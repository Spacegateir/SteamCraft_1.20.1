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
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    public static void offerReversibleCompactingRecipesWithId(Consumer<RecipeJsonProvider> exporter, RecipeCategory baseCategory, ItemConvertible base,
                                                              RecipeCategory resultCategory, ItemConvertible result, String idSuffix) {

        ShapedRecipeJsonBuilder.create(resultCategory, result)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', base)
                .criterion("has_" + Registries.ITEM.getId(base.asItem()).getPath(), conditionsFromItem(base))
                .offerTo(exporter, new Identifier("steamcraft", Registries.ITEM.getId(result.asItem()).getPath() + "_from_" + idSuffix));

        ShapelessRecipeJsonBuilder.create(baseCategory, base, 9)
                .input(result)
                .criterion("has_" + Registries.ITEM.getId(result.asItem()).getPath(), conditionsFromItem(result))
                .offerTo(exporter, new Identifier("steamcraft", Registries.ITEM.getId(base.asItem()).getPath() + "_from_" + idSuffix));
    }

    public static void offerReversible2x2CompactingRecipesWithId(Consumer<RecipeJsonProvider> exporter, RecipeCategory baseCategory, ItemConvertible base,
                                                              RecipeCategory resultCategory, ItemConvertible result, String idSuffix) {

        ShapedRecipeJsonBuilder.create(resultCategory, result)
                .pattern("##")
                .pattern("##")
                .input('#', base)
                .criterion("has_" + Registries.ITEM.getId(base.asItem()).getPath(), conditionsFromItem(base))
                .offerTo(exporter, new Identifier("steamcraft", Registries.ITEM.getId(result.asItem()).getPath() + "_from_" + idSuffix));

        ShapelessRecipeJsonBuilder.create(baseCategory, base, 4)
                .input(result)
                .criterion("has_" + Registries.ITEM.getId(result.asItem()).getPath(), conditionsFromItem(result))
                .offerTo(exporter, new Identifier("steamcraft", Registries.ITEM.getId(base.asItem()).getPath() + "_from_" + idSuffix));
    }

    public static void offerStairRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible result, ItemConvertible base) {
        ShapedRecipeJsonBuilder.create(category, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', base)
                .criterion("has_" + Registries.ITEM.getId(base.asItem()).getPath(), conditionsFromItem(base))
                .offerTo(exporter, new Identifier("steamcraft", Registries.ITEM.getId(result.asItem()).getPath() + "_from_" + Registries.ITEM.getId(base.asItem()).getPath()));
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
    private void registerFlowerToSeedRecipes(Consumer<RecipeJsonProvider> exporter) {
        String[] baseNames = {
                "carnation", "violet", "iris", "primrose", "daffodil", "delphinium", "dahlia", "hydrangea",
                "midnight_mystic", "hawthorn", "bonsai", "spiderlily", "larkspur", "agapanthus",
                "blue_cosmos", "snow_drop"
        };

        for (String name : baseNames) {
            registerSingleFlowerToSeed(exporter, name, "", ""); // Normal
            registerSingleFlowerToSeed(exporter, name, "lush_", "LUSH_"); // Lush
            registerSingleFlowerToSeed(exporter, name, "thorned_", "THORNED_"); // Thorned
        }
    }

    private void registerSingleFlowerToSeed(Consumer<RecipeJsonProvider> exporter, String baseName, String prefix, String fieldPrefix) {
        String path = prefix + baseName + "_to_seed";
        Identifier id = new Identifier(Steamcraft.MOD_ID, path);

        Item seed = ModItems.getField(fieldPrefix.toUpperCase() + baseName.toUpperCase() + "_SEED");
        Item flower = ModItems.getField(fieldPrefix.toUpperCase() + baseName.toUpperCase() + "_FLOWER_ITEM");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, seed)
                .input(flower)
                .criterion("has_flower", conditionsFromItem(flower))
                .offerTo(exporter, id);
    }



    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        registerFlowerToSeedRecipes(exporter);
        registerMouldRecipes(exporter);
        registerFoolsGoldSmithingRecipes(exporter);


        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModItems.SILVER_INGOT, "silver_nugget_ingot");
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.SILVER_INGOT, RecipeCategory.MISC, ModBlocks.SILVER_BLOCK, "silver_ingot_block");
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.RAW_SILVER, RecipeCategory.MISC, ModItems.RAW_SILVER_ITEM, "raw_silver_block");
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_SCRAP, RecipeCategory.MISC, ModItems.FOOLS_GOLD_RAW, "scrap");
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_RAW, RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_RAW_BLOCK, "block");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT, RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_BLOCK);
        offerReversibleCompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.DIVINITITE_ALLOY_INGOT, RecipeCategory.MISC, ModBlocks.DIVINITITE_ALLOY_BLOCK, "block");

        offerReversible2x2CompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.ANCIENT_MOIST_CLAY, RecipeCategory.MISC, ModBlocks.ANCIENT_MOIST_CLAY_BLOCK, "moist_clay");
        offerReversible2x2CompactingRecipesWithId(exporter, RecipeCategory.MISC, ModItems.ANCIENT_CLAY, RecipeCategory.MISC, ModBlocks.ANCIENT_CLAY_BLOCK, "dry_clay");

        offerSmelting(exporter, List.of(ModItems.FOOLS_GOLD_RAW), RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT,
                0.15f, 200, "fools_gold");
        offerBlasting(exporter, List.of(ModItems.FOOLS_GOLD_RAW), RecipeCategory.MISC, ModItems.FOOLS_GOLD_INGOT,
                0.15f, 100, "fools_gold");
        offerSmelting(exporter, List.of(ModItems.RAW_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT,
                0.15f, 200, "silver");
        offerBlasting(exporter, List.of(ModItems.RAW_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT,
                0.15f, 100, "silver");

        offerSmelting(exporter, List.of(ModBlocks.FOOLS_GOLD_RAW_BLOCK), RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_BLOCK,
                0.15f, 200, "fools_gold_block");
        offerBlasting(exporter, List.of(ModBlocks.FOOLS_GOLD_RAW_BLOCK), RecipeCategory.MISC, ModBlocks.FOOLS_GOLD_BLOCK,
                0.15f, 100, "fools_gold_block");
        offerSmelting(exporter, List.of(ModBlocks.RAW_SILVER_BLOCK), RecipeCategory.MISC, ModBlocks.SILVER_BLOCK,
                0.15f, 200, "silver_block");
        offerBlasting(exporter, List.of(ModBlocks.RAW_SILVER_BLOCK), RecipeCategory.MISC, ModBlocks.SILVER_BLOCK,
                0.15f, 100, "silver_block");

        offerSmelting(exporter, List.of(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK), RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_BLOCK,
                0.15f, 200, "glimmerstone_block");
        offerBlasting(exporter, List.of(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK), RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_BLOCK,
                0.15f, 100, "glimmerstone_block");

        offerSmelting(exporter, List.of(ModBlocks.ANCIENT_MOIST_CLAY_BLOCK), RecipeCategory.MISC, ModBlocks.ANCIENT_CLAY_BLOCK,
                0.15f, 200, "clay_block");
        offerBlasting(exporter, List.of(ModBlocks.ANCIENT_MOIST_CLAY_BLOCK), RecipeCategory.MISC, ModBlocks.ANCIENT_CLAY_BLOCK,
                0.15f, 100, "clay_block");

        offerSmelting(exporter, List.of(ModBlocks.ANCIENT_SAND_BLOCK), RecipeCategory.MISC, Blocks.GLASS,
                0.15f, 200, "sand_block");
        offerBlasting(exporter, List.of(ModBlocks.ANCIENT_SAND_BLOCK), RecipeCategory.MISC, Blocks.GLASS,
                0.15f, 100, "sand_block");

        offerSmelting(exporter, List.of(ModItems.ANCIENT_MOIST_CLAY), RecipeCategory.MISC, ModItems.ANCIENT_CLAY,
                0.15f, 200, "clay");
        offerBlasting(exporter, List.of(ModItems.ANCIENT_MOIST_CLAY), RecipeCategory.MISC, ModItems.ANCIENT_CLAY,
                0.15f, 100, "clay");

        offerBlasting(exporter, List.of(ModBlocks.ANCIENT_MUD_BLOCK), RecipeCategory.MISC, ModBlocks.ANCIENT_CLAY_BLOCK,
                0.15f, 200, "mud_block");
        offerSmelting(exporter, List.of(ModBlocks.ANCIENT_MUD_BLOCK), RecipeCategory.MISC, Blocks.CLAY,
                0.15f, 200, "mud_block");
        offerSmelting(exporter, List.of(ModBlocks.ANCIENT_SILT_BLOCK), RecipeCategory.MISC, Blocks.CALCITE,
                0.15f, 200, "silt_block");
        offerSmelting(exporter, List.of(ModBlocks.ANCIENT_LOAM_BLOCK), RecipeCategory.MISC, Blocks.DIRT,
                0.15f, 200, "loam_block");

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

//Stairs

        offerStairRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModItems.GLIMMERSTONE_ITEM);
        offerStairRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModItems.GLIMMERSTONE_COBBLESTONE_ITEM);
        offerStairRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModItems.GLIMMERSTONE_BRICKS_ITEM);

