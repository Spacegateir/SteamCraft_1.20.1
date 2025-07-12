package net.spacegateir.steamcraft.item.tools;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.tools.hammer_classes.*;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.util.MiningMode;
import net.spacegateir.steamcraft.util.ModTags;
import net.spacegateir.steamcraft.util.ShearsMode;

import java.util.*;

public class CelestialGearforgedPickaxeItem extends PickaxeItem implements IToolWithBuffAndMode{

    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";
    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;                          // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;                         // 20 minutes
    private static final String VEIN_ACTIVE_UNTIL_KEY = "VeinMiningActiveUntil";
    private static final String VEIN_COOLDOWN_KEY = "VeinMiningCooldown";
    private static final String MODE_KEY = "MiningMode";
    private static final int BASE_VEIN_BLOCKS = 16;             // Base max number of blocks mined during vein mining without buff 16
    private static final int VEIN_RADIUS = 10;                  // Radius around the origin block to search for vein mining blocks 10



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
            tooltip.add(Text.literal("§7- Go to §cpickaxe_mining_mode§7 tag to add blocks usable by the §dMining Mode Ability§7"));
            tooltip.add(Text.literal("§7- Go to §cpickaxe_ores§7 tag to add blocks usable by the §dVein Mining Ability§7"));
            tooltip.add(Text.literal("§7- Go to §cpickaxe_efficient§7 tag to add blocks for 2x increase in §dMining Speed§7"));

        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eShift + Right-Click in Air:§r to change §dMining Mode§7"));
            tooltip.add(Text.literal("   §8• Changes modes 1x1, 1x2, 1x3, 3x3"));
            tooltip.add(Text.literal("   §8• Buff gives 5x5 and 7x7 for 5 minutes"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click on Block:§r §dVein Mining Ability§7"));
            tooltip.add(Text.literal("   §8• Vein mining active for 5 minutes or 10 minutes with Buff"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown, or 10 minutes with Buff"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Haste 3 for 5 minutes"));
            tooltip.add(Text.literal("   §8• 20 minute cooldown"));
            tooltip.add(Text.literal("   §8• Grants Resistance V for 1 minute when Celestial Shield is equipped"));
            tooltip.add(Text.literal("   §8• 15 minutes cooldown"));
            tooltip.add(Text.literal("   §8• Reduces cooldowns of pickaxe abilities"));

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

    private MiningMode getMode(ItemStack stack) {
        String modeName = stack.getOrCreateNbt().getString(MODE_KEY);
        try {
            return MiningMode.valueOf(modeName);
        } catch (IllegalArgumentException e) {
            return MiningMode.X1;
        }
    }

    private void setMode(ItemStack stack, MiningMode mode) {
        stack.getOrCreateNbt().putString(MODE_KEY, mode.name());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();

        checkAndResetModeIfBuffExpired(player, stack);

        if (world.isClient || player == null) return super.useOnBlock(context);

        if (player.isSneaking()) {
            if (isOnCooldown(stack, VEIN_COOLDOWN_KEY, world)) {
                boolean hasBuff = hasValidBuff(player);
                long totalCooldown = hasBuff ? 20 * 60 * 10 : 20 * 60 * 20;
                long secondsLeft = getCooldownSecondsRemaining(stack, VEIN_COOLDOWN_KEY, world);

                player.sendMessage(Text.literal(
                        "§cVein Mining on cooldown: " + secondsLeft + "s remaining (Max Cooldown: " + (totalCooldown / 20) + "s)"
                ), true);
            } else {
                long duration = toggleVeinMining(player, stack, world);
                long minutes = duration / (20 * 60);
                player.sendMessage(Text.literal("§bVein Mining activated for " + minutes + " minute(s)!"), true);
            }
        }


        return ActionResult.SUCCESS;
    }

    private static boolean hasValidBuff(PlayerEntity player) {
        StatusEffectInstance effect = player.getStatusEffect(StatusEffects.HASTE);
        return effect != null && effect.getAmplifier() >= 2;
    }

    private long toggleVeinMining(PlayerEntity player, ItemStack stack, World world) {
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        boolean hasBuff = hasValidBuff(player);
        long duration = hasBuff ? 20 * 60 * 10 : 20 * 60 * 5;
        long cooldown = hasBuff ? 20 * 60 * 10 : 20 * 60 * 20;

        nbt.putLong(VEIN_ACTIVE_UNTIL_KEY, currentTime + duration);
        nbt.putLong(VEIN_COOLDOWN_KEY, currentTime + cooldown);

        return duration; // ✅ Now matches method return type
    }


    private boolean isOnCooldown(ItemStack stack, String key, World world) {
        return world.getTime() < stack.getOrCreateNbt().getLong(key);
    }

    private long getCooldownSecondsRemaining(ItemStack stack, String key, World world) {
        long ticksLeft = stack.getOrCreateNbt().getLong(key) - world.getTime();
        return Math.max(ticksLeft / 20, 0); // Convert ticks to seconds, prevent negatives
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
            player.sendMessage(Text.literal("§aPickaxe Buff active! Cooldown started."), true);

            // Buff shield if equipped
            ItemStack offhandStack = player.getOffHandStack();
            if (offhandStack.getItem() instanceof IToolWithBuffAndMode tool) {
                tool.applyBuffAbility(player);
            }

        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cPickaxe Buff on cooldown: " + secondsLeft + "s remaining"), true);
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

        MiningMode currentMode = getMode(stack);

        // Check if player has the necessary buff
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() >= 2;

        // Define allowed modes based on buff status
        List<MiningMode> allowedModes = new ArrayList<>();
        allowedModes.add(MiningMode.X1);
        allowedModes.add(MiningMode.X1X2);
        allowedModes.add(MiningMode.X1X3);
        allowedModes.add(MiningMode.X3);
        if (hasBuff) {
            allowedModes.add(MiningMode.X5);
            allowedModes.add(MiningMode.X7);
        }

        // Find the index of the current mode and go to the next one
        int currentIndex = allowedModes.indexOf(currentMode);
        int nextIndex = (currentIndex + 1) % allowedModes.size();
        MiningMode nextMode = allowedModes.get(nextIndex);

        // Update mode
        setMode(stack, nextMode);
        player.sendMessage(Text.literal("§bMining Mode set to: §e§o" + nextMode.getDisplayName()), true);
    }

    public static MiningMode getMiningMode(ItemStack stack, PlayerEntity player) {
        NbtCompound nbt = stack.getOrCreateNbt();
        String modeStr = nbt.getString(MODE_KEY);
        MiningMode mode;
        try {
            mode = MiningMode.valueOf(modeStr);
        } catch (Exception e) {
            mode = MiningMode.X1;
        }

        // If mode is FIVE_BY_FIVE or SEVEN_BY_SEVEN but player does NOT have Haste 3 buff, reset mode to ONE_BY_ONE
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2;

        if ((mode == MiningMode.X5 || mode == MiningMode.X7) && !hasBuff) {
            mode = MiningMode.X1;
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

    private List<BlockPos> getBlocksFromHammerClass(BlockPos origin, Direction face, MiningMode mode, ServerPlayerEntity player) {
        return switch (mode) {
            case X1 -> Collections.singletonList(origin);

            case X1X2 -> Hammer_1x2.getBlocksToBeDestroyed(origin, player);

            case X1X3 -> Hammer_1x3.getBlocksToBeDestroyed(origin, player);

            case X3 -> Hammer_3x3.getBlocksToBeDestroyed(origin, player);

            case X5 -> Hammer_5x5.getBlocksToBeDestroyed(origin, player);

            case X7 -> Hammer_7x7.getBlocksToBeDestroyed(origin, player);

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

    private void checkAndResetModeIfBuffExpired(PlayerEntity player, ItemStack stack) {
        MiningMode mode = getMode(stack);
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() == 2;

        if ((mode == MiningMode.X5 || mode == MiningMode.X7) && !hasBuff) {
            setMode(stack, MiningMode.X1);
            player.sendMessage(Text.literal("§cBuff expired! Mining mode reset to: §e" + MiningMode.X1.getDisplayName()), true);
        }
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            checkAndResetModeIfBuffExpired(player, stack);
        }
    }
}
