package net.spacegateir.steamcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import net.spacegateir.steamcraft.item.armor.CelestialGearforgedArmourItem;
import net.spacegateir.steamcraft.item.armor.FoolsGoldArmourItem;
import net.spacegateir.steamcraft.item.custom.ToolTipItem;
import net.spacegateir.steamcraft.item.custom.SwapItem;

public class ModItems {

    public static final Item TEST_ITEM = registerItem("test_item",
            new Item(new FabricItemSettings()));

    public static final Item COPPER_COIN = registerItem("copper_coin",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item SILVER_COIN = registerItem("silver_coin",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item GOLD_COIN = registerItem("gold_coin",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

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

    public static final Item FERRITE_HEARTSTONE = registerItem("ferrite_heartstone",
            new ToolTipItem(new FabricItemSettings()));
    public static final Item AETHERIUM_PRISM = registerItem("aetherium_prism",
            new ToolTipItem(new FabricItemSettings()));
    public static final Item AQUARION_SHARD = registerItem("aquarion_shard",
            new ToolTipItem(new FabricItemSettings()));
    public static final Item PYROCITE_CORE = registerItem("pyrocite_core",
            new ToolTipItem(new FabricItemSettings()));
    public static final Item LUMINITE_SPARK = registerItem("luminite_spark",
            new ToolTipItem(new FabricItemSettings()));
    public static final Item OBSCURIUM_CRYSTAL = registerItem("obscurium_crystal",
            new ToolTipItem(new FabricItemSettings()));

    public static final Item FOOLS_GOLD_HELMET_1 = registerItem("fools_gold_helmet_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_HELMET_2 = registerItem("fools_gold_helmet_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_HELMET_3 = registerItem("fools_gold_helmet_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_HELMET_4 = registerItem("fools_gold_helmet_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_CHESTPLATE_1 = registerItem("fools_gold_chestplate_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_CHESTPLATE_2 = registerItem("fools_gold_chestplate_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_CHESTPLATE_3 = registerItem("fools_gold_chestplate_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_CHESTPLATE_4 = registerItem("fools_gold_chestplate_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_LEGGINGS_1 = registerItem("fools_gold_leggings_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_LEGGINGS_2 = registerItem("fools_gold_leggings_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_LEGGINGS_3 = registerItem("fools_gold_leggings_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_LEGGINGS_4 = registerItem("fools_gold_leggings_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_BOOTS_1 = registerItem("fools_gold_boots_1-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_BOOTS_2 = registerItem("fools_gold_boots_2-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_BOOTS_3 = registerItem("fools_gold_boots_3-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item FOOLS_GOLD_BOOTS_4 = registerItem("fools_gold_boots_4-4",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item FOOLS_GOLD_HELMET = registerItem("fools_gold_helmet",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item FOOLS_GOLD_CHESTPLATE = registerItem("fools_gold_chestplate",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item FOOLS_GOLD_LEGGINGS = registerItem("fools_gold_leggings",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item FOOLS_GOLD_BOOTS = registerItem("fools_gold_boots",
            new FoolsGoldArmourItem(ModArmorMaterials.FOOLS_GOLD, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item CELESTIAL_GEARFORGED_HELMET = registerItem("celestial_gearforged_helmet",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CELESTIAL_GEARFORGED_CHESTPLATE = registerItem("celestial_gearforged_chestplate",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CELESTIAL_GEARFORGED_LEGGINGS = registerItem("celestial_gearforged_leggings",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CELESTIAL_GEARFORGED_BOOTS = registerItem("celestial_gearforged_boots",
            new CelestialGearforgedArmourItem(ModArmorMaterials.CELESTIAL_GEARFORGED, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TEST_ITEM_BLOCK = Registry.register(Registries.ITEM,
            new Identifier(Steamcraft.MOD_ID, "test_item_block"),
            new BlockItem(ModBlocks.TEST_BLOCK_ITEM, new FabricItemSettings()));







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
