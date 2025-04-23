package net.spacegateir.steamcraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ShovelItem;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.lang.reflect.Field;
import java.util.Map;

public class ShovelPathStateInjector {
    @SuppressWarnings("unchecked")
    public static void inject() {
        try {
            Field pathStatesField = ShovelItem.class.getDeclaredField("PATH_STATES");
            pathStatesField.setAccessible(true);

            Map<Block, BlockState> pathStates = (Map<Block, BlockState>) pathStatesField.get(null);
            pathStates.put(Blocks.CLAY, ModBlocks.CLAY_PATH.getDefaultState());
            pathStates.put(Blocks.COARSE_DIRT, ModBlocks.COARSE_DIRT_PATH.getDefaultState());
            pathStates.put(Blocks.DIRT_PATH, ModBlocks.DIRT_PATH.getDefaultState());
            pathStates.put(Blocks.GRAVEL, ModBlocks.GRAVEL_PATH.getDefaultState());
            pathStates.put(Blocks.MUD, ModBlocks.MUD_PATH.getDefaultState());
            pathStates.put(Blocks.RED_SAND, ModBlocks.RED_SAND_PATH.getDefaultState());
            pathStates.put(Blocks.ROOTED_DIRT, ModBlocks.ROOTED_DIRT_PATH.getDefaultState());
            pathStates.put(Blocks.SAND, ModBlocks.SAND_PATH.getDefaultState());
            pathStates.put(Blocks.SNOW_BLOCK, ModBlocks.SNOW_PATH.getDefaultState());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
