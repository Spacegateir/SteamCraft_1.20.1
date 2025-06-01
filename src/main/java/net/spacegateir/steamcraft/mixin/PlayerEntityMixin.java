package net.spacegateir.steamcraft.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.spacegateir.steamcraft.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    // Boost Swim Speed
    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.getWorld() instanceof ServerWorld serverWorld &&
                player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT) &&
                player.isSwimming()) {

            Vec3d direction = player.getRotationVec(1.0F).normalize();
            double swimBoost = 0.15;

            Vec3d newVelocity = player.getVelocity().add(direction.x * swimBoost, 0, direction.z * swimBoost);
            player.setVelocity(newVelocity);
            player.velocityModified = true;

            for (int i = 0; i < 4; i++) {
                double offsetX = -direction.x * i * 0.3;
                double offsetY = player.getHeight() / 2.0;
                double offsetZ = -direction.z * i * 0.3;

                double px = player.getX() + offsetX;
                double py = player.getY() + offsetY;
                double pz = player.getZ() + offsetZ;

                serverWorld.spawnParticles(
                        ParticleTypes.BUBBLE_COLUMN_UP,
                        px, py, pz,
                        1,
                        0, 0, 0,
                        0.01
                );
            }
        }
    }

    // Change jump height 4.5 Blocks
    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void modifyJump(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT)) {
            Vec3d velocity = player.getVelocity();
            player.setVelocity(velocity.x, 0.8, velocity.z);

            // Add particle burst at feet
            if (player.getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(
                        ParticleTypes.CLOUD,     // You can change this to FLAME, FIREWORK, etc.
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        30,      // count
                        0.2, 0.1, 0.2, // spread (X, Y, Z)
                        0.02     // speed
                );
            }

            ci.cancel(); // prevent vanilla jump
        }
    }


    // Modify fall damage 10 Blocks
    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void onFall(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.hasStatusEffect(ModEffects.CELESTIAL_GEARFORGES_EFFECT)) {
            if (fallDistance <= 10) {
                cir.setReturnValue(false);
            }
        }
    }
}
