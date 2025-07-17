package net.spacegateir.steamcraft.item.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.ModArmorMaterials;

import java.util.List;
import java.util.Map;

public class FoolsGoldArmourItem extends ArmorItem {
    private static final int[] WARNING_THRESHOLDS = {75, 50, 25, 20, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.FOOLS_GOLD, new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1))
                    .build();

    public FoolsGoldArmourItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Fool's Gold Armour§r"));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §dGreatness cracks before it shines, and from ruin, power is born.§7"));
            tooltip.add(Text.literal("   §8• Gather the golden shards as your armour fractures."));
            tooltip.add(Text.literal("   §8• Fragments of the weak forge tools of the mighty."));
            tooltip.add(Text.literal("   §8• Craft divine weapons and unlock secrets unknown."));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for more information."));
        }
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int maxDamage = stack.getMaxDamage();
            int currentDamage = stack.getDamage();
            int remainingDurability = maxDamage - currentDamage;
            int percent = (int) ((remainingDurability / (float) maxDamage) * 100);

            for (int threshold : WARNING_THRESHOLDS) {
                String key = "warned_" + threshold;
                if (percent <= threshold && !nbt.getBoolean(key)) {
                    nbt.putBoolean(key, true);

                    Text warning = Text.literal("⚠ Your Armor is at " + percent + "% — repair it before it breaks. ⚠");
                    player.sendMessage(warning, true); // popup
                    player.sendMessage(warning);       // chat
                }
            }

            // Reset warnings if durability is restored
            if (percent > 75) {
                for (int threshold : WARNING_THRESHOLDS) {
                    nbt.remove("warned_" + threshold);
                }
            }

            // Apply effects if full set is worn
            evaluateArmorEffect(player);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasFullSuitOfArmorOn(player) && hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffectAlready = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (!hasPlayerEffectAlready) {
            player.addStatusEffect(new StatusEffectInstance(
                    mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(),
                    mapStatusEffect.getAmplifier()));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getArmorItems()) {
            if (!(armorStack.getItem() instanceof ArmorItem armorItem) || armorItem.getMaterial() != material) {
                return false;
            }
        }
        return true;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        return !player.getInventory().getArmorStack(0).isEmpty() &&
                !player.getInventory().getArmorStack(1).isEmpty() &&
                !player.getInventory().getArmorStack(2).isEmpty() &&
                !player.getInventory().getArmorStack(3).isEmpty();
    }
}
