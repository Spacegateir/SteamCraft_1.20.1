package net.spacegateir.steamcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.custom.*;

public class ModBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block AETHER_COIL = registerBlock("aether_coil",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));
    public static final Block AETHER_COIL_WHITE = registerBlock("aether_coil_white",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.WHITE)));
    public static final Block AETHER_COIL_LIGHT_GRAY = registerBlock("aether_coil_light_gray",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block AETHER_COIL_GRAY = registerBlock("aether_coil_gray",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.GRAY)));
    public static final Block AETHER_COIL_BLACK = registerBlock("aether_coil_black",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.BLACK)));
    public static final Block AETHER_COIL_BROWN = registerBlock("aether_coil_brown",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.BROWN)));
    public static final Block AETHER_COIL_RED = registerBlock("aether_coil_red",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.RED)));
    public static final Block AETHER_COIL_ORANGE = registerBlock("aether_coil_orange",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.ORANGE)));
    public static final Block AETHER_COIL_YELLOW = registerBlock("aether_coil_yellow",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.YELLOW)));
    public static final Block AETHER_COIL_LIME = registerBlock("aether_coil_lime",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.LIME)));
    public static final Block AETHER_COIL_GREEN = registerBlock("aether_coil_green",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.GREEN)));
    public static final Block AETHER_COIL_CYAN = registerBlock("aether_coil_cyan",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.CYAN)));
    public static final Block AETHER_COIL_LIGHT_BLUE = registerBlock("aether_coil_light_blue",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block AETHER_COIL_BLUE = registerBlock("aether_coil_blue",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.BLUE)));
    public static final Block AETHER_COIL_PURPLE = registerBlock("aether_coil_purple",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.PURPLE)));
    public static final Block AETHER_COIL_MAGENTA = registerBlock("aether_coil_magenta",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.MAGENTA)));
    public static final Block AETHER_COIL_PINK = registerBlock("aether_coil_pink",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50,2400)
                    .nonOpaque().velocityMultiplier(1.25F).mapColor(MapColor.PINK)));

    public static final Block FOOLS_GOLD_BLOCK = registerBlock("fools_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block FOOLS_GOLD_RAW_BLOCK = registerBlock("fools_gold_raw_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block CLAY_PATH = registerBlock("clay_path",
            new ClayPathBlock(FabricBlockSettings.copyOf(Blocks.CLAY).velocityMultiplier(1.25F)));
    public static final Block COARSE_DIRT_PATH = registerBlock("coarse_dirt_path",
            new CoarsePathBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT).velocityMultiplier(1.25F)));
    public static final Block DIRT_PATH = registerBlock("dirt_path",
            new DirtYPathBlock(FabricBlockSettings.copyOf(Blocks.DIRT).velocityMultiplier(1.25F)));
    public static final Block GRAVEL_PATH = registerBlock("gravel_path",
            new GravelPathBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL).velocityMultiplier(1.25F)));
    public static final Block MUD_PATH = registerBlock("mud_path",
            new MudPathBlock(FabricBlockSettings.copyOf(Blocks.MUD).velocityMultiplier(1.25F)));
    public static final Block RED_SAND_PATH = registerBlock("red_sand_path",
            new RedSandPathBlock(FabricBlockSettings.copyOf(Blocks.RED_SAND).velocityMultiplier(1.25F)));
    public static final Block ROOTED_DIRT_PATH = registerBlock("rooted_dirt_path",
            new RootedDirtPathBlock(FabricBlockSettings.copyOf(Blocks.ROOTED_DIRT).velocityMultiplier(1.25F)));
    public static final Block SAND_PATH = registerBlock("sand_path",
            new SandPathBlock(FabricBlockSettings.copyOf(Blocks.SAND).velocityMultiplier(1.25F)));

    public static final Block SKELETON_SITTING = registerBlock("skeleton_sitting",
            new SkeletonParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_HEAD = registerBlock("skeleton_head",
            new SkeletonHalfParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_CHEST = registerBlock("skeleton_chest",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_ARM = registerBlock("skeleton_arm",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_LEG = registerBlock("skeleton_leg",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_PELVIS = registerBlock("skeleton_pelvis",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_SPINE = registerBlock("skeleton_spine",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_TORSO = registerBlock("skeleton_torso",
            new SkeletonParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_HALF_BODY = registerBlock("skeleton_half_body",
            new SkeletonHalfParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_HEAD_STACK = registerBlock("skeleton_head_stack",
            new SkeletonParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_ARMS_CROSS = registerBlock("skeleton_arms_cross",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_LEGS_CROSS = registerBlock("skeleton_legs_cross",
            new SkeletonBoneParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block SKELETON_LAYING = registerBlock("skeleton_laying",
            new SkeletonHalfParts(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).allowsSpawning(Blocks::never).nonOpaque()));












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
