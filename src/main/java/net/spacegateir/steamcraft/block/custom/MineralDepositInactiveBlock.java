package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.MineralShapes;
import net.spacegateir.steamcraft.util.MineralType;

public class MineralDepositInactiveBlock extends TwoTallBlock {

    private final MineralType mineralType;

    public MineralDepositInactiveBlock(Settings settings, MineralType mineralType) {
        super(settings.ticksRandomly());
        this.mineralType = mineralType;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        MineralShapes.ShapePair shapePair = MineralShapes.SHAPES.get(mineralType);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? shapePair.lower : shapePair.upper;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos upperPos = pos.up();
        BlockState upperState = world.getBlockState(upperPos);

        if (!(upperState.getBlock() instanceof MineralDepositInactiveBlock)
                || !upperState.contains(HALF)
                || upperState.get(HALF) != DoubleBlockHalf.UPPER) {
            return;
        }

        Block activeBlock = mineralType.getActiveBlock();

        BlockState activeLower = activeBlock.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
        BlockState activeUpper = activeBlock.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);

        world.setBlockState(pos, activeLower, Block.NOTIFY_ALL);
        world.setBlockState(upperPos, activeUpper, Block.NOTIFY_ALL);
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.onPlaced(world, pos, state, placer, stack);
        if (!world.isClient && state.get(HALF) == DoubleBlockHalf.LOWER) {
            world.scheduleBlockTick(pos, this, mineralType.getRespawnDelayTicks());
        }
    }
}
