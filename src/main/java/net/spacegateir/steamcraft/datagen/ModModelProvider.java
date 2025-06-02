package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.DyeColor;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FOOLS_GOLD_BLOCK);

        for (DyeColor color : DyeColor.values()) {
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLOR_TO_COBBLED_CONCRETE.get(color));
            blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLOR_TO_COBBLED_CONCRETE_POWDER.get(color));
        }

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_TILES_CRACKED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_BRICKS_CRACKED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_TILES_CRACKED);

        // Normal Flowers
        ModBlocks.FLOWER_TO_POTTED_FLOWER.forEach((flower, pottedFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(flower, pottedFlower, BlockStateModelGenerator.TintType.NOT_TINTED));
        ModBlocks.FLOWER_TO_GLOW_FLOWER.forEach((flower, glowFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(glowFlower, ModBlocks.FLOWER_TO_POTTED_GLOW_FLOWER.get(flower), BlockStateModelGenerator.TintType.NOT_TINTED));

        // Thorned Flowers
        ModBlocks.FLOWER_TO_THORNED_FLOWER.forEach((flower, thornedFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(thornedFlower, ModBlocks.FLOWER_TO_POTTED_THORNED_FLOWER.get(flower), BlockStateModelGenerator.TintType.NOT_TINTED));
        ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.forEach((flower, glowThornedFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(glowThornedFlower, ModBlocks.FLOWER_TO_POTTED_GLOW_THORNED_FLOWER.get(flower), BlockStateModelGenerator.TintType.NOT_TINTED));

        // Lush Flowers
        ModBlocks.FLOWER_TO_LUSH_FLOWER.forEach((flower, lushFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(lushFlower, ModBlocks.FLOWER_TO_POTTED_LUSH_FLOWER.get(flower), BlockStateModelGenerator.TintType.NOT_TINTED));
        ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.forEach((flower, glowLushFlower) ->
                blockStateModelGenerator.registerFlowerPotPlant(glowLushFlower, ModBlocks.FLOWER_TO_POTTED_GLOW_LUSH_FLOWER.get(flower), BlockStateModelGenerator.TintType.NOT_TINTED));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.TROWEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRAP_CONCEALER, Models.GENERATED);


        ModItems.COLOR_TO_WATER_BUCKET.values().forEach(waterBucket ->
                itemModelGenerator.register(waterBucket, Models.GENERATED));

        ModItems.COLOR_TO_LAVA_BUCKET.values().forEach(lavaBucket ->
                itemModelGenerator.register(lavaBucket, Models.GENERATED));


        itemModelGenerator.register(ModItems.BLANK_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HELMET_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHESTPLATE_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEGGINGS_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOTS_MOULD, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_4, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.FOOLS_GOLD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FOOLS_GOLD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FOOLS_GOLD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FOOLS_GOLD_BOOTS);

        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.WINGED_SANDALS, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.LOOT_CHEST, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.AMETHYST_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.AMETHYST_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.AMETHYST_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.AMETHYST_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.AMETHYST_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.WOLF_FURY_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.ADAMANTITE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_BOOTS));

        itemModelGenerator.register(ModRewardItems.AER_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_BOOTS));

        itemModelGenerator.register(ModRewardItems.AQUA_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_BOOTS));

        itemModelGenerator.register(ModRewardItems.DRAGON_BANE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_BOOTS));

        itemModelGenerator.register(ModRewardItems.DWARF_STEEL_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_BOOTS));

        itemModelGenerator.register(ModRewardItems.IGNIS_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_BOOTS));

        itemModelGenerator.register(ModRewardItems.MAGIRITE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_BOOTS));

        itemModelGenerator.register(ModRewardItems.MYTHRIL_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_BOOTS));

        itemModelGenerator.register(ModRewardItems.ORIKALKUM_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_BOOTS));

        itemModelGenerator.register(ModRewardItems.TERA_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_BOOTS));







    }
}