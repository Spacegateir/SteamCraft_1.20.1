package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.fluid.ModFluids;

import java.util.EnumMap;

public class ModFluidRendererRegistry {

    public static void registerFluidRenderers() {

        EnumMap<DyeColor, Integer> COLOR_TO_FLUID_COLOR = Util.make(new EnumMap<>(DyeColor.class), map -> {
            map.put(DyeColor.WHITE, 0xA1FFFFFF);
            map.put(DyeColor.LIGHT_GRAY, 0xFFA0A0A0);
            map.put(DyeColor.GRAY, 0xFF808080);
            map.put(DyeColor.BLACK, 0xA1DDD4CB);
            map.put(DyeColor.BROWN, 0xFF8B4513);
            map.put(DyeColor.RED, 0xFFFF0000);
            map.put(DyeColor.ORANGE, 0xFFFFA500);
            map.put(DyeColor.YELLOW, 0xFFFFFF00);
            map.put(DyeColor.LIME, 0xA15DFF07);
            map.put(DyeColor.GREEN, 0xFF008000);
            map.put(DyeColor.CYAN, 0xFF00FFFF);
            map.put(DyeColor.LIGHT_BLUE, 0xFFADD8E6);
            map.put(DyeColor.BLUE, 0xFF0000FF);
            map.put(DyeColor.PURPLE, 0xFF800080);
            map.put(DyeColor.MAGENTA, 0xFFFF00FF);
            map.put(DyeColor.PINK, 0xFFFFC0CB);
        });

        for (DyeColor color : DyeColor.values()) {
            FluidRenderHandlerRegistry.INSTANCE.register(
                    ModFluids.COLOR_TO_STILL_WATER.get(color), ModFluids.COLOR_TO_FLOWING_WATER.get(color),
                    ModFluidRenderHandler.coloredWater(
                            COLOR_TO_FLUID_COLOR.get(color),
                            new Identifier(Steamcraft.MOD_ID, "block/" + color.getName() + "_water_still"),
                            new Identifier(Steamcraft.MOD_ID, "block/" + color.getName() + "_water_flow")
                    )
            );

            FluidRenderHandlerRegistry.INSTANCE.register(
                    ModFluids.COLOR_TO_STILL_LAVA.get(color), ModFluids.COLOR_TO_FLOWING_LAVA.get(color),
                    ModFluidRenderHandler.coloredLava(
                            COLOR_TO_FLUID_COLOR.get(color),
                            new Identifier(Steamcraft.MOD_ID, "block/" + color.getName() + "_lava_still"),
                            new Identifier(Steamcraft.MOD_ID, "block/" + color.getName() + "_lava_flow")
                    )
            );
        }
    }
}
