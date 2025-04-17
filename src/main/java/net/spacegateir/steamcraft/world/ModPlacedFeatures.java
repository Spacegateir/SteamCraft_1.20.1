package net.spacegateir.steamcraft.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.spacegateir.steamcraft.Steamcraft;

import java.util.List;

public class ModPlacedFeatures {


    public static final RegistryKey<PlacedFeature> CARNATION_FLOWER_PLACED_KEY = registerKey("carnation_flower_placed");
    public static final RegistryKey<PlacedFeature> VIOLET_FLOWER_PLACED_KEY = registerKey("violet_flower_placed");
    public static final RegistryKey<PlacedFeature> IRIS_FLOWER_PLACED_KEY = registerKey("iris_flower_placed");
    public static final RegistryKey<PlacedFeature> PRIMROSE_FLOWER_PLACED_KEY = registerKey("primrose_flower_placed");
    public static final RegistryKey<PlacedFeature> DAFFODIL_FLOWER_PLACED_KEY = registerKey("daffodil_flower_placed");
    public static final RegistryKey<PlacedFeature> DELPHINIUM_FLOWER_PLACED_KEY = registerKey("delphinium_flower_placed");
    public static final RegistryKey<PlacedFeature> DAHLIA_FLOWER_PLACED_KEY = registerKey("dahlia_flower_placed");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_FLOWER_PLACED_KEY = registerKey("hydrangea_flower_placed");
    public static final RegistryKey<PlacedFeature> MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY = registerKey("midnight_mystic_flower_placed");
    public static final RegistryKey<PlacedFeature> HAWTHORN_FLOWER_PLACED_KEY = registerKey("hawthorn_flower_placed");
    public static final RegistryKey<PlacedFeature> BONSAI_FLOWER_PLACED_KEY = registerKey("bonsai_flower_placed");
    public static final RegistryKey<PlacedFeature> SPIDERLILY_FLOWER_PLACED_KEY = registerKey("spiderlily_flower_placed");
    public static final RegistryKey<PlacedFeature> LARKSPUR_FLOWER_PLACED_KEY = registerKey("larkspur_flower_placed");
    public static final RegistryKey<PlacedFeature> AGAPANTHUS_FLOWER_PLACED_KEY = registerKey("agapanthus_flower_placed");
    public static final RegistryKey<PlacedFeature> BLUE_COSMOS_FLOWER_PLACED_KEY = registerKey("blue_cosmos_flower_placed");
    public static final RegistryKey<PlacedFeature> SNOW_DROP_FLOWER_PLACED_KEY = registerKey("snow_drop_flower_placed");

