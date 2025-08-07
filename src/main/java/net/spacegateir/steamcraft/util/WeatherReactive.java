package net.spacegateir.steamcraft.util;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public interface WeatherReactive {
    void tickWeatherEffect(BlockState state, ServerWorld world, BlockPos pos, Random random);
}
