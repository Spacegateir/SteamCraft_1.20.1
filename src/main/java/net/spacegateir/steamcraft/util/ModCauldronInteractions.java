package net.spacegateir.steamcraft.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.Map;

public class ModCauldronInteractions implements CauldronBehavior {

    public static final Map<Item, CauldronBehavior> WHITE_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> WHITE_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> ORANGE_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> ORANGE_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> MAGENTA_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> MAGENTA_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIGHT_BLUE_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIGHT_BLUE_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> YELLOW_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> YELLOW_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIME_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIME_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> PINK_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> PINK_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> GRAY_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> GRAY_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIGHT_GRAY_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> LIGHT_GRAY_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> CYAN_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> CYAN_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> PURPLE_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> PURPLE_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BLUE_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BLUE_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BROWN_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BROWN_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> GREEN_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> GREEN_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> RED_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> RED_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BLACK_LAVA_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final Map<Item, CauldronBehavior> BLACK_WATER_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();



    @Override
    public ActionResult interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
        return null;
    }

    public static void bootstrap() {
        String[] colors = {
                "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink",
                "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
        };

        for (String color : colors) {
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
                EMPTY_CAULDRON_BEHAVIOR.put(lavaBucket, (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.fillCauldron(world, pos, player, hand, stack, lavaCauldron, SoundEvents.ITEM_BUCKET_EMPTY_LAVA));
                EMPTY_CAULDRON_BEHAVIOR.put(waterBucket, (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.fillCauldron(world, pos, player, hand, stack, waterCauldron, SoundEvents.ITEM_BUCKET_EMPTY));

                // Empty cauldrons
                CauldronBehavior lavaBehavior = (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(lavaBucket), s -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA);
                CauldronBehavior waterBehavior = (state, world, pos, player, hand, stack) ->
                        CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(waterBucket), s -> true, SoundEvents.ITEM_BUCKET_FILL);

                Map<Item, CauldronBehavior> lavaMap = (Map<Item, CauldronBehavior>) ModCauldronInteractions.class
                        .getField(color.toUpperCase() + "_LAVA_CAULDRON_BEHAVIOR").get(null);
                Map<Item, CauldronBehavior> waterMap = (Map<Item, CauldronBehavior>) ModCauldronInteractions.class
                        .getField(color.toUpperCase() + "_WATER_CAULDRON_BEHAVIOR").get(null);

                lavaMap.put(Items.BUCKET, lavaBehavior);
                waterMap.put(Items.BUCKET, waterBehavior);

                WATER_CAULDRON_BEHAVIOR.put(dyeItem, (state, world, pos, player, hand, stack) -> {
                    world.setBlockState(pos, waterCauldron);
                    stack.decrement(1);
                    world.playSound(null, pos, SoundEvents.ITEM_DYE_USE, player.getSoundCategory(), 1.0F, 1.0F);
                    return ActionResult.success(world.isClient);
                });

                LAVA_CAULDRON_BEHAVIOR.put(dyeItem, (state, world, pos, player, hand, stack) -> {
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
