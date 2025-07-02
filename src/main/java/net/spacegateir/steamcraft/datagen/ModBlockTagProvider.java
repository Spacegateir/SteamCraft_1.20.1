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
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModBlockTagProvider.ModTags.Blocks.SKELETON)
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
                        ModBlocks.ARCANE_CONDUIT_BLOCK,
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

        getOrCreateTagBuilder(ModBlockTagProvider.ModTags.Blocks.TRAPS)
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
                        ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK
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


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.Blocks.SKELETON)
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.AETHER_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)
                .addTag(ModTags.Blocks.BUILDING_BLOCKS)
                .addTag(ModTags.Blocks.STONE_PATH_BLOCKS)

                .add(

                        Blocks.BUDDING_AMETHYST,
                        Blocks.SPAWNER,
                        Blocks.REINFORCED_DEEPSLATE,

                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,
                        ModBlocks.DIVINITITE_ALLOY_BLOCK,

                        ModBlocks.POWER_PRECISION_BLOCK,
                        ModBlocks.SMOKE_BLOCK,

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
                        ModBlocks.SNOW_TILES_CRACKED

                );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)

                .add(

                        ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK,

                        ModBlocks.SMOKE_BLOCK

                );


        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(

                        ModBlocks.SMOKE_BLOCK

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

                        ModBlocks.POWER_PRECISION_BLOCK

                );


        getOrCreateTagBuilder(BlockTags.WALLS)

                .add(ModBlocks.GLIMMERSTONE_WALL_BLOCK)
                .add(ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK)
                .add(ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)

                .add(
                        ModBlocks.DIVINITITE_ALLOY_BLOCK,
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
                    java.lang.reflect.Field field = ModBlocks.class.getField(fieldName);
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
