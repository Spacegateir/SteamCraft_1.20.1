package net.spacegateir.steamcraft.item.trinkets.item;

import dev.emi.trinkets.api.TrinketItem;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.inventory.MagicBagInventory;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.HasMagicBag;
import net.spacegateir.steamcraft.sound.ModSounds;

public class MagicBagItem extends TrinketItem {

    private static final Text CONTAINER_NAME = Text.translatable("container.magic_bag");
    public static final Identifier OPEN_PACKET_ID = new Identifier("steamcraft", "open_magic_bag");

    public MagicBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            MagicBagInventory bagInventory = ((HasMagicBag) user).getMagicBagInventory();
            user.openHandledScreen(createScreenHandlerFactory(bagInventory));
            stack.getOrCreateNbt().putBoolean("Open", true);

            world.playSound(
                    null,
                    user.getBlockPos(),
                    ModSounds.ZIPPER,
                    SoundCategory.PLAYERS,
                    1.0f,
                    -5.0f
            );

            return TypedActionResult.success(stack);
        }

        return TypedActionResult.success(stack, world.isClient);
    }


    public static void sendOpenPacket(ClientPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(OPEN_PACKET_ID, buf);
    }

    private static NamedScreenHandlerFactory createScreenHandlerFactory(Inventory inventory) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, player) -> {
                    GenericContainerScreenHandler handler = GenericContainerScreenHandler.createGeneric9x6(syncId, playerInventory, inventory);

                    return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X6, syncId, playerInventory, inventory, 6) {
                        @Override
                        public void onClosed(PlayerEntity player) {
                            super.onClosed(player);
                            if (!player.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
                                MagicBagItem.closeBag(serverPlayer);
                            }
                        }
                    };
                },
                CONTAINER_NAME
        );
    }

    public static void openBag(ServerPlayerEntity player) {
        ServerWorld world = (ServerWorld) player.getWorld();
        MagicBagInventory bagInventory = ((HasMagicBag) player).getMagicBagInventory();
        player.openHandledScreen(createScreenHandlerFactory(bagInventory));

        world.playSound(
                null,
                player.getBlockPos(),
                ModSounds.ZIPPER,
                SoundCategory.PLAYERS,
                1.0f,
                -20.0f
        );
    }

    public static void closeBag(ServerPlayerEntity player) {
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
        if (stack != null) {
            stack.getOrCreateNbt().putBoolean("Open", false);
        }

        ServerWorld world = (ServerWorld) player.getWorld();

        world.playSound(
                null,
                player.getBlockPos(),
                ModSounds.ZIPPER_SLOW,
                SoundCategory.PLAYERS,
                1.0f,
                5.0f
        );
    }
}
