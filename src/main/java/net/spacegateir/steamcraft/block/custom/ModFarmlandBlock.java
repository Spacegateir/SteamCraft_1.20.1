package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class ModFarmlandBlock extends FarmlandBlock {

    public ModFarmlandBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(Properties.MOISTURE, MAX_MOISTURE));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Always stay at max moisture
        if (state.get(MOISTURE) < MAX_MOISTURE) {
            world.setBlockState(pos, state.with(MOISTURE, MAX_MOISTURE), Block.NOTIFY_LISTENERS);
        }

        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);

        // Only convert to dirt if a non-crop, solid block is placed above
        if (aboveState.isSolidBlock(world, abovePos) && !aboveState.isIn(net.minecraft.registry.tag.BlockTags.MAINTAINS_FARMLAND)) {
            setToDirt(null, state, world, pos);
        }

        // Accelerate crop growth above (2x)
        if (aboveState.getBlock() instanceof Fertilizable fertilizable && fertilizable.isFertilizable(world, abovePos, aboveState, false)) {
            for (int i = 0; i < 2; i++) {
                fertilizable.grow(world, random, abovePos, aboveState);
            }
        }

    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        // Do nothing on landing — disables trampling behavior
        // No call to super.onLandedUpon or setToDirt
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        // Schedule tick if a block is placed above
        if (direction == Direction.UP && !world.getBlockState(pos.up()).isAir()) {
            world.scheduleBlockTick(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // Always placeable — avoids reverting to dirt on placement
        return true;
    }
}
