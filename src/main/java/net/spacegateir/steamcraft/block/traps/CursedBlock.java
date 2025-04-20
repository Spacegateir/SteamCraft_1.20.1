package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public class CursedBlock extends Block {

    public CursedBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!world.isClient) {
            int radius = 50;
            Box effectArea = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));

            // Apply effects and play heartbeat sound for players within the radius
            world.getEntitiesByClass(PlayerEntity.class, effectArea, player -> player.isAlive())
                    .forEach(player -> {
                        // Apply Mining Fatigue effect
                        StatusEffectInstance miningFatigue = new StatusEffectInstance(
                                StatusEffects.MINING_FATIGUE, 20000, 2, false, false);
                        player.addStatusEffect(miningFatigue);

                        // Apply Weakness effect
                        StatusEffectInstance weakness = new StatusEffectInstance(
                                StatusEffects.WEAKNESS, 20000, 1, false, false);
                        player.addStatusEffect(weakness);

                        // Apply Darkness effect (separate from Weakness)
                        StatusEffectInstance darkness = new StatusEffectInstance(
                                StatusEffects.DARKNESS, 200, 1, false, false);
                        player.addStatusEffect(darkness);

                        // Send message to the player
                        player.sendMessage(Text.of("You have been cursed. Purify the area!"), true);

                        // Calculate distance and set heartbeat volume based on proximity
                        double distance = player.getPos().distanceTo(Vec3d.ofCenter(pos));
                        float maxVolume = 5f;  // Max volume for heartbeat sound
                        float volume = Math.max(0, maxVolume - (float)(distance / radius));

                        // Play heartbeat sound at adjusted volume
                        if (volume > 0) {  // Only play if volume is above 0
                            world.playSound(
                                    null,                // Listener (null for all players nearby)
                                    player.getX(),       // X position of the player
                                    player.getY(),       // Y position of the player
                                    player.getZ(),       // Z position of the player
                                    SoundEvents.ENTITY_WARDEN_HEARTBEAT,  // Heartbeat sound
                                    SoundCategory.PLAYERS,               // Sound category
                                    volume,                              // Volume based on distance
                                    1.0f                                 // Pitch (keep it at 1.0 for a normal heartbeat sound)
                            );
                        }
                    });

            scheduleTick(world, pos);
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    public void scheduleTick(ServerWorld world, BlockPos pos) {
        world.scheduleBlockTick(pos, this, 20); // Schedule the next random tick in 20 game ticks (~1 second)
    }
}
