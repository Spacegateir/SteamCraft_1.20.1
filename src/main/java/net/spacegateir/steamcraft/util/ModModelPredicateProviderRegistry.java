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

        registerCustomShield(ModItems.FOOLS_GOLD_SHIELD);
        registerCustomShield(ModItems.CELESTIAL_GEARFORGED_SHIELD);
        registerCustomBag(ModItems.MAGIC_BAG);
    }

    private static void registerCustomShield(Item item) {
        ModelPredicateProviderRegistry.register(
                item,
                new Identifier("blocking"),
                (stack, world, entity, seed) ->
                        entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }

    private static void registerCustomBag(Item item) {
        ModelPredicateProviderRegistry.register(
                item,
                new Identifier("open"),
                (stack, world, entity, seed) ->
                        stack.hasNbt() && stack.getNbt().getBoolean("Open") ? 1.0f : 0.0f
        );
    }

}