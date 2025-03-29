package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.Map;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TEST_ITEM, RecipeCategory.MISC, ModBlocks.TEST_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_COIN, 1)
                .input(ModItems.COPPER_COIN, 9)
                .criterion("has_copper_coin", conditionsFromItem(ModItems.COPPER_COIN))
                .offerTo(exporter, new Identifier("steamcraft", "copper_to_silver"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_COIN, 1)
                .input(ModItems.SILVER_COIN, 9)
                .criterion("has_silver_coin", conditionsFromItem(ModItems.SILVER_COIN))
                .offerTo(exporter, new Identifier("steamcraft", "silver_to_gold"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_COIN, 9)
                .input(ModItems.SILVER_COIN, 1)
                .criterion("has_copper_coin", conditionsFromItem(ModItems.COPPER_COIN))
                .offerTo(exporter, new Identifier("steamcraft", "silver_to_copper"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_COIN, 9)
                .input(ModItems.GOLD_COIN, 1)
                .criterion("has_silver_coin", conditionsFromItem(ModItems.SILVER_COIN))
                .offerTo(exporter, new Identifier("steamcraft", "gold_to_silver"));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_RECOMPILER)
                .pattern(" N ")
                .pattern("NGN")
                .pattern("IGI")
                .input('G', Blocks.GOLD_BLOCK)
                .input('N', Items.NETHERITE_INGOT)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PATTERN_RECOMPILER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL, 8)
                .pattern("III")
                .pattern("IOI")
                .pattern("III")
                .input('O', Blocks.OBSIDIAN)
                .input('I', Blocks.IRON_BLOCK)
                .criterion(hasItem(Blocks.OBSIDIAN), conditionsFromItem(Blocks.OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AETHER_COIL)));

        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_WHITE, i)
                    .input(Ingredient.ofItems(Items.WHITE_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_white_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_LIGHT_GRAY, i)
                    .input(Ingredient.ofItems(Items.LIGHT_GRAY_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_light_gray_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_GRAY, i)
                    .input(Ingredient.ofItems(Items.GRAY_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_gray_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_BLACK, i)
                    .input(Ingredient.ofItems(Items.BLACK_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_black_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_BROWN, i)
                    .input(Ingredient.ofItems(Items.BROWN_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_brown_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_RED, i)
                    .input(Ingredient.ofItems(Items.RED_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_red_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_ORANGE, i)
                    .input(Ingredient.ofItems(Items.ORANGE_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_orange_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_YELLOW, i)
                    .input(Ingredient.ofItems(Items.YELLOW_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_yellow_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_LIME, i)
                    .input(Ingredient.ofItems(Items.LIME_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_lime_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_GREEN, i)
                    .input(Ingredient.ofItems(Items.GREEN_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_green_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_CYAN, i)
                    .input(Ingredient.ofItems(Items.CYAN_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_cyan_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_LIGHT_BLUE, i)
                    .input(Ingredient.ofItems(Items.LIGHT_BLUE_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_light_blue_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_BLUE, i)
                    .input(Ingredient.ofItems(Items.BLUE_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_blue_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_PURPLE, i)
                    .input(Ingredient.ofItems(Items.PURPLE_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_purple_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_MAGENTA, i)
                    .input(Ingredient.ofItems(Items.MAGENTA_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_magenta_from_dye_and_aether_coil" + i));
        }
        for (int i = 1; i <= 8; i++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL_PINK, i)
                    .input(Ingredient.ofItems(Items.PINK_DYE))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), i)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier("steamcraft", "aether_coil_pink_from_dye_and_aether_coil" + i));
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOOLS_GOLD_HELMET)
                .pattern("12")
                .pattern("34")
                .input('1', ModItems.FOOLS_GOLD_HELMET_1)
                .input('2', ModItems.FOOLS_GOLD_HELMET_2)
                .input('3', ModItems.FOOLS_GOLD_HELMET_3)
                .input('4', ModItems.FOOLS_GOLD_HELMET_4)
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET_1), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET_1))
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET_2), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET_2))
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET_3), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET_3))
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET_4), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET_4))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FOOLS_GOLD_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOOLS_GOLD_CHESTPLATE)
                .pattern("12")
                .pattern("34")
                .input('1', ModItems.FOOLS_GOLD_CHESTPLATE_1)
                .input('2', ModItems.FOOLS_GOLD_CHESTPLATE_2)
                .input('3', ModItems.FOOLS_GOLD_CHESTPLATE_3)
                .input('4', ModItems.FOOLS_GOLD_CHESTPLATE_4)
                .criterion(hasItem(ModItems.FOOLS_GOLD_CHESTPLATE_1), conditionsFromItem(ModItems.FOOLS_GOLD_CHESTPLATE_1))
                .criterion(hasItem(ModItems.FOOLS_GOLD_CHESTPLATE_2), conditionsFromItem(ModItems.FOOLS_GOLD_CHESTPLATE_2))
                .criterion(hasItem(ModItems.FOOLS_GOLD_CHESTPLATE_3), conditionsFromItem(ModItems.FOOLS_GOLD_CHESTPLATE_3))
                .criterion(hasItem(ModItems.FOOLS_GOLD_CHESTPLATE_4), conditionsFromItem(ModItems.FOOLS_GOLD_CHESTPLATE_4))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FOOLS_GOLD_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOOLS_GOLD_LEGGINGS)
                .pattern("12")
                .pattern("34")
                .input('1', ModItems.FOOLS_GOLD_LEGGINGS_1)
                .input('2', ModItems.FOOLS_GOLD_LEGGINGS_2)
                .input('3', ModItems.FOOLS_GOLD_LEGGINGS_3)
                .input('4', ModItems.FOOLS_GOLD_LEGGINGS_4)
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS_1), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS_1))
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS_2), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS_2))
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS_3), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS_3))
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS_4), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS_4))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FOOLS_GOLD_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOOLS_GOLD_BOOTS)
                .pattern("12")
                .pattern("34")
                .input('1', ModItems.FOOLS_GOLD_BOOTS_1)
                .input('2', ModItems.FOOLS_GOLD_BOOTS_2)
                .input('3', ModItems.FOOLS_GOLD_BOOTS_3)
                .input('4', ModItems.FOOLS_GOLD_BOOTS_4)
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS_1), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS_1))
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS_2), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS_2))
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS_3), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS_3))
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS_4), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS_4))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FOOLS_GOLD_BOOTS)));


    }
}



