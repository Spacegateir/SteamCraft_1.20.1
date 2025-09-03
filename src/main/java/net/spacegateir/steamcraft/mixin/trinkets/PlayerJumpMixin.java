package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.ModEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerJumpMixin extends LivingEntity {

    protected PlayerJumpMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void modifyJumpHeight(CallbackInfo ci) {
        if (this.isSneaking()) {
            return;
        }

        double jumpStrength = this.getAttributeValue(ModEntityAttributes.GENERIC_MOVEMENT_JUMP);

        // Add Jump Boost potion if present
        int jumpBoost = this.hasStatusEffect(StatusEffects.JUMP_BOOST)
                ? this.getStatusEffect(StatusEffects.JUMP_BOOST).getAmplifier() + 1
                : 0;

        // Each jump boost level = +1 block
        double totalHeight = jumpStrength + jumpBoost;

        // Convert blocks to Y velocity
        double jumpVelocity = Math.sqrt(2 * 0.08 * totalHeight) * 1.05;

        this.setVelocity(this.getVelocity().x, jumpVelocity, this.getVelocity().z);
        this.velocityDirty = true;

        ci.cancel(); // cancel vanilla jump
    }
}

