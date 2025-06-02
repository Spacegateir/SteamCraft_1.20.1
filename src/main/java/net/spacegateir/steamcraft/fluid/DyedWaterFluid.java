package net.spacegateir.steamcraft.fluid;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.*;
import net.spacegateir.steamcraft.item.ModItems;

public abstract class DyedWaterFluid extends FlowableFluid {

    private final Supplier<FlowableFluid> stillSupplier;
    private final Supplier<FlowableFluid> flowingSupplier;
    private final Supplier<Block> blockSupplier;
    private final Supplier<Item> bucketSupplier;

    public DyedWaterFluid(DyeColor color) {
        this.stillSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_STILL_WATER.get(color));
        this.flowingSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_FLOWING_WATER.get(color));
        this.blockSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_WATER_BLOCK.get(color));
        this.bucketSupplier = Suppliers.memoize(() -> ModItems.COLOR_TO_WATER_BUCKET.get(color));
    }

    @Override
    public Fluid getFlowing() {
        return this.flowingSupplier.get();
    }

    @Override
    public Fluid getStill() {
        return this.stillSupplier.get();
    }

    @Override
    protected boolean isInfinite(World world) {
        return world.getGameRules().getBoolean(GameRules.WATER_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return this.bucketSupplier.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        // Allow replacement like vanilla water (e.g. lava replacing water downward)
        return direction == Direction.DOWN && !state.isIn(FluidTags.WATER);
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return this.blockSupplier.get().getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    public static class Flowing extends DyedWaterFluid {
        public Flowing(DyeColor color) {
            super(color);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends DyedWaterFluid {
        public Still(DyeColor color) {
            super(color);
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
