package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.MineralDepositHandler;
import net.spacegateir.steamcraft.util.MineralShapes;
import net.spacegateir.steamcraft.util.MineralType;

public class MineralDepositActiveBlock extends TwoTallBlock {

    private final MineralType mineralType;

    public MineralDepositActiveBlock(Settings settings, MineralType mineralType) {
        super(settings);
        this.mineralType = mineralType;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        MineralShapes.ShapePair shapePair = MineralShapes.SHAPES.get(mineralType);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? shapePair.lower : shapePair.upper;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf half = state.get(HALF);
        BlockPos otherPos = (half == DoubleBlockHalf.LOWER) ? pos.up() : pos.down();
        BlockState otherState = world.getBlockState(otherPos);

        if (otherState.getBlock() == this && otherState.get(HALF) != half) {
            world.breakBlock(otherPos, false);
        }

        if (!world.isClient && half == DoubleBlockHalf.LOWER) {
            MineralDepositHandler.placeInactiveMineralDepositLower(world, pos, mineralType);
        }

        if (!world.isClient && half == DoubleBlockHalf.UPPER) {
            MineralDepositHandler.placeInactiveMineralDepositUpper(world, pos, mineralType);
        }

        super.onBreak(world, pos, state, player);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            DoubleBlockHalf half = state.get(HALF);

            if (!world.isClient) {
                if (half == DoubleBlockHalf.LOWER) {
                    MineralDepositHandler.placeInactiveMineralDepositLower(world, pos, mineralType);
                } else {
                    MineralDepositHandler.placeInactiveMineralDepositUpper(world, pos, mineralType);
                }
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }








}

