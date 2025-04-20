package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.HashMap;
import java.util.Map;

public class StoneTrapBlock extends Block {
    // Map to track the last time a sound was played for each block position
    private static final Map<BlockPos, Long> soundCooldowns = new HashMap<>();

    public StoneTrapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (!world.isClient) {
            if (state.isOf(ModBlocks.STONE_TRAP_BLOCK)) {
                // Change block to the spiked version
                world.setBlockState(pos, ModBlocks.STONE_TRAP_BLOCK_SPIKES.getDefaultState());

                // Schedule the block to revert back to normal after 20 ticks
                world.scheduleBlockTick(pos, ModBlocks.STONE_TRAP_BLOCK_SPIKES, 20);

            } else if (state.isOf(ModBlocks.STONE_TRAP_BLOCK_SPIKES)) {
                // Apply status effects to the entity
                if (entity instanceof net.minecraft.entity.LivingEntity livingEntity) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0, false, false));
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 5, 0, false, false));

                    // Check if enough time has passed since the last sound was played
                    long currentTime = world.getTime();
                    Long lastSoundTime = soundCooldowns.getOrDefault(pos, 0L);

                    if (currentTime - lastSoundTime >= 20) { // 20 ticks = 1 second
                        // Play sound effect
                        world.playSound(
                                null,                          // Player responsible for the sound; null means no player
                                pos,                           // Position of the sound
                                SoundEvents.ENTITY_GENERIC_HURT, // The sound effect to play
                                SoundCategory.BLOCKS,          // Category of the sound
                                5.0F,                          // Volume
                                1.0F                           // Pitch
                        );
                        // Update the last sound time
                        soundCooldowns.put(pos, currentTime);
                    }
                }
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Check if the current block is the spiked version
        if (state.isOf(ModBlocks.STONE_TRAP_BLOCK_SPIKES)) {
            // Revert the block back to the normal trap block
            world.setBlockState(pos, ModBlocks.STONE_TRAP_BLOCK.getDefaultState());
        }
    }
}
