package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EarthWallBlock extends Block {

    public static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public EarthWallBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.5, 0.5F, 0.5));      // Slows target down or gets sticky on touch

        if (!world.isClient && entity instanceof LivingEntity target) {
            if (world.random.nextInt(10) == 0) {
                LivingEntity user = null;
                target.damage(world.getDamageSources().playerAttack((PlayerEntity) user), 0.5F);    //Damages target
            }
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            // Self-destruct delay between 1 second (20 ticks) and 1 minute (1200 ticks)
            int minTicks = 20;     // 1 second
            int maxTicks = 900;   // 45 seconds
            int delayTicks = minTicks + world.random.nextInt(maxTicks - minTicks + 1);

            serverWorld.scheduleBlockTick(pos, this, delayTicks);
        }
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            world.breakBlock(pos, false);
        }
    }
}
