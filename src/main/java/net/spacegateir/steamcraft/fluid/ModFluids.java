package net.spacegateir.steamcraft.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;

import java.util.EnumMap;

public class ModFluids {

    public static final EnumMap<DyeColor, FlowableFluid> COLOR_TO_STILL_WATER = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, FlowableFluid> COLOR_TO_FLOWING_WATER = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> COLOR_TO_WATER_BLOCK = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, FlowableFluid> COLOR_TO_STILL_LAVA = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, FlowableFluid> COLOR_TO_FLOWING_LAVA = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> COLOR_TO_LAVA_BLOCK = new EnumMap<>(DyeColor.class);

    public static final FlowableFluid STILL_WHITE_WATER = registerStillWater(DyeColor.WHITE);
    public static final FlowableFluid FLOWING_WHITE_WATER = registerFlowingWater(DyeColor.WHITE);
    public static final Block WHITE_WATER_BLOCK = registerWaterBlock(DyeColor.WHITE);

    public static final FlowableFluid STILL_LIGHT_GRAY_WATER = registerStillWater(DyeColor.LIGHT_GRAY);
    public static final FlowableFluid FLOWING_LIGHT_GRAY_WATER = registerFlowingWater(DyeColor.LIGHT_GRAY);
    public static final Block LIGHT_GRAY_WATER_BLOCK = registerWaterBlock(DyeColor.LIGHT_GRAY);

    public static final FlowableFluid STILL_GRAY_WATER = registerStillWater(DyeColor.GRAY);
    public static final FlowableFluid FLOWING_GRAY_WATER = registerFlowingWater(DyeColor.GRAY);
    public static final Block GRAY_WATER_BLOCK = registerWaterBlock(DyeColor.GRAY);

    public static final FlowableFluid STILL_BLACK_WATER = registerStillWater(DyeColor.BLACK);
    public static final FlowableFluid FLOWING_BLACK_WATER = registerFlowingWater(DyeColor.BLACK);
    public static final Block BLACK_WATER_BLOCK = registerWaterBlock(DyeColor.BLACK);

    public static final FlowableFluid STILL_BROWN_WATER = registerStillWater(DyeColor.BROWN);
    public static final FlowableFluid FLOWING_BROWN_WATER = registerFlowingWater(DyeColor.BROWN);
    public static final Block BROWN_WATER_BLOCK = registerWaterBlock(DyeColor.BROWN);

    public static final FlowableFluid STILL_RED_WATER = registerStillWater(DyeColor.RED);
    public static final FlowableFluid FLOWING_RED_WATER = registerFlowingWater(DyeColor.RED);
    public static final Block RED_WATER_BLOCK = registerWaterBlock(DyeColor.RED);

    public static final FlowableFluid STILL_ORANGE_WATER = registerStillWater(DyeColor.ORANGE);
    public static final FlowableFluid FLOWING_ORANGE_WATER = registerFlowingWater(DyeColor.ORANGE);
    public static final Block ORANGE_WATER_BLOCK = registerWaterBlock(DyeColor.ORANGE);

    public static final FlowableFluid STILL_YELLOW_WATER = registerStillWater(DyeColor.YELLOW);
    public static final FlowableFluid FLOWING_YELLOW_WATER = registerFlowingWater(DyeColor.YELLOW);
    public static final Block YELLOW_WATER_BLOCK = registerWaterBlock(DyeColor.YELLOW);

    public static final FlowableFluid STILL_LIME_WATER = registerStillWater(DyeColor.LIME);
    public static final FlowableFluid FLOWING_LIME_WATER = registerFlowingWater(DyeColor.LIME);
    public static final Block LIME_WATER_BLOCK = registerWaterBlock(DyeColor.LIME);

    public static final FlowableFluid STILL_GREEN_WATER = registerStillWater(DyeColor.GREEN);
    public static final FlowableFluid FLOWING_GREEN_WATER = registerFlowingWater(DyeColor.GREEN);
    public static final Block GREEN_WATER_BLOCK = registerWaterBlock(DyeColor.GREEN);

    public static final FlowableFluid STILL_CYAN_WATER = registerStillWater(DyeColor.CYAN);
    public static final FlowableFluid FLOWING_CYAN_WATER = registerFlowingWater(DyeColor.CYAN);
    public static final Block CYAN_WATER_BLOCK = registerWaterBlock(DyeColor.CYAN);

    public static final FlowableFluid STILL_LIGHT_BLUE_WATER = registerStillWater(DyeColor.LIGHT_BLUE);
    public static final FlowableFluid FLOWING_LIGHT_BLUE_WATER = registerFlowingWater(DyeColor.LIGHT_BLUE);
    public static final Block LIGHT_BLUE_WATER_BLOCK = registerWaterBlock(DyeColor.LIGHT_BLUE);

