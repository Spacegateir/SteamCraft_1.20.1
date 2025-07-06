package net.spacegateir.steamcraft.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.tools.hammer_classes.*;
import net.spacegateir.steamcraft.util.MiningMode;
import net.spacegateir.steamcraft.util.ModTags;

import java.util.*;

public class CelestialGearforgedPickaxeItem extends PickaxeItem {

    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";  // NBT key to store the cooldown time for the pickaxe's buff ability
    private static final int BUFF_DURATION_TICKS = 60 * 20;                  // Duration of the buff in game ticks (60 seconds * 20 ticks per second)
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 5;             // Cooldown duration of the buff in ticks (5 minutes)
    private static final String VEIN_ACTIVE_UNTIL_KEY = "VeinMiningActiveUntil";  // NBT key for when vein mining is active until (game time)
    private static final String VEIN_COOLDOWN_KEY = "VeinMiningCooldown";         // NBT key for vein mining cooldown (game time)
    private static final String MODE_KEY = "MiningMode";                       // NBT key to store the current mining mode of the pickaxe
    private static final int BASE_VEIN_BLOCKS = 16;                            // Base max number of blocks mined during vein mining without buff
    private static final int VEIN_RADIUS = 10;                                 // Radius around the origin block to search for vein mining blocks



    public CelestialGearforgedPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        int efficiencyLevel = EnchantmentHelper.getLevel(Enchantments.EFFICIENCY, stack);
        float bonus = efficiencyLevel > 0 ? (float) (Math.pow(efficiencyLevel, 2) + 1) : 0;

        float baseSpeed;
        if (state.isOf(Blocks.DEEPSLATE) || state.isOf(Blocks.COBBLED_DEEPSLATE)) {
            baseSpeed = 40.0F;
        } else if (state.isIn(ModTags.Blocks.PICKAXE_EFFICIENT)) {
            baseSpeed = 24.0F;
        } else {
            baseSpeed = 12.0F;
        }

        return baseSpeed + bonus;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Pickaxe Abilities:"));

