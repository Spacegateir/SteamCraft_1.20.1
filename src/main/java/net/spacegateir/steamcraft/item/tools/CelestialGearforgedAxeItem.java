package net.spacegateir.steamcraft.item.tools;

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
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.LumberMode;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;

public class CelestialGearforgedAxeItem extends AxeItem {

    private static final String MODE_KEY = "LumberMode";

    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";
    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;   // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;   // 20 minutes

    public CelestialGearforgedAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Axe Abilities:"));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§7- §eRight-Click in Air:§r to change §dLumber Mode§7"));
            tooltip.add(Text.literal("   §8• Modes: Normal, Pillar, Lumber Jack"));
            tooltip.add(Text.literal("   §8• Lumber Mode: can also Strip Trees"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right Click:§r activate §dBuff§7"));
            tooltip.add(Text.literal("   §8• Grants Haste 2 for 5 minutes"));
            tooltip.add(Text.literal("   §8• Grants Speed 2 for 5 minutes"));
            tooltip.add(Text.literal("   §8• Cooldown for 20 minutes"));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for ability info"));
        }
    }

    public LumberMode getLumberMode(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            try {
                return LumberMode.valueOf(nbt.getString(MODE_KEY));
            } catch (Exception ignored) {}
        }
        return LumberMode.NORMAL;
    }

    public void setLumberMode(ItemStack stack, LumberMode mode) {
        stack.getOrCreateNbt().putString(MODE_KEY, mode.name());
    }

    // This method cycles the mode on right-click in air & implements the buff
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient && Screen.hasControlDown() && Screen.hasShiftDown()) {
            applyBuffAbility(player, stack);
            return TypedActionResult.success(stack, world.isClient);
        }

        // Mode switching only if not aiming at block
        if (!world.isClient && player != null) {
            if (player.raycast(5.0D, 0.0F, false).getType() == net.minecraft.util.hit.HitResult.Type.MISS) {
                LumberMode currentMode = getLumberMode(stack);
                LumberMode[] modes = LumberMode.values();
                int nextIndex = (currentMode.ordinal() + 1) % modes.length;
                LumberMode nextMode = modes[nextIndex];

                setLumberMode(stack, nextMode);
                player.sendMessage(Text.literal("§bLumber Mode set to: §e" + nextMode.getDisplayName()), true);

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

        // Handle buff activation
        if (!world.isClient && player != null && Screen.hasControlDown() && Screen.hasShiftDown()) {
            applyBuffAbility(player, stack);
            return ActionResult.SUCCESS;
        }

        // Handle lumber mode stripping
        if (!world.isClient && player != null) {
            LumberMode mode = getLumberMode(stack);
            BlockState state = world.getBlockState(pos);

            if (isTreeLog(state)) {
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
                            // Not a custom-strip target: fallback to vanilla AxeItem logic
                            return super.useOnBlock(context);
                        }
                    }
                }

                stack.damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                return ActionResult.SUCCESS;
            }
        }

        // Fallback to default AxeItem behavior (oxidation/wax removal/etc.)
        return super.useOnBlock(context);
    }

    // tree choping ability
    public boolean isLog(BlockState state) {
        return state.getBlock() instanceof PillarBlock;
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
        // changes the distance from the block that's broken allowing to are between so they don't need to touch
        for (BlockPos offset : BlockPos.iterateOutwards(pos, 2, 2, 2)) {
            if (!offset.equals(pos)) {
                breakTree(world, offset, player, visited);
            }
        }
    }


    // tree stripping ability
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

    // Buff Ability
    private void applyBuffAbility(PlayerEntity player, ItemStack stack) {
        long currentTime = player.getWorld().getTime();
        long cooldownEnd = stack.getOrCreateNbt().getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, BUFF_DURATION_TICKS, 1)); // Haste 2
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, BUFF_DURATION_TICKS, 1)); // Speed 2
            stack.getOrCreateNbt().putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);
            player.sendMessage(Text.literal("§bBuff active! Cooldown started."), true);
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }





}


