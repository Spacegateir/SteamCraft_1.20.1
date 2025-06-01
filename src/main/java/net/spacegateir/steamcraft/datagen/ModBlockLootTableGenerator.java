package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.loot.entry.ItemEntry;
import net.spacegateir.steamcraft.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AETHER_COIL);
        addDrop(ModBlocks.AETHER_COIL_WHITE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_WHITE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIGHT_GRAY,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIGHT_GRAY, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_GRAY,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_GRAY, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BLACK,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BLACK, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BROWN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BROWN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_RED,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_RED, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_ORANGE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_ORANGE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_YELLOW,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_YELLOW, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIME,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIME, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_GREEN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_GREEN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_CYAN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_CYAN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIGHT_BLUE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIGHT_BLUE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BLUE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BLUE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_PURPLE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_PURPLE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_MAGENTA,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_MAGENTA, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_PINK,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_PINK, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );

        addDrop(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
        addDrop(ModBlocks.FOOLS_GOLD_BLOCK);

        addDrop(ModBlocks.CLAY_PATH,
                dropsWithSilkTouch(ModBlocks.CLAY_PATH, ItemEntry.builder(Blocks.CLAY))
        );
        addDrop(ModBlocks.COARSE_DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.COARSE_DIRT_PATH, ItemEntry.builder(Blocks.COARSE_DIRT))
        );
        addDrop(ModBlocks.DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.DIRT_PATH, ItemEntry.builder(Blocks.DIRT))
        );
        addDrop(ModBlocks.GRAVEL_PATH,
                dropsWithSilkTouch(ModBlocks.GRAVEL_PATH, ItemEntry.builder(Blocks.GRAVEL))
        );
        addDrop(ModBlocks.MUD_PATH,
                dropsWithSilkTouch(ModBlocks.MUD_PATH, ItemEntry.builder(Blocks.MUD))
        );
        addDrop(ModBlocks.RED_SAND_PATH,
                dropsWithSilkTouch(ModBlocks.RED_SAND_PATH, ItemEntry.builder(Blocks.RED_SAND))
        );
        addDrop(ModBlocks.ROOTED_DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.ROOTED_DIRT_PATH, ItemEntry.builder(Blocks.ROOTED_DIRT))
        );
        addDrop(ModBlocks.SAND_PATH,
                dropsWithSilkTouch(ModBlocks.SAND_PATH, ItemEntry.builder(Blocks.SAND))
        );
        addDrop(ModBlocks.SNOW_PATH,
                dropsWithSilkTouch(ModBlocks.SNOW_PATH, ItemEntry.builder(Blocks.SNOW_BLOCK))
        );
        addDrop(ModBlocks.ANDESITE_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.ANDESITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_MOSSY_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.ANDESITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_DIRTY_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.COBBLESTONE_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLESTONE_PATH, ItemEntry.builder(Blocks.COBBLESTONE))
        );
        addDrop(ModBlocks.MOSSY_COBBLESTONE_PATH,
                dropsWithSilkTouch(ModBlocks.MOSSY_COBBLESTONE_PATH, ItemEntry.builder(Blocks.MOSSY_COBBLESTONE))
        );
        addDrop(ModBlocks.COBBLED_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLESTONE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.DIORITE_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.DIORITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_MOSSY_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.DIORITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_DIRTY_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.GRANITE_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.GRANITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_MOSSY_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.GRANITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_DIRTY_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.STONE_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.STONE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_MOSSY_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.STONE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_DIRTY_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.END_STONE_PATH,
                dropsWithSilkTouch(ModBlocks.END_STONE_PATH, ItemEntry.builder(Blocks.END_STONE))
        );

// Minecraft blocks
        addDrop(Blocks.BUDDING_AMETHYST,
                dropsWithSilkTouch(Blocks.BUDDING_AMETHYST, ItemEntry.builder(Blocks.AMETHYST_BLOCK))
        );
        addDrop(Blocks.SPAWNER,
                dropsWithSilkTouch(Blocks.SPAWNER, ItemEntry.builder(Blocks.SPAWNER))
        );
        addDrop(Blocks.REINFORCED_DEEPSLATE);

