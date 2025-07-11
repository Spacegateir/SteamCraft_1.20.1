package net.spacegateir.steamcraft.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.tools.hammer_classes.*;
import net.spacegateir.steamcraft.util.*;
import net.minecraft.item.ItemStack;

import java.util.*;

public class CelestialGearforgedShearsItem extends ShearsItem {

    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";
    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;

    private static final String VEIN_ACTIVE_UNTIL_KEY = "VeinShearingActiveUntil";
    private static final String VEIN_COOLDOWN_KEY = "VeinShearingCooldown";
    private static final String MODE_KEY = "ShearsMode";

    private static final int BASE_VEIN_BLOCKS = 64;
    private static final int VEIN_RADIUS = 64;

    public CelestialGearforgedShearsItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Shears Abilities:"));

        if (Screen.hasShiftDown() && Screen.hasControlDown()) {
            tooltip.add(Text.literal("§7- Go to §cshearing_mode§7 tag to add blocks usable by the §dShearing Mode Ability§7"));

        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eRight-Click in Air:§r to change §dShearing Mode§7"));
            tooltip.add(Text.literal("   §8• Changes modes 1x1, 3x3, 5x5"));
            tooltip.add(Text.literal("   §8• Buff gives 7x7 for 5 minutes"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click:§r §dVein Shearing Ability§7"));
            tooltip.add(Text.literal("   §8• Vein Shearing active for 5 minutes or 10 minutes with Buff"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown, or 10 minutes with Buff"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Jump Boost 3 for 5 minutes"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown"));
            tooltip.add(Text.literal("   §8• Reduces cooldowns of Shears abilities"));

        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability info"));
            tooltip.add(Text.literal("§7Hold §eShift + CTRL §7for tag details"));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && Screen.hasControlDown() && Screen.hasShiftDown()) {
            applyBuffAbility(user);
            return TypedActionResult.success(stack, world.isClient());
        }

        if (!world.isClient) {
            HitResult hit = user.raycast(5.0D, 0.0F, false);

            if (hit.getType() == HitResult.Type.MISS) {
                ShearsMode currentMode = getMode(stack);
                ShearsMode next = ShearsMode.next(currentMode, hasValidBuff(user));

                setMode(stack, next);
                user.sendMessage(Text.literal("§bShearing Mode set to: §e§o" + next.getDisplayName()), true);
                return TypedActionResult.success(stack);
            }
        }

        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();

        checkAndResetModeIfBuffExpired(player, stack);

        if (world.isClient || player == null) return super.useOnBlock(context);

        if (Screen.hasControlDown() && Screen.hasShiftDown()) {
            applyBuffAbility(player);
        } else if (Screen.hasShiftDown()) {
            if (isOnCooldown(stack, VEIN_COOLDOWN_KEY, world)) {
                long secondsLeft = getCooldownSecondsRemaining(stack, VEIN_COOLDOWN_KEY, world);
                player.sendMessage(Text.literal("§cVein All on cooldown: " + secondsLeft + "s remaining"), true);
            } else if (toggleVeinShearing(player, stack, world)) {
                player.sendMessage(Text.literal("§bVein All activated!"), true);
            }
        }

        return ActionResult.SUCCESS;
    }

    private ShearsMode getMode(ItemStack stack) {
        String modeName = stack.getOrCreateNbt().getString(MODE_KEY);
        try {
            return ShearsMode.valueOf(modeName);
        } catch (IllegalArgumentException e) {
            return ShearsMode.X1;
        }
    }

    private void setMode(ItemStack stack, ShearsMode mode) {
        stack.getOrCreateNbt().putString(MODE_KEY, mode.name());
    }

    private static boolean hasValidBuff(PlayerEntity player) {
        StatusEffectInstance effect = player.getStatusEffect(StatusEffects.JUMP_BOOST);
        return effect != null && effect.getAmplifier() >= 2;
    }

    private boolean toggleVeinShearing(PlayerEntity player, ItemStack stack, World world) {
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        long duration = hasValidBuff(player) ? 20 * 60 * 10 : 20 * 60 * 5;
        long cooldown = hasValidBuff(player) ? 20 * 60 * 10 : 20 * 60 * 20;

        nbt.putLong(VEIN_ACTIVE_UNTIL_KEY, currentTime + duration);
        nbt.putLong(VEIN_COOLDOWN_KEY, currentTime + cooldown);

        return true;
    }

    private boolean isOnCooldown(ItemStack stack, String key, World world) {
        return world.getTime() < stack.getOrCreateNbt().getLong(key);
    }

    private long getCooldownSecondsRemaining(ItemStack stack, String key, World world) {
        long ticksLeft = stack.getOrCreateNbt().getLong(key) - world.getTime();
        return Math.max(ticksLeft / 20, 0);
    }

    private void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        long currentTime = player.getWorld().getTime();
        long cooldownEnd = stack.getOrCreateNbt().getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, BUFF_DURATION_TICKS, 2));
            stack.getOrCreateNbt().putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);
            player.sendMessage(Text.literal("§bBuff active! Cooldown started."), true);
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }

    public static ShearsMode getShearingMode(ItemStack stack, PlayerEntity player) {
        NbtCompound nbt = stack.getOrCreateNbt();
        String modeStr = nbt.getString(MODE_KEY);
        ShearsMode mode;
        try {
            mode = ShearsMode.valueOf(modeStr);
        } catch (Exception e) {
            mode = ShearsMode.X1;
        }

        if (mode == ShearsMode.X7 && !hasValidBuff(player)) {
            mode = ShearsMode.X1;
            nbt.putString(MODE_KEY, mode.name());
        }


        return mode;
    }


    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof ServerPlayerEntity player) {
            long currentTime = world.getTime();
            NbtCompound nbt = stack.getOrCreateNbt();
            long activeUntil = nbt.getLong(VEIN_ACTIVE_UNTIL_KEY);

            if (currentTime < activeUntil && isShearsMinable(state)) {
                performVeinShearing(world, player, pos, state.getBlock(), stack);
                return true;
            }

            ShearsMode mode = getShearingMode(stack, player);
            Direction face = player.getHorizontalFacing().getOpposite();
            List<BlockPos> area = getBlocksFromHammerClass(pos, face, mode, player);

            int broken = 0;
            for (BlockPos bp : area) {
                if (!bp.equals(pos)) {
                    BlockState target = world.getBlockState(bp);
                    if (isEffectiveOn(target)) {
                        if (!player.isCreative()) {
                            world.breakBlock(bp, true, player);
                            broken++;
                        } else {
                            world.setBlockState(bp, Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }

            if (!player.isCreative() && broken > 0) {
                stack.damage(broken, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    private void performVeinShearing(World world, PlayerEntity player, BlockPos origin, Block targetBlock, ItemStack stack) {
        int radius = VEIN_RADIUS;
        int max = hasValidBuff(player) ? BASE_VEIN_BLOCKS * 2 : BASE_VEIN_BLOCKS;

        Set<BlockPos> visited = new HashSet<>();
        for (BlockPos pos : BlockPos.iterateOutwards(origin, radius, radius, radius)) {
            if (visited.size() >= max) break;
            if (pos.getSquaredDistance(origin) > radius * radius) continue;

            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == targetBlock && isShearsMinable(state) && !visited.contains(pos)) {
                visited.add(pos);
                world.breakBlock(pos, true, player);
                stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
            }
        }
    }

    private boolean isEffectiveOn(BlockState state) {
        return !state.isAir() && state.isIn(ModTags.Blocks.SHEARING_MODE);
    }

    private boolean isShearsMinable(BlockState state) {
        return state.isIn(ModTags.Blocks.SHEARING_MODE);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos origin, Direction face, ShearsMode mode) {
        List<BlockPos> positions = new ArrayList<>();

        switch (mode) {
            case X1 -> positions.add(origin);
            case X3 -> fillArea(positions, origin, face, 1);
            case X5 -> fillArea(positions, origin, face, 2);
            case X7 -> fillArea(positions, origin, face, 3);
        }

        return positions;
    }

    private static void fillArea(List<BlockPos> positions, BlockPos origin, Direction face, int range) {
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                positions.add(offset(origin, face, x, y));
            }
        }
    }

    private List<BlockPos> getBlocksFromHammerClass(BlockPos origin, Direction face, ShearsMode mode, ServerPlayerEntity player) {
        return switch (mode) {
            case X1 -> Collections.singletonList(origin);
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

    private void checkAndResetModeIfBuffExpired(PlayerEntity player, ItemStack stack) {
        ShearsMode mode = getMode(stack);
        if (!hasValidBuff(player) && mode == ShearsMode.X7) {
            setMode(stack, ShearsMode.X1);
            player.sendMessage(Text.literal("§cBuff expired! Mode reverted to §e1x1"), true);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            checkAndResetModeIfBuffExpired(player, stack);
        }
    }


}
