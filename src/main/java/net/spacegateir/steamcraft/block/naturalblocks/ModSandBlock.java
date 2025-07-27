package net.spacegateir.steamcraft.block.naturalblocks;

import net.minecraft.block.SandBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModSandBlock extends SandBlock {
    private final int color;

    public ModSandBlock(int color, AbstractBlock.Settings settings) {
        super(color, settings);
        this.color = color;
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return this.color;
    }
}
