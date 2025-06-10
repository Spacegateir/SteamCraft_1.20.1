package net.spacegateir.steamcraft.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;
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

    public static void bootstrap() {

        for (DyeColor color : DyeColor.values()) {

            Item lavaBucket = ModItems.COLOR_TO_LAVA_BUCKET.get(color);
            Item waterBucket = ModItems.COLOR_TO_WATER_BUCKET.get(color);
            Item dyeItem = ModItems.COLOR_TO_DYE.get(color);


            BlockState lavaCauldron = ModBlocks.COLOR_TO_LAVA_CAULDRON.get(color).getDefaultState();
            BlockState waterCauldron = ModBlocks.COLOR_TO_WATER_CAULDRON.get(color).getDefaultState();

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
        }
    }
}
