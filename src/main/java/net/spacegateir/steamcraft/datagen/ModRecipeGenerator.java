package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    private static void offerReversibleCompactingRecipesWithId(Consumer<RecipeJsonProvider> exporter, RecipeCategory baseCategory, ItemConvertible base,
                                                              RecipeCategory resultCategory, ItemConvertible result, String idSuffix) {

        ShapedRecipeJsonBuilder.create(resultCategory, result)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', base)
                .criterion("has_" + Registries.ITEM.getId(base.asItem()).getPath(), conditionsFromItem(base))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, Registries.ITEM.getId(result.asItem()).getPath() + "_from_" + idSuffix));

        ShapelessRecipeJsonBuilder.create(baseCategory, base, 9)
                .input(result)
                .criterion("has_" + Registries.ITEM.getId(result.asItem()).getPath(), conditionsFromItem(result))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, Registries.ITEM.getId(base.asItem()).getPath() + "_from_" + idSuffix));
    }

    private static void offerAetherCoilRecipe(Consumer<RecipeJsonProvider> exporter, Block coloredCoil, Item dye) {
        for (int coilCount = 1; coilCount <= 8; coilCount++) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, coloredCoil, coilCount)
                    .input(Ingredient.ofItems(dye))
                    .input(Ingredient.ofItems(ModBlocks.AETHER_COIL), coilCount)
                    .criterion("has_aether_coil", RecipeProvider.conditionsFromItem(ModBlocks.AETHER_COIL))
                    .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, Registries.ITEM.getId(dye).getPath() + coilCount));
        }
    }


    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_SCRAP, RecipeCategory.MISC, ModItems.FOOLS_GOLD_RAW, "scrap");
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_RAW, RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_RAW_BLOCK, "block");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT, RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_BLOCK);

        offerSmelting(exporter, List.of(ModItems.FOOLS_GOLD_RAW), RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT,
                1.00f, 200, "fools_gold");
        offerBlasting(exporter, List.of(ModItems.FOOLS_GOLD_RAW), RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT,
                1.00f, 100, "fools_gold");

        offerSmelting(exporter, List.of(Items.LODESTONE), RecipeCategory.MISC, Items.NETHERITE_INGOT,
                1.00f, 200, "netherite_ingot");
        offerBlasting(exporter, List.of(Items.LODESTONE), RecipeCategory.MISC, Items.NETHERITE_INGOT,
                1.00f, 100, "netherite_ingot");

        offerSmelting(exporter, List.of(ModBlocks.PACKED_ICE_BRICKS), RecipeCategory.MISC, ModBlocks.PACKED_ICE_BRICKS_CRACKED,
                0.10f, 50, "packed_ice_bricks");
        offerBlasting(exporter, List.of(ModBlocks.PACKED_ICE_BRICKS), RecipeCategory.MISC, ModBlocks.PACKED_ICE_BRICKS_CRACKED,
                0.10f, 50, "packed_ice_bricks");
        offerSmelting(exporter, List.of(ModBlocks.PACKED_ICE_TILES), RecipeCategory.MISC, ModBlocks.PACKED_ICE_TILES_CRACKED,
                0.10f, 50, "packed_ice_tiles");
        offerBlasting(exporter, List.of(ModBlocks.PACKED_ICE_TILES), RecipeCategory.MISC, ModBlocks.PACKED_ICE_TILES_CRACKED,
                0.10f, 50, "packed_ice_tiles");

        offerSmelting(exporter, List.of(ModBlocks.SNOW_BRICKS), RecipeCategory.MISC, ModBlocks.SNOW_BRICKS_CRACKED,
                0.10f, 50, "snow_bricks");
        offerBlasting(exporter, List.of(ModBlocks.SNOW_BRICKS), RecipeCategory.MISC, ModBlocks.SNOW_BRICKS_CRACKED,
                0.10f, 50, "snow_bricks");
        offerSmelting(exporter, List.of(ModBlocks.SNOW_TILES), RecipeCategory.MISC, ModBlocks.SNOW_TILES_CRACKED,
                0.10f, 50, "snow_tiles");
        offerBlasting(exporter, List.of(ModBlocks.SNOW_TILES), RecipeCategory.MISC, ModBlocks.SNOW_TILES_CRACKED,
                0.10f, 50, "snow_tiles");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_COIN, 1)
                .input(ModItems.COPPER_COIN, 9)
                .criterion("has_copper_coin", conditionsFromItem(ModItems.COPPER_COIN))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "copper_to_silver"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_COIN, 1)
                .input(ModItems.SILVER_COIN, 9)
                .criterion("has_silver_coin", conditionsFromItem(ModItems.SILVER_COIN))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "silver_to_gold"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_COIN, 9)
                .input(ModItems.SILVER_COIN, 1)
                .criterion("has_copper_coin", conditionsFromItem(ModItems.COPPER_COIN))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "silver_to_copper"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_COIN, 9)
                .input(ModItems.GOLD_COIN, 1)
                .criterion("has_silver_coin", conditionsFromItem(ModItems.SILVER_COIN))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "gold_to_silver"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_RECOMPILER)
                .pattern(" N ")
                .pattern("NGN")
                .pattern("IGI")
                .input('G', Blocks.GOLD_BLOCK)
                .input('N', Items.NETHERITE_INGOT)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TROWEL)
                .pattern("  1")
                .pattern(" 1 ")
                .pattern("2  ")
                .input('1', Items.STICK)
                .input('2', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TRAP_CONCEALER)
                .pattern(" N ")
                .pattern("N1N")
                .pattern("IGI")
                .input('G', Blocks.GOLD_BLOCK)
                .input('N', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('I', Items.COPPER_INGOT)
                .input('1', ModItems.PATTERN_RECOMPILER)
                .criterion(hasItem(ModItems.DIVINITITE_ALLOY_INGOT), conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SMOKE_BLOCK_ITEM, 16)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('1', ModItems.CORE_OF_CHANGING)
                .input('2', Items.CAMPFIRE)
                .criterion(hasItem(ModItems.CORE_OF_CHANGING), conditionsFromItem(ModItems.CORE_OF_CHANGING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AETHER_COIL, 8)
                .pattern("III")
                .pattern("IOI")
                .pattern("III")
                .input('O', Blocks.OBSIDIAN)
                .input('I', Blocks.IRON_BLOCK)
                .criterion(hasItem(Blocks.OBSIDIAN), conditionsFromItem(Blocks.OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AETHER_COIL)));

        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_WHITE, Items.WHITE_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_LIGHT_GRAY, Items.LIGHT_GRAY_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_GRAY, Items.GRAY_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_BLACK, Items.BLACK_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_BROWN, Items.BROWN_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_RED, Items.RED_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_ORANGE, Items.ORANGE_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_YELLOW, Items.YELLOW_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_LIME, Items.LIME_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_GREEN, Items.GREEN_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_CYAN, Items.CYAN_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_LIGHT_BLUE, Items.LIGHT_BLUE_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_BLUE, Items.BLUE_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_PURPLE, Items.PURPLE_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_MAGENTA, Items.MAGENTA_DYE);
        offerAetherCoilRecipe(exporter, ModBlocks.AETHER_COIL_PINK, Items.PINK_DYE);

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
                .offerTo(exporter);

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
                .offerTo(exporter);

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
                .offerTo(exporter);

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
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_HELMET)
                .pattern("323")
                .pattern("313")
                .input('1', ModItems.FOOLS_GOLD_HELMET)
                .input('2', ModItems.LUMINITE_SPARK)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_CHESTPLATE)
                .pattern("515")
                .pattern("525")
                .pattern("354")
                .input('1', ModItems.FOOLS_GOLD_CHESTPLATE)
                .input('2', ModItems.OBSCURIUM_CRYSTAL)
                .input('3', ModItems.PYROCITE_CORE)
                .input('4', ModItems.AQUARION_SHARD)
                .input('5', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_CHESTPLATE), conditionsFromItem(ModItems.FOOLS_GOLD_CHESTPLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_LEGGINGS)
                .pattern("444")
                .pattern("213")
                .pattern("4 4")
                .input('1', ModItems.FOOLS_GOLD_LEGGINGS)
                .input('2', ModItems.FERRITE_HEARTSTONE)
                .input('3', ModItems.AETHERIUM_PRISM)
                .input('4', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_BOOTS)
                .pattern(" 2 ")
                .pattern("313")
                .pattern("3 3")
                .input('1', ModItems.FOOLS_GOLD_BOOTS)
                .input('2', ModItems.WINGED_SANDALS)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINITITE_ALLOY_INGOT)
                .pattern("424")
                .pattern("313")
                .pattern("424")
                .input('1', ModItems.FOOLS_GOLD_INGOT)
                .input('2', Items.NETHERITE_INGOT)
                .input('3', Items.NETHER_STAR)
                .input('4', Blocks.GOLD_BLOCK)
                .criterion(hasItem(ModItems.FOOLS_GOLD_INGOT), conditionsFromItem(ModItems.FOOLS_GOLD_INGOT))
                .offerTo(exporter);

