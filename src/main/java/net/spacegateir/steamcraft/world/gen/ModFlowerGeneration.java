package net.spacegateir.steamcraft.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.world.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        for (Block flower : ModBlocks.COLOR_TO_FLOWER.values()) {
            registerFlowerFeature(BiomeKeys.FLOWER_FOREST, flower);
            registerFlowerFeature(BiomeKeys.FLOWER_FOREST, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.FLOWER_FOREST, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.THE_VOID, flower);
            registerFlowerFeature(BiomeKeys.THE_VOID, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.THE_VOID, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.SWAMP, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.RIVER, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.LUSH_CAVES, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
            registerFlowerFeature(BiomeKeys.MANGROVE_SWAMP, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
        }

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.CARNATION));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DAHLIA));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.BLUE_COSMOS));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.PRIMROSE));

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SUNFLOWER_PLAINS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.VIOLET));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.HYDRANGEA));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.SNOW_DROP));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.HAWTHORN));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DAHLIA));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.LARKSPUR));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.LARKSPUR));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.HAWTHORN));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.SPIDERLILY));

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.BONSAI));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.HYDRANGEA));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DELPHINIUM));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.AGAPANTHUS));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.BLUE_COSMOS));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.BONSAI));

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

// Normal Flowers
//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DAFFODIL));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.MIDNIGHT_MYSTIC));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.CARNATION));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.PRIMROSE));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.IRIS));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.SPIDERLILY));

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_FROZEN_OCEAN),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.MIDNIGHT_MYSTIC));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.AGAPANTHUS));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.VIOLET));

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.ERODED_BADLANDS),
//                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DELPHINIUM));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.SNOW_DROP));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.IRIS));

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.getKey(ModBlocks.DAFFODIL));
    }

    private static void registerFlowerFeature(RegistryKey<Biome> biomeKey, Block flower) {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(biomeKey),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Registries.BLOCK.getId(flower)));
    }
}