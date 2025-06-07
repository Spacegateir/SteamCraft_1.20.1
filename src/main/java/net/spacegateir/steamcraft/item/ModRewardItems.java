package net.spacegateir.steamcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.*;
import net.spacegateir.steamcraft.item.loot_chests.*;

public class ModRewardItems {


    public static final Item LOOT_CHEST = registerItem("loot_chest",
            new LootChestItem(new FabricItemSettings().maxCount(1)));

//    public static final Item _LOOT_CHEST = registerItem("_loot_chest",
//            new Item(new FabricItemSettings().maxCount(1)));
//    public static final Item _HELMET = registerItem("_helmet",
//            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
//    public static final Item _CHESTPLATE = registerItem("_chestplate",
//            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
//    public static final Item _LEGGINGS = registerItem("_leggings",
//            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
//    public static final Item _BOOTS = registerItem("_boots",
//            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TERA_LOOT_CHEST = registerItem("tera_loot_chest",
            new TeraItem(new FabricItemSettings().maxCount(1)));
    public static final Item TERA_HELMET = registerItem("tera_helmet",
            new TeraArmorItem(ModArmorMaterials.TERA, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TERA_CHESTPLATE = registerItem("tera_chestplate",
            new TeraArmorItem(ModArmorMaterials.TERA, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TERA_LEGGINGS = registerItem("tera_leggings",
            new TeraArmorItem(ModArmorMaterials.TERA, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TERA_BOOTS = registerItem("tera_boots",
            new TeraArmorItem(ModArmorMaterials.TERA, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item ORIKALKUM_LOOT_CHEST = registerItem("orikalkum_loot_chest",
            new OrikalkumItem(new FabricItemSettings().maxCount(1)));
    public static final Item ORIKALKUM_HELMET = registerItem("orikalkum_helmet",
            new OrikalkumArmorItem(ModArmorMaterials.ORIKALKUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ORIKALKUM_CHESTPLATE = registerItem("orikalkum_chestplate",
            new OrikalkumArmorItem(ModArmorMaterials.ORIKALKUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ORIKALKUM_LEGGINGS = registerItem("orikalkum_leggings",
            new OrikalkumArmorItem(ModArmorMaterials.ORIKALKUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ORIKALKUM_BOOTS = registerItem("orikalkum_boots",
            new OrikalkumArmorItem(ModArmorMaterials.ORIKALKUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item MYTHRIL_LOOT_CHEST = registerItem("mythril_loot_chest",
            new MythrilItem(new FabricItemSettings().maxCount(1)));
    public static final Item MYTHRIL_HELMET = registerItem("mythril_helmet",
            new MythrilArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item MYTHRIL_CHESTPLATE = registerItem("mythril_chestplate",
            new MythrilArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item MYTHRIL_LEGGINGS = registerItem("mythril_leggings",
            new MythrilArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item MYTHRIL_BOOTS = registerItem("mythril_boots",
            new MythrilArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item MAGIRITE_LOOT_CHEST = registerItem("magirite_loot_chest",
            new MagiriteItem(new FabricItemSettings().maxCount(1)));
    public static final Item MAGIRITE_HELMET = registerItem("magirite_helmet",
            new MagiriteArmorItem(ModArmorMaterials.MAGIRITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item MAGIRITE_CHESTPLATE = registerItem("magirite_chestplate",
            new MagiriteArmorItem(ModArmorMaterials.MAGIRITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item MAGIRITE_LEGGINGS = registerItem("magirite_leggings",
            new MagiriteArmorItem(ModArmorMaterials.MAGIRITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item MAGIRITE_BOOTS = registerItem("magirite_boots",
            new MagiriteArmorItem(ModArmorMaterials.MAGIRITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item IGNIS_LOOT_CHEST = registerItem("ignis_loot_chest",
            new IgnisItem(new FabricItemSettings().maxCount(1)));
    public static final Item IGNIS_HELMET = registerItem("ignis_helmet",
            new IgnisArmorItem(ModArmorMaterials.IGNIS, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IGNIS_CHESTPLATE = registerItem("ignis_chestplate",
            new IgnisArmorItem(ModArmorMaterials.IGNIS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IGNIS_LEGGINGS = registerItem("ignis_leggings",
            new IgnisArmorItem(ModArmorMaterials.IGNIS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item IGNIS_BOOTS = registerItem("ignis_boots",
            new IgnisArmorItem(ModArmorMaterials.IGNIS, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item DWARF_STEEL_LOOT_CHEST = registerItem("dwarf_steel_loot_chest",
            new DwarfSteelItem(new FabricItemSettings().maxCount(1)));
    public static final Item DWARF_STEEL_HELMET = registerItem("dwarf_steel_helmet",
            new DwarfSteelArmorItem(ModArmorMaterials.DWARF_STEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DWARF_STEEL_CHESTPLATE = registerItem("dwarf_steel_chestplate",
            new DwarfSteelArmorItem(ModArmorMaterials.DWARF_STEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DWARF_STEEL_LEGGINGS = registerItem("dwarf_steel_leggings",
            new DwarfSteelArmorItem(ModArmorMaterials.DWARF_STEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DWARF_STEEL_BOOTS = registerItem("dwarf_steel_boots",
            new DwarfSteelArmorItem(ModArmorMaterials.DWARF_STEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item DRAGON_BANE_LOOT_CHEST = registerItem("dragon_bane_loot_chest",
            new DragonBaneItem(new FabricItemSettings().maxCount(1)));
    public static final Item DRAGON_BANE_HELMET = registerItem("dragon_bane_helmet",
            new DragonBaneArmorItem(ModArmorMaterials.DRAGON_BANE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DRAGON_BANE_CHESTPLATE = registerItem("dragon_bane_chestplate",
            new DragonBaneArmorItem(ModArmorMaterials.DRAGON_BANE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DRAGON_BANE_LEGGINGS = registerItem("dragon_bane_leggings",
            new DragonBaneArmorItem(ModArmorMaterials.DRAGON_BANE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DRAGON_BANE_BOOTS = registerItem("dragon_bane_boots",
            new DragonBaneArmorItem(ModArmorMaterials.DRAGON_BANE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item AQUA_LOOT_CHEST = registerItem("aqua_loot_chest",
            new AquaItem(new FabricItemSettings().maxCount(1)));
    public static final Item AQUA_HELMET = registerItem("aqua_helmet",
            new AquaArmorItem(ModArmorMaterials.AQUA, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item AQUA_CHESTPLATE = registerItem("aqua_chestplate",
            new AquaArmorItem(ModArmorMaterials.AQUA, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item AQUA_LEGGINGS = registerItem("aqua_leggings",
            new AquaArmorItem(ModArmorMaterials.AQUA, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item AQUA_BOOTS = registerItem("aqua_boots",
            new AquaArmorItem(ModArmorMaterials.AQUA, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item AER_LOOT_CHEST = registerItem("aer_loot_chest",
            new AerItem(new FabricItemSettings().maxCount(1)));
    public static final Item AER_HELMET = registerItem("aer_helmet",
            new AerArmorItem(ModArmorMaterials.AER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item AER_CHESTPLATE = registerItem("aer_chestplate",
            new AerArmorItem(ModArmorMaterials.AER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item AER_LEGGINGS = registerItem("aer_leggings",
            new AerArmorItem(ModArmorMaterials.AER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item AER_BOOTS = registerItem("aer_boots",
            new AerArmorItem(ModArmorMaterials.AER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item ADAMANTITE_LOOT_CHEST = registerItem("adamantite_loot_chest",
            new AdamantiteItem(new FabricItemSettings().maxCount(1)));
    public static final Item ADAMANTITE_HELMET = registerItem("adamantite_helmet",
            new AdamantiteArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ADAMANTITE_CHESTPLATE = registerItem("adamantite_chestplate",
            new AdamantiteArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ADAMANTITE_LEGGINGS = registerItem("adamantite_leggings",
            new AdamantiteArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ADAMANTITE_BOOTS = registerItem("adamantite_boots",
            new AdamantiteArmorItem(ModArmorMaterials.ADAMANTITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item WOLF_FURY_LOOT_CHEST = registerItem("wolf_fury_loot_chest",
            new WolfFuryItem(new FabricItemSettings().maxCount(1)));
    public static final Item WOLF_FURY_HELMET = registerItem("wolf_fury_helmet",
            new WolfFuryArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item WOLF_FURY_CHESTPLATE = registerItem("wolf_fury_chestplate",
            new WolfFuryArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item WOLF_FURY_LEGGINGS = registerItem("wolf_fury_leggings",
            new WolfFuryArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item WOLF_FURY_BOOTS = registerItem("wolf_fury_boots",
            new WolfFuryArmorItem(ModArmorMaterials.WOLF, ArmorItem.Type.BOOTS, new FabricItemSettings()));







    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name), item);
    }

    public static void registerModRewardItems()   {
        Steamcraft.LOGGER.info("Registering Mod Items for " + Steamcraft.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