        if (Screen.hasShiftDown() && Screen.hasControlDown()) {
            tooltip.add(Text.literal("§7- Go to pickaxe_mining_mode tag to add blocks to the Mining Mode Ability" ));
            tooltip.add(Text.literal("§7- Go to pickaxe_ores tag to add blocks to the Vein Mining Ability"));

        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eRight-Click on Block:§r Mining Mode"));
            tooltip.add(Text.literal("   §8• Changes modes 1x1, 1x2, 1x3, 3x3"));
            tooltip.add(Text.literal("   §8• Buff gives 5x5 and 7x7 for 60 seconds"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click:§r Vein Mining Ability"));
            tooltip.add(Text.literal("   §8• Vein mining active for 5 minutes or 10 minutes with Buff"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown 10 minutes with Buff"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift Right Click:§r Activate Buff"));
            tooltip.add(Text.literal("   §8• Grants Haste 3 for 60 seconds"));
            tooltip.add(Text.literal("   §8• Reduces the cooldowns of pickaxe abilities"));

        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability details"));
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
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();

        if (!world.isClient && player != null) {
            long currentTime = world.getTime();

            if (Screen.hasControlDown() && Screen.hasShiftDown()) {
                applyBuffAbility(player);

            } else if (Screen.hasShiftDown()) {
                if (isOnCooldown(stack, VEIN_COOLDOWN_KEY, world)) {
                    long secondsLeft = getCooldownSecondsRemaining(stack, VEIN_COOLDOWN_KEY, world);
                    player.sendMessage(Text.literal("§cVein mining on cooldown: " + secondsLeft + "s remaining"), true);
                } else if (toggleVeinMining(player, stack, world)) {
                    player.sendMessage(Text.literal("§bVein mining activated!"), true);
                }

            } else {
                // Cycle mining mode
                NbtCompound nbt = stack.getOrCreateNbt();
                boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                        player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2;

                MiningMode current = getMiningMode(stack, player);
                MiningMode next = MiningMode.next(current, hasBuff);
                nbt.putString(MODE_KEY, next.name());

                player.sendMessage(Text.literal("§bSwitched to mode: §e" + next.name()), true);
            }
        }

        return ActionResult.SUCCESS;
    }


    private boolean toggleVeinMining(PlayerEntity player, ItemStack stack, World world) {
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2;

        long duration = hasBuff ? 20 * 60 * 10 : 20 * 60 * 5;      // 10 or 5 mins
        long cooldown = hasBuff ? 20 * 60 * 10 : 20 * 60 * 20;     // 10 or 20 mins

        nbt.putLong(VEIN_ACTIVE_UNTIL_KEY, currentTime + duration);
        nbt.putLong(VEIN_COOLDOWN_KEY, currentTime + cooldown);

        return true;
    }
    private boolean isOnCooldown(ItemStack stack, String key, World world) {
        return world.getTime() < stack.getOrCreateNbt().getLong(key);
    }

    private long getCooldownSecondsRemaining(ItemStack stack, String key, World world) {
        long ticksLeft = stack.getOrCreateNbt().getLong(key) - world.getTime();
        return Math.max(ticksLeft / 20, 0); // Convert ticks to seconds, prevent negatives
    }



    private void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        long currentTime = player.getWorld().getTime();
        long cooldownEnd = stack.getOrCreateNbt().getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, BUFF_DURATION_TICKS, 2));
            stack.getOrCreateNbt().putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);
            player.sendMessage(Text.literal("§bBuff active! Cooldown started."), true);
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }

    public static MiningMode getMiningMode(ItemStack stack, PlayerEntity player) {
        NbtCompound nbt = stack.getOrCreateNbt();
        String modeStr = nbt.getString(MODE_KEY);
        MiningMode mode;
        try {
            mode = MiningMode.valueOf(modeStr);
        } catch (Exception e) {
            mode = MiningMode.ONE_BY_ONE;
        }

        // If mode is FIVE_BY_FIVE or SEVEN_BY_SEVEN but player does NOT have Haste 3 buff, reset mode to ONE_BY_ONE
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2;

        if ((mode == MiningMode.FIVE_BY_FIVE || mode == MiningMode.SEVEN_BY_SEVEN) && !hasBuff) {
            mode = MiningMode.ONE_BY_ONE;
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

            if (currentTime < activeUntil && isPickaxeMinable(state)) {
                performVeinMining(world, player, stack, pos, state.getBlock(), stack);
                return true;
            }

            // Get current mode and facing direction
            MiningMode mode = getMiningMode(stack, (PlayerEntity) miner);
            Direction face = player.getHorizontalFacing().getOpposite();

            // Get blocks to destroy using the hammer classes or fallback
            List<BlockPos> area = getBlocksFromHammerClass(pos, face, mode, player);

            int broken = 0;
            for (BlockPos bp : area) {
                if (!bp.equals(pos)) {
                    BlockState target = world.getBlockState(bp);
                    if (!target.isAir() && isEffectiveOn(target)) {
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

    private void performVeinMining(World world, PlayerEntity player, ItemStack tool, BlockPos origin, Block targetBlock, ItemStack stack) {
        int radius = VEIN_RADIUS;
        int max = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2 ? BASE_VEIN_BLOCKS * 2 : BASE_VEIN_BLOCKS;

        Set<BlockPos> visited = new HashSet<>();
        for (BlockPos pos : BlockPos.iterateOutwards(origin, radius, radius, radius)) {
            if (visited.size() >= max) break;
            if (pos.getSquaredDistance(origin) > radius * radius) continue;

            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == targetBlock && isPickaxeMinable(state) && !visited.contains(pos)) {
                visited.add(pos);
                world.breakBlock(pos, true, player);
                stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
            }
        }
    }

    private boolean isEffectiveOn(BlockState state) {
        return state.getHardness(null, null) != -1 && state.isIn(ModTags.Blocks.PICKAXE_MINING_MODE);
    }

    private boolean isPickaxeMinable(BlockState state) {
        return state.isIn(ModTags.Blocks.PICKAXE_ORES);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos origin, Direction face, MiningMode mode) {
        List<BlockPos> positions = new ArrayList<>();

        switch (mode) {
            case ONE_BY_ONE -> positions.add(origin);

            case ONE_BY_TWO -> {
                for (int y = -1; y <= 0; y++) {
                    positions.add(offset(origin, face, 0, y));
                }
            }

            case ONE_BY_THREE -> {
                for (int y = -1; y <= 1; y++) {
                    positions.add(offset(origin, face, 0, y));
                }
            }

            case THREE_BY_THREE -> {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }

            case FIVE_BY_FIVE -> {
                for (int x = -2; x <= 2; x++) {
                    for (int y = -2; y <= 2; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }

            case SEVEN_BY_SEVEN -> {
                for (int x = -3; x <= 3; x++) {
                    for (int y = -3; y <= 3; y++) {
                        positions.add(offset(origin, face, x, y));
                    }
                }
            }
        }

        return positions;
    }

    private List<BlockPos> getBlocksFromHammerClass(BlockPos origin, Direction face, MiningMode mode, ServerPlayerEntity player) {
        return switch (mode) {
            case ONE_BY_ONE -> Collections.singletonList(origin);

            case ONE_BY_TWO -> Hammer_1x2.getBlocksToBeDestroyed(origin, player);

            case ONE_BY_THREE -> Hammer_1x3.getBlocksToBeDestroyed(origin, player);

            case THREE_BY_THREE -> Hammer_3x3.getBlocksToBeDestroyed(origin, player);

            case FIVE_BY_FIVE -> Hammer_5x5.getBlocksToBeDestroyed(origin, player);

            case SEVEN_BY_SEVEN -> Hammer_7x7.getBlocksToBeDestroyed(origin, player);

            default -> getBlocksToBeDestroyed(origin, face, mode);  // fallback if needed
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
