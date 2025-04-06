package net.spacegateir.steamcraft.effect.effects;

import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.spacegateir.steamcraft.effect.ModEffects;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class CelestialGearforgedEffect extends StatusEffect {
    private static final Set<UUID> boostedPlayers = new HashSet<>(Set.of(UUID.fromString("e94b5c2e-6a6f-4f1e-9048-6d5f84a16b33")));


    public CelestialGearforgedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    private static final Set<Class<? extends StatusEffect>> BLACKLISTED_EFFECTS = new HashSet<>();
    static {
        BLACKLISTED_EFFECTS.add(ClearNeutralStatusEffect.class);
        BLACKLISTED_EFFECTS.add(ClearNegativeStatusEffect.class);
        BLACKLISTED_EFFECTS.add(ClearPositiveStatusEffect.class);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        int tickInterval = 1000;

        entity.getActiveStatusEffects().keySet().removeIf(effect ->
                effect.getCategory() == StatusEffectCategory.HARMFUL &&
                        !BLACKLISTED_EFFECTS.contains(effect.getClass())
        );

        // Jump Boost
//        if (entity.getWorld().isClient && entity instanceof PlayerEntity player) {
//            UUID uuid = player.getUuid();
//
//            // Skip the jump boost if the player has less than 1/3 of their health
//            if (player.getHealth() < player.getMaxHealth()) {
//                return; // Skip the boost if the player has less than 1/3 health
//            }
//
//            // Check if the player is attempting to jump (in the air)
//            if (player.fallDistance == 0 && player.getVelocity().y > 0) {
//                if (!boostedPlayers.contains(uuid)) {
//                    player.addVelocity(0, 0.4, 0); // Boost jump height (~3 blocks)
//                    player.velocityDirty = true;
//                    boostedPlayers.add(uuid);
//                }
//            } else if (player.isOnGround()) {
//                boostedPlayers.remove(uuid);
//            }
//        }


        // Frozen Immunity
        if (entity.isFrozen()) {entity.isOnFire();
        }

        // Fire Immunity
        if (entity.isOnFire()) { entity.extinguish();
        }

        // Water Breathing
        if (entity.isSubmergedInWater()) {
            entity.setAir(entity.getMaxAir());
        }

//        // Swimming Speed Boost
//        if (entity.isInSwimmingPose() && entity.isSubmergedInWater()) {
//            double fixedSwimmingSpeed = 1.0D; // Base swimming speed
//            double turnSpeedMultiplier = 1.5D; // Multiplier to increase turn speed
//
//            Vec3d currentVelocity = entity.getVelocity();
//
//            // Calculate the horizontal speed (X and Z components)
//            double horizontalSpeed = Math.sqrt(currentVelocity.x * currentVelocity.x + currentVelocity.z * currentVelocity.z);
//
//            // Normalize the velocity vector and scale it by the fixed swimming speed
//            if (horizontalSpeed > 0) {
//                // Apply fixed swimming speed and allow for quicker turning
//                currentVelocity = new Vec3d(
//                        currentVelocity.x / horizontalSpeed * fixedSwimmingSpeed * turnSpeedMultiplier,  // Increase turning speed
//                        currentVelocity.y,  // Maintain the vertical velocity
//                        currentVelocity.z / horizontalSpeed * fixedSwimmingSpeed * turnSpeedMultiplier
//                );
//            } else {
//                // If there's no horizontal movement, just set the fixed speed for all directions
//                currentVelocity = new Vec3d(fixedSwimmingSpeed, currentVelocity.y, 0);
//            }
//
//            // Apply the new velocity to the entity
//            entity.setVelocity(currentVelocity);
//        }







        // Stick to wall
//        if (entity.horizontalCollision) {
//            Vec3d initialVec = entity.getVelocity();
//            Vec3d climbVec = new Vec3d(initialVec.x, 0.2D, initialVec.z);
//            entity.setVelocity(climbVec.x * 0.92D, climbVec.y * 0.98D, climbVec.z * 0.92D);
//        }

        if (!entity.getWorld().isClient) {
            ServerWorld world = (ServerWorld) entity.getWorld();
            BlockPos pos = entity.getBlockPos();

            // Apply beneficial effects to nearby entities
            world.getEntitiesByClass(LivingEntity.class, entity.getBoundingBox().expand(10), e -> e != entity)
                    .forEach(e -> {
                        if (e instanceof PlayerEntity || isEligibleEntity(e)) {
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 2,
                                    false, false, false));
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 2,
                                    false, false, false));
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 2,
                                    false, false, false));
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 2,
                                    false, false, false));
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2400, 0,
                                    false, false, false));
                        }
                    });

            // Reapply effects every 1000 ticks
            if (entity.age % tickInterval == 0) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 2,
                        false, false, false));
            }
        }

        super.applyUpdateEffect(entity, amplifier);
    }

    private boolean isEligibleEntity(LivingEntity entity) {
        return entity instanceof AnimalEntity || entity instanceof VillagerEntity || entity instanceof IronGolemEntity;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
