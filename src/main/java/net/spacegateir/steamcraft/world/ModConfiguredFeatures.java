package net.spacegateir.steamcraft.world;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.spacegateir.steamcraft.Steamcraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.spacegateir.steamcraft.block.ModBlocks;

public class ModConfiguredFeatures {


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        for (Block flower : ModBlocks.COLOR_TO_FLOWER.values()) {
            registerFlowerFeature(context, flower);
            registerFlowerFeature(context, ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
            registerFlowerFeature(context, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
        }
    }

    private static void registerFlowerFeature(Registerable<ConfiguredFeature<?, ?>> context, Block flower) {
        register(context,
                RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Registries.BLOCK.getId(flower)),
                Feature.FLOWER,
                new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(flower)))));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> of(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Steamcraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}


