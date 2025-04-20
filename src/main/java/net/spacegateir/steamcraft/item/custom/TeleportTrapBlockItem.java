package net.spacegateir.steamcraft.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleportTrapBlockItem extends BlockItem {
    public TeleportTrapBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.steamcraft.teleport_trap.tooltip.shift_1"));
            tooltip.add(Text.translatable("tooltip.steamcraft.teleport_trap.tooltip.shift_2"));
            tooltip.add(Text.translatable("tooltip.steamcraft.teleport_trap.tooltip.shift_3"));
            tooltip.add(Text.translatable("tooltip.steamcraft.teleport_trap.tooltip.shift_4"));
        } else {
            tooltip.add(Text.translatable("tooltip.steamcraft.teleport_trap.tooltip"));
        }
    }
}
