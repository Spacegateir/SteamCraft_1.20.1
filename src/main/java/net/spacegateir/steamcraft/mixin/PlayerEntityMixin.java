package net.spacegateir.steamcraft.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.spacegateir.steamcraft.effect.ModEffects;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    // Boost Swim Speed
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT) && player.isSwimming()) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null && (client.player.input.movementForward != 0 || client.player.input.movementSideways != 0)) {
                Vec3d direction = player.getRotationVec(1.0F).normalize();
                double swimBoost = 0.1;

                Vec3d newVelocity = player.getVelocity().add(direction.x * swimBoost, 0, direction.z * swimBoost);
                player.setVelocity(newVelocity);
            }
        }
    }

    // Change jump height 4.5 Blocks
    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void modifyJump(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT)) {
            Vec3d velocity = player.getVelocity();
            player.setVelocity(velocity.x, 0.8, velocity.z);
            ci.cancel();
        }
    }

    // Modify fall damage 10 Blocks
    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void onFall(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT)) {
            if (fallDistance <= 10) {
                cir.cancel();
            }
        }
    }
}
