package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class WonderingTrapBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

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

    public WonderingTrapBlock(Settings settings) {
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
        // Ensure that only horizontal directions are used
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
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!world.isClient) {
            int radius = 25;
            Box effectArea = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));

            // Apply effects for players within the radius
            world.getEntitiesByClass(PlayerEntity.class, effectArea, player -> player.isAlive())
                    .forEach(player -> {
                        // Apply Blindness effect (duration: 1000 ticks, level: 2)

                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200, 2, false, false));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20000, 2, false, false));

                    });
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;  // Allow this block to have random ticks
    }

    // Schedule the next random tick for this block
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);
        world.scheduleBlockTick(pos, this, 20); // Schedule the next random tick in 20 game ticks (~1 second)
    }
}
