package net.spacegateir.steamcraft.block.traps;

import net.minecraft.block.BlockState;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FrostBitTrapBlock extends PowderSnowBlock {

    public FrostBitTrapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!world.isClient) {
            int radius = 25; // Radius for random tick effect
            Box effectArea = new Box(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));

            // Apply status effects to players within the radius
            world.getEntitiesByClass(PlayerEntity.class, effectArea, entity -> entity.isAlive())
                    .forEach(playerEntity -> {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1200, 2, false, false));
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20000, 2, false, false));
                    });
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;  // Enable random ticks
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);

        if (!world.isClient) {
            int radius = 25; // Smaller radius for scheduled tick effect
            Box effectArea = new Box(pos).expand(radius);

            // Increment freezing ticks for nearby entities
            world.getEntitiesByClass(LivingEntity.class, effectArea, entity -> entity.isAlive())
                    .forEach(entity -> {
                        int currentFrozenTicks = entity.getFrozenTicks();
                        entity.setFrozenTicks(Math.min(currentFrozenTicks + 1200, 2400)); // Cap at 2400 ticks 2 minute
                    });

            // Schedule the next tick
            world.scheduleBlockTick(pos, this, 20); // Every 1 second
        }
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        // Start ticking immediately upon placement
        world.scheduleBlockTick(pos, this, 20);
    }
}
