package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;


import java.lang.reflect.Field;
import java.util.concurrent.CompletableFuture;


public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static class ModTags {
        public static class Blocks {
            public static final TagKey<Block> SKELETON = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "skeleton")
            );
            public static final TagKey<Block> ARCANE_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "arcane_blocks")
            );
            public static final TagKey<Block> AETHER_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "aether_blocks")
            );
            public static final TagKey<Block> TRAPS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "traps")
            );
            public static final TagKey<Block> BUILDING_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "building_blocks")
            );
            public static final TagKey<Block> STONE_PATH_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "path_blocks")
            );
            public static final TagKey<Block> SOIL_PATH_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "path_blocks")
            );
            public static final TagKey<Block> FLOWER_CROPS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "flower_crops")
            );
            public static final TagKey<Block> TROPHY_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "trophy_blocks")
            );
            public static final TagKey<Block> DECORATION_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "decoration_blocks")
            );
            public static final TagKey<Block> PICKAXE_EFFICIENT = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "pickaxe_efficient")
            );
            public static final TagKey<Block> PICKAXE_MINING_MODE = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "pickaxe_mining_mode")
            );
            public static final TagKey<Block> SHOVEL_DIGGING_MODE = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "shovel_digging_mode")
            );
            public static final TagKey<Block> HOE_TILLING_MODE = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "hoe_tilling_mode")
            );
            public static final TagKey<Block> SHEARING_MODE = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "shearing_mode")
            );
            public static final TagKey<Block> PICKAXE_ORES = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "pickaxe_ores")
            );
            public static final TagKey<Block> AXE_STRIPPABLE = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "axe_strippable")
            );
            public static final TagKey<Block> METALS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "metals")
            );
            public static final TagKey<Block> MINERAL_DEPOSIT = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "mineral_deposit")
            );
            public static final TagKey<Block> MINERAL_INACTIVE_DEPOSIT = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "mineral_inactive_deposit")
            );
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModTags.Blocks.SKELETON)
                .add(
                        ModBlocks.SKELETON_ARM,
                        ModBlocks.SKELETON_CHEST,
                        ModBlocks.SKELETON_HEAD,
                        ModBlocks.SKELETON_LEG,
                        ModBlocks.SKELETON_PELVIS,
                        ModBlocks.SKELETON_ARMS_CROSS,
                        ModBlocks.SKELETON_HALF_BODY,
                        ModBlocks.SKELETON_HEAD_STACK,
                        ModBlocks.SKELETON_LAYING,
                        ModBlocks.SKELETON_LEGS_CROSS,
                        ModBlocks.SKELETON_TORSO,
                        ModBlocks.SKELETON_SITTING,
                        ModBlocks.SKELETON_SPINE
                );

        getOrCreateTagBuilder(ModTags.Blocks.ARCANE_BLOCKS)
                .add(
                        ModBlocks.ARCANE_ABSORPTION_BLOCK,
                        ModBlocks.ARCANE_BAD_OMEN_BLOCK,
                        ModBlocks.ARCANE_BLINDNESS_BLOCK,
                        ModBlocks.ARCANE_CONDUIT_POWER_BLOCK,
                        ModBlocks.ARCANE_DARKNESS_BLOCK,
                        ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK,
                        ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK,
                        ModBlocks.ARCANE_GLOWING_BLOCK,
                        ModBlocks.ARCANE_HASTE_BLOCK,
                        ModBlocks.ARCANE_HEALTH_BOOST_BLOCK,
                        ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK,
                        ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK,
                        ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK,
                        ModBlocks.ARCANE_INVISIBILITY_BLOCK,
                        ModBlocks.ARCANE_JUMP_BOOST_BLOCK,
                        ModBlocks.ARCANE_LEVITATION_BLOCK,
                        ModBlocks.ARCANE_LUCK_BLOCK,
                        ModBlocks.ARCANE_MINING_FATIGUE_BLOCK,
                        ModBlocks.ARCANE_NEAUSEA_BLOCK,
                        ModBlocks.ARCANE_NIGHT_VISION_BLOCK,
                        ModBlocks.ARCANE_POISION_BLOCK,
                        ModBlocks.ARCANE_REGENERATION_BLOCK,
                        ModBlocks.ARCANE_RESISTANCE_BLOCK,
                        ModBlocks.ARCANE_SATUATION_BLOCK,
                        ModBlocks.ARCANE_SLOW_FALL_BLOCK,
                        ModBlocks.ARCANE_SLOWNESS_BLOCK,
                        ModBlocks.ARCANE_SPEED_BLOCK,
                        ModBlocks.ARCANE_STARVING_BLOCK,
                        ModBlocks.ARCANE_STRENGTH_BLOCK,
                        ModBlocks.ARCANE_UNLUCK_BLOCK,
                        ModBlocks.ARCANE_WATER_BREATHING_BLOCK,
                        ModBlocks.ARCANE_WEAKNESS_BLOCK,
                        ModBlocks.ARCANE_WITHER_BLOCK,
                        ModBlocks.ARCANE_VOID_BLOCK,
                        ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK,
                        ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK,
                        ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK,
                        ModBlocks.ARCANE_DISORIENT_BLOCK,
                        ModBlocks.ARCANE_STICKY_FEAT_BLOCK,
                        ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.AETHER_BLOCKS)
                .add(
                        ModBlocks.AETHER_COIL,
                        ModBlocks.AETHER_COIL_WHITE,
                        ModBlocks.AETHER_COIL_LIGHT_GRAY,
                        ModBlocks.AETHER_COIL_GRAY,
                        ModBlocks.AETHER_COIL_BLACK,
                        ModBlocks.AETHER_COIL_BROWN,
                        ModBlocks.AETHER_COIL_RED,
                        ModBlocks.AETHER_COIL_ORANGE,
                        ModBlocks.AETHER_COIL_YELLOW,
                        ModBlocks.AETHER_COIL_LIME,
                        ModBlocks.AETHER_COIL_GREEN,
                        ModBlocks.AETHER_COIL_CYAN,
                        ModBlocks.AETHER_COIL_LIGHT_BLUE,
                        ModBlocks.AETHER_COIL_BLUE,
                        ModBlocks.AETHER_COIL_PURPLE,
                        ModBlocks.AETHER_COIL_MAGENTA,
                        ModBlocks.AETHER_COIL_PINK
                );

        getOrCreateTagBuilder(ModTags.Blocks.TRAPS)
                .add(
                        ModBlocks.CURSED_BLOCK,
                        ModBlocks.COURSE_DIRT_TRAP_BLOCK,
                        ModBlocks.STONE_TRAP_BLOCK,
                        ModBlocks.DEEPSLATE_TRAP_BLOCK,
                        ModBlocks.FLAREFORGE_BLOCK,
                        ModBlocks.NETHER_STEAM_VENT,
                        ModBlocks.SPIRIT_JUMP_TRAP,
                        ModBlocks.FROST_BITE_TRAP_BLOCK,
                        ModBlocks.CURSED_NAUSEA_TRAP_BLOCK,
                        ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK,
                        ModBlocks.CURSED_BRASIER_TRAP_BLOCK,
                        ModBlocks.EMPTY_BRASIER,
                        ModBlocks.CURSED_TOTEM_BLOCK,
                        ModBlocks.TELEPORT_TRAP_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.BUILDING_BLOCKS)
                .add(

                        ModBlocks.COBBLED_WHITE_CONCRETE,
                        ModBlocks.COBBLED_WHITE_CONCRETE_POWDER,
                        ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE,
                        ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER,
                        ModBlocks.COBBLED_GRAY_CONCRETE,
                        ModBlocks.COBBLED_GRAY_CONCRETE_POWDER,
                        ModBlocks.COBBLED_BLACK_CONCRETE,
                        ModBlocks.COBBLED_BLACK_CONCRETE_POWDER,
                        ModBlocks.COBBLED_BROWN_CONCRETE,
                        ModBlocks.COBBLED_BROWN_CONCRETE_POWDER,
                        ModBlocks.COBBLED_RED_CONCRETE,
                        ModBlocks.COBBLED_RED_CONCRETE_POWDER,
                        ModBlocks.COBBLED_ORANGE_CONCRETE,
                        ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER,
                        ModBlocks.COBBLED_YELLOW_CONCRETE,
                        ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER,
                        ModBlocks.COBBLED_LIME_CONCRETE,
                        ModBlocks.COBBLED_LIME_CONCRETE_POWDER,
                        ModBlocks.COBBLED_GREEN_CONCRETE,
                        ModBlocks.COBBLED_GREEN_CONCRETE_POWDER,
                        ModBlocks.COBBLED_CYAN_CONCRETE,
                        ModBlocks.COBBLED_CYAN_CONCRETE_POWDER,
                        ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE,
                        ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER,
                        ModBlocks.COBBLED_BLUE_CONCRETE,
                        ModBlocks.COBBLED_BLUE_CONCRETE_POWDER,
                        ModBlocks.COBBLED_PURPLE_CONCRETE,
                        ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER,
                        ModBlocks.COBBLED_MAGENTA_CONCRETE,
                        ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER,
                        ModBlocks.COBBLED_PINK_CONCRETE,
                        ModBlocks.COBBLED_PINK_CONCRETE_POWDER,

                        ModBlocks.GLIMMERSTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_BRICKS_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_PILLAR_BLOCK,
                        ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK,

                        ModBlocks.ANCIENT_GRAVEL_BLOCK,
                        ModBlocks.ANCIENT_SAND_BLOCK,
                        ModBlocks.ANCIENT_SILT_BLOCK,
                        ModBlocks.ANCIENT_LOAM_BLOCK,
                        ModBlocks.ANCIENT_CLAY_BLOCK,

                        ModBlocks.KILN_BURNT_BRICKS_BLOCK,
                        ModBlocks.KILN_BURNT_BRICKS_STAIR_BLOCK,
                        ModBlocks.KILN_BURNT_BRICKS_SLAB_BLOCK,
                        ModBlocks.KILN_BURNT_BRICKS_WALL_BLOCK,
                        ModBlocks.MUD_BRICKS_BLOCK,
                        ModBlocks.MUD_BRICKS_STAIR_BLOCK,
                        ModBlocks.MUD_BRICKS_SLAB_BLOCK,
                        ModBlocks.MUD_BRICKS_WALL_BLOCK

                );

        getOrCreateTagBuilder(ModTags.Blocks.STONE_PATH_BLOCKS)
                .add(

                        ModBlocks.ANDESITE_PATH,
                        ModBlocks.ANDESITE_MOSSY_PATH,
                        ModBlocks.ANDESITE_DIRTY_PATH,
                        ModBlocks.COBBLESTONE_PATH,
                        ModBlocks.MOSSY_COBBLESTONE_PATH,
                        ModBlocks.COBBLED_DIRTY_PATH,
                        ModBlocks.COBBLED_DEEPSLATE_PATH,
                        ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH,
                        ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH,
                        ModBlocks.DIORITE_PATH,
                        ModBlocks.DIORITE_MOSSY_PATH,
                        ModBlocks.DIORITE_DIRTY_PATH,
                        ModBlocks.GRANITE_PATH,
                        ModBlocks.GRANITE_MOSSY_PATH,
                        ModBlocks.GRANITE_DIRTY_PATH,
                        ModBlocks.STONE_PATH,
                        ModBlocks.STONE_MOSSY_PATH,
                        ModBlocks.STONE_DIRTY_PATH,
                        ModBlocks.END_STONE_PATH
                );

        getOrCreateTagBuilder(ModTags.Blocks.SOIL_PATH_BLOCKS)
                .add(
                        ModBlocks.ANCIENT_WET_MUD,
                        ModBlocks.ANCIENT_SLIGHTLY_WET_MUD,
                        ModBlocks.ANCIENT_MUD_BLOCK,
                        ModBlocks.ANCIENT_SLIGHTLY_DRY_MUD,
                        ModBlocks.ANCIENT_DRY_MUD,

                        ModBlocks.CLAY_PATH,
                        ModBlocks.COARSE_DIRT_PATH,
                        ModBlocks.DIRT_PATH,
                        ModBlocks.GRAVEL_PATH,
                        ModBlocks.MUD_PATH,
                        ModBlocks.RED_SAND_PATH,
                        ModBlocks.ROOTED_DIRT_PATH,
                        ModBlocks.SAND_PATH,
                        ModBlocks.SNOW_PATH
                );

        getOrCreateTagBuilder(BlockTags.CAULDRONS)
                .add(
                        ModBlocks.BLACK_LAVA_CAULDRON_BLOCK,
                        ModBlocks.BLACK_WATER_CAULDRON_BLOCK,
                        ModBlocks.BLUE_LAVA_CAULDRON_BLOCK,
                        ModBlocks.BLUE_WATER_CAULDRON_BLOCK,
                        ModBlocks.BROWN_LAVA_CAULDRON_BLOCK,
                        ModBlocks.BROWN_WATER_CAULDRON_BLOCK,
                        ModBlocks.CYAN_LAVA_CAULDRON_BLOCK,
                        ModBlocks.CYAN_WATER_CAULDRON_BLOCK,
                        ModBlocks.GRAY_LAVA_CAULDRON_BLOCK,
                        ModBlocks.GRAY_WATER_CAULDRON_BLOCK,
                        ModBlocks.GREEN_LAVA_CAULDRON_BLOCK,
                        ModBlocks.GREEN_WATER_CAULDRON_BLOCK,
                        ModBlocks.LIGHT_BLUE_LAVA_CAULDRON_BLOCK,
                        ModBlocks.LIGHT_BLUE_WATER_CAULDRON_BLOCK,
                        ModBlocks.LIGHT_GRAY_LAVA_CAULDRON_BLOCK,
                        ModBlocks.LIGHT_GRAY_WATER_CAULDRON_BLOCK,
                        ModBlocks.LIME_LAVA_CAULDRON_BLOCK,
                        ModBlocks.LIME_WATER_CAULDRON_BLOCK,
                        ModBlocks.MAGENTA_LAVA_CAULDRON_BLOCK,
                        ModBlocks.MAGENTA_WATER_CAULDRON_BLOCK,
                        ModBlocks.ORANGE_LAVA_CAULDRON_BLOCK,
                        ModBlocks.ORANGE_WATER_CAULDRON_BLOCK,
                        ModBlocks.PINK_LAVA_CAULDRON_BLOCK,
                        ModBlocks.PINK_WATER_CAULDRON_BLOCK,
                        ModBlocks.PURPLE_LAVA_CAULDRON_BLOCK,
                        ModBlocks.PURPLE_WATER_CAULDRON_BLOCK,
                        ModBlocks.RED_LAVA_CAULDRON_BLOCK,
                        ModBlocks.RED_WATER_CAULDRON_BLOCK,
                        ModBlocks.WHITE_LAVA_CAULDRON_BLOCK,
                        ModBlocks.WHITE_WATER_CAULDRON_BLOCK,
                        ModBlocks.YELLOW_LAVA_CAULDRON_BLOCK,
                        ModBlocks.YELLOW_WATER_CAULDRON_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.TROPHY_BLOCKS)
                .add(
                        ModBlocks.GOLD_TROPHY_BLOCK,
                        ModBlocks.SILVER_TROPHY_BLOCK,
                        ModBlocks.COPPER_TROPHY_BLOCK,
                        ModBlocks.PARTICIPATION_TROPHY_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.DECORATION_BLOCKS)
                .add(

                        ModBlocks.MORTAR_AND_PESTLE_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.PICKAXE_EFFICIENT)
                .add(

                        ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_BLOCK,
                        ModBlocks.GLIMMERSTONE_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.HOE_TILLING_MODE)
                .add(
                        Blocks.GRASS,
                        Blocks.TALL_GRASS,
                        Blocks.FERN,
                        Blocks.LARGE_FERN,
                        Blocks.DEAD_BUSH,
                        Blocks.MOSS_BLOCK,
                        Blocks.MOSS_CARPET,
                        Blocks.VINE,
                        Blocks.WEEPING_VINES,
                        Blocks.TWISTING_VINES,
                        Blocks.CAVE_VINES,
                        Blocks.CAVE_VINES_PLANT,
                        Blocks.GLOW_LICHEN,
                        Blocks.MANGROVE_ROOTS,
                        Blocks.HANGING_ROOTS,
                        Blocks.CRIMSON_ROOTS,
                        Blocks.WARPED_ROOTS,
                        Blocks.NETHER_SPROUTS,
                        Blocks.LILY_PAD,
                        Blocks.SEAGRASS,
                        Blocks.TALL_SEAGRASS,
                        Blocks.SEA_PICKLE,
                        Blocks.KELP,
                        Blocks.SCULK_VEIN,
                        Blocks.PINK_PETALS,

                        Blocks.SCULK,
                        Blocks.SCULK_CATALYST,
                        Blocks.SCULK_SHRIEKER,
                        Blocks.SCULK_SENSOR,
                        Blocks.SPONGE,
                        Blocks.WET_SPONGE,
                        Blocks.TARGET,
                        Blocks.DRIED_KELP_BLOCK,
                        Blocks.HAY_BLOCK,
                        Blocks.NETHER_WART_BLOCK,
                        Blocks.WARPED_WART_BLOCK,
                        Blocks.SHROOMLIGHT,

                        Blocks.WHEAT,
                        Blocks.CARROTS,
                        Blocks.POTATOES,
                        Blocks.BEETROOTS,
                        Blocks.NETHER_WART,
                        Blocks.MELON,
                        Blocks.PUMPKIN,
                        Blocks.SWEET_BERRY_BUSH,
                        Blocks.COCOA
                );

        getOrCreateTagBuilder(ModTags.Blocks.SHOVEL_DIGGING_MODE)
                .addTag(ModTags.Blocks.SOIL_PATH_BLOCKS)
                .add(
                        Blocks.DIRT,
                        Blocks.COARSE_DIRT,
                        Blocks.ROOTED_DIRT,
                        Blocks.PODZOL,
                        Blocks.MYCELIUM,
                        Blocks.GRASS_BLOCK,
                        Blocks.FARMLAND,
                        Blocks.SAND,
                        Blocks.RED_SAND,
                        Blocks.GRAVEL,
                        Blocks.CLAY,
                        Blocks.SNOW,
                        Blocks.SNOW_BLOCK,
                        Blocks.POWDER_SNOW,
                        Blocks.SOUL_SAND,
                        Blocks.SOUL_SOIL,
                        Blocks.MUD,
                        Blocks.MUD_BRICKS,
                        Blocks.MOSS_BLOCK,
                        Blocks.DIRT_PATH,

                        ModBlocks.ANCIENT_GRAVEL_BLOCK,
                        ModBlocks.ANCIENT_SAND_BLOCK,
                        ModBlocks.ANCIENT_SILT_BLOCK,
                        ModBlocks.ANCIENT_LOAM_BLOCK,
                        ModBlocks.ANCIENT_CLAY_BLOCK,
                        ModBlocks.ANCIENT_MOIST_CLAY_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.SHEARING_MODE)
                .add(
                        // Wool
                        Blocks.WHITE_WOOL,
                        Blocks.LIGHT_GRAY_WOOL,
                        Blocks.GRAY_WOOL,
                        Blocks.BLACK_WOOL,
                        Blocks.BROWN_WOOL,
                        Blocks.RED_WOOL,
                        Blocks.ORANGE_WOOL,
                        Blocks.YELLOW_WOOL,
                        Blocks.LIME_WOOL,
                        Blocks.GREEN_WOOL,
                        Blocks.CYAN_WOOL,
                        Blocks.LIGHT_BLUE_WOOL,
                        Blocks.BLUE_WOOL,
                        Blocks.PURPLE_WOOL,
                        Blocks.MAGENTA_WOOL,
                        Blocks.PINK_WOOL,

                        // Carpets
                        Blocks.WHITE_CARPET,
                        Blocks.LIGHT_GRAY_CARPET,
                        Blocks.GRAY_CARPET,
                        Blocks.BLACK_CARPET,
                        Blocks.BROWN_CARPET,
                        Blocks.RED_CARPET,
                        Blocks.ORANGE_CARPET,
                        Blocks.YELLOW_CARPET,
                        Blocks.LIME_CARPET,
                        Blocks.GREEN_CARPET,
                        Blocks.CYAN_CARPET,
                        Blocks.LIGHT_BLUE_CARPET,
                        Blocks.BLUE_CARPET,
                        Blocks.PURPLE_CARPET,
                        Blocks.MAGENTA_CARPET,
                        Blocks.PINK_CARPET,

                        // Leaves
                        Blocks.OAK_LEAVES,
                        Blocks.SPRUCE_LEAVES,
                        Blocks.BIRCH_LEAVES,
                        Blocks.JUNGLE_LEAVES,
                        Blocks.ACACIA_LEAVES,
                        Blocks.DARK_OAK_LEAVES,
                        Blocks.MANGROVE_LEAVES,
                        Blocks.CHERRY_LEAVES,
                        Blocks.AZALEA_LEAVES,
                        Blocks.FLOWERING_AZALEA_LEAVES,

                        // Shearables
                        Blocks.COBWEB,
                        Blocks.VINE,
                        Blocks.GLOW_LICHEN,
                        Blocks.TALL_GRASS,
                        Blocks.FERN,
                        Blocks.LARGE_FERN,
                        Blocks.DEAD_BUSH
                );




        getOrCreateTagBuilder(ModTags.Blocks.PICKAXE_MINING_MODE)
