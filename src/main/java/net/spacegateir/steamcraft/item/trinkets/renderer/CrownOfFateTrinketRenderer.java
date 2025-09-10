package net.spacegateir.steamcraft.item.trinkets.renderer;

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
import net.spacegateir.steamcraft.item.trinkets.renderer.TrinketRenderRegistry.TrinketRenderData;

public class CrownOfFateTrinketRenderer implements TrinketRenderer {

//    X-axis: left/right (negative = left, positive = right)
//    Y-axis: up/down (negative = down, positive = up)
//    Z-axis: forward/backward (negative = forward, positive = back)
//    1 pixel = 0.0625 units in all directions

    private final ModelPart hat;

    public CrownOfFateTrinketRenderer() {
        ModelData md = new ModelData();
        ModelPartData root = md.getRoot();

        root.addChild("baseN",
                ModelPartBuilder.create()
                        .uv(32, 9)
                        .cuboid(3.0F, 0.0F, 3.0F, 10.0F, 4.0F, 1.0F),
                ModelTransform.pivot(1.0F, -1.5F, 6.0F));

        root.addChild("baseS",
                ModelPartBuilder.create()
                        .uv(32, 9)
                        .cuboid(3.0F, 0.0F, 12.0F, 10.0F, 4.0F, 1.0F),
                ModelTransform.pivot(1.0F, -1.5F, 6.0F));

        root.addChild("baseE",
                ModelPartBuilder.create()
                        .uv(0, 28)
                        .cuboid(12.0F, 0.0F, 4.0F, 1.0F, 4.0F, 8.0F),
                ModelTransform.pivot(1.0F, -1.5F, 6.0F));

        root.addChild("baseW",
                ModelPartBuilder.create()
                        .uv(0, 28)
                        .cuboid(3.0F, 0.0F, 4.0F, 1.0F, 4.0F, 8.0F),
                ModelTransform.pivot(1.0F, -1.5F, 6.0F));

        root.addChild("middleT",
                ModelPartBuilder.create()
                        .uv(0, 19)
                        .cuboid(5.0F, 3.0F, 5.0F, 6.0F, 3.0F, 6.0F),
                ModelTransform.pivot(1.0F, -6.5F, 6.0F));

        root.addChild("middleB",
                ModelPartBuilder.create()
                        .uv(0, 9)
                        .cuboid(4.0F, 1.0F, 4.0F, 8.0F, 2.0F, 8.0F),
                ModelTransform.pivot(1.0F, -1.5F, 6.0F));

        root.addChild("top",
                ModelPartBuilder.create()
                        .uv(9, 0)
                        .cuboid(3.5F, 7.0F, 3.5F, 9.0F, 0.01F, 9.0F),
                ModelTransform.pivot(1.0F, -11.5F, 6.0F));

        root.addChild("topN",
                ModelPartBuilder.create()
                        .uv(36, 0)
                        .cuboid(3.5F, 9.0F, 3.5F, 9.0F, 3.0F, 0.01F),
                ModelTransform.pivot(1.0F, -13.5F, 6.0F));

        root.addChild("topS",
                ModelPartBuilder.create()
                        .uv(36, 0)
                        .cuboid(3.5F, 9.0F, 12.5F, 9.0F, 3.0F, 0.01F),
                ModelTransform.pivot(1.0F, -13.5F, 6.0F));

        root.addChild("topE",
                ModelPartBuilder.create()
                        .uv(18, 40)
                        .cuboid(12.5F, 9.0F, 3.5F, 0.01F, 3.0F, 9.0F),
                ModelTransform.pivot(1.0F, -13.5F, 6.0F));

        root.addChild("topW",
                ModelPartBuilder.create()
                        .uv(18, 40)
                        .cuboid(3.5F, 9.0F, 3.5F, 0.01F, 3.0F, 9.0F),
                ModelTransform.pivot(1.0F, -13.5F, 6.0F));

        root.addChild("crossR",
                ModelPartBuilder.create()
                        .uv(48, 28)
                        .cuboid(6.5F, 12.0F, 8.0F, 3.0F, 4.0F, 0.01F),
                ModelTransform.pivot(1.0F, -20.5F, 6.0F));

        root.addChild("crossL",
                ModelPartBuilder.create()
                        .uv(36, 0)
                        .cuboid(8.0F, 12.0F, 6.5F, 0.01F, 4.0F, 3.0F),
                ModelTransform.pivot(1.0F, -20.5F, 6.0F));

        TexturedModelData tmd = TexturedModelData.of(md, 64, 64);
        this.hat = tmd.createModel();
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

        // Hat
        matrices.push();
        TrinketRenderer.translateToFace(matrices, playerModel, player, headYaw, headPitch);
        matrices.translate(0.0F, -0.25F, 0.0F);

        drawHat(matrices, vertexConsumers, texture, light, stack);
        matrices.pop();
    }

    private void drawHat(MatrixStack matrices, VertexConsumerProvider vcp,
                         Identifier texture, int light, ItemStack stack) {
        VertexConsumer vc = ItemRenderer.getArmorGlintConsumer(
                vcp,
                RenderLayer.getArmorCutoutNoCull(texture),
                false,
                stack.hasGlint()
        );

        matrices.push();
        matrices.translate(-0.5625F, 0.0F, -0.5625F);
        matrices.scale(1.0F, 1.0F, 1.0F);
        hat.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }
}
