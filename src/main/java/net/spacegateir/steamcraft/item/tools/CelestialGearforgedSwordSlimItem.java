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

public class CelestialGearforgedSwordSlimItem extends SwordItem implements IToolWithBuffAndMode{

    private static final Random RANDOM = new Random();

    private static final String BUFF_COOLDOWN_KEY = "buffCooldown";
    private static final String BUFF_END_TIME_KEY = "buffEndTime";

    private static final String JUMP_EARTH_FLAG_KEY = "HasJumped";
    private static final String EARTH_SPIKE_LAST_USED_KEY = "earth_spike_last_used";

    private static final long COOLDOWN_TICKS = 2400;        // 120 seconds
    private static final long BUFFED_COOLDOWN_TICKS = 1800; // 90 seconds

    public CelestialGearforgedSwordSlimItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§6Celestial Gearforged Sword Abilities:"));

        if (Screen.hasShiftDown()) {

            tooltip.add(Text.literal("§7- §eRight-Click:§r §dRoar of the Champion§7"));
            tooltip.add(Text.literal("   §8• Knocks back, damages and debuff enemies"));
            tooltip.add(Text.literal("   §8• 10 seconds cooldown 5 seconds with buff"));

            tooltip.add(Text.literal("§7- §eCTRL + Shift + Right-Click:§r §dActivate Buff§7"));
            tooltip.add(Text.literal("   §8• Grants Speed II and Strength II for 30 seconds"));
            tooltip.add(Text.literal("   §8• 5-minute cooldown"));
            tooltip.add(Text.literal("   §8• Grants Resistance V for 1 minute when Celestial Shield is equipped"));
            tooltip.add(Text.literal("   §8• 15 minutes cooldown"));

            tooltip.add(Text.literal("§7- §eSneak + Look Down:§r §dDominion§7"));
            tooltip.add(Text.literal("   §8• Creates a earthly ring around you"));
            tooltip.add(Text.literal("   §8• 2-minute cooldown 60 seconds with buff"));
            tooltip.add(Text.literal("   §8• With Shield Equipped Creates a wall around you as well"));
            tooltip.add(Text.literal("   §8• 9 minute cooldown"));

            tooltip.add(Text.literal("§7- §dPassive:§r for §dHealing Grace§7"));
            tooltip.add(Text.literal("   §8• Heals you based on damage dealt"));
            tooltip.add(Text.literal("   §8• Heals more when buff is active"));

            tooltip.add(Text.literal("§7- §dPassive:§r for §dThunder Surge§7"));
            tooltip.add(Text.literal("   §8• Chance to summon lightning on hit during storms"));
            tooltip.add(Text.literal("   §8• Also triggers in rain if buff is active"));
        } else {
            tooltip.add(Text.literal("§7Hold §eShift §7for abilities details"));
        }
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();
        boolean buffActive = nbt.getLong(BUFF_END_TIME_KEY) > currentTime;

        // 1/5 chance to spawn lightning in thunder or rain if buffed ( When Stormy (Passive))
        if (!world.isClient && (world.isThundering() || (buffActive && world.isRaining())) && RANDOM.nextInt(5) == 0) {
            BlockPos pos = target.getBlockPos();
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.setPosition(pos.getX(), pos.getY(), pos.getZ());
            ((ServerWorld) world).spawnEntity(lightning);
        }


