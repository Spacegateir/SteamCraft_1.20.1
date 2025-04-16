package net.spacegateir.steamcraft.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.nbt.NbtCompound;
import net.spacegateir.steamcraft.block.custom.AetherBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SwapItem extends Item {

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.steamcraft.pattern_recompiler.tooltip.shift_1"));
            tooltip.add(Text.translatable("tooltip.steamcraft.pattern_recompiler.tooltip.shift_2"));
        } else {
            tooltip.add(Text.translatable("tooltip.steamcraft.pattern_recompiler.tooltip"));
        }

    }

    // Array to hold model names based on switch_state value
    private static final String[] MODEL_NAMES = {
            "aether_coil #0",

            //Diagonals
            "horizontal_ns #1", "horizontal_ew #2", "vertical_upwards #3", "vertical_sidewards #4",

            //Angles
            "up_east #5", "up_west #6", "down_east #7", "down_west #8",
            "up_north #9", "up_south #10", "down_north #11", "down_south #12",
            "north_east #13", "north_west #14", "south_east #15", "south_west #16",

            //Ends with one Entrance point
            "north_cap #17", "east_cap #18", "south_cap #19", "west_cap #20", "up_cap #21", "down_cap #22",

            //3 Sides like a T
            "north_tri #23", "east_tri #24", "south_tri #25", "west_tri #26",

            "uew_tri #27", "ued_tri #28", "edw_tri #29", "dwu_tri #30",
            "und_tri #31", "nds_tri #32", "dsu_tri #33", "nsu_tri #34",

            //All 4 Sides
            "ns_all #35", "ew_all #36", "ud_all #37",

    };

    public SwapItem(Settings settings) {
        super(settings);
    }

    // Right-click in air to change model selection
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int currentModel = nbt.getInt("SelectedModel");
            int maxModels = MODEL_NAMES.length;

            int next;
            if (player.isSneaking()) {
                next = (currentModel - 1 + maxModels) % maxModels;
            } else {
                next = (currentModel + 1) % maxModels;
            }

            nbt.putInt("SelectedModel", next);
            stack.setNbt(nbt);

            String modelName = MODEL_NAMES[next];
            player.sendMessage(Text.literal(" " + modelName), true);

        }

        return TypedActionResult.success(stack);
    }


    // Apply the stored model index to the block when used on block
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = context.getStack();

        // Check if the block is ANY AetherBlock variant
        if (state.getBlock() instanceof AetherBlock) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int selectedModel = nbt.getInt("SelectedModel");
            int maxModels = MODEL_NAMES.length;

            if (selectedModel >= maxModels) selectedModel = 0; // Safety check

            // Apply the switch_state
            BlockState newState = state.with(AetherBlock.SWITCH_STATE, selectedModel);

            world.playSound(player, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (player instanceof ServerPlayerEntity serverPlayer) {
                Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }

            world.setBlockState(pos, newState, 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, newState));

            stack.damage(1, player, (p) -> p.sendToolBreakStatus(context.getHand()));

            if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
                String modelName = MODEL_NAMES[selectedModel];
                serverPlayer.sendMessage(Text.literal("Applied Model: " + modelName), true);
            }

            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

}
