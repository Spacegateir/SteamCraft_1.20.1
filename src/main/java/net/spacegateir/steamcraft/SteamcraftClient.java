package net.spacegateir.steamcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.armor.WingedSandalsCosmeticItem;

public class SteamcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                ItemStack boots = client.player.getInventory().getArmorStack(0);
                if (boots.getItem() instanceof WingedSandalsCosmeticItem) {
                    ((WingedSandalsCosmeticItem) boots.getItem()).handleMovement(client.player);
                }
            }

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

        });
    }
}