//Tuff Crafting
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.TUFF, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Items.DEEPSLATE)
                .input('2', Items.OBSIDIAN)
                .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                .offerTo(exporter, new Identifier(getRecipeName(Items.TUFF) + "deepslate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.TUFF, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Items.COBBLED_DEEPSLATE)
                .input('2', Items.OBSIDIAN)
                .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                .offerTo(exporter, convertBetween(Items.TUFF, Items.COBBLED_DEEPSLATE));

//Rooted Dirt
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ROOTED_DIRT, 1)
                .pattern("12")
                .input('1', Items.DIRT)
                .input('2', Items.HANGING_ROOTS)
                .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter);

//Mud
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MUD, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Items.DIRT)
                .input('2', Items.WATER_BUCKET)
                .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter);

//Gilded Blackstone
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GILDED_BLACKSTONE, 2)
                .pattern("12")
                .pattern("21")
                .input('1', Items.BLACKSTONE)
                .input('2', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

//Crying Obsidian
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CRYING_OBSIDIAN, 2)
                .pattern("12")
                .pattern("21")
                .input('1', Items.OBSIDIAN)
                .input('2', Items.ENDER_PEARL)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter);

//Mould Duplicating
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HELMET_MOULD, 2)
                .pattern("121")
                .pattern("131")
                .pattern("111")
                .input('1', ModItems.BLANK_MOULD)
                .input('2', ModItems.HELMET_MOULD)
                .input('3', Items.NETHERITE_HELMET)
                .criterion(hasItem(ModItems.HELMET_MOULD), conditionsFromItem(ModItems.HELMET_MOULD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHESTPLATE_MOULD, 2)
                .pattern("121")
                .pattern("131")
                .pattern("111")
                .input('1', ModItems.BLANK_MOULD)
                .input('2', ModItems.CHESTPLATE_MOULD)
                .input('3', Items.NETHERITE_CHESTPLATE)
                .criterion(hasItem(ModItems.CHESTPLATE_MOULD), conditionsFromItem(ModItems.CHESTPLATE_MOULD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEGGINGS_MOULD, 2)
                .pattern("121")
                .pattern("131")
                .pattern("111")
                .input('1', ModItems.BLANK_MOULD)
                .input('2', ModItems.LEGGINGS_MOULD)
                .input('3', Items.NETHERITE_LEGGINGS)
                .criterion(hasItem(ModItems.LEGGINGS_MOULD), conditionsFromItem(ModItems.LEGGINGS_MOULD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOOTS_MOULD, 2)
                .pattern("121")
                .pattern("131")
                .pattern("111")
                .input('1', ModItems.BLANK_MOULD)
                .input('2', ModItems.BOOTS_MOULD)
                .input('3', Items.NETHERITE_BOOTS)
                .criterion(hasItem(ModItems.BOOTS_MOULD), conditionsFromItem(ModItems.BOOTS_MOULD))
                .offerTo(exporter);

//Smithing Table Recipies
//Fools Gold Helmet
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HELMET_MOULD),
                        Ingredient.ofItems(ModBlocks.FOOLS_GOLD_BLOCK.asItem()),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.FOOLS_GOLD_HELMET
                )
                .criterion("has_helmet_mould", conditionsFromItem(ModItems.HELMET_MOULD))
                .criterion("has_fools_gold_block", conditionsFromItem(ModBlocks.FOOLS_GOLD_BLOCK.asItem()))
                .criterion("has_ancient_gem", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "fools_gold_helmet_smithing"));

