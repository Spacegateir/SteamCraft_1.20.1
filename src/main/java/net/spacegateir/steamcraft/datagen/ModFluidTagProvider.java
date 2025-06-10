package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        this.getOrCreateTagBuilder(FluidTags.WATER)

                .add(ModFluids.FLOWING_WHITE_WATER)
                .add(ModFluids.STILL_WHITE_WATER)
                .add(ModFluids.FLOWING_LIGHT_GRAY_WATER)
                .add(ModFluids.STILL_LIGHT_GRAY_WATER)
                .add(ModFluids.FLOWING_GRAY_WATER)
                .add(ModFluids.STILL_GRAY_WATER)
                .add(ModFluids.FLOWING_BLACK_WATER)
                .add(ModFluids.STILL_BLACK_WATER)
                .add(ModFluids.FLOWING_BROWN_WATER)
                .add(ModFluids.STILL_BROWN_WATER)
                .add(ModFluids.FLOWING_RED_WATER)
                .add(ModFluids.STILL_RED_WATER)
                .add(ModFluids.FLOWING_ORANGE_WATER)
                .add(ModFluids.STILL_ORANGE_WATER)
                .add(ModFluids.FLOWING_YELLOW_WATER)
                .add(ModFluids.STILL_YELLOW_WATER)
                .add(ModFluids.FLOWING_LIME_WATER)
                .add(ModFluids.STILL_LIME_WATER)
                .add(ModFluids.FLOWING_GREEN_WATER)
                .add(ModFluids.STILL_GREEN_WATER)
                .add(ModFluids.FLOWING_CYAN_WATER)
                .add(ModFluids.STILL_CYAN_WATER)
                .add(ModFluids.FLOWING_LIGHT_BLUE_WATER)
                .add(ModFluids.STILL_LIGHT_BLUE_WATER)
                .add(ModFluids.FLOWING_BLUE_WATER)
                .add(ModFluids.STILL_BLUE_WATER)
                .add(ModFluids.FLOWING_PURPLE_WATER)
                .add(ModFluids.STILL_PURPLE_WATER)
                .add(ModFluids.FLOWING_MAGENTA_WATER)
                .add(ModFluids.STILL_MAGENTA_WATER)
                .add(ModFluids.FLOWING_PINK_WATER)
                .add(ModFluids.STILL_PINK_WATER);


        this.getOrCreateTagBuilder(FluidTags.LAVA)

                .add(ModFluids.FLOWING_WHITE_LAVA)
                .add(ModFluids.STILL_WHITE_LAVA)
                .add(ModFluids.FLOWING_LIGHT_GRAY_LAVA)
                .add(ModFluids.STILL_LIGHT_GRAY_LAVA)
                .add(ModFluids.FLOWING_GRAY_LAVA)
                .add(ModFluids.STILL_GRAY_LAVA)
                .add(ModFluids.FLOWING_BLACK_LAVA)
                .add(ModFluids.STILL_BLACK_LAVA)
                .add(ModFluids.FLOWING_BROWN_LAVA)
                .add(ModFluids.STILL_BROWN_LAVA)
                .add(ModFluids.FLOWING_RED_LAVA)
                .add(ModFluids.STILL_RED_LAVA)
                .add(ModFluids.FLOWING_ORANGE_LAVA)
                .add(ModFluids.STILL_ORANGE_LAVA)
                .add(ModFluids.FLOWING_YELLOW_LAVA)
                .add(ModFluids.STILL_YELLOW_LAVA)
                .add(ModFluids.FLOWING_LIME_LAVA)
                .add(ModFluids.STILL_LIME_LAVA)
                .add(ModFluids.FLOWING_GREEN_LAVA)
                .add(ModFluids.STILL_GREEN_LAVA)
                .add(ModFluids.FLOWING_CYAN_LAVA)
                .add(ModFluids.STILL_CYAN_LAVA)
                .add(ModFluids.FLOWING_LIGHT_BLUE_LAVA)
                .add(ModFluids.STILL_LIGHT_BLUE_LAVA)
                .add(ModFluids.FLOWING_BLUE_LAVA)
                .add(ModFluids.STILL_BLUE_LAVA)
                .add(ModFluids.FLOWING_PURPLE_LAVA)
                .add(ModFluids.STILL_PURPLE_LAVA)
                .add(ModFluids.FLOWING_MAGENTA_LAVA)
                .add(ModFluids.STILL_MAGENTA_LAVA)
                .add(ModFluids.FLOWING_PINK_LAVA)
                .add(ModFluids.STILL_PINK_LAVA)

                .add(ModFluids.FLOWING_FOOLS_GOLD_LAVA)
                .add(ModFluids.STILL_FOOLS_GOLD_LAVA)
                .add(ModFluids.FLOWING_DIVINITITE_ALLOY_LAVA)
                .add(ModFluids.STILL_DIVINITITE_ALLOY_LAVA);


    }
}
