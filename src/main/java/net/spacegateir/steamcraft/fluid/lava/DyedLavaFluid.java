package net.spacegateir.steamcraft.fluid.lava;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.spacegateir.steamcraft.block.fluidblocks.DyedFluidBlock;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Optional;

public abstract class DyedLavaFluid extends FlowableFluid {
    public static final float MIN_HEIGHT_TO_REPLACE = 0.44444445F;
    private static final EnumMap<DyeColor, Block> COLOR_TO_CONCRETE = Util.make(new EnumMap<>(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, Blocks.WHITE_CONCRETE);
        map.put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE);
        map.put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE);
        map.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        map.put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE);
        map.put(DyeColor.LIME, Blocks.LIME_CONCRETE);
        map.put(DyeColor.PINK, Blocks.PINK_CONCRETE);
        map.put(DyeColor.GRAY, Blocks.GRAY_CONCRETE);
        map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        map.put(DyeColor.CYAN, Blocks.CYAN_CONCRETE);
        map.put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE);
        map.put(DyeColor.BLUE, Blocks.BLUE_CONCRETE);
        map.put(DyeColor.BROWN, Blocks.BROWN_CONCRETE);
        map.put(DyeColor.GREEN, Blocks.GREEN_CONCRETE);
        map.put(DyeColor.RED, Blocks.RED_CONCRETE);
        map.put(DyeColor.BLACK, Blocks.BLACK_CONCRETE);
    });

    private final Supplier<FlowableFluid> stillSupplier;
    private final Supplier<FlowableFluid> flowingSupplier;
    private final Supplier<Block> blockSupplier;
    private final Supplier<Item> bucketSupplier;
    private final TagKey<Fluid> waterTag;
    private final TagKey<Fluid> lavaTag;
    private final Block concrete;

    public DyedLavaFluid(DyeColor color) {
        this.stillSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_STILL_LAVA.get(color));
        this.flowingSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_FLOWING_LAVA.get(color));
        this.blockSupplier = Suppliers.memoize(() -> ModFluids.COLOR_TO_LAVA_BLOCK.get(color));
        this.bucketSupplier = Suppliers.memoize(() -> ModItems.COLOR_TO_LAVA_BUCKET.get(color));
        this.waterTag = ModTags.Fluids.createWaterTag(color);
        this.lavaTag = ModTags.Fluids.createLavaTag(color);
        this.concrete = COLOR_TO_CONCRETE.get(color);
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
    public Item getBucketItem() {
        return this.bucketSupplier.get();
    }

    @Override
    protected boolean isInfinite(World world) {
        return world.getGameRules().getBoolean(GameRules.LAVA_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
        playExtinguishEvent(world, pos);
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        BlockPos above = pos.up();
        if (world.getBlockState(above).isAir() && !world.getBlockState(above).isOpaqueFullCube(world, above)) {
            if (random.nextInt(100) == 0) {
                double x = pos.getX() + random.nextDouble();
                double y = pos.getY() + 1.0;
                double z = pos.getZ() + random.nextDouble();
                world.addParticle(ParticleTypes.LAVA, x, y, z, 0.0, 0.0, 0.0);
                world.playSound(x, y, z, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
            if (random.nextInt(200) == 0) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }
    }

    @Override
    public void onRandomTick(World world, BlockPos pos, FluidState state, Random random) {
        if (world.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos blockPos = pos;
                for (int j = 0; j < i; ++j) {
                    blockPos = blockPos.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!world.canSetBlock(blockPos)) continue;

                    BlockState blockState = world.getBlockState(blockPos);
                    if (blockState.isAir() && this.canLightFire(world, blockPos)) {
                        world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
                        return;
                    } else if (blockState.blocksMovement()) {
                        return;
                    }
                }
            } else {
                for (int j = 0; j < 3; ++j) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!world.canSetBlock(blockPos)) continue;

                    if (world.isAir(blockPos.up()) && this.hasBurnableBlock(world, blockPos)) {
                        world.setBlockState(blockPos.up(), AbstractFireBlock.getState(world, blockPos));
                    }
                }
            }
        }
    }

    private boolean canLightFire(WorldView world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (hasBurnableBlock(world, pos.offset(direction))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasBurnableBlock(WorldView world, BlockPos pos) {
        return pos.getY() >= world.getBottomY() && pos.getY() < world.getTopY()
                && world.isChunkLoaded(pos)
                && world.getBlockState(pos).isBurnable();
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Nullable
    @Override
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return world.getDimension().ultrawarm() ? 4 : 2;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return world.getDimension().ultrawarm() ? 1 : 2;
    }

    @Override
    public int getTickRate(WorldView world) {
        return world.getDimension().ultrawarm() ? 10 : 30;
    }

    @Override
    public int getNextTickDelay(World world, BlockPos pos, FluidState oldState, FluidState newState) {
        int delay = this.getTickRate(world);
        if (!oldState.isEmpty() && !newState.isEmpty()
                && !oldState.get(FALLING)
                && !newState.get(FALLING)
                && newState.getHeight(world, pos) > oldState.getHeight(world, pos)
                && world.getRandom().nextInt(4) != 0) {
            delay *= 4;
        }
        return delay;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected boolean hasRandomTicks() {
        return true;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL_LAVA);
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {

        // DYED_LAVA + DYED_WATER => DYED_CONCRETE
        if (direction == Direction.DOWN) {
            if (this.isIn(this.lavaTag) && fluidState.isIn(this.waterTag)) {
                if (state.getBlock() instanceof DyedFluidBlock) {
                    world.setBlockState(pos, this.concrete.getDefaultState(), Block.NOTIFY_ALL);
                }
                this.playExtinguishEvent(world, pos);
                return;
            }
        }

        // Vanilla: LAVA + WATER => STONE
        if (direction == Direction.DOWN) {
            if (this.isIn(FluidTags.LAVA) && fluidState.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
                }
                this.playExtinguishEvent(world, pos);
                return;
            }
        }

        super.flow(world, pos, state, direction, fluidState);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return state.getHeight(world, pos) >= MIN_HEIGHT_TO_REPLACE && fluid.isIn(ModTags.Fluids.WATER_DL);
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return this.blockSupplier.get().getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    public static class Flowing extends DyedLavaFluid {
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

    public static class Still extends DyedLavaFluid {
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
