package net.spacegateir.steamcraft.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolTipItem extends Item {
    public ToolTipItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        String baseKey = "tooltip.steamcraft.";
        String itemKey = "";

        if (stack.isOf(ModItems.FERRITE_HEARTSTONE)) {
            itemKey = "ferrite_heartstone";
        } else if (stack.isOf(ModItems.AETHERIUM_PRISM)) {
            itemKey = "aetherium_prism";
        } else if (stack.isOf(ModItems.AQUARION_SHARD)) {
            itemKey = "aquarion_shard";
        } else if (stack.isOf(ModItems.PYROCITE_CORE)) {
            itemKey = "pyrocite_core";
        } else if (stack.isOf(ModItems.LUMINITE_SPARK)) {
            itemKey = "luminite_spark";
        } else if (stack.isOf(ModItems.OBSCURIUM_CRYSTAL)) {
            itemKey = "obscurium_crystal";
        }

        if (!itemKey.isEmpty()) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable(baseKey + itemKey + ".tooltip.shift"));
            } else {
                tooltip.add(Text.translatable(baseKey + itemKey + ".tooltip"));
            }
        }
    }
}
