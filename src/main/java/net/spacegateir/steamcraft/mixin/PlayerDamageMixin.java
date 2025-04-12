package net.spacegateir.steamcraft.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EquipmentSlot;
import net.spacegateir.steamcraft.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerDamageMixin {

    @Inject(method = "damage", at = @At("TAIL"))
    private void onPlayerDamaged(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (!player.getWorld().isClient && isWearingFullFoolsGold(player)) {
            float rng = player.getRandom().nextFloat();

            if (rng < 0.003f) { // 0.10% for raw
                flingScrap(player, ModItems.FOOLS_GOLD_RAW);
            } else if (rng < 0.05f) { // 1% for scrap
                flingScrap(player, ModItems.FOOLS_GOLD_SCRAP);
            }
        }
    }

    private boolean isWearingFullFoolsGold(PlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.FOOLS_GOLD_HELMET &&
                player.getEquippedStack(EquipmentSlot.CHEST).getItem() == ModItems.FOOLS_GOLD_CHESTPLATE &&
                player.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.FOOLS_GOLD_LEGGINGS &&
                player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.FOOLS_GOLD_BOOTS;
    }

    private void flingScrap(PlayerEntity player, net.minecraft.item.Item item) {
        ServerWorld world = (ServerWorld) player.getWorld();
        Vec3d pos = player.getPos();
        ItemStack stack = new ItemStack(item, 1);

        net.minecraft.util.math.random.Random rand = player.getRandom();
        double angle = rand.nextDouble() * 2 * Math.PI;
        double speed = 0.3 + rand.nextDouble() * 0.4;

        double vx = Math.cos(angle) * speed;
        double vz = Math.sin(angle) * speed;
        double vy = 0.3 + rand.nextDouble() * 0.2;

        var itemEntity = new net.minecraft.entity.ItemEntity(world, pos.x, pos.y + 1, pos.z, stack);
        itemEntity.setVelocity(vx, vy, vz);
        itemEntity.setPickupDelay(40); // Delay in ticks (2 seconds)

        world.spawnEntity(itemEntity);

        world.playSoundFromEntity(
                null,
                player,
                SoundEvents.ENTITY_ITEM_BREAK,
                SoundCategory.PLAYERS,
                1.0f,
                0.9f + rand.nextFloat() * 0.2f
        );
    }



}
