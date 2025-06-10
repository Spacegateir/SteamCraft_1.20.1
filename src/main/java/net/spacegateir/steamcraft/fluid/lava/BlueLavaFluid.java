package net.spacegateir.steamcraft.fluid.lava;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.fluidblocks.*;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public abstract class BlueLavaFluid extends FlowableFluid {
    public static final float MIN_HEIGHT_TO_REPLACE = 0.44444445F;

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_BLUE_LAVA;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_BLUE_LAVA;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.BLUE_LAVA_BUCKET;
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
        // Define the fluid-block reactions once
        Map<Class<?>, Block> coloredWaterReactions = Map.ofEntries(
                Map.entry(ModFluidWhite.class, ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER),   // Blue + White = Light Blue
                Map.entry(ModFluidOrange.class, ModBlocks.COBBLED_BROWN_CONCRETE_POWDER),       // Blue + Orange ≈ Brown
                Map.entry(ModFluidMagenta.class, ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER),     // Blue + Magenta ≈ Purple
                Map.entry(ModFluidLightBlue.class, ModBlocks.COBBLED_CYAN_CONCRETE_POWDER),     // Blue + Light Blue ≈ Cyan
                Map.entry(ModFluidYellow.class, ModBlocks.COBBLED_GREEN_CONCRETE_POWDER),       // Blue + Yellow ≈ Green
                Map.entry(ModFluidLime.class, ModBlocks.COBBLED_CYAN_CONCRETE_POWDER),          // Blue + Lime ≈ Cyan
                Map.entry(ModFluidPink.class, ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER),       // Blue + Pink ≈ Magenta
                Map.entry(ModFluidGray.class, ModBlocks.COBBLED_GRAY_CONCRETE_POWDER),          // Blue + Gray = Gray
                Map.entry(ModFluidLightGray.class, ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER),// Blue + Light Gray = Light Gray
                Map.entry(ModFluidCyan.class, ModBlocks.COBBLED_CYAN_CONCRETE_POWDER),          // Blue + Cyan = Cyan
                Map.entry(ModFluidPurple.class, ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER),      // Blue + Purple = Purple
                Map.entry(ModFluidBlue.class, ModBlocks.COBBLED_BLUE_CONCRETE_POWDER),          // Blue + Blue = Blue
                Map.entry(ModFluidBrown.class, ModBlocks.COBBLED_BROWN_CONCRETE_POWDER),        // Blue + Brown = Brown
                Map.entry(ModFluidGreen.class, ModBlocks.COBBLED_CYAN_CONCRETE_POWDER),         // Blue + Green ≈ Cyan
                Map.entry(ModFluidRed.class, ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER),         // Blue + Red ≈ Purple
                Map.entry(ModFluidBlack.class, ModBlocks.COBBLED_BLUE_CONCRETE_POWDER)          // Blue + Black = Blue (dark stays dark)
        );


        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);

            if (this.isIn(ModTags.Fluids.BLUE_LAVA_DL) && fluidState2.isIn(ModTags.Fluids.WATER_DL)) {
                for (Map.Entry<Class<?>, Block> entry : coloredWaterReactions.entrySet()) {
                    if (state.getBlock().getClass().equals(entry.getKey())) {
                        world.setBlockState(pos, entry.getValue().getDefaultState(), Block.NOTIFY_ALL);
                        this.playExtinguishEvent(world, pos);
                        return;
                    }
                }
            }

            // Vanilla: LAVA + WATER => STONE
            if (this.isIn(FluidTags.LAVA) && fluidState2.isIn(FluidTags.WATER)) {
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
        return ModFluids.BLUE_LAVA_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    // Subclasses

    public static class Flowing extends BlueLavaFluid {
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

    public static class Still extends BlueLavaFluid {
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
