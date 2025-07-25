package net.spacegateir.steamcraft.item.tools;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
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
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.tools.hammer_classes.*;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.util.ModTags;
import net.spacegateir.steamcraft.util.TillingMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CelestialGearforgedHoeItem extends HoeItem implements IToolWithBuffAndMode{

    private static final String MODE_KEY = "TillingMode";
    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";

    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;      // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 15;     // 15 minutes

    protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS = Maps.<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>>newHashMap(
        ImmutableMap.of(
                Blocks.FARMLAND,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.GRASS_BLOCK,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.DIRT_PATH,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.DIRT,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.COARSE_DIRT,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.MYCELIUM,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.PODZOL,
                Pair.of(HoeItem::canTillFarmland, createTillAction(ModBlocks.FARMLAND_ENRICHED_BLOCK.getDefaultState())),
                Blocks.ROOTED_DIRT,
                Pair.of(itemUsageContext -> true, createTillAndDropAction(Blocks.DIRT.getDefaultState(), Items.HANGING_ROOTS))
        )
);

    public CelestialGearforgedHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Hoe Abilities:"));

        if (Screen.hasShiftDown() && Screen.hasControlDown()) {
            tooltip.add(Text.literal("§7- Go to §choe_tilling_mode§7 tag to add crops usable by the §dTilling Ability§7."));

        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §dPassive:§r for §dTilling§7"));
            tooltip.add(Text.literal("   §8• Change Dirt Types to Farmland Enriched Soil"));
            tooltip.add(Text.literal("   §8• Farmland Enriched Soil doesn't need water"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click in Air:§r to change §dTilling Mode§7"));
            tooltip.add(Text.literal("   §8• Effects Tilling area and Harvest area"));
            tooltip.add(Text.literal("   §8• Changes modes 1x1, 3x3, 5x5"));
            tooltip.add(Text.literal("   §8• Buff gives 7x7"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Haste 3 for 5 minutes"));
            tooltip.add(Text.literal("   §8• Cooldown for 20 minutes"));
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


    private TillingMode getMode(ItemStack stack) {
        String modeName = stack.getOrCreateNbt().getString(MODE_KEY);
        try {
            return TillingMode.valueOf(modeName);
        } catch (IllegalArgumentException e) {
            return TillingMode.X1;
        }
    }

    private void setMode(ItemStack stack, TillingMode mode) {
        stack.getOrCreateNbt().putString(MODE_KEY, mode.name());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        BlockPos origin = context.getBlockPos();

        if (player == null) return ActionResult.PASS;

        checkAndResetModeIfBuffExpired(player, stack);

        // ACTUAL TILLING ACTION
        if (!world.isClient) {
            TillingMode mode = getMode(stack);
            Direction playerFacing = player.getHorizontalFacing().getOpposite();
            List<BlockPos> area = getBlocksToBeDestroyed(origin, playerFacing, mode);

            int tilledCount = 0;

            for (BlockPos pos : area) {
                Block block = world.getBlockState(pos).getBlock();
                Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = TILLING_ACTIONS.get(block);

                if (pair != null) {
                    ItemUsageContext areaContext = new ItemUsageContext(player, context.getHand(), new BlockHitResult(
                            context.getHitPos(), context.getSide(), pos, false
                    ));

                    if (pair.getFirst().test(areaContext)) {
                        pair.getSecond().accept(areaContext);
                        tilledCount++;
                    }
                }
            }

            if (tilledCount > 0) {
                stack.damage(tilledCount, player, p -> p.sendToolBreakStatus(context.getHand()));
                return ActionResult.SUCCESS;
            }
        }

        return super.useOnBlock(context);
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
            player.sendMessage(Text.literal("§aHoe Buff active! Cooldown started."), true);

            // Buff shield if equipped
            ItemStack offhandStack = player.getOffHandStack();
            if (offhandStack.getItem() instanceof IToolWithBuffAndMode tool) {
                tool.applyBuffAbility(player);
            }

        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cHoe Buff on cooldown: " + secondsLeft + "s remaining"), true);
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

        TillingMode currentMode = getMode(stack);

        // Check if player has the necessary buff
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() >= 2;

        // Define allowed modes based on buff status
        List<TillingMode> allowedModes = new ArrayList<>();
        allowedModes.add(TillingMode.X1);
        allowedModes.add(TillingMode.X3);
        allowedModes.add(TillingMode.X5);
        if (hasBuff) {
            allowedModes.add(TillingMode.X7);
        }

        // Find the index of the current mode and go to the next one
        int currentIndex = allowedModes.indexOf(currentMode);
        int nextIndex = (currentIndex + 1) % allowedModes.size();
        TillingMode nextMode = allowedModes.get(nextIndex);

        // Update mode
        setMode(stack, nextMode);
        player.sendMessage(Text.literal("§bHoe Mode set to: §e§o" + nextMode.getDisplayName()), true);
    }


    private void checkAndResetModeIfBuffExpired(PlayerEntity player, ItemStack stack) {
        TillingMode mode = getMode(stack);
        boolean hasBuff = player.hasStatusEffect(StatusEffects.HASTE) &&
                player.getStatusEffect(StatusEffects.HASTE).getAmplifier() >= 2;

        if (!hasBuff && mode == TillingMode.X7) {
            setMode(stack, TillingMode.X1);
            player.sendMessage(Text.literal("§cBuff expired! Mode reverted to §e1x1"), true);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            checkAndResetModeIfBuffExpired(player, stack);
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof ServerPlayerEntity player) {
            TillingMode mode = getMode(stack);
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
        return state.getHardness(null, null) != -1 && state.isIn(ModTags.Blocks.HOE_TILLING_MODE);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos origin, Direction face, TillingMode mode) {
        List<BlockPos> positions = new ArrayList<>();

        switch (mode) {
            case X1 -> positions.add(origin);

            case X3 -> {
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        positions.add(offset(origin, face, x, z));
                    }
                }
            }

            case X5 -> {
                for (int x = -2; x <= 2; x++) {
                    for (int z = -2; z <= 2; z++) {
                        positions.add(offset(origin, face, x, z));
                    }
                }
            }

            case X7 -> {
                for (int x = -3; x <= 3; x++) {
                    for (int z = -3; z <= 3; z++) {
                        positions.add(offset(origin, face, x, z));
                    }
                }
            }
        }

        return positions;
    }

    private List<BlockPos> getBlocksFromHammerClass(BlockPos origin, Direction face, TillingMode mode, ServerPlayerEntity player) {
        return switch (mode) {
            case X1 -> Collections.singletonList(origin);
            case X3 -> Hammer_3x3.getBlocksToBeDestroyed(origin, player);
            case X5 -> Hammer_5x5.getBlocksToBeDestroyed(origin, player);
            case X7 -> Hammer_7x7.getBlocksToBeDestroyed(origin, player);
        };
    }

    private static BlockPos offset(BlockPos origin, Direction face, int xOffset, int zOffset) {
        return origin.add(xOffset, 0, zOffset);
    }



}

