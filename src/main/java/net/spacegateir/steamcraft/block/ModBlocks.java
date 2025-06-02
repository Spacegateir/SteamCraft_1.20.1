package net.spacegateir.steamcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.arcane.ArcaneBlock;
import net.spacegateir.steamcraft.block.arcane.ArcaneSlownessBlock;
import net.spacegateir.steamcraft.block.arcane.ArcaneSpeedBlock;
import net.spacegateir.steamcraft.block.arcane.ArcaneStarvingBlock;
import net.spacegateir.steamcraft.block.arcane_specal.ArcaneVoidBlock;
import net.spacegateir.steamcraft.block.cauldronblocks.DyedLavaCauldronBlock;
import net.spacegateir.steamcraft.block.cauldronblocks.DyedWaterCauldronBlock;
import net.spacegateir.steamcraft.block.custom.*;
import net.spacegateir.steamcraft.block.path_blocks.*;
import net.spacegateir.steamcraft.block.traps.*;
import net.spacegateir.steamcraft.effect.ModEffects;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ModBlocks {

    public static final EnumMap<DyeColor, Block> COLOR_TO_LAVA_CAULDRON = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> COLOR_TO_WATER_CAULDRON = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, Block> COLOR_TO_CONCRETE = Util.make(new EnumMap<>(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, Blocks.WHITE_CONCRETE);
        map.put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE);
        map.put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE);
        map.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        map.put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE);
        map.put(DyeColor.LIME, Blocks.LIME_CONCRETE);
        map.put(DyeColor.PINK, Blocks.PINK_CONCRETE);
        map.put(DyeColor.GRAY, Blocks.GRAY_CONCRETE);
        map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        map.put(DyeColor.CYAN, Blocks.CYAN_CONCRETE);
        map.put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE);
        map.put(DyeColor.BLUE, Blocks.BLUE_CONCRETE);
        map.put(DyeColor.BROWN, Blocks.BROWN_CONCRETE);
        map.put(DyeColor.GREEN, Blocks.GREEN_CONCRETE);
        map.put(DyeColor.RED, Blocks.RED_CONCRETE);
        map.put(DyeColor.BLACK, Blocks.BLACK_CONCRETE);
    });
    public static final EnumMap<DyeColor, Block> COLOR_TO_CONCRETE_POWDER = Util.make(new EnumMap<>(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, Blocks.WHITE_CONCRETE_POWDER);
        map.put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE_POWDER);
        map.put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE_POWDER);
        map.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
        map.put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE_POWDER);
        map.put(DyeColor.LIME, Blocks.LIME_CONCRETE_POWDER);
        map.put(DyeColor.PINK, Blocks.PINK_CONCRETE_POWDER);
        map.put(DyeColor.GRAY, Blocks.GRAY_CONCRETE_POWDER);
        map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
        map.put(DyeColor.CYAN, Blocks.CYAN_CONCRETE_POWDER);
        map.put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE_POWDER);
        map.put(DyeColor.BLUE, Blocks.BLUE_CONCRETE_POWDER);
        map.put(DyeColor.BROWN, Blocks.BROWN_CONCRETE_POWDER);
        map.put(DyeColor.GREEN, Blocks.GREEN_CONCRETE_POWDER);
        map.put(DyeColor.RED, Blocks.RED_CONCRETE_POWDER);
        map.put(DyeColor.BLACK, Blocks.BLACK_CONCRETE_POWDER);
    });
    public static final EnumMap<DyeColor, Block> COLOR_TO_COBBLED_CONCRETE = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> COLOR_TO_COBBLED_CONCRETE_POWDER = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, Block> COLOR_TO_AETHER_COIL = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, Block> COLOR_TO_FLOWER = new EnumMap<>(DyeColor.class);
    public static final Map<Block, Block> FLOWER_TO_POTTED_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_GLOW_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_POTTED_GLOW_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_THORNED_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_POTTED_THORNED_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_GLOW_THORNED_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_POTTED_GLOW_THORNED_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_LUSH_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_POTTED_LUSH_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_GLOW_LUSH_FLOWER = new HashMap<>();
    public static final Map<Block, Block> FLOWER_TO_POTTED_GLOW_LUSH_FLOWER = new HashMap<>();

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block AETHER_COIL = registerBlock("aether_coil",
            new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block AETHER_COIL_WHITE = registerDyedAetherCoil(DyeColor.WHITE, MapColor.WHITE);
    public static final Block AETHER_COIL_LIGHT_GRAY = registerDyedAetherCoil(DyeColor.LIGHT_GRAY, MapColor.LIGHT_GRAY);
    public static final Block AETHER_COIL_GRAY = registerDyedAetherCoil(DyeColor.GRAY, MapColor.GRAY);
    public static final Block AETHER_COIL_BLACK = registerDyedAetherCoil(DyeColor.BLACK, MapColor.BLACK);
    public static final Block AETHER_COIL_BROWN = registerDyedAetherCoil(DyeColor.BROWN, MapColor.BROWN);
    public static final Block AETHER_COIL_RED = registerDyedAetherCoil(DyeColor.RED, MapColor.RED);
    public static final Block AETHER_COIL_ORANGE = registerDyedAetherCoil(DyeColor.ORANGE, MapColor.ORANGE);
    public static final Block AETHER_COIL_YELLOW = registerDyedAetherCoil(DyeColor.YELLOW, MapColor.YELLOW);
    public static final Block AETHER_COIL_LIME = registerDyedAetherCoil(DyeColor.LIME, MapColor.LIME);
    public static final Block AETHER_COIL_GREEN = registerDyedAetherCoil(DyeColor.GREEN, MapColor.GREEN);
    public static final Block AETHER_COIL_CYAN = registerDyedAetherCoil(DyeColor.CYAN, MapColor.CYAN);
    public static final Block AETHER_COIL_LIGHT_BLUE = registerDyedAetherCoil(DyeColor.LIGHT_BLUE, MapColor.LIGHT_BLUE);
    public static final Block AETHER_COIL_BLUE = registerDyedAetherCoil(DyeColor.BLUE, MapColor.BLUE);
    public static final Block AETHER_COIL_PURPLE = registerDyedAetherCoil(DyeColor.PURPLE, MapColor.PURPLE);
    public static final Block AETHER_COIL_MAGENTA = registerDyedAetherCoil(DyeColor.MAGENTA, MapColor.MAGENTA);
    public static final Block AETHER_COIL_PINK = registerDyedAetherCoil(DyeColor.PINK, MapColor.PINK);

    public static final Block FOOLS_GOLD_BLOCK = registerBlock("fools_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block FOOLS_GOLD_RAW_BLOCK = registerBlock("fools_gold_raw_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    // Path Blocks

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
    public static final Block SNOW_PATH = registerBlock("snow_path",
            new SnowPathBlock(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).velocityMultiplier(1.25F)));

    public static final Block ANDESITE_PATH = registerBlock("andesite_path",
            new AndesitePathBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE).velocityMultiplier(1.25F)));
    public static final Block ANDESITE_DIRTY_PATH = registerBlock("andesite_dirty_path",
            new AndesitePathBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE).velocityMultiplier(1.25F)));
    public static final Block ANDESITE_MOSSY_PATH = registerBlock("andesite_mossy_path",
            new AndesitePathBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE).velocityMultiplier(1.25F)));
    public static final Block COBBLESTONE_PATH = registerBlock("cobblestone_path",
            new CobbledPathBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).velocityMultiplier(1.25F)));
    public static final Block COBBLED_DIRTY_PATH = registerBlock("cobbled_dirty_path",
            new CobbledPathBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).velocityMultiplier(1.25F)));
    public static final Block MOSSY_COBBLESTONE_PATH = registerBlock("mossy_cobblestone_path",
            new CobbledMossyPathBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_COBBLESTONE).velocityMultiplier(1.25F)));
    public static final Block COBBLED_DEEPSLATE_PATH = registerBlock("cobbled_deepslate_path",
            new DeepslatePathBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE).velocityMultiplier(1.25F)));
    public static final Block COBBLED_DEEPSLATE_DIRTY_PATH = registerBlock("cobbled_deepslate_dirty_path",
            new DeepslatePathBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE).velocityMultiplier(1.25F)));
    public static final Block COBBLED_DEEPSLATE_MOSSY_PATH = registerBlock("cobbled_deepslate_mossy_path",
            new DeepslatePathBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE).velocityMultiplier(1.25F)));
    public static final Block END_STONE_PATH = registerBlock("end_stone_path",
            new EndStonePathBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).velocityMultiplier(1.25F)));
    public static final Block DIORITE_PATH = registerBlock("diorite_path",
            new DioritePathBlock(FabricBlockSettings.copyOf(Blocks.DIORITE).velocityMultiplier(1.25F)));
    public static final Block DIORITE_DIRTY_PATH = registerBlock("diorite_dirty_path",
            new DioritePathBlock(FabricBlockSettings.copyOf(Blocks.DIORITE).velocityMultiplier(1.25F)));
    public static final Block DIORITE_MOSSY_PATH = registerBlock("diorite_mossy_path",
            new DioritePathBlock(FabricBlockSettings.copyOf(Blocks.DIORITE).velocityMultiplier(1.25F)));
    public static final Block GRANITE_PATH = registerBlock("granite_path",
            new GranitePathBlock(FabricBlockSettings.copyOf(Blocks.GRANITE).velocityMultiplier(1.25F)));
    public static final Block GRANITE_DIRTY_PATH = registerBlock("granite_dirty_path",
            new GranitePathBlock(FabricBlockSettings.copyOf(Blocks.GRANITE).velocityMultiplier(1.25F)));
    public static final Block GRANITE_MOSSY_PATH = registerBlock("granite_mossy_path",
            new GranitePathBlock(FabricBlockSettings.copyOf(Blocks.GRANITE).velocityMultiplier(1.25F)));
    public static final Block STONE_PATH = registerBlock("stone_path",
            new StonePathBlock(FabricBlockSettings.copyOf(Blocks.STONE).velocityMultiplier(1.25F)));
    public static final Block STONE_DIRTY_PATH = registerBlock("stone_dirty_path",
            new StonePathBlock(FabricBlockSettings.copyOf(Blocks.STONE).velocityMultiplier(1.25F)));
    public static final Block STONE_MOSSY_PATH = registerBlock("stone_mossy_path",
            new StonePathBlock(FabricBlockSettings.copyOf(Blocks.STONE).velocityMultiplier(1.25F)));


    //Mob Parts Blocks

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


    public static final Block POWER_PRECISION_BLOCK = registerBlock("power_precision_block_0",
            new PowerPrecisionBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).resistance(50.0F).hardness(50.0F)));

    // Arcane Blocks

    public static final Block ARCANE_ABSORPTION_BLOCK = registerArcaneBlock(StatusEffects.ABSORPTION, signalStrength ->
                    new StatusEffectInstance(StatusEffects.ABSORPTION, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_BAD_OMEN_BLOCK = registerArcaneBlock(StatusEffects.BAD_OMEN, signalStrength ->
                    new StatusEffectInstance(StatusEffects.BAD_OMEN, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_BLINDNESS_BLOCK = registerArcaneBlock(StatusEffects.BLINDNESS, signalStrength ->
                    new StatusEffectInstance(StatusEffects.BLINDNESS, signalStrength == 0 ? 2400 : signalStrength * 1200 + 1200, signalStrength, false, false));

    public static final Block ARCANE_CONDUIT_BLOCK = registerArcaneBlock(StatusEffects.CONDUIT_POWER, signalStrength ->
                    new StatusEffectInstance(StatusEffects.CONDUIT_POWER, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_DARKNESS_BLOCK = registerArcaneBlock(StatusEffects.DARKNESS, signalStrength ->
                    new StatusEffectInstance(StatusEffects.DARKNESS, signalStrength == 0 ? 2400 : signalStrength * 1200 + 1200, signalStrength, false, false));

    public static final Block ARCANE_DOLPHINS_GRACE_BLOCK = registerArcaneBlock(StatusEffects.DOLPHINS_GRACE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_FIRE_RESISTANCE_BLOCK = registerArcaneBlock(StatusEffects.FIRE_RESISTANCE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_GLOWING_BLOCK = registerArcaneBlock(StatusEffects.GLOWING, signalStrength ->
                    new StatusEffectInstance(StatusEffects.GLOWING, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_HASTE_BLOCK = registerArcaneBlock(StatusEffects.HASTE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.HASTE, signalStrength * 2400 + 2400, ((signalStrength == 0) ? 0 : 2400 /* TODO amplifier 2400? */) + signalStrength, false, false));

    public static final Block ARCANE_HEALTH_BOOST_BLOCK = registerArcaneBlock(StatusEffects.HEALTH_BOOST, signalStrength ->
                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, signalStrength * 1200 + 1200, signalStrength, false, false));

    public static final Block ARCANE_HERO_OF_THE_VILLAGE_BLOCK = registerArcaneBlock(StatusEffects.HERO_OF_THE_VILLAGE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_INSTANT_DAMAGE_BLOCK = registerArcaneBlock(StatusEffects.INSTANT_DAMAGE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, signalStrength == 0 ? 1 : signalStrength * 10 + 10, signalStrength, false, false));

    public static final Block ARCANE_INSTANT_HEALTH_BLOCK = registerArcaneBlock(StatusEffects.INSTANT_HEALTH, signalStrength ->
                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, signalStrength * 1200 + 1200, signalStrength, false, false));

    public static final Block ARCANE_INVISIBILITY_BLOCK = registerArcaneBlock(StatusEffects.INVISIBILITY, signalStrength ->
                    new StatusEffectInstance(StatusEffects.INVISIBILITY, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_JUMP_BOOST_BLOCK = registerArcaneBlock(StatusEffects.JUMP_BOOST, signalStrength ->
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, signalStrength * 600 + 600, signalStrength == 0 ? 0 : signalStrength * 2 + 1, false, false));

    public static final Block ARCANE_LEVITATION_BLOCK = registerArcaneBlock(StatusEffects.LEVITATION, signalStrength ->
                    new StatusEffectInstance(StatusEffects.LEVITATION, signalStrength * 600 + 600, signalStrength, false, false));

    public static final Block ARCANE_LUCK_BLOCK = registerArcaneBlock(StatusEffects.LUCK, signalStrength ->
                    new StatusEffectInstance(StatusEffects.LUCK, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_MINING_FATIGUE_BLOCK = registerArcaneBlock(StatusEffects.MINING_FATIGUE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.MINING_FATIGUE, signalStrength * 2400 + 2400, ((signalStrength == 0) ? 0 : 2400 /* TODO amplifier 2400? */) + signalStrength, false, false));

    public static final Block ARCANE_NEAUSEA_BLOCK = registerArcaneBlock(StatusEffects.NAUSEA, signalStrength ->
                    new StatusEffectInstance(StatusEffects.NAUSEA, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_NIGHT_VISION_BLOCK = registerArcaneBlock(StatusEffects.NIGHT_VISION, signalStrength ->
                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_POISION_BLOCK = registerArcaneBlock(StatusEffects.POISON, signalStrength ->
                    new StatusEffectInstance(StatusEffects.POISON, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_REGENERATION_BLOCK = registerArcaneBlock(StatusEffects.REGENERATION, signalStrength ->
                    new StatusEffectInstance(StatusEffects.REGENERATION, signalStrength * 600 + 600, signalStrength, false, false));

    public static final Block ARCANE_RESISTANCE_BLOCK = registerArcaneBlock(StatusEffects.RESISTANCE, signalStrength ->
                    new StatusEffectInstance(StatusEffects.RESISTANCE, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_SATUATION_BLOCK = registerArcaneBlock(StatusEffects.SATURATION, signalStrength ->
                    new StatusEffectInstance(StatusEffects.SATURATION, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_SLOW_FALL_BLOCK = registerArcaneBlock(StatusEffects.SLOW_FALLING, signalStrength ->
                    new StatusEffectInstance(StatusEffects.SLOW_FALLING, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_SLOWNESS_BLOCK = registerBlock("arcane_slowness_block",
            new ArcaneSlownessBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_SPEED_BLOCK = registerBlock("arcane_speed_block",
            new ArcaneSpeedBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_STARVING_BLOCK = registerBlock("arcane_starving_block",
            new ArcaneStarvingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_STRENGTH_BLOCK = registerArcaneBlock(StatusEffects.STRENGTH, signalStrength ->
                    new StatusEffectInstance(StatusEffects.STRENGTH, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_UNLUCK_BLOCK = registerArcaneBlock(StatusEffects.UNLUCK, signalStrength ->
                    new StatusEffectInstance(StatusEffects.UNLUCK, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_WATER_BREATHING_BLOCK = registerArcaneBlock(StatusEffects.WATER_BREATHING, signalStrength ->
                    new StatusEffectInstance(StatusEffects.WATER_BREATHING, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_WEAKNESS_BLOCK = registerArcaneBlock(StatusEffects.WEAKNESS, signalStrength ->
                    new StatusEffectInstance(StatusEffects.WEAKNESS, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_WITHER_BLOCK = registerArcaneBlock(StatusEffects.WITHER, signalStrength ->
                    new StatusEffectInstance(StatusEffects.WITHER, signalStrength * 600 + 600, signalStrength, false, false));


    public static final Block ARCANE_VOID_BLOCK = registerBlock("arcane_void_block",
            new ArcaneVoidBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_CLEAR_NEGATIVE_BLOCK = registerArcaneBlock(ModEffects.CLEAR_NEGATIVE_EFFECT, signalStrength ->
                    new StatusEffectInstance(ModEffects.CLEAR_NEGATIVE_EFFECT, 1, 200, false, false));

    public static final Block ARCANE_CLEAR_POSITIVE_BLOCK = registerArcaneBlock(ModEffects.CLEAR_POSITIVE_EFFECT, signalStrength ->
                    new StatusEffectInstance(ModEffects.CLEAR_POSITIVE_EFFECT, 1, 200, false, false));

    public static final Block ARCANE_CLEAR_NEUTRAL_BLOCK = registerArcaneBlock(ModEffects.CLEAR_NEUTRAL_EFFECT, signalStrength ->
                    new StatusEffectInstance(ModEffects.CLEAR_NEUTRAL_EFFECT, 1, 200, false, false));

    public static final Block ARCANE_DISORIENT_BLOCK = registerArcaneBlock(ModEffects.DISORIENT, signalStrength ->
                    new StatusEffectInstance(ModEffects.DISORIENT, signalStrength * 600 + 600, signalStrength, false, false));

    public static final Block ARCANE_STICKY_FEAT_BLOCK = registerArcaneBlock(ModEffects.STICKY_FEAT, signalStrength ->
                    new StatusEffectInstance(ModEffects.STICKY_FEAT, signalStrength * 2400 + 2400, signalStrength, false, false));

    public static final Block ARCANE_FREAKY_BUNNY_BLOCK = registerArcaneBlock(ModEffects.FREAKY_BUNNY, signalStrength ->
                    new StatusEffectInstance(ModEffects.FREAKY_BUNNY, signalStrength * 2400 + 2400, signalStrength, false, false));


    // Trap Blocks
    public static final Block CURSED_BLOCK = registerBlock("cursed_block",
            new CursedBlock(FabricBlockSettings.copyOf(Blocks.SCULK).resistance(50.0F).hardness(50.0F)));

    public static final Block COURSE_DIRT_TRAP_BLOCK = registerBlock("course_dirt_trap_block",
            new CourseDirtTrapBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block COURSE_DIRT_TRAP_BLOCK_SPIKES = registerBlock("course_dirt_trap_block_spikes",
            new CourseDirtTrapBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block STONE_TRAP_BLOCK = registerBlock("stone_trap_block",
            new StoneTrapBlock(FabricBlockSettings.copyOf(Blocks.STONE).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block STONE_TRAP_BLOCK_SPIKES = registerBlock("stone_trap_block_spikes",
            new StoneTrapBlock(FabricBlockSettings.copyOf(Blocks.STONE).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block DEEPSLATE_TRAP_BLOCK = registerBlock("deepslate_trap_block",
            new DeepslateTrapBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block DEEPSLATE_TRAP_BLOCK_SPIKES = registerBlock("deepslate_trap_block_spikes",
            new DeepslateTrapBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block SAND_QUICKSAND = registerBlock("sand_quicksand",
            new QuickSandBlock(FabricBlockSettings.copyOf(Blocks.SAND).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).noCollision().solid()));
    public static final Block RED_SAND_QUICKSAND = registerBlock("red_sand_quicksand",
            new QuickSandBlock(FabricBlockSettings.copyOf(Blocks.RED_SAND).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).noCollision().solid()));
    public static final Block GRAVEL_SINKSTONE = registerBlock("gravel_sinkstone",
            new QuickSandBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).noCollision().solid()));
    public static final Block MUD_SINKING_SLUDGE = registerBlock("mud_sinking_sludge",
            new QuickSandBlock(FabricBlockSettings.copyOf(Blocks.MUD).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).noCollision().solid()));
    public static final Block SOUL_SAND_PHANTOM_QUICKSAND = registerBlock("soul_sand_phantom_quicksand",
            new QuickSandBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SAND).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).noCollision().solid()));

    public static final Block FLAREFORGE_BLOCK = registerBlock("flareforge",
            new FlareforgeBlock(FabricBlockSettings.copyOf(Blocks.BRICKS).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block NETHER_STEAM_VENT = registerBlock("nether_steam_vent",
            new FlareforgeBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block CURSED_TOTEM_BLOCK = registerBlock("cursed_totem_block",
            new WonderingTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).nonOpaque().resistance(50.0F).hardness(50.0F)));

    public static final Block FROST_BITE_TRAP_BLOCK = registerBlock("frost_bite_trap_block",
            new FrostBitTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block CURSED_NAUSEA_TRAP_BLOCK = registerBlock("cursed_nausea_trap_block",
            new CursedNauseaTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F).nonOpaque()));
    public static final Block CURSED_POISON_SPORE_TRAP_BLOCK = registerBlock("cursed_poison_spore_trap_block",
            new CursedPoisonSporeTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).nonOpaque().allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block CURSED_BRASIER_TRAP_BLOCK = registerBlock("cursed_brasier_trap_block",
            new HungerZoneTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).nonOpaque().allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block EMPTY_BRASIER = registerBlock("empty_brasier",
            new BrasierBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).nonOpaque().luminance(15)));
    public static final Block SPIRIT_JUMP_TRAP = registerBlock("spirit_jump_trap",
            new SpiritJumpTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));
    public static final Block SPIRIT_JUMP_TRAP_BLOCK = registerBlock("spirit_jump_trap_block",
            new SpiritJumpTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block TELEPORT_TRAP_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "teleport_trap_block"),
            new TeleportTrapBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).resistance(50.0F).hardness(50.0F)));

    public static final Block SMOKE_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "smoke_block"),
            new SmokeBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2f,-1f).nonOpaque()
                    .luminance(5).noCollision()));

    // Concrete Blocks

    public static final Block WHITE_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.WHITE);
    public static final Block WHITE_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.WHITE, WHITE_COBBLED_CONCRETE);

    public static final Block LIGHT_GRAY_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.LIGHT_GRAY);
    public static final Block LIGHT_GRAY_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.LIGHT_GRAY, LIGHT_GRAY_COBBLED_CONCRETE);

    public static final Block GRAY_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.GRAY);
    public static final Block GRAY_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.GRAY, GRAY_COBBLED_CONCRETE);

    public static final Block BLACK_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.BLACK);
    public static final Block BLACK_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.BLACK, BLACK_COBBLED_CONCRETE);

    public static final Block BROWN_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.BROWN);
    public static final Block BROWN_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.BROWN, BROWN_COBBLED_CONCRETE);

    public static final Block RED_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.RED);
    public static final Block RED_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.RED, RED_COBBLED_CONCRETE);

    public static final Block ORANGE_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.ORANGE);
    public static final Block ORANGE_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.ORANGE, ORANGE_COBBLED_CONCRETE);

    public static final Block YELLOW_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.YELLOW);
    public static final Block YELLOW_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.YELLOW, YELLOW_COBBLED_CONCRETE);

    public static final Block LIME_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.LIME);
    public static final Block LIME_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.LIME, LIME_COBBLED_CONCRETE);

    public static final Block GREEN_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.GREEN);
    public static final Block GREEN_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.GREEN, GREEN_COBBLED_CONCRETE);

    public static final Block CYAN_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.CYAN);
    public static final Block CYAN_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.CYAN, CYAN_COBBLED_CONCRETE);

    public static final Block LIGHT_BLUE_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.LIGHT_BLUE);
    public static final Block LIGHT_BLUE_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.LIGHT_BLUE, LIGHT_BLUE_COBBLED_CONCRETE);

    public static final Block BLUE_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.BLUE);
    public static final Block BLUE_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.BLUE, BLUE_COBBLED_CONCRETE);

    public static final Block PURPLE_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.PURPLE);
    public static final Block PURPLE_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.PURPLE, PURPLE_COBBLED_CONCRETE);

    public static final Block MAGENTA_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.MAGENTA);
    public static final Block MAGENTA_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.MAGENTA, MAGENTA_COBBLED_CONCRETE);

    public static final Block PINK_COBBLED_CONCRETE = registerCobbledConcrete(DyeColor.PINK);
    public static final Block PINK_COBBLED_CONCRETE_POWDER = registerCobbledConcretePowder(DyeColor.PINK, PINK_COBBLED_CONCRETE);


    public static final Block WHITE_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.WHITE);
    public static final Block WHITE_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.WHITE);

    public static final Block ORANGE_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.ORANGE);
    public static final Block ORANGE_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.ORANGE);

    public static final Block MAGENTA_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.MAGENTA);
    public static final Block MAGENTA_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.MAGENTA);

    public static final Block LIGHT_BLUE_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.LIGHT_BLUE);
    public static final Block LIGHT_BLUE_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.LIGHT_BLUE);

    public static final Block YELLOW_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.YELLOW);
    public static final Block YELLOW_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.YELLOW);

    public static final Block LIME_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.LIME);
    public static final Block LIME_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.LIME);

    public static final Block PINK_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.PINK);
    public static final Block PINK_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.PINK);

    public static final Block GRAY_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.GRAY);
    public static final Block GRAY_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.GRAY);

    public static final Block LIGHT_GRAY_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.LIGHT_GRAY);
    public static final Block LIGHT_GRAY_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.LIGHT_GRAY);

    public static final Block CYAN_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.CYAN);
    public static final Block CYAN_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.CYAN);

    public static final Block PURPLE_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.PURPLE);
    public static final Block PURPLE_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.PURPLE);

    public static final Block BLUE_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.BLUE);
    public static final Block BLUE_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.BLUE);

    public static final Block BROWN_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.BROWN);
    public static final Block BROWN_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.BROWN);

    public static final Block GREEN_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.GREEN);
    public static final Block GREEN_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.GREEN);

    public static final Block RED_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.RED);
    public static final Block RED_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.RED);

    public static final Block BLACK_LAVA_CAULDRON_BLOCK = registerDyedLavaCauldron(DyeColor.BLACK);
    public static final Block BLACK_WATER_CAULDRON_BLOCK = registerDyedWaterCauldron(DyeColor.BLACK);


