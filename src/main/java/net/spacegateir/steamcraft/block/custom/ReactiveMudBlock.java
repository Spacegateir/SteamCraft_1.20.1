package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.spacegateir.steamcraft.util.MudLevel;
import net.spacegateir.steamcraft.util.WeatherReactive;

import java.util.HashMap;
import java.util.Map;

public class ReactiveMudBlock extends Block implements WeatherReactive {
    private static final Map<MudLevel, Block> LEVEL_TO_BLOCK = new HashMap<>();

    private final MudLevel thisLevel;

    public ReactiveMudBlock(Settings settings, MudLevel level) {
        super(settings);
        this.thisLevel = level;
    }

    public static void initMudTransitions(Map<MudLevel, Block> map) {
        LEVEL_TO_BLOCK.clear();
        LEVEL_TO_BLOCK.putAll(map);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        tickWeatherEffect(state, world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        tickWeatherEffect(state, world, pos, random);
    }

    @Override
    public void tickWeatherEffect(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isSkyVisible(pos.up())) return;

        int delta;
        int tickChance;

        // Determine the weather and its effect
        if (world.isThundering()) {
            delta = -2;
            tickChance = 5; // 1 in 5 ticks
        } else if (world.isRaining()) {
            delta = -1;
            tickChance = 5; // 1 in 5 ticks
        } else {
            delta = 1;
            tickChance = 20; // 1 in 20 ticks
        }

        if (random.nextInt(tickChance) == 0) {
            int newLevelValue = thisLevel.value + delta;

            MudLevel newLevel = MudLevel.fromValue(newLevelValue);

            Block newBlock = LEVEL_TO_BLOCK.get(newLevel);

            if (newBlock != null && newBlock != this) {
                world.setBlockState(pos, newBlock.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
    }
}