    public static final FlowableFluid STILL_BLUE_WATER = registerStillWater(DyeColor.BLUE);
    public static final FlowableFluid FLOWING_BLUE_WATER = registerFlowingWater(DyeColor.BLUE);
    public static final Block BLUE_WATER_BLOCK = registerWaterBlock(DyeColor.BLUE);

    public static final FlowableFluid STILL_PURPLE_WATER = registerStillWater(DyeColor.PURPLE);
    public static final FlowableFluid FLOWING_PURPLE_WATER = registerFlowingWater(DyeColor.PURPLE);
    public static final Block PURPLE_WATER_BLOCK = registerWaterBlock(DyeColor.PURPLE);

    public static final FlowableFluid STILL_MAGENTA_WATER = registerStillWater(DyeColor.MAGENTA);
    public static final FlowableFluid FLOWING_MAGENTA_WATER = registerFlowingWater(DyeColor.MAGENTA);
    public static final Block MAGENTA_WATER_BLOCK = registerWaterBlock(DyeColor.MAGENTA);

    public static final FlowableFluid STILL_PINK_WATER = registerStillWater(DyeColor.PINK);
    public static final FlowableFluid FLOWING_PINK_WATER = registerFlowingWater(DyeColor.PINK);
    public static final Block PINK_WATER_BLOCK = registerWaterBlock(DyeColor.PINK);



    public static final FlowableFluid STILL_WHITE_LAVA = registerStillLava(DyeColor.WHITE);
    public static final FlowableFluid FLOWING_WHITE_LAVA = registerFlowingLava(DyeColor.WHITE);
    public static final Block WHITE_LAVA_BLOCK = registerLavaBlock(DyeColor.WHITE);

    public static final FlowableFluid STILL_LIGHT_GRAY_LAVA = registerStillLava(DyeColor.LIGHT_GRAY);
    public static final FlowableFluid FLOWING_LIGHT_GRAY_LAVA = registerFlowingLava(DyeColor.LIGHT_GRAY);
    public static final Block LIGHT_GRAY_LAVA_BLOCK = registerLavaBlock(DyeColor.LIGHT_GRAY);

    public static final FlowableFluid STILL_GRAY_LAVA = registerStillLava(DyeColor.GRAY);
    public static final FlowableFluid FLOWING_GRAY_LAVA = registerFlowingLava(DyeColor.GRAY);
    public static final Block GRAY_LAVA_BLOCK = registerLavaBlock(DyeColor.GRAY);

    public static final FlowableFluid STILL_BLACK_LAVA = registerStillLava(DyeColor.BLACK);
    public static final FlowableFluid FLOWING_BLACK_LAVA = registerFlowingLava(DyeColor.BLACK);
    public static final Block BLACK_LAVA_BLOCK = registerLavaBlock(DyeColor.BLACK);

    public static final FlowableFluid STILL_BROWN_LAVA = registerStillLava(DyeColor.BROWN);
    public static final FlowableFluid FLOWING_BROWN_LAVA = registerFlowingLava(DyeColor.BROWN);
    public static final Block BROWN_LAVA_BLOCK = registerLavaBlock(DyeColor.BROWN);

    public static final FlowableFluid STILL_RED_LAVA = registerStillLava(DyeColor.RED);
    public static final FlowableFluid FLOWING_RED_LAVA = registerFlowingLava(DyeColor.RED);
    public static final Block RED_LAVA_BLOCK = registerLavaBlock(DyeColor.RED);

    public static final FlowableFluid STILL_ORANGE_LAVA = registerStillLava(DyeColor.ORANGE);
    public static final FlowableFluid FLOWING_ORANGE_LAVA = registerFlowingLava(DyeColor.ORANGE);
    public static final Block ORANGE_LAVA_BLOCK = registerLavaBlock(DyeColor.ORANGE);

    public static final FlowableFluid STILL_YELLOW_LAVA = registerStillLava(DyeColor.YELLOW);
    public static final FlowableFluid FLOWING_YELLOW_LAVA = registerFlowingLava(DyeColor.YELLOW);
    public static final Block YELLOW_LAVA_BLOCK = registerLavaBlock(DyeColor.YELLOW);

    public static final FlowableFluid STILL_LIME_LAVA = registerStillLava(DyeColor.LIME);
    public static final FlowableFluid FLOWING_LIME_LAVA = registerFlowingLava(DyeColor.LIME);
    public static final Block LIME_LAVA_BLOCK = registerLavaBlock(DyeColor.LIME);

