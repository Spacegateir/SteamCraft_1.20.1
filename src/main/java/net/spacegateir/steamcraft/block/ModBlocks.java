package net.spacegateir.steamcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.custom.AetherBlock;

public class ModBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block AETHER_COIL = registerBlock("aether_coil",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_WHITE = registerBlock("aether_coil_white",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_LIGHT_GRAY = registerBlock("aether_coil_light_gray",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_GRAY = registerBlock("aether_coil_gray",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_BLACK = registerBlock("aether_coil_black",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_BROWN = registerBlock("aether_coil_brown",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_RED = registerBlock("aether_coil_red",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_ORANGE = registerBlock("aether_coil_orange",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_YELLOW = registerBlock("aether_coil_yellow",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_LIME = registerBlock("aether_coil_lime",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_GREEN = registerBlock("aether_coil_green",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_CYAN = registerBlock("aether_coil_cyan",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_LIGHT_BLUE = registerBlock("aether_coil_light_blue",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_BLUE = registerBlock("aether_coil_blue",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_PURPLE = registerBlock("aether_coil_purple",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_MAGENTA = registerBlock("aether_coil_magenta",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AETHER_COIL_PINK = registerBlock("aether_coil_pink",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block TEST_BLOCK_ITEM = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "test_block_item"),
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).resistance(50.0F).hardness(50.0F)));





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Steamcraft.LOGGER.info("Registering ModBlocks for " + Steamcraft.MOD_ID);
    }
}
