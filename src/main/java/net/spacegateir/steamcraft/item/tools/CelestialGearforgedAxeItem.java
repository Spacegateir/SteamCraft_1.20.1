package net.spacegateir.steamcraft.item.tools;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.util.LumberMode;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;


import java.util.List;
import java.util.Set;

public class CelestialGearforgedAxeItem extends AxeItem implements IToolWithBuffAndMode {

    private static final String MODE_KEY = "Lumbermode";
    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";

    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;    // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;   // 20 minutes

    public CelestialGearforgedAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Axe Abilities:"));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eShift + Right-Click in Air:§r to change §dLumber Mode§7"));
            tooltip.add(Text.literal("   §8• Modes: Normal, Pillar, Lumber Jack"));
            tooltip.add(Text.literal("   §8• Lumber Mode: can also Strip Trees"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Haste 2 for 5 minutes"));
            tooltip.add(Text.literal("   §8• Grants Speed 2 for 5 minutes"));
            tooltip.add(Text.literal("   §8• Cooldown for 20 minutes"));
            tooltip.add(Text.literal("   §8• Grants Resistance V for 1 minute when Celestial Shield is equipped"));
            tooltip.add(Text.literal("   §8• 15 minutes cooldown"));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability info"));
        }
    }

    public LumberMode getLumberMode(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        int modeIndex = nbt.contains(MODE_KEY) ? nbt.getInt(MODE_KEY) : 0;
        LumberMode[] modes = LumberMode.values();
        if (modeIndex < 0 || modeIndex >= modes.length) modeIndex = 0;
        return modes[modeIndex];
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (world.isClient) {
            boolean isSneaking = player.isSneaking();
            boolean isCtrlDown = Screen.hasControlDown();
            boolean isShiftDown = Screen.hasShiftDown();
            boolean isRightClickInAir = player.raycast(5.0D, 0.0F, false).getType() == net.minecraft.util.hit.HitResult.Type.MISS;

            if (isCtrlDown && isShiftDown) {
                ClientPlayNetworking.send(ModPackets.ACTIVATE_BUFF_PACKET_ID, PacketByteBufs.empty());
                return TypedActionResult.success(stack, true);
            }

            if (isSneaking && isRightClickInAir) {
                return TypedActionResult.success(stack, true);
            }

            return TypedActionResult.pass(stack);
        }

        // Server-side logic: no use of Screen or client-only classes!
        boolean isSneaking = player.isSneaking();
        boolean isRightClickInAir = player.raycast(5.0D, 0.0F, false).getType() == net.minecraft.util.hit.HitResult.Type.MISS;

        if (isSneaking && isRightClickInAir) {
            if (canSwitchMode(player)) {
                switchMode(player);
                player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.UI_BUTTON_CLICK.value(), player.getSoundCategory(), 0.5f, 1.0f);
                return TypedActionResult.success(stack);
            }
        }

        return TypedActionResult.pass(stack);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos();

        if (world.isClient || player == null) return ActionResult.PASS;

        LumberMode mode = getLumberMode(stack);
        BlockState state = world.getBlockState(pos);

        if (!isTreeLog(state)) {
            return super.useOnBlock(context);
        }

        switch (mode) {
            case PILLAR -> {
                stripPillar(world, pos, player);
                player.sendMessage(Text.literal("§2§l§oStripped Pillar"), true);
            }
            case LUMBER_JACK -> {
                stripTree(world, pos, player, new java.util.HashSet<>());
                player.sendMessage(Text.literal("§2§l§oStripped Tree"), true);
            }
            case NORMAL -> {
                if (isStrippableLog(state)) {
                    stripLog(world, pos, player);
                    player.sendMessage(Text.literal("§2§l§oStripped Log"), true);
                } else {
                    return super.useOnBlock(context);
                }
            }
        }

        stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
        return ActionResult.SUCCESS;
    }

    // Implement interface methods for buff and mode handling

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
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, BUFF_DURATION_TICKS, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, BUFF_DURATION_TICKS, 1));
            nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);

            player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 1.0f, 1.0f);
            player.sendMessage(Text.literal("§aAxe Buff active! Cooldown started."), true);

            // Buff shield if equipped
            ItemStack offhandStack = player.getOffHandStack();
            if (offhandStack.getItem() instanceof IToolWithBuffAndMode tool) {
                tool.applyBuffAbility(player);
            }

        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cAxe Buff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }



    @Override
    public boolean canSwitchMode(PlayerEntity player) {
        // Always allow switching mode
        return true;
    }

    @Override
    public void switchMode(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getOrCreateNbt();

        int currentMode = nbt.contains(MODE_KEY) ? nbt.getInt(MODE_KEY) : 0;
        int nextMode = (currentMode + 1) % LumberMode.values().length;
        nbt.putInt(MODE_KEY, nextMode);

        String modeName = LumberMode.values()[nextMode].getDisplayName();
        player.sendMessage(Text.literal("§bAxe Mode set to: §e§o" + modeName), true);
    }

    // -------------------------------------------------
    // Keep your existing tree chopping, stripping, and utility methods here unchanged
    // -------------------------------------------------

    public boolean isTreeLog(BlockState state) {
        Block block = state.getBlock();
        Identifier id = Registries.BLOCK.getId(block);
        return block instanceof PillarBlock &&
                (id.getPath().contains("_log") || id.getPath().contains("_wood") || id.getPath().contains("stripped_"));
    }

    public boolean isStrippableLog(BlockState state) {
        Block block = state.getBlock();
        Identifier id = Registries.BLOCK.getId(block);
        return block instanceof PillarBlock && !id.getPath().startsWith("stripped_");
    }

    public void stripLog(World world, BlockPos pos, PlayerEntity player) {
        BlockState state = world.getBlockState(pos);
        BlockState strippedState = getStrippedState(state);
        if (strippedState != null) {
            world.setBlockState(pos, strippedState);
        }
    }

    public void stripPillar(World world, BlockPos pos, PlayerEntity player) {
        BlockPos currentPos = pos;
        while (true) {
            BlockState state = world.getBlockState(currentPos);
            if (state.isAir() || !isStrippableLog(state)) break;
            stripLog(world, currentPos, player);
            currentPos = currentPos.up();
        }
    }

    public void stripTree(World world, BlockPos pos, PlayerEntity player, Set<BlockPos> visited) {
        if (visited.contains(pos)) return;

        BlockState state = world.getBlockState(pos);
        if (!isTreeLog(state)) return;

        visited.add(pos);

        if (isStrippableLog(state)) {
            stripLog(world, pos, player);
        }

        for (BlockPos offset : BlockPos.iterateOutwards(BlockPos.ORIGIN, 1, 1, 1)) {
            if (!offset.equals(BlockPos.ORIGIN)) {
                BlockPos neighbor = pos.add(offset);
                stripTree(world, neighbor, player, visited);
            }
        }
    }

    private BlockState getStrippedState(BlockState state) {
        Block block = state.getBlock();

        if (!(block instanceof PillarBlock)) return null;

        Identifier id = Registries.BLOCK.getId(block);

        if (id.getPath().startsWith("stripped_")) {
            return null;
        }

        Identifier strippedId = new Identifier(id.getNamespace(), "stripped_" + id.getPath());
        Block strippedBlock = Registries.BLOCK.getOrEmpty(strippedId).orElse(null);

        if (strippedBlock == null) return null;

        return strippedBlock.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS));
    }

    public boolean isLog(BlockState state) {
        // You already have isTreeLog() - just delegate
        return isTreeLog(state);
    }

    public void breakPillar(World world, BlockPos pos, PlayerEntity player) {
        BlockPos currentPos = pos;
        while (true) {
            BlockState state = world.getBlockState(currentPos);
            if (state.isAir() || !isLog(state)) break;
            world.breakBlock(currentPos, true, player);
            currentPos = currentPos.up();
        }
    }

    public void breakTree(World world, BlockPos pos, PlayerEntity player, Set<BlockPos> visited) {
        if (visited.contains(pos)) return;

        BlockState state = world.getBlockState(pos);
        if (!isLog(state)) return;

        visited.add(pos);

        world.breakBlock(pos, true, player);

        for (BlockPos offset : BlockPos.iterateOutwards(BlockPos.ORIGIN, 1, 1, 1)) {
            if (!offset.equals(BlockPos.ORIGIN)) {
                BlockPos neighbor = pos.add(offset);
                breakTree(world, neighbor, player, visited);
            }
        }
    }


    // You can add your other utility methods here as needed...

}
