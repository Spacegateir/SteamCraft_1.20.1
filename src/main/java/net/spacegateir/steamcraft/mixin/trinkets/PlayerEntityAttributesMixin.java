package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.spacegateir.steamcraft.util.ModEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityAttributesMixin {

    @Inject(method = "createPlayerAttributes", at = @At("RETURN"), cancellable = true)
    private static void addCustomAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        DefaultAttributeContainer.Builder builder = cir.getReturnValue();
        ModEntityAttributes.addPlayerAttributes(builder);
        cir.setReturnValue(builder);
    }
}
