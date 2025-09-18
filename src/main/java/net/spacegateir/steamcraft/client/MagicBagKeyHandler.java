package net.spacegateir.steamcraft.client;

import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.TrinketComponent;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.item.trinkets.item.MagicBagItem;

public class MagicBagKeyHandler {

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(MagicBagKeyHandler::handleMagicBagKey);
    }

    private static void handleMagicBagKey(MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        if (player == null || client.currentScreen != null) return;

        while (Keybinds.MAGIC_BAG_KEY.wasPressed()) {
            TrinketComponent trinkets = TrinketsApi.getTrinketComponent(player).orElse(null);
            if (trinkets == null) return;

            trinkets.getAllEquipped().forEach(pair -> {
                ItemStack stack = pair.getRight();
                if (!stack.isEmpty() && stack.getItem() instanceof MagicBagItem) {
                    MagicBagItem.sendOpenPacket(player);
                }
            });
        }
    }

}
