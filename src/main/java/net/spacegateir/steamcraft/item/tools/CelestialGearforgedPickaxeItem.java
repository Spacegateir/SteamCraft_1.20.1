package net.spacegateir.steamcraft.item.tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.spacegateir.steamcraft.util.ModTags;

public class CelestialGearforgedPickaxeItem extends PickaxeItem {

    public CelestialGearforgedPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        int efficiencyLevel = EnchantmentHelper.getLevel(Enchantments.EFFICIENCY, stack);

        float bonus = efficiencyLevel > 0 ? (float)(Math.pow(efficiencyLevel, 2) + 1) : 0;

        float baseSpeed;
        if (state.isOf(Blocks.DEEPSLATE) || state.isOf(Blocks.COBBLED_DEEPSLATE)) {
            baseSpeed = 40.0F;
        } else if (state.isIn(ModTags.Blocks.PICKAXE_EFFICIENT)) {
            baseSpeed = 24.0F;
        } else {
            baseSpeed = 12.0F;
        }

        return baseSpeed + bonus;
    }


}