//Slabs

        offerSlabRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModItems.GLIMMERSTONE_ITEM);
        offerSlabRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModItems.GLIMMERSTONE_COBBLESTONE_ITEM);
        offerSlabRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModItems.GLIMMERSTONE_BRICKS_ITEM);

//Walls

        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModItems.GLIMMERSTONE_ITEM);
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModItems.GLIMMERSTONE_COBBLESTONE_ITEM);
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModItems.GLIMMERSTONE_BRICKS_ITEM);

//smoking

        offerMultipleOptions(exporter, RecipeSerializer.SMOKING, List.of(ModBlocks.ANCIENT_LOAM_BLOCK),
                RecipeCategory.BUILDING_BLOCKS,Blocks.COARSE_DIRT,0.1F,100,"smoked_blocks","_from_smoking"
        );
        offerMultipleOptions(exporter, RecipeSerializer.SMOKING, List.of(ModBlocks.ANCIENT_MUD_BLOCK),
                RecipeCategory.BUILDING_BLOCKS,ModBlocks.ANCIENT_CLAY_BLOCK,0.1F,100,"smoked_blocks","_from_smoking"
        );


// stone cutting

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_STAIR_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_SLAB_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModBlocks.GLIMMERSTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_WALL_BLOCK, ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BLOCK, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLIMMERSTONE_BRICKS_BLOCK, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK);







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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TROWEL)
                .pattern("  1")
                .pattern(" 1 ")
                .pattern("2  ")
                .input('1', Items.STICK)
                .input('2', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TROWEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MORTAR_AND_PESTLE)
                .pattern("  1")
                .pattern("2 2")
                .pattern(" 2 ")
                .input('1', Items.FLINT)
                .input('2', Items.STONE)
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MORTAR_AND_PESTLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TRAP_CONCEALER)
                .pattern(" N ")
                .pattern("N1N")
                .pattern("IGI")
                .input('G', Blocks.GOLD_BLOCK)
                .input('N', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('I', Items.COPPER_INGOT)
                .input('1', ModItems.PATTERN_RECOMPILER)
                .criterion(hasItem(ModItems.DIVINITITE_ALLOY_INGOT), conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TRAP_CONCEALER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINE_IMBUMENT_GEM, 1)
                .pattern("213")
                .pattern("415")
                .pattern("617")
                .input('1', ModItems.FOOLS_GOLD_INGOT)
                .input('2', ModItems.FERRITE_HEARTSTONE)
                .input('3', ModItems.AETHERIUM_PRISM)
                .input('4', ModItems.AQUARION_SHARD)
                .input('5', ModItems.PYROCITE_CORE)
                .input('6', ModItems.LUMINITE_SPARK)
                .input('7', ModItems.OBSCURIUM_CRYSTAL)
                .criterion(hasItem(ModItems.FOOLS_GOLD_INGOT), conditionsFromItem(ModItems.FOOLS_GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIVINE_IMBUMENT_GEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SMOKE_BLOCK_ITEM, 16)
                .pattern("222")
                .pattern("212")
                .pattern("222")
                .input('1', ModItems.CORE_OF_CHANGING)
                .input('2', Items.CAMPFIRE)
                .criterion(hasItem(ModItems.CORE_OF_CHANGING), conditionsFromItem(ModItems.CORE_OF_CHANGING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SMOKE_BLOCK_ITEM)));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_HELMET)
                .pattern("323")
                .pattern("313")
                .input('1', ModItems.FOOLS_GOLD_HELMET)
                .input('2', ModItems.LUMINITE_SPARK)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_HELMET), conditionsFromItem(ModItems.FOOLS_GOLD_HELMET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_HELMET)));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_LEGGINGS)
                .pattern("444")
                .pattern("213")
                .pattern("4 4")
                .input('1', ModItems.FOOLS_GOLD_LEGGINGS)
                .input('2', ModItems.FERRITE_HEARTSTONE)
                .input('3', ModItems.AETHERIUM_PRISM)
                .input('4', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_LEGGINGS), conditionsFromItem(ModItems.FOOLS_GOLD_LEGGINGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_BOOTS)
                .pattern(" 2 ")
                .pattern("313")
                .pattern("3 3")
                .input('1', ModItems.FOOLS_GOLD_BOOTS)
                .input('2', ModItems.WINGED_SANDALS)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_BOOTS), conditionsFromItem(ModItems.FOOLS_GOLD_BOOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_BOOTS)));

