package net.spacegateir.steamcraft.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.EnumMap;
import java.util.Map;

public class ModCauldronInteractions {


    public static final EnumMap<DyeColor, Map<Item, CauldronBehavior>> COLOR_TO_WATER_CAULDRON_BEHAVIOR = Util.make(new EnumMap<>(DyeColor.class), map -> {
        for (DyeColor color : DyeColor.values()) {
            map.put(color, CauldronBehavior.createMap());
        }
    });

    public static final EnumMap<DyeColor, Map<Item, CauldronBehavior>> COLOR_TO_LAVA_CAULDRON_BEHAVIOR = Util.make(new EnumMap<>(DyeColor.class), map -> {
        for (DyeColor color : DyeColor.values()) {
            map.put(color, CauldronBehavior.createMap());
        }
    });

    @Override
    public ActionResult interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
        return null;
    }

    public static void bootstrap() {

        for (DyeColor color : DyeColor.values()) {
            final String lavaBucketName = color.toUpperCase() + "_LAVA_BUCKET";
            final String waterBucketName = color.toUpperCase() + "_WATER_BUCKET";
            final String lavaCauldronBlockName = color.toUpperCase() + "_LAVA_CAULDRON_BLOCK";
            final String waterCauldronBlockName = color.toUpperCase() + "_WATER_CAULDRON_BLOCK";
            final String dyeItemName = color.toUpperCase() + "_DYE";

            try {
                Item lavaBucket = (Item) ModItems.class.getField(lavaBucketName).get(null);
                Item waterBucket = (Item) ModItems.class.getField(waterBucketName).get(null);
                Item dyeItem = (Item) Items.class.getField(dyeItemName).get(null); // Minecraft vanilla dye

                BlockState lavaCauldron = ((net.minecraft.block.Block) ModBlocks.class.getField(lavaCauldronBlockName).get(null)).getDefaultState();
                BlockState waterCauldron = ((net.minecraft.block.Block) ModBlocks.class.getField(waterCauldronBlockName).get(null)).getDefaultState();

                // Fill cauldrons
                CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.put(lavaBucket, (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.fillCauldron(world, pos, player, hand, stack, lavaCauldron, SoundEvents.ITEM_BUCKET_EMPTY_LAVA));
                CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.put(waterBucket, (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.fillCauldron(world, pos, player, hand, stack, waterCauldron, SoundEvents.ITEM_BUCKET_EMPTY));

                // Empty cauldrons
                CauldronBehavior lavaBehavior = (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(lavaBucket), s -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA);
                CauldronBehavior waterBehavior = (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(waterBucket), s -> true, SoundEvents.ITEM_BUCKET_FILL);

                Map<Item, CauldronBehavior> lavaMap = COLOR_TO_LAVA_CAULDRON_BEHAVIOR.get(color);
                Map<Item, CauldronBehavior> waterMap = COLOR_TO_WATER_CAULDRON_BEHAVIOR.get(color);

                lavaMap.put(Items.BUCKET, lavaBehavior);
                waterMap.put(Items.BUCKET, waterBehavior);

                CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(dyeItem, (state, world, pos, player, hand, stack) -> {
                    world.setBlockState(pos, waterCauldron);
                    stack.decrement(1);
                    world.playSound(null, pos, SoundEvents.ITEM_DYE_USE, player.getSoundCategory(), 1.0F, 1.0F);
                    return ActionResult.success(world.isClient);
                });

                CauldronBehavior.LAVA_CAULDRON_BEHAVIOR.put(dyeItem, (state, world, pos, player, hand, stack) -> {
                    world.setBlockState(pos, lavaCauldron);
                    stack.decrement(1);
                    world.playSound(null, pos, SoundEvents.ITEM_DYE_USE, player.getSoundCategory(), 1.0F, 0.75F);
                    return ActionResult.success(world.isClient);
                });


            } catch (Exception e) {
                System.err.println("Failed to register cauldron behavior for color: " + color);
                e.printStackTrace();
            }
        }
    }
}