    public static final FlowableFluid STILL_GREEN_LAVA = registerStillLava(DyeColor.GREEN);
    public static final FlowableFluid FLOWING_GREEN_LAVA = registerFlowingLava(DyeColor.GREEN);
    public static final Block GREEN_LAVA_BLOCK = registerLavaBlock(DyeColor.GREEN);

    public static final FlowableFluid STILL_CYAN_LAVA = registerStillLava(DyeColor.CYAN);
    public static final FlowableFluid FLOWING_CYAN_LAVA = registerFlowingLava(DyeColor.CYAN);
    public static final Block CYAN_LAVA_BLOCK = registerLavaBlock(DyeColor.CYAN);

    public static final FlowableFluid STILL_LIGHT_BLUE_LAVA = registerStillLava(DyeColor.LIGHT_BLUE);
    public static final FlowableFluid FLOWING_LIGHT_BLUE_LAVA = registerFlowingLava(DyeColor.LIGHT_BLUE);
    public static final Block LIGHT_BLUE_LAVA_BLOCK = registerLavaBlock(DyeColor.LIGHT_BLUE);

    public static final FlowableFluid STILL_BLUE_LAVA = registerStillLava(DyeColor.BLUE);
    public static final FlowableFluid FLOWING_BLUE_LAVA = registerFlowingLava(DyeColor.BLUE);
    public static final Block BLUE_LAVA_BLOCK = registerLavaBlock(DyeColor.BLUE);

    public static final FlowableFluid STILL_PURPLE_LAVA = registerStillLava(DyeColor.PURPLE);
    public static final FlowableFluid FLOWING_PURPLE_LAVA = registerFlowingLava(DyeColor.PURPLE);
    public static final Block PURPLE_LAVA_BLOCK = registerLavaBlock(DyeColor.PURPLE);

    public static final FlowableFluid STILL_MAGENTA_LAVA = registerStillLava(DyeColor.MAGENTA);
    public static final FlowableFluid FLOWING_MAGENTA_LAVA = registerFlowingLava(DyeColor.MAGENTA);
    public static final Block MAGENTA_LAVA_BLOCK = registerLavaBlock(DyeColor.MAGENTA);

    public static final FlowableFluid STILL_PINK_LAVA = registerStillLava(DyeColor.PINK);
    public static final FlowableFluid FLOWING_PINK_LAVA = registerFlowingLava(DyeColor.PINK);
    public static final Block PINK_LAVA_BLOCK = registerLavaBlock(DyeColor.PINK);


    private static FlowableFluid registerStillWater(DyeColor color) {
        DyedWaterFluid.Still fluid = new DyedWaterFluid.Still(color);
        COLOR_TO_STILL_WATER.put(color, fluid);
        return Registry.register(Registries.FLUID, new Identifier(Steamcraft.MOD_ID, color.getName() + "_water"), fluid);
    }

    private static FlowableFluid registerFlowingWater(DyeColor color) {
        DyedWaterFluid.Flowing fluid = new DyedWaterFluid.Flowing(color);
        COLOR_TO_FLOWING_WATER.put(color, fluid);
        return Registry.register(Registries.FLUID, new Identifier(Steamcraft.MOD_ID, "flowing_" + color.getName() + "_water"), fluid);
    }

    private static Block registerWaterBlock(DyeColor color) {
        DyedFluidBlock block = new DyedFluidBlock(COLOR_TO_STILL_WATER.get(color), color, FabricBlockSettings.copyOf(Blocks.WATER)
                .replaceable().liquid());
        COLOR_TO_WATER_BLOCK.put(color, block);
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
                color.getName() + "_water"), block);
    }

    private static FlowableFluid registerStillLava(DyeColor color) {
        DyedLavaFluid.Still fluid = new DyedLavaFluid.Still(color);
        COLOR_TO_STILL_LAVA.put(color, fluid);
        return Registry.register(Registries.FLUID, new Identifier(Steamcraft.MOD_ID, color.getName() + "_lava"), fluid);
    }

    private static FlowableFluid registerFlowingLava(DyeColor color) {
        DyedLavaFluid.Flowing fluid = new DyedLavaFluid.Flowing(color);
        COLOR_TO_FLOWING_LAVA.put(color, fluid);
        return Registry.register(Registries.FLUID, new Identifier(Steamcraft.MOD_ID, "flowing_" + color.getName() + "_lava"), fluid);
    }

    private static Block registerLavaBlock(DyeColor color) {
        DyedFluidBlock block = new DyedFluidBlock(COLOR_TO_STILL_LAVA.get(color), color, FabricBlockSettings.copyOf(Blocks.LAVA)
                .replaceable().liquid());
        COLOR_TO_LAVA_BLOCK.put(color, block);
        return Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
                color.getName() + "_lava"), block);
    }

    public static void registerFluids() {
        Steamcraft.LOGGER.info("Registering Fluids");
    }
}
