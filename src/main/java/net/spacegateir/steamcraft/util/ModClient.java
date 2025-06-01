package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.minecraft.fluid.FlowableFluid;

import java.util.Map;
import java.util.function.Supplier;

public class ModClient {

    private record LavaFluidData(Supplier<FlowableFluid> still, Supplier<FlowableFluid> flowing, int color, String textureBase) {}
    private record WaterFluidData(Supplier<FlowableFluid> still, Supplier<FlowableFluid> flowing, int color, String textureBase) {}

    public static void registerFluidRenderers() {
        // Register lava fluids
        Map<String, LavaFluidData> lavaFluids = Map.ofEntries(
                Map.entry("white", new LavaFluidData(() -> ModFluids.STILL_WHITE_LAVA, () -> ModFluids.FLOWING_WHITE_LAVA, 0xA1FFFFFF, "white_lava")),
                Map.entry("light_gray", new LavaFluidData(() -> ModFluids.STILL_LIGHT_GRAY_LAVA, () -> ModFluids.FLOWING_LIGHT_GRAY_LAVA, 0xFFA0A0A0, "light_gray_lava")),
                Map.entry("gray", new LavaFluidData(() -> ModFluids.STILL_GRAY_LAVA, () -> ModFluids.FLOWING_GRAY_LAVA, 0xFF808080, "gray_lava")),
                Map.entry("black", new LavaFluidData(() -> ModFluids.STILL_BLACK_LAVA, () -> ModFluids.FLOWING_BLACK_LAVA, 0xA1DDD4CB, "black_lava")),
                Map.entry("brown", new LavaFluidData(() -> ModFluids.STILL_BROWN_LAVA, () -> ModFluids.FLOWING_BROWN_LAVA, 0xFF8B4513, "brown_lava")),
                Map.entry("red", new LavaFluidData(() -> ModFluids.STILL_RED_LAVA, () -> ModFluids.FLOWING_RED_LAVA, 0xFFFF0000, "red_lava")),
                Map.entry("orange", new LavaFluidData(() -> ModFluids.STILL_ORANGE_LAVA, () -> ModFluids.FLOWING_ORANGE_LAVA, 0xFFFFA500, "orange_lava")),
                Map.entry("yellow", new LavaFluidData(() -> ModFluids.STILL_YELLOW_LAVA, () -> ModFluids.FLOWING_YELLOW_LAVA, 0xFFFFFF00, "yellow_lava")),
                Map.entry("lime", new LavaFluidData(() -> ModFluids.STILL_LIME_LAVA, () -> ModFluids.FLOWING_LIME_LAVA, 0xA15DFF07, "lime_lava")),
                Map.entry("green", new LavaFluidData(() -> ModFluids.STILL_GREEN_LAVA, () -> ModFluids.FLOWING_GREEN_LAVA, 0xFF008000, "green_lava")),
                Map.entry("cyan", new LavaFluidData(() -> ModFluids.STILL_CYAN_LAVA, () -> ModFluids.FLOWING_CYAN_LAVA, 0xFF00FFFF, "cyan_lava")),
                Map.entry("light_blue", new LavaFluidData(() -> ModFluids.STILL_LIGHT_BLUE_LAVA, () -> ModFluids.FLOWING_LIGHT_BLUE_LAVA, 0xFFADD8E6, "light_blue_lava")),
                Map.entry("blue", new LavaFluidData(() -> ModFluids.STILL_BLUE_LAVA, () -> ModFluids.FLOWING_BLUE_LAVA, 0xFF0000FF, "blue_lava")),
                Map.entry("purple", new LavaFluidData(() -> ModFluids.STILL_PURPLE_LAVA, () -> ModFluids.FLOWING_PURPLE_LAVA, 0xFF800080, "purple_lava")),
                Map.entry("magenta", new LavaFluidData(() -> ModFluids.STILL_MAGENTA_LAVA, () -> ModFluids.FLOWING_MAGENTA_LAVA, 0xFFFF00FF, "magenta_lava")),
                Map.entry("pink", new LavaFluidData(() -> ModFluids.STILL_PINK_LAVA, () -> ModFluids.FLOWING_PINK_LAVA, 0xFFFFC0CB, "pink_lava"))
        );

        lavaFluids.forEach((name, data) -> {
            FluidRenderHandlerRegistry.INSTANCE.register(
                    data.still().get(), data.flowing().get(),
                    ModFluidRenderHandler.coloredLava(
                            data.color(),
                            new Identifier(Steamcraft.MOD_ID, "block/" + data.textureBase() + "_still"),
                            new Identifier(Steamcraft.MOD_ID, "block/" + data.textureBase() + "_flow")
                    )
            );
        });

        // Register water fluids
        Map<String, WaterFluidData> waterFluids = Map.ofEntries(
                Map.entry("white", new WaterFluidData(() -> ModFluids.STILL_WHITE_WATER, () -> ModFluids.FLOWING_WHITE_WATER, 0xA1FFFFFF, "white_water")),
                Map.entry("light_gray", new WaterFluidData(() -> ModFluids.STILL_LIGHT_GRAY_WATER, () -> ModFluids.FLOWING_LIGHT_GRAY_WATER, 0xFFA0A0A0, "light_gray_water")),
                Map.entry("gray", new WaterFluidData(() -> ModFluids.STILL_GRAY_WATER, () -> ModFluids.FLOWING_GRAY_WATER, 0xFF808080, "gray_water")),
                Map.entry("black", new WaterFluidData(() -> ModFluids.STILL_BLACK_WATER, () -> ModFluids.FLOWING_BLACK_WATER, 0xA1DDD4CB, "black_water")),
                Map.entry("brown", new WaterFluidData(() -> ModFluids.STILL_BROWN_WATER, () -> ModFluids.FLOWING_BROWN_WATER, 0xFF8B4513, "brown_water")),
                Map.entry("red", new WaterFluidData(() -> ModFluids.STILL_RED_WATER, () -> ModFluids.FLOWING_RED_WATER, 0xFFFF0000, "red_water")),
                Map.entry("orange", new WaterFluidData(() -> ModFluids.STILL_ORANGE_WATER, () -> ModFluids.FLOWING_ORANGE_WATER, 0xFFFFA500, "orange_water")),
                Map.entry("yellow", new WaterFluidData(() -> ModFluids.STILL_YELLOW_WATER, () -> ModFluids.FLOWING_YELLOW_WATER, 0xFFFFFF00, "yellow_water")),
                Map.entry("lime", new WaterFluidData(() -> ModFluids.STILL_LIME_WATER, () -> ModFluids.FLOWING_LIME_WATER, 0xA15DFF07, "lime_water")),
                Map.entry("green", new WaterFluidData(() -> ModFluids.STILL_GREEN_WATER, () -> ModFluids.FLOWING_GREEN_WATER, 0xFF008000, "green_water")),
                Map.entry("cyan", new WaterFluidData(() -> ModFluids.STILL_CYAN_WATER, () -> ModFluids.FLOWING_CYAN_WATER, 0xFF00FFFF, "cyan_water")),
                Map.entry("light_blue", new WaterFluidData(() -> ModFluids.STILL_LIGHT_BLUE_WATER, () -> ModFluids.FLOWING_LIGHT_BLUE_WATER, 0xFFADD8E6, "light_blue_water")),
                Map.entry("blue", new WaterFluidData(() -> ModFluids.STILL_BLUE_WATER, () -> ModFluids.FLOWING_BLUE_WATER, 0xFF0000FF, "blue_water")),
                Map.entry("purple", new WaterFluidData(() -> ModFluids.STILL_PURPLE_WATER, () -> ModFluids.FLOWING_PURPLE_WATER, 0xFF800080, "purple_water")),
                Map.entry("magenta", new WaterFluidData(() -> ModFluids.STILL_MAGENTA_WATER, () -> ModFluids.FLOWING_MAGENTA_WATER, 0xFFFF00FF, "magenta_water")),
                Map.entry("pink", new WaterFluidData(() -> ModFluids.STILL_PINK_WATER, () -> ModFluids.FLOWING_PINK_WATER, 0xFFFFC0CB, "pink_water"))
        );

        waterFluids.forEach((name, data) -> {
            FluidRenderHandlerRegistry.INSTANCE.register(
                    data.still().get(), data.flowing().get(),
                    ModFluidRenderHandler.coloredWater(
                            data.color(),
                            new Identifier(Steamcraft.MOD_ID, "block/" + data.textureBase() + "_still"),
                            new Identifier(Steamcraft.MOD_ID, "block/" + data.textureBase() + "_flow")
                    )
            );
        });
    }
}
