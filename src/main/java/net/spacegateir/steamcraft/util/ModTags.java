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
    }
}