//Fools Gold Chestplate
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.CHESTPLATE_MOULD),
                        Ingredient.ofItems(ModBlocks.FOOLS_GOLD_BLOCK.asItem()),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.FOOLS_GOLD_CHESTPLATE
                )
                .criterion("has_chestplate_mould", conditionsFromItem(ModItems.CHESTPLATE_MOULD))
                .criterion("has_fools_gold_block", conditionsFromItem(ModBlocks.FOOLS_GOLD_BLOCK.asItem()))
                .criterion("has_ancient_gem", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "fools_gold_chestplate_smithing"));

//Fools Gold Leggings
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.LEGGINGS_MOULD),
                        Ingredient.ofItems(ModBlocks.FOOLS_GOLD_BLOCK.asItem()),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.FOOLS_GOLD_LEGGINGS
                )
                .criterion("has_leggings_mould", conditionsFromItem(ModItems.LEGGINGS_MOULD))
                .criterion("has_fools_gold_block", conditionsFromItem(ModBlocks.FOOLS_GOLD_BLOCK.asItem()))
                .criterion("has_ancient_gem", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "fools_gold_leggings_smithing"));

//Fools Gold Boots
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BOOTS_MOULD),
                        Ingredient.ofItems(ModBlocks.FOOLS_GOLD_BLOCK.asItem()),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.FOOLS_GOLD_BOOTS
                )
                .criterion("has_boots_mould", conditionsFromItem(ModItems.BOOTS_MOULD))
                .criterion("has_fools_gold_block", conditionsFromItem(ModBlocks.FOOLS_GOLD_BLOCK.asItem()))
                .criterion("has_ancient_gem", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(Steamcraft.MOD_ID, "fools_gold_boots_smithing"));

