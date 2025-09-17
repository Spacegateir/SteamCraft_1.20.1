package net.spacegateir.steamcraft.item.trinkets.item;

import dev.emi.trinkets.api.TrinketItem;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.inventory.MagicBagInventory;
import net.spacegateir.steamcraft.inventory.MagicBagPersistentState;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.MagicBagScreenHandler;
import net.spacegateir.steamcraft.sound.ModSounds;

import java.util.UUID;

public class MagicBagItem extends TrinketItem {

    private static final Text TITLE = Text.translatable("container.magic_bag");
    public static final Identifier OPEN_PACKET_ID = new Identifier("steamcraft", "open_magic_bag");

    public MagicBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient && player.isSneaking()) {
            openBag((ServerPlayerEntity) player);
            stack.getOrCreateNbt().putBoolean("Open", true);
            return TypedActionResult.success(stack);
        }

        return TypedActionResult.pass(stack);
    }

    public static void sendOpenPacket(ClientPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ClientPlayNetworking.send(OPEN_PACKET_ID, buf);
    }

    public static void openBag(ServerPlayerEntity player) {
        ServerWorld world = (ServerWorld) player.getWorld();

        MagicBagPersistentState state = world.getPersistentStateManager().getOrCreate(
                MagicBagPersistentState::fromNbt,
                MagicBagPersistentState::new,
                "magic_bags"
        );

        UUID uuid = player.getUuid();
        MagicBagInventory bagInventory = new MagicBagInventory();
        bagInventory.readNbtList(state.getInventory(uuid));

        ItemStack stack = player.getMainHandStack();

        world.playSound(
                null,
                player.getBlockPos(),
                ModSounds.ZIPPER,
                SoundCategory.PLAYERS,
                1.0f,
                -20.0f
        );

        player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, playerInventory, p) ->
                new MagicBagScreenHandler(syncId, playerInventory, bagInventory, stack),
                TITLE
        ));

        bagInventory.addListener(inv -> state.setInventory(uuid, bagInventory.toNbtList()));
    }
}
