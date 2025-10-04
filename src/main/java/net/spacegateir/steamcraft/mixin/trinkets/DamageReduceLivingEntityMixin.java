package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.item.trinkets.item.NecklaceTrinketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class DamageReduceLivingEntityMixin {

    @ModifyVariable(method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", at = @At("HEAD"), ordinal = 0)
    private float reduceDamage(float amount, DamageSource source) {
        if ((Object) this instanceof PlayerEntity player) {
            ItemStack necklace = NecklaceTrinketItem.getEquippedNecklace(player);
            if (!necklace.isEmpty() && NecklaceTrinketItem.getGemType(necklace).equals("diamond")) {
                return amount * 0.5f; // reduce by 50%
            }
        }
        return amount; // unchanged
    }
}

