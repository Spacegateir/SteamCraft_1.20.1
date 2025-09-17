package net.spacegateir.steamcraft.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class MagicBagInventory extends SimpleInventory {

    public MagicBagInventory() {
        super(54);
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }

    public void readNbtList(NbtList nbtList) {
        for (int i = 0; i < this.size(); ++i) {
            this.setStack(i, ItemStack.EMPTY);
        }
        for (int i = 0; i < nbtList.size(); ++i) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int slot = nbtCompound.getByte("Slot") & 255;
            if (slot >= 0 && slot < this.size()) {
                this.setStack(slot, ItemStack.fromNbt(nbtCompound));
            }
        }
    }

    public NbtList toNbtList() {
        NbtList nbtList = new NbtList();
        for (int i = 0; i < this.size(); ++i) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                NbtCompound nbt = new NbtCompound();
                nbt.putByte("Slot", (byte) i);
                stack.writeNbt(nbt);
                nbtList.add(nbt);
            }
        }
        return nbtList;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}
