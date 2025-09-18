package net.spacegateir.steamcraft.mixin.trinkets;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.spacegateir.steamcraft.inventory.MagicBagInventory;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.HasMagicBag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMagicBagMixin implements HasMagicBag {

    @Unique
    private final MagicBagInventory magicBagInventory = new MagicBagInventory();

    @Override
    public MagicBagInventory getMagicBagInventory() {
        return this.magicBagInventory;
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readMagicBagData(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("MagicBagItems", NbtElement.LIST_TYPE)) {
            this.magicBagInventory.readNbtList(nbt.getList("MagicBagItems", NbtElement.COMPOUND_TYPE));
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeMagicBagData(NbtCompound nbt, CallbackInfo ci) {
        nbt.put("MagicBagItems", this.magicBagInventory.toNbtList());
    }
}
