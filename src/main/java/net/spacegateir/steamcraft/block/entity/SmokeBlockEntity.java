package net.spacegateir.steamcraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlockEntities;

import java.util.Random;

public class SmokeBlockEntity extends BlockEntity {
    private static final Random RANDOM = new Random();

    public SmokeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMOKE_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SmokeBlockEntity blockEntity) {
        if (world.isClient) {
            if (RANDOM.nextFloat() < 0.4f) { // 20% chance each tick
                double x = pos.getX() + 0.5 + (RANDOM.nextDouble() - 0.5) * 0.8;
                double y = pos.getY() + 0.5;
                double z = pos.getZ() + 0.5 + (RANDOM.nextDouble() - 0.5) * 0.8;

                double velocityX = 0.0;
                double velocityY = 0.1 + RANDOM.nextDouble() * 0.02;
                double velocityZ = 0.0;

                world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, velocityX, velocityY, velocityZ);
            }
        }
    }
}
