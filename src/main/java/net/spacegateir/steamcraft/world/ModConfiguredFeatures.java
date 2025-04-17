package net.spacegateir.steamcraft.world;

import net.minecraft.block.Block;
import net.spacegateir.steamcraft.Steamcraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CARNATION_FLOWERS_KEY = registerKey("carnation_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIOLET_FLOWERS_KEY = registerKey("violet_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRIS_FLOWERS_KEY = registerKey("iris_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIMROSE_FLOWERS_KEY = registerKey("primrose_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAFFODIL_FLOWERS_KEY = registerKey("daffodil_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DELPHINIUM_FLOWERS_KEY = registerKey("delphinium_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAHLIA_FLOWERS_KEY = registerKey("dahlia_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA_FLOWERS_KEY = registerKey("hydrangea_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MIDNIGHT_MYSTIC_FLOWERS_KEY = registerKey("midnight_mystic_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HAWTHORN_FLOWERS_KEY = registerKey("hawthorn_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BONSAI_FLOWERS_KEY = registerKey("bonsai_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPIDERLILY_FLOWERS_KEY = registerKey("spiderlily_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARKSPUR_FLOWERS_KEY = registerKey("larkspur_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AGAPANTHUS_FLOWERS_KEY = registerKey("agapanthus_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_COSMOS_FLOWERS_KEY = registerKey("blue_cosmos_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOW_DROP_FLOWERS_KEY = registerKey("snow_drop_flowers");

    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_CARNATION_FLOWERS_KEY = registerKey("thorned_carnation_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_VIOLET_FLOWERS_KEY = registerKey("thorned_violet_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_IRIS_FLOWERS_KEY = registerKey("thorned_iris_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_PRIMROSE_FLOWERS_KEY = registerKey("thorned_primrose_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_DAFFODIL_FLOWERS_KEY = registerKey("thorned_daffodil_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_DELPHINIUM_FLOWERS_KEY = registerKey("thorned_delphinium_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_DAHLIA_FLOWERS_KEY = registerKey("thorned_dahlia_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_HYDRANGEA_FLOWERS_KEY = registerKey("thorned_hydrangea_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_MIDNIGHT_MYSTIC_FLOWERS_KEY = registerKey("thorned_midnight_mystic_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_HAWTHORN_FLOWERS_KEY = registerKey("thorned_hawthorn_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_BONSAI_FLOWERS_KEY = registerKey("thorned_bonsai_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_SPIDERLILY_FLOWERS_KEY = registerKey("thorned_spiderlily_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_LARKSPUR_FLOWERS_KEY = registerKey("thorned_larkspur_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_AGAPANTHUS_FLOWERS_KEY = registerKey("thorned_agapanthus_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_BLUE_COSMOS_FLOWERS_KEY = registerKey("thorned_blue_cosmos_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THORNED_SNOW_DROP_FLOWERS_KEY = registerKey("thorned_snow_drop_flowers");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_CARNATION_FLOWERS_KEY = registerKey("lush_carnation_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_VIOLET_FLOWERS_KEY = registerKey("lush_violet_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_IRIS_FLOWERS_KEY = registerKey("lush_iris_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_PRIMROSE_FLOWERS_KEY = registerKey("lush_primrose_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_DAFFODIL_FLOWERS_KEY = registerKey("lush_daffodil_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_DELPHINIUM_FLOWERS_KEY = registerKey("lush_delphinium_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_DAHLIA_FLOWERS_KEY = registerKey("lush_dahlia_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_HYDRANGEA_FLOWERS_KEY = registerKey("lush_hydrangea_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_MIDNIGHT_MYSTIC_FLOWERS_KEY = registerKey("lush_midnight_mystic_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_HAWTHORN_FLOWERS_KEY = registerKey("lush_hawthorn_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_BONSAI_FLOWERS_KEY = registerKey("lush_bonsai_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_SPIDERLILY_FLOWERS_KEY = registerKey("lush_spiderlily_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_LARKSPUR_FLOWERS_KEY = registerKey("lush_larkspur_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_AGAPANTHUS_FLOWERS_KEY = registerKey("lush_agapanthus_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_BLUE_COSMOS_FLOWERS_KEY = registerKey("lush_blue_cosmos_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_SNOW_DROP_FLOWERS_KEY = registerKey("lush_snow_drop_flowers");






    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {





        register(context, CARNATION_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CARNATION_FLOWER_BLOCK)))));
        register(context, VIOLET_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VIOLET_FLOWER_BLOCK)))));
        register(context, IRIS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.IRIS_FLOWER_BLOCK)))));
        register(context, PRIMROSE_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PRIMROSE_FLOWER_BLOCK)))));
        register(context, DAFFODIL_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DAFFODIL_FLOWER_BLOCK)))));
        register(context, DELPHINIUM_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DELPHINIUM_FLOWER_BLOCK)))));
        register(context, DAHLIA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DAHLIA_FLOWER_BLOCK)))));
        register(context, HYDRANGEA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HYDRANGEA_FLOWER_BLOCK)))));
        register(context, MIDNIGHT_MYSTIC_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK)))));
        register(context, HAWTHORN_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HAWTHORN_FLOWER_BLOCK)))));
        register(context, BONSAI_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BONSAI_FLOWER_BLOCK)))));
        register(context, SPIDERLILY_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SPIDERLILY_FLOWER_BLOCK)))));
        register(context, LARKSPUR_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARKSPUR_FLOWER_BLOCK)))));
        register(context, AGAPANTHUS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.AGAPANTHUS_FLOWER_BLOCK)))));
        register(context, BLUE_COSMOS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK)))));
        register(context, SNOW_DROP_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SNOW_DROP_FLOWER_BLOCK)))));

        register(context, THORNED_CARNATION_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_CARNATION_FLOWER_BLOCK)))));
        register(context, THORNED_VIOLET_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_VIOLET_FLOWER_BLOCK)))));
        register(context, THORNED_IRIS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_IRIS_FLOWER_BLOCK)))));
        register(context, THORNED_PRIMROSE_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK)))));
        register(context, THORNED_DAFFODIL_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK)))));
        register(context, THORNED_DELPHINIUM_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK)))));
        register(context, THORNED_DAHLIA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK)))));
        register(context, THORNED_HYDRANGEA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK)))));
        register(context, THORNED_MIDNIGHT_MYSTIC_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK)))));
        register(context, THORNED_HAWTHORN_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK)))));
        register(context, THORNED_BONSAI_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_BONSAI_FLOWER_BLOCK)))));
        register(context, THORNED_SPIDERLILY_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK)))));
        register(context, THORNED_LARKSPUR_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK)))));
        register(context, THORNED_AGAPANTHUS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK)))));
        register(context, THORNED_BLUE_COSMOS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK)))));
        register(context, THORNED_SNOW_DROP_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK)))));

        register(context, LUSH_CARNATION_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_CARNATION_FLOWER_BLOCK)))));
        register(context, LUSH_VIOLET_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_VIOLET_FLOWER_BLOCK)))));
        register(context, LUSH_IRIS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_IRIS_FLOWER_BLOCK)))));
        register(context, LUSH_PRIMROSE_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK)))));
        register(context, LUSH_DAFFODIL_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK)))));
        register(context, LUSH_DELPHINIUM_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK)))));
        register(context, LUSH_DAHLIA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK)))));
        register(context, LUSH_HYDRANGEA_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK)))));
        register(context, LUSH_MIDNIGHT_MYSTIC_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK)))));
        register(context, LUSH_HAWTHORN_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK)))));
        register(context, LUSH_BONSAI_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_BONSAI_FLOWER_BLOCK)))));
        register(context, LUSH_SPIDERLILY_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK)))));
        register(context, LUSH_LARKSPUR_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK)))));
        register(context, LUSH_AGAPANTHUS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK)))));
        register(context, LUSH_BLUE_COSMOS_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK)))));
        register(context, LUSH_SNOW_DROP_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK)))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Steamcraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}


