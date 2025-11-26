package net.spacegateir.steamcraft.item.tools;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class BedrockBreakerPickaxeItem extends PickaxeItem {

    public BedrockBreakerPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§8Breaks Bedrock"));
        tooltip.add(Text.literal("§8Breaks Dungeon Walls"));
        tooltip.add(Text.literal("§8Breaks Mineral Deposits"));

    }
}