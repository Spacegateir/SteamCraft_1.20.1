package net.spacegateir.steamcraft.event.renderers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.spacegateir.steamcraft.block.entity.SmokeBlockEntity;

public class SmokeBlockRenderer implements BlockEntityRenderer<SmokeBlockEntity> {

    public SmokeBlockRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(SmokeBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        // Example: just show a log message each frame for testing
//        System.out.println("Rendering SmokeBlockEntity at " + entity.getPos());

    }


}