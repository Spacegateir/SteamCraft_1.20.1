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
import net.spacegateir.steamcraft.block.arcane.*;
import net.spacegateir.steamcraft.block.arcane_specal.*;
import net.spacegateir.steamcraft.block.custom.*;
import net.spacegateir.steamcraft.block.traps.*;
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
    public static final Block SNOW_PATH = registerBlock("snow_path",
            new SnowPathBlock(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).velocityMultiplier(1.25F)));

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

    public static final Block ARCANE_ABSORPTION_BLOCK = registerBlock("arcane_absorption_block",
            new ArcaneAbsorptionBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_BAD_OMEN_BLOCK = registerBlock("arcane_bad_omen_block",
            new ArcaneBadOmenBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_BLINDNESS_BLOCK = registerBlock("arcane_blindness_block",
            new ArcaneBlindnessBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_CONDUIT_BLOCK = registerBlock("arcane_conduit_block",
            new ArcaneConduitBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_DARKNESS_BLOCK = registerBlock("arcane_darkness_block",
            new ArcaneDarknessBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_DOLPHINS_GRACE_BLOCK = registerBlock("arcane_dolphins_grace_block",
            new ArcaneDolphinsGraceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_FIRE_RESISTANCE_BLOCK = registerBlock("arcane_fire_resistance_block",
            new ArcaneFireResistanceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_GLOWING_BLOCK = registerBlock("arcane_glowing_block",
            new ArcaneGlowingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_HASTE_BLOCK = registerBlock("arcane_haste_block",
            new ArcaneHasteBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_HEALTH_BOOST_BLOCK = registerBlock("arcane_health_boost_block",
            new ArcaneHealthBoostBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_HERO_OF_THE_VILLAGE_BLOCK = registerBlock("arcane_hero_of_the_village_block",
            new ArcaneHeroOfTheVillageBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_INSTANT_DAMAGE_BLOCK = registerBlock("arcane_instant_damage_block",
            new ArcaneInstantDamageBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_INSTANT_HEALTH_BLOCK = registerBlock("arcane_instant_health_block",
            new ArcaneInstantHealthBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_INVISIBILITY_BLOCK = registerBlock("arcane_invisibility_block",
            new ArcaneInvisibilityBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_JUMP_BOOST_BLOCK = registerBlock("arcane_jump_boost_block",
            new ArcaneJumpBoostBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_LEVITATION_BLOCK = registerBlock("arcane_levitation_block",
            new ArcaneLevitationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_LUCK_BLOCK = registerBlock("arcane_luck_block",
            new ArcaneLuckBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_MINING_FATIGUE_BLOCK = registerBlock("arcane_mining_fatigue_block",
            new ArcaneMiningFatigueBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_NEAUSEA_BLOCK = registerBlock("arcane_neausea_block",
            new ArcaneNeauseaBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_NIGHT_VISION_BLOCK = registerBlock("arcane_night_vision_block",
            new ArcaneNightVisionBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_POISION_BLOCK = registerBlock("arcane_poision_block",
            new ArcanePoisionBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_REGENERATION_BLOCK = registerBlock("arcane_regeneration_block",
            new ArcaneRegenerationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_RESISTANCE_BLOCK = registerBlock("arcane_resistance_block",
            new ArcaneResistanceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_SATUATION_BLOCK = registerBlock("arcane_satuation_block",
            new ArcaneSatuationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_SLOW_FALL_BLOCK = registerBlock("arcane_slow_fall_block",
            new ArcaneSlowFallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_SLOWNESS_BLOCK = registerBlock("arcane_slowness_block",
            new ArcaneSlownessBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_SPEED_BLOCK = registerBlock("arcane_speed_block",
            new ArcaneSpeedBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_STARVING_BLOCK = registerBlock("arcane_starving_block",
            new ArcaneStarvingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_STRENGTH_BLOCK = registerBlock("arcane_strength_block",
            new ArcaneStrengthBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_UNLUCK_BLOCK = registerBlock("arcane_unluck_block",
            new ArcaneUnluckBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_WATER_BREATHING_BLOCK = registerBlock("arcane_water_breathing_block",
            new ArcaneWaterBreathingBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_WEAKNESS_BLOCK = registerBlock("arcane_weakness_block",
            new ArcaneWeaknessBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_WITHER_BLOCK = registerBlock("arcane_wither_block",
            new ArcaneWitherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));



    public static final Block ARCANE_VOID_BLOCK = registerBlock("arcane_void_block",
            new ArcaneVoidBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_CLEAR_NEGATIVE_BLOCK = registerBlock("arcane_clear_negative_block",
            new ArcaneClearNegativeBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_CLEAR_POSITIVE_BLOCK = registerBlock("arcane_clear_positive_block",
            new ArcaneClearPositiveBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_CLEAR_NEUTRAL_BLOCK = registerBlock("arcane_clear_neutral_block",
            new ArcaneClearNeutralBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_DISORIENT_BLOCK = registerBlock("arcane_disorient_block",
            new ArcaneDisorientBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_STICKY_FEAT_BLOCK = registerBlock("arcane_sticky_feat_block",
            new ArcaneStickyFeatBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));

    public static final Block ARCANE_FREAKY_BUNNY_BLOCK = registerBlock("arcane_freaky_bunny_block",
            new ArcanFreakyBunnyBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).allowsSpawning(Blocks::never).resistance(50.0F).hardness(50.0F)));



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
