package net.spacegateir.steamcraft.mixin.trinkets;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.spacegateir.steamcraft.util.ModEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VillagerEntity.class)
public abstract class TradeOfferMixin {

    @ModifyExpressionValue(
            method = "prepareOffersFor",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/VillagerEntity;getReputation(Lnet/minecraft/entity/player/PlayerEntity;)I"
            )
    )
    private int applyCrownDiscount(int original, PlayerEntity player) {
        double discount = player.getAttributeValue(ModEntityAttributes.GENERIC_VILLAGER_DISCOUNT);

        if (discount != 0) {
            return Math.max(original + 100, 0); // +100 guarantees cheapest trades
        }

        // If not wearing the crown, leave reputation unchanged
        return original;
    }
}
