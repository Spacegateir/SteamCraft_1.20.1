package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
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
                        ModBlocks.AETHER_COIL_PINK

                );


    }
}