package net.spacegateir.steamcraft.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

import java.util.HashSet;
import java.util.Set;

public class ClearPositiveStatusEffect extends StatusEffect {

    // Set of status effects to exclude from removal (use the class type of effects)
    private static final Set<Class<? extends StatusEffect>> BLACKLISTED_EFFECTS = new HashSet<>();

    static {
        // Add specific effect classes to the blacklist (they will not be removed)
        BLACKLISTED_EFFECTS.add(ClearNeutralStatusEffect.class); // Add class types
        BLACKLISTED_EFFECTS.add(ClearNegativeStatusEffect.class);
        BLACKLISTED_EFFECTS.add(ClearPositiveStatusEffect.class);
        BLACKLISTED_EFFECTS.add(CelestialGearforgedEffect.class);
    }

    public ClearPositiveStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Loop through all active status effects and remove neutral effects that are not blacklisted
        entity.getActiveStatusEffects().keySet().stream()
                .filter(effect -> effect.getCategory() == StatusEffectCategory.BENEFICIAL) // Filter neutral effects
                .filter(effect -> !BLACKLISTED_EFFECTS.contains(effect.getClass())) // Exclude blacklisted effects by class type
                .forEach(entity::removeStatusEffect); // Remove each non-blacklisted neutral effect
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Determines how frequently the effect should trigger; in this case, every tick
        return true;
    }
}
