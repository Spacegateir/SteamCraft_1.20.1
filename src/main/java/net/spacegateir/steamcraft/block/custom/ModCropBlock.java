package net.spacegateir.steamcraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.spacegateir.steamcraft.item.ModItems;

public class ModCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);
    private final boolean isThorned;




    public ModCropBlock(Settings settings, boolean isThorned) {
        super(settings);
        this.isThorned = isThorned;
        this.setDefaultState(this.stateManager.getDefaultState().with(getAgeProperty(), 0));
    }


    @Override
    protected ItemConvertible getSeedsItem() {
        return ModCropData.getSeed(this);
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.GRASS_BLOCK)
                || floor.isOf(Blocks.DIRT)
                || floor.isOf(Blocks.COARSE_DIRT)
                || floor.isOf(Blocks.ROOTED_DIRT)
                || floor.isOf(Blocks.MOSS_BLOCK)
                || floor.isOf(Blocks.PODZOL)
                || floor.isOf(Blocks.FARMLAND);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(getAgeProperty()) < getMaxAge();
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!isThorned) return;

        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.slowMovement(state, new Vec3d(0.8F, 0.75F, 0.8F));

            if (!world.isClient && state.get(AGE) > 0 &&
                    (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double dx = Math.abs(entity.getX() - entity.lastRenderX);
                double dz = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (dx >= 0.003 || dz >= 0.003) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        boolean fullyGrown = age == MAX_AGE;

        if (!fullyGrown && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (fullyGrown) {
            ItemConvertible flowerItem = ModCropData.getFlower(this);
            int amount = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(flowerItem, amount + 1));

            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES,
                    SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);

            world.setBlockState(pos, state.with(AGE, 1), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
