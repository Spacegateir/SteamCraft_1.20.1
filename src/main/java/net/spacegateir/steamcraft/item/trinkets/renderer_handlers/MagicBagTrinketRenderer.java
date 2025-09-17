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

public class MagicBagTrinketRenderer implements TrinketRenderer {

//    X-axis: left/right (negative = left, positive = right)
//    Y-axis: up/down (negative = down, positive = up)
//    Z-axis: forward/backward (negative = forward, positive = back)
//    1 pixel = 0.0625 units in all directions

    private final ModelPart bag;

    public MagicBagTrinketRenderer() {
        ModelData md = new ModelData();
        ModelPartData root = md.getRoot();

        root.addChild("bag_top", ModelPartBuilder.create()
                        .uv(0, 14)
                        .cuboid(-4.0F, 19.0F, 2.0F, 8, 4, 4),
                ModelTransform.pivot(8, -8, 8));

        root.addChild("bag_bottom", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-4.0F, 11.0F, 2.0F, 8, 8, 6),
                ModelTransform.pivot(8, 4, 8));

        root.addChild("right_shoulder_top", ModelPartBuilder.create()
                        .uv(16, 25)
                        .cuboid(1.5F, 21.0F, -3.0F, 2, 4, 6),
                ModelTransform.pivot(8, -12, 8));

        root.addChild("right_shoulder_bottom", ModelPartBuilder.create()
                        .uv(32, 26)
                        .cuboid(2.5F, 17.0F, -3.0F, 2, 4, 4),
                ModelTransform.pivot(8, -4, 8));

        root.addChild("left_shoulder_top", ModelPartBuilder.create()
                        .uv(0, 25)
                        .cuboid(-3.5F, 21.0F, -3.0F, 2, 4, 6),
                ModelTransform.pivot(8, -12, 8));

        root.addChild("left_shoulder_bottom", ModelPartBuilder.create()
                        .uv(32, 18)
                        .cuboid(-4.5F, 17.0F, -3.0F, 2, 4, 4),
                ModelTransform.pivot(8, -4, 8));

        root.addChild("lock", ModelPartBuilder.create()
                        .uv(40, 0)
                        .cuboid(-1.0F, 17.5F, 6.0F, 2, 2, 3F),
                ModelTransform.pivot(8, -3, 7.5F));

        root.addChild("buckel", ModelPartBuilder.create()
                        .uv(0, 22)
                        .cuboid(-6.5F, 14.5F, 4.5F, 13, 2, 1.0F),
                ModelTransform.pivot(8F, 3F, 8F));

        root.addChild("bag_left_side", ModelPartBuilder.create()
                        .uv(28, 9)
                        .cuboid(-6, 12, 3, 2, 5, 4F),
                ModelTransform.pivot(8, 5, 8));

        root.addChild("bag_right_side", ModelPartBuilder.create()
                        .uv(28, 0)
                        .cuboid(4, 12, 3, 2, 5, 4F),
                ModelTransform.pivot(8, 5, 8));

        TexturedModelData tmd = TexturedModelData.of(md, 64, 64);
        this.bag = tmd.createModel();
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

        // backpack
        matrices.push();
        TrinketRenderer.translateToChest(matrices, playerModel, player);
        matrices.translate(0.0625F, -1.03125F, 0.21875F);

        drawbackpack(matrices, vertexConsumers, texture, light, stack);
        matrices.pop();
    }

    private void drawbackpack(MatrixStack matrices, VertexConsumerProvider vcp,
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
        bag.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
    }
}
