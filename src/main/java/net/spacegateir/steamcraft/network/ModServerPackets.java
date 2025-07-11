package net.spacegateir.steamcraft.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.item.tools.IToolWithBuffAndMode;

public class ModServerPackets {

    // Packet identifier for buff activation
//    public static final Identifier BUFF_ACTIVATION_PACKET_ID = new Identifier("steamcraft", "buff_activation"); // means nothing

    // Call this method during your server initialization
    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.ACTIVATE_BUFF_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                ItemStack mainHandStack = player.getMainHandStack();
                ItemStack offHandStack = player.getOffHandStack();

                // Try main hand first
                if (mainHandStack.getItem() instanceof IToolWithBuffAndMode mainHandTool) {
                    if (mainHandTool.canActivateBuff(player)) {
                        mainHandTool.applyBuffAbility(player);
                        return;
                    }
                }

                // Try offhand next
                if (offHandStack.getItem() instanceof IToolWithBuffAndMode offHandTool) {
                    if (offHandTool.canActivateBuff(player)) {
                        offHandTool.applyBuffAbility(player);
                        return;
                    }
                }

                // Optional: notify player no shield found or cooldown active
//                player.sendMessage(Text.literal("§cYou must hold the Celestial Shield to activate the buff.2"), true); //on cooldown
            });
        });

    }
}
