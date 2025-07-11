package net.spacegateir.steamcraft.TestTools.Class;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Buff extends PickaxeItem {

    private static final String BUFF_COOLDOWN_KEY = "CelestialBuffCooldown";
    private static final int BUFF_DURATION_TICKS = 20 * 60 * 5;   // 5 minutes
    private static final int BUFF_COOLDOWN_TICKS = 20 * 60 * 20;   // 20 minutes

    public Buff(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
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

        if (!world.isClient && player != null && Screen.hasControlDown() && Screen.hasShiftDown()) {
            applyBuffAbility(player);
            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }

    private void applyBuffAbility(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        long currentTime = player.getWorld().getTime();
        long cooldownEnd = stack.getOrCreateNbt().getLong(BUFF_COOLDOWN_KEY);

        if (currentTime >= cooldownEnd) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, BUFF_DURATION_TICKS, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, BUFF_DURATION_TICKS, 1));
            stack.getOrCreateNbt().putLong(BUFF_COOLDOWN_KEY, currentTime + BUFF_COOLDOWN_TICKS);
            player.sendMessage(Text.literal("§bBuff active! Cooldown started."), true);
        } else {
            long secondsLeft = (cooldownEnd - currentTime) / 20;
            player.sendMessage(Text.literal("§cBuff on cooldown: " + secondsLeft + "s remaining"), true);
        }
    }
}
