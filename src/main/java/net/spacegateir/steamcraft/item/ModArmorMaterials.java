package net.spacegateir.steamcraft.item;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.spacegateir.steamcraft.Steamcraft;

public enum ModArmorMaterials implements ArmorMaterial {

    UNBREAKING("unbreaking", -1, new int[] {0, 0, 0, 0}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.LEATHER)),

    FOOLS_GOLD("fools_gold", 133, new int[] {3, 8, 6, 3}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.FOOLS_GOLD_INGOT)),

    CELESTIAL_GEARFORGED("celestial_gearforged", -1, new int[] {8, 18, 14, 8}, 1000,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 8.0F, 1.0F, () -> Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT)),

    AMETHYST("amethyst", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.AMETHYST_SHARD)),

    WOLF("wolf", 37, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ENTITY_WOLF_HOWL, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    DWARF_STEEL("dwarf_steel", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    AER("aer", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    AQUA("aqua", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    TERA("tera", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    IGNIS("ignis", 15, new int[] {2, 6, 5, 2}, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),

    MAGIRITE("magirite", 33, new int[] {3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),

    MYTHRIL("mythril", 33, new int[] {3, 8, 6, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),

    ADAMANTITE("adamantite", 37, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    ORIKALKUM("orikalkum", 37, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),

    DRAGON_BANE("dragon_bane", 37, new int[] {3, 8, 6, 3}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts,
                              int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = Suppliers.memoize(repairIngredientSupplier);
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return Steamcraft.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}