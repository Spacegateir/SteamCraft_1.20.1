package net.spacegateir.steamcraft.item.tools;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.tools.hammer_classes.*;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.util.ModTags;
import net.spacegateir.steamcraft.util.ShovelMode;
import net.spacegateir.steamcraft.util.TillingMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CelestialGearforgedShovelItem extends ShovelItem implements IToolWithBuffAndMode{

    private static final String MODE_KEY = "ShovelMode";
    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";

    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;   // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;   // 20 minutes

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

    public CelestialGearforgedShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Shovel Abilities:"));

        if (Screen.hasShiftDown() && Screen.hasControlDown()) {
            tooltip.add(Text.literal("§7- Go to §cshovel_digging_mode§7 tag to add blocks usable by the §dShovel Mode Ability§7."));

        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eRight-Click:§r on select blocks for §dPathing§7"));
            tooltip.add(Text.literal("   §8• Dirt types, Stone Types, Clay, Sand Types and more"));
            tooltip.add(Text.literal("   §8• Shovel Mod effects Pathing"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click in Air:§r to change §dShovel Mode§7"));
            tooltip.add(Text.literal("   §8• Changes modes 1x1, 1x2, 1x3, 3x3"));
            tooltip.add(Text.literal("   §8• Buff gives 5x5 and 7x7"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Haste 3 for 5 minutes"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown"));
            tooltip.add(Text.literal("   §8• Grants Resistance V for 1 minute when Celestial Shield is equipped"));
            tooltip.add(Text.literal("   §8• 15 minutes cooldown"));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability info"));
            tooltip.add(Text.literal("§7Hold §eShift + CTRL §7for tag details"));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // --- CLIENT SIDE ---
        if (world.isClient) {
            boolean isSneaking = player.isSneaking();
            boolean isCtrlDown = Screen.hasControlDown();
            boolean isShiftDown = Screen.hasShiftDown();
            boolean isRightClickInAir = player.raycast(5.0D, 0.0F, false).getType() == net.minecraft.util.hit.HitResult.Type.MISS;

            // Buff Logic: Ctrl + Shift triggers client to send buff activation packet
            if (isCtrlDown && isShiftDown) {
                ClientPlayNetworking.send(ModPackets.ACTIVATE_BUFF_PACKET_ID, PacketByteBufs.empty());
                return TypedActionResult.success(stack, true); // Show use animation
            }

            // Prepare for Mode Switch: Sneaking + right click in air triggers animation only
            if (isSneaking && isRightClickInAir) {
                return TypedActionResult.success(stack, true); // Animation only
            }

            // Default: no special use
            return TypedActionResult.pass(stack);
        }

        // --- SERVER SIDE ---
        boolean isSneaking = player.isSneaking();
        boolean isRightClickInAir = player.raycast(5.0D, 0.0F, false).getType() == net.minecraft.util.hit.HitResult.Type.MISS;

        // Mode Switch Logic: Sneaking + right click in air
        if (isSneaking && isRightClickInAir) {
            if (canSwitchMode(player)) {
                switchMode(player);
                player.getWorld().playSound(
                        null,
                        player.getBlockPos(),
                        SoundEvents.UI_BUTTON_CLICK.value(),
                        player.getSoundCategory(),
                        0.5f,
                        1.0f
                );
                return TypedActionResult.success(stack); // Actually performs the switch
            }
        }

        // Default: item not used
        return TypedActionResult.pass(stack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos();

        ShovelMode mode = getMode(stack);
        Direction face = player.getHorizontalFacing().getOpposite();

        if (player instanceof ServerPlayerEntity serverPlayer) {
            List<BlockPos> area = getBlocksFromHammerClass(pos, face, mode, serverPlayer);

            for (BlockPos target : area) {
                BlockState state = world.getBlockState(target);
                if (PATH_STATES.containsKey(state.getBlock()) && world.getBlockState(target.up()).isAir()) {
                    world.setBlockState(target, PATH_STATES.get(state.getBlock()));
                    stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                }
            }
            return ActionResult.SUCCESS;
        }


        return super.useOnBlock(context);
    }

    private ShovelMode getMode(ItemStack stack) {
        String modeName = stack.getOrCreateNbt().getString(MODE_KEY);
        try {
            return ShovelMode.valueOf(modeName);
        } catch (IllegalArgumentException e) {
            return ShovelMode.X1;
        }
    }

    private void setMode(ItemStack stack, ShovelMode mode) {
        stack.getOrCreateNbt().putString(MODE_KEY, mode.name());
    }

    @Override
    public boolean canActivateBuff(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getOrCreateNbt();
        long cooldownTime = nbt.getLong(BUFF_COOLDOWN_KEY);
        long currentTime = player.getWorld().getTime();
        return cooldownTime <= currentTime;
    }

    @Override
    public void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = player.getInventory().getMainHandStack();
        NbtCompound nbt = stack.getOrCreateNbt();

        long currentTime = player.getWorld().getTime();
        long cooldownEnd = nbt.getLong(BUFF_COOLDOWN_KEY);

        System.out.println("CurrentTime: " + currentTime + ", CooldownEnd: " + cooldownEnd);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, BUFF_DURATION_TICKS, 2));
            nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);

            player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 1.0f, 1.0f);
            player.sendMessage(Text.literal("§aShovel Buff active! Cooldown started."), true);

            // Buff shield if equipped
            ItemStack offhandStack = player.getOffHandStack();
            if (offhandStack.getItem() instanceof IToolWithBuffAndMode tool) {
                tool.applyBuffAbility(player);
            }

        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cShovel Buff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }

    @Override
    public boolean canSwitchMode(PlayerEntity player) {
        return true;
    }

    @Override
    public void switchMode(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getOrCreateNbt();

        ShovelMode currentMode = getMode(stack);

        // Check if player has the necessary buff
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() >= 2;

        // Define allowed modes based on buff status
        List<ShovelMode> allowedModes = new ArrayList<>();
        allowedModes.add(ShovelMode.X1);
        allowedModes.add(ShovelMode.X1X2);
        allowedModes.add(ShovelMode.X1X3);
        allowedModes.add(ShovelMode.X3);
        if (hasBuff) {
            allowedModes.add(ShovelMode.X5);
            allowedModes.add(ShovelMode.X7);
            }

            // Find the index of the current mode and go to the next one
            int currentIndex = allowedModes.indexOf(currentMode);
            int nextIndex = (currentIndex + 1) % allowedModes.size();
            ShovelMode nextMode = allowedModes.get(nextIndex);

            // Update mode
            setMode(stack, nextMode);
            player.sendMessage(Text.literal("§bShovel Mode set to: §e§o" + nextMode.getDisplayName()), true);
        }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof ServerPlayerEntity player) {
            ShovelMode mode = getMode(stack);
            Direction face = player.getHorizontalFacing().getOpposite();

            List<BlockPos> area = getBlocksFromHammerClass(pos, face, mode, player);

            for (BlockPos bp : area) {
                if (!bp.equals(pos)) {
                    BlockState target = world.getBlockState(bp);
                    if (!target.isAir() && isEffectiveOn(target)) {
                        world.breakBlock(bp, true, player);
                    }
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    private boolean isEffectiveOn(BlockState state) {
        return state.getHardness(null, null) != -1 && state.isIn(ModTags.Blocks.SHOVEL_DIGGING_MODE);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos origin, Direction face, ShovelMode mode) {
        List<BlockPos> positions = new ArrayList<>();

        switch (mode) {
            case X1 -> positions.add(origin);

            case X1X2 -> {
                for (int y = -1; y <= 0; y++) {
                    positions.add(offset(origin, face, 0, y));
                }
            }

            case X1X3 -> {
                for (int y = -1; y <= 1; y++) {
                    positions.add(offset(origin, face, 0, y));
                }
            }

            case X3 -> {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }

            case X5 -> {
                for (int x = -2; x <= 2; x++) {
                    for (int y = -2; y <= 2; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }

            case X7 -> {
                for (int x = -3; x <= 3; x++) {
                    for (int y = -3; y <= 3; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }
        }

        return positions;
    }

    private List<BlockPos> getBlocksFromHammerClass(BlockPos origin, Direction face, ShovelMode mode, ServerPlayerEntity player) {
        return switch (mode) {
            case X1 -> Collections.singletonList(origin);

            case X1X2 -> Hammer_1x2.getBlocksToBeDestroyed(origin, player);

            case X1X3 -> Hammer_1x3.getBlocksToBeDestroyed(origin, player);

            case X3 -> Hammer_3x3.getBlocksToBeDestroyed(origin, player);

            case X5 -> Hammer_5x5.getBlocksToBeDestroyed(origin, player);

            case X7 -> Hammer_7x7.getBlocksToBeDestroyed(origin, player);

            default -> getBlocksToBeDestroyed(origin, face, mode);
        };
    }

    private static BlockPos offset(BlockPos origin, Direction face, int xOffset, int yOffset) {
        return switch (face) {
            case UP, DOWN -> origin.add(xOffset, 0, yOffset);
            case NORTH, SOUTH -> origin.add(xOffset, yOffset, 0);
            case EAST, WEST -> origin.add(0, yOffset, xOffset);
            default -> origin;
        };
    }
}
