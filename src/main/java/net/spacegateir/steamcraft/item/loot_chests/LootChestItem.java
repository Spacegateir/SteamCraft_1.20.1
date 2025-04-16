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

import java.util.List;
import java.util.Random;

public class LootChestItem extends Item {
    private final Random random = new Random();

    public LootChestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            List<ItemConvertible> lootItems = List.of(
                    ModRewardItems.AMETHYST_LOOT_CHEST,
                    ModRewardItems.WOLF_FURY_LOOT_CHEST
            );

            ItemConvertible selectedLoot = lootItems.get(random.nextInt(lootItems.size()));
            ItemStack dropStack = new ItemStack(selectedLoot);

            // Drop the item
            Vec3d pos = player.getPos();
            ItemEntity itemEntity = new ItemEntity(world, pos.x, pos.y + 1, pos.z, dropStack);
            world.spawnEntity(itemEntity);

            // Send message to player
            String itemName = dropStack.getName().getString();
            player.sendMessage(Text.literal("🎉 Congratulations! You received " + itemName + ". Enjoy your prize! 🎉"), true);

            // Launch celebratory fireworks
            launchFireworks(world, pos);

            // Consume loot chest if not creative
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    private void launchFireworks(World world, Vec3d pos) {
        for (int i = 0; i < 16; i++) {
            ItemStack fireworkStack = new ItemStack(net.minecraft.item.Items.FIREWORK_ROCKET);
            NbtCompound fireworksNbt = new NbtCompound();
            NbtList explosions = new NbtList();

            NbtCompound explosion = new NbtCompound();
            explosion.putByte("Type", (byte) 1); // Star-shaped

            // Generate random color arrays
            int[] colors = new int[]{
                    getRandomColor(world),
                    getRandomColor(world)
            };
            int[] fadeColors = new int[]{
                    getRandomColor(world)
            };

            explosion.putIntArray("Colors", colors);
            explosion.putIntArray("FadeColors", fadeColors);
            explosion.putBoolean("Flicker", true);
            explosion.putBoolean("Trail", true);

            explosions.add(explosion);

            NbtCompound fireworks = new NbtCompound();
            fireworks.put("Explosions", explosions);
            fireworks.putByte("Flight", (byte) ((i % 3) + 1)); // Cycle through 1, 2, 3 flight duration

            fireworksNbt.put("Fireworks", fireworks);
            fireworkStack.setNbt(fireworksNbt);

            // Slight random offset so they don't stack
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

    // Utility method to generate a random RGB color
    private int getRandomColor(World world) {
        int r = world.random.nextInt(256);
        int g = world.random.nextInt(256);
        int b = world.random.nextInt(256);
        return (r << 16) | (g << 8) | b;
    }
}
