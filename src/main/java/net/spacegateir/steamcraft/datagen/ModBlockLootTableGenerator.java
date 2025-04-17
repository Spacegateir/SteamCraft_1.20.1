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

        addDrop(ModBlocks.AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK);

        addDrop(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK);

        // Normal Flowers
        addDrop(ModBlocks.BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BONSAI_FLOWER_BLOCK);
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



    }
}