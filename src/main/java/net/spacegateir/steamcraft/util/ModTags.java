package net.spacegateir.steamcraft.util;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;

import java.util.EnumMap;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Steamcraft.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }

    public static class Items {

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Steamcraft.MOD_ID, name));
        }

        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }
    }

    public static class Fluids {

        public static final TagKey<Fluid> LAVA_DL = createFluidTag("lava_dl");

        public static final TagKey<Fluid> WATER_DL = createFluidTag("water_dl");


        private static TagKey<Fluid> createFluidTag(String name) {
            return TagKey.of(RegistryKeys.FLUID, new Identifier(Steamcraft.MOD_ID, name));
        }

        public static TagKey<Fluid> createWaterTag(DyeColor color) {
            String name = color.getName() + "_water_dl";
            return TagKey.of(RegistryKeys.FLUID, new Identifier(Steamcraft.MOD_ID, name));
        }

        public static TagKey<Fluid> createLavaTag(DyeColor color) {
            String name = color.getName() + "_water_dl";
            return TagKey.of(RegistryKeys.FLUID, new Identifier(Steamcraft.MOD_ID, name));
        }

        private static TagKey<Fluid> createCommonFluidTag(String name) {
            return TagKey.of(RegistryKeys.FLUID, new Identifier("c", name));
        }
    }
}
