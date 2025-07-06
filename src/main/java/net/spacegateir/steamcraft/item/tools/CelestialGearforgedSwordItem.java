package net.spacegateir.steamcraft.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.List;
import java.util.Random;

public class CelestialGearforgedSwordItem extends SwordItem {

    private static final Random RANDOM = new Random();

    private static final String BUFF_COOLDOWN_KEY = "buffCooldown";
    private static final String BUFF_END_TIME_KEY = "buffEndTime";
    private static final String JUMP_EARTH_FLAG_KEY = "HasJumped";
    private static final String EARTH_SPIKE_LAST_USED_KEY = "earth_spike_last_used";
    private static final long COOLDOWN_TICKS = 2400;        // 120 seconds
    private static final long BUFFED_COOLDOWN_TICKS = 1200; // 60 seconds
    public CelestialGearforgedSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Sword Abilities:"));

        if (Screen.hasShiftDown()) {
            // Show full abilities when Shift is held
            tooltip.add(Text.literal("§7- §eRight-Click:§r Roar of the King"));
            tooltip.add(Text.literal("   §8• Knocks back, damages and debuff enemies"));
            tooltip.add(Text.literal("   §8• 10 seconds cooldown 5 seconds with buff"));

            tooltip.add(Text.literal("§7- §eShift + Right-Click:§r Activate Buff"));
            tooltip.add(Text.literal("   §8• Grants Speed I and Strength III for 60 seconds"));
            tooltip.add(Text.literal("   §8• 4-minute cooldown"));

            tooltip.add(Text.literal("§7- §eSneak + Look Down:§r Sanctum +"));
            tooltip.add(Text.literal("   §8• Creates a earthly ring around you"));
            tooltip.add(Text.literal("   §8• 2-minute cooldown 60 seconds with buff"));

            tooltip.add(Text.literal("§7- §dPassive:§r Healing Grace +"));
            tooltip.add(Text.literal("   §8• Heals you based on damage dealt"));
            tooltip.add(Text.literal("   §8• Heals more when buff is active"));

            tooltip.add(Text.literal("§7- §dPassive:§r Tempest Wrath"));
            tooltip.add(Text.literal("   §8• Chance to summon lightning on hit during rainfall"));
            tooltip.add(Text.literal("   §8• Also triggers without rain if buff is active"));
        } else {
            // Show hint when Shift is not held
            tooltip.add(Text.literal("§7Hold §eShift §7for abilities details"));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();
        boolean buffActive = nbt.getLong(BUFF_END_TIME_KEY) > currentTime;

        // 1/5 chance to spawn lightning in rain or without rain if buffed ( When Raining (Passive))
        if (!world.isClient && (world.isRaining() || buffActive) && RANDOM.nextInt(3) == 0) {
            BlockPos pos = target.getBlockPos();
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.setPosition(pos.getX(), pos.getY(), pos.getZ());
            ((ServerWorld) world).spawnEntity(lightning);
        }

        // Heal attacker based on damage dealt ( Passive )
        if (!world.isClient && attacker != null && target != null) {
            float targetDamage = target.getMaxHealth() - target.getHealth();
            float healAmount = targetDamage * (buffActive ? 0.75f : 0.5f);

            if (healAmount > 0 && attacker.getHealth() < attacker.getMaxHealth()) {
                attacker.heal(healAmount);

                if (attacker instanceof PlayerEntity player) {
                    player.sendMessage(
                            net.minecraft.text.Text.literal("You were healed for " + String.format("%.1f", healAmount) + " health."),
                            true
                    );
                }
            }
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        // Sneak + right-click = activate buff (Enhance Buff ability)
        if (!world.isClient && user.isSneaking()) {
            long cooldownTime = nbt.getLong(BUFF_COOLDOWN_KEY);

            if (cooldownTime <= currentTime) {
                // Apply buff
                nbt.putLong(BUFF_END_TIME_KEY, currentTime + 1200);    // 60 seconds
                nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + 4800);   // 4 minutes

                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 0));

                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, user.getSoundCategory(), 1.0f, 1.0f);

                user.sendMessage(
                        net.minecraft.text.Text.literal("§aBuff active! Cooldown started."), true
                );

