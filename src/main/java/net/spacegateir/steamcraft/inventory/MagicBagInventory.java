package net.spacegateir.steamcraft.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class MagicBagInventory extends SimpleInventory {
    public MagicBagInventory() {
        super(54); // 9x6 slots
    }

    public void readNbtList(NbtList list) {
        for (int i = 0; i < this.size(); i++) {
            this.setStack(i, ItemStack.EMPTY);
        }
        for (int i = 0; i < list.size(); i++) {
            NbtCompound tag = list.getCompound(i);
            int slot = tag.getByte("Slot") & 255;
            if (slot >= 0 && slot < this.size()) {
                this.setStack(slot, ItemStack.fromNbt(tag));
            }
        }
    }

    public NbtList toNbtList() {
        NbtList list = new NbtList();
        for (int i = 0; i < this.size(); i++) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                NbtCompound tag = new NbtCompound();
                tag.putByte("Slot", (byte)i);
                stack.writeNbt(tag);
                list.add(tag);
            }
        }
        return list;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}
