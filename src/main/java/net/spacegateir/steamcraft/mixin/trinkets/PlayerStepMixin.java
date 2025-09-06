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
        double stepLevel = ((LivingEntity)(Object)this)
                .getAttributeValue(ModEntityAttributes.GENERIC_MOVEMENT_STEP);

        ((LivingEntity)(Object)this).setStepHeight(
                ((PlayerEntity)(Object)this).isSneaking() ? 0.6F : (float) stepLevel
        );
    }
}

