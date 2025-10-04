package net.spacegateir.steamcraft.item.trinkets.renderer_handlers;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.item.trinkets.renderer_handlers.TrinketRenderRegistry.TrinketRenderData;

public class RingTrinketRenderer implements TrinketRenderer {

//    X-axis: left/right (negative = left, positive = right)
//    Y-axis: up/down (negative = up, positive = down)
//    Z-axis: forward/backward (negative = forward, positive = back)
//    1 pixel = 0.0625 units in all directions

    private final ModelPart ring;

    public RingTrinketRenderer() {
        ModelData md = new ModelData();
        ModelPartData root = md.getRoot();

        root.addChild("ring",
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-0.25F, 1.0F, -0.25F, 1.5F, 1.5F, 1.5F),
                ModelTransform.pivot(13.5F, 7.0F, 12.5F));

        root.addChild("gem",
                ModelPartBuilder.create()
                        .uv(0, 4)
                        .cuboid(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F),
                ModelTransform.pivot(13.5F, 8.5F, 12.5F));


        TexturedModelData tmd = TexturedModelData.of(md, 16, 16);
        this.ring = tmd.createModel();
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference,
                       EntityModel<? extends LivingEntity> contextModel,
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

        var slotType = slotReference.inventory().getSlotType();
        String group = slotType.getGroup();
        String name = slotType.getName();

        if (group.equals("hand") && name.equals("ring")) {
            matrices.push();
            TrinketRenderer.translateToRightArm(matrices, playerModel, player);
            matrices.translate(-0.90625F, -0.59375F, -0.84375F);
            drawRing(matrices, vertexConsumers, texture, light, stack);
            matrices.pop();

        } else if (group.equals("offhand") && name.equals("ring")) {
            matrices.push();
            TrinketRenderer.translateToLeftArm(matrices, playerModel, player);
            matrices.translate(0.90625F, -0.59375F, -0.84375F);
            matrices.scale(-1.0F, 1.0F, 1.0F);
            drawRing(matrices, vertexConsumers, texture, light, stack);
            matrices.pop();
        }
    }

    private void drawRing(MatrixStack matrices, VertexConsumerProvider vcp,
                              Identifier texture, int light, ItemStack stack) {
        VertexConsumer vc = ItemRenderer.getArmorGlintConsumer(
                vcp,
                RenderLayer.getArmorCutoutNoCull(texture),
                false,
                stack.hasGlint()
        );

        matrices.push();
        matrices.scale(1.0F, 1.0F, 1.0F);
        ring.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }
}