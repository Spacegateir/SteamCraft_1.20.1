package net.spacegateir.steamcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.item.armor.WingedSandalsCosmeticItem;

public class SteamcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                ItemStack boots = client.player.getInventory().getArmorStack(0);
                if (boots.getItem() instanceof WingedSandalsCosmeticItem) {
                    ((WingedSandalsCosmeticItem) boots.getItem()).handleMovement(client.player);
                }
            }
        });
    }
}