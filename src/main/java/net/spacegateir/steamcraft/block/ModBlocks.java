package net.spacegateir.steamcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.custom.*;
import net.spacegateir.steamcraft.effect.ModEffects;

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
            new DirtyPathBlock(FabricBlockSettings.copyOf(Blocks.DIRT).velocityMultiplier(1.25F)));
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

// Normal Flowers
    public static final Block AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "agapanthus_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_agapanthus_flower"),
            new FlowerPotBlock(AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_agapanthus_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_agapanthus_flower"),
            new FlowerPotBlock(GLOW_AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SPEED, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_blue_cosmos_flower"),
            new FlowerPotBlock(BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SPEED, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_blue_cosmos_flower"),
            new FlowerPotBlock(GLOW_BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_bonsai_flower"),
            new FlowerPotBlock(BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_bonsai_flower"),
            new FlowerPotBlock(GLOW_BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "carnation_flower"),
            new FlowerBlock(StatusEffects.BAD_OMEN, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_carnation_flower"),
            new FlowerPotBlock(CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_carnation_flower"),
            new FlowerBlock(StatusEffects.BAD_OMEN, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_carnation_flower"),
            new FlowerPotBlock(GLOW_CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "daffodil_flower"),
            new FlowerBlock(StatusEffects.LUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_daffodil_flower"),
            new FlowerPotBlock(DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_daffodil_flower"),
            new FlowerBlock(StatusEffects.LUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_daffodil_flower"),
            new FlowerPotBlock(GLOW_DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "dahlia_flower"),
            new FlowerBlock(StatusEffects.WITHER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_dahlia_flower"),
            new FlowerPotBlock(DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_dahlia_flower"),
            new FlowerBlock(StatusEffects.WITHER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_dahlia_flower"),
            new FlowerPotBlock(GLOW_DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "delphinium_flower"),
            new FlowerBlock(StatusEffects.LEVITATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_delphinium_flower"),
            new FlowerPotBlock(DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_delphinium_flower"),
            new FlowerBlock(StatusEffects.LEVITATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_delphinium_flower"),
            new FlowerPotBlock(GLOW_DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "hawthorn_flower"),
            new FlowerBlock(ModEffects.CLEAR_NEGATIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_hawthorn_flower"),
            new FlowerPotBlock(HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_hawthorn_flower"),
            new FlowerBlock(ModEffects.CLEAR_NEGATIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_hawthorn_flower"),
            new FlowerPotBlock(GLOW_HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "hydrangea_flower"),
            new FlowerBlock(StatusEffects.NAUSEA, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_hydrangea_flower"),
            new FlowerPotBlock(HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_hydrangea_flower"),
            new FlowerBlock(StatusEffects.NAUSEA, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_hydrangea_flower"),
            new FlowerPotBlock(GLOW_HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "iris_flower"),
            new FlowerBlock(StatusEffects.GLOWING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_iris_flower"),
            new FlowerPotBlock(IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_iris_flower"),
            new FlowerBlock(StatusEffects.GLOWING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_iris_flower"),
            new FlowerPotBlock(GLOW_IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "larkspur_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_larkspur_flower"),
            new FlowerPotBlock(LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_larkspur_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_larkspur_flower"),
            new FlowerPotBlock(GLOW_LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "midnight_mystic_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_midnight_mystic_flower"),
            new FlowerPotBlock(MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_midnight_mystic_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_midnight_mystic_flower"),
            new FlowerPotBlock(GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "primrose_flower"),
            new FlowerBlock(StatusEffects.HASTE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_primrose_flower"),
            new FlowerPotBlock(PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_primrose_flower"),
            new FlowerBlock(StatusEffects.HASTE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_primrose_flower"),
            new FlowerPotBlock(GLOW_PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "snow_drop_flower"),
            new FlowerBlock(ModEffects.FREAKY_BUNNY, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_snow_drop_flower"),
            new FlowerPotBlock(SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_snow_drop_flower"),
            new FlowerBlock(ModEffects.FREAKY_BUNNY, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_snow_drop_flower"),
            new FlowerPotBlock(GLOW_SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_spiderlily_flower"),
            new FlowerPotBlock(SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_spiderlily_flower"),
            new FlowerPotBlock(GLOW_SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "violet_flower"),
            new FlowerBlock(StatusEffects.POISON, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_violet_flower"),
            new FlowerPotBlock(VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_violet_flower"),
            new FlowerBlock(StatusEffects.POISON, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_violet_flower"),
            new FlowerPotBlock(GLOW_VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

// Thorned Flowers
    public static final Block THORNED_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_agapanthus_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_agapanthus_flower"),
            new FlowerPotBlock(THORNED_AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_agapanthus_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_agapanthus_flower"),
            new FlowerPotBlock(GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SLOW_FALLING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_blue_cosmos_flower"),
            new FlowerPotBlock(THORNED_BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SLOW_FALLING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_blue_cosmos_flower"),
            new FlowerPotBlock(GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_bonsai_flower"),
            new FlowerPotBlock(THORNED_BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_bonsai_flower"),
            new FlowerPotBlock(GLOW_THORNED_BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_carnation_flower"),
            new FlowerBlock(StatusEffects.BAD_OMEN, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_carnation_flower"),
            new FlowerPotBlock(THORNED_CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_carnation_flower"),
            new FlowerBlock(StatusEffects.BAD_OMEN, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_carnation_flower"),
            new FlowerPotBlock(GLOW_THORNED_CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_daffodil_flower"),
            new FlowerBlock(StatusEffects.UNLUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_daffodil_flower"),
            new FlowerPotBlock(THORNED_DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_daffodil_flower"),
            new FlowerBlock(StatusEffects.UNLUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_daffodil_flower"),
            new FlowerPotBlock(GLOW_THORNED_DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_dahlia_flower"),
            new FlowerBlock(StatusEffects.WITHER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_dahlia_flower"),
            new FlowerPotBlock(THORNED_DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_dahlia_flower"),
            new FlowerBlock(StatusEffects.WITHER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_dahlia_flower"),
            new FlowerPotBlock(GLOW_THORNED_DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_delphinium_flower"),
            new FlowerBlock(StatusEffects.LEVITATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_delphinium_flower"),
            new FlowerPotBlock(THORNED_DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_delphinium_flower"),
            new FlowerBlock(StatusEffects.LEVITATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_delphinium_flower"),
            new FlowerPotBlock(GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_hawthorn_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_hawthorn_flower"),
            new FlowerPotBlock(THORNED_HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_hawthorn_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_hawthorn_flower"),
            new FlowerPotBlock(GLOW_THORNED_HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_hydrangea_flower"),
            new FlowerBlock(StatusEffects.NAUSEA, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_hydrangea_flower"),
            new FlowerPotBlock(THORNED_HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_hydrangea_flower"),
            new FlowerBlock(StatusEffects.NAUSEA, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_hydrangea_flower"),
            new FlowerPotBlock(GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_iris_flower"),
            new FlowerBlock(StatusEffects.BLINDNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_iris_flower"),
            new FlowerPotBlock(THORNED_IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_iris_flower"),
            new FlowerBlock(StatusEffects.BLINDNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_iris_flower"),
            new FlowerPotBlock(GLOW_THORNED_IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_larkspur_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_larkspur_flower"),
            new FlowerPotBlock(THORNED_LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_larkspur_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_larkspur_flower"),
            new FlowerPotBlock(GLOW_THORNED_LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_midnight_mystic_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_midnight_mystic_flower"),
            new FlowerPotBlock(THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_midnight_mystic_flower"),
            new FlowerBlock(ModEffects.DISORIENT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_midnight_mystic_flower"),
            new FlowerPotBlock(GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_primrose_flower"),
            new FlowerBlock(StatusEffects.SLOWNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_primrose_flower"),
            new FlowerPotBlock(THORNED_PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_primrose_flower"),
            new FlowerBlock(StatusEffects.SLOWNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_primrose_flower"),
            new FlowerPotBlock(GLOW_THORNED_PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_snow_drop_flower"),
            new FlowerBlock(StatusEffects.WEAKNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_snow_drop_flower"),
            new FlowerPotBlock(THORNED_SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_snow_drop_flower"),
            new FlowerBlock(StatusEffects.WEAKNESS, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_snow_drop_flower"),
            new FlowerPotBlock(GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_spiderlily_flower"),
            new FlowerPotBlock(THORNED_SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_spiderlily_flower"),
            new FlowerPotBlock(GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block THORNED_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "thorned_violet_flower"),
            new FlowerBlock(StatusEffects.HUNGER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_THORNED_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_thorned_violet_flower"),
            new FlowerPotBlock(THORNED_VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_THORNED_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_thorned_violet_flower"),
            new FlowerBlock(StatusEffects.HUNGER, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_THORNED_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_violet_flower"),
            new FlowerPotBlock(GLOW_THORNED_VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

// Lush Flowers
    public static final Block LUSH_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_agapanthus_flower"),
            new FlowerBlock(StatusEffects.STRENGTH, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_agapanthus_flower"),
            new FlowerPotBlock(LUSH_AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_agapanthus_flower"),
            new FlowerBlock(StatusEffects.STRENGTH, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_agapanthus_flower"),
            new FlowerPotBlock(GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SPEED, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_blue_cosmos_flower"),
            new FlowerPotBlock(LUSH_BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_blue_cosmos_flower"),
            new FlowerBlock(StatusEffects.SPEED, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_blue_cosmos_flower"),
            new FlowerPotBlock(GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_NEGATIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_bonsai_flower"),
            new FlowerPotBlock(LUSH_BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_bonsai_flower"),
            new FlowerBlock(ModEffects.CLEAR_NEGATIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_BONSAI_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_bonsai_flower"),
            new FlowerPotBlock(GLOW_LUSH_BONSAI_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_carnation_flower"),
            new FlowerBlock(StatusEffects.HERO_OF_THE_VILLAGE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_carnation_flower"),
            new FlowerPotBlock(LUSH_CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_carnation_flower"),
            new FlowerBlock(StatusEffects.HERO_OF_THE_VILLAGE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_CARNATION_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_carnation_flower"),
            new FlowerPotBlock(GLOW_LUSH_CARNATION_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_daffodil_flower"),
            new FlowerBlock(StatusEffects.LUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_daffodil_flower"),
            new FlowerPotBlock(LUSH_DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_daffodil_flower"),
            new FlowerBlock(StatusEffects.LUCK, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_DAFFODIL_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_daffodil_flower"),
            new FlowerPotBlock(GLOW_LUSH_DAFFODIL_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_dahlia_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_dahlia_flower"),
            new FlowerPotBlock(LUSH_DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_dahlia_flower"),
            new FlowerBlock(StatusEffects.REGENERATION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_DAHLIA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_dahlia_flower"),
            new FlowerPotBlock(GLOW_LUSH_DAHLIA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_delphinium_flower"),
            new FlowerBlock(StatusEffects.SLOW_FALLING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_delphinium_flower"),
            new FlowerPotBlock(LUSH_DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_delphinium_flower"),
            new FlowerBlock(StatusEffects.SLOW_FALLING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_delphinium_flower"),
            new FlowerPotBlock(GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_hawthorn_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_hawthorn_flower"),
            new FlowerPotBlock(LUSH_HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_hawthorn_flower"),
            new FlowerBlock(ModEffects.CLEAR_POSITIVE_EFFECT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_HAWTHORN_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_hawthorn_flower"),
            new FlowerPotBlock(GLOW_LUSH_HAWTHORN_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_hydrangea_flower"),
            new FlowerBlock(StatusEffects.WATER_BREATHING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_hydrangea_flower"),
            new FlowerPotBlock(LUSH_HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_hydrangea_flower"),
            new FlowerBlock(StatusEffects.WATER_BREATHING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_hydrangea_flower"),
            new FlowerPotBlock(GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_iris_flower"),
            new FlowerBlock(StatusEffects.GLOWING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_iris_flower"),
            new FlowerPotBlock(LUSH_IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_iris_flower"),
            new FlowerBlock(StatusEffects.GLOWING, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_IRIS_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_iris_flower"),
            new FlowerPotBlock(GLOW_LUSH_IRIS_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_larkspur_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_larkspur_flower"),
            new FlowerPotBlock(LUSH_LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_larkspur_flower"),
            new FlowerBlock(StatusEffects.RESISTANCE, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_LARKSPUR_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_larkspur_flower"),
            new FlowerPotBlock(GLOW_LUSH_LARKSPUR_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_midnight_mystic_flower"),
            new FlowerBlock(ModEffects.FREAKY_BUNNY, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_midnight_mystic_flower"),
            new FlowerPotBlock(LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_midnight_mystic_flower"),
            new FlowerBlock(ModEffects.FREAKY_BUNNY, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_midnight_mystic_flower"),
            new FlowerPotBlock(GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_primrose_flower"),
            new FlowerBlock(StatusEffects.JUMP_BOOST, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_primrose_flower"),
            new FlowerPotBlock(LUSH_PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_primrose_flower"),
            new FlowerBlock(StatusEffects.JUMP_BOOST, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_PRIMROSE_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_primrose_flower"),
            new FlowerPotBlock(GLOW_LUSH_PRIMROSE_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_snow_drop_flower"),
            new FlowerBlock(StatusEffects.ABSORPTION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_snow_drop_flower"),
            new FlowerPotBlock(LUSH_SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_snow_drop_flower"),
            new FlowerBlock(StatusEffects.ABSORPTION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_snow_drop_flower"),
            new FlowerPotBlock(GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_spiderlily_flower"),
            new FlowerPotBlock(LUSH_SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_spiderlily_flower"),
            new FlowerBlock(ModEffects.STICKY_FEAT, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_spiderlily_flower"),
            new FlowerPotBlock(GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));

    public static final Block LUSH_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "lush_violet_flower"),
            new FlowerBlock(StatusEffects.NIGHT_VISION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_LUSH_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_lush_violet_flower"),
            new FlowerPotBlock(LUSH_VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block GLOW_LUSH_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glow_lush_violet_flower"),
            new FlowerBlock(StatusEffects.NIGHT_VISION, 160, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision()));
    public static final Block POTTED_GLOW_LUSH_VIOLET_FLOWER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_violet_flower"),
            new FlowerPotBlock(GLOW_LUSH_VIOLET_FLOWER_BLOCK, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque()));





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
