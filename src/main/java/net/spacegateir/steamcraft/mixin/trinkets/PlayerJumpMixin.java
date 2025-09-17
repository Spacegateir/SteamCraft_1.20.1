package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
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

    @Inject(method = "jump", at = @At("TAIL"))
    private void addExtraJumpHeight(CallbackInfo ci) {
        if (this.isSneaking()) {
            return;
        }

        double levels = this.getAttributeValue(ModEntityAttributes.GENERIC_MOVEMENT_JUMP);

        if (levels > 0) {
            int jumpBoost = this.hasStatusEffect(StatusEffects.JUMP_BOOST)
                    ? this.getStatusEffect(StatusEffects.JUMP_BOOST).getAmplifier() + 1
                    : 0;

            double totalExtraBlocks = levels + jumpBoost;

            double currentVelocity = this.getVelocity().y;

            double extraVelocity = Math.sqrt(2 * 0.1 * totalExtraBlocks) - currentVelocity;

            this.setVelocity(
                    this.getVelocity().x,
                    currentVelocity + extraVelocity,
                    this.getVelocity().z
            );
            this.velocityDirty = true;
        }
    }





}
