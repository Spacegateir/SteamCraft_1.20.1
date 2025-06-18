package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;

import java.util.HashMap;
import java.util.Map;

public class ModCropData {
    public static final Map<Block, ItemConvertible> SEED_MAP = new HashMap<>();
    public static final Map<Block, ItemConvertible> FLOWER_MAP = new HashMap<>();

    public static void register(Block crop, ItemConvertible seed, ItemConvertible flower) {
        SEED_MAP.put(crop, seed);
        FLOWER_MAP.put(crop, flower);
    }

    public static ItemConvertible getSeed(Block block) {
        return SEED_MAP.get(block);
    }

    public static ItemConvertible getFlower(Block block) {
        return FLOWER_MAP.get(block);
    }
}