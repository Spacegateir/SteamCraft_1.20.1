package net.spacegateir.steamcraft.item.loot_chests;

import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.Vec3d;
import net.spacegateir.steamcraft.item.ModRewardItems;

import java.util.Map;
import java.util.Random;

public class LootChestItem extends Item {
    private final Random random = new Random();

    public LootChestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            // Define loot table with weights
            Map<ItemConvertible, Integer> lootTable = Map.ofEntries(
//                    Map.entry(ModRewardItems.AMETHYST_LOOT_CHEST, 3),                //(3 / 166) × 100 = 1.81%
                    Map.entry(ModRewardItems.WOLF_FURY_LOOT_CHEST, 3),               //1.81%

                    Map.entry(ModRewardItems.TERA_LOOT_CHEST, 20),                   //12.05%
                    Map.entry(ModRewardItems.ORIKALKUM_LOOT_CHEST, 10),              //6.02%
                    Map.entry(ModRewardItems.MYTHRIL_LOOT_CHEST, 15),                //9.04%
                    Map.entry(ModRewardItems.MAGIRITE_LOOT_CHEST, 15),               //9.04%
                    Map.entry(ModRewardItems.IGNIS_LOOT_CHEST, 20),                  //12.05%
                    Map.entry(ModRewardItems.DWARF_STEEL_LOOT_CHEST, 20),            //12.05%
                    Map.entry(ModRewardItems.DRAGON_BANE_LOOT_CHEST, 10),            //6.02%
                    Map.entry(ModRewardItems.AQUA_LOOT_CHEST, 20),                   //12.05%
                    Map.entry(ModRewardItems.AER_LOOT_CHEST, 20),                    //12.05%
                    Map.entry(ModRewardItems.ADAMANTITE_LOOT_CHEST, 10)              //6.02%
            );


            // Choose a reward
            ItemConvertible selectedLoot = getWeightedRandomItem(lootTable);
            ItemStack dropStack = new ItemStack(selectedLoot);

            // Drop reward near player
            Vec3d pos = player.getPos();
            ItemEntity itemEntity = new ItemEntity(world, pos.x, pos.y + 1, pos.z, dropStack);
            world.spawnEntity(itemEntity);

            // Notify player
            player.sendMessage(Text.literal("🎉 Congratulations! You received " + dropStack.getName().getString() + ". Enjoy your prize! 🎉"), true);

            // Fireworks celebration
            launchFireworks(world, pos);

            // Consume loot chest
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    // Picks an item based on weighted chance
    private ItemConvertible getWeightedRandomItem(Map<ItemConvertible, Integer> lootTable) {
        int totalWeight = lootTable.values().stream().mapToInt(Integer::intValue).sum();
        int randomWeight = random.nextInt(totalWeight);
        int cumulative = 0;

        for (Map.Entry<ItemConvertible, Integer> entry : lootTable.entrySet()) {
            cumulative += entry.getValue();
            if (randomWeight < cumulative) {
                return entry.getKey();
            }
        }

        // Fallback
        return lootTable.keySet().iterator().next();
    }

    // Launch multiple randomized fireworks
    private void launchFireworks(World world, Vec3d pos) {
        for (int i = 0; i < 16; i++) {
            ItemStack fireworkStack = new ItemStack(net.minecraft.item.Items.FIREWORK_ROCKET);
            NbtCompound fireworksNbt = new NbtCompound();
            NbtList explosions = new NbtList();

            NbtCompound explosion = new NbtCompound();
            explosion.putByte("Type", (byte) 1); // Star-shaped
            explosion.putIntArray("Colors", new int[]{getRandomColor(world), getRandomColor(world)});
            explosion.putIntArray("FadeColors", new int[]{getRandomColor(world)});
            explosion.putBoolean("Flicker", true);
            explosion.putBoolean("Trail", true);

            explosions.add(explosion);

            NbtCompound fireworks = new NbtCompound();
            fireworks.put("Explosions", explosions);
            fireworks.putByte("Flight", (byte) ((i % 3) + 1)); // Vary flight duration

            fireworksNbt.put("Fireworks", fireworks);
            fireworkStack.setNbt(fireworksNbt);

            // Small random offsets to spread fireworks
            double offsetX = (world.random.nextDouble() - 0.5) * 0.5;
            double offsetZ = (world.random.nextDouble() - 0.5) * 0.5;

            FireworkRocketEntity firework = new FireworkRocketEntity(
                    world,
                    pos.x + offsetX,
                    pos.y + 1,
                    pos.z + offsetZ,
                    fireworkStack
            );

            world.spawnEntity(firework);
        }
    }

    // Random RGB color
    private int getRandomColor(World world) {
        int r = world.random.nextInt(256);
        int g = world.random.nextInt(256);
        int b = world.random.nextInt(256);
        return (r << 16) | (g << 8) | b;
    }
}
