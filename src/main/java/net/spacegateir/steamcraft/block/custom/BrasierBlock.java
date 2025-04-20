package net.spacegateir.steamcraft.block.custom;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class BrasierBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public BrasierBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE; // Single shape used for all directions
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction facing = ctx.getPlayerLookDirection().getOpposite();
        return this.getDefaultState().with(FACING, facing.getAxis().isHorizontal() ? facing : Direction.NORTH);
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
        if (world.isClient) {
            for (int i = 0; i < 5; i++) {
                world.addParticle(
                        ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        pos.getX() + 0.5 + world.random.nextGaussian() * 0.1,
                        pos.getY() + 1.2,
                        pos.getZ() + 0.5 + world.random.nextGaussian() * 0.1,
                        0.0, 0.03, 0.0
                );
            }
        }

        if (entity instanceof LivingEntity livingEntity && !livingEntity.isFireImmune()) {
            livingEntity.setOnFireFor(20);
        }
    }
}