//                .addTag(BlockTags.PICKAXE_MINEABLE)

                .addTag(ModTags.Blocks.AETHER_BLOCKS)
                .addTag(ModTags.Blocks.BUILDING_BLOCKS)
                .addTag(ModTags.Blocks.STONE_PATH_BLOCKS)

                .add(
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_BLOCK,
                        ModBlocks.GLIMMERSTONE_BLOCK,

                        Blocks.STONE,
                        Blocks.STONE_BRICKS,
                        Blocks.ANDESITE,
                        Blocks.POLISHED_ANDESITE,
                        Blocks.GRANITE,
                        Blocks.POLISHED_GRANITE,
                        Blocks.DIORITE,
                        Blocks.POLISHED_DIORITE,
                        Blocks.COBBLESTONE,
                        Blocks.BASALT,
                        Blocks.SMOOTH_BASALT,
                        Blocks.SMOOTH_SANDSTONE,
                        Blocks.SMOOTH_QUARTZ,
                        Blocks.SMOOTH_STONE,
                        Blocks.POLISHED_BASALT,
                        Blocks.CALCITE,
                        Blocks.TUFF,
                        Blocks.DEEPSLATE,
                        Blocks.COBBLED_DEEPSLATE,
                        Blocks.POLISHED_DEEPSLATE,
                        Blocks.DEEPSLATE_TILES,
                        Blocks.DEEPSLATE_BRICKS,
                        Blocks.CHISELED_DEEPSLATE,
                        Blocks.CRACKED_DEEPSLATE_BRICKS,
                        Blocks.CRACKED_DEEPSLATE_TILES,
                        Blocks.BLACKSTONE,
                        Blocks.POLISHED_BLACKSTONE,
                        Blocks.POLISHED_BLACKSTONE_BRICKS,
                        Blocks.GILDED_BLACKSTONE,
                        Blocks.ICE,
                        Blocks.PACKED_ICE,
                        Blocks.BLUE_ICE,
                        Blocks.SANDSTONE,
                        Blocks.RED_SANDSTONE,
                        Blocks.MOSSY_COBBLESTONE,
                        Blocks.BRICKS,
                        Blocks.CUT_SANDSTONE,
                        Blocks.CUT_RED_SANDSTONE,
                        Blocks.CHISELED_SANDSTONE,
                        Blocks.CHISELED_RED_SANDSTONE,
                        Blocks.NETHER_BRICKS,
                        Blocks.DRIPSTONE_BLOCK,
                        Blocks.NETHERRACK,
                        Blocks.END_STONE,
                        Blocks.MUD,
                        Blocks.MUD_BRICKS,

                        Blocks.TERRACOTTA,
                        Blocks.WHITE_TERRACOTTA,
                        Blocks.ORANGE_TERRACOTTA,
                        Blocks.MAGENTA_TERRACOTTA,
                        Blocks.LIGHT_BLUE_TERRACOTTA,
                        Blocks.YELLOW_TERRACOTTA,
                        Blocks.LIME_TERRACOTTA,
                        Blocks.PINK_TERRACOTTA,
                        Blocks.GRAY_TERRACOTTA,
                        Blocks.LIGHT_GRAY_TERRACOTTA,
                        Blocks.CYAN_TERRACOTTA,
                        Blocks.PURPLE_TERRACOTTA,
                        Blocks.BLUE_TERRACOTTA,
                        Blocks.BROWN_TERRACOTTA,
                        Blocks.GREEN_TERRACOTTA,
                        Blocks.RED_TERRACOTTA,
                        Blocks.BLACK_TERRACOTTA,

                        Blocks.WHITE_GLAZED_TERRACOTTA,
                        Blocks.ORANGE_GLAZED_TERRACOTTA,
                        Blocks.MAGENTA_GLAZED_TERRACOTTA,
                        Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
                        Blocks.YELLOW_GLAZED_TERRACOTTA,
                        Blocks.LIME_GLAZED_TERRACOTTA,
                        Blocks.PINK_GLAZED_TERRACOTTA,
                        Blocks.GRAY_GLAZED_TERRACOTTA,
                        Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
                        Blocks.CYAN_GLAZED_TERRACOTTA,
                        Blocks.PURPLE_GLAZED_TERRACOTTA,
                        Blocks.BLUE_GLAZED_TERRACOTTA,
                        Blocks.BROWN_GLAZED_TERRACOTTA,
                        Blocks.GREEN_GLAZED_TERRACOTTA,
                        Blocks.RED_GLAZED_TERRACOTTA,
                        Blocks.BLACK_GLAZED_TERRACOTTA,

                        Blocks.COAL_ORE,
                        Blocks.DEEPSLATE_COAL_ORE,
                        Blocks.COPPER_ORE,
                        Blocks.DEEPSLATE_COPPER_ORE,
                        Blocks.IRON_ORE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.GOLD_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.NETHER_GOLD_ORE,
                        Blocks.DIAMOND_ORE,
                        Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.EMERALD_ORE,
                        Blocks.DEEPSLATE_EMERALD_ORE,
                        Blocks.LAPIS_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        Blocks.REDSTONE_ORE,
                        Blocks.DEEPSLATE_REDSTONE_ORE,
                        Blocks.NETHER_QUARTZ_ORE,
                        Blocks.ANCIENT_DEBRIS,

                        Blocks.LAPIS_BLOCK,
                        Blocks.GOLD_BLOCK,
                        Blocks.IRON_BLOCK,
                        Blocks.DIAMOND_BLOCK,
                        Blocks.EMERALD_BLOCK,
                        Blocks.REDSTONE_BLOCK,
                        Blocks.COPPER_BLOCK,
                        Blocks.RAW_IRON_BLOCK,
                        Blocks.RAW_COPPER_BLOCK,
                        Blocks.RAW_GOLD_BLOCK
                );

        getOrCreateTagBuilder(ModTags.Blocks.PICKAXE_ORES)

                .addTag(ModTags.Blocks.MINERAL_DEPOSIT)

                .add(
                        Blocks.ANDESITE,
                        Blocks.GRANITE,
                        Blocks.DIORITE,
                        Blocks.BASALT,
                        Blocks.SMOOTH_BASALT,
                        Blocks.CALCITE,
                        Blocks.AMETHYST_BLOCK,

                        Blocks.COAL_ORE,
                        Blocks.DEEPSLATE_COAL_ORE,
                        Blocks.COPPER_ORE,
                        Blocks.DEEPSLATE_COPPER_ORE,
                        Blocks.IRON_ORE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.GOLD_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.NETHER_GOLD_ORE,
                        Blocks.DIAMOND_ORE,
                        Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.EMERALD_ORE,
                        Blocks.DEEPSLATE_EMERALD_ORE,
                        Blocks.LAPIS_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        Blocks.REDSTONE_ORE,
                        Blocks.DEEPSLATE_REDSTONE_ORE,
                        Blocks.NETHER_QUARTZ_ORE,
                        Blocks.ANCIENT_DEBRIS
                );

        getOrCreateTagBuilder(ModTags.Blocks.AXE_STRIPPABLE)
                .add(
                        Blocks.OAK_LOG,
                        Blocks.SPRUCE_LOG,
                        Blocks.BIRCH_LOG,
                        Blocks.JUNGLE_LOG,
                        Blocks.ACACIA_LOG,
                        Blocks.DARK_OAK_LOG,
                        Blocks.MANGROVE_LOG,
                        Blocks.CHERRY_LOG,

                        Blocks.CRIMSON_STEM,
                        Blocks.WARPED_STEM
                );

        getOrCreateTagBuilder(ModTags.Blocks.METALS)
                .add(
                        ModBlocks.RAW_SILVER_BLOCK,
                        ModBlocks.SILVER_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,
                        ModBlocks.FOOLS_GOLD_BLOCK
                );

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.Blocks.SKELETON)
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.AETHER_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)
                .addTag(ModTags.Blocks.BUILDING_BLOCKS)
                .addTag(ModTags.Blocks.STONE_PATH_BLOCKS)
                .addTag(ModTags.Blocks.TROPHY_BLOCKS)
                .addTag(ModTags.Blocks.DECORATION_BLOCKS)
                .addTag(ModTags.Blocks.MINERAL_DEPOSIT)

                .add(

                        Blocks.BUDDING_AMETHYST,
                        Blocks.SPAWNER,
                        Blocks.REINFORCED_DEEPSLATE,

                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,
                        ModBlocks.DIVINITITE_ALLOY_BLOCK,

                        ModBlocks.POWER_PRECISION_BLOCK,
                        ModBlocks.SMOKE_BLOCK,
                        ModBlocks.MEDKIT,
                        ModBlocks.PAN,
                        ModBlocks.POT,

                        ModBlocks.PACKED_ICE_BRICKS,
                        ModBlocks.PACKED_ICE_BRICKS_CRACKED,
                        ModBlocks.PACKED_ICE_TILES,
                        ModBlocks.PACKED_ICE_TILES_CRACKED


                );

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .addTag(ModTags.Blocks.SOIL_PATH_BLOCKS)

                .add(

                        ModBlocks.SAND_QUICKSAND,
                        ModBlocks.RED_SAND_QUICKSAND,
                        ModBlocks.GRAVEL_SINKSTONE,
                        ModBlocks.MUD_SINKING_SLUDGE,
                        ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND,

                        ModBlocks.SMOKE_BLOCK,

                        ModBlocks.SNOW_BRICKS,
                        ModBlocks.SNOW_BRICKS_CRACKED,
                        ModBlocks.SNOW_TILES,
                        ModBlocks.SNOW_TILES_CRACKED,

                        ModBlocks.ANCIENT_GRAVEL_BLOCK,
                        ModBlocks.ANCIENT_SAND_BLOCK,
                        ModBlocks.ANCIENT_SILT_BLOCK,
                        ModBlocks.ANCIENT_LOAM_BLOCK,
                        ModBlocks.ANCIENT_MUD_BLOCK,
                        ModBlocks.ANCIENT_CLAY_BLOCK,
                        ModBlocks.ANCIENT_MOIST_CLAY_BLOCK

                );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)

                .add(

                        ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK,

                        ModBlocks.SMOKE_BLOCK,
                        ModBlocks.GAMEBOARD_BLOCK

                );


        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(

                        ModBlocks.SMOKE_BLOCK

                );


        getOrCreateTagBuilder(ModTags.Blocks.MINERAL_DEPOSIT)
                .add(

                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_BLOCK,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_CLAY,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_COAL,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_IRON,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_COPPER,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_SILVER,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_REDSTONE,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_LAPIS,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_GOLD,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_NETHERITE,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_GEM

                );


        getOrCreateTagBuilder(ModTags.Blocks.MINERAL_INACTIVE_DEPOSIT)
                .add(

                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_BLOCK,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_CLAY,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_COAL,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_IRON,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_COPPER,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_SILVER,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_REDSTONE,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_LAPIS,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_GOLD,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_NETHERITE,
                        ModBlocks.MINERAL_DEPOSIT_INACTIVE_GEM

                );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.AETHER_COIL,
                        ModBlocks.AETHER_COIL_WHITE,
                        ModBlocks.AETHER_COIL_LIGHT_GRAY,
                        ModBlocks.AETHER_COIL_GRAY,
                        ModBlocks.AETHER_COIL_BLACK,
                        ModBlocks.AETHER_COIL_BROWN,
                        ModBlocks.AETHER_COIL_RED,
                        ModBlocks.AETHER_COIL_ORANGE,
                        ModBlocks.AETHER_COIL_YELLOW,
                        ModBlocks.AETHER_COIL_LIME,
                        ModBlocks.AETHER_COIL_GREEN,
                        ModBlocks.AETHER_COIL_CYAN,
                        ModBlocks.AETHER_COIL_LIGHT_BLUE,
                        ModBlocks.AETHER_COIL_BLUE,
                        ModBlocks.AETHER_COIL_PURPLE,
                        ModBlocks.AETHER_COIL_MAGENTA,
                        ModBlocks.AETHER_COIL_PINK,

                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,

                        ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_BLOCK,
                        ModBlocks.GLIMMERSTONE_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_BRICKS_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK,
                        ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK,

                        ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK,
                        ModBlocks.GLIMMERSTONE_PILLAR_BLOCK,

                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_SILVER,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_REDSTONE,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_LAPIS,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_GOLD,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_GEM,

                        ModBlocks.POWER_PRECISION_BLOCK

                );


        getOrCreateTagBuilder(BlockTags.WALLS)

                .add(ModBlocks.GLIMMERSTONE_WALL_BLOCK)
                .add(ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK)
                .add(ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK)
                .add(ModBlocks.MUD_BRICKS_WALL_BLOCK)
                .add(ModBlocks.KILN_BURNT_BRICKS_WALL_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)

                .add(
                        ModBlocks.DIVINITITE_ALLOY_BLOCK,
                        ModBlocks.MINERAL_DEPOSIT_ACTIVE_NETHERITE,
                        Blocks.BUDDING_AMETHYST

                );

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(

                        Blocks.SPAWNER,
                        Blocks.REINFORCED_DEEPSLATE

                );

        // Dynamic seed block tag registration
        String[] baseFlowers = {
                "carnation", "violet", "iris", "primrose", "daffodil", "delphinium", "dahlia",
                "hydrangea", "midnight_mystic", "hawthorn", "bonsai", "spiderlily",
                "larkspur", "agapanthus", "blue_cosmos", "snow_drop"
        };

        String[] prefixes = {"", "lush_", "thorned_"};

        var builder = getOrCreateTagBuilder(ModTags.Blocks.FLOWER_CROPS);

        for (String prefix : prefixes) {
            for (String base : baseFlowers) {
                String fieldName = (prefix + base).toUpperCase() + "_CROP"; // check if block fields have this naming
                try {
                    Field field = ModBlocks.class.getField(fieldName);
                    Object block = field.get(null);
                    if (block instanceof Block) {
                        builder.add((Block) block);
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    System.err.println("Block field not found or inaccessible: " + fieldName);
                }
            }
        }


    }
}