    public static final RegistryKey<PlacedFeature> THORNED_CARNATION_FLOWER_PLACED_KEY = registerKey("thorned_carnation_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_VIOLET_FLOWER_PLACED_KEY = registerKey("thorned_violet_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_IRIS_FLOWER_PLACED_KEY = registerKey("thorned_iris_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_PRIMROSE_FLOWER_PLACED_KEY = registerKey("thorned_primrose_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_DAFFODIL_FLOWER_PLACED_KEY = registerKey("thorned_daffodil_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_DELPHINIUM_FLOWER_PLACED_KEY = registerKey("thorned_delphinium_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_DAHLIA_FLOWER_PLACED_KEY = registerKey("thorned_dahlia_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_HYDRANGEA_FLOWER_PLACED_KEY = registerKey("thorned_hydrangea_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY = registerKey("thorned_midnight_mystic_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_HAWTHORN_FLOWER_PLACED_KEY = registerKey("thorned_hawthorn_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_BONSAI_FLOWER_PLACED_KEY = registerKey("thorned_bonsai_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_SPIDERLILY_FLOWER_PLACED_KEY = registerKey("thorned_spiderlily_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_LARKSPUR_FLOWER_PLACED_KEY = registerKey("thorned_larkspur_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_AGAPANTHUS_FLOWER_PLACED_KEY = registerKey("thorned_agapanthus_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_BLUE_COSMOS_FLOWER_PLACED_KEY = registerKey("thorned_blue_cosmos_flower_placed");
    public static final RegistryKey<PlacedFeature> THORNED_SNOW_DROP_FLOWER_PLACED_KEY = registerKey("thorned_snow_drop_flower_placed");

    public static final RegistryKey<PlacedFeature> LUSH_CARNATION_FLOWER_PLACED_KEY = registerKey("lush_carnation_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_VIOLET_FLOWER_PLACED_KEY = registerKey("lush_violet_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_IRIS_FLOWER_PLACED_KEY = registerKey("lush_iris_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_PRIMROSE_FLOWER_PLACED_KEY = registerKey("lush_primrose_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_DAFFODIL_FLOWER_PLACED_KEY = registerKey("lush_daffodil_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_DELPHINIUM_FLOWER_PLACED_KEY = registerKey("lush_delphinium_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_DAHLIA_FLOWER_PLACED_KEY = registerKey("lush_dahlia_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_HYDRANGEA_FLOWER_PLACED_KEY = registerKey("lush_hydrangea_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY = registerKey("lush_midnight_mystic_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_HAWTHORN_FLOWER_PLACED_KEY = registerKey("lush_hawthorn_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_BONSAI_FLOWER_PLACED_KEY = registerKey("lush_bonsai_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_SPIDERLILY_FLOWER_PLACED_KEY = registerKey("lush_spiderlily_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_LARKSPUR_FLOWER_PLACED_KEY = registerKey("lush_larkspur_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_AGAPANTHUS_FLOWER_PLACED_KEY = registerKey("lush_agapanthus_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_BLUE_COSMOS_FLOWER_PLACED_KEY = registerKey("lush_blue_cosmos_flower_placed");
    public static final RegistryKey<PlacedFeature> LUSH_SNOW_DROP_FLOWER_PLACED_KEY = registerKey("lush_snow_drop_flower_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context, CARNATION_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CARNATION_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIOLET_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIOLET_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, IRIS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.IRIS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PRIMROSE_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PRIMROSE_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, DAFFODIL_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DAFFODIL_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, DELPHINIUM_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DELPHINIUM_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, DAHLIA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DAHLIA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HYDRANGEA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MIDNIGHT_MYSTIC_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HAWTHORN_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HAWTHORN_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BONSAI_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BONSAI_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SPIDERLILY_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPIDERLILY_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LARKSPUR_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LARKSPUR_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, AGAPANTHUS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AGAPANTHUS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_COSMOS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_COSMOS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SNOW_DROP_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SNOW_DROP_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, THORNED_CARNATION_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_CARNATION_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_VIOLET_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_VIOLET_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_IRIS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_IRIS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_PRIMROSE_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_PRIMROSE_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_DAFFODIL_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_DAFFODIL_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_DELPHINIUM_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_DELPHINIUM_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_DAHLIA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_DAHLIA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_HYDRANGEA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_HYDRANGEA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_MIDNIGHT_MYSTIC_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_HAWTHORN_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_HAWTHORN_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_BONSAI_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_BONSAI_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_SPIDERLILY_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_SPIDERLILY_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_LARKSPUR_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_LARKSPUR_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_AGAPANTHUS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_AGAPANTHUS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_BLUE_COSMOS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_BLUE_COSMOS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, THORNED_SNOW_DROP_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THORNED_SNOW_DROP_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, LUSH_CARNATION_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_CARNATION_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_VIOLET_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_VIOLET_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_IRIS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_IRIS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_PRIMROSE_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_PRIMROSE_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_DAFFODIL_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_DAFFODIL_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_DELPHINIUM_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_DELPHINIUM_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_DAHLIA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_DAHLIA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_HYDRANGEA_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_HYDRANGEA_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_MIDNIGHT_MYSTIC_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_MIDNIGHT_MYSTIC_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_HAWTHORN_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_HAWTHORN_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_BONSAI_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_BONSAI_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_SPIDERLILY_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_SPIDERLILY_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_LARKSPUR_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_LARKSPUR_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_AGAPANTHUS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_AGAPANTHUS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_BLUE_COSMOS_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_BLUE_COSMOS_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUSH_SNOW_DROP_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUSH_SNOW_DROP_FLOWERS_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Steamcraft.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
