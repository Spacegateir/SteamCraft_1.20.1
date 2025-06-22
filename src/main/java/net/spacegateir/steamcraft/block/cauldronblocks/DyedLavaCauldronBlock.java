package net.spacegateir.steamcraft.block.cauldronblocks;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.ModCauldronInteractions;

public class DyedLavaCauldronBlock extends AbstractCauldronBlock {

    public DyedLavaCauldronBlock(Settings settings, DyeColor color) {
        super(settings, ModCauldronInteractions.COLOR_TO_LAVA_CAULDRON_BEHAVIOR.get(color));
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return 0.9375;
    }

    @Override
    public boolean isFull(BlockState state) {
        return true;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (this.isEntityTouchingFluid(state, pos, entity)) {
            entity.setOnFireFromLava();
        }
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 3;
    }
}