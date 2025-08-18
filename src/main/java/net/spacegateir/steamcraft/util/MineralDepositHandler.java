package net.spacegateir.steamcraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.spacegateir.steamcraft.block.custom.TwoTallBlock;

public class MineralDepositHandler {

    public static void placeInactiveMineralDepositLower(World world, BlockPos brokenPos, MineralType mineralType) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            serverWorld.getServer().execute(() -> {
                BlockPos lowerPos = brokenPos;
                BlockPos upperPos = lowerPos.up();

                Block inactiveBlock = mineralType.getInactiveBlock();

                BlockState inactiveLower = inactiveBlock.getDefaultState()
                        .with(TwoTallBlock.HALF, DoubleBlockHalf.LOWER);
                BlockState inactiveUpper = inactiveBlock.getDefaultState()
                        .with(TwoTallBlock.HALF, DoubleBlockHalf.UPPER);

                if (serverWorld.isAir(lowerPos) && serverWorld.isAir(upperPos)) {
                    serverWorld.setBlockState(lowerPos, inactiveLower, Block.FORCE_STATE | Block.NOTIFY_LISTENERS);
                    serverWorld.setBlockState(upperPos, inactiveUpper, Block.FORCE_STATE | Block.NOTIFY_LISTENERS);

                    serverWorld.scheduleBlockTick(lowerPos, inactiveBlock, mineralType.getRespawnDelayTicks());
                }
            });
        }
    }

    public static void placeInactiveMineralDepositUpper(World world, BlockPos brokenPos, MineralType mineralType) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            serverWorld.getServer().execute(() -> {
                BlockPos upperPos = brokenPos;
                BlockPos lowerPos = upperPos.down();

                Block inactiveBlock = mineralType.getInactiveBlock();

                BlockState inactiveLower = inactiveBlock.getDefaultState()
                        .with(TwoTallBlock.HALF, DoubleBlockHalf.LOWER);
                BlockState inactiveUpper = inactiveBlock.getDefaultState()
                        .with(TwoTallBlock.HALF, DoubleBlockHalf.UPPER);

                if (serverWorld.isAir(lowerPos) && serverWorld.isAir(upperPos)) {
                    serverWorld.setBlockState(lowerPos, inactiveLower, Block.FORCE_STATE | Block.NOTIFY_LISTENERS);
                    serverWorld.setBlockState(upperPos, inactiveUpper, Block.FORCE_STATE | Block.NOTIFY_LISTENERS);

                    serverWorld.scheduleBlockTick(lowerPos, inactiveBlock, mineralType.getRespawnDelayTicks());
                }
            });
        }
    }








}