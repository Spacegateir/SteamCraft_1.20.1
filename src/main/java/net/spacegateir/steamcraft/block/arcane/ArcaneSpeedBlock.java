package net.spacegateir.steamcraft.block.arcane;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ArcaneSpeedBlock extends Block {

    public static final IntProperty SWITCH_STATE = IntProperty.of("switch_state", 0, 49);
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

    public ArcaneSpeedBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(SWITCH_STATE, 0));
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
        builder.add(SWITCH_STATE);
        builder.add(FACING);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {

            // Get the redstone signal strength at the block position
            int signalStrength = world.getReceivedRedstonePower(pos);

            // Set base values if no signal is present (signalStrength == 0)
            int baseDuration = (signalStrength == 0) ? 200 : 200;
            int baseAmplifier = (signalStrength == 0) ? 0 : 0;

            // Adjust duration and amplifier based on the redstone signal
            int adjustedDuration = baseDuration + (signalStrength * 200);
            int adjustedAmplifier = baseAmplifier + signalStrength;

            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, adjustedDuration, adjustedAmplifier, false, false));
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}


