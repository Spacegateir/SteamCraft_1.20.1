package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.custom.ModCropBlock;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FOOLS_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIVINITITE_ALLOY_BLOCK);

//        BlockStateModelGenerator.BlockTexturePool GlimmerstoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLIMMERSTONE_BLOCK);
//        GlimmerstoneTexturePool.stairs(ModBlocks.GLIMMERSTONE_STAIR_BLOCK);
//        GlimmerstoneTexturePool.slab(ModBlocks.GLIMMERSTONE_SLAB_BLOCK);
//        GlimmerstoneTexturePool.wall(ModBlocks.GLIMMERSTONE_WALL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_WHITE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_WHITE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_GRAY_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_GRAY_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BLACK_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BLACK_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BROWN_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BROWN_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_RED_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_RED_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_ORANGE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_YELLOW_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIME_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIME_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_GREEN_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_GREEN_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_CYAN_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_CYAN_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BLUE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_BLUE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_PURPLE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_MAGENTA_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_PINK_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_PINK_CONCRETE_POWDER);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_ICE_TILES_CRACKED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_BRICKS_CRACKED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SNOW_TILES_CRACKED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_GRAVEL_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_MUD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_CLAY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_MOIST_CLAY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_SAND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_SILT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_LOAM_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.CARNATION_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_CARNATION_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_CARNATION_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.VIOLET_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_VIOLET_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_VIOLET_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.IRIS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_IRIS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_IRIS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.PRIMROSE_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_PRIMROSE_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_PRIMROSE_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.DAFFODIL_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_DAFFODIL_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_DAFFODIL_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.DELPHINIUM_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_DELPHINIUM_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_DELPHINIUM_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.DAHLIA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_DAHLIA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_DAHLIA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.HYDRANGEA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_HYDRANGEA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_HYDRANGEA_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.MIDNIGHT_MYSTIC_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_MIDNIGHT_MYSTIC_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_MIDNIGHT_MYSTIC_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.HAWTHORN_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_HAWTHORN_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_HAWTHORN_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.BONSAI_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_BONSAI_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_BONSAI_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.SPIDERLILY_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_SPIDERLILY_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_SPIDERLILY_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.LARKSPUR_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_LARKSPUR_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_LARKSPUR_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.AGAPANTHUS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_AGAPANTHUS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_AGAPANTHUS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.BLUE_COSMOS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_BLUE_COSMOS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_BLUE_COSMOS_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerCrop(ModBlocks.SNOW_DROP_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.LUSH_SNOW_DROP_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.THORNED_SNOW_DROP_CROP, ModCropBlock.AGE, 0,1,2,3,4,5,6);


        // Normal Flowers
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.IRIS_FLOWER_BLOCK, ModBlocks.POTTED_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_IRIS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        // Thorned Flowers
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_IRIS_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_IRIS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THORNED_VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_THORNED_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_THORNED_VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_THORNED_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);


        // Lush Flowers
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_BONSAI_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_BONSAI_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_CARNATION_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_CARNATION_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_DAFFODIL_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_DAFFODIL_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_DAHLIA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_DAHLIA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_HAWTHORN_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_HAWTHORN_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_IRIS_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_IRIS_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_IRIS_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_LARKSPUR_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_LARKSPUR_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_PRIMROSE_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_PRIMROSE_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUSH_VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_LUSH_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_LUSH_VIOLET_FLOWER_BLOCK, ModBlocks.POTTED_GLOW_LUSH_VIOLET_FLOWER_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.TROWEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MORTAR_AND_PESTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRAP_CONCEALER, Models.GENERATED);

        itemModelGenerator.register(ModItems.SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DIVINE_IMBUMENT_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.WHITE_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_GRAY_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAY_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROWN_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIME_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CYAN_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_BLUE_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGENTA_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_WATER_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.WHITE_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_GRAY_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAY_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROWN_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIME_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CYAN_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_BLUE_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGENTA_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_LAVA_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_LAVA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINITITE_ALLOY_LAVA_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANCIENT_CLAY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_MOIST_CLAY, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLANK_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HELMET_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHESTPLATE_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEGGINGS_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOOTS_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PICKAXE_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AXE_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHOVEL_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOE_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWORD_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHEARS_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHIELD_MOULD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUCKET_MOULD, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HELMET_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_CHESTPLATE_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_LEGGINGS_4, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_BOOTS_4, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_BOOTS));

        itemModelGenerator.register(ModItems.FOOLS_GOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FOOLS_GOLD_SHEARS, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.WINGED_SANDALS, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.LOOT_CHEST, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.WOLF_FURY_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModRewardItems.WOLF_FURY_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModRewardItems.ADAMANTITE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ADAMANTITE_BOOTS));

        itemModelGenerator.register(ModRewardItems.AER_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AER_BOOTS));

        itemModelGenerator.register(ModRewardItems.AQUA_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.AQUA_BOOTS));

        itemModelGenerator.register(ModRewardItems.DRAGON_BANE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DRAGON_BANE_BOOTS));

        itemModelGenerator.register(ModRewardItems.DWARF_STEEL_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.DWARF_STEEL_BOOTS));

        itemModelGenerator.register(ModRewardItems.IGNIS_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.IGNIS_BOOTS));

        itemModelGenerator.register(ModRewardItems.MAGIRITE_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MAGIRITE_BOOTS));

        itemModelGenerator.register(ModRewardItems.MYTHRIL_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.MYTHRIL_BOOTS));

        itemModelGenerator.register(ModRewardItems.ORIKALKUM_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.ORIKALKUM_BOOTS));

        itemModelGenerator.register(ModRewardItems.TERA_LOOT_CHEST, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModRewardItems.TERA_BOOTS));

        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ, Models.GENERATED);

        itemModelGenerator.register(ModItems.RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_ONYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RING_TOPAZ, Models.GENERATED);

        itemModelGenerator.register(ModItems.NECKLACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_ONYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NECKLACE_TOPAZ, Models.GENERATED);







    }
}