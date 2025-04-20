package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
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

public class FlareforgeBlock extends Block{

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

    public FlareforgeBlock(Settings settings) {
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
        return this.getDefaultState().with(FACING, Direction.NORTH);
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

        // Check if the world is client-side for particle effects
        if (world.isClient) {
            for (int i = 0; i < 5; i++) { // Spawn multiple particles for better effect
                // Emit FLAME particles
                world.addParticle(
                        ParticleTypes.FLAME,
                        pos.getX() + 0.5 + world.random.nextGaussian() * 0.1, // X position (center with slight random offset)
                        pos.getY() + 1, // Y position (above the block)
                        pos.getZ() + 0.5 + world.random.nextGaussian() * 0.1, // Z position (center with slight random offset)
                        0.0, // X velocity
                        0.07, // Y velocity
                        0.0  // Z velocity
                );

                // Emit SMOKE particles
                world.addParticle(
                        ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        pos.getX() + 0.5 + world.random.nextGaussian() * 0.1, // X position (center with slight random offset)
                        pos.getY() + 2, // Y position (above the block)
                        pos.getZ() + 0.5 + world.random.nextGaussian() * 0.1, // Z position (center with slight random offset)
                        0.0, // X velocity
                        0.03, // Y velocity (slower than flame for realism)
                        0.0  // Z velocity
                );
            }
        }

        // Apply fire damage if entity is a living entity
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.setOnFireFor(20); // Set the entity on fire for 2 seconds
        }
    }
}

