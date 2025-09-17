package net.spacegateir.steamcraft.inventory;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.PersistentState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MagicBagPersistentState extends PersistentState {

    private final Map<UUID, NbtList> playerInventories = new HashMap<>();

    public NbtList getInventory(UUID playerUUID) {
        return playerInventories.getOrDefault(playerUUID, new NbtList());
    }

    public void setInventory(UUID playerUUID, NbtList inventory) {
        playerInventories.put(playerUUID, inventory);
        markDirty();
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        NbtCompound players = new NbtCompound();
        for (Map.Entry<UUID, NbtList> entry : playerInventories.entrySet()) {
            players.put(entry.getKey().toString(), entry.getValue());
        }
        nbt.put("Players", players);
        return nbt;
    }

    public static MagicBagPersistentState fromNbt(NbtCompound nbt) {
        MagicBagPersistentState state = new MagicBagPersistentState();
        NbtCompound players = nbt.getCompound("Players");
        for (String key : players.getKeys()) {
            try {
                UUID uuid = UUID.fromString(key);
                state.playerInventories.put(uuid, players.getList(key, 10)); // 10 = NbtCompound
            } catch (IllegalArgumentException ignored) {}
        }
        return state;
    }
}
