package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.server.network.ServerPlayerEntity;
import net.spacegateir.steamcraft.inventory.MagicBagInventory;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.HasMagicBag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerMagicBagCopyMixin {

    @Inject(method = "copyFrom", at = @At("TAIL"))
    private void copyMagicBagInventory(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        if (oldPlayer instanceof HasMagicBag oldBag && (Object) this instanceof HasMagicBag newBag) {
            MagicBagInventory oldInv = oldBag.getMagicBagInventory();
            MagicBagInventory newInv = newBag.getMagicBagInventory();

            newInv.readNbtList(oldInv.toNbtList());
        }
    }
}
