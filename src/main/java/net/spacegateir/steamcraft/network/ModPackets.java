package net.spacegateir.steamcraft.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.item.tools.IToolWithBuffAndMode;

public class ModPackets {

    public static final Identifier ACTIVATE_BUFF_PACKET_ID = new Identifier("steamcraft", "activate_buff");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(ACTIVATE_BUFF_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                ItemStack mainHand = player.getMainHandStack();
                if (!mainHand.isEmpty()) {
                    var item = mainHand.getItem();
                    String className = item.getClass().getSimpleName();

                    if (className.contains("CelestialGearforged") && item instanceof IToolWithBuffAndMode tool) {
                        tool.applyBuffAbility(player);
                    }
                }
            });
        });
    }

}