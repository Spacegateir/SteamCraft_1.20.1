package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.spacegateir.steamcraft.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_BLOCK);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);

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

//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_LEGGINGS));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FOOLS_GOLD_BOOTS));

        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_GEARFORGED_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_BOOTS, Models.GENERATED);






    }
}