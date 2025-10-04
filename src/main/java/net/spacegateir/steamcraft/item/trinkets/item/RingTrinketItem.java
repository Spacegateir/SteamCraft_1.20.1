package net.spacegateir.steamcraft.item.trinkets.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class RingTrinketItem extends TrinketItem {

    private static final UUID DIAMOND_RING_UUID = UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479");

    public RingTrinketItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        String gemType = getGemType(stack);
        String abilityText = switch (gemType) {
            case "diamond" -> "Attack Boost (4 extra damage)";
            case "emerald" -> "Luck + Increased XP pickup range";
            case "amethyst" -> "Night Vision + Inflicts Darkness on hit";
            case "ruby" -> "Ignites enemies on hit";
            case "sapphire" -> "Improved Water Breathing & Swim Speed";
            case "onyx" -> "Invisibility when sneaking";
            case "jade" -> "Life Steals (25% of damage dealt)";
            case "topaz" -> "Inflicts Poison on hit";
            default -> "";
        };

        if (!abilityText.isEmpty()) {
            tooltip.add(Text.literal(abilityText).formatted(Formatting.DARK_GRAY));
        }
    }

    public static void onPlayerTick(PlayerEntity player, World world) {
        applyDiamondRingDamage(player);

        ItemStack ring = getEquippedRing(player);
        if (ring.isEmpty()) return;

        String gemType = getGemType(ring);

        switch (gemType) {
            case "diamond" -> {
            }
            case "emerald" -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 220, 0, true, false, true));
                world.getEntitiesByClass(ExperienceOrbEntity.class,
                                player.getBoundingBox().expand(10.0),
                                orb -> true)
                        .forEach(orb -> orb.setPosition(player.getX(), player.getY(), player.getZ()));
            }
            case "amethyst" ->
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0, true, false, true));
            case "ruby" -> {    //onAttack
            }
            case "sapphire" -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 220, 0, true, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 220, 0, true, false, true));
            }
            case "onyx" -> {
                if (player.isSneaking()) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20, 0, true, false, true));
                }
            }
            case "jade" -> {    //onAttack
            }
            case "topaz" -> {    //onAttack
            }
        }
    }

    public static void onAttack(PlayerEntity player, LivingEntity target) {
        ItemStack ring = getEquippedRing(player);
        if (ring.isEmpty()) return;

        String gemType = getGemType(ring);

        switch (gemType) {
            case "diamond" -> {
            }
            case "amethyst" -> target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0));
            case "ruby" -> target.setOnFireFor(4);
            case "topaz" -> target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));
            case "jade" -> {
                if (!player.getWorld().isClient) {
                    int jadeCount;
                    List<ItemStack> equippedRings = TrinketsApi.getTrinketComponent(player)
                            .map(component -> {
                                List<Pair<SlotReference, ItemStack>> rings = component.getEquipped(stack -> stack.getItem() instanceof RingTrinketItem);
                                return rings.stream().map(Pair::getRight).toList();
                            }).orElse(List.of());

                    jadeCount = (int) equippedRings.stream().filter(stack -> !stack.isEmpty() && getGemType(stack).equals("jade")).count();

                    float baseLifesteal = 0.25f; // 25% per ring

                    float preHealth = target.getHealth();
                    player.getServer().execute(() -> {
                        float postHealth = target.getHealth();
                        float damageDealt = preHealth - postHealth;

                        if (damageDealt > 0) {
                            float healAmount = damageDealt * baseLifesteal * jadeCount;
                            if (player.getHealth() < player.getMaxHealth()) {
                                player.heal(healAmount);

                                player.sendMessage(
                                        Text.literal("§4You were §4§l§ohealed§r §4for " + String.format("§4§l§o%.1f", healAmount) + " health§r."),
                                        true
                                );
                            }
                        }
                    });
                }
            }

        }
    }

    private static void applyDiamondRingDamage(PlayerEntity player) {
        var attribute = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attribute == null) return;

        List<ItemStack> equippedRings = TrinketsApi.getTrinketComponent(player)
                .map(component -> component.getEquipped(stack -> stack.getItem() instanceof RingTrinketItem))
                .orElse(List.of())
                .stream()
                .map(Pair::getRight)
                .toList();

        long diamondCount = equippedRings.stream()
                .filter(s -> !s.isEmpty() && getGemType(s).equals("diamond"))
                .count();

        // Remove old modifier if it exists
        var oldModifier = attribute.getModifier(DIAMOND_RING_UUID);
        if (oldModifier != null) {
            attribute.removeModifier(DIAMOND_RING_UUID);
        }

        // Add new modifier if we have at least one diamond ring
        if (diamondCount > 0) {
            attribute.addTemporaryModifier(new EntityAttributeModifier(
                    DIAMOND_RING_UUID,
                    "Diamond ring bonus",
                    4.0 * diamondCount,
                    EntityAttributeModifier.Operation.ADDITION
            ));
        }
    }


    private static ItemStack getEquippedRing(PlayerEntity player) {
        return TrinketsApi.getTrinketComponent(player).map(component -> {
            List<Pair<SlotReference, ItemStack>> equipped =
                    component.getEquipped(stack -> stack.getItem() instanceof RingTrinketItem);
            for (Pair<SlotReference, ItemStack> pair : equipped) {
                ItemStack stack = pair.getRight();
                if (!stack.isEmpty()) return stack;
            }
            return ItemStack.EMPTY;
        }).orElse(ItemStack.EMPTY);
    }

    private static String getGemType(ItemStack stack) {
        String id = Registries.ITEM.getId(stack.getItem()).getPath();
        if (id.contains("diamond")) return "diamond";
        if (id.contains("emerald")) return "emerald";
        if (id.contains("amethyst")) return "amethyst";
        if (id.contains("ruby")) return "ruby";
        if (id.contains("sapphire")) return "sapphire";
        if (id.contains("onyx")) return "onyx";
        if (id.contains("jade")) return "jade";
        if (id.contains("topaz")) return "topaz";
        return "";
    }
}
