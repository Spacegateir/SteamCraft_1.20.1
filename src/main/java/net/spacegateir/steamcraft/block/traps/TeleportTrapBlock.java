package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeleportTrapBlock extends Block {

    public TeleportTrapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (entity instanceof LivingEntity) {
            // Search for blocks within a 50-block radius of the current position
            BlockPos targetPos = findSafePriorityBlockWithinRadius(world, pos, 50);

            if (targetPos != null) {
                // Calculate the center of the block and teleport the entity 1 block above
                double centerX = targetPos.getX() + 0.5;
                double centerY = targetPos.getY() + 1; // 1 block above the block
                double centerZ = targetPos.getZ() + 0.5;

                // Teleport the entity to the calculated coordinates
                entity.teleport(centerX, centerY, centerZ);
            }
        }
    }

    private BlockPos findSafePriorityBlockWithinRadius(World world, BlockPos pos, int radius) {
        List<BlockPos> firstPriority = new ArrayList<>();
        List<BlockPos> secondPriority = new ArrayList<>();
        List<BlockPos> thirdPriority = new ArrayList<>();
        Random random = new Random();

        // Iterate through a 50-block radius around the teleport trap block
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -radius; y <= radius; y++) {
                    BlockPos checkPos = pos.add(x, y, z);
                    BlockState blockState = world.getBlockState(checkPos);

                    // Ensure the block at the position is valid and safe for teleportation
                    if (isSafeForTeleport(world, checkPos)) {
                        // Add blocks to respective priority lists
                        if (blockState.isOf(Blocks.GOLD_BLOCK)) {
                            firstPriority.add(checkPos);
                        } else if (blockState.isOf(ModBlocks.ARCANE_DISORIENT_BLOCK)) {
                            secondPriority.add(checkPos);
                        } else if (blockState.isOf(Blocks.STONE)) {
                            thirdPriority.add(checkPos);
                        }
                    }
                }
            }
        }

        // Choose randomly from the highest priority list that is not empty
        if (!firstPriority.isEmpty()) {
            return firstPriority.get(random.nextInt(firstPriority.size()));
        } else if (!secondPriority.isEmpty()) {
            return secondPriority.get(random.nextInt(secondPriority.size()));
        } else if (!thirdPriority.isEmpty()) {
            return thirdPriority.get(random.nextInt(thirdPriority.size()));
        }

        // Return null if no prioritized blocks are found
        return null;
    }

    private boolean isSafeForTeleport(World world, BlockPos pos) {
        BlockPos abovePos = pos.up(); // Block above the target position
        BlockPos twoAbovePos = pos.up(2); // Two blocks above the target position

        // Check that the target block is solid for standing, and both blocks above it are non-solid
        return world.getBlockState(pos).isSolidBlock(world, pos)
                && world.getBlockState(abovePos).isAir()
                && world.getBlockState(twoAbovePos).isAir();
    }
}
