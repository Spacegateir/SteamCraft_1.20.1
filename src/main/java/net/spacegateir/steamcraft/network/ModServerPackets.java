package net.spacegateir.steamcraft.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.tools.IToolWithBuffAndMode;

public class ModServerPackets {

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

                // If holding CelestialGearforgedAxeItem, show buff or cooldown message
                if (mainHandStack.getItem() == ModItems.CELESTIAL_GEARFORGED_AXE) {
                    long cooldownEnd = mainHandStack.getOrCreateNbt().getLong("CelestialBuffCooldown");
                    long currentTime = player.getWorld().getTime();

                    long secondsLeft = (cooldownEnd - currentTime) / 20;
                    if (secondsLeft < 0) secondsLeft = 0;

                    player.sendMessage(Text.literal("§bAxe Buff active! §cBuff on cooldown: " + secondsLeft + "s remaining"), true);
                }

                // If holding CelestialGearforgedHoeItem, show buff or cooldown message
                if (mainHandStack.getItem() == ModItems.CELESTIAL_GEARFORGED_HOE) {
                    long cooldownEnd = mainHandStack.getOrCreateNbt().getLong("CelestialBuffCooldown");
                    long currentTime = player.getWorld().getTime();

                    long secondsLeft = (cooldownEnd - currentTime) / 20;
                    if (secondsLeft < 0) secondsLeft = 0;

                    player.sendMessage(Text.literal("§bHoe Buff active! §cBuff on cooldown: " + secondsLeft + "s remaining"), true);
                }

                // If holding CelestialGearforgedShovelItem, show buff or cooldown message
                if (mainHandStack.getItem() == ModItems.CELESTIAL_GEARFORGED_SHOVEL) {
                    long cooldownEnd = mainHandStack.getOrCreateNbt().getLong("CelestialBuffCooldown");
                    long currentTime = player.getWorld().getTime();

                    long secondsLeft = (cooldownEnd - currentTime) / 20;
                    if (secondsLeft < 0) secondsLeft = 0;

                    player.sendMessage(Text.literal("§bShovel Buff active! §cBuff on cooldown: " + secondsLeft + "s remaining"), true);
                }

                // If holding CelestialGearforgedShearsItem, show buff or cooldown message
                if (mainHandStack.getItem() == ModItems.CELESTIAL_GEARFORGED_SHEARS) {
                    long cooldownEnd = mainHandStack.getOrCreateNbt().getLong("CelestialBuffCooldown");
                    long currentTime = player.getWorld().getTime();

                    long secondsLeft = (cooldownEnd - currentTime) / 20;
                    if (secondsLeft < 0) secondsLeft = 0;

                    player.sendMessage(Text.literal("§bShears Buff active! §cBuff on cooldown: " + secondsLeft + "s remaining"), true);
                }

                // If holding CelestialGearforgedPickaxeItem, show buff or cooldown message
                if (mainHandStack.getItem() == ModItems.CELESTIAL_GEARFORGED_PICKAXE) {
                    long cooldownEnd = mainHandStack.getOrCreateNbt().getLong("CelestialBuffCooldown");
                    long currentTime = player.getWorld().getTime();

                    long secondsLeft = (cooldownEnd - currentTime) / 20;
                    if (secondsLeft < 0) secondsLeft = 0;

                    player.sendMessage(Text.literal("§bPickaxe Buff active! §cBuff on cooldown: " + secondsLeft + "s remaining"), true);
                }



                // else {
                //     Optional: message for not holding the axe
                //     player.sendMessage(Text.literal("§cYou must hold the Celestial Shield to activate the buff."), true);
                // }
            });
        });
    }
}
