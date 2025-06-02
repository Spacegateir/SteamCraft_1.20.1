package net.spacegateir.steamcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.armor.*;
import net.spacegateir.steamcraft.item.custom.*;

import java.util.EnumMap;

public class ModItems {

    public static final EnumMap<DyeColor, Item> COLOR_TO_WATER_BUCKET = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Item> COLOR_TO_LAVA_BUCKET = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, Item> COLOR_TO_DYE = Util.make(new EnumMap<>(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, Items.WHITE_DYE);
        map.put(DyeColor.ORANGE, Items.ORANGE_DYE);
        map.put(DyeColor.MAGENTA, Items.MAGENTA_DYE);
        map.put(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE);
        map.put(DyeColor.YELLOW, Items.YELLOW_DYE);
        map.put(DyeColor.LIME, Items.LIME_DYE);
        map.put(DyeColor.PINK, Items.PINK_DYE);
        map.put(DyeColor.GRAY, Items.GRAY_DYE);
        map.put(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE);
        map.put(DyeColor.CYAN, Items.CYAN_DYE);
        map.put(DyeColor.PURPLE, Items.PURPLE_DYE);
        map.put(DyeColor.BLUE, Items.BLUE_DYE);
        map.put(DyeColor.BROWN, Items.BROWN_DYE);
        map.put(DyeColor.GREEN, Items.GREEN_DYE);
        map.put(DyeColor.RED, Items.RED_DYE);
        map.put(DyeColor.BLACK, Items.BLACK_DYE);
    });

    public static final Item TEST_ITEM = registerItem("test_item",
            new Item(new FabricItemSettings()));

    public static final Item COPPER_COIN = registerItem("copper_coin",
            new GlintItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item SILVER_COIN = registerItem("silver_coin",
            new GlintItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item GOLD_COIN = registerItem("gold_coin",
            new GlintItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    public static final Item FOOLS_GOLD_SCRAP = registerItem("fools_gold_scrap",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item FOOLS_GOLD_RAW = registerItem("fools_gold_raw",
            new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item FOOLS_GOLD_INGOT = registerItem("fools_gold_ingot",
            new Item(new FabricItemSettings()));
    public static final Item DIVINITITE_ALLOY_INGOT = registerItem("divinitite_alloy_ingot",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item PATTERN_RECOMPILER = registerItem("pattern_recompiler",
            new SwapItem(new FabricItemSettings()));
    public static final Item TRAP_CONCEALER = registerItem("trap_concealer",
            new TrapConcealerItem(new FabricItemSettings()));
    public static final Item TROWEL = registerItem("trowel",
            new TrowelItem(new FabricItemSettings().maxDamage(500)));
    public static final Item CORE_OF_CHANGING = registerItem("core_of_changing",
            new Item(new FabricItemSettings()));


    public static final Item BLANK_MOULD = registerItem("blank_mould",
            new Item(new FabricItemSettings()));
    public static final Item HELMET_MOULD = registerItem("helmet_mould",
            new Item(new FabricItemSettings()));
    public static final Item CHESTPLATE_MOULD = registerItem("chestplate_mould",
            new Item(new FabricItemSettings()));
    public static final Item LEGGINGS_MOULD = registerItem("leggings_mould",
            new Item(new FabricItemSettings()));
    public static final Item BOOTS_MOULD = registerItem("boots_mould",
            new Item(new FabricItemSettings()));

    public static final Item FERRITE_HEARTSTONE = registerItem("ferrite_heartstone",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));
    public static final Item AETHERIUM_PRISM = registerItem("aetherium_prism",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));
    public static final Item AQUARION_SHARD = registerItem("aquarion_shard",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));
    public static final Item PYROCITE_CORE = registerItem("pyrocite_core",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));
    public static final Item LUMINITE_SPARK = registerItem("luminite_spark",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));
    public static final Item OBSCURIUM_CRYSTAL = registerItem("obscurium_crystal",
            new ToolTipItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));

    public static final Item FOOLS_GOLD_HELMET_1 = registerItem("fools_gold_helmet_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_HELMET_2 = registerItem("fools_gold_helmet_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_HELMET_3 = registerItem("fools_gold_helmet_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_HELMET_4 = registerItem("fools_gold_helmet_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_CHESTPLATE_1 = registerItem("fools_gold_chestplate_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_CHESTPLATE_2 = registerItem("fools_gold_chestplate_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_CHESTPLATE_3 = registerItem("fools_gold_chestplate_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_CHESTPLATE_4 = registerItem("fools_gold_chestplate_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_LEGGINGS_1 = registerItem("fools_gold_leggings_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_LEGGINGS_2 = registerItem("fools_gold_leggings_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_LEGGINGS_3 = registerItem("fools_gold_leggings_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_LEGGINGS_4 = registerItem("fools_gold_leggings_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_BOOTS_1 = registerItem("fools_gold_boots_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_BOOTS_2 = registerItem("fools_gold_boots_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_BOOTS_3 = registerItem("fools_gold_boots_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item FOOLS_GOLD_BOOTS_4 = registerItem("fools_gold_boots_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static final Item FOOLS_GOLD_HELMET = registerItem("fools_gold_helmet",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item FOOLS_GOLD_CHESTPLATE = registerItem("fools_gold_chestplate",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item FOOLS_GOLD_LEGGINGS = registerItem("fools_gold_leggings",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item FOOLS_GOLD_BOOTS = registerItem("fools_gold_boots",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    public static final Item CELESTIAL_GEARFORGED_HELMET = registerItem("celestial_gearforged_helmet",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item CELESTIAL_GEARFORGED_CHESTPLATE = registerItem("celestial_gearforged_chestplate",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item CELESTIAL_GEARFORGED_LEGGINGS = registerItem("celestial_gearforged_leggings",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item CELESTIAL_GEARFORGED_BOOTS = registerItem("celestial_gearforged_boots",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    public static final Item WINGED_SANDALS = registerItem("winged_sandals",
            new WingedSandalsCosmeticItem(ModArmorMaterials.UNBREAKING, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TEST_ITEM_BLOCK = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "test_item_block"),
            new BlockItem(ModBlocks.TEST_BLOCK_ITEM, new FabricItemSettings()));

// Normal Flowers
    public static final Item AGAPANTHUS = registerBlockItem(ModBlocks.AGAPANTHUS);
    public static final Item GLOW_AGAPANTHUS = registerBlockItem(ModBlocks.GLOW_AGAPANTHUS);

    public static final Item BLUE_COSMOS = registerBlockItem(ModBlocks.BLUE_COSMOS);
    public static final Item GLOW_BLUE_COSMOS = registerBlockItem(ModBlocks.GLOW_BLUE_COSMOS);

    public static final Item BONSAI = registerBlockItem(ModBlocks.BONSAI);
    public static final Item GLOW_BONSAI = registerBlockItem(ModBlocks.GLOW_BONSAI);

    public static final Item CARNATION = registerBlockItem(ModBlocks.CARNATION);
    public static final Item GLOW_CARNATION = registerBlockItem(ModBlocks.GLOW_CARNATION);

    public static final Item DAFFODIL = registerBlockItem(ModBlocks.DAFFODIL);
    public static final Item GLOW_DAFFODIL = registerBlockItem(ModBlocks.GLOW_DAFFODIL);

    public static final Item DAHLIA = registerBlockItem(ModBlocks.DAHLIA);
    public static final Item GLOW_DAHLIA = registerBlockItem(ModBlocks.GLOW_DAHLIA);

    public static final Item DELPHINIUM = registerBlockItem(ModBlocks.DELPHINIUM);
    public static final Item GLOW_DELPHINIUM = registerBlockItem(ModBlocks.GLOW_DELPHINIUM);

    public static final Item HAWTHORN = registerBlockItem(ModBlocks.HAWTHORN);
    public static final Item GLOW_HAWTHORN = registerBlockItem(ModBlocks.GLOW_HAWTHORN);

    public static final Item HYDRANGEA = registerBlockItem(ModBlocks.HYDRANGEA);
    public static final Item GLOW_HYDRANGEA = registerBlockItem(ModBlocks.GLOW_HYDRANGEA);

    public static final Item IRIS = registerBlockItem(ModBlocks.IRIS);
    public static final Item GLOW_IRIS = registerBlockItem(ModBlocks.GLOW_IRIS);

    public static final Item LARKSPUR = registerBlockItem(ModBlocks.LARKSPUR);
    public static final Item GLOW_LARKSPUR = registerBlockItem(ModBlocks.GLOW_LARKSPUR);

    public static final Item MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.MIDNIGHT_MYSTIC);
    public static final Item GLOW_MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.GLOW_MIDNIGHT_MYSTIC);

    public static final Item PRIMROSE = registerBlockItem(ModBlocks.PRIMROSE);
    public static final Item GLOW_PRIMROSE = registerBlockItem(ModBlocks.GLOW_PRIMROSE);

    public static final Item SNOW_DROP = registerBlockItem(ModBlocks.SNOW_DROP);
    public static final Item GLOW_SNOW_DROP = registerBlockItem(ModBlocks.GLOW_SNOW_DROP);

    public static final Item SPIDERLILY = registerBlockItem(ModBlocks.SPIDERLILY);
    public static final Item GLOW_SPIDERLILY = registerBlockItem(ModBlocks.GLOW_SPIDERLILY);

    public static final Item VIOLET = registerBlockItem(ModBlocks.VIOLET);
    public static final Item GLOW_VIOLET = registerBlockItem(ModBlocks.GLOW_VIOLET);

// Thorned Flowers
    public static final Item THORNED_AGAPANTHUS = registerBlockItem(ModBlocks.THORNED_AGAPANTHUS);
    public static final Item GLOW_THORNED_AGAPANTHUS = registerBlockItem(ModBlocks.GLOW_THORNED_AGAPANTHUS);

    public static final Item THORNED_BLUE_COSMOS = registerBlockItem(ModBlocks.THORNED_BLUE_COSMOS);
    public static final Item GLOW_THORNED_BLUE_COSMOS = registerBlockItem(ModBlocks.GLOW_THORNED_BLUE_COSMOS);

    public static final Item THORNED_BONSAI = registerBlockItem(ModBlocks.THORNED_BONSAI);
    public static final Item GLOW_THORNED_BONSAI = registerBlockItem(ModBlocks.GLOW_THORNED_BONSAI);

    public static final Item THORNED_CARNATION = registerBlockItem(ModBlocks.THORNED_CARNATION);
    public static final Item GLOW_THORNED_CARNATION = registerBlockItem(ModBlocks.GLOW_THORNED_CARNATION);

    public static final Item THORNED_DAFFODIL = registerBlockItem(ModBlocks.THORNED_DAFFODIL);
    public static final Item GLOW_THORNED_DAFFODIL = registerBlockItem(ModBlocks.GLOW_THORNED_DAFFODIL);

    public static final Item THORNED_DAHLIA = registerBlockItem(ModBlocks.THORNED_DAHLIA);
    public static final Item GLOW_THORNED_DAHLIA = registerBlockItem(ModBlocks.GLOW_THORNED_DAHLIA);

    public static final Item THORNED_DELPHINIUM = registerBlockItem(ModBlocks.THORNED_DELPHINIUM);
    public static final Item GLOW_THORNED_DELPHINIUM = registerBlockItem(ModBlocks.GLOW_THORNED_DELPHINIUM);

    public static final Item THORNED_HAWTHORN = registerBlockItem(ModBlocks.THORNED_HAWTHORN);
    public static final Item GLOW_THORNED_HAWTHORN = registerBlockItem(ModBlocks.GLOW_THORNED_HAWTHORN);

    public static final Item THORNED_HYDRANGEA = registerBlockItem(ModBlocks.THORNED_HYDRANGEA);
    public static final Item GLOW_THORNED_HYDRANGEA = registerBlockItem(ModBlocks.GLOW_THORNED_HYDRANGEA);

    public static final Item THORNED_IRIS = registerBlockItem(ModBlocks.THORNED_IRIS);
    public static final Item GLOW_THORNED_IRIS = registerBlockItem(ModBlocks.GLOW_THORNED_IRIS);

    public static final Item THORNED_LARKSPUR = registerBlockItem(ModBlocks.THORNED_LARKSPUR);
    public static final Item GLOW_THORNED_LARKSPUR = registerBlockItem(ModBlocks.GLOW_THORNED_LARKSPUR);

    public static final Item THORNED_MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.THORNED_MIDNIGHT_MYSTIC);
    public static final Item GLOW_THORNED_MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC);

    public static final Item THORNED_PRIMROSE = registerBlockItem(ModBlocks.THORNED_PRIMROSE);
    public static final Item GLOW_THORNED_PRIMROSE = registerBlockItem(ModBlocks.GLOW_THORNED_PRIMROSE);

    public static final Item THORNED_SNOW_DROP = registerBlockItem(ModBlocks.THORNED_SNOW_DROP);
    public static final Item GLOW_THORNED_SNOW_DROP = registerBlockItem(ModBlocks.GLOW_THORNED_SNOW_DROP);

    public static final Item THORNED_SPIDERLILY = registerBlockItem(ModBlocks.THORNED_SPIDERLILY);
    public static final Item GLOW_THORNED_SPIDERLILY = registerBlockItem(ModBlocks.GLOW_THORNED_SPIDERLILY);

    public static final Item THORNED_VIOLET = registerBlockItem(ModBlocks.THORNED_VIOLET);
    public static final Item GLOW_THORNED_VIOLET = registerBlockItem(ModBlocks.GLOW_THORNED_VIOLET);

// Lush Flowers
    public static final Item LUSH_AGAPANTHUS = registerBlockItem(ModBlocks.LUSH_AGAPANTHUS);
    public static final Item GLOW_LUSH_AGAPANTHUS = registerBlockItem(ModBlocks.GLOW_LUSH_AGAPANTHUS);

    public static final Item LUSH_BLUE_COSMOS = registerBlockItem(ModBlocks.LUSH_BLUE_COSMOS);
    public static final Item GLOW_LUSH_BLUE_COSMOS = registerBlockItem(ModBlocks.GLOW_LUSH_BLUE_COSMOS);

    public static final Item LUSH_BONSAI = registerBlockItem(ModBlocks.LUSH_BONSAI);
    public static final Item GLOW_LUSH_BONSAI = registerBlockItem(ModBlocks.GLOW_LUSH_BONSAI);

    public static final Item LUSH_CARNATION = registerBlockItem(ModBlocks.LUSH_CARNATION);
    public static final Item GLOW_LUSH_CARNATION = registerBlockItem(ModBlocks.GLOW_LUSH_CARNATION);

    public static final Item LUSH_DAFFODIL = registerBlockItem(ModBlocks.LUSH_DAFFODIL);
    public static final Item GLOW_LUSH_DAFFODIL = registerBlockItem(ModBlocks.GLOW_LUSH_DAFFODIL);

    public static final Item LUSH_DAHLIA = registerBlockItem(ModBlocks.LUSH_DAHLIA);
    public static final Item GLOW_LUSH_DAHLIA = registerBlockItem(ModBlocks.GLOW_LUSH_DAHLIA);

    public static final Item LUSH_DELPHINIUM = registerBlockItem(ModBlocks.LUSH_DELPHINIUM);
    public static final Item GLOW_LUSH_DELPHINIUM = registerBlockItem(ModBlocks.GLOW_LUSH_DELPHINIUM);

    public static final Item LUSH_HAWTHORN = registerBlockItem(ModBlocks.LUSH_HAWTHORN);
    public static final Item GLOW_LUSH_HAWTHORN = registerBlockItem(ModBlocks.GLOW_LUSH_HAWTHORN);

    public static final Item LUSH_HYDRANGEA = registerBlockItem(ModBlocks.LUSH_HYDRANGEA);
    public static final Item GLOW_LUSH_HYDRANGEA = registerBlockItem(ModBlocks.GLOW_LUSH_HYDRANGEA);

    public static final Item LUSH_IRIS = registerBlockItem(ModBlocks.LUSH_IRIS);
    public static final Item GLOW_LUSH_IRIS = registerBlockItem(ModBlocks.GLOW_LUSH_IRIS);

    public static final Item LUSH_LARKSPUR = registerBlockItem(ModBlocks.LUSH_LARKSPUR);
    public static final Item GLOW_LUSH_LARKSPUR = registerBlockItem(ModBlocks.GLOW_LUSH_LARKSPUR);

    public static final Item LUSH_MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.LUSH_MIDNIGHT_MYSTIC);
    public static final Item GLOW_LUSH_MIDNIGHT_MYSTIC = registerBlockItem(ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC);

    public static final Item LUSH_PRIMROSE = registerBlockItem(ModBlocks.LUSH_PRIMROSE);
    public static final Item GLOW_LUSH_PRIMROSE = registerBlockItem(ModBlocks.GLOW_LUSH_PRIMROSE);

    public static final Item LUSH_SNOW_DROP = registerBlockItem(ModBlocks.LUSH_SNOW_DROP);
    public static final Item GLOW_LUSH_SNOW_DROP = registerBlockItem(ModBlocks.GLOW_LUSH_SNOW_DROP);

    public static final Item LUSH_SPIDERLILY = registerBlockItem(ModBlocks.LUSH_SPIDERLILY);
    public static final Item GLOW_LUSH_SPIDERLILY = registerBlockItem(ModBlocks.GLOW_LUSH_SPIDERLILY);

    public static final Item LUSH_VIOLET = registerBlockItem(ModBlocks.LUSH_VIOLET);
    public static final Item GLOW_LUSH_VIOLET = registerBlockItem(ModBlocks.GLOW_LUSH_VIOLET);

// Water
    public static final Item WHITE_WATER_BUCKET = registerDyedWaterBucket(DyeColor.WHITE, ModFluids.STILL_WHITE_WATER);
    public static final Item LIGHT_GRAY_WATER_BUCKET = registerDyedWaterBucket(DyeColor.LIGHT_GRAY, ModFluids.STILL_LIGHT_GRAY_WATER);
    public static final Item GRAY_WATER_BUCKET = registerDyedWaterBucket(DyeColor.GRAY, ModFluids.STILL_GRAY_WATER);
    public static final Item BLACK_WATER_BUCKET = registerDyedWaterBucket(DyeColor.BLACK, ModFluids.STILL_BLACK_WATER);
    public static final Item BROWN_WATER_BUCKET = registerDyedWaterBucket(DyeColor.BROWN, ModFluids.STILL_BROWN_WATER);
    public static final Item RED_WATER_BUCKET = registerDyedWaterBucket(DyeColor.RED, ModFluids.STILL_RED_WATER);
    public static final Item ORANGE_WATER_BUCKET = registerDyedWaterBucket(DyeColor.ORANGE, ModFluids.STILL_ORANGE_WATER);
    public static final Item YELLOW_WATER_BUCKET = registerDyedWaterBucket(DyeColor.YELLOW, ModFluids.STILL_YELLOW_WATER);
    public static final Item LIME_WATER_BUCKET = registerDyedWaterBucket(DyeColor.LIME, ModFluids.STILL_LIME_WATER);
    public static final Item GREEN_WATER_BUCKET = registerDyedWaterBucket(DyeColor.GREEN, ModFluids.STILL_GREEN_WATER);
    public static final Item CYAN_WATER_BUCKET = registerDyedWaterBucket(DyeColor.CYAN, ModFluids.STILL_CYAN_WATER);
    public static final Item LIGHT_BLUE_WATER_BUCKET = registerDyedWaterBucket(DyeColor.LIGHT_BLUE, ModFluids.STILL_LIGHT_BLUE_WATER);
    public static final Item BLUE_WATER_BUCKET = registerDyedWaterBucket(DyeColor.BLUE, ModFluids.STILL_BLUE_WATER);
    public static final Item PURPLE_WATER_BUCKET = registerDyedWaterBucket(DyeColor.PURPLE, ModFluids.STILL_PURPLE_WATER);
    public static final Item MAGENTA_WATER_BUCKET = registerDyedWaterBucket(DyeColor.MAGENTA, ModFluids.STILL_MAGENTA_WATER);
    public static final Item PINK_WATER_BUCKET = registerDyedWaterBucket(DyeColor.PINK, ModFluids.STILL_PINK_WATER);

// Lava
    public static final Item WHITE_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.WHITE, ModFluids.STILL_WHITE_LAVA);
    public static final Item LIGHT_GRAY_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.LIGHT_GRAY, ModFluids.STILL_LIGHT_GRAY_LAVA);
    public static final Item GRAY_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.GRAY, ModFluids.STILL_GRAY_LAVA);
    public static final Item BLACK_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.BLACK, ModFluids.STILL_BLACK_LAVA);
    public static final Item BROWN_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.BROWN, ModFluids.STILL_BROWN_LAVA);
    public static final Item RED_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.RED, ModFluids.STILL_RED_LAVA);
    public static final Item ORANGE_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.ORANGE, ModFluids.STILL_ORANGE_LAVA);
    public static final Item YELLOW_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.YELLOW, ModFluids.STILL_YELLOW_LAVA);
    public static final Item LIME_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.LIME, ModFluids.STILL_LIME_LAVA);
    public static final Item GREEN_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.GREEN, ModFluids.STILL_GREEN_LAVA);
    public static final Item CYAN_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.CYAN, ModFluids.STILL_CYAN_LAVA);
    public static final Item LIGHT_BLUE_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.LIGHT_BLUE, ModFluids.STILL_LIGHT_BLUE_LAVA);
    public static final Item BLUE_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.BLUE, ModFluids.STILL_BLUE_LAVA);
    public static final Item PURPLE_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.PURPLE, ModFluids.STILL_PURPLE_LAVA);
    public static final Item MAGENTA_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.MAGENTA, ModFluids.STILL_MAGENTA_LAVA);
    public static final Item PINK_LAVA_BUCKET = registerDyedLavaBucket(DyeColor.PINK, ModFluids.STILL_PINK_LAVA);


    public static final Item TELEPORT_TRAP_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "teleport_trap_item"),
            new TeleportTrapBlockItem(ModBlocks.TELEPORT_TRAP_BLOCK, new FabricItemSettings()));

    public static final Item SMOKE_BLOCK_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "smoke_block_item"),
            new SmokeBlockItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));

    private static Item registerDyedWaterBucket(DyeColor color, FlowableFluid fluid) {
        BucketItem item = new BucketItem(fluid, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1));
        COLOR_TO_WATER_BUCKET.put(color, item);
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, color.getName() + "_water_bucket"), item);
    }

    private static Item registerDyedLavaBucket(DyeColor color, FlowableFluid fluid) {
        BucketItem item = new BucketItem(fluid, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1));
        COLOR_TO_LAVA_BUCKET.put(color, item);
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, color.getName() + "_lava_bucket"), item);
    }
    
    private static Item registerBlockItem(Block block) {
        return Registry.register(Registries.ITEM, Registries.BLOCK.getId(block), new BlockItem(block, new FabricItemSettings()));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name), item);
    }

    public static void registerModItems()   {
        Steamcraft.LOGGER.info("Registering Mod Items");
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
