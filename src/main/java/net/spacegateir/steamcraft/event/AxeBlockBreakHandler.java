package net.spacegateir.steamcraft.event;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.spacegateir.steamcraft.item.tools.CelestialGearforgedAxeItem;

import java.util.HashSet;
import java.util.Set;

public class AxeBlockBreakHandler {

    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack held = player.getMainHandStack();

            if (!(held.getItem() instanceof CelestialGearforgedAxeItem)) return true;

            CelestialGearforgedAxeItem axe = (CelestialGearforgedAxeItem) held.getItem();

            if (!axe.isLog(state)) return true;
            if (!world.isClient) {
                world.breakBlock(pos, true, player);

                switch (axe.getLumberMode(held)) {
                    case PILLAR:
                        axe.breakPillar(world, pos.up(), player);
                        break;
                    case LUMBER_JACK:
                        Set<BlockPos> visited = new HashSet<>();
                        axe.breakTree(world, pos.up(), player, visited);
                        break;
                    default:
                        break;
                }
            }

            return false;
        });
    }
}