// Celestial Gearforged Tools

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_PICKAXE)
                .pattern("333")
                .pattern(" 12")
                .pattern(" 4 ")
                .input('1', ModItems.FOOLS_GOLD_PICKAXE)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_PICKAXE), conditionsFromItem(ModItems.FOOLS_GOLD_PICKAXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_AXE)
                .pattern("33 ")
                .pattern("312")
                .pattern(" 4 ")
                .input('1', ModItems.FOOLS_GOLD_AXE)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_AXE), conditionsFromItem(ModItems.FOOLS_GOLD_AXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_AXE) + "celestial_gearforged_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_SHOVEL)
                .pattern(" 3 ")
                .pattern(" 12")
                .pattern(" 4 ")
                .input('1', ModItems.FOOLS_GOLD_SHOVEL)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_SHOVEL), conditionsFromItem(ModItems.FOOLS_GOLD_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_SHOVEL) + "celestial_gearforged_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_HOE)
                .pattern("33 ")
                .pattern(" 12")
                .pattern(" 4 ")
                .input('1', ModItems.FOOLS_GOLD_HOE)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_HOE), conditionsFromItem(ModItems.FOOLS_GOLD_HOE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_HOE) + "celestial_gearforged_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_SWORD_SLIM)
                .pattern(" 3 ")
                .pattern(" 34")
                .pattern("412")
                .input('1', ModItems.FOOLS_GOLD_SWORD)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_SWORD), conditionsFromItem(ModItems.FOOLS_GOLD_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_SWORD_SLIM) + "celestial_gearforged_sword"));

        //Sword smithing template to god sword
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.CELESTIAL_GEARFORGED_SWORD_SLIM),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_LAVA_BUCKET),
                        Ingredient.ofItems(ModItems.DIVINE_IMBUMENT_GEM),
                        RecipeCategory.MISC,
                        ModItems.CELESTIAL_GEARFORGED_SWORD
                )
                .criterion("has_celestial_gearforged_sword_slim", conditionsFromItem(ModItems.CELESTIAL_GEARFORGED_SWORD_SLIM))
                .criterion("has_divinitie_alloy_lava_bucket", conditionsFromItem(ModItems.DIVINITITE_ALLOY_LAVA_BUCKET))
                .criterion("has_divine_imbument_gem", conditionsFromItem(ModItems.DIVINE_IMBUMENT_GEM))
                .offerTo(exporter, new Identifier("steamcraft", "celestial_gearforged_sword_smithing"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_SHEARS)
                .pattern("3 3")
                .pattern("323")
                .pattern("414")
                .input('1', ModItems.FOOLS_GOLD_SHEARS)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_SHEARS), conditionsFromItem(ModItems.FOOLS_GOLD_SHEARS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_SHEARS) + "celestial_gearforged_shears"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CELESTIAL_GEARFORGED_SHIELD)
                .pattern("3 4")
                .pattern("313")
                .pattern("423")
                .input('1', ModItems.FOOLS_GOLD_SHIELD)
                .input('2', ModItems.DIVINE_IMBUMENT_GEM)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', ModItems.FOOLS_GOLD_INGOT)
                .criterion(hasItem(ModItems.FOOLS_GOLD_SHIELD), conditionsFromItem(ModItems.FOOLS_GOLD_SHIELD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CELESTIAL_GEARFORGED_SHIELD) + "celestial_gearforged_shield"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINITITE_ALLOY_INGOT)
                .pattern("424")
                .pattern("313")
                .pattern("424")
                .input('1', ModItems.FOOLS_GOLD_INGOT)
                .input('2', Items.NETHERITE_INGOT)
                .input('3', Items.NETHER_STAR)
                .input('4', Blocks.GOLD_BLOCK)
                .criterion(hasItem(ModItems.FOOLS_GOLD_INGOT), conditionsFromItem(ModItems.FOOLS_GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIVINITITE_ALLOY_INGOT) + "divinitite_alloy"));

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
                .offerTo(exporter, new Identifier(getRecipeName(Items.TUFF) + "cobbled_deepslate"));

