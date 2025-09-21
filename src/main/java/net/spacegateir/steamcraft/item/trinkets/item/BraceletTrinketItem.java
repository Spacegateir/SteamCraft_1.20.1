package net.spacegateir.steamcraft.item.trinkets.item;

import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import net.minecraft.world.World;

import java.util.List;

public class BraceletTrinketItem extends TrinketItem {

    private static final double REPEL_RADIUS = 15.0;
    private static final double REPEL_DISTANCE = 10.0;
    private static final double REPEL_SPEED = 1.0;
    private static final double ATTRACT_RADIUS = 10.0;
    private static final double ATTRACT_SPEED = 0.7;

    public BraceletTrinketItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        String gemType = getGemType(stack);
        String abilityText = switch (gemType) {
            case "diamond" -> "Burns all undead";
            case "emerald" -> "Attracts Animals";
            case "amethyst" -> "Repels Phantoms";
            case "ruby" -> "Repels Wither Skeletons";
            case "sapphire" -> "Repels Drowned & Guardian";
            case "onyx" -> "Repels Endermen & Creeper";
            case "jade" -> "Repels Piglins";
            case "topaz" -> "Repels Spiders";
            default -> "";
        };

        if (!abilityText.isEmpty()) {
            tooltip.add(Text.literal(abilityText).formatted(Formatting.DARK_GRAY)); // Optional color formatting
        }
    }


    public static void onPlayerTick(PlayerEntity player, World world) {
        ItemStack bracelet = getEquippedBracelet(player);
        if (bracelet.isEmpty()) return;

        String gemType = getGemType(bracelet);

        switch (gemType) {
            case "diamond":
                burnUndead(player, world);
                break;
            case "emerald":
                attractMobs(player, world, CowEntity.class, SheepEntity.class, PigEntity.class, ChickenEntity.class, RabbitEntity.class, BeeEntity.class);
                break;
            case "amethyst":
                repelMobs(player, world, PhantomEntity.class);
                break;
            case "ruby":
                repelMobs(player, world, WitherSkeletonEntity.class);
                break;
            case "sapphire":
                repelMobs(player, world, DrownedEntity.class, GuardianEntity.class);
                break;
            case "onyx":
                repelMobs(player, world, EndermanEntity.class, CreeperEntity.class);
                break;
            case "jade":
                repelMobs(player, world, PiglinEntity.class);
                break;
            case "topaz":
                repelMobs(player, world, SpiderEntity.class, CaveSpiderEntity.class);
                break;
        }
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

    @SafeVarargs
    private static void attractMobs(PlayerEntity player, World world, Class<? extends MobEntity>... mobClasses) {
        final double MIN_ATTRACT_DISTANCE = 4.0;

        for (Class<? extends MobEntity> mobClass : mobClasses) {
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
                                ATTRACT_SPEED
                        );
                    });
        }
    }

    private static void burnUndead(PlayerEntity player, World world) {
        Class<? extends MobEntity>[] undeadClasses = new Class[]{
                ZombieEntity.class,
                ZombieVillagerEntity.class,
                ZombieHorseEntity.class,
                SkeletonEntity.class,
                SkeletonHorseEntity.class,
                HuskEntity.class,
                DrownedEntity.class,
                PhantomEntity.class,
                StrayEntity.class,
        };

        for (Class<? extends MobEntity> undeadClass : undeadClasses) {
            world.getEntitiesByClass(undeadClass,
                            player.getBoundingBox().expand(REPEL_RADIUS),
                            mob -> true)
                    .forEach(mob -> mob.setOnFireFor(1));
        }
    }

    private static ItemStack getEquippedBracelet(PlayerEntity player) {
        return TrinketsApi.getTrinketComponent(player).map(component -> {
            List<Pair<SlotReference, ItemStack>> equipped = component.getEquipped(stack -> stack.getItem() instanceof BraceletTrinketItem);
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
