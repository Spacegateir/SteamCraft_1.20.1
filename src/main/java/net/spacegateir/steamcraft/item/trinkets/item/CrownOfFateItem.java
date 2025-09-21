package net.spacegateir.steamcraft.item.trinkets.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.ModEntityAttributes;

import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.mob.*;

public class CrownOfFateItem extends TrinketItem {

    private static final UUID VILLAGER_DISCOUNT_UUID = UUID.fromString("8e9a13b3-0f3a-4b8c-9c4a-123456789abc");

    private static final double REPEL_RADIUS = 10.0;
    private static final double REPEL_DISTANCE = 5.0;
    private static final double REPEL_SPEED = 1.0;

    private static final double ATTRACT_RADIUS = 10.0;
    private static final double MIN_ATTRACT_DISTANCE = 4.0;
    private static final double ATTRACT_SPEED = 0.4;

    @SuppressWarnings("unchecked")
    private static final Class<? extends MobEntity>[] REPEL_MOBS = new Class[]{
            PillagerEntity.class,
            VindicatorEntity.class,
            RavagerEntity.class,
            WitchEntity.class,
            EvokerEntity.class,
            VexEntity.class
    };

    @SuppressWarnings("unchecked")
    private static final Map<Class<? extends MobEntity>, Double> ATTRACTABLE_MOBS = Map.of(
            VillagerEntity.class, ATTRACT_SPEED,
            IronGolemEntity.class, ATTRACT_SPEED + 0.3
    );


    public CrownOfFateItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, java.util.List<net.minecraft.text.Text> tooltip, net.minecraft.client.item.TooltipContext context) {
        tooltip.add(net.minecraft.text.Text.literal("§6Crown of Fate Abilities:"));

        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(net.minecraft.text.Text.literal("§7- §eRoyal Aura:§r"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Villager's and Iron Golem's will follow you"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Stops Raid Mobs from targeting you"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Forces them to walk away in fear"));

            tooltip.add(net.minecraft.text.Text.literal(""));

            tooltip.add(net.minecraft.text.Text.literal("§7- §eVillager's Favor:§r§7"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Villager Discount when worn"));

            tooltip.add(net.minecraft.text.Text.literal(""));

        } else {
            tooltip.add(net.minecraft.text.Text.literal("§7Hold §eShift §7for ability info"));
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(
            ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {

        Multimap<EntityAttribute, EntityAttributeModifier> modifiers =
                super.getModifiers(stack, slot, entity, uuid);

        if (slot.inventory().getSlotType().getName().equals("head") ||
                slot.inventory().getSlotType().getName().equals("hat")) {

            modifiers.put(
                    ModEntityAttributes.GENERIC_VILLAGER_DISCOUNT,
                    new EntityAttributeModifier(
                            VILLAGER_DISCOUNT_UUID,
                            "Crown villager discount boost",
                            1.0,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        }

        return modifiers;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.getWorld().isClient) return;
        if (!(entity instanceof PlayerEntity player)) return;

        repelMobs(player, player.getWorld(), REPEL_MOBS);

        attractMobs(player, player.getWorld(), ATTRACTABLE_MOBS);
    }
    @SafeVarargs
    private static void repelMobs(PlayerEntity player, World world, Class<? extends MobEntity>... mobClasses) {
        for (Class<? extends MobEntity> mobClass : mobClasses) {
            world.getEntitiesByClass(mobClass,
                            player.getBoundingBox().expand(REPEL_RADIUS),
                            mob -> true)
                    .forEach(mob -> {
                        mob.setTarget(null);

                        double dx = mob.getX() - player.getX();
                        double dz = mob.getZ() - player.getZ();
                        double distance = Math.sqrt(dx * dx + dz * dz);
                        if (distance < 0.1) return;

                        double moveX = mob.getX() + (dx / distance) * REPEL_DISTANCE;
                        double moveZ = mob.getZ() + (dz / distance) * REPEL_DISTANCE;

                        mob.getNavigation().startMovingTo(moveX, mob.getY(), moveZ, REPEL_SPEED);
                    });
        }
    }

    private static void attractMobs(PlayerEntity player, World world, Map<Class<? extends MobEntity>, Double> mobClasses) {
        for (Map.Entry<Class<? extends MobEntity>, Double> entry : mobClasses.entrySet()) {
            Class<? extends MobEntity> mobClass = entry.getKey();
            double speed = entry.getValue();

            world.getEntitiesByClass(mobClass,
                            player.getBoundingBox().expand(ATTRACT_RADIUS),
                            mob -> true)
                    .forEach(mob -> {
                        if (mob.getTarget() != null) return;

                        double dx = player.getX() - mob.getX();
                        double dz = player.getZ() - mob.getZ();
                        double distance = Math.sqrt(dx * dx + dz * dz);

                        if (distance < MIN_ATTRACT_DISTANCE) {
                            mob.getNavigation().stop();
                            return;
                        }

                        mob.getNavigation().startMovingTo(
                                player.getX(),
                                player.getY(),
                                player.getZ(),
                                speed
                        );
                    });
        }
    }


}

