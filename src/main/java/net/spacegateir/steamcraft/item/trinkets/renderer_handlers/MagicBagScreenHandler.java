package net.spacegateir.steamcraft.item.trinkets.renderer_handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.spacegateir.steamcraft.inventory.MagicBagInventory;
import net.spacegateir.steamcraft.inventory.MagicBagPersistentState;
import net.spacegateir.steamcraft.sound.ModSounds;

import java.util.UUID;

public class MagicBagScreenHandler extends GenericContainerScreenHandler {

    private final ItemStack stack;
    private final MagicBagInventory bagInventory;

    public MagicBagScreenHandler(int syncId, PlayerInventory playerInventory, MagicBagInventory inventory, ItemStack stack) {
        super(ScreenHandlerType.GENERIC_9X6, syncId, playerInventory, inventory, 6);
        this.stack = stack;
        this.bagInventory = inventory;
    }

    public MagicBagInventory getBagInventory() {
        return bagInventory;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);

        if (stack != null) {
            stack.getOrCreateNbt().putBoolean("Open", false);
        }

        if (!player.getWorld().isClient() && player instanceof ServerPlayerEntity serverPlayer) {
            ServerWorld world = serverPlayer.getServerWorld();
            MagicBagPersistentState state = world.getPersistentStateManager().getOrCreate(
                    MagicBagPersistentState::fromNbt,
                    MagicBagPersistentState::new,
                    "magic_bags"
            );
            UUID uuid = player.getUuid();
            state.setInventory(uuid, bagInventory.toNbtList());


            world.playSound(
                    null,
                    player.getBlockPos(),
                    ModSounds.ZIPPER_FAST,
                    SoundCategory.PLAYERS,
                    1.0f,
                    5.0f
            );
        }
    }
}
