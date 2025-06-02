package net.spacegateir.steamcraft.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
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

public class FoolsGoldArmourItem extends ArmorItem {
    private static final int[] WARNING_THRESHOLDS = {75, 50, 25, 20, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public FoolsGoldArmourItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int maxDamage = stack.getMaxDamage();
            int currentDamage = stack.getDamage();
            int remainingDurability = maxDamage - currentDamage;
            int percent = (int) ((remainingDurability / (float) maxDamage) * 100);

            // TODO: use a single "warned" int value
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
            if (player.getInventory().armor.stream()
                    .allMatch(itemStack -> itemStack.getItem() instanceof ArmorItem armorItem &&
                            armorItem.getMaterial() == ModArmorMaterials.FOOLS_GOLD)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
