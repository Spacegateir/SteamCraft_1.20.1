package net.spacegateir.steamcraft.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.spacegateir.steamcraft.Steamcraft;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {

    public static final FlowableFluid STILL_SOAP_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "soap_water"), new SoapWaterFluid.Still());

    public static final FlowableFluid FLOWING_SOAP_WATER = Registry.register(Registries.FLUID,
            new Identifier(Steamcraft.MOD_ID, "flowing_soap_water"), new SoapWaterFluid.Flowing());

    public static final Block SOAP_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Steamcraft.MOD_ID,
            "soap_water_block"), new FluidBlock(ModFluids.STILL_SOAP_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item SOAP_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(Steamcraft.MOD_ID,
            "soap_water_bucket"), new BucketItem(ModFluids.STILL_SOAP_WATER,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {
        Steamcraft.LOGGER.info("Registering Fluid for " + Steamcraft.MOD_ID);
    }
}