//Rooted Dirt
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ROOTED_DIRT, 1)
                .pattern("12")
                .input('1', Items.DIRT)
                .input('2', Items.HANGING_ROOTS)
                .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter, new Identifier(getRecipeName(Items.ROOTED_DIRT) + "rooted_dirt"));

//Mud
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MUD, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Items.DIRT)
                .input('2', Items.WATER_BUCKET)
                .criterion(hasItem(Items.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter, new Identifier(getRecipeName(Items.MUD) + "mud"));

//Gilded Blackstone
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GILDED_BLACKSTONE, 2)
                .pattern("12")
                .pattern("21")
                .input('1', Items.BLACKSTONE)
                .input('2', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(Items.GILDED_BLACKSTONE) + "gilded_blackstone"));

//Crying Obsidian
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CRYING_OBSIDIAN, 2)
                .pattern("12")
                .pattern("21")
                .input('1', Items.OBSIDIAN)
                .input('2', Items.ENDER_PEARL)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(Items.CRYING_OBSIDIAN) + "crying_obsidian"));

//Brown Mushroom
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BROWN_MUSHROOM_BLOCK, 1)
                .pattern("11")
                .pattern("11")
                .input('1', Items.BROWN_MUSHROOM)
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .offerTo(exporter, new Identifier(getRecipeName(Items.BROWN_MUSHROOM_BLOCK) + "brown_mushroom_block"));

//Brown Mushroom Stem
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MUSHROOM_STEM, 2)
                .pattern("1")
                .pattern("1")
                .input('1', Items.BROWN_MUSHROOM_BLOCK)
                .criterion(hasItem(Items.BROWN_MUSHROOM_BLOCK), conditionsFromItem(Items.BROWN_MUSHROOM_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.MUSHROOM_STEM) + "brown_mushroom_stem"));

//Red Mushroom
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RED_MUSHROOM_BLOCK, 1)
                .pattern("11")
                .pattern("11")
                .input('1', Items.RED_MUSHROOM)
                .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Items.RED_MUSHROOM))
                .offerTo(exporter, new Identifier(getRecipeName(Items.RED_MUSHROOM_BLOCK) + "red_mushroom_block"));

//Red Mushroom Stem
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MUSHROOM_STEM, 2)
                .pattern("1")
                .pattern("1")
                .input('1', Items.RED_MUSHROOM_BLOCK)
                .criterion(hasItem(Items.RED_MUSHROOM_BLOCK), conditionsFromItem(Items.RED_MUSHROOM_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(Items.MUSHROOM_STEM) + "red_mushroom_stem"));

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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CORE_OF_CHANGING)));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCANE_CONDUIT_POWER_BLOCK, 1)
                .pattern("111")
                .pattern("232")
                .pattern("424")
                .input('1', Items.CONDUIT)
                .input('2', ModItems.CORE_OF_CHANGING)
                .input('3', ModItems.DIVINITITE_ALLOY_INGOT)
                .input('4', Blocks.COPPER_BLOCK)
                .criterion("has_divinitite_alloy_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCANE_CONDUIT_POWER_BLOCK)));

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
                .input('2', ModBlocks.ARCANE_CONDUIT_POWER_BLOCK)
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
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TELEPORT_TRAP_ITEM)));


// White Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_WHITE_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.WHITE_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_white_concrete", conditionsFromItem(Blocks.WHITE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_WHITE_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_WHITE_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.WHITE_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_white_concrete_powder", conditionsFromItem(Blocks.WHITE_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_WHITE_CONCRETE_POWDER)));

// Light Gray Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIGHT_GRAY_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_light_gray_concrete", conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIGHT_GRAY_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_light_gray_concrete_powder", conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER)));

// Gray Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_GRAY_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.GRAY_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_gray_concrete", conditionsFromItem(Blocks.GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_GRAY_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_GRAY_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.GRAY_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_gray_concrete_powder", conditionsFromItem(Blocks.GRAY_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_GRAY_CONCRETE_POWDER)));

// Black Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BLACK_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BLACK_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_black_concrete", conditionsFromItem(Blocks.BLACK_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BLACK_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BLACK_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BLACK_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_black_concrete_powder", conditionsFromItem(Blocks.BLACK_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BLACK_CONCRETE_POWDER)));

// Brown Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BROWN_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BROWN_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_brown_concrete", conditionsFromItem(Blocks.BROWN_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BROWN_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BROWN_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BROWN_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_brown_concrete_powder", conditionsFromItem(Blocks.BROWN_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BROWN_CONCRETE_POWDER)));

