package net.spacegateir.steamcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.arcane.*;
import net.spacegateir.steamcraft.block.cauldronblocks.*;
import net.spacegateir.steamcraft.block.custom.*;
import net.spacegateir.steamcraft.block.naturalblocks.*;
import net.spacegateir.steamcraft.block.path_blocks.*;
import net.spacegateir.steamcraft.block.traps.*;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.EnumMap;
import java.util.function.Function;


public class ModBlocks {

    public static final EnumMap<DyeColor, Block> COLOR_TO_LAVA_CAULDRON = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> COLOR_TO_WATER_CAULDRON = new EnumMap<>(DyeColor.class);

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

    public static final Block RAW_SILVER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "raw_silver_block"),
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final Block SILVER_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "silver_block"),
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    public static final Block FOOLS_GOLD_RAW_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "fools_gold_raw_block"),
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final Block FOOLS_GOLD_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "fools_gold_block"),
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    public static final Block DIVINITITE_ALLOY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "divinitite_alloy_block"),
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).nonOpaque()
                    .luminance(state -> 15)));

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

    public static final Block ARCANE_CONDUIT_POWER_BLOCK = registerArcaneBlock(StatusEffects.CONDUIT_POWER, signalStrength ->
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

    public static final Block COBBLED_WHITE_CONCRETE = registerBlock("cobbled_white_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));
    public static final Block COBBLED_WHITE_CONCRETE_POWDER = registerBlock("cobbled_white_concrete_powder",
            new ConcretePowderBlock(COBBLED_WHITE_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER)));

    public static final Block COBBLED_LIGHT_GRAY_CONCRETE = registerBlock("cobbled_light_gray_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block COBBLED_LIGHT_GRAY_CONCRETE_POWDER = registerBlock("cobbled_light_gray_concrete_powder",
            new ConcretePowderBlock(COBBLED_LIGHT_GRAY_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE_POWDER)));

    public static final Block COBBLED_GRAY_CONCRETE = registerBlock("cobbled_gray_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE)));
    public static final Block COBBLED_GRAY_CONCRETE_POWDER = registerBlock("cobbled_gray_concrete_powder",
            new ConcretePowderBlock(COBBLED_GRAY_CONCRETE, FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE_POWDER)));

    public static final Block COBBLED_BLACK_CONCRETE = registerBlock("cobbled_black_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block COBBLED_BLACK_CONCRETE_POWDER = registerBlock("cobbled_black_concrete_powder",
            new ConcretePowderBlock(COBBLED_BLACK_CONCRETE, FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE_POWDER)));

    public static final Block COBBLED_BROWN_CONCRETE = registerBlock("cobbled_brown_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE)));
    public static final Block COBBLED_BROWN_CONCRETE_POWDER = registerBlock("cobbled_brown_concrete_powder",
            new ConcretePowderBlock(COBBLED_BROWN_CONCRETE, FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE_POWDER)));

    public static final Block COBBLED_RED_CONCRETE = registerBlock("cobbled_red_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE)));
    public static final Block COBBLED_RED_CONCRETE_POWDER = registerBlock("cobbled_red_concrete_powder",
            new ConcretePowderBlock(COBBLED_RED_CONCRETE, FabricBlockSettings.copyOf(Blocks.RED_CONCRETE_POWDER)));

    public static final Block COBBLED_ORANGE_CONCRETE = registerBlock("cobbled_orange_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE)));
    public static final Block COBBLED_ORANGE_CONCRETE_POWDER = registerBlock("cobbled_orange_concrete_powder",
            new ConcretePowderBlock(COBBLED_ORANGE_CONCRETE, FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE_POWDER)));

    public static final Block COBBLED_YELLOW_CONCRETE = registerBlock("cobbled_yellow_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE)));
    public static final Block COBBLED_YELLOW_CONCRETE_POWDER = registerBlock("cobbled_yellow_concrete_powder",
            new ConcretePowderBlock(COBBLED_YELLOW_CONCRETE, FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE_POWDER)));

    public static final Block COBBLED_LIME_CONCRETE = registerBlock("cobbled_lime_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE)));
    public static final Block COBBLED_LIME_CONCRETE_POWDER = registerBlock("cobbled_lime_concrete_powder",
            new ConcretePowderBlock(COBBLED_LIME_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE_POWDER)));

    public static final Block COBBLED_GREEN_CONCRETE = registerBlock("cobbled_green_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE)));
    public static final Block COBBLED_GREEN_CONCRETE_POWDER = registerBlock("cobbled_green_concrete_powder",
            new ConcretePowderBlock(COBBLED_GREEN_CONCRETE, FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE_POWDER)));

    public static final Block COBBLED_CYAN_CONCRETE = registerBlock("cobbled_cyan_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE)));
    public static final Block COBBLED_CYAN_CONCRETE_POWDER = registerBlock("cobbled_cyan_concrete_powder",
            new ConcretePowderBlock(COBBLED_CYAN_CONCRETE, FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE_POWDER)));

    public static final Block COBBLED_LIGHT_BLUE_CONCRETE = registerBlock("cobbled_light_blue_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block COBBLED_LIGHT_BLUE_CONCRETE_POWDER = registerBlock("cobbled_light_blue_concrete_powder",
            new ConcretePowderBlock(COBBLED_LIGHT_BLUE_CONCRETE, FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE_POWDER)));

    public static final Block COBBLED_BLUE_CONCRETE = registerBlock("cobbled_blue_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE)));
    public static final Block COBBLED_BLUE_CONCRETE_POWDER = registerBlock("cobbled_blue_concrete_powder",
            new ConcretePowderBlock(COBBLED_BLUE_CONCRETE, FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE_POWDER)));

    public static final Block COBBLED_PURPLE_CONCRETE = registerBlock("cobbled_purple_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE)));
    public static final Block COBBLED_PURPLE_CONCRETE_POWDER = registerBlock("cobbled_purple_concrete_powder",
            new ConcretePowderBlock(COBBLED_PURPLE_CONCRETE, FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE_POWDER)));

    public static final Block COBBLED_MAGENTA_CONCRETE = registerBlock("cobbled_magenta_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE)));
    public static final Block COBBLED_MAGENTA_CONCRETE_POWDER = registerBlock("cobbled_magenta_concrete_powder",
            new ConcretePowderBlock(COBBLED_MAGENTA_CONCRETE, FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE_POWDER)));

    public static final Block COBBLED_PINK_CONCRETE = registerBlock("cobbled_pink_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE)));
    public static final Block COBBLED_PINK_CONCRETE_POWDER = registerBlock("cobbled_pink_concrete_powder",
            new ConcretePowderBlock(COBBLED_PINK_CONCRETE, FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE_POWDER)));




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

    public static final Block GLIMMERSTONE_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_block"),
            new GlimmerstoneBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block GLIMMERSTONE_STAIR_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_stair_block"),
            new GlimmerstoneStairsBlock(ModBlocks.GLIMMERSTONE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block GLIMMERSTONE_SLAB_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_slab_block"),
            new GlimmerstoneSlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block GLIMMERSTONE_WALL_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_wall_block"),
            new GlimmerstoneWallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block GLIMMERSTONE_COBBLESTONE_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_cobblestone_block"),
            new GlimmerstoneBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_cobblestone_stair_block"),
            new GlimmerstoneStairsBlock(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_cobblestone_slab_block"),
            new GlimmerstoneSlabBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block GLIMMERSTONE_COBBLESTONE_WALL_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_cobblestone_wall_block"),
            new GlimmerstoneWallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));

    public static final Block GLIMMERSTONE_BRICKS_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_bricks_block"),
            new GlimmerstoneBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block GLIMMERSTONE_BRICKS_STAIR_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_bricks_stair_block"),
            new GlimmerstoneStairsBlock(ModBlocks.GLIMMERSTONE_BRICKS_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block GLIMMERSTONE_BRICKS_SLAB_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_bricks_slab_block"),
            new GlimmerstoneSlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block GLIMMERSTONE_BRICKS_WALL_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_bricks_wall_block"),
            new GlimmerstoneWallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block GLIMMERSTONE_PILLAR_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_pillar_block"),
            new GlimmerstoneBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block GLIMMERSTONE_ENGRAVED_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "glimmerstone/glimmerstone_engraved_block"),
            new GlimmerstoneBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block ANCIENT_GRAVEL_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_gravel_block"),
            new ModGravelBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL)));

    public static final Block ANCIENT_MUD_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_mud_block"),
            new ModMudBlock(FabricBlockSettings.copyOf(Blocks.MUD)));

    public static final Block ANCIENT_CLAY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_clay_block"),
            new ModClayBlock(FabricBlockSettings.copyOf(Blocks.PACKED_MUD)));

    public static final Block ANCIENT_MOIST_CLAY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_moist_clay_block"),
            new ModClayBlock(FabricBlockSettings.copyOf(Blocks.PACKED_MUD)));

    public static final Block ANCIENT_SAND_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_sand_block"),
            new ModSandBlock(0xB8775B, FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Block ANCIENT_SILT_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_silt_block"),
            new ModSiltBlock(FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Block ANCIENT_LOAM_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "ancient_loam_block"),
            new ModLoamBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT)));

    // Crops
    public static final Block AGAPANTHUS_CROP = registerBlockWithoutBlockItem("agapanthus_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_AGAPANTHUS_CROP = registerBlockWithoutBlockItem("lush_agapanthus_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_AGAPANTHUS_CROP = registerBlockWithoutBlockItem("thorned_agapanthus_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block BLUE_COSMOS_CROP = registerBlockWithoutBlockItem("blue_cosmos_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_BLUE_COSMOS_CROP = registerBlockWithoutBlockItem("lush_blue_cosmos_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_BLUE_COSMOS_CROP = registerBlockWithoutBlockItem("thorned_blue_cosmos_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block BONSAI_CROP = registerBlockWithoutBlockItem("bonsai_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_BONSAI_CROP = registerBlockWithoutBlockItem("lush_bonsai_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_BONSAI_CROP = registerBlockWithoutBlockItem("thorned_bonsai_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block CARNATION_CROP = registerBlockWithoutBlockItem("carnation_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_CARNATION_CROP = registerBlockWithoutBlockItem("lush_carnation_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_CARNATION_CROP = registerBlockWithoutBlockItem("thorned_carnation_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block DAFFODIL_CROP = registerBlockWithoutBlockItem("daffodil_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_DAFFODIL_CROP = registerBlockWithoutBlockItem("lush_daffodil_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_DAFFODIL_CROP = registerBlockWithoutBlockItem("thorned_daffodil_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block DAHLIA_CROP = registerBlockWithoutBlockItem("dahlia_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_DAHLIA_CROP = registerBlockWithoutBlockItem("lush_dahlia_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_DAHLIA_CROP = registerBlockWithoutBlockItem("thorned_dahlia_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block DELPHINIUM_CROP = registerBlockWithoutBlockItem("delphinium_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_DELPHINIUM_CROP = registerBlockWithoutBlockItem("lush_delphinium_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_DELPHINIUM_CROP = registerBlockWithoutBlockItem("thorned_delphinium_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block HAWTHORN_CROP = registerBlockWithoutBlockItem("hawthorn_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_HAWTHORN_CROP = registerBlockWithoutBlockItem("lush_hawthorn_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_HAWTHORN_CROP = registerBlockWithoutBlockItem("thorned_hawthorn_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block HYDRANGEA_CROP = registerBlockWithoutBlockItem("hydrangea_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_HYDRANGEA_CROP = registerBlockWithoutBlockItem("lush_hydrangea_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_HYDRANGEA_CROP = registerBlockWithoutBlockItem("thorned_hydrangea_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block IRIS_CROP = registerBlockWithoutBlockItem("iris_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_IRIS_CROP = registerBlockWithoutBlockItem("lush_iris_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_IRIS_CROP = registerBlockWithoutBlockItem("thorned_iris_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block LARKSPUR_CROP = registerBlockWithoutBlockItem("larkspur_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_LARKSPUR_CROP = registerBlockWithoutBlockItem("lush_larkspur_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_LARKSPUR_CROP = registerBlockWithoutBlockItem("thorned_larkspur_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));

    public static final Block MIDNIGHT_MYSTIC_CROP = registerBlockWithoutBlockItem("midnight_mystic_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_MIDNIGHT_MYSTIC_CROP = registerBlockWithoutBlockItem("lush_midnight_mystic_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_MIDNIGHT_MYSTIC_CROP = registerBlockWithoutBlockItem("thorned_midnight_mystic_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block PRIMROSE_CROP = registerBlockWithoutBlockItem("primrose_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_PRIMROSE_CROP = registerBlockWithoutBlockItem("lush_primrose_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_PRIMROSE_CROP = registerBlockWithoutBlockItem("thorned_primrose_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block SNOW_DROP_CROP = registerBlockWithoutBlockItem("snow_drop_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_SNOW_DROP_CROP = registerBlockWithoutBlockItem("lush_snow_drop_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_SNOW_DROP_CROP = registerBlockWithoutBlockItem("thorned_snow_drop_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block SPIDERLILY_CROP = registerBlockWithoutBlockItem("spiderlily_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_SPIDERLILY_CROP = registerBlockWithoutBlockItem("lush_spiderlily_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_SPIDERLILY_CROP = registerBlockWithoutBlockItem("thorned_spiderlily_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));

    public static final Block VIOLET_CROP = registerBlockWithoutBlockItem("violet_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block LUSH_VIOLET_CROP = registerBlockWithoutBlockItem("lush_violet_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),false));
    public static final Block THORNED_VIOLET_CROP = registerBlockWithoutBlockItem("thorned_violet_crop",
            new ModCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT),true));



    public static final Block PARTICIPATION_TROPHY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "participation_trophy_block"),
            new PlackBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque()));

    public static final Block COPPER_TROPHY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "copper_trophy_block"),
            new TrophyBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque()));
    public static final Block SILVER_TROPHY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "silver_trophy_block"),
            new TrophyBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque()));
    public static final Block GOLD_TROPHY_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "gold_trophy_block"),
            new TrophyFireBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque().luminance(state -> 15)));

    public static final Block MORTAR_AND_PESTLE_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "mortar_and_pestle_block"),
            new MortarAndPestleBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));

    public static final Block MEDKIT = registerBlock("medkit",
            new MedkitBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block PAN = registerBlock("pan",
            new PanBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block POT = registerBlock("pot",
            new PotBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block GAMEBOARD_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "gameboard_block"),
            new GameBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));

    public static final Block FARMLAND_ENRICHED_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "farmland_enriched_block"),
            new ModFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND)
                    .blockVision(Blocks::always).suffocates(Blocks::always)));

    public static final Block EARTH_SPIKE_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "earth_spike_block"),
            new EarthSpikeBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .nonOpaque().solid().noCollision().pistonBehavior(PistonBehavior.DESTROY).strength(-1.0F, -1.0F)
                    .dropsNothing().allowsSpawning(Blocks::never)));
    public static final Block EARTH_WALL_BLOCK = Registry.register(Registries.BLOCK,
            new Identifier(Steamcraft.MOD_ID, "earth_wall_block"),
            new EarthWallBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .nonOpaque().solid().noCollision().pistonBehavior(PistonBehavior.DESTROY).strength(-1.0F, -1.0F)
                    .dropsNothing().allowsSpawning(Blocks::never)));



    private static Block registerArcaneBlock(StatusEffect effect, Function<Integer, StatusEffectInstance> signalStrengthToEffect) {
        Identifier id = Registries.STATUS_EFFECT.getId(effect);
        String path = id != null ? id.getPath() : "unknown";
        return registerBlock("arcane_" + path + "_block",
                new ArcaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                        .allowsSpawning(Blocks::never)
                        .resistance(50.0F)
                        .hardness(50.0F),
                        signalStrengthToEffect));
    }

    private static Block registerDyedWaterCauldron(DyeColor color) {
        DyedWaterCauldronBlock block = new DyedWaterCauldronBlock(FabricBlockSettings.copyOf(Blocks.WATER_CAULDRON), color);
        COLOR_TO_WATER_CAULDRON.put(color, block);
        return registerBlock(color.getName() + "_water_cauldron_block", block);
    }

    private static Block registerDyedLavaCauldron(DyeColor color) {
        DyedLavaCauldronBlock block = new DyedLavaCauldronBlock(FabricBlockSettings.copyOf(Blocks.LAVA_CAULDRON).luminance(15), color);
        COLOR_TO_LAVA_CAULDRON.put(color, block);
        return registerBlock(color.getName() + "_lava_cauldron_block", block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerCropData() {
        ModCropData.register(AGAPANTHUS_CROP, ModItems.AGAPANTHUS_SEED, ModItems.AGAPANTHUS_FLOWER_ITEM);
        ModCropData.register(LUSH_AGAPANTHUS_CROP, ModItems.LUSH_AGAPANTHUS_SEED, ModItems.LUSH_AGAPANTHUS_FLOWER_ITEM);
        ModCropData.register(THORNED_AGAPANTHUS_CROP, ModItems.THORNED_AGAPANTHUS_SEED, ModItems.THORNED_AGAPANTHUS_FLOWER_ITEM);

        ModCropData.register(BLUE_COSMOS_CROP, ModItems.BLUE_COSMOS_SEED, ModItems.BLUE_COSMOS_FLOWER_ITEM);
        ModCropData.register(LUSH_BLUE_COSMOS_CROP, ModItems.LUSH_BLUE_COSMOS_SEED, ModItems.LUSH_BLUE_COSMOS_FLOWER_ITEM);
        ModCropData.register(THORNED_BLUE_COSMOS_CROP, ModItems.THORNED_BLUE_COSMOS_SEED, ModItems.THORNED_BLUE_COSMOS_FLOWER_ITEM);

        ModCropData.register(BONSAI_CROP, ModItems.BONSAI_SEED, ModItems.BONSAI_FLOWER_ITEM);
        ModCropData.register(LUSH_BONSAI_CROP, ModItems.LUSH_BONSAI_SEED, ModItems.LUSH_BONSAI_FLOWER_ITEM);
        ModCropData.register(THORNED_BONSAI_CROP, ModItems.THORNED_BONSAI_SEED, ModItems.THORNED_BONSAI_FLOWER_ITEM);

        ModCropData.register(CARNATION_CROP, ModItems.CARNATION_SEED, ModItems.CARNATION_FLOWER_ITEM);
        ModCropData.register(LUSH_CARNATION_CROP, ModItems.LUSH_CARNATION_SEED, ModItems.LUSH_CARNATION_FLOWER_ITEM);
        ModCropData.register(THORNED_CARNATION_CROP, ModItems.THORNED_CARNATION_SEED, ModItems.THORNED_CARNATION_FLOWER_ITEM);

        ModCropData.register(DAFFODIL_CROP, ModItems.DAFFODIL_SEED, ModItems.DAFFODIL_FLOWER_ITEM);
        ModCropData.register(LUSH_DAFFODIL_CROP, ModItems.LUSH_DAFFODIL_SEED, ModItems.LUSH_DAFFODIL_FLOWER_ITEM);
        ModCropData.register(THORNED_DAFFODIL_CROP, ModItems.THORNED_DAFFODIL_SEED, ModItems.THORNED_DAFFODIL_FLOWER_ITEM);

        ModCropData.register(DAHLIA_CROP, ModItems.DAHLIA_SEED, ModItems.DAHLIA_FLOWER_ITEM);
        ModCropData.register(LUSH_DAHLIA_CROP, ModItems.LUSH_DAHLIA_SEED, ModItems.LUSH_DAHLIA_FLOWER_ITEM);
        ModCropData.register(THORNED_DAHLIA_CROP, ModItems.THORNED_DAHLIA_SEED, ModItems.THORNED_DAHLIA_FLOWER_ITEM);

        ModCropData.register(DELPHINIUM_CROP, ModItems.DELPHINIUM_SEED, ModItems.DELPHINIUM_FLOWER_ITEM);
        ModCropData.register(LUSH_DELPHINIUM_CROP, ModItems.LUSH_DELPHINIUM_SEED, ModItems.LUSH_DELPHINIUM_FLOWER_ITEM);
        ModCropData.register(THORNED_DELPHINIUM_CROP, ModItems.THORNED_DELPHINIUM_SEED, ModItems.THORNED_DELPHINIUM_FLOWER_ITEM);

        ModCropData.register(HAWTHORN_CROP, ModItems.HAWTHORN_SEED, ModItems.HAWTHORN_FLOWER_ITEM);
        ModCropData.register(LUSH_HAWTHORN_CROP, ModItems.LUSH_HAWTHORN_SEED, ModItems.LUSH_HAWTHORN_FLOWER_ITEM);
        ModCropData.register(THORNED_HAWTHORN_CROP, ModItems.THORNED_HAWTHORN_SEED, ModItems.THORNED_HAWTHORN_FLOWER_ITEM);

        ModCropData.register(HYDRANGEA_CROP, ModItems.HYDRANGEA_SEED, ModItems.HYDRANGEA_FLOWER_ITEM);
        ModCropData.register(LUSH_HYDRANGEA_CROP, ModItems.LUSH_HYDRANGEA_SEED, ModItems.LUSH_HYDRANGEA_FLOWER_ITEM);
        ModCropData.register(THORNED_HYDRANGEA_CROP, ModItems.THORNED_HYDRANGEA_SEED, ModItems.THORNED_HYDRANGEA_FLOWER_ITEM);

        ModCropData.register(IRIS_CROP, ModItems.IRIS_SEED, ModItems.IRIS_FLOWER_ITEM);
        ModCropData.register(LUSH_IRIS_CROP, ModItems.LUSH_IRIS_SEED, ModItems.LUSH_IRIS_FLOWER_ITEM);
        ModCropData.register(THORNED_IRIS_CROP, ModItems.THORNED_IRIS_SEED, ModItems.THORNED_IRIS_FLOWER_ITEM);

        ModCropData.register(LARKSPUR_CROP, ModItems.LARKSPUR_SEED, ModItems.LARKSPUR_FLOWER_ITEM);
        ModCropData.register(LUSH_LARKSPUR_CROP, ModItems.LUSH_LARKSPUR_SEED, ModItems.LUSH_LARKSPUR_FLOWER_ITEM);
        ModCropData.register(THORNED_LARKSPUR_CROP, ModItems.THORNED_LARKSPUR_SEED, ModItems.THORNED_LARKSPUR_FLOWER_ITEM);

        ModCropData.register(MIDNIGHT_MYSTIC_CROP, ModItems.MIDNIGHT_MYSTIC_SEED, ModItems.MIDNIGHT_MYSTIC_FLOWER_ITEM);
        ModCropData.register(LUSH_MIDNIGHT_MYSTIC_CROP, ModItems.LUSH_MIDNIGHT_MYSTIC_SEED, ModItems.LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM);
        ModCropData.register(THORNED_MIDNIGHT_MYSTIC_CROP, ModItems.THORNED_MIDNIGHT_MYSTIC_SEED, ModItems.THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM);

        ModCropData.register(PRIMROSE_CROP, ModItems.PRIMROSE_SEED, ModItems.PRIMROSE_FLOWER_ITEM);
        ModCropData.register(LUSH_PRIMROSE_CROP, ModItems.LUSH_PRIMROSE_SEED, ModItems.LUSH_PRIMROSE_FLOWER_ITEM);
        ModCropData.register(THORNED_PRIMROSE_CROP, ModItems.THORNED_PRIMROSE_SEED, ModItems.THORNED_PRIMROSE_FLOWER_ITEM);

        ModCropData.register(SNOW_DROP_CROP, ModItems.SNOW_DROP_SEED, ModItems.SNOW_DROP_FLOWER_ITEM);
        ModCropData.register(LUSH_SNOW_DROP_CROP, ModItems.LUSH_SNOW_DROP_SEED, ModItems.LUSH_SNOW_DROP_FLOWER_ITEM);
        ModCropData.register(THORNED_SNOW_DROP_CROP, ModItems.THORNED_SNOW_DROP_SEED, ModItems.THORNED_SNOW_DROP_FLOWER_ITEM);

        ModCropData.register(SPIDERLILY_CROP, ModItems.SPIDERLILY_SEED, ModItems.SPIDERLILY_FLOWER_ITEM);
        ModCropData.register(LUSH_SPIDERLILY_CROP, ModItems.LUSH_SPIDERLILY_SEED, ModItems.LUSH_SPIDERLILY_FLOWER_ITEM);
        ModCropData.register(THORNED_SPIDERLILY_CROP, ModItems.THORNED_SPIDERLILY_SEED, ModItems.THORNED_SPIDERLILY_FLOWER_ITEM);

        ModCropData.register(VIOLET_CROP, ModItems.VIOLET_SEED, ModItems.VIOLET_FLOWER_ITEM);
        ModCropData.register(LUSH_VIOLET_CROP, ModItems.LUSH_VIOLET_SEED, ModItems.LUSH_VIOLET_FLOWER_ITEM);
        ModCropData.register(THORNED_VIOLET_CROP, ModItems.THORNED_VIOLET_SEED, ModItems.THORNED_VIOLET_FLOWER_ITEM);
    }


    public static void registerModBlocks() {
        Steamcraft.LOGGER.info("Registering ModBlocks for " + Steamcraft.MOD_ID);
    }
}
