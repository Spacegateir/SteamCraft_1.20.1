package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.spacegateir.steamcraft.util.ModEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerStepMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void updateStepHeight(CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;

        double stepLevel = self.getAttributeValue(ModEntityAttributes.GENERIC_MOVEMENT_STEP);

        // Fallback to vanilla default (0.6F) if attribute is not present or 0
        float baseStep = 0.6F;
        float finalStep = (float) Math.max(stepLevel, baseStep);

        if (((PlayerEntity)(Object)this).isSneaking()) {
            self.setStepHeight(baseStep);
        } else {
            self.setStepHeight(finalStep);
        }
    }

}

