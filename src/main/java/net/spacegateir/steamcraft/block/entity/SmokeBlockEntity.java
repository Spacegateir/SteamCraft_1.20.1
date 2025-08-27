package net.spacegateir.steamcraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.custom.SmokeBlock;

import java.util.Random;

public class SmokeBlockEntity extends BlockEntity {
    private static final Random RANDOM = new Random();

    public SmokeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMOKE_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SmokeBlockEntity blockEntity) {
        if (world.isClient && RANDOM.nextFloat() < 0.4f) {
            int mode = state.get(SmokeBlock.MODE);

            double x = pos.getX() + 0.5 + (RANDOM.nextDouble() - 0.5) * 0.8;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5 + (RANDOM.nextDouble() - 0.5) * 0.8;

            double velocityX = 0.0;
            double velocityY = 0.1 + RANDOM.nextDouble() * 0.02;
            double velocityZ = 0.0;

            BlockState below = world.getBlockState(pos.down());
            if (below.isOf(Blocks.HAY_BLOCK)) {
                velocityY *= 2.0;
            } else if (below.isOf(Blocks.PACKED_ICE)) {
                velocityY *= 0.5;
            }


            DefaultParticleType particleType;

            switch (mode) {
                case 1 -> { // Mode 1: normal smoke
                    particleType = ParticleTypes.SMOKE;
                }
                case 2 -> { // Mode 2: cosy smoke
                    particleType = ParticleTypes.CAMPFIRE_COSY_SMOKE;
                }
                case 3 -> { // Mode 3: tall signal smoke
                    particleType = ParticleTypes.CAMPFIRE_SIGNAL_SMOKE;
                }
                default -> {
                    particleType = ParticleTypes.SMOKE;
                }
            }

            world.addParticle(particleType, x, y, z, velocityX, velocityY, velocityZ);
        }
    }
}
