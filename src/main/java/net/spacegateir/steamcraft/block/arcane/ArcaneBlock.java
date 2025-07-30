package net.spacegateir.steamcraft.block.arcane;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Function;

public class ArcaneBlock extends Block {

    public static final IntProperty SWITCH_STATE = IntProperty.of("switch_state", 0, 49);

    private final Function<Integer, StatusEffectInstance> signalStrengthToEffect;

    public ArcaneBlock(Settings settings, Function<Integer, StatusEffectInstance> signalStrengthToEffect) {

        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(SWITCH_STATE, 0));
        this.signalStrengthToEffect = signalStrengthToEffect;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SWITCH_STATE);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {

            int signalStrength = world.getReceivedRedstonePower(pos);

            StatusEffectInstance statusEffectInstance = signalStrengthToEffect.apply(signalStrength);
            if (statusEffectInstance != null) {
                livingEntity.addStatusEffect(statusEffectInstance);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}