                return new TypedActionResult<>(ActionResult.SUCCESS, stack);
            } else {
                // Cooldown remaining
                long ticksLeft = cooldownTime - currentTime;
                long secondsLeft = ticksLeft / 20;
                user.sendMessage(
                        net.minecraft.text.Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true
                );
                return new TypedActionResult<>(ActionResult.FAIL, stack);
            }
        }

        // Warden Roar (normal right-click)
        if (!world.isClient) {
            if (user.getItemCooldownManager().isCoolingDown(this)) {
                return new TypedActionResult<>(ActionResult.FAIL, stack);
            }

            boolean buffActive = nbt.getLong(BUFF_END_TIME_KEY) > currentTime;

            user.getItemCooldownManager().set(this, buffActive ? 100 : 200); // 5s or 10s cooldown
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_ROAR, user.getSoundCategory(), 3.0F, 1.0F);

            List<LivingEntity> targets = world.getEntitiesByClass(
                    LivingEntity.class,
                    new Box(user.getBlockPos()).expand(15.0),
                    entity -> entity != user && entity.isAlive() && !entity.isSpectator()
            );

            for (LivingEntity target : targets) {
                double dx = target.getX() - user.getX();
                double dz = target.getZ() - user.getZ();
                double dist = Math.sqrt(dx * dx + dz * dz);
                if (dist != 0) {
                    double strength = 2.0;
                    target.addVelocity(dx / dist * strength, 0.7, dz / dist * strength);
                    target.velocityModified = true;
                }

                target.damage(world.getDamageSources().playerAttack(user), 27.0F);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 150, 4));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 150, 0));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 150, 1));
            }

            Vec3d direction = user.getRotationVec(1.0F);
            Vec3d origin = user.getEyePos();
            double beamLength = 20.0;
            double step = 0.5;

            for (double d = 0; d < beamLength; d += step) {
                double x = origin.x + direction.x * d;
                double y = origin.y + direction.y * d;
                double z = origin.z + direction.z * d;

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.SONIC_BOOM,
                        x, y, z,
                        1,
                        0, 0, 0, 0
                );
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (world.isClient || !(entity instanceof PlayerEntity player)) return;

        ItemStack mainHandStack = player.getMainHandStack();
        boolean isHoldingSword = mainHandStack.isOf(ModItems.CELESTIAL_GEARFORGED_SWORD);

        if (!isHoldingSword) return;

        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        boolean isSneaking = player.isSneaking();
        boolean isLookingDown = player.getPitch() > 60.0f;
        boolean alreadyActivated = nbt.getBoolean(JUMP_EARTH_FLAG_KEY);
        long lastUsed = nbt.getLong(EARTH_SPIKE_LAST_USED_KEY);
        boolean buffActive = nbt.getLong(BUFF_END_TIME_KEY) > currentTime;
        long cooldownDuration = buffActive ? BUFFED_COOLDOWN_TICKS : COOLDOWN_TICKS;
        boolean isCooldownOver = (currentTime - lastUsed) >= cooldownDuration;

        if (isSneaking && isLookingDown && !alreadyActivated) {
            if (isCooldownOver) {
                activateEarthSpikes(world, player);
                nbt.putBoolean(JUMP_EARTH_FLAG_KEY, true);
                nbt.putLong(EARTH_SPIKE_LAST_USED_KEY, currentTime);

                player.sendMessage(
                        net.minecraft.text.Text.literal("§aEarth Spikes activated! Cooldown started."), true
                );
            } else {
                long ticksLeft = cooldownDuration - (currentTime - lastUsed);
                long secondsLeft = ticksLeft / 20;

                player.sendMessage(
                        net.minecraft.text.Text.literal("§cEarth Spikes on cooldown: " + secondsLeft + "s remaining"), true
                );
            }
        }

        if ((!isSneaking || !isLookingDown) && alreadyActivated) {
            nbt.putBoolean(JUMP_EARTH_FLAG_KEY, false);
        }
    }


    private void activateEarthSpikes(World world, PlayerEntity player) {
        BlockPos basePos = player.getBlockPos();
        int safeRadius = 3;
        int spikeRingRadius = 7;
        Block earthSpikeBlock = ModBlocks.EARTH_SPIKE_BLOCK;
        BlockState earthSpikeState = earthSpikeBlock.getDefaultState();

        for (int dx = -spikeRingRadius; dx <= spikeRingRadius; dx++) {
            for (int dz = -spikeRingRadius; dz <= spikeRingRadius; dz++) {
                double distance = Math.sqrt(dx * dx + dz * dz);
                if (distance <= safeRadius || distance > spikeRingRadius) continue;

                for (int dy = -3; dy <= 3; dy++) {
                    BlockPos groundPos = basePos.add(dx, dy - 1, dz);
                    BlockPos placePos = groundPos.up();

                    if (world.getBlockState(groundPos).isSolidBlock(world, groundPos) && world.isAir(placePos)) {
                        world.setBlockState(placePos, earthSpikeState, 3);

                        earthSpikeBlock.onPlaced(world, placePos, earthSpikeState, player, player.getMainHandStack());
                    }
                }
            }
        }

        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_STONE_BREAK, player.getSoundCategory(), 1.0f, 1.0f);
    }
}