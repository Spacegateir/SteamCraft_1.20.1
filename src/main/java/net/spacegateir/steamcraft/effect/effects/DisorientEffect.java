package net.spacegateir.steamcraft.effect.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;

public class DisorientEffect extends StatusEffect {
    public DisorientEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient() && entity instanceof net.minecraft.client.network.ClientPlayerEntity player) {
            // Apply dramatic camera movement
            double intensity = (amplifier + 2) * 3.5; // Higher amplifier increases intensity

            // Define the range of fluctuation
            double yawFluctuation = Math.sin(player.age * 0.3) * intensity;
            double pitchFluctuation = Math.cos(player.age * 0.1) * intensity;

            // Add random fluctuation within a given range to yaw and pitch
            double yawOffset = Math.random() * 0.2 - 0.01; // Random range between -0.05 and 0.05
            double pitchOffset = Math.random() * 0.2 - 0.01; // Random range between -0.05 and 0.05

            // Apply the fluctuation to yaw and pitch
            player.setYaw((float) (player.getYaw() + yawFluctuation + yawOffset));
            player.setPitch((float) (player.getPitch() + pitchFluctuation + pitchOffset));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
