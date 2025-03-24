package net.spacegateir.steamcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.custom.ToolTipItem;
import net.spacegateir.steamcraft.item.custom.SwapItem;

public class ModItems {

    public static final Item TEST_ITEM = registerItem("test_item",
            new Item(new FabricItemSettings()));

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