// Mob Parts
        addDrop(ModBlocks.SKELETON_ARM);
        addDrop(ModBlocks.SKELETON_CHEST);
        addDrop(ModBlocks.SKELETON_HEAD);
        addDrop(ModBlocks.SKELETON_LEG);
        addDrop(ModBlocks.SKELETON_PELVIS);
        addDrop(ModBlocks.SKELETON_ARMS_CROSS);
        addDrop(ModBlocks.SKELETON_HALF_BODY);
        addDrop(ModBlocks.SKELETON_HEAD_STACK);
        addDrop(ModBlocks.SKELETON_LAYING);
        addDrop(ModBlocks.SKELETON_LEGS_CROSS);
        addDrop(ModBlocks.SKELETON_TORSO);
        addDrop(ModBlocks.SKELETON_SITTING);
        addDrop(ModBlocks.SKELETON_SPINE);



        // Normal Flowers
        addDrop(ModBlocks.BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_VIOLET_FLOWER_BLOCK);

        // Thorned Flowers
        addDrop(ModBlocks.THORNED_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK);

        // Lush Flowers
        addDrop(ModBlocks.LUSH_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK);

        addDrop(ModBlocks.POWER_PRECISION_BLOCK);

        addDrop(ModBlocks.ARCANE_ABSORPTION_BLOCK);
        addDrop(ModBlocks.ARCANE_BAD_OMEN_BLOCK);
        addDrop(ModBlocks.ARCANE_BLINDNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_CONDUIT_BLOCK);
        addDrop(ModBlocks.ARCANE_DARKNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK);
        addDrop(ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK);
        addDrop(ModBlocks.ARCANE_GLOWING_BLOCK);
        addDrop(ModBlocks.ARCANE_HASTE_BLOCK);
        addDrop(ModBlocks.ARCANE_HEALTH_BOOST_BLOCK);
        addDrop(ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK);
        addDrop(ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK);
        addDrop(ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK);
        addDrop(ModBlocks.ARCANE_INVISIBILITY_BLOCK);
        addDrop(ModBlocks.ARCANE_JUMP_BOOST_BLOCK);
        addDrop(ModBlocks.ARCANE_LEVITATION_BLOCK);
        addDrop(ModBlocks.ARCANE_LUCK_BLOCK);
        addDrop(ModBlocks.ARCANE_MINING_FATIGUE_BLOCK);
        addDrop(ModBlocks.ARCANE_NEAUSEA_BLOCK);
        addDrop(ModBlocks.ARCANE_NIGHT_VISION_BLOCK);
        addDrop(ModBlocks.ARCANE_POISION_BLOCK);
        addDrop(ModBlocks.ARCANE_REGENERATION_BLOCK);
        addDrop(ModBlocks.ARCANE_RESISTANCE_BLOCK);
        addDrop(ModBlocks.ARCANE_SATUATION_BLOCK);
        addDrop(ModBlocks.ARCANE_SLOW_FALL_BLOCK);
        addDrop(ModBlocks.ARCANE_SLOWNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_SPEED_BLOCK);
        addDrop(ModBlocks.ARCANE_STARVING_BLOCK);
        addDrop(ModBlocks.ARCANE_STRENGTH_BLOCK);
        addDrop(ModBlocks.ARCANE_UNLUCK_BLOCK);
        addDrop(ModBlocks.ARCANE_WATER_BREATHING_BLOCK);
        addDrop(ModBlocks.ARCANE_WEAKNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_WITHER_BLOCK);
        addDrop(ModBlocks.ARCANE_VOID_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK);
        addDrop(ModBlocks.ARCANE_DISORIENT_BLOCK);
        addDrop(ModBlocks.ARCANE_STICKY_FEAT_BLOCK);
        addDrop(ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK);

        addDrop(ModBlocks.CURSED_BLOCK);
        addDrop(ModBlocks.COURSE_DIRT_TRAP_BLOCK);
        addDrop(ModBlocks.STONE_TRAP_BLOCK);
        addDrop(ModBlocks.DEEPSLATE_TRAP_BLOCK);
        addDrop(ModBlocks.FLAREFORGE_BLOCK);
        addDrop(ModBlocks.NETHER_STEAM_VENT);
        addDrop(ModBlocks.SPIRIT_JUMP_TRAP);
        addDrop(ModBlocks.FROST_BITE_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_BRASIER_TRAP_BLOCK);
        addDrop(ModBlocks.EMPTY_BRASIER);
        addDrop(ModBlocks.CURSED_TOTEM_BLOCK);
        addDrop(ModBlocks.TELEPORT_TRAP_BLOCK);
        addDrop(ModBlocks.SAND_QUICKSAND);
        addDrop(ModBlocks.RED_SAND_QUICKSAND);
        addDrop(ModBlocks.GRAVEL_SINKSTONE);
        addDrop(ModBlocks.MUD_SINKING_SLUDGE);
        addDrop(ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND);

        addDrop(ModBlocks.SMOKE_BLOCK);

        addDrop(ModBlocks.WHITE_COBBLED_CONCRETE);
        addDrop(ModBlocks.WHITE_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.LIGHT_GRAY_COBBLED_CONCRETE);
        addDrop(ModBlocks.LIGHT_GRAY_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.GRAY_COBBLED_CONCRETE);
        addDrop(ModBlocks.GRAY_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.BLACK_COBBLED_CONCRETE);
        addDrop(ModBlocks.BLACK_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.BROWN_COBBLED_CONCRETE);
        addDrop(ModBlocks.BROWN_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.RED_COBBLED_CONCRETE);
        addDrop(ModBlocks.RED_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.ORANGE_COBBLED_CONCRETE);
        addDrop(ModBlocks.ORANGE_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.YELLOW_COBBLED_CONCRETE);
        addDrop(ModBlocks.YELLOW_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.LIME_COBBLED_CONCRETE);
        addDrop(ModBlocks.LIME_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.GREEN_COBBLED_CONCRETE);
        addDrop(ModBlocks.GREEN_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.CYAN_COBBLED_CONCRETE);
        addDrop(ModBlocks.CYAN_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.LIGHT_BLUE_COBBLED_CONCRETE);
        addDrop(ModBlocks.LIGHT_BLUE_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.BLUE_COBBLED_CONCRETE);
        addDrop(ModBlocks.BLUE_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.PURPLE_COBBLED_CONCRETE);
        addDrop(ModBlocks.PURPLE_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.MAGENTA_COBBLED_CONCRETE);
        addDrop(ModBlocks.MAGENTA_COBBLED_CONCRETE_POWDER);
        addDrop(ModBlocks.PINK_COBBLED_CONCRETE);
        addDrop(ModBlocks.PINK_COBBLED_CONCRETE_POWDER);

        addDrop(ModBlocks.PACKED_ICE_BRICKS);
        addDrop(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
        addDrop(ModBlocks.PACKED_ICE_TILES);
        addDrop(ModBlocks.PACKED_ICE_TILES_CRACKED);
        addDrop(ModBlocks.SNOW_BRICKS);
        addDrop(ModBlocks.SNOW_BRICKS_CRACKED);
        addDrop(ModBlocks.SNOW_TILES);
        addDrop(ModBlocks.SNOW_TILES_CRACKED);






    }
}