// Skeleton BoneMeal Recipes
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_HEAD, "misc", 3);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_ARM, "misc", 3);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_LEG, "misc", 3);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_CHEST, "misc", 3);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_PELVIS, "misc", 3);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, ModBlocks.SKELETON_SPINE, "misc", 3);

        // Skeleton Sitting
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_SITTING, 1)
                .pattern(" H ")
                .pattern("ATA")
                .pattern("L L")
                .input('H', ModBlocks.SKELETON_HEAD)
                .input('T', ModBlocks.SKELETON_TORSO)
                .input('A', ModBlocks.SKELETON_ARM)
                .input('L', ModBlocks.SKELETON_LEG)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_SITTING)));

        // Skeleton Laying
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_LAYING, 1)
                .pattern(" A ")
                .pattern("HTL")
                .input('H', ModBlocks.SKELETON_HEAD)
                .input('T', ModBlocks.SKELETON_TORSO)
                .input('A', ModBlocks.SKELETON_ARMS_CROSS)
                .input('L', ModBlocks.SKELETON_LEGS_CROSS)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_LAYING)));

        // Skeleton Torso
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_TORSO, 1)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" P ")
                .input('C', ModBlocks.SKELETON_CHEST)
                .input('S', ModBlocks.SKELETON_SPINE)
                .input('P', ModBlocks.SKELETON_PELVIS)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_TORSO)));

        // Skeleton Arms Cross
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_ARMS_CROSS, 1)
                .pattern("AA")
                .input('A', ModBlocks.SKELETON_ARM)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_ARMS_CROSS)));

        // Skeleton Legs Cross
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_LEGS_CROSS, 1)
                .pattern("AA")
                .input('A', ModBlocks.SKELETON_LEG)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_LEGS_CROSS)));

        // Skeleton Arms Cross
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_HEAD_STACK, 1)
                .pattern("HHH")
                .input('H', ModBlocks.SKELETON_HEAD)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_HEAD_STACK)));

        // Skeleton Half Body
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SKELETON_HALF_BODY, 1)
                .pattern("HAL")
                .input('H', ModBlocks.SKELETON_HEAD)
                .input('A', ModBlocks.SKELETON_ARM)
                .input('L', ModBlocks.SKELETON_LEG)
                .criterion("has_skeleton_head", conditionsFromItem(ModBlocks.SKELETON_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SKELETON_HALF_BODY)));

        // Arcane Blocks

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CORE_OF_CHANGING, 1)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .input('1', Blocks.STONE)
                .input('2', Blocks.DEEPSLATE)
                .input('3', Blocks.BRICKS)
                .input('4', Blocks.ANDESITE)
                .input('5', Blocks.DIAMOND_BLOCK)
                .input('6', Blocks.GRANITE)
                .input('7', Blocks.DIORITE)
                .input('8', Blocks.GRAVEL)
                .input('9', Blocks.TERRACOTTA)
                .criterion("has_diamond_block", conditionsFromItem(Blocks.DIAMOND_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_ABSORPTION_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.HONEY_BOTTLE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_ABSORPTION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_BAD_OMEN_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.TOTEM_OF_UNDYING)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_BAD_OMEN_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_BLINDNESS_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SHULKER_SHELL)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_BLINDNESS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_CONDUIT_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.CONDUIT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_CONDUIT_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_DARKNESS_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.BLACK_CANDLE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_DARKNESS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.TRIDENT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.MAGMA_CREAM)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_GLOWING_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GLOWSTONE_DUST)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_GLOWING_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_HASTE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SADDLE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_HASTE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_HEALTH_BOOST_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GOLDEN_APPLE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_HEALTH_BOOST_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.DIAMOND_SWORD)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GLISTERING_MELON_SLICE)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GLISTERING_MELON_SLICE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_INVISIBILITY_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_INVISIBILITY_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_JUMP_BOOST_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.RABBIT_FOOT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_JUMP_BOOST_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_LEVITATION_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.PHANTOM_MEMBRANE)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_LEVITATION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_LUCK_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GUNPOWDER)
                .input('5', Items.RABBIT_FOOT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_LUCK_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_MINING_FATIGUE_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SADDLE)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_NEAUSEA_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.ROTTEN_FLESH)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_NEAUSEA_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_NIGHT_VISION_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GOLDEN_CARROT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_NIGHT_VISION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_POISION_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_POISION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_REGENERATION_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GHAST_TEAR)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_REGENERATION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_RESISTANCE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.TURTLE_HELMET)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_RESISTANCE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_SATUATION_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.BEEF)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_SATUATION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_SLOW_FALL_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.PHANTOM_MEMBRANE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_SLOW_FALL_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_SLOWNESS_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SUGAR)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_SLOWNESS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_SPEED_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SUGAR)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_SPEED_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_STARVING_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.BONE)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_STARVING_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_STRENGTH_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.BLAZE_POWDER)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_STRENGTH_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_UNLUCK_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.GUNPOWDER)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_UNLUCK_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_WATER_BREATHING_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.PUFFERFISH)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_WATER_BREATHING_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_WEAKNESS_BLOCK, 1)
                .pattern("151")
                .pattern("232")
                .pattern("424")
                .input('1', Items.BLAZE_POWDER)
                .input('5', Items.FERMENTED_SPIDER_EYE)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_WEAKNESS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_WITHER_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.WITHER_SKELETON_SKULL)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_WITHER_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.NETHER_STAR)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.ECHO_SHARD)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.HEART_OF_THE_SEA)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_DISORIENT_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.POISONOUS_POTATO)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_DISORIENT_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_STICKY_FEAT_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.SLIME_BALL)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_STICKY_FEAT_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.CARROT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_VOID_BLOCK, 1)
                .pattern("123")
                .input('1', ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK)
                .input('2', ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK)
                .input('3', ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_VOID_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POWER_PRECISION_BLOCK, 1)
                .pattern("121")
                .pattern("232")
                .pattern("121")
                .input('1', Blocks.COPPER_BLOCK)
                .input('2', Items.COMPARATOR)
                .input('3', Blocks.REDSTONE_BLOCK)
                .criterion("has_copper_block", conditionsFromItem(Blocks.COPPER_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POWER_PRECISION_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SAND_QUICKSAND, 8)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('2', Blocks.SAND)
                .input('1', Items.WATER_BUCKET)
                .criterion("has_sand_block", conditionsFromItem(Blocks.SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAND_QUICKSAND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RED_SAND_QUICKSAND, 8)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('2', Blocks.RED_SAND)
                .input('1', Items.WATER_BUCKET)
                .criterion("has_red_sand_block", conditionsFromItem(Blocks.RED_SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RED_SAND_QUICKSAND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GRAVEL_SINKSTONE, 8)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('2', Blocks.GRAVEL)
                .input('1', Items.WATER_BUCKET)
                .criterion("has_gravel_block", conditionsFromItem(Blocks.GRAVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GRAVEL_SINKSTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MUD_SINKING_SLUDGE, 8)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('2', Blocks.MUD)
                .input('1', Items.WATER_BUCKET)
                .criterion("has_mud_block", conditionsFromItem(Blocks.MUD))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MUD_SINKING_SLUDGE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND, 8)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('2', Blocks.SOUL_SAND)
                .input('1', Items.WATER_BUCKET)
                .criterion("has_soul_sand", conditionsFromItem(Blocks.SOUL_SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STONE_TRAP_BLOCK, 1)
                .pattern("333")
                .pattern("212")
                .pattern("222")
                .input('1', ModBlocks.POWER_PRECISION_BLOCK)
                .input('2', Items.COPPER_INGOT)
                .input('3', Blocks.STONE)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STONE_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEEPSLATE_TRAP_BLOCK, 1)
                .pattern("333")
                .pattern("212")
                .pattern("222")
                .input('1', ModBlocks.POWER_PRECISION_BLOCK)
                .input('2', Items.COPPER_INGOT)
                .input('3', Blocks.COBBLED_DEEPSLATE)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEEPSLATE_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COURSE_DIRT_TRAP_BLOCK, 1)
                .pattern("333")
                .pattern("212")
                .pattern("222")
                .input('1', ModBlocks.POWER_PRECISION_BLOCK)
                .input('2', Items.COPPER_INGOT)
                .input('3', Blocks.COARSE_DIRT)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COURSE_DIRT_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.EMPTY_BRASIER, 1)
                .pattern("212")
                .pattern("232")
                .input('1', Blocks.CAMPFIRE)
                .input('2', Blocks.IRON_BARS)
                .input('3', Blocks.IRON_BLOCK)
                .criterion("has_iron_block", conditionsFromItem(Blocks.IRON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.EMPTY_BRASIER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NETHER_STEAM_VENT, 1)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.NETHERRACK)
                .input('2', Blocks.SOUL_CAMPFIRE)
                .criterion("has_netherrack", conditionsFromItem(Blocks.NETHERRACK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.NETHER_STEAM_VENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLAREFORGE_BLOCK, 1)
                .pattern("111")
                .pattern("323")
                .pattern("333")
                .input('1', Blocks.BLAST_FURNACE)
                .input('2', Blocks.SOUL_CAMPFIRE)
                .input('3', Blocks.BRICKS)
                .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLAREFORGE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPIRIT_JUMP_TRAP, 1)
                .pattern("111")
                .pattern("323")
                .pattern("343")
                .input('1', Blocks.DARK_OAK_PLANKS)
                .input('2', Blocks.PISTON)
                .input('3', Blocks.DARK_OAK_LOG)
                .input('4', ModBlocks.POWER_PRECISION_BLOCK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SPIRIT_JUMP_TRAP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CURSED_TOTEM_BLOCK, 1)
                .pattern("232")
                .pattern("141")
                .pattern("151")
                .input('1', Blocks.STONE)
                .input('2', Blocks.COBBLED_DEEPSLATE)
                .input('3', ModBlocks.ARCANE_BLINDNESS_BLOCK)
                .input('4', ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)
                .input('5', ModBlocks.POWER_PRECISION_BLOCK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CURSED_TOTEM_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FROST_BITE_TRAP_BLOCK, 1)
                .pattern("121")
                .pattern("141")
                .pattern("131")
                .input('1', Blocks.BLUE_ICE)
                .input('2', ModBlocks.ARCANE_CONDUIT_BLOCK)
                .input('3', ModBlocks.ARCANE_SLOWNESS_BLOCK)
                .input('4', ModBlocks.POWER_PRECISION_BLOCK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FROST_BITE_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CURSED_NAUSEA_TRAP_BLOCK, 1)
                .pattern("121")
                .pattern("141")
                .pattern("131")
                .input('1', Blocks.STONE)
                .input('2', ModBlocks.ARCANE_NEAUSEA_BLOCK)
                .input('3', ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)
                .input('4', ModBlocks.POWER_PRECISION_BLOCK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK, 1)
                .pattern("121")
                .pattern("535")
                .pattern("545")
                .input('1', Blocks.SPORE_BLOSSOM)
                .input('2', ModBlocks.ARCANE_POISION_BLOCK)
                .input('3', ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)
                .input('4', ModBlocks.POWER_PRECISION_BLOCK)
                .input('5', Blocks.SPRUCE_LOG)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CURSED_BRASIER_TRAP_BLOCK, 1)
                .pattern("121")
                .pattern("131")
                .pattern("545")
                .input('1', ModBlocks.SKELETON_SITTING)
                .input('2', ModBlocks.ARCANE_STARVING_BLOCK)
                .input('3', ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)
                .input('4', ModBlocks.POWER_PRECISION_BLOCK)
                .input('5', ModBlocks.EMPTY_BRASIER)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CURSED_BRASIER_TRAP_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CURSED_BLOCK, 1)
                .pattern("626")
                .pattern("453")
                .pattern("111")
                .input('1', Blocks.SCULK_CATALYST)
                .input('2', ModBlocks.ARCANE_DARKNESS_BLOCK)
                .input('3', ModBlocks.ARCANE_WEAKNESS_BLOCK)
                .input('4', ModBlocks.ARCANE_MINING_FATIGUE_BLOCK)
                .input('5', ModBlocks.POWER_PRECISION_BLOCK)
                .input('6', Blocks.SCULK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CURSED_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TELEPORT_TRAP_ITEM, 1)
                .pattern("313")
                .pattern("121")
                .pattern("313")
                .input('1', Blocks.OBSIDIAN)
                .input('2', ModBlocks.POWER_PRECISION_BLOCK)
                .input('3', Blocks.SCULK)
                .criterion("has_power_precision_block", conditionsFromItem(ModBlocks.POWER_PRECISION_BLOCK))
                .offerTo(exporter);


        for (DyeColor color : DyeColor.values()) {

            Block concrete = ModBlocks.COLOR_TO_CONCRETE.get(color);
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COLOR_TO_COBBLED_CONCRETE.get(color), 8)
                    .pattern("CCC")
                    .pattern("CSC")
                    .pattern("CCC")
                    .input('C', concrete)
                    .input('S', Blocks.COBBLESTONE)
                    .criterion(hasItem(concrete), conditionsFromItem(concrete))
                    .offerTo(exporter);

            Block concretePowder = ModBlocks.COLOR_TO_CONCRETE_POWDER.get(color);
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COLOR_TO_COBBLED_CONCRETE_POWDER.get(color), 8)
                    .pattern("CCC")
                    .pattern("CSC")
                    .pattern("CCC")
                    .input('C', concretePowder)
                    .input('S', Blocks.COBBLESTONE)
                    .criterion(hasItem(concretePowder), conditionsFromItem(concretePowder))
                    .offerTo(exporter);
        }

