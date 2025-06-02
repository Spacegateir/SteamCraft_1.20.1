package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.minecraft.loot.function.SetCountLootFunction;

import java.util.List;

public class ModLootTableModifiers {
    private static final List<Identifier> CHEST_LOOT_TABLES = List.of(
            LootTables.ABANDONED_MINESHAFT_CHEST,
            LootTables.ANCIENT_CITY_CHEST,
            LootTables.ANCIENT_CITY_ICE_BOX_CHEST,
            LootTables.BASTION_BRIDGE_CHEST,
            LootTables.BASTION_HOGLIN_STABLE_CHEST,
            LootTables.BASTION_OTHER_CHEST,
            LootTables.BASTION_TREASURE_CHEST,
            LootTables.BURIED_TREASURE_CHEST,
            LootTables.DESERT_PYRAMID_CHEST,
            LootTables.END_CITY_TREASURE_CHEST,
            LootTables.IGLOO_CHEST_CHEST,
            LootTables.JUNGLE_TEMPLE_CHEST,
            LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST,
            LootTables.NETHER_BRIDGE_CHEST,
            LootTables.PILLAGER_OUTPOST_CHEST,
            LootTables.RUINED_PORTAL_CHEST,
            LootTables.SHIPWRECK_MAP_CHEST,
            LootTables.SHIPWRECK_SUPPLY_CHEST,
            LootTables.SHIPWRECK_TREASURE_CHEST,
            LootTables.SIMPLE_DUNGEON_CHEST,
            LootTables.SPAWN_BONUS_CHEST,
            LootTables.STRONGHOLD_CORRIDOR_CHEST,
            LootTables.STRONGHOLD_CROSSING_CHEST,
            LootTables.STRONGHOLD_LIBRARY_CHEST,
            LootTables.UNDERWATER_RUIN_BIG_CHEST,
            LootTables.UNDERWATER_RUIN_SMALL_CHEST,
            LootTables.WOODLAND_MANSION_CHEST
    );


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (EntityType.ZOMBIE.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.SKELETON.getLootTableId().equals(id)) {
                LootPool.Builder skeletonPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModBlocks.SKELETON_HEAD))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_ARM))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_LEG))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_SPINE))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_PELVIS))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_CHEST))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(skeletonPool.build());


                LootPool.Builder torsoArmsCrossLegsCrossPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModBlocks.SKELETON_TORSO))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_ARMS_CROSS))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_LEGS_CROSS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(torsoArmsCrossLegsCrossPool.build());


                LootPool.Builder goldChestplatePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(goldChestplatePool.build());
            }

            if (EntityType.DROWNED.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.WITCH.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.PIGLIN.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.PILLAGER.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.RAVAGER.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.EVOKER.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.VINDICATOR.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.GUARDIAN.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AQUARION_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.GHAST.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(Items.GHAST_TEAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (EntityType.VILLAGER.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (EntityType.TRADER_LLAMA.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 10% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (EntityType.IRON_GOLEM.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.ENDER_DRAGON.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AETHERIUM_PRISM))
                        .with(ItemEntry.builder(Blocks.DRAGON_EGG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.WITHER.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.PYROCITE_CORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.WARDEN.getLootTableId().equals(id)) {
                LootPool.Builder heartstonePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FERRITE_HEARTSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(heartstonePool.build());

                LootPool.Builder echoShardPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(Items.ECHO_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                tableBuilder.pool(echoShardPool.build());
            }

            if (EntityType.ELDER_GUARDIAN.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AQUARION_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (CHEST_LOOT_TABLES.contains(id)) {
                addLootToChests(tableBuilder);
            }
        });
    }

    private static void addLootToChests(LootTable.Builder tableBuilder) {
        LootPool.Builder gemPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 10% of the time
                .with(ItemEntry.builder(ModItems.LUMINITE_SPARK))
                .with(ItemEntry.builder(ModItems.OBSCURIUM_CRYSTAL))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder helmetPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_4))
                .with(ItemEntry.builder(ModItems.HELMET_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder chestplatePoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_4))
                .with(ItemEntry.builder(ModItems.CHESTPLATE_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder leggingsPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_4))
                .with(ItemEntry.builder(ModItems.LEGGINGS_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder bootsPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_4))
                .with(ItemEntry.builder(ModItems.BOOTS_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder20 = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops 20% of the time
                .with(ItemEntry.builder(ModItems.BLANK_MOULD))
                .with(ItemEntry.builder(ModItems.CORE_OF_CHANGING))
                .with(ItemEntry.builder(ModItems.TROWEL))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder40 = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.4f)) // Drops 50% of the time
                .with(ItemEntry.builder(ModItems.BLANK_MOULD))
                .with(ItemEntry.builder(ModItems.CORE_OF_CHANGING))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 7.0f)).build());


        tableBuilder.pool(gemPoolBuilder.build());
        tableBuilder.pool(helmetPoolBuilder.build());
        tableBuilder.pool(chestplatePoolBuilder.build());
        tableBuilder.pool(leggingsPoolBuilder.build());
        tableBuilder.pool(bootsPoolBuilder.build());
        tableBuilder.pool(poolBuilder20.build());
        tableBuilder.pool(poolBuilder40.build());
    }


}