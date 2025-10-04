package net.spacegateir.steamcraft.item.trinkets.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.item.TooltipContext;
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

public class NecklaceTrinketItem extends TrinketItem {

    public NecklaceTrinketItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        String gemType = getGemType(stack);
        String abilityText = switch (gemType) {
            case "diamond" -> "Defense: All Damage reduction 50%"; //DamageReduceLivingEntityMixin
            case "emerald" -> "Raid Immunity (Bad Omen)";
            case "amethyst" -> "Immunity to Darkness & Blindness";
            case "ruby" -> "Fire & Lava Immunity";
            case "sapphire" -> "Freezing & Slowness Immunity";
            case "onyx" -> "Wither Immunity";
            case "jade" -> "Hunger Immunity";
            case "topaz" -> "Poison Immunity";
            default -> "";
        };

        if (!abilityText.isEmpty()) {
            tooltip.add(Text.literal(abilityText).formatted(Formatting.DARK_GRAY));
        }
    }

    public static void onPlayerTick(PlayerEntity player, World world) {
        ItemStack necklace = getEquippedNecklace(player);
        if (necklace.isEmpty()) return;

        String gemType = getGemType(necklace);

        switch (gemType) {
            case "diamond" -> {
             }
            case "emerald" -> {
                if (player.hasStatusEffect(StatusEffects.BAD_OMEN)) {
                    player.removeStatusEffect(StatusEffects.BAD_OMEN);
                }
            }
            case "amethyst" -> {
                // Darkness & blindness immunity
                if (player.hasStatusEffect(StatusEffects.DARKNESS)) {
                    player.removeStatusEffect(StatusEffects.DARKNESS);
                }
                if (player.hasStatusEffect(StatusEffects.BLINDNESS)) {
                    player.removeStatusEffect(StatusEffects.BLINDNESS);
                }
            }
            case "ruby" -> {
                // Fire & lava immunity
                player.setFireTicks(0);
                if (player.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                    // already applied
                } else {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 220, 0, true, false, true));
                }
            }
            case "sapphire" -> {
                // freezing and slowness immunity
                if (!player.getWorld().isClient) {
                    player.setFrozenTicks(0);
                    if (player.hasStatusEffect(StatusEffects.SLOWNESS)) {
                        player.removeStatusEffect(StatusEffects.SLOWNESS);
                    }
                }
            }
            case "onyx" -> {
                // Wither immunity
                if (player.hasStatusEffect(StatusEffects.WITHER)) {
                    player.removeStatusEffect(StatusEffects.WITHER);
                }
            }
            case "jade" -> {
                // Hunger immunity
                if (player.hasStatusEffect(StatusEffects.HUNGER)) {
                    player.removeStatusEffect(StatusEffects.HUNGER);
                }
                if (player.getHungerManager().getFoodLevel() < 1) {
                    player.getHungerManager().setFoodLevel(1);
                }
            }
            case "topaz" -> {
                // Poison immunity
                if (player.hasStatusEffect(StatusEffects.POISON)) {
                    player.removeStatusEffect(StatusEffects.POISON);
                }
            }
        }
    }

    public static ItemStack getEquippedNecklace(PlayerEntity player) {
        return TrinketsApi.getTrinketComponent(player).map(component -> {
            List<Pair<SlotReference, ItemStack>> equipped = component.getEquipped(stack -> stack.getItem() instanceof NecklaceTrinketItem);
            for (Pair<SlotReference, ItemStack> pair : equipped) {
                ItemStack stack = pair.getRight();
                if (!stack.isEmpty()) return stack;
            }
            return ItemStack.EMPTY;
        }).orElse(ItemStack.EMPTY);
    }


    public static String getGemType(ItemStack stack) {
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
