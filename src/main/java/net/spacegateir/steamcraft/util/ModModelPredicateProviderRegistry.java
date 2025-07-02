package net.spacegateir.steamcraft.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.spacegateir.steamcraft.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModModelPredicateProviderRegistry {

    public static void registerModelPredicates() {

        registerCustomShield(ModItems.CELESTIAL_GEARFORGED_SHIELD);
    }

    private static void registerCustomShield(Item item) {
        ModelPredicateProviderRegistry.register(
                item,
                new Identifier("blocking"),
                (stack, world, entity, seed) ->
                        entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}