package net.spacegateir.steamcraft.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.fluidblocks.*;
import net.spacegateir.steamcraft.fluid.lava.*;
import net.spacegateir.steamcraft.fluid.water.*;

public class ModFluids {

    // White
    public static final FlowableFluid STILL_WHITE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "white_water"), new WhiteWaterFluid.Still());
    public static final FlowableFluid FLOWING_WHITE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_white_water"), new WhiteWaterFluid.Flowing());
    public static final Block WHITE_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "white_water_block"), new ModFluidWhite(STILL_WHITE_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Light Gray
    public static final FlowableFluid STILL_LIGHT_GRAY_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "light_gray_water"), new LightGrayWaterFluid.Still());
    public static final FlowableFluid FLOWING_LIGHT_GRAY_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_light_gray_water"), new LightGrayWaterFluid.Flowing());
    public static final Block LIGHT_GRAY_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "light_gray_water_block"), new ModFluidLightGray(STILL_LIGHT_GRAY_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Gray
    public static final FlowableFluid STILL_GRAY_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "gray_water"), new GrayWaterFluid.Still());
    public static final FlowableFluid FLOWING_GRAY_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_gray_water"), new GrayWaterFluid.Flowing());
    public static final Block GRAY_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "gray_water_block"), new ModFluidGray(STILL_GRAY_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Black
    public static final FlowableFluid STILL_BLACK_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "black_water"), new BlackWaterFluid.Still());
    public static final FlowableFluid FLOWING_BLACK_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_black_water"), new BlackWaterFluid.Flowing());
    public static final Block BLACK_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "black_water_block"), new ModFluidBlack(STILL_BLACK_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Brown
    public static final FlowableFluid STILL_BROWN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "brown_water"), new BrownWaterFluid.Still());
    public static final FlowableFluid FLOWING_BROWN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_brown_water"), new BrownWaterFluid.Flowing());
    public static final Block BROWN_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "brown_water_block"), new ModFluidBrown(STILL_BROWN_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Red
    public static final FlowableFluid STILL_RED_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "red_water"), new RedWaterFluid.Still());
    public static final FlowableFluid FLOWING_RED_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_red_water"), new RedWaterFluid.Flowing());
    public static final Block RED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "red_water_block"), new ModFluidRed(STILL_RED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Orange
    public static final FlowableFluid STILL_ORANGE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "orange_water"), new OrangeWaterFluid.Still());
    public static final FlowableFluid FLOWING_ORANGE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_orange_water"), new OrangeWaterFluid.Flowing());
    public static final Block ORANGE_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "orange_water_block"), new ModFluidOrange(STILL_ORANGE_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Yellow
    public static final FlowableFluid STILL_YELLOW_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "yellow_water"), new YellowWaterFluid.Still());
    public static final FlowableFluid FLOWING_YELLOW_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_yellow_water"), new YellowWaterFluid.Flowing());
    public static final Block YELLOW_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "yellow_water_block"), new ModFluidYellow(STILL_YELLOW_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Lime
    public static final FlowableFluid STILL_LIME_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "lime_water"), new LimeWaterFluid.Still());
    public static final FlowableFluid FLOWING_LIME_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_lime_water"), new LimeWaterFluid.Flowing());
    public static final Block LIME_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "lime_water_block"), new ModFluidLime(STILL_LIME_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Green
    public static final FlowableFluid STILL_GREEN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "green_water"), new GreenWaterFluid.Still());
    public static final FlowableFluid FLOWING_GREEN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_green_water"), new GreenWaterFluid.Flowing());
    public static final Block GREEN_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "green_water_block"), new ModFluidGreen(STILL_GREEN_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Cyan
    public static final FlowableFluid STILL_CYAN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "cyan_water"), new CyanWaterFluid.Still());
    public static final FlowableFluid FLOWING_CYAN_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_cyan_water"), new CyanWaterFluid.Flowing());
    public static final Block CYAN_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "cyan_water_block"), new ModFluidCyan(STILL_CYAN_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Light Blue
    public static final FlowableFluid STILL_LIGHT_BLUE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "light_blue_water"), new LightBlueWaterFluid.Still());
    public static final FlowableFluid FLOWING_LIGHT_BLUE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_light_blue_water"), new LightBlueWaterFluid.Flowing());
    public static final Block LIGHT_BLUE_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "light_blue_water_block"), new ModFluidLightBlue(STILL_LIGHT_BLUE_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Blue
    public static final FlowableFluid STILL_BLUE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "blue_water"), new BlueWaterFluid.Still());
    public static final FlowableFluid FLOWING_BLUE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_blue_water"), new BlueWaterFluid.Flowing());
    public static final Block BLUE_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "blue_water_block"), new ModFluidBlue(STILL_BLUE_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Purple
    public static final FlowableFluid STILL_PURPLE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "purple_water"), new PurpleWaterFluid.Still());
    public static final FlowableFluid FLOWING_PURPLE_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_purple_water"), new PurpleWaterFluid.Flowing());
    public static final Block PURPLE_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "purple_water_block"), new ModFluidPurple(STILL_PURPLE_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Magenta
    public static final FlowableFluid STILL_MAGENTA_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "magenta_water"), new MagentaWaterFluid.Still());
    public static final FlowableFluid FLOWING_MAGENTA_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_magenta_water"), new MagentaWaterFluid.Flowing());
    public static final Block MAGENTA_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "magenta_water_block"), new ModFluidMagenta(STILL_MAGENTA_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));

    // Pink
    public static final FlowableFluid STILL_PINK_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "pink_water"), new PinkWaterFluid.Still());
    public static final FlowableFluid FLOWING_PINK_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_pink_water"), new PinkWaterFluid.Flowing());
    public static final Block PINK_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "pink_water_block"), new ModFluidPink(STILL_PINK_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));











    // White
    public static final FlowableFluid STILL_WHITE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "white_lava"), new WhiteLavaFluid.Still());
    public static final FlowableFluid FLOWING_WHITE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_white_lava"), new WhiteLavaFluid.Flowing());
    public static final Block WHITE_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "white_lava_block"), new ModFluidWhite(STILL_WHITE_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Light Gray
    public static final FlowableFluid STILL_LIGHT_GRAY_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "light_gray_lava"), new LightGrayLavaFluid.Still());
    public static final FlowableFluid FLOWING_LIGHT_GRAY_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_light_gray_lava"), new LightGrayLavaFluid.Flowing());
    public static final Block LIGHT_GRAY_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "light_gray_lava_block"), new ModFluidLightGray(STILL_LIGHT_GRAY_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));


    // Gray
    public static final FlowableFluid STILL_GRAY_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "gray_lava"), new GrayLavaFluid.Still());
    public static final FlowableFluid FLOWING_GRAY_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_gray_lava"), new GrayLavaFluid.Flowing());
    public static final Block GRAY_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "gray_lava_block"), new ModFluidGray(STILL_GRAY_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Black
    public static final FlowableFluid STILL_BLACK_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "black_lava"), new BlackLavaFluid.Still());
    public static final FlowableFluid FLOWING_BLACK_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_black_lava"), new BlackLavaFluid.Flowing());
    public static final Block BLACK_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "black_lava_block"), new ModFluidBlack(STILL_BLACK_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Brown
    public static final FlowableFluid STILL_BROWN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "brown_lava"), new BrownLavaFluid.Still());
    public static final FlowableFluid FLOWING_BROWN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_brown_lava"), new BrownLavaFluid.Flowing());
    public static final Block BROWN_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "brown_lava_block"), new ModFluidBrown(STILL_BROWN_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Red
    public static final FlowableFluid STILL_RED_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "red_lava"), new RedLavaFluid.Still());
    public static final FlowableFluid FLOWING_RED_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_red_lava"), new RedLavaFluid.Flowing());
    public static final Block RED_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "red_lava_block"), new ModFluidRed(STILL_RED_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Orange
    public static final FlowableFluid STILL_ORANGE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "orange_lava"), new OrangeLavaFluid.Still());
    public static final FlowableFluid FLOWING_ORANGE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_orange_lava"), new OrangeLavaFluid.Flowing());
    public static final Block ORANGE_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "orange_lava_block"), new ModFluidOrange(STILL_ORANGE_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Yellow
    public static final FlowableFluid STILL_YELLOW_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "yellow_lava"), new YellowLavaFluid.Still());
    public static final FlowableFluid FLOWING_YELLOW_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_yellow_lava"), new YellowLavaFluid.Flowing());
    public static final Block YELLOW_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "yellow_lava_block"), new ModFluidYellow(STILL_YELLOW_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Lime
    public static final FlowableFluid STILL_LIME_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "lime_lava"), new LimeLavaFluid.Still());
    public static final FlowableFluid FLOWING_LIME_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_lime_lava"), new LimeLavaFluid.Flowing());
    public static final Block LIME_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "lime_lava_block"), new ModFluidLime(STILL_LIME_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Green
    public static final FlowableFluid STILL_GREEN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "green_lava"), new GreenLavaFluid.Still());
    public static final FlowableFluid FLOWING_GREEN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_green_lava"), new GreenLavaFluid.Flowing());
    public static final Block GREEN_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "green_lava_block"), new ModFluidGreen(STILL_GREEN_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Cyan
    public static final FlowableFluid STILL_CYAN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "cyan_lava"), new CyanLavaFluid.Still());
    public static final FlowableFluid FLOWING_CYAN_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_cyan_lava"), new CyanLavaFluid.Flowing());
    public static final Block CYAN_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "cyan_lava_block"), new ModFluidCyan(STILL_CYAN_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Light Blue
    public static final FlowableFluid STILL_LIGHT_BLUE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "light_blue_lava"), new LightBlueLavaFluid.Still());
    public static final FlowableFluid FLOWING_LIGHT_BLUE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_light_blue_lava"), new LightBlueLavaFluid.Flowing());
    public static final Block LIGHT_BLUE_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "light_blue_lava_block"), new ModFluidLightBlue(STILL_LIGHT_BLUE_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Blue
    public static final FlowableFluid STILL_BLUE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "blue_lava"), new BlueLavaFluid.Still());
    public static final FlowableFluid FLOWING_BLUE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_blue_lava"), new BlueLavaFluid.Flowing());
    public static final Block BLUE_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "blue_lava_block"), new ModFluidBlue(STILL_BLUE_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Purple
    public static final FlowableFluid STILL_PURPLE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "purple_lava"), new PurpleLavaFluid.Still());
    public static final FlowableFluid FLOWING_PURPLE_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_purple_lava"), new PurpleLavaFluid.Flowing());
    public static final Block PURPLE_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "purple_lava_block"), new ModFluidPurple(STILL_PURPLE_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Magenta
    public static final FlowableFluid STILL_MAGENTA_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "magenta_lava"), new MagentaLavaFluid.Still());
    public static final FlowableFluid FLOWING_MAGENTA_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_magenta_lava"), new MagentaLavaFluid.Flowing());
    public static final Block MAGENTA_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "magenta_lava_block"), new ModFluidMagenta(STILL_MAGENTA_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));

    // Pink
    public static final FlowableFluid STILL_PINK_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "pink_lava"), new PinkLavaFluid.Still());
    public static final FlowableFluid FLOWING_PINK_LAVA = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_pink_lava"), new PinkLavaFluid.Flowing());
    public static final Block PINK_LAVA_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "pink_lava_block"), new ModFluidPink(STILL_PINK_LAVA, FabricBlockSettings.copyOf(Blocks.LAVA)
            .replaceable().liquid()));






    public static void registerFluids() {
        Steamcraft.LOGGER.info("Registering Fluid for " + Steamcraft.MOD_ID);
    }
}
