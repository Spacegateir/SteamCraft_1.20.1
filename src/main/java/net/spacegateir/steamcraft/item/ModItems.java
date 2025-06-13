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

import static net.minecraft.util.Rarity.RARE;

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
            new Item(new FabricItemSettings().rarity(RARE)));
    public static final Item FOOLS_GOLD_RAW = registerItem("fools_gold_raw",
            new Item(new FabricItemSettings().rarity(RARE)));
    public static final Item FOOLS_GOLD_INGOT = registerItem("fools_gold_ingot",
            new Item(new FabricItemSettings().rarity(RARE)));
    public static final Item DIVINITITE_ALLOY_INGOT = registerItem("divinitite_alloy_ingot",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item DIVINITITE_ALLOY_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "divinitite_alloy_item"),
            new BlockItem(ModBlocks.DIVINITITE_ALLOY_BLOCK, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

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
    public static final Item BUCKET_MOULD = registerItem("bucket_mould",
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
    public static final Item AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "agapanthus_flower_item"),
            new BlockItem(ModBlocks.AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_agapanthus_flower_item"),
            new BlockItem(ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "bonsai_flower_item"),
            new BlockItem(ModBlocks.BONSAI_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_bonsai_flower_item"),
            new BlockItem(ModBlocks.GLOW_BONSAI_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "carnation_flower_item"),
            new BlockItem(ModBlocks.CARNATION_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_carnation_flower_item"),
            new BlockItem(ModBlocks.GLOW_CARNATION_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "daffodil_flower_item"),
            new BlockItem(ModBlocks.DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_daffodil_flower_item"),
            new BlockItem(ModBlocks.GLOW_DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "dahlia_flower_item"),
            new BlockItem(ModBlocks.DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_dahlia_flower_item"),
            new BlockItem(ModBlocks.GLOW_DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "delphinium_flower_item"),
            new BlockItem(ModBlocks.DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_delphinium_flower_item"),
            new BlockItem(ModBlocks.GLOW_DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "hawthorn_flower_item"),
            new BlockItem(ModBlocks.HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_hawthorn_flower_item"),
            new BlockItem(ModBlocks.GLOW_HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "hydrangea_flower_item"),
            new BlockItem(ModBlocks.HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_hydrangea_flower_item"),
            new BlockItem(ModBlocks.GLOW_HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "iris_flower_item"),
            new BlockItem(ModBlocks.IRIS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_iris_flower_item"),
            new BlockItem(ModBlocks.GLOW_IRIS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "larkspur_flower_item"),
            new BlockItem(ModBlocks.LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_larkspur_flower_item"),
            new BlockItem(ModBlocks.GLOW_LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "primrose_flower_item"),
            new BlockItem(ModBlocks.PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_primrose_flower_item"),
            new BlockItem(ModBlocks.GLOW_PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "snow_drop_flower_item"),
            new BlockItem(ModBlocks.SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_snow_drop_flower_item"),
            new BlockItem(ModBlocks.GLOW_SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "spiderlily_flower_item"),
            new BlockItem(ModBlocks.SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_spiderlily_flower_item"),
            new BlockItem(ModBlocks.GLOW_SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "violet_flower_item"),
            new BlockItem(ModBlocks.VIOLET_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_violet_flower_item"),
            new BlockItem(ModBlocks.GLOW_VIOLET_FLOWER_BLOCK, new FabricItemSettings()));

// Thorned Flowers
    public static final Item THORNED_AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_agapanthus_flower_item"),
            new BlockItem(ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_agapanthus_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_bonsai_flower_item"),
            new BlockItem(ModBlocks.THORNED_BONSAI_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_bonsai_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_BONSAI_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_carnation_flower_item"),
            new BlockItem(ModBlocks.THORNED_CARNATION_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_carnation_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_CARNATION_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_daffodil_flower_item"),
            new BlockItem(ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_daffodil_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_dahlia_flower_item"),
            new BlockItem(ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_dahlia_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_delphinium_flower_item"),
            new BlockItem(ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_delphinium_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_hawthorn_flower_item"),
            new BlockItem(ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_hawthorn_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_hydrangea_flower_item"),
            new BlockItem(ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_hydrangea_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_iris_flower_item"),
            new BlockItem(ModBlocks.THORNED_IRIS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_iris_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_IRIS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_larkspur_flower_item"),
            new BlockItem(ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_larkspur_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_primrose_flower_item"),
            new BlockItem(ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_primrose_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_snow_drop_flower_item"),
            new BlockItem(ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_snow_drop_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_spiderlily_flower_item"),
            new BlockItem(ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_spiderlily_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item THORNED_VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "thorned_violet_flower_item"),
            new BlockItem(ModBlocks.THORNED_VIOLET_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_THORNED_VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_violet_flower_item"),
            new BlockItem(ModBlocks.GLOW_THORNED_VIOLET_FLOWER_BLOCK, new FabricItemSettings()));

// Lush Flowers
    public static final Item LUSH_AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_agapanthus_flower_item"),
            new BlockItem(ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_AGAPANTHUS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_agapanthus_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_BLUE_COSMOS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_blue_cosmos_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_bonsai_flower_item"),
            new BlockItem(ModBlocks.LUSH_BONSAI_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_BONSAI_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_bonsai_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_BONSAI_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_carnation_flower_item"),
            new BlockItem(ModBlocks.LUSH_CARNATION_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_CARNATION_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_carnation_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_CARNATION_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_daffodil_flower_item"),
            new BlockItem(ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_DAFFODIL_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_daffodil_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_DAFFODIL_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_dahlia_flower_item"),
            new BlockItem(ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_DAHLIA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_dahlia_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_DAHLIA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_delphinium_flower_item"),
            new BlockItem(ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_DELPHINIUM_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_delphinium_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_hawthorn_flower_item"),
            new BlockItem(ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_HAWTHORN_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_hawthorn_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_HAWTHORN_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_hydrangea_flower_item"),
            new BlockItem(ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_HYDRANGEA_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_hydrangea_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_iris_flower_item"),
            new BlockItem(ModBlocks.LUSH_IRIS_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_IRIS_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_iris_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_IRIS_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_larkspur_flower_item"),
            new BlockItem(ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_LARKSPUR_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_larkspur_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_LARKSPUR_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_midnight_mystic_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_primrose_flower_item"),
            new BlockItem(ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_PRIMROSE_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_primrose_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_PRIMROSE_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_snow_drop_flower_item"),
            new BlockItem(ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_SNOW_DROP_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_snow_drop_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_spiderlily_flower_item"),
            new BlockItem(ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_SPIDERLILY_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_spiderlily_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK, new FabricItemSettings()));

    public static final Item LUSH_VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "lush_violet_flower_item"),
            new BlockItem(ModBlocks.LUSH_VIOLET_FLOWER_BLOCK, new FabricItemSettings()));
    public static final Item GLOW_LUSH_VIOLET_FLOWER_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_violet_flower_item"),
            new BlockItem(ModBlocks.GLOW_LUSH_VIOLET_FLOWER_BLOCK, new FabricItemSettings()));



    public static final Item TELEPORT_TRAP_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "teleport_trap_item"),
            new TeleportTrapBlockItem(ModBlocks.TELEPORT_TRAP_BLOCK, new FabricItemSettings()));

    public static final Item SMOKE_BLOCK_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "smoke_block_item"),
            new SmokeBlockItem(ModBlocks.SMOKE_BLOCK, new FabricItemSettings()));

    public static final Item GLIMMERSTONE_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_STAIR_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_stair_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_STAIR_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_SLAB_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_slab_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_SLAB_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_WALL_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_wall_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_WALL_BLOCK, new FabricItemSettings()));

    public static final Item GLIMMERSTONE_COBBLESTONE_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_cobblestone_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_COBBLESTONE_STAIR_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_cobblestone_stair_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_COBBLESTONE_SLAB_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_cobblestone_slab_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_COBBLESTONE_WALL_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_cobblestone_wall_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, new FabricItemSettings()));

    public static final Item GLIMMERSTONE_BRICKS_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_bricks_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_BRICKS_STAIR_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_bricks_stair_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_BRICKS_SLAB_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_bricks_slab_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, new FabricItemSettings()));
    public static final Item GLIMMERSTONE_BRICKS_WALL_ITEM = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone_bricks_wall_item"),
            new BlockItem(ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, new FabricItemSettings()));


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

    public static final Item FOOLS_GOLD_LAVA_BUCKET = Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID,
            "fools_gold_lava_bucket"), new BucketItem(ModFluids.STILL_FOOLS_GOLD_LAVA,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).rarity(RARE)));

    public static final Item DIVINITITE_ALLOY_LAVA_BUCKET = Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID,
            "divinitite_alloy_lava_bucket"), new BucketItem(ModFluids.STILL_DIVINITITE_ALLOY_LAVA,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).rarity(Rarity.EPIC)));















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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name), item);
    }

    public static void registerModItems()   {
        Steamcraft.LOGGER.info("Registering Mod Items for " + Steamcraft.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
