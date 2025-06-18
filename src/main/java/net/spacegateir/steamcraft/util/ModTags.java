package net.spacegateir.steamcraft.util;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> SKELETON = createBlockTag("skeleton");
        public static final TagKey<Block> ARCANE_BLOCKS = createBlockTag("arcane_blocks");
        public static final TagKey<Block> AETHER_BLOCKS = createBlockTag("aether_blocks");
        public static final TagKey<Block> TRAPS = createBlockTag("traps");
        public static final TagKey<Block> BUILDING_BLOCKS = createBlockTag("building_blocks");
        public static final TagKey<Block> STONE_PATH_BLOCKS = createBlockTag("path_blocks");
        public static final TagKey<Block> SOIL_PATH_BLOCKS = createBlockTag("path_blocks");
        public static final TagKey<Block> FLOWER_SEEDS = createBlockTag("flower_seeds");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Steamcraft.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> DYES = createItemTag("dyes");
        public static final TagKey<Item> AETHER_COIL = createItemTag("aether_coil");
        public static final TagKey<Item> ANCIENT_GEMS = createItemTag("ancient_gems");

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Steamcraft.MOD_ID, name));
        }
    }


    public static class Fluids {

        public static final TagKey<Fluid> LAVA_DL = createFluidTag("lava_dl");

        public static final TagKey<Fluid> WHITE_LAVA_DL = createFluidTag("white_lava_dl");
        public static final TagKey<Fluid> ORANGE_LAVA_DL = createFluidTag("orange_lava_dl");
        public static final TagKey<Fluid> MAGENTA_LAVA_DL = createFluidTag("magenta_lava_dl");
        public static final TagKey<Fluid> LIGHT_BLUE_LAVA_DL = createFluidTag("light_blue_lava_dl");
        public static final TagKey<Fluid> YELLOW_LAVA_DL = createFluidTag("yellow_lava_dl");
        public static final TagKey<Fluid> LIME_LAVA_DL = createFluidTag("lime_lava_dl");
        public static final TagKey<Fluid> PINK_LAVA_DL = createFluidTag("pink_lava_dl");
        public static final TagKey<Fluid> GRAY_LAVA_DL = createFluidTag("gray_lava_dl");
        public static final TagKey<Fluid> LIGHT_GRAY_LAVA_DL = createFluidTag("light_gray_lava_dl");
        public static final TagKey<Fluid> CYAN_LAVA_DL = createFluidTag("cyan_lava_dl");
        public static final TagKey<Fluid> PURPLE_LAVA_DL = createFluidTag("purple_lava_dl");
        public static final TagKey<Fluid> BLUE_LAVA_DL = createFluidTag("blue_lava_dl");
        public static final TagKey<Fluid> BROWN_LAVA_DL = createFluidTag("brown_lava_dl");
        public static final TagKey<Fluid> GREEN_LAVA_DL = createFluidTag("green_lava_dl");
        public static final TagKey<Fluid> RED_LAVA_DL = createFluidTag("red_lava_dl");
        public static final TagKey<Fluid> BLACK_LAVA_DL = createFluidTag("black_lava_dl");

        public static final TagKey<Fluid> WATER_DL = createFluidTag("water_dl");

        public static final TagKey<Fluid> WHITE_WATER_DL = createFluidTag("white_water_dl");
        public static final TagKey<Fluid> ORANGE_WATER_DL = createFluidTag("orange_water_dl");
        public static final TagKey<Fluid> MAGENTA_WATER_DL = createFluidTag("magenta_water_dl");
        public static final TagKey<Fluid> LIGHT_BLUE_WATER_DL = createFluidTag("light_blue_water_dl");
        public static final TagKey<Fluid> YELLOW_WATER_DL = createFluidTag("yellow_water_dl");
        public static final TagKey<Fluid> LIME_WATER_DL = createFluidTag("lime_water_dl");
        public static final TagKey<Fluid> PINK_WATER_DL = createFluidTag("pink_water_dl");
        public static final TagKey<Fluid> GRAY_WATER_DL = createFluidTag("gray_water_dl");
        public static final TagKey<Fluid> LIGHT_GRAY_WATER_DL = createFluidTag("light_gray_water_dl");
        public static final TagKey<Fluid> CYAN_WATER_DL = createFluidTag("cyan_water_dl");
        public static final TagKey<Fluid> PURPLE_WATER_DL = createFluidTag("purple_water_dl");
        public static final TagKey<Fluid> BLUE_WATER_DL = createFluidTag("blue_water_dl");
        public static final TagKey<Fluid> BROWN_WATER_DL = createFluidTag("brown_water_dl");
        public static final TagKey<Fluid> GREEN_WATER_DL = createFluidTag("green_water_dl");
        public static final TagKey<Fluid> RED_WATER_DL = createFluidTag("red_water_dl");
        public static final TagKey<Fluid> BLACK_WATER_DL = createFluidTag("black_water_dl");


        public static final TagKey<Fluid> MOLTEN_METALS = createFluidTag("molten_metals");

        public static final TagKey<Fluid> FOOLS_GOLD_MM = createFluidTag("fools_gold_mm");
        public static final TagKey<Fluid> DIVINITITE_ALLOY_MM = createFluidTag("divinitite_alloy_mm");


        private static TagKey<Fluid> createFluidTag(String name) {
            return TagKey.of(RegistryKeys.FLUID, new Identifier(Steamcraft.MOD_ID, name));
        }
    }
}