// Snow and Ice Blocks

    public static final Block PACKED_ICE_BRICKS = registerBlock("packed_ice_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));

    public static final Block PACKED_ICE_BRICKS_CRACKED = registerBlock("packed_ice_bricks_cracked",
            new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));

    public static final Block PACKED_ICE_TILES = registerBlock("packed_ice_tiles",
            new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));

    public static final Block PACKED_ICE_TILES_CRACKED = registerBlock("packed_ice_tiles_cracked",
            new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));

    public static final Block SNOW_BRICKS = registerBlock("snow_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(0.2F)));

    public static final Block SNOW_BRICKS_CRACKED = registerBlock("snow_bricks_cracked",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(0.2F)));

    public static final Block SNOW_TILES = registerBlock("snow_tiles",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(0.2F)));

    public static final Block SNOW_TILES_CRACKED = registerBlock("snow_tiles_cracked",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(0.2F)));




    public static final Block TEST_BLOCK_ITEM = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "test_block_item"),
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).resistance(50.0F).hardness(50.0F)));

// Normal Flowers
    public static final Block AGAPANTHUS = registerFlower("agapanthus", DyeColor.GRAY, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_AGAPANTHUS = registerPottedFlower(AGAPANTHUS);
    public static final Block GLOW_AGAPANTHUS = registerGlowFlower(AGAPANTHUS, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_GLOW_AGAPANTHUS = registerPottedGlowFlower(AGAPANTHUS);

    public static final Block BLUE_COSMOS = registerFlower("blue_cosmos", DyeColor.LIGHT_BLUE, StatusEffects.SPEED, 160);
    public static final Block POTTED_BLUE_COSMOS = registerPottedFlower(BLUE_COSMOS);
    public static final Block GLOW_BLUE_COSMOS = registerGlowFlower(BLUE_COSMOS, StatusEffects.SPEED, 160);
    public static final Block POTTED_GLOW_BLUE_COSMOS = registerPottedGlowFlower(BLUE_COSMOS);

    public static final Block BONSAI = registerFlower("bonsai", DyeColor.GREEN, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_BONSAI = registerPottedFlower(BONSAI);
    public static final Block GLOW_BONSAI = registerGlowFlower(BONSAI, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_GLOW_BONSAI = registerPottedGlowFlower(BONSAI);

    public static final Block CARNATION = registerFlower("carnation", DyeColor.MAGENTA, StatusEffects.BAD_OMEN, 160);
    public static final Block POTTED_CARNATION = registerPottedFlower(CARNATION);
    public static final Block GLOW_CARNATION = registerGlowFlower(CARNATION, StatusEffects.BAD_OMEN, 160);
    public static final Block POTTED_GLOW_CARNATION = registerPottedGlowFlower(CARNATION);

    public static final Block DAFFODIL = registerFlower("daffodil", DyeColor.ORANGE, StatusEffects.LUCK, 160);
    public static final Block POTTED_DAFFODIL = registerPottedFlower(DAFFODIL);
    public static final Block GLOW_DAFFODIL = registerGlowFlower(DAFFODIL, StatusEffects.LUCK, 160);
    public static final Block POTTED_GLOW_DAFFODIL = registerPottedGlowFlower(DAFFODIL);

    public static final Block DAHLIA = registerFlower("dahlia", DyeColor.BROWN, StatusEffects.WITHER, 160);
    public static final Block POTTED_DAHLIA = registerPottedFlower(DAHLIA);
    public static final Block GLOW_DAHLIA = registerGlowFlower(DAHLIA, StatusEffects.WITHER, 160);
    public static final Block POTTED_GLOW_DAHLIA = registerPottedGlowFlower(DAHLIA);

    public static final Block DELPHINIUM = registerFlower("delphinium", DyeColor.BLUE, StatusEffects.LEVITATION, 160);
    public static final Block POTTED_DELPHINIUM = registerPottedFlower(DELPHINIUM);
    public static final Block GLOW_DELPHINIUM = registerGlowFlower(DELPHINIUM, StatusEffects.LEVITATION, 160);
    public static final Block POTTED_GLOW_DELPHINIUM = registerPottedGlowFlower(DELPHINIUM);

    public static final Block HAWTHORN = registerFlower("hawthorn", DyeColor.LIGHT_GRAY, ModEffects.CLEAR_NEGATIVE_EFFECT, 160);
    public static final Block POTTED_HAWTHORN = registerPottedFlower(HAWTHORN);
    public static final Block GLOW_HAWTHORN = registerGlowFlower(HAWTHORN, ModEffects.CLEAR_NEGATIVE_EFFECT, 160);
    public static final Block POTTED_GLOW_HAWTHORN = registerPottedGlowFlower(HAWTHORN);

    public static final Block HYDRANGEA = registerFlower("hydrangea", DyeColor.LIME, StatusEffects.NAUSEA, 160);
    public static final Block POTTED_HYDRANGEA = registerPottedFlower(HYDRANGEA);
    public static final Block GLOW_HYDRANGEA = registerGlowFlower(HYDRANGEA, StatusEffects.NAUSEA, 160);
    public static final Block POTTED_GLOW_HYDRANGEA = registerPottedGlowFlower(HYDRANGEA);

    public static final Block IRIS = registerFlower("iris", DyeColor.PINK, StatusEffects.GLOWING, 160);
    public static final Block POTTED_IRIS = registerPottedFlower(IRIS);
    public static final Block GLOW_IRIS = registerGlowFlower(IRIS, StatusEffects.GLOWING, 160);
    public static final Block POTTED_GLOW_IRIS = registerPottedGlowFlower(IRIS);

    public static final Block LARKSPUR = registerFlower("larkspur", DyeColor.CYAN, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_LARKSPUR = registerPottedFlower(LARKSPUR);
    public static final Block GLOW_LARKSPUR = registerGlowFlower(LARKSPUR, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_GLOW_LARKSPUR = registerPottedGlowFlower(LARKSPUR);

    public static final Block MIDNIGHT_MYSTIC = registerFlower("midnight_mystic", DyeColor.BLACK, ModEffects.DISORIENT, 160);
    public static final Block POTTED_MIDNIGHT_MYSTIC = registerPottedFlower(MIDNIGHT_MYSTIC);
    public static final Block GLOW_MIDNIGHT_MYSTIC = registerGlowFlower(MIDNIGHT_MYSTIC, ModEffects.DISORIENT, 160);
    public static final Block POTTED_GLOW_MIDNIGHT_MYSTIC = registerPottedGlowFlower(MIDNIGHT_MYSTIC);

    public static final Block PRIMROSE = registerFlower("primrose", DyeColor.YELLOW, StatusEffects.HASTE, 160);
    public static final Block POTTED_PRIMROSE = registerPottedFlower(PRIMROSE);
    public static final Block GLOW_PRIMROSE = registerGlowFlower(PRIMROSE, StatusEffects.HASTE, 160);
    public static final Block POTTED_GLOW_PRIMROSE = registerPottedGlowFlower(PRIMROSE);

    public static final Block SNOW_DROP = registerFlower("snow_drop", DyeColor.WHITE, ModEffects.FREAKY_BUNNY, 160);
    public static final Block POTTED_SNOW_DROP = registerPottedFlower(SNOW_DROP);
    public static final Block GLOW_SNOW_DROP = registerGlowFlower(SNOW_DROP, ModEffects.FREAKY_BUNNY, 160);
    public static final Block POTTED_GLOW_SNOW_DROP = registerPottedGlowFlower(SNOW_DROP);

    public static final Block SPIDERLILY = registerFlower("spiderlily", DyeColor.RED, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_SPIDERLILY = registerPottedFlower(SPIDERLILY);
    public static final Block GLOW_SPIDERLILY = registerGlowFlower(SPIDERLILY, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_GLOW_SPIDERLILY = registerPottedGlowFlower(SPIDERLILY);

    public static final Block VIOLET = registerFlower("violet", DyeColor.PURPLE, StatusEffects.POISON, 160);
    public static final Block POTTED_VIOLET = registerPottedFlower(VIOLET);
    public static final Block GLOW_VIOLET = registerGlowFlower(VIOLET, StatusEffects.POISON, 160);
    public static final Block POTTED_GLOW_VIOLET = registerPottedGlowFlower(VIOLET);

// Thorned Flowers
    public static final Block THORNED_AGAPANTHUS = registerThornedFlower(AGAPANTHUS, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_THORNED_AGAPANTHUS = registerPottedThornedFlower(AGAPANTHUS);
    public static final Block GLOW_THORNED_AGAPANTHUS = registerGlowThornedFlower(AGAPANTHUS, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_GLOW_THORNED_AGAPANTHUS = registerPottedGlowThornedFlower(AGAPANTHUS);

    public static final Block THORNED_BLUE_COSMOS = registerThornedFlower(BLUE_COSMOS, StatusEffects.SLOW_FALLING, 160);
    public static final Block POTTED_THORNED_BLUE_COSMOS = registerPottedThornedFlower(BLUE_COSMOS);
    public static final Block GLOW_THORNED_BLUE_COSMOS = registerGlowThornedFlower(BLUE_COSMOS, StatusEffects.SLOW_FALLING, 160);
    public static final Block POTTED_GLOW_THORNED_BLUE_COSMOS = registerPottedGlowThornedFlower(BLUE_COSMOS);

    public static final Block THORNED_BONSAI = registerThornedFlower(BONSAI, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_THORNED_BONSAI = registerPottedThornedFlower(BONSAI);
    public static final Block GLOW_THORNED_BONSAI = registerGlowThornedFlower(BONSAI, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_GLOW_THORNED_BONSAI = registerPottedGlowThornedFlower(BONSAI);

    public static final Block THORNED_CARNATION = registerThornedFlower(CARNATION, StatusEffects.BAD_OMEN, 160);
    public static final Block POTTED_THORNED_CARNATION = registerPottedThornedFlower(CARNATION);
    public static final Block GLOW_THORNED_CARNATION = registerGlowThornedFlower(CARNATION, StatusEffects.BAD_OMEN, 160);
    public static final Block POTTED_GLOW_THORNED_CARNATION = registerPottedGlowThornedFlower(CARNATION);

    public static final Block THORNED_DAFFODIL = registerThornedFlower(DAFFODIL, StatusEffects.UNLUCK, 160);
    public static final Block POTTED_THORNED_DAFFODIL = registerPottedThornedFlower(DAFFODIL);
    public static final Block GLOW_THORNED_DAFFODIL = registerGlowThornedFlower(DAFFODIL, StatusEffects.UNLUCK, 160);
    public static final Block POTTED_GLOW_THORNED_DAFFODIL = registerPottedGlowThornedFlower(DAFFODIL);

    public static final Block THORNED_DAHLIA = registerThornedFlower(DAHLIA, StatusEffects.WITHER, 160);
    public static final Block POTTED_THORNED_DAHLIA = registerPottedThornedFlower(DAHLIA);
    public static final Block GLOW_THORNED_DAHLIA = registerGlowThornedFlower(DAHLIA, StatusEffects.WITHER, 160);
    public static final Block POTTED_GLOW_THORNED_DAHLIA = registerPottedGlowThornedFlower(DAHLIA);

    public static final Block THORNED_DELPHINIUM = registerThornedFlower(DELPHINIUM, StatusEffects.LEVITATION, 160);
    public static final Block POTTED_THORNED_DELPHINIUM = registerPottedThornedFlower(DELPHINIUM);
    public static final Block GLOW_THORNED_DELPHINIUM = registerGlowThornedFlower(DELPHINIUM, StatusEffects.LEVITATION, 160);
    public static final Block POTTED_GLOW_THORNED_DELPHINIUM = registerPottedGlowThornedFlower(DELPHINIUM);

    public static final Block THORNED_HAWTHORN = registerThornedFlower(HAWTHORN, ModEffects.DISORIENT, 160);
    public static final Block POTTED_THORNED_HAWTHORN = registerPottedThornedFlower(HAWTHORN);
    public static final Block GLOW_THORNED_HAWTHORN = registerGlowThornedFlower(HAWTHORN, ModEffects.DISORIENT, 160);
    public static final Block POTTED_GLOW_THORNED_HAWTHORN = registerPottedGlowThornedFlower(HAWTHORN);

    public static final Block THORNED_HYDRANGEA = registerThornedFlower(HYDRANGEA, StatusEffects.NAUSEA, 160);
    public static final Block POTTED_THORNED_HYDRANGEA = registerPottedThornedFlower(HYDRANGEA);
    public static final Block GLOW_THORNED_HYDRANGEA = registerGlowThornedFlower(HYDRANGEA, StatusEffects.NAUSEA, 160);
    public static final Block POTTED_GLOW_THORNED_HYDRANGEA = registerPottedGlowThornedFlower(HYDRANGEA);

    public static final Block THORNED_IRIS = registerThornedFlower(IRIS, StatusEffects.BLINDNESS, 160);
    public static final Block POTTED_THORNED_IRIS = registerPottedThornedFlower(IRIS);
    public static final Block GLOW_THORNED_IRIS = registerGlowThornedFlower(IRIS, StatusEffects.BLINDNESS, 160);
    public static final Block POTTED_GLOW_THORNED_IRIS = registerPottedGlowThornedFlower(IRIS);

    public static final Block THORNED_LARKSPUR = registerThornedFlower(LARKSPUR, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_THORNED_LARKSPUR = registerPottedThornedFlower(LARKSPUR);
    public static final Block GLOW_THORNED_LARKSPUR = registerGlowThornedFlower(LARKSPUR, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_GLOW_THORNED_LARKSPUR = registerPottedGlowThornedFlower(LARKSPUR);

    public static final Block THORNED_MIDNIGHT_MYSTIC = registerThornedFlower(MIDNIGHT_MYSTIC, ModEffects.DISORIENT, 160);
    public static final Block POTTED_THORNED_MIDNIGHT_MYSTIC = registerPottedThornedFlower(MIDNIGHT_MYSTIC);
    public static final Block GLOW_THORNED_MIDNIGHT_MYSTIC = registerGlowThornedFlower(MIDNIGHT_MYSTIC, ModEffects.DISORIENT, 160);
    public static final Block POTTED_GLOW_THORNED_MIDNIGHT_MYSTIC = registerPottedGlowThornedFlower(MIDNIGHT_MYSTIC);

    public static final Block THORNED_PRIMROSE = registerThornedFlower(PRIMROSE, StatusEffects.SLOWNESS, 160);
    public static final Block POTTED_THORNED_PRIMROSE = registerPottedThornedFlower(PRIMROSE);
    public static final Block GLOW_THORNED_PRIMROSE = registerGlowThornedFlower(PRIMROSE, StatusEffects.SLOWNESS, 160);
    public static final Block POTTED_GLOW_THORNED_PRIMROSE = registerPottedGlowThornedFlower(PRIMROSE);

    public static final Block THORNED_SNOW_DROP = registerThornedFlower(SNOW_DROP, StatusEffects.WEAKNESS, 160);
    public static final Block POTTED_THORNED_SNOW_DROP = registerPottedThornedFlower(SNOW_DROP);
    public static final Block GLOW_THORNED_SNOW_DROP = registerGlowThornedFlower(SNOW_DROP, StatusEffects.WEAKNESS, 160);
    public static final Block POTTED_GLOW_THORNED_SNOW_DROP = registerPottedGlowThornedFlower(SNOW_DROP);

    public static final Block THORNED_SPIDERLILY = registerThornedFlower(SPIDERLILY, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_THORNED_SPIDERLILY = registerPottedThornedFlower(SPIDERLILY);
    public static final Block GLOW_THORNED_SPIDERLILY = registerGlowThornedFlower(SPIDERLILY, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_GLOW_THORNED_SPIDERLILY = registerPottedGlowThornedFlower(SPIDERLILY);

    public static final Block THORNED_VIOLET = registerThornedFlower(VIOLET, StatusEffects.HUNGER, 160);
    public static final Block POTTED_THORNED_VIOLET = registerPottedThornedFlower(VIOLET);
    public static final Block GLOW_THORNED_VIOLET = registerGlowThornedFlower(VIOLET, StatusEffects.HUNGER, 160);
    public static final Block POTTED_GLOW_THORNED_VIOLET = registerPottedGlowThornedFlower(VIOLET);

// Lush Flowers
    public static final Block LUSH_AGAPANTHUS = registerLushFlower(AGAPANTHUS, StatusEffects.STRENGTH, 160);
    public static final Block POTTED_LUSH_AGAPANTHUS = registerPottedLushFlower(AGAPANTHUS);
    public static final Block GLOW_LUSH_AGAPANTHUS = registerGlowLushFlower(AGAPANTHUS, StatusEffects.STRENGTH, 160);
    public static final Block POTTED_GLOW_LUSH_AGAPANTHUS = registerPottedGlowLushFlower(AGAPANTHUS);

    public static final Block LUSH_BLUE_COSMOS = registerLushFlower(BLUE_COSMOS, StatusEffects.SPEED, 160);
    public static final Block POTTED_LUSH_BLUE_COSMOS = registerPottedLushFlower(BLUE_COSMOS);
    public static final Block GLOW_LUSH_BLUE_COSMOS = registerGlowLushFlower(BLUE_COSMOS, StatusEffects.SPEED, 160);
    public static final Block POTTED_GLOW_LUSH_BLUE_COSMOS = registerPottedGlowLushFlower(BLUE_COSMOS);

    public static final Block LUSH_BONSAI = registerLushFlower(BONSAI, ModEffects.CLEAR_NEGATIVE_EFFECT, 160);
    public static final Block POTTED_LUSH_BONSAI = registerPottedLushFlower(BONSAI);
    public static final Block GLOW_LUSH_BONSAI = registerGlowLushFlower(BONSAI, ModEffects.CLEAR_NEGATIVE_EFFECT, 160);
    public static final Block POTTED_GLOW_LUSH_BONSAI = registerPottedGlowLushFlower(BONSAI);

    public static final Block LUSH_CARNATION = registerLushFlower(CARNATION, StatusEffects.HERO_OF_THE_VILLAGE, 160);
    public static final Block POTTED_LUSH_CARNATION = registerPottedLushFlower(CARNATION);
    public static final Block GLOW_LUSH_CARNATION = registerGlowLushFlower(CARNATION, StatusEffects.HERO_OF_THE_VILLAGE, 160);
    public static final Block POTTED_GLOW_LUSH_CARNATION = registerPottedGlowLushFlower(CARNATION);

    public static final Block LUSH_DAFFODIL = registerLushFlower(DAFFODIL, StatusEffects.LUCK, 160);
    public static final Block POTTED_LUSH_DAFFODIL = registerPottedLushFlower(DAFFODIL);
    public static final Block GLOW_LUSH_DAFFODIL = registerGlowLushFlower(DAFFODIL, StatusEffects.LUCK, 160);
    public static final Block POTTED_GLOW_LUSH_DAFFODIL = registerPottedGlowLushFlower(DAFFODIL);

    public static final Block LUSH_DAHLIA = registerLushFlower(DAHLIA, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_LUSH_DAHLIA = registerPottedLushFlower(DAHLIA);
    public static final Block GLOW_LUSH_DAHLIA = registerGlowLushFlower(DAHLIA, StatusEffects.REGENERATION, 160);
    public static final Block POTTED_GLOW_LUSH_DAHLIA = registerPottedGlowLushFlower(DAHLIA);

    public static final Block LUSH_DELPHINIUM = registerLushFlower(DELPHINIUM, StatusEffects.SLOW_FALLING, 160);
    public static final Block POTTED_LUSH_DELPHINIUM = registerPottedLushFlower(DELPHINIUM);
    public static final Block GLOW_LUSH_DELPHINIUM = registerGlowLushFlower(DELPHINIUM, StatusEffects.SLOW_FALLING, 160);
    public static final Block POTTED_GLOW_LUSH_DELPHINIUM = registerPottedGlowLushFlower(DELPHINIUM);

    public static final Block LUSH_HAWTHORN = registerLushFlower(HAWTHORN, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_LUSH_HAWTHORN = registerPottedLushFlower(HAWTHORN);
    public static final Block GLOW_LUSH_HAWTHORN = registerGlowLushFlower(HAWTHORN, ModEffects.CLEAR_POSITIVE_EFFECT, 160);
    public static final Block POTTED_GLOW_LUSH_HAWTHORN = registerPottedGlowLushFlower(HAWTHORN);

    public static final Block LUSH_HYDRANGEA = registerLushFlower(HYDRANGEA, StatusEffects.WATER_BREATHING, 160);
    public static final Block POTTED_LUSH_HYDRANGEA = registerPottedLushFlower(HYDRANGEA);
    public static final Block GLOW_LUSH_HYDRANGEA = registerGlowLushFlower(HYDRANGEA, StatusEffects.WATER_BREATHING, 160);
    public static final Block POTTED_GLOW_LUSH_HYDRANGEA = registerPottedGlowLushFlower(HYDRANGEA);

    public static final Block LUSH_IRIS = registerLushFlower(IRIS, StatusEffects.GLOWING, 160);
    public static final Block POTTED_LUSH_IRIS = registerPottedLushFlower(IRIS);
    public static final Block GLOW_LUSH_IRIS = registerGlowLushFlower(IRIS, StatusEffects.GLOWING, 160);
    public static final Block POTTED_GLOW_LUSH_IRIS = registerPottedGlowLushFlower(IRIS);

    public static final Block LUSH_LARKSPUR = registerLushFlower(LARKSPUR, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_LUSH_LARKSPUR = registerPottedLushFlower(LARKSPUR);
    public static final Block GLOW_LUSH_LARKSPUR = registerGlowLushFlower(LARKSPUR, StatusEffects.RESISTANCE, 160);
    public static final Block POTTED_GLOW_LUSH_LARKSPUR = registerPottedGlowLushFlower(LARKSPUR);

    public static final Block LUSH_MIDNIGHT_MYSTIC = registerLushFlower(MIDNIGHT_MYSTIC, ModEffects.FREAKY_BUNNY, 160);
    public static final Block POTTED_LUSH_MIDNIGHT_MYSTIC = registerPottedLushFlower(MIDNIGHT_MYSTIC);
    public static final Block GLOW_LUSH_MIDNIGHT_MYSTIC = registerGlowLushFlower(MIDNIGHT_MYSTIC, ModEffects.FREAKY_BUNNY, 160);
    public static final Block POTTED_GLOW_LUSH_MIDNIGHT_MYSTIC = registerPottedGlowLushFlower(MIDNIGHT_MYSTIC);

    public static final Block LUSH_PRIMROSE = registerLushFlower(PRIMROSE, StatusEffects.JUMP_BOOST, 160);
    public static final Block POTTED_LUSH_PRIMROSE = registerPottedLushFlower(PRIMROSE);
    public static final Block GLOW_LUSH_PRIMROSE = registerGlowLushFlower(PRIMROSE, StatusEffects.JUMP_BOOST, 160);
    public static final Block POTTED_GLOW_LUSH_PRIMROSE = registerPottedGlowLushFlower(PRIMROSE);

    public static final Block LUSH_SNOW_DROP = registerLushFlower(SNOW_DROP, StatusEffects.ABSORPTION, 160);
    public static final Block POTTED_LUSH_SNOW_DROP = registerPottedLushFlower(SNOW_DROP);
    public static final Block GLOW_LUSH_SNOW_DROP = registerGlowLushFlower(SNOW_DROP, StatusEffects.ABSORPTION, 160);
    public static final Block POTTED_GLOW_LUSH_SNOW_DROP = registerPottedGlowLushFlower(SNOW_DROP);

    public static final Block LUSH_SPIDERLILY = registerLushFlower(SPIDERLILY, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_LUSH_SPIDERLILY = registerPottedLushFlower(SPIDERLILY);
    public static final Block GLOW_LUSH_SPIDERLILY = registerGlowLushFlower(SPIDERLILY, ModEffects.STICKY_FEAT, 160);
    public static final Block POTTED_GLOW_LUSH_SPIDERLILY = registerPottedGlowLushFlower(SPIDERLILY);

    public static final Block LUSH_VIOLET = registerLushFlower(VIOLET, StatusEffects.NIGHT_VISION, 160);
    public static final Block POTTED_LUSH_VIOLET = registerPottedLushFlower(VIOLET);
    public static final Block GLOW_LUSH_VIOLET = registerGlowLushFlower(VIOLET, StatusEffects.NIGHT_VISION, 160);
    public static final Block POTTED_GLOW_LUSH_VIOLET = registerPottedGlowLushFlower(VIOLET);


    private static Block registerDyedWaterCauldron(DyeColor color) {
        DyedWaterCauldronBlock block = new DyedWaterCauldronBlock(FabricBlockSettings.copyOf(Blocks.WATER_CAULDRON), color);
        COLOR_TO_WATER_CAULDRON.put(color, block);
        return registerBlock(color.getName() + "_water_cauldron", block);
    }

    private static Block registerDyedLavaCauldron(DyeColor color) {
        DyedLavaCauldronBlock block = new DyedLavaCauldronBlock(FabricBlockSettings.copyOf(Blocks.LAVA_CAULDRON).luminance(15), color);
        COLOR_TO_LAVA_CAULDRON.put(color, block);
        return registerBlock(color.getName() + "_lava_cauldron", block);
    }

    private static Block registerCobbledConcrete(DyeColor color) {
        Block block = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE));
        COLOR_TO_COBBLED_CONCRETE.put(color, block);
        return registerBlock(color.getName() + "_cobbled_concrete", block);
    }

    private static Block registerCobbledConcretePowder(DyeColor color, Block hardened) {
        Block block = new ConcretePowderBlock(hardened, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER));
        COLOR_TO_COBBLED_CONCRETE_POWDER.put(color, block);
        return registerBlock(color.getName() + "_cobbled_concrete_powder", block);
    }

    private static Block registerArcaneBlock(StatusEffect effect, Function<Integer, StatusEffectInstance> signalStrengthToEffect) {
        return registerBlock("arcane_" + effect.getName().getString() + "_block",
                new ArcaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F), signalStrengthToEffect));
    }

    private static Block registerDyedAetherCoil(DyeColor color, MapColor mapColor) {
        AetherBlock block = new AetherBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50, 2400)
                .nonOpaque().velocityMultiplier(1.25F).mapColor(mapColor));
        COLOR_TO_AETHER_COIL.put(color, block);
        return registerBlock("aether_coil_" + color.getName(), block);
    }

    private static Block registerFlower(String name, DyeColor color, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision());
        COLOR_TO_FLOWER.put(color, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, name),
                block);
    }

    private static Block registerPottedFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(flower, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque());
        FLOWER_TO_POTTED_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerGlowFlower(Block flower, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision());
        FLOWER_TO_GLOW_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "glow_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerPottedGlowFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(FLOWER_TO_GLOW_FLOWER.get(flower), FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque());
        FLOWER_TO_POTTED_GLOW_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_glow_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerThornedFlower(Block flower, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision());
        FLOWER_TO_THORNED_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "thorned_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerPottedThornedFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(FLOWER_TO_THORNED_FLOWER.get(flower), FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque());
        FLOWER_TO_POTTED_THORNED_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_thorned_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerGlowThornedFlower(Block flower, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision());
        FLOWER_TO_GLOW_THORNED_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "glow_thorned_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerPottedGlowThornedFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(FLOWER_TO_GLOW_THORNED_FLOWER.get(flower), FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque());
        FLOWER_TO_POTTED_GLOW_THORNED_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_glow_thorned_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerLushFlower(Block flower, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision());
        FLOWER_TO_LUSH_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "lush_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerPottedLushFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(FLOWER_TO_LUSH_FLOWER.get(flower), FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque());
        FLOWER_TO_POTTED_LUSH_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_lush_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerGlowLushFlower(Block flower, StatusEffect suspiciousStewEffect, int effectDuration) {
        FlowerBlock block = new FlowerBlock(suspiciousStewEffect, effectDuration, FabricBlockSettings.copyOf(Blocks.ALLIUM).luminance(15).nonOpaque().noCollision());
        FLOWER_TO_GLOW_LUSH_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "glow_lush_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerPottedGlowLushFlower(Block flower) {
        FlowerPotBlock block = new FlowerPotBlock(FLOWER_TO_GLOW_LUSH_FLOWER.get(flower), FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).luminance(15).nonOpaque());
        FLOWER_TO_POTTED_GLOW_LUSH_FLOWER.put(flower, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(Steamcraft.MOD_ID, "potted_glow_lush_" + Registries.BLOCK.getId(flower).getPath()),
                block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Steamcraft.LOGGER.info("Registering ModBlocks");
    }
}
