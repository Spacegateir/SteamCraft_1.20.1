package net.spacegateir.steamcraft.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SmokeBlockItem extends BlockItem {
    public SmokeBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§eSmoke Block§r may be invisible but to generate smoke its pretty cool!"));
            tooltip.add(Text.literal("§eRight Click§r on the §eSmoke Block§r to change between 3 modes "));
            tooltip.add(Text.literal("If §eSmoke Block§r is on Hay Block double the height if on Packed Ice half the height "));
        } else {
            tooltip.add(Text.literal("Press §eSHIFT§r for more Information"));
        }
    }
}
