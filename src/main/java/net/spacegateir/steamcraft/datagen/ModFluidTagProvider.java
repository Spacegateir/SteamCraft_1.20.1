package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        FabricTagProvider<Fluid>.FabricTagBuilder waterFluidTagBuilder = this.getOrCreateTagBuilder(FluidTags.WATER);
        ModFluids.COLOR_TO_STILL_WATER.values().forEach(waterFluidTagBuilder::add);
        ModFluids.COLOR_TO_FLOWING_WATER.values().forEach(waterFluidTagBuilder::add);


        FabricTagProvider<Fluid>.FabricTagBuilder lavaFluidTagBuilder = this.getOrCreateTagBuilder(FluidTags.LAVA);
        ModFluids.COLOR_TO_STILL_LAVA.values().forEach(lavaFluidTagBuilder::add);
        ModFluids.COLOR_TO_STILL_LAVA.values().forEach(lavaFluidTagBuilder::add);

        for (DyeColor color : DyeColor.values()) {
            TagKey<Fluid> waterTag = ModTags.Fluids.createWaterTag(color);
            this.getOrCreateTagBuilder(waterTag)
                    .add(ModFluids.COLOR_TO_STILL_WATER.get(color))
                    .add(ModFluids.COLOR_TO_FLOWING_WATER.get(color));

            TagKey<Fluid> lavaTag = ModTags.Fluids.createLavaTag(color);
            this.getOrCreateTagBuilder(lavaTag)
                    .add(ModFluids.COLOR_TO_STILL_LAVA.get(color))
                    .add(ModFluids.COLOR_TO_FLOWING_LAVA.get(color));
        }
    }
}
