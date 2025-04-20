package net.spacegateir.steamcraft.block.arcane;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class ArcaneDolphinsGraceBlock extends Block {
    // modify when the json file gets more models
    public static final IntProperty SWITCH_STATE = IntProperty.of("switch_state", 0, 49);


    public ArcaneDolphinsGraceBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(SWITCH_STATE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SWITCH_STATE);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {

            // Get the redstone signal strength at the block position
            int signalStrength = world.getReceivedRedstonePower(pos);

            // Set base values if no signal is present (signalStrength == 0)
            int baseDuration = (signalStrength == 0) ? 2400 : 2400;
            int baseAmplifier = (signalStrength == 0) ? 0 : 0;

            // Adjust duration and amplifier based on the redstone signal
            int adjustedDuration = baseDuration + (signalStrength * 2400);
            int adjustedAmplifier = baseAmplifier + signalStrength;

            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, adjustedDuration, adjustedAmplifier, false, false));
        }
        super.onSteppedOn(world, pos, state, entity);
    }

}