// Ice and Snow
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PACKED_ICE_BRICKS, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PACKED_ICE)
                .input('2', Blocks.STONE_BRICKS)
                .criterion("has_packed_ice", conditionsFromItem(Blocks.PACKED_ICE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PACKED_ICE_BRICKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PACKED_ICE_TILES, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PACKED_ICE)
                .input('2', Blocks.BRICKS)
                .criterion("has_packed_ice", conditionsFromItem(Blocks.PACKED_ICE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PACKED_ICE_TILES)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SNOW_BRICKS, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.SNOW_BLOCK)
                .input('2', Blocks.STONE_BRICKS)
                .criterion("has_snow_block", conditionsFromItem(Blocks.SNOW_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SNOW_BRICKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SNOW_TILES, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.SNOW_BLOCK)
                .input('2', Blocks.BRICKS)
                .criterion("has_snow_block", conditionsFromItem(Blocks.SNOW_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SNOW_TILES)));


        ModBlocks.COLOR_TO_FLOWER.forEach((color, flower) -> {
            Item dye = ModItems.COLOR_TO_DYE.get(color);
            offerShapelessRecipe(exporter, dye, flower, "dye_recipes", 4);
            offerShapelessRecipe(exporter, dye, ModBlocks.FLOWER_TO_GLOW_FLOWER.get(flower), "dye_recipes", 4);
            offerShapelessRecipe(exporter, dye, ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.get(flower), "dye_recipes", 4);
            offerShapelessRecipe(exporter, dye, ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower), "dye_recipes", 4);
            offerShapelessRecipe(exporter, dye, ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.get(flower), "dye_recipes", 4);
        });

        // Lava Recipes
        ModItems.COLOR_TO_LAVA_BUCKET.forEach((color, bucketItem) -> {
            Item dye = ModItems.COLOR_TO_DYE.get(color);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, bucketItem)
                    .input(Items.LAVA_BUCKET)
                    .input(Items.BUCKET)
                    .input(dye)
                    .criterion("has_lava_bucket", conditionsFromItem(Items.LAVA_BUCKET))
                    .criterion("has_dye", conditionsFromItem(dye))
                    .offerTo(exporter, "dyeableliquids/" +color + "_lava_bucket");

            SmithingTransformRecipeJsonBuilder.create(
                            Ingredient.ofItems(Items.LAVA_BUCKET),                           // base item
                            Ingredient.ofItems(dye),                         // addition (dye)
                            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),   // template (none)
                            RecipeCategory.MISC,
                            bucketItem
                    )
                    .criterion("has_lava_bucket", conditionsFromItem(Items.LAVA_BUCKET))
                    .criterion("has_dye", conditionsFromItem(dye))
                    .offerTo(exporter, "dyeableliquids/" + color + "_lava_bucket_smithing");
        });

        // Water Recipes
        ModItems.COLOR_TO_WATER_BUCKET.forEach((color, bucketItem) -> {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, bucketItem)
                    .input(Items.WATER_BUCKET)
                    .input(Items.BUCKET)
                    .input(ModItems.COLOR_TO_DYE.get(color))
                    .criterion("has_water_bucket", conditionsFromItem(Items.WATER_BUCKET))
                    .criterion("has_dye", conditionsFromItem(ModItems.COLOR_TO_DYE.get(color)))
                    .offerTo(exporter, "dyeableliquids/" + color + "_water_bucket");

            SmithingTransformRecipeJsonBuilder.create(
                            Ingredient.ofItems(Items.WATER_BUCKET),                          // base item
                            Ingredient.ofItems(ModItems.COLOR_TO_DYE.get(color)),                         // addition (dye)
                            Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),   // template (none)
                            RecipeCategory.MISC,
                            bucketItem
                    )
                    .criterion("has_water_bucket", conditionsFromItem(Items.WATER_BUCKET))
                    .criterion("has_dye", conditionsFromItem(ModItems.COLOR_TO_DYE.get(color)))
                    .offerTo(exporter, "dyeableliquids/" + color + "_water_bucket_smithing");
        });


        ModBlocks.FLOWER_TO_GLOW_FLOWER.forEach((flower, glowFlower) -> registerGlowRecipe(exporter, flower, glowFlower));
        ModBlocks.FLOWER_TO_THORNED_FLOWER.forEach((flower, thornedFlower) -> registerGlowRecipe(exporter, thornedFlower, ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.get(flower)));
        ModBlocks.FLOWER_TO_LUSH_FLOWER.forEach((flower, lushFlower) -> registerGlowRecipe(exporter, lushFlower, ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.get(flower)));
    }

    private void registerGlowRecipe(Consumer<RecipeJsonProvider> exporter, Block baseFlower, Block glowFlower) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, glowFlower.asItem())
                .input(baseFlower.asItem())
                .input(Items.GLOWSTONE_DUST)
                .criterion("has_flower", conditionsFromItem(baseFlower.asItem()))
                .criterion("has_glowstone_dust", conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter);
    }
}