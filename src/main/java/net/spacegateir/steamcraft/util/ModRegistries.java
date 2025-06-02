package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.potion.ModPotions;

public class ModRegistries {
    public static void registerModStuff() {

        createPortal();
        registerPotionRecipes();
        registerModCompostables();
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        ModItems.COLOR_TO_LAVA_BUCKET.values().forEach(lavaBucket -> registry.add(lavaBucket, 20_000));
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
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.SLOW_FALLING, Ingredient.ofItems(Items.SLIME_BALL), ModPotions.STICKY_FEAT_POTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.STICKY_FEAT_POTION, Ingredient.ofItems(Items.REDSTONE), ModPotions.STICKY_FEAT_POTION_1); // 8 min
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.STICKY_FEAT_POTION, Ingredient.ofItems(Items.GLOWSTONE_DUST), ModPotions.STICKY_FEAT_POTION_2); // lvl 2

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.HARMING, Ingredient.ofItems(Items.POISONOUS_POTATO), ModPotions.DISORIENT_POTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.DISORIENT_POTION, Ingredient.ofItems(Items.REDSTONE), ModPotions.DISORIENT_POTION_1); // 8 min
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.DISORIENT_POTION, Ingredient.ofItems(Items.GLOWSTONE_DUST), ModPotions.DISORIENT_POTION_2); // lvl 2

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.LEAPING, Ingredient.ofItems(Items.CARROT), ModPotions.FREAKY_BUNNY_POTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.FREAKY_BUNNY_POTION, Ingredient.ofItems(Items.REDSTONE), ModPotions.FREAKY_BUNNY_POTION_1); // 8 min
        FabricBrewingRecipeRegistry.registerPotionRecipe(ModPotions.FREAKY_BUNNY_POTION, Ingredient.ofItems(Items.GLOWSTONE_DUST), ModPotions.FREAKY_BUNNY_POTION_2); // lvl 2

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.REGENERATION, Ingredient.ofItems(Items.NETHER_STAR), ModPotions.CLEAR_NEGATIVE_EFFECT_POTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.REGENERATION, Ingredient.ofItems(Items.HEART_OF_THE_SEA), ModPotions.CLEAR_NEUTRAL_EFFECT_POTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.REGENERATION, Ingredient.ofItems(Items.ECHO_SHARD), ModPotions.CLEAR_POSITIVE_EFFECT_POTION);
    }

    private static void registerModCompostables() {

        for (Block flower : ModBlocks.COLOR_TO_FLOWER.values()) {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(flower, 0.4F);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWER_TO_GLOW_FLOWER.get(flower), 0.4F);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower), 0.6F);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.get(flower), 0.6F);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower), 0.8F);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.get(flower), 0.8F);
        }
    }
}