        // Heal attacker based on damage dealt ( Passive )
        if (!world.isClient && attacker != null && target != null) {
            float targetDamage = target.getMaxHealth() - target.getHealth();
            float healAmount = targetDamage * (buffActive ? 0.5f : 0.25f);

            if (healAmount > 0 && attacker.getHealth() < attacker.getMaxHealth()) {
                attacker.heal(healAmount);

                if (attacker instanceof PlayerEntity player) {
                    player.sendMessage(
                            net.minecraft.text.Text.literal("§4You were §4§l§ohealed§r §4for " + String.format("§4§l§o%.1f", healAmount) + " health§r."),
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

        // Warden Roar (normal right-click)
        if (!world.isClient) {
            if (user.getItemCooldownManager().isCoolingDown(this)) {
                return new TypedActionResult<>(ActionResult.FAIL, stack);
            }

            boolean buffActive = nbt.getLong("buffEndTime") > currentTime;

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

                target.damage(world.getDamageSources().playerAttack(user), 18.0F);
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

                if (world instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(
                            ParticleTypes.SONIC_BOOM,
                            x, y, z,
                            1,
                            0, 0, 0, 0
                    );
                }
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (world.isClient || !(entity instanceof PlayerEntity player)) return;

        ItemStack mainHandStack = player.getMainHandStack();
        boolean isHoldingSword = mainHandStack.isOf(ModItems.CELESTIAL_GEARFORGED_SWORD_SLIM);
        if (!isHoldingSword) return;

        NbtCompound swordNbt = stack.getOrCreateNbt();
        long currentTime = world.getTime();

        boolean isSneaking = player.isSneaking();
        boolean isLookingDown = player.getPitch() > 60.0f;
        boolean alreadyActivated = swordNbt.getBoolean(JUMP_EARTH_FLAG_KEY);

        if (isSneaking && isLookingDown && !alreadyActivated) {
            swordNbt.putBoolean(JUMP_EARTH_FLAG_KEY, true);

            // ⚔ Earth Spikes (Sanctum Ability)
            long lastUsed = swordNbt.getLong(EARTH_SPIKE_LAST_USED_KEY);
            boolean buffActive = swordNbt.getLong(BUFF_END_TIME_KEY) > currentTime;
            long cooldownDuration = buffActive ? BUFFED_COOLDOWN_TICKS : COOLDOWN_TICKS;
            boolean earthCooldownOver = (currentTime - lastUsed) >= cooldownDuration;

            if (earthCooldownOver) {
                activateEarthSpikes(world, player);
                swordNbt.putLong(EARTH_SPIKE_LAST_USED_KEY, currentTime);
                player.sendMessage(Text.literal("§aEarth Spikes activated! Cooldown started."), true);
            } else {
                long ticksLeft = cooldownDuration - (currentTime - lastUsed);
                long secondsLeft = ticksLeft / 20;
                player.sendMessage(Text.literal("§cEarth Spikes on cooldown: " + secondsLeft + "s remaining"), true);
            }

            // 🛡 Shield Wall = Shield must be equipped
            ItemStack offhandStack = player.getOffHandStack();
            if (!offhandStack.isEmpty() && offhandStack.getItem() instanceof CelestialGearforgedShieldItem) {
                NbtCompound shieldNbt = offhandStack.getOrCreateNbt();
                long wallCooldownEnd = shieldNbt.getLong("CelestialWallCooldown");

                if (currentTime >= wallCooldownEnd) {
                    if (world instanceof ServerWorld) {
                        CelestialGearforgedShieldItem.createShieldWall(world, player);
                    }
                    shieldNbt.putLong("CelestialWallCooldown", currentTime + 20 * 60 * 9); // 9 minutes
                    player.sendMessage(Text.literal("§bShield Wall activated! Cooldown started."), true);
                } else {
                    long secondsLeft = (wallCooldownEnd - currentTime) / 20;
                    player.sendMessage(Text.literal("§cShield Wall on cooldown: " + secondsLeft + "s remaining"), true);
                }
            }

        }

        // Reset activation flag once the input is no longer held
        if ((!isSneaking || !isLookingDown) && alreadyActivated) {
            swordNbt.putBoolean(JUMP_EARTH_FLAG_KEY, false);
        }
    }




    private void activateEarthSpikes(World world, PlayerEntity player) {
        BlockPos basePos = player.getBlockPos();
        int safeRadius = 2;
        int spikeRingRadius = 5;
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

        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_STONE_BREAK, player.getSoundCategory(), 0.25f, 0.25f);
    }

    @Override
    public boolean canActivateBuff(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        if (!stack.isOf(this)) return false;

        NbtCompound nbt = stack.getOrCreateNbt();
        long currentTime = player.getWorld().getTime();
        long cooldownTime = nbt.getLong(BUFF_COOLDOWN_KEY);

        if (cooldownTime <= currentTime) {
            player.sendMessage(Text.literal("§bLong Sword Buff activated! Speed II and Strength II for 30 seconds."), true);
            return true;
        } else {
            long ticksLeft = cooldownTime - currentTime;
            long secondsLeft = ticksLeft / 20;
            player.sendMessage(Text.literal("§cLong Sword Buff still on cooldown: " + secondsLeft + "s remaining."), true);
            return false;
        }
    }

    @Override
    public void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        if (!stack.isOf(this)) return;

        NbtCompound nbt = stack.getOrCreateNbt();
        World world = player.getWorld();
        long currentTime = world.getTime();

        long cooldownTime = nbt.getLong(BUFF_COOLDOWN_KEY);

        if (cooldownTime <= currentTime) {
            // Apply buff
            nbt.putLong(BUFF_END_TIME_KEY, currentTime + 600);    // Buff active for 30 seconds (600 ticks)
            nbt.putLong(BUFF_COOLDOWN_KEY, currentTime + 6000);   // 5-minute cooldown (6000 ticks)

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1));

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, player.getSoundCategory(), 1.0f, 1.0f);
        }
    }


    @Override
    public boolean canSwitchMode(PlayerEntity player) {
        // Mode switching not implemented for this sword yet.
        return false;
    }

    @Override
    public void switchMode(PlayerEntity player) {
        // You can leave this empty or send a message
//        player.sendMessage(Text.literal("§7This weapon has no alternate mode."), true);
    }

}