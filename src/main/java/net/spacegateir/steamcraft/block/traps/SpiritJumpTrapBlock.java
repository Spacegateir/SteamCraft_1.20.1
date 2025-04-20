package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.stream.Stream;

public class SpiritJumpTrapBlock extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    // Define different shapes for each facing direction
    public static final VoxelShape NORTH_SHAPE = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape EAST_SHAPE = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SOUTH_SHAPE = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape WEST_SHAPE = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public SpiritJumpTrapBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return NORTH_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction facing = ctx.getPlayerLookDirection().getOpposite();
        if (facing.getAxis().isHorizontal()) {
            return this.getDefaultState().with(FACING, facing);
        }
        return this.getDefaultState().with(FACING, Direction.NORTH); // Default to NORTH if vertical
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (entity instanceof LivingEntity) {
            // Apply upward force to simulate a jump of 10 blocks high
            double jumpHeight = 20.0; // Height of the jump (in blocks)
            double jumpVelocity = Math.sqrt(2 * jumpHeight * 0.08); // Calculate the required velocity

            // Apply velocity in the Y-axis to simulate the jump
            entity.setVelocity(entity.getVelocity().x, jumpVelocity, entity.getVelocity().z);

            // Change the block state to the activated version
            if (!world.isClient) {
                world.setBlockState(pos, ModBlocks.SPIRIT_JUMP_TRAP_BLOCK.getDefaultState());
                world.playSound(null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 3.0F, 2.0F); // Play piston extension sound

                // Schedule the block to revert back to normal after 60 ticks (3 seconds)
                world.scheduleBlockTick(pos, ModBlocks.SPIRIT_JUMP_TRAP_BLOCK, 30);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Check if the current block is the activated version
        if (state.isOf(ModBlocks.SPIRIT_JUMP_TRAP_BLOCK)) {
            // Revert the block back to the normal trap block
            world.setBlockState(pos, ModBlocks.SPIRIT_JUMP_TRAP.getDefaultState());
            world.playSound(null, pos, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 3.0F, 2.0F); // Play piston contraction sound
        }
    }
}
