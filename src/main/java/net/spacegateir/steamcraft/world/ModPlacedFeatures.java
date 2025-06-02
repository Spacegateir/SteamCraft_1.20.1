package net.spacegateir.steamcraft.world;

import net.minecraft.block.Block;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var lookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        for (Block flower : ModBlocks.COLOR_TO_FLOWER.values()) {
            registerFlowerFeature(context, lookup, flower);
            registerFlowerFeature(context, lookup, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
            registerFlowerFeature(context, lookup, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
        }
    }

    private static void registerFlowerFeature(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> lookup, Block flower) {
        register(context,
                getKey(flower),
                lookup.getOrThrow(RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Registries.BLOCK.getId(flower))),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> getKey(Block flower) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Registries.BLOCK.getId(flower));
    }

    public static RegistryKey<PlacedFeature> of(String name) {
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
