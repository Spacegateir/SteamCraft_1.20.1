package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
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

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SNOW_DROP_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CARNATION_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.VIOLET_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.IRIS_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PRIMROSE_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DAFFODIL_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DELPHINIUM_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DAHLIA_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HYDRANGEA_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HAWTHORN_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BONSAI_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SPIDERLILY_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LARKSPUR_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.AGAPANTHUS_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BLUE_COSMOS_FLOWER_ITEM, 0.4F);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_SNOW_DROP_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_CARNATION_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_VIOLET_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_IRIS_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_PRIMROSE_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_DAFFODIL_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_DELPHINIUM_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_DAHLIA_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_HYDRANGEA_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_HAWTHORN_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_BONSAI_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_SPIDERLILY_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LARKSPUR_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_AGAPANTHUS_FLOWER_ITEM, 0.4F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_BLUE_COSMOS_FLOWER_ITEM, 0.4F);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_SNOW_DROP_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_CARNATION_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_VIOLET_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_IRIS_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_PRIMROSE_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_DAFFODIL_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_DELPHINIUM_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_DAHLIA_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_HYDRANGEA_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_HAWTHORN_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_BONSAI_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_SPIDERLILY_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_LARKSPUR_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_AGAPANTHUS_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.THORNED_BLUE_COSMOS_FLOWER_ITEM, 0.6F);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_SNOW_DROP_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_CARNATION_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_VIOLET_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_IRIS_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_PRIMROSE_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_DAFFODIL_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_DELPHINIUM_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_DAHLIA_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_HYDRANGEA_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_HAWTHORN_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_BONSAI_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_SPIDERLILY_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_LARKSPUR_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_AGAPANTHUS_FLOWER_ITEM, 0.6F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_THORNED_BLUE_COSMOS_FLOWER_ITEM, 0.6F);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_SNOW_DROP_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_CARNATION_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_VIOLET_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_IRIS_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_PRIMROSE_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_DAFFODIL_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_DELPHINIUM_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_DAHLIA_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_HYDRANGEA_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_HAWTHORN_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_BONSAI_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_SPIDERLILY_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_LARKSPUR_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_AGAPANTHUS_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LUSH_BLUE_COSMOS_FLOWER_ITEM, 0.8F);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_SNOW_DROP_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_CARNATION_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_VIOLET_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_IRIS_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_PRIMROSE_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_DAFFODIL_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_DELPHINIUM_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_DAHLIA_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_HYDRANGEA_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_HAWTHORN_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_BONSAI_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_SPIDERLILY_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_LARKSPUR_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_AGAPANTHUS_FLOWER_ITEM, 0.8F);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GLOW_LUSH_BLUE_COSMOS_FLOWER_ITEM, 0.8F);
    }
}



