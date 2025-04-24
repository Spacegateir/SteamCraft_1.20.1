package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.entity.SmokeBlockEntity;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;

import java.util.List;

public class SmokeBlock extends BlockWithEntity {
    public SmokeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SmokeBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient && type == ModBlockEntities.SMOKE_BLOCK_ENTITY
                ? (w, pos, s, be) -> SmokeBlockEntity.tick(w, pos, s, (SmokeBlockEntity) be)
                : null;
    }
}
