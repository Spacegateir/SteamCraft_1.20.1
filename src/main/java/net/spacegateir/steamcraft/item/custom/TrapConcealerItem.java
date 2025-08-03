package net.spacegateir.steamcraft.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.spacegateir.steamcraft.block.arcane.ArcaneBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TrapConcealerItem extends Item {

    // Array of model names (linked to switch_state values)
    private static final String[] MODEL_NAMES = new String[]{
            "arcane base block #0",
            "stone #1",
            "deepslate #2",
            "granite #3",
            "diorite #4",
            "andesite #5",
            "tuff #6",
            "calcite #7",
            "basalt #8",
            "blackstone #9",
            "netherrack #10",
            "end stone #11",
            "stone bricks #12",
            "dirt #13",
            "coarse dirt #14",
            "rooted dirt #15",
            "podzol #16",
            "mud #17",
            "clay #18",
            "sand #19",
            "gravel #20",
            "sandstone #21",
            "smooth stone #22",
            "moss block #23",
            "mossy cobblestone #24",
            "snow block #25",
            "ice #26",
            "packed ice #27",
            "oak planks #28",
            "spruce planks #29",
            "birch planks #30",
            "jungle planks #31",
            "acacia planks #32",
            "dark oak planks #33",
            "mangrove planks #34",
            "cherry planks #35",
            "crimson planks #36",
            "warped planks #37",
            "bricks #38",
            "terracotta #39",
            "cobblestone #40",
            "cobbled deepslate #41",
            "copper block #42",
            "prismarine #43",
            "amethyst block #44",
            "white concrete #45",
            "quartz block #46",
            "smooth sandstone #47",
            "chiseled stone bricks #48",
            "nether bricks #49",

            "glimmerstone #50",
            "glimmerstone cobblestone #51",
            "glimmerstone bricks #52",
            "glimmerstone pillar#53",
            "glimmerstone engraved #54",
            "ancient gravel #55",
            "ancient sand #56",
            "ancient silt #57",
            "ancient loam #58",
            "ancient mud #59",
            "ancient clay #60",
            "ancient moist clay #61",
            "mud bricks  #62",
            "kiln burnt bricks #63"
    };

    public TrapConcealerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§eShift Right§r or §eRight Click§r to Cycle Different States"));
            tooltip.add(Text.literal("§eRight Click§r on Arcane Blocks to Change their BlockState!"));
        } else {
            tooltip.add(Text.literal("Press §eSHIFT§r for more Information"));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int currentModel = nbt.getInt("SelectedModel");
            int maxModels = MODEL_NAMES.length;

            int next = (player.isSneaking() ? currentModel - 1 + maxModels : currentModel + 1) % maxModels;

            nbt.putInt("SelectedModel", next);
            stack.setNbt(nbt);

            player.sendMessage(Text.literal(MODEL_NAMES[next]), true);
        }

        return TypedActionResult.success(stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = context.getStack();

        Block block = state.getBlock();

        if (block instanceof ArcaneBlock) {
            IntProperty switchProperty = ArcaneBlock.SWITCH_STATE;

            NbtCompound nbt = stack.getOrCreateNbt();
            int selectedModel = nbt.getInt("SelectedModel");

            if (selectedModel >= MODEL_NAMES.length) selectedModel = 0;

            BlockState newState = state.with(switchProperty, selectedModel);
            world.playSound(player, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (player instanceof ServerPlayerEntity serverPlayer) {
                Criteria.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
                serverPlayer.sendMessage(Text.literal("Applied Model: " + MODEL_NAMES[selectedModel]), true);
            }

            world.setBlockState(pos, newState, Block.REDRAW_ON_MAIN_THREAD | Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, newState));

            stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));

            return ActionResult.success(world.isClient);
        }


        return ActionResult.PASS;
    }
}