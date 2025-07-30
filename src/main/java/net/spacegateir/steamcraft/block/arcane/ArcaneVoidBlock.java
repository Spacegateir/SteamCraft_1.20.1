package net.spacegateir.steamcraft.block.arcane;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.effect.ModEffects;

public class ArcaneVoidBlock extends ArcaneBlock {

    public ArcaneVoidBlock(AbstractBlock.Settings settings) {
        super(settings, signalStrength -> null);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {


            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CLEAR_POSITIVE_EFFECT, 1, 200, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CLEAR_NEGATIVE_EFFECT, 1, 200, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CLEAR_NEUTRAL_EFFECT, 1, 200, false, false));


//            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CELESTIAL_GEARFORGES_EFFECT, 1, 200, false, false));
        }
        super.onSteppedOn(world, pos, state, entity);
    }

}