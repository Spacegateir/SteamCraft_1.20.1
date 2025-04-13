package net.spacegateir.steamcraft.effect.effects;

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

import java.util.HashSet;
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

        // step up 1 block
        if (entity instanceof PlayerEntity player) {
            if (player.isOnGround()) {
                BlockPos playerPos = player.getBlockPos();
                BlockPos blockInFront = playerPos.offset(player.getMovementDirection());

                if (player.getWorld().getBlockState(blockInFront.up()).isAir() && player.getWorld().getBlockState(blockInFront).isSolidBlock(player.getWorld(), blockInFront)) {
                    player.setVelocity(player.getVelocity().add(0, 0.5D, 0));
                }
            }
        }

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
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 1024,
                                    false, false, false));
                            e.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2400, 0,
                                    false, false, false));
                        }
                    });

            // Reapply effects every 1000 ticks
            if (entity.age % tickInterval == 0) {
//                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200, 2,
//                        false, false, false));
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
