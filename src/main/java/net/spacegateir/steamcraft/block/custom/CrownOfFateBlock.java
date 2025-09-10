package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CrownOfFateBlock extends FallingBlock {

    // Base of the crown
    private static final VoxelShape SHAPE_BASE = Block.createCuboidShape(
            3, 0, 3, 13, 4, 13
    );

    // Top of the crown
    private static final VoxelShape SHAPE_TOP = Block.createCuboidShape(
            3.5, 4, 3.5, 12.5, 7, 12.5
    );

    // Combined shape
    private static final VoxelShape SHAPE = VoxelShapes.union(SHAPE_BASE, SHAPE_TOP);

    public CrownOfFateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