// Red Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_RED_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.RED_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_red_concrete", conditionsFromItem(Blocks.RED_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_RED_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_RED_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.RED_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_red_concrete_powder", conditionsFromItem(Blocks.RED_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_RED_CONCRETE_POWDER)));

// Orange Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_ORANGE_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.ORANGE_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_orange_concrete", conditionsFromItem(Blocks.ORANGE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_ORANGE_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.ORANGE_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_orange_concrete_powder", conditionsFromItem(Blocks.ORANGE_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER)));

// Yellow Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_YELLOW_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.YELLOW_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_yellow_concrete", conditionsFromItem(Blocks.YELLOW_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_YELLOW_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.YELLOW_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_yellow_concrete_powder", conditionsFromItem(Blocks.YELLOW_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER)));

// Lime Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIME_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIME_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_lime_concrete", conditionsFromItem(Blocks.LIME_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIME_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIME_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIME_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_lime_concrete_powder", conditionsFromItem(Blocks.LIME_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIME_CONCRETE_POWDER)));

// Green Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_GREEN_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.GREEN_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_green_concrete", conditionsFromItem(Blocks.GREEN_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_GREEN_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_GREEN_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.GREEN_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_green_concrete_powder", conditionsFromItem(Blocks.GREEN_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_GREEN_CONCRETE_POWDER)));

// Cyan Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_CYAN_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.CYAN_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_cyan_concrete", conditionsFromItem(Blocks.CYAN_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_CYAN_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_CYAN_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.CYAN_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_cyan_concrete_powder", conditionsFromItem(Blocks.CYAN_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_CYAN_CONCRETE_POWDER)));

// Light Blue Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIGHT_BLUE_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_light_blue_concrete", conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.LIGHT_BLUE_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_light_blue_concrete_powder", conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER)));

// Blue Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BLUE_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BLUE_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_blue_concrete", conditionsFromItem(Blocks.BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BLUE_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_BLUE_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.BLUE_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_blue_concrete_powder", conditionsFromItem(Blocks.BLUE_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_BLUE_CONCRETE_POWDER)));

// Purple Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_PURPLE_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PURPLE_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_purple_concrete", conditionsFromItem(Blocks.PURPLE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_PURPLE_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PURPLE_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_purple_concrete_powder", conditionsFromItem(Blocks.PURPLE_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER)));

// Magenta Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_MAGENTA_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.MAGENTA_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_magenta_concrete", conditionsFromItem(Blocks.MAGENTA_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_MAGENTA_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.MAGENTA_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_magenta_concrete_powder", conditionsFromItem(Blocks.MAGENTA_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER)));

// Pink Concrete
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_PINK_CONCRETE, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PINK_CONCRETE)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_magenta_concrete", conditionsFromItem(Blocks.MAGENTA_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_PINK_CONCRETE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COBBLED_PINK_CONCRETE_POWDER, 8)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', Blocks.PINK_CONCRETE_POWDER)
                .input('2', Blocks.COBBLESTONE)
                .criterion("has_pink_concrete_powder", conditionsFromItem(Blocks.PINK_CONCRETE_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COBBLED_PINK_CONCRETE_POWDER)));

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.GLIMMERSTONE_BRICKS_ITEM, 4)
                .input(ModItems.GLIMMERSTONE_ITEM, 4)
                .criterion("has_glimmerstone", conditionsFromItem(ModItems.GLIMMERSTONE_ITEM))
                .offerTo(exporter, new Identifier("steamcraft", "glimmerstone_to_glimmerstone_brick"));

