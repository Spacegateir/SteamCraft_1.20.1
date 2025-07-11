package net.spacegateir.steamcraft.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.List;

public class CelestialGearforgedShieldItem extends ShieldItem implements IToolWithBuffAndMode {

    public static final String BUFF_COOLDOWN_KEY = "buffCooldown";
    private static final String WALL_COOLDOWN_KEY = "CelestialWallCooldown";
    private static final String BUFF_ACTIVE_KEY = "CelestialBuffActive";

    public static final int BUFF_DURATION_TICKS = 20 * 60;       // 1 minute
    public static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 15;  // 15 minutes
    private static final int WALL_COOLDOWN_TICKS = 20 * 60 * 6;   // 6 minutes

    public CelestialGearforgedShieldItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Shield Abilities:"));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eShift + Look Down + Right Click:§r activate §dShield Wall§7"));
            tooltip.add(Text.literal("   §8• Creates a protective wall"));
            tooltip.add(Text.literal("   §8• 6 minute cooldown"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dResistance Buff§7"));
            tooltip.add(Text.literal("   §8• Grants Resistance V for 1 minute"));
            tooltip.add(Text.literal("   §8• Works in main hand or equipped with Celestial Swords"));
            tooltip.add(Text.literal("   §8• 15 minute cooldown"));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability info"));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        long currentTime = world.getTime();
        NbtCompound nbt = stack.getOrCreateNbt();

        if (!world.isClient && user.isSneaking() && user.getPitch() > 60.0f && stack.isOf(this)) {
            long wallCooldownEnd = nbt.getLong(WALL_COOLDOWN_KEY);

            if (currentTime >= wallCooldownEnd) {
                createShieldWall(world, user);
                nbt.putLong(WALL_COOLDOWN_KEY, currentTime + WALL_COOLDOWN_TICKS);
                user.sendMessage(Text.literal("§bShield Wall activated! Cooldown started."), true);
                return TypedActionResult.success(stack, world.isClient());
            } else {
                long secondsLeft = (wallCooldownEnd - currentTime) / 20;
                user.sendMessage(Text.literal("§cShield Wall on cooldown: " + secondsLeft + "s remaining"), true);
                return TypedActionResult.fail(stack);
            }
        }

        return super.use(world, user, hand);
    }


    public static void applyBuffAbility(PlayerEntity player, ItemStack stack) {
        long currentTime = player.getWorld().getTime();
        NbtCompound nbt = stack.getOrCreateNbt();
        long cooldownEnd = nbt.getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, BUFF_DURATION_TICKS, 4));
            nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);
            nbt.putBoolean(BUFF_ACTIVE_KEY, true);
            player.sendMessage(Text.literal("§bResistance Buff activated!"), true);
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            checkAndRemoveExpiredBuff(player);
        }
    }

    private void checkAndRemoveExpiredBuff(PlayerEntity player) {
        for (Hand hand : Hand.values()) {
            ItemStack stack = player.getStackInHand(hand);
            if (!(stack.getItem() instanceof CelestialGearforgedShieldItem)) continue;

            boolean hasBuff = player.hasStatusEffect(StatusEffects.RESISTANCE) &&
                    player.getStatusEffect(StatusEffects.RESISTANCE).getAmplifier() >= 4;

            boolean wasBuffActive = stack.getOrCreateNbt().getBoolean(BUFF_ACTIVE_KEY);

            if (hasBuff) {
                stack.getOrCreateNbt().putBoolean(BUFF_ACTIVE_KEY, true);
            } else if (wasBuffActive) {
                player.sendMessage(Text.literal("§cResistance Buff has expired."), true);
                stack.getOrCreateNbt().putBoolean(BUFF_ACTIVE_KEY, false);
            }
        }
    }

    public static void createShieldWall(World world, PlayerEntity player) {
        BlockPos basePos = player.getBlockPos();
        int radius = 9;
        int thickness = 1;
        Block earthSpikeBlock = ModBlocks.EARTH_WALL_BLOCK;
        BlockState earthSpikeState = earthSpikeBlock.getDefaultState();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                double dist = Math.sqrt(dx * dx + dz * dz);
                if (dist >= radius - thickness && dist <= radius + 0.5) {
                    for (int dy = -5; dy <= 5; dy++) {
                        BlockPos pos = basePos.add(dx, dy, dz);

                        if (world.isAir(pos) || world.getBlockState(pos).isReplaceable() || !world.getBlockState(pos).isSolidBlock(world, pos)) {
                            world.setBlockState(pos, earthSpikeState, 3);
                            earthSpikeBlock.onPlaced(world, pos, earthSpikeState, player, player.getMainHandStack());
                        }
                    }
                }
            }
        }

        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_STONE_BREAK, player.getSoundCategory(), 0.25f, 0.25f);
    }

    public static ItemStack getShieldStackInHands(PlayerEntity player) {
        ItemStack main = player.getMainHandStack();
        if (main.isOf(ModItems.CELESTIAL_GEARFORGED_SHIELD)) return main;

        ItemStack off = player.getOffHandStack();
        if (off.isOf(ModItems.CELESTIAL_GEARFORGED_SHIELD)) return off;

        return ItemStack.EMPTY;
    }


    @Override
    public boolean canActivateBuff(PlayerEntity player) {
        ItemStack stack = getShieldStackInHands(player);
        if (stack.isEmpty()) return false;

        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = player.getWorld().getTime();
        long cooldownEnd = nbt.getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            return true;
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cShield Buff still on cooldown: " + secondsLeft + "s remaining."), true);
            return false;
        }
    }

    @Override
    public void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = getShieldStackInHands(player);
        if (stack.isEmpty()) return;

        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = player.getWorld().getTime();

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, BUFF_DURATION_TICKS, 4));
        nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);

        player.sendMessage(Text.literal("§bBuff activated! Resistance V for 1 minute."), true);//activation
        player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 1.0f, 1.0f);
    }

    @Override
    public boolean canSwitchMode(PlayerEntity player) {
        return false;
    }

    @Override
    public void switchMode(PlayerEntity player) {
        // Mode switching not supported
    }
}
