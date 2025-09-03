package net.spacegateir.steamcraft.item.trinkets.renderer;

import net.minecraft.util.Identifier;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class TrinketRenderRegistry {
    private static final Map<Item, TrinketRenderData> RENDERS = new HashMap<>();

    public static void register(Item item, String texturePath) {
        RENDERS.put(item, new TrinketRenderData(
                new Identifier("steamcraft", texturePath)
        ));
    }

    public static TrinketRenderData get(Item item) {
        return RENDERS.get(item);
    }

    public record TrinketRenderData( Identifier texture) {}
}