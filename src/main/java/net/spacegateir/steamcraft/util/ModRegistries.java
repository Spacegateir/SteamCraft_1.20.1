package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.mixin.BrewingRecipeRegistryMixin;
import net.spacegateir.steamcraft.potion.ModPotions;

public class ModRegistries {
    public static void registerModStuff() {

        createPortal();
        registerPotionRecipes();
    }

    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_GREEN)
                .lightWithItem(ModItems.FERRITE_HEARTSTONE)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_green"))
                .setPortalSearchYRange(50, 150)
                .tintColor(0x009300)
                .registerPortal();

//        CustomPortalBuilder.beginPortal()
//                .frameBlock(ModBlocks.AETHER_COIL_BLUE)
//                .lightWithItem(ModItems.AQUARION_SHARD)
//                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_blue"))
//                .setPortalSearchYRange(64, 64)
//                .tintColor(0x0000ff)
//                .registerPortal();

//        CustomPortalBuilder.beginPortal()
//                .frameBlock(ModBlocks.AETHER_COIL_RED)
//                .lightWithItem(ModItems.PYROCITE_CORE)
//                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_red"))
//                .setPortalSearchYRange(50, 150)
//                .tintColor(0xff0000)
//                .registerPortal();

//        CustomPortalBuilder.beginPortal()
//                .frameBlock(ModBlocks.AETHER_COIL_YELLOW)
//                .lightWithItem(ModItems.AETHERIUM_PRISM)
//                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_yellow"))
//                .setPortalSearchYRange(64, 64)
//                .tintColor(0xffa500)
//                .registerPortal();

//        CustomPortalBuilder.beginPortal()
//                .frameBlock(ModBlocks.AETHER_COIL_WHITE)
//                .lightWithItem(ModItems.LUMINITE_SPARK)
//                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_white"))
//                .setPortalSearchYRange(64, 64)
//                .tintColor(0xffffff)
//                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_BLACK)
                .lightWithItem(ModItems.OBSCURIUM_CRYSTAL)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_black"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0x000000)
                .registerPortal();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.SLOW_FALLING, Items.SLIME_BALL, ModPotions.STICKY_FEAT_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.STICKY_FEAT_POTION, Items.REDSTONE, ModPotions.STICKY_FEAT_POTION_1); // 8 min
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.STICKY_FEAT_POTION, Items.GLOWSTONE_DUST, ModPotions.STICKY_FEAT_POTION_2); // lvl 2

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.HARMING, Items.POISONOUS_POTATO, ModPotions.DISORIENT_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.DISORIENT_POTION, Items.REDSTONE, ModPotions.DISORIENT_POTION_1); // 8 min
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.DISORIENT_POTION, Items.GLOWSTONE_DUST, ModPotions.DISORIENT_POTION_2); // lvl 2

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.LEAPING, Items.CARROT, ModPotions.FREAKY_BUNNY_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FREAKY_BUNNY_POTION, Items.REDSTONE, ModPotions.FREAKY_BUNNY_POTION_1); // 8 min
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FREAKY_BUNNY_POTION, Items.GLOWSTONE_DUST, ModPotions.FREAKY_BUNNY_POTION_2); // lvl 2

        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.REGENERATION, Items.NETHER_STAR, ModPotions.CLEAR_NEGATIVE_EFFECT_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.REGENERATION, Items.HEART_OF_THE_SEA, ModPotions.CLEAR_NEUTRAL_EFFECT_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.REGENERATION, Items.ECHO_SHARD, ModPotions.CLEAR_POSITIVE_EFFECT_POTION);
    }



}
