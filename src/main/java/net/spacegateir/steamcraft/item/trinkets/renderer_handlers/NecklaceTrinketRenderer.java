package net.spacegateir.steamcraft.item.trinkets.renderer_handlers;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.TrinketRenderRegistry.TrinketRenderData;

public class NecklaceTrinketRenderer implements TrinketRenderer {

//    X-axis: left/right (negative = right, positive = left)
//    Y-axis: up/down (negative = up, positive = down)
//    Z-axis: forward/backward (negative = forward, positive = back)
//    1 pixel = 0.0625 units in all directions

    private final ModelPart necklace;

    public NecklaceTrinketRenderer() {
        ModelData md = new ModelData();
        ModelPartData root = md.getRoot();

        root.addChild("necklace", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(3.5F, -0.5F, 5.5F, 9, 13, 5),
                ModelTransform.pivot(8, -8, 8));

        TexturedModelData tmd = TexturedModelData.of(md, 32, 32);
        this.necklace = tmd.createModel();
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference,
                       net.minecraft.client.render.entity.model.EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                       int light, LivingEntity entity,
                       float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        if (!(entity instanceof AbstractClientPlayerEntity player)) return;
        if (!(contextModel instanceof PlayerEntityModel<?> genericModel)) return;

        @SuppressWarnings("unchecked")
        PlayerEntityModel<AbstractClientPlayerEntity> playerModel =
                (PlayerEntityModel<AbstractClientPlayerEntity>) genericModel;

        TrinketRenderData data = TrinketRenderRegistry.get(stack.getItem());
        if (data == null) return;
        Identifier texture = data.texture();

        // Necklace
        matrices.push();
        TrinketRenderer.translateToChest(matrices, playerModel, player);
        matrices.translate(-1.0F, 0.1F, -0.84015625F);

        drawnecklace(matrices, vertexConsumers, texture, light, stack);
        matrices.pop();
    }

    private void drawnecklace(MatrixStack matrices, VertexConsumerProvider vcp,
                         Identifier texture, int light, ItemStack stack) {
        VertexConsumer vc = ItemRenderer.getArmorGlintConsumer(
                vcp,
                RenderLayer.getArmorCutoutNoCull(texture),
                false,
                stack.hasGlint()
        );

        matrices.push();
        matrices.translate(-0.0F, 0.0F, -0.0F);
        matrices.scale(1.0F, 1.0F, 1.0F);
        necklace.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }
}
