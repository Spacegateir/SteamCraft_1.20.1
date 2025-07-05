package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import net.spacegateir.steamcraft.particle.ModParticles;

public class EarthSpikeBlock extends Block {

    public static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 8, 10);
    private static final int TICK_INTERVAL = 5;

    public EarthSpikeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.9, 1.0F, 0.9));

        if (!world.isClient && entity instanceof LivingEntity target) {
            if (world.random.nextInt(10) == 0) {
                LivingEntity user = null; // Replace with attacker if available
                target.damage(world.getDamageSources().playerAttack((PlayerEntity) user), 0.5F);
            }
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!(world instanceof ClientWorld clientWorld)) return;

        if (random.nextInt(TICK_INTERVAL) != 0) return;

        for (Direction direction : Direction.Type.HORIZONTAL) {
            if (random.nextBoolean()) continue;

            for (int i = 0; i < 50; i++) {
                double x = pos.getX() + 0.5 + direction.getOffsetX() * 0.6 + (random.nextDouble() - 0.5) * 1.0;
                double y = pos.getY() + 0.2 + random.nextDouble() * 0.3;
                double z = pos.getZ() + 0.5 + direction.getOffsetZ() * 0.6 + (random.nextDouble() - 0.5) * 1.0;

                clientWorld.addParticle(ModParticles.EARTH_SPIKE_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            int delayTicks = 20 + world.random.nextInt(401); // 200–600 ticks = 1–30 seconds
            serverWorld.scheduleBlockTick(pos, this, delayTicks);
        }

        // Client-side particles (optional)
        if (world.isClient) {
            for (int i = 0; i < 50; i++) {
                double x = pos.getX() + 0.5 + (world.random.nextDouble() - 0.5) * 1.0;
                double y = pos.getY() + 0.2 + world.random.nextDouble() * 0.3;
                double z = pos.getZ() + 0.5 + (world.random.nextDouble() - 0.5) * 1.0;
                world.addParticle(ModParticles.EARTH_SPIKE_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
            }
        }
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            world.breakBlock(pos, false);
        }
    }
}