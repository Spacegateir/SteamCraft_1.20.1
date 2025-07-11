package net.spacegateir.steamcraft.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.spacegateir.steamcraft.item.tools.CelestialGearforgedAxeItem;

import java.util.HashSet;
import java.util.Set;

public class AxeBlockStripHandler {

    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack held = player.getMainHandStack();

            if (!(held.getItem() instanceof CelestialGearforgedAxeItem)) return true;

            CelestialGearforgedAxeItem axe = (CelestialGearforgedAxeItem) held.getItem();

            if (!axe.isLog(state)) return true;

            if (!world.isClient) {
                switch (axe.getLumberMode(held)) {
                    case PILLAR:
                        // Strip all logs from the current block upwards
                        axe.stripPillar(world, pos, player);
                        break;
                    case LUMBER_JACK:
                        Set<BlockPos> visited = new HashSet<>();
                        // Strip all connected logs of the tree starting at current block
                        axe.stripTree(world, pos, player, visited);
                        break;
                    default:
                        // For NORMAL mode, just strip the single log block
                        axe.stripLog(world, pos, player);
                        break;
                }
            }

            return false;
        });
    }
}
