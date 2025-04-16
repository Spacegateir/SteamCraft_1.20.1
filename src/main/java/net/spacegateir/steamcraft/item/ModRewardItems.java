package net.spacegateir.steamcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import net.spacegateir.steamcraft.item.armor.WolfFuryArmorItem;
import net.spacegateir.steamcraft.item.loot_chests.AmethystItem;
import net.spacegateir.steamcraft.item.loot_chests.LootChestItem;
import net.spacegateir.steamcraft.item.loot_chests.WolfFuryItem;

public class ModRewardItems {


    public static final Item LOOT_CHEST = registerItem("loot_chest",
            new LootChestItem(new FabricItemSettings().maxCount(1)));

    public static final Item AMETHYST_LOOT_CHEST = registerItem("amethyst_loot_chest",
            new AmethystItem(new FabricItemSettings().maxCount(1)));
    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots",
            new AmethystArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new FabricItemSettings()));

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