//Pillar / Engraved

        // Glimmerstone Pillar
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_PILLAR_BLOCK, 1)
                .pattern("I")
                .pattern("I")
                .input('I', ModItems.GLIMMERSTONE_SLAB_ITEM)
                .criterion("has_slab", conditionsFromItem(ModItems.GLIMMERSTONE_SLAB_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GLIMMERSTONE_PILLAR_BLOCK)));

        // Glimmerstone Engraved
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK, 1)
                .pattern("I")
                .pattern("I")
                .input('I', ModItems.GLIMMERSTONE_BRICKS_SLAB_ITEM)
                .criterion("has_slab", conditionsFromItem(ModItems.GLIMMERSTONE_BRICKS_SLAB_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GAMEBOARD_ITEM)
                .pattern("B W")
                .pattern("LLL")
                .input('B', Items.SMOOTH_BASALT)
                .input('W', Items.SMOOTH_QUARTZ)
                .input('L', ItemTags.LOGS)
                .criterion("has_smooth_basalt", conditionsFromItem(Items.SMOOTH_BASALT))
                .criterion("has_smooth_quartz", conditionsFromItem(Items.SMOOTH_QUARTZ))
                .criterion("has_logs", conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GAMEBOARD_ITEM) + "game_board"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PAN)
                .pattern("II ")
                .pattern("II ")
                .pattern("  L")
                .input('I', Items.IRON_INGOT)
                .input('L', ItemTags.LOGS)
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .criterion("has_logs", conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PAN) + "pan"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POT)
                .pattern("   ")
                .pattern("LIL")
                .pattern(" I ")
                .input('I', Items.IRON_INGOT)
                .input('L', ItemTags.LOGS)
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .criterion("has_logs", conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POT) + "pot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MEDKIT)
                .pattern("W  ")
                .pattern("IIW")
                .pattern("II ")
                .input('I', Items.IRON_INGOT)
                .input('W', ItemTags.WOOL)
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .criterion("has_wool", conditionsFromTag(ItemTags.WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MEDKIT) + "medkit"));










































        // Lava Bucket Outputs
        Map<String, Item> dyeToLavaBucket = Map.ofEntries(
                entry("white", ModItems.WHITE_LAVA_BUCKET),
                entry("orange", ModItems.ORANGE_LAVA_BUCKET),
                entry("magenta", ModItems.MAGENTA_LAVA_BUCKET),
                entry("light_blue", ModItems.LIGHT_BLUE_LAVA_BUCKET),
                entry("yellow", ModItems.YELLOW_LAVA_BUCKET),
                entry("lime", ModItems.LIME_LAVA_BUCKET),
                entry("pink", ModItems.PINK_LAVA_BUCKET),
                entry("gray", ModItems.GRAY_LAVA_BUCKET),
                entry("light_gray", ModItems.LIGHT_GRAY_LAVA_BUCKET),
                entry("cyan", ModItems.CYAN_LAVA_BUCKET),
                entry("purple", ModItems.PURPLE_LAVA_BUCKET),
                entry("blue", ModItems.BLUE_LAVA_BUCKET),
                entry("brown", ModItems.BROWN_LAVA_BUCKET),
                entry("green", ModItems.GREEN_LAVA_BUCKET),
                entry("red", ModItems.RED_LAVA_BUCKET),
                entry("black", ModItems.BLACK_LAVA_BUCKET)
        );

        // Water Bucket Outputs
        Map<String, Item> dyeToWaterBucket = Map.ofEntries(
                entry("white", ModItems.WHITE_WATER_BUCKET),
                entry("orange", ModItems.ORANGE_WATER_BUCKET),
                entry("magenta", ModItems.MAGENTA_WATER_BUCKET),
                entry("light_blue", ModItems.LIGHT_BLUE_WATER_BUCKET),
                entry("yellow", ModItems.YELLOW_WATER_BUCKET),
                entry("lime", ModItems.LIME_WATER_BUCKET),
                entry("pink", ModItems.PINK_WATER_BUCKET),
                entry("gray", ModItems.GRAY_WATER_BUCKET),
                entry("light_gray", ModItems.LIGHT_GRAY_WATER_BUCKET),
                entry("cyan", ModItems.CYAN_WATER_BUCKET),
                entry("purple", ModItems.PURPLE_WATER_BUCKET),
                entry("blue", ModItems.BLUE_WATER_BUCKET),
                entry("brown", ModItems.BROWN_WATER_BUCKET),
                entry("green", ModItems.GREEN_WATER_BUCKET),
                entry("red", ModItems.RED_WATER_BUCKET),
                entry("black", ModItems.BLACK_WATER_BUCKET)
        );

        // Dye Inputs
        Map<String, Item> dyeItems = Map.ofEntries(
                entry("white", Items.WHITE_DYE),
                entry("orange", Items.ORANGE_DYE),
                entry("magenta", Items.MAGENTA_DYE),
                entry("light_blue", Items.LIGHT_BLUE_DYE),
                entry("yellow", Items.YELLOW_DYE),
                entry("lime", Items.LIME_DYE),
                entry("pink", Items.PINK_DYE),
                entry("gray", Items.GRAY_DYE),
                entry("light_gray", Items.LIGHT_GRAY_DYE),
                entry("cyan", Items.CYAN_DYE),
                entry("purple", Items.PURPLE_DYE),
                entry("blue", Items.BLUE_DYE),
                entry("brown", Items.BROWN_DYE),
                entry("green", Items.GREEN_DYE),
                entry("red", Items.RED_DYE),
                entry("black", Items.BLACK_DYE)
        );

        //Flowers
        Map<Item, String> dyeToFlowerMap = Map.ofEntries(
                entry(Items.LIGHT_BLUE_DYE, "BLUE_COSMOS"),
                entry(Items.WHITE_DYE, "SNOW_DROP"),
                entry(Items.MAGENTA_DYE, "CARNATION"),
                entry(Items.PURPLE_DYE, "VIOLET"),
                entry(Items.PINK_DYE, "IRIS"),
                entry(Items.YELLOW_DYE, "PRIMROSE"),
                entry(Items.ORANGE_DYE, "DAFFODIL"),
                entry(Items.BLUE_DYE, "DELPHINIUM"),
                entry(Items.BROWN_DYE, "DAHLIA"),
                entry(Items.LIME_DYE, "HYDRANGEA"),
                entry(Items.BLACK_DYE, "MIDNIGHT_MYSTIC"),
                entry(Items.LIGHT_GRAY_DYE, "HAWTHORN"),
                entry(Items.GREEN_DYE, "BONSAI"),
                entry(Items.RED_DYE, "SPIDERLILY"),
                entry(Items.CYAN_DYE, "LARKSPUR"),
                entry(Items.GRAY_DYE, "AGAPANTHUS")
        );

        String[] prefixes = {
                "",                  // Normal
                "GLOW_",
                "THORNED_",
                "GLOW_THORNED_",
                "LUSH_",
                "GLOW_LUSH_"
        };

        for (String prefix : prefixes) {
            for (Map.Entry<Item, String> dyeEntry : dyeToFlowerMap.entrySet()) {
                Item dye = dyeEntry.getKey();
                String flowerName = dyeEntry.getValue();

                try {
                    Block flowerBlock = (Block) ModBlocks.class
                            .getField(prefix + flowerName + "_FLOWER_BLOCK")
                            .get(null);

                    for (int i = 1; i <= 8; i++) {
                        ShapelessRecipeJsonBuilder builder = ShapelessRecipeJsonBuilder
                                .create(RecipeCategory.MISC, dye, 4 * i) // 4 dye per flower
                                .input(ModItems.MORTAR_AND_PESTLE);     // Not consumed if remainder is set

                        for (int j = 0; j < i; j++) {
                            builder.input(flowerBlock.asItem());       // Add 'i' flowers
                        }

                        builder.criterion("has_mortar_and_pestle",
                                        RecipeProvider.conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                                .criterion("has_flower",
                                        RecipeProvider.conditionsFromItem(flowerBlock.asItem()))
                                .offerTo(exporter, new Identifier("steamcraft",
                                        "mortar_and_" + prefix.toLowerCase() +
                                                flowerName.toLowerCase() + "_to_" +
                                                Registries.ITEM.getId(dye).getPath() + "_x" + i));
                    }

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    System.err.println("Missing field: " + prefix + flowerName + "_FLOWER_BLOCK");
                }
            }
        }

        // Lava Bucket Smithing Recipes
        dyeToLavaBucket.forEach((color, bucketItem) -> SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BUCKET_MOULD),   // template (none)
                        Ingredient.ofItems(dyeItems.get(color)),                         // addition (dye)
                        Ingredient.ofItems(Items.LAVA_BUCKET),                           // base item
                        RecipeCategory.MISC,
                        bucketItem
                )
                .criterion("has_lava_bucket", conditionsFromItem(Items.LAVA_BUCKET))
                .criterion("has_dye", conditionsFromItem(dyeItems.get(color)))
                .offerTo(exporter, new Identifier("dyeableliquids", color + "_lava_bucket_smithing")));

        // Water Bucket Smithing Recipes
        dyeToWaterBucket.forEach((color, bucketItem) -> SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BUCKET_MOULD),   // template (none)
                        Ingredient.ofItems(dyeItems.get(color)),                         // addition (dye)
                        Ingredient.ofItems(Items.WATER_BUCKET),                          // base item
                        RecipeCategory.MISC,
                        bucketItem
                )
                .criterion("has_water_bucket", conditionsFromItem(Items.WATER_BUCKET))
                .criterion("has_dye", conditionsFromItem(dyeItems.get(color)))
                .offerTo(exporter, new Identifier("dyeableliquids", color + "_water_bucket_smithing")));

        //Fools Gold smithing template to liquid
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BUCKET_MOULD),
                        Ingredient.ofItems(ModBlocks.FOOLS_GOLD_BLOCK.asItem()),
                        Ingredient.ofItems(Items.LAVA_BUCKET),
                        RecipeCategory.MISC,
                        ModItems.FOOLS_GOLD_LAVA_BUCKET
                )
                .criterion("has_bucket_mould", conditionsFromItem(ModItems.BUCKET_MOULD))
                .criterion("has_fools_gold_block", conditionsFromItem(ModBlocks.FOOLS_GOLD_BLOCK.asItem()))
                .criterion("has_lava_bucket", conditionsFromItem(Items.LAVA_BUCKET))
                .offerTo(exporter, new Identifier("steamcraft", "fools_gold_lava_bucket_smithing"));

        //Divinitite Alloy smithing template to liquid
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BUCKET_MOULD),
                        Ingredient.ofItems(ModBlocks.DIVINITITE_ALLOY_BLOCK.asItem()),
                        Ingredient.ofItems(Items.LAVA_BUCKET),
                        RecipeCategory.MISC,
                        ModItems.DIVINITITE_ALLOY_LAVA_BUCKET
                )
                .criterion("has_bucket_mould", conditionsFromItem(ModItems.BUCKET_MOULD))
                .criterion("has_divinitite_alloy_block", conditionsFromItem(ModBlocks.DIVINITITE_ALLOY_BLOCK.asItem()))
                .criterion("has_lava_bucket", conditionsFromItem(Items.LAVA_BUCKET))
                .offerTo(exporter, new Identifier("steamcraft", "divinitite_alloy_lava_bucket_smithing"));


        registerGlowRecipe(exporter, ModBlocks.SNOW_DROP_FLOWER_BLOCK, ModBlocks.GLOW_SNOW_DROP_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.CARNATION_FLOWER_BLOCK, ModBlocks.GLOW_CARNATION_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.VIOLET_FLOWER_BLOCK, ModBlocks.GLOW_VIOLET_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.IRIS_FLOWER_BLOCK, ModBlocks.GLOW_IRIS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.PRIMROSE_FLOWER_BLOCK, ModBlocks.GLOW_PRIMROSE_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.DAFFODIL_FLOWER_BLOCK, ModBlocks.GLOW_DAFFODIL_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.DELPHINIUM_FLOWER_BLOCK, ModBlocks.GLOW_DELPHINIUM_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.DAHLIA_FLOWER_BLOCK, ModBlocks.GLOW_DAHLIA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.HYDRANGEA_FLOWER_BLOCK, ModBlocks.GLOW_HYDRANGEA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.HAWTHORN_FLOWER_BLOCK, ModBlocks.GLOW_HAWTHORN_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.BONSAI_FLOWER_BLOCK, ModBlocks.GLOW_BONSAI_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.SPIDERLILY_FLOWER_BLOCK, ModBlocks.GLOW_SPIDERLILY_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LARKSPUR_FLOWER_BLOCK, ModBlocks.GLOW_LARKSPUR_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.AGAPANTHUS_FLOWER_BLOCK, ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK);

        registerGlowRecipe(exporter, ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_CARNATION_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_CARNATION_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_VIOLET_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_VIOLET_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_IRIS_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_IRIS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_PRIMROSE_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_DAFFODIL_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_DAHLIA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_HAWTHORN_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_BONSAI_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_BONSAI_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_LARKSPUR_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK);

        registerGlowRecipe(exporter, ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_CARNATION_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_CARNATION_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_VIOLET_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_VIOLET_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_IRIS_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_IRIS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_PRIMROSE_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_DAFFODIL_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_DAHLIA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_HAWTHORN_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_BONSAI_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_BONSAI_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_LARKSPUR_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK);
        registerGlowRecipe(exporter, ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK);

    }

    private void registerGlowRecipe(Consumer<RecipeJsonProvider> exporter, Block baseFlower, Block glowFlower) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, glowFlower.asItem())
                .input(baseFlower.asItem())
                .input(Items.GLOWSTONE_DUST)
                .criterion("has_flower", conditionsFromItem(baseFlower.asItem()))
                .criterion("has_glowstone_dust", conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter);
    }

    private void registerMouldRecipes(Consumer<RecipeJsonProvider> exporter) {
        Map<Item, Item> mouldRecipes = Map.ofEntries(
                Map.entry(ModItems.HELMET_MOULD, Items.NETHERITE_HELMET),
                Map.entry(ModItems.CHESTPLATE_MOULD, Items.NETHERITE_CHESTPLATE),
                Map.entry(ModItems.LEGGINGS_MOULD, Items.NETHERITE_LEGGINGS),
                Map.entry(ModItems.BOOTS_MOULD, Items.NETHERITE_BOOTS),
                Map.entry(ModItems.BUCKET_MOULD, Items.BUCKET),
                Map.entry(ModItems.PICKAXE_MOULD, Items.NETHERITE_PICKAXE),
                Map.entry(ModItems.AXE_MOULD, Items.NETHERITE_AXE),
                Map.entry(ModItems.SHOVEL_MOULD, Items.NETHERITE_SHOVEL),
                Map.entry(ModItems.HOE_MOULD, Items.NETHERITE_HOE),
                Map.entry(ModItems.SWORD_MOULD, Items.NETHERITE_SWORD),
                Map.entry(ModItems.SHEARS_MOULD, Items.SHEARS),
                Map.entry(ModItems.SHIELD_MOULD, Items.SHIELD)
        );

        mouldRecipes.forEach((mouldItem, baseItem) -> offerMouldRecipe(exporter, mouldItem, baseItem));
    }

    private void offerMouldRecipe(Consumer<RecipeJsonProvider> exporter, Item outputMould, Item baseItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputMould, 2)
                .pattern("121")
                .pattern("131")
                .pattern("111")
                .input('1', ModItems.BLANK_MOULD)
                .input('2', outputMould)
                .input('3', baseItem)
                .criterion("has_" + Registries.ITEM.getId(outputMould).getPath(), conditionsFromItem(outputMould))
                .offerTo(exporter, new Identifier(getRecipeName(outputMould)));
    }

    private static String getRecipeName(Item item) {
        return Registries.ITEM.getId(item).getPath();
    }

    private void registerFoolsGoldSmithingRecipes(Consumer<RecipeJsonProvider> exporter) {
        Map<Item, String> tools = Map.ofEntries(
                Map.entry(ModItems.FOOLS_GOLD_HELMET, "helmet"),
                Map.entry(ModItems.FOOLS_GOLD_CHESTPLATE, "chestplate"),
                Map.entry(ModItems.FOOLS_GOLD_LEGGINGS, "leggings"),
                Map.entry(ModItems.FOOLS_GOLD_BOOTS, "boots"),

                Map.entry(ModItems.FOOLS_GOLD_PICKAXE, "pickaxe"),
                Map.entry(ModItems.FOOLS_GOLD_AXE, "axe"),
                Map.entry(ModItems.FOOLS_GOLD_SHOVEL, "shovel"),
                Map.entry(ModItems.FOOLS_GOLD_HOE, "hoe"),
                Map.entry(ModItems.FOOLS_GOLD_SWORD, "sword"),
                Map.entry(ModItems.FOOLS_GOLD_SHEARS, "shears"),
                Map.entry(ModItems.FOOLS_GOLD_SHIELD, "shield")
        );

        tools.forEach((outputItem, mouldName) -> SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(getMouldItem(mouldName)),
                        Ingredient.ofItems(ModItems.FOOLS_GOLD_LAVA_BUCKET),
                        Ingredient.ofItems(ModItems.DIVINITITE_ALLOY_INGOT),
                        RecipeCategory.COMBAT,
                        outputItem
                )
                .criterion("has_" + mouldName + "_mould", conditionsFromItem(getMouldItem(mouldName)))
                .criterion("has_fools_gold_bucket", conditionsFromItem(ModItems.FOOLS_GOLD_LAVA_BUCKET))
                .criterion("has_divinitite_ingot", conditionsFromItem(ModItems.DIVINITITE_ALLOY_INGOT))
                .offerTo(exporter, new Identifier("steamcraft", "fools_gold_" + mouldName + "_smithing")));
    }

    private Item getMouldItem(String mouldName) {
        return switch (mouldName) {
            case "helmet" -> ModItems.HELMET_MOULD;
            case "chestplate" -> ModItems.CHESTPLATE_MOULD;
            case "leggings" -> ModItems.LEGGINGS_MOULD;
            case "boots" -> ModItems.BOOTS_MOULD;

            case "pickaxe" -> ModItems.PICKAXE_MOULD;
            case "axe" -> ModItems.AXE_MOULD;
            case "shovel" -> ModItems.SHOVEL_MOULD;
            case "hoe" -> ModItems.HOE_MOULD;
            case "sword" -> ModItems.SWORD_MOULD;
            case "shears" -> ModItems.SHEARS_MOULD;
            case "shield" -> ModItems.SHIELD_MOULD;
            default -> throw new IllegalArgumentException("Unknown mould name: " + mouldName);
        };
    }







}