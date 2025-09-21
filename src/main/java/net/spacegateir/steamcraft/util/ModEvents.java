package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.spacegateir.steamcraft.item.trinkets.item.BraceletTrinketItem;

public class ModEvents {

    public static void register() {

        ServerTickEvents.END_SERVER_TICK.register(ModEvents::onServerTick);
    }

    private static void onServerTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            BraceletTrinketItem.onPlayerTick(player, player.getWorld());
        }
    }
}
