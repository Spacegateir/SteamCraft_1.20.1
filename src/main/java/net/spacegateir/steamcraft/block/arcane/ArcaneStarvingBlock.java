package net.spacegateir.steamcraft.block.arcane;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArcaneStarvingBlock extends ArcaneBlock {

    public ArcaneStarvingBlock(Settings settings) {
        super(settings, signalStrength -> new StatusEffectInstance(StatusEffects.HUNGER, signalStrength * 2400 + 2400, signalStrength, false, false));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (!world.isClient && entity instanceof PlayerEntity player) {
            // Set hunger to 0 (drain hunger completely)
            HungerManager hungerManager = player.getHungerManager();
            hungerManager.setFoodLevel(0);
            hungerManager.setSaturationLevel(0);
        }
    }
}