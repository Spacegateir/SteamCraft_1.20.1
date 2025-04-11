package net.spacegateir.steamcraft.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.armor.FoolsGoldArmourItem;

public class ModModelPredicateProvider {
    public static void registerModelPredicates() {

        // Register predicate for helmet
        ModelPredicateProviderRegistry.register(ModItems.FOOLS_GOLD_HELMET, new Identifier("broken"),
                (stack, world, entity, seed) -> FoolsGoldArmourItem.isUsable(stack) ? 0.0F : 1.0F);

        // Register predicate for chestplate
        ModelPredicateProviderRegistry.register(ModItems.FOOLS_GOLD_CHESTPLATE, new Identifier("broken"),
                (stack, world, entity, seed) -> FoolsGoldArmourItem.isUsable(stack) ? 0.0F : 1.0F);

        // Register predicate for leggings
        ModelPredicateProviderRegistry.register(ModItems.FOOLS_GOLD_LEGGINGS, new Identifier("broken"),
                (stack, world, entity, seed) -> FoolsGoldArmourItem.isUsable(stack) ? 0.0F : 1.0F);

        // Register predicate for boots
        ModelPredicateProviderRegistry.register(ModItems.FOOLS_GOLD_BOOTS, new Identifier("broken"),
                (stack, world, entity, seed) -> FoolsGoldArmourItem.isUsable(stack) ? 0.0F : 1.0F);
    }
}
