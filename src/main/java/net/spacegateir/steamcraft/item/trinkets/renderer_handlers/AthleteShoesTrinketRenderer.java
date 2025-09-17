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

public class AthleteShoesTrinketRenderer implements TrinketRenderer {

//    X-axis: left/right (negative = left, positive = right)
//    Y-axis: up/down (negative = down, positive = up)
//    Z-axis: forward/backward (negative = forward, positive = back)
//    1 pixel = 0.0625 units in all directions

    private final ModelPart shoe;

    public AthleteShoesTrinketRenderer() {
        ModelData md = new ModelData();
        ModelPartData root = md.getRoot();

        root.addChild("right",
                ModelPartBuilder.create()
                        .uv(0, 5)
                        .cuboid(0.0F, 0.5F, -0.5F, 0.01F, 6.0F, 5.0F),
                ModelTransform.pivot(6.5F, -6.0F, 7.0F));

        root.addChild("left",
                ModelPartBuilder.create()
                        .uv(10, 5)
                        .cuboid(0.0F, 0.5F, -0.5F, 0.01F, 6.0F, 5.0F),
                ModelTransform.pivot(11.5F, -6.0F, 7.0F));

        root.addChild("front",
                ModelPartBuilder.create()
                        .uv(10, 16)
                        .cuboid(0.0F, 0.5F, -0.5F, 5.0F, 6.0F, 0.01F),
                ModelTransform.pivot(6.5F, -6.0F, 7.0F));

        root.addChild("back",
                ModelPartBuilder.create()
                        .uv(0, 16)
                        .cuboid(0.0F, 0.5F, 4.5F, 5.0F, 6.0F, 0.01F),
                ModelTransform.pivot(6.5F, -6.0F, 7.0F));

        root.addChild("bottom",
                ModelPartBuilder.create()
                        .uv(0, 5)
                        .cuboid(-0.5F, 0.5F, -0.5F, 5.00F, 0.01F, 5.0F),
                ModelTransform.pivot(7.0F, 0.0F, 7.0F));

        root.addChild("toe",
                ModelPartBuilder.create()
                        .uv(16, 0)
                        .cuboid(0.0F, 0.5F, -2.5F, 5.0F, 4.0F, 2.00F),
                ModelTransform.pivot(6.5F, -4.0F, 7.0F));

        TexturedModelData tmd = TexturedModelData.of(md, 32, 32);
        this.shoe = tmd.createModel();
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

        // RIGHT FOOT
        matrices.push();
        TrinketRenderer.translateToRightLeg(matrices, playerModel, player);
        drawShoe(matrices, vertexConsumers, texture, light, stack);
        matrices.pop();

        // LEFT FOOT
        matrices.push();
        TrinketRenderer.translateToLeftLeg(matrices, playerModel, player);
        drawShoe(matrices, vertexConsumers, texture, light, stack);
        matrices.pop();
    }

    private void drawShoe(MatrixStack matrices, VertexConsumerProvider vcp,
                          Identifier texture, int light, ItemStack stack) {
        VertexConsumer vc = ItemRenderer.getArmorGlintConsumer(
                vcp,
                RenderLayer.getArmorCutoutNoCull(texture),
                false,
                stack.hasGlint()
        );

        matrices.push();

        matrices.translate(-0.5625F, 0.0F, -0.5625F);

        matrices.scale(1.00F, 1.00F, 1.00F);

        shoe.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }

}
