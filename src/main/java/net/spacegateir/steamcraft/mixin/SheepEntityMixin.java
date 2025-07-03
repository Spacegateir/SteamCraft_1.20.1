package net.spacegateir.steamcraft.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends MobEntity {

    protected SheepEntityMixin() {
        super(null, null); // Required constructor stub for mixins
    }

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void onInteractMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.getItem() instanceof ShearsItem) {
            SheepEntity sheep = (SheepEntity) (Object) this;

            if (!sheep.getWorld().isClient && sheep.isShearable()) {
                sheep.sheared(SoundCategory.PLAYERS);
                sheep.emitGameEvent(net.minecraft.world.event.GameEvent.SHEAR, player);
                itemStack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                cir.setReturnValue(ActionResult.SUCCESS);
            } else {
                cir.setReturnValue(ActionResult.CONSUME);
            }
        }
    }
}
