package net.spacegateir.steamcraft.potion;

import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion STICKY_FEAT_POTION = registerPotion("sticky_feat_potion",
            new Potion(new StatusEffectInstance(ModEffects.STICKY_FEAT, 2400, 0)));
    public static final Potion STICKY_FEAT_POTION_1 = registerPotion("sticky_feat_potion_1",
            new Potion(new StatusEffectInstance(ModEffects.STICKY_FEAT, 9600, 0)));
    public static final Potion STICKY_FEAT_POTION_2 = registerPotion("sticky_feat_potion_2",
            new Potion(new StatusEffectInstance(ModEffects.STICKY_FEAT, 1200, 1)));

    public static final Potion DISORIENT_POTION = registerPotion("disorient_potion",
            new Potion(new StatusEffectInstance(ModEffects.DISORIENT, 400, 0)));
    public static final Potion DISORIENT_POTION_1 = registerPotion("disorient_potion_1",
            new Potion(new StatusEffectInstance(ModEffects.DISORIENT, 800, 0)));
    public static final Potion DISORIENT_POTION_2 = registerPotion("disorient_potion_2",
            new Potion(new StatusEffectInstance(ModEffects.DISORIENT, 200, 1)));

    public static final Potion FREAKY_BUNNY_POTION = registerPotion("freaky_bunny_potion",
            new Potion(new StatusEffectInstance(ModEffects.FREAKY_BUNNY, 400, 0)));
    public static final Potion FREAKY_BUNNY_POTION_1 = registerPotion("freaky_bunny_potion_1",
            new Potion(new StatusEffectInstance(ModEffects.FREAKY_BUNNY, 800, 0)));
    public static final Potion FREAKY_BUNNY_POTION_2 = registerPotion("freaky_bunny_potion_2",
            new Potion(new StatusEffectInstance(ModEffects.FREAKY_BUNNY, 200, 1)));



    public static final Potion CLEAR_NEGATIVE_EFFECT_POTION = registerPotion("clear_negative_effect_potion",
            new Potion(new StatusEffectInstance(ModEffects.CLEAR_NEGATIVE_EFFECT, 600, 0)));

    public static final Potion CLEAR_NEUTRAL_EFFECT_POTION = registerPotion("clear_neutral_effect_potion",
            new Potion(new StatusEffectInstance(ModEffects.CLEAR_NEUTRAL_EFFECT, 600, 0)));

    public static final Potion CLEAR_POSITIVE_EFFECT_POTION = registerPotion("clear_positive_effect_potion",
            new Potion(new StatusEffectInstance(ModEffects.CLEAR_POSITIVE_EFFECT, 600, 0)));




    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(Steamcraft.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Steamcraft.LOGGER.info("Registering Potions");
    }
}