package net.spacegateir.steamcraft.item.trinkets.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.util.ModEntityAttributes;

import java.util.UUID;

public class CrownOfFateItem extends TrinketItem {

    private static final UUID VILLAGER_DISCOUNT_UUID = UUID.fromString("8e9a13b3-0f3a-4b8c-9c4a-123456789abc");
    private static final double CREEPER_REPEL_RADIUS = 5.0;
    private static final double CREEPER_REPEL_DISTANCE = 3.0; // distance creepers move away
    private static final double CREEPER_SPEED = 1.0; // movement speed

    public CrownOfFateItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, java.util.List<net.minecraft.text.Text> tooltip, net.minecraft.client.item.TooltipContext context) {
        tooltip.add(net.minecraft.text.Text.literal("§6Crown of Fate Abilities:"));

        if (net.minecraft.client.gui.screen.Screen.hasShiftDown()) {
            tooltip.add(net.minecraft.text.Text.literal("§7- §eRoyal Aura:§r §aCreepers§7 will avoid you like cats"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Stops §aCreepers§7 §8•from targeting you"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Forces them to walk away in fear"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Aura radius: 5 blocks"));

            tooltip.add(net.minecraft.text.Text.literal(""));
            tooltip.add(net.minecraft.text.Text.literal("§7- §eVillager's Favor:§r§7 Grants better trades"));
            tooltip.add(net.minecraft.text.Text.literal("   §8• Villager Discount when worn"));
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

        repelCreepers(player, player.getWorld());
    }

    private void repelCreepers(PlayerEntity player, World world) {
        world.getEntitiesByClass(CreeperEntity.class,
                        player.getBoundingBox().expand(CREEPER_REPEL_RADIUS),
                        creeper -> true)
                .forEach(creeper -> {
                    creeper.setTarget(null);

                    double dx = creeper.getX() - player.getX();
                    double dz = creeper.getZ() - player.getZ();
                    double distance = Math.sqrt(dx * dx + dz * dz);
                    if (distance < 0.1) return;

                    double moveX = creeper.getX() + (dx / distance) * CREEPER_REPEL_DISTANCE;
                    double moveZ = creeper.getZ() + (dz / distance) * CREEPER_REPEL_DISTANCE;

                    creeper.getNavigation().startMovingTo(moveX, creeper.getY(), moveZ, CREEPER_SPEED);
                });
    }
}
