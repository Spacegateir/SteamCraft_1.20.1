package net.spacegateir.steamcraft.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;

public class FreakyBunnyEffect extends StatusEffect {
    public FreakyBunnyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isOnGround() && entity.age % 5 == 0) {
            Vec3d initialVec = entity.getVelocity();

            double jumpBoost = 1.0D + (amplifier * 0.2D);
            Vec3d jumpVec = new Vec3d(initialVec.x, jumpBoost, initialVec.z);

            entity.setVelocity(jumpVec.x * 0.92D, jumpVec.y, jumpVec.z * 0.92D);

            entity.getWorld().addParticle(
                    ParticleTypes.CLOUD,
                    entity.getX(),
                    entity.getY() + 0.1D,
                    entity.getZ(),
                    0.0D, 0.1D, 0.0D
            );
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
