package net.spacegateir.steamcraft.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.Map;

public class TrowelItem extends Item {
    private static final Map<Block, BlockState> PATH_STATES = Maps.newHashMap(
            new ImmutableMap.Builder<Block, BlockState>()

                    .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState())

                    .put(Blocks.CLAY, ModBlocks.CLAY_PATH.getDefaultState())
                    .put(Blocks.COARSE_DIRT, ModBlocks.COARSE_DIRT_PATH.getDefaultState())
                    .put(Blocks.DIRT_PATH, ModBlocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.DIRT, ModBlocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.GRAVEL, ModBlocks.GRAVEL_PATH.getDefaultState())
                    .put(Blocks.MUD, ModBlocks.MUD_PATH.getDefaultState())
                    .put(Blocks.RED_SAND, ModBlocks.RED_SAND_PATH.getDefaultState())
                    .put(Blocks.ROOTED_DIRT, ModBlocks.ROOTED_DIRT_PATH.getDefaultState())
                    .put(Blocks.SAND, ModBlocks.SAND_PATH.getDefaultState())
                    .put(Blocks.SNOW_BLOCK, ModBlocks.SNOW_PATH.getDefaultState())
                    .put(Blocks.ANDESITE, ModBlocks.ANDESITE_PATH.getDefaultState())
                    .put(ModBlocks.ANDESITE_PATH, ModBlocks.ANDESITE_MOSSY_PATH.getDefaultState())
                    .put(ModBlocks.ANDESITE_MOSSY_PATH, ModBlocks.ANDESITE_DIRTY_PATH.getDefaultState())
                    .put(Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_PATH.getDefaultState())
                    .put(Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_PATH.getDefaultState())
                    .put(ModBlocks.COBBLESTONE_PATH, ModBlocks.COBBLED_DIRTY_PATH.getDefaultState())
                    .put(Blocks.COBBLED_DEEPSLATE, ModBlocks.COBBLED_DEEPSLATE_PATH.getDefaultState())
                    .put(ModBlocks.COBBLED_DEEPSLATE_PATH, ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH.getDefaultState())
                    .put(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH, ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH.getDefaultState())
                    .put(Blocks.DIORITE, ModBlocks.DIORITE_PATH.getDefaultState())
                    .put(ModBlocks.DIORITE_PATH, ModBlocks.DIORITE_MOSSY_PATH.getDefaultState())
                    .put(ModBlocks.DIORITE_MOSSY_PATH, ModBlocks.DIORITE_DIRTY_PATH.getDefaultState())
                    .put(Blocks.GRANITE, ModBlocks.GRANITE_PATH.getDefaultState())
                    .put(ModBlocks.GRANITE_PATH, ModBlocks.GRANITE_MOSSY_PATH.getDefaultState())
                    .put(ModBlocks.GRANITE_MOSSY_PATH, ModBlocks.GRANITE_DIRTY_PATH.getDefaultState())
                    .put(Blocks.STONE, ModBlocks.STONE_PATH.getDefaultState())
                    .put(ModBlocks.STONE_PATH, ModBlocks.STONE_MOSSY_PATH.getDefaultState())
                    .put(ModBlocks.STONE_MOSSY_PATH, ModBlocks.STONE_DIRTY_PATH.getDefaultState())

                    .put(Blocks.END_STONE, ModBlocks.END_STONE_PATH.getDefaultState())

                    .build()
    );

    public TrowelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Direction face = context.getSide();

        if (face == Direction.DOWN) {
            return ActionResult.PASS;
        }

        BlockState originalState = world.getBlockState(pos);
        BlockState pathState = PATH_STATES.get(originalState.getBlock());

        if (pathState != null && world.getBlockState(pos.up()).isAir()) {
            PlayerEntity player = context.getPlayer();

            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (!world.isClient) {
                world.setBlockState(pos, pathState, Block.NOTIFY_ALL);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, pathState));

                if (player != null) {
                    context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                }
            }

            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }
}
