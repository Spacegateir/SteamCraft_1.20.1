package net.spacegateir.steamcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.event.renderers.SmokeBlockRenderer;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.armor.WingedSandalsCosmeticItem;
import net.spacegateir.steamcraft.util.ModFluidRendererRegistry;

public class SteamcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModFluidRendererRegistry.registerFluidRenderers();

        BlockEntityRendererFactories.register(ModBlockEntities.SMOKE_BLOCK_ENTITY, SmokeBlockRenderer::new);


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                ItemStack boots = client.player.getInventory().getArmorStack(0);
                if (boots.getItem() instanceof WingedSandalsCosmeticItem wingedSandalsCosmeticItem) {
                    wingedSandalsCosmeticItem.handleMovement(client.player);
                }
            }
        });


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_HEAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_ARM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_LEG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_CHEST, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_PELVIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_SPINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_SITTING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_LAYING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_ARMS_CROSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_LEGS_CROSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_HEAD_STACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_HALF_BODY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SKELETON_TORSO, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMOKE_BLOCK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COURSE_DIRT_TRAP_BLOCK_SPIKES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_TRAP_BLOCK_SPIKES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_TRAP_BLOCK_SPIKES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FROST_BITE_TRAP_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_BRASIER_TRAP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EMPTY_BRASIER, RenderLayer.getCutout());


        Registries.BLOCK.streamEntries()
                .filter(blockReference -> blockReference.registryKey().getValue().getNamespace().equals(Steamcraft.MOD_ID))
                .map(RegistryEntry.Reference::value)
                .filter(block -> block instanceof FlowerBlock || block instanceof FlowerPotBlock)
                .forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));


//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_WHITE_WATER, ModFluids.FLOWING_WHITE_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FFFFFF));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_WHITE_WATER, ModFluids.FLOWING_WHITE_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIGHT_GRAY_WATER, ModFluids.FLOWING_LIGHT_GRAY_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1BEBEBE));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_LIGHT_GRAY_WATER, ModFluids.FLOWING_LIGHT_GRAY_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GRAY_WATER, ModFluids.FLOWING_GRAY_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1808080));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_GRAY_WATER, ModFluids.FLOWING_GRAY_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BLACK_WATER, ModFluids.FLOWING_BLACK_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1191919));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_BLACK_WATER, ModFluids.FLOWING_BLACK_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BROWN_WATER, ModFluids.FLOWING_BROWN_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1804A2C));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_BROWN_WATER, ModFluids.FLOWING_BROWN_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_RED_WATER, ModFluids.FLOWING_RED_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FF0000));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_RED_WATER, ModFluids.FLOWING_RED_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ORANGE_WATER, ModFluids.FLOWING_ORANGE_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FFA500));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_ORANGE_WATER, ModFluids.FLOWING_ORANGE_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_YELLOW_WATER, ModFluids.FLOWING_YELLOW_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FFFF00));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_YELLOW_WATER, ModFluids.FLOWING_YELLOW_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIME_WATER, ModFluids.FLOWING_LIME_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA15DFF07));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_LIME_WATER, ModFluids.FLOWING_LIME_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GREEN_WATER, ModFluids.FLOWING_GREEN_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1008000));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_GREEN_WATER, ModFluids.FLOWING_GREEN_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_CYAN_WATER, ModFluids.FLOWING_CYAN_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA100FFFF));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_CYAN_WATER, ModFluids.FLOWING_CYAN_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIGHT_BLUE_WATER, ModFluids.FLOWING_LIGHT_BLUE_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1ADD8E6));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_LIGHT_BLUE_WATER, ModFluids.FLOWING_LIGHT_BLUE_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BLUE_WATER, ModFluids.FLOWING_BLUE_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA10000FF));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_BLUE_WATER, ModFluids.FLOWING_BLUE_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_PURPLE_WATER, ModFluids.FLOWING_PURPLE_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA18000FF));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_PURPLE_WATER, ModFluids.FLOWING_PURPLE_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MAGENTA_WATER, ModFluids.FLOWING_MAGENTA_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FF00FF));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_MAGENTA_WATER, ModFluids.FLOWING_MAGENTA_WATER);
//
//            FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_PINK_WATER, ModFluids.FLOWING_PINK_WATER,
//                    SimpleFluidRenderHandler.coloredWater(0xA1FFC0CB));
//            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
//                    ModFluids.STILL_PINK_WATER, ModFluids.FLOWING_PINK_WATER);

// Water
            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.WHITE_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_WHITE_WATER, ModFluids.FLOWING_WHITE_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIGHT_GRAY_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIGHT_GRAY_WATER, ModFluids.FLOWING_LIGHT_GRAY_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.GRAY_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_GRAY_WATER, ModFluids.FLOWING_GRAY_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BLACK_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BLACK_WATER, ModFluids.FLOWING_BLACK_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BROWN_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BROWN_WATER, ModFluids.FLOWING_BROWN_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.RED_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_RED_WATER, ModFluids.FLOWING_RED_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.ORANGE_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_ORANGE_WATER, ModFluids.FLOWING_ORANGE_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.YELLOW_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_YELLOW_WATER, ModFluids.FLOWING_YELLOW_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIME_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIME_WATER, ModFluids.FLOWING_LIME_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.GREEN_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_GREEN_WATER, ModFluids.FLOWING_GREEN_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.CYAN_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_CYAN_WATER, ModFluids.FLOWING_CYAN_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIGHT_BLUE_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIGHT_BLUE_WATER, ModFluids.FLOWING_LIGHT_BLUE_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BLUE_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BLUE_WATER, ModFluids.FLOWING_BLUE_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.PURPLE_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_PURPLE_WATER, ModFluids.FLOWING_PURPLE_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.MAGENTA_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_MAGENTA_WATER, ModFluids.FLOWING_MAGENTA_WATER);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.PINK_WATER_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_PINK_WATER, ModFluids.FLOWING_PINK_WATER);

//Lava
            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.WHITE_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_WHITE_LAVA, ModFluids.FLOWING_WHITE_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIGHT_GRAY_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIGHT_GRAY_LAVA, ModFluids.FLOWING_LIGHT_GRAY_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.GRAY_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_GRAY_LAVA, ModFluids.FLOWING_GRAY_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BLACK_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BLACK_LAVA, ModFluids.FLOWING_BLACK_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BROWN_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BROWN_LAVA, ModFluids.FLOWING_BROWN_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.RED_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_RED_LAVA, ModFluids.FLOWING_RED_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.ORANGE_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_ORANGE_LAVA, ModFluids.FLOWING_ORANGE_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.YELLOW_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_YELLOW_LAVA, ModFluids.FLOWING_YELLOW_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIME_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIME_LAVA, ModFluids.FLOWING_LIME_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.GREEN_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_GREEN_LAVA, ModFluids.FLOWING_GREEN_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.CYAN_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_CYAN_LAVA, ModFluids.FLOWING_CYAN_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.LIGHT_BLUE_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIGHT_BLUE_LAVA, ModFluids.FLOWING_LIGHT_BLUE_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.BLUE_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BLUE_LAVA, ModFluids.FLOWING_BLUE_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.PURPLE_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_PURPLE_LAVA, ModFluids.FLOWING_PURPLE_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.MAGENTA_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_MAGENTA_LAVA, ModFluids.FLOWING_MAGENTA_LAVA);

            BlockRenderLayerMap.INSTANCE.putBlock(ModFluids.PINK_LAVA_BLOCK, RenderLayer.getTranslucent());
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_PINK_LAVA, ModFluids.FLOWING_PINK_LAVA);


    }
}