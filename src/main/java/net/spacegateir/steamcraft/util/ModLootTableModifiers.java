package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.minecraft.loot.function.SetCountLootFunction;

public class ModLootTableModifiers {

    private static final Identifier ZOMBIE_ID =
            new Identifier("minecraft","entities/zombie");
    private static final Identifier SKELETON_ID =
            new Identifier("minecraft","entities/skeleton");
    private static final Identifier DROWNED_ID =
            new Identifier("minecraft","entities/drowned");
    private static final Identifier WITCH_ID =
            new Identifier("minecraft","entities/witch");
    private static final Identifier PIGLIN_ID =
            new Identifier("minecraft","entities/piglin");
    private static final Identifier PILLAGER_ID =
            new Identifier("minecraft","entities/pillager");
    private static final Identifier RAVAGER_ID =
            new Identifier("minecraft","entities/ravager");
    private static final Identifier EVOKER_ID =
            new Identifier("minecraft","entities/evoker");
    private static final Identifier VINDICATOR_ID =
            new Identifier("minecraft","entities/vindicator");
    private static final Identifier GUARDIAN_ID =
            new Identifier("minecraft","entities/guardian");
    private static final Identifier GHAST_ID =
            new Identifier("minecraft","entities/ghast");

    private static final Identifier VILLAGER_ID =
            new Identifier("minecraft","entities/villager");
    private static final Identifier TRADER_LLAMA_ID =
            new Identifier("minecraft","entities/trader_llama");
    private static final Identifier IRON_GOLEM_ID =
            new Identifier("minecraft","entities/iron_golem");

    //Bosses
    private static final Identifier ENDER_DRAGON_ID =
            new Identifier("minecraft","entities/ender_dragon");
    private static final Identifier WARDEN_ID =
            new Identifier("minecraft","entities/warden");
    private static final Identifier WITHER_ID =
            new Identifier("minecraft","entities/wither");
    private static final Identifier ELDER_GUARDIAN_ID =
            new Identifier("minecraft","entities/elder_guardian");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time    0.001f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
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

                tableBuilder.pool(poolBuilder.build());
            }

            if (SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModBlocks.SKELETON_TORSO))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_ARMS_CROSS))
                        .with(ItemEntry.builder(ModBlocks.SKELETON_LEGS_CROSS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time    0.001f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only drops when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (DROWNED_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time    0.001f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (WITCH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time       0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (PIGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.10% of the time    0.001f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (PILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (RAVAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (EVOKER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (VINDICATOR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time     0.001f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AQUARION_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (GHAST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(Items.GHAST_TEAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 3.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (TRADER_LLAMA_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // Drops 10% of the time        0.1f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }


            if (IRON_GOLEM_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1.0% of the time      0.01f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_3))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }





            if (ENDER_DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AETHERIUM_PRISM))
                        .with(ItemEntry.builder(Blocks.DRAGON_EGG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (WITHER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.PYROCITE_CORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.FERRITE_HEARTSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% drop chance
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(Items.ECHO_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (ELDER_GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% drop chance      0.1f
                        .conditionally(KilledByPlayerLootCondition.builder().build()) // Only when killed by player
                        .with(ItemEntry.builder(ModItems.AQUARION_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (isChestLootTable(id)) {
                addLootToChests(tableBuilder);
            }
        }));
    }

    private static boolean isChestLootTable(Identifier id) {
        return
                id.equals(new Identifier("minecraft", "chests/abandoned_mineshaft")) ||
                        id.equals(new Identifier("minecraft", "chests/ancient_city")) ||
                        id.equals(new Identifier("minecraft", "chests/ancient_city_ice_box")) ||
                        id.equals(new Identifier("minecraft", "chests/bastion_bridge")) ||
                        id.equals(new Identifier("minecraft", "chests/bastion_hoglin_stable")) ||
                        id.equals(new Identifier("minecraft", "chests/bastion_other")) ||
                        id.equals(new Identifier("minecraft", "chests/bastion_treasure")) ||
                        id.equals(new Identifier("minecraft", "chests/buried_treasure")) ||
                        id.equals(new Identifier("minecraft", "chests/desert_pyramid")) ||
                        id.equals(new Identifier("minecraft", "chests/end_city_treasure")) ||
                        id.equals(new Identifier("minecraft", "chests/igloo_chest")) ||
                        id.equals(new Identifier("minecraft", "chests/jungle_temple")) ||
                        id.equals(new Identifier("minecraft", "chests/jungle_temple_dispenser")) ||
                        id.equals(new Identifier("minecraft", "chests/nether_bridge")) ||
                        id.equals(new Identifier("minecraft", "chests/pillager_outpost")) ||
                        id.equals(new Identifier("minecraft", "chests/ruined_portal")) ||
                        id.equals(new Identifier("minecraft", "chests/shipwreck_map")) ||
                        id.equals(new Identifier("minecraft", "chests/shipwreck_supply")) ||
                        id.equals(new Identifier("minecraft", "chests/shipwreck_treasure")) ||
                        id.equals(new Identifier("minecraft", "chests/simple_dungeon")) ||
                        id.equals(new Identifier("minecraft", "chests/spawn_bonus_chest")) ||
                        id.equals(new Identifier("minecraft", "chests/stronghold_corridor")) ||
                        id.equals(new Identifier("minecraft", "chests/stronghold_crossing")) ||
                        id.equals(new Identifier("minecraft", "chests/stronghold_library")) ||
                        id.equals(new Identifier("minecraft", "chests/underwater_ruin_big")) ||
                        id.equals(new Identifier("minecraft", "chests/underwater_ruin_small")) ||
                        id.equals(new Identifier("minecraft", "chests/woodland_mansion"));
    }

    private static void addLootToChests(LootTable.Builder tableBuilder) {
        LootPool.Builder poolBuilder_gem = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.10f)) // Drops 10% of the time
                .with(ItemEntry.builder(ModItems.LUMINITE_SPARK))
                .with(ItemEntry.builder(ModItems.OBSCURIUM_CRYSTAL))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_helmet = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.0025f)) // Drops 0.25% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_HELMET_4))
                .with(ItemEntry.builder(ModItems.HELMET_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_chestplate = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.0025f)) // Drops 0.25% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_CHESTPLATE_4))
                .with(ItemEntry.builder(ModItems.CHESTPLATE_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_leggings = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.0025f)) // Drops 0.25% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_LEGGINGS_4))
                .with(ItemEntry.builder(ModItems.LEGGINGS_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_boots = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.0025f)) // Drops 0.25% of the time
                .with(ItemEntry.builder(ModItems.FOOLS_GOLD_BOOTS_4))
                .with(ItemEntry.builder(ModItems.BOOTS_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_bucket = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.01f)) // Drops 1% of the time
                .with(ItemEntry.builder(ModItems.BUCKET_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_pickaxe = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.PICKAXE_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_axe = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.AXE_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_shovel = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.SHOVEL_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_hoe = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.HOE_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_sword = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.SWORD_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_shears = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.SHEARS_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_shield = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.001f)) // Drops 0.1% of the time
                .with(ItemEntry.builder(ModItems.SHIELD_MOULD))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_20 = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1.0f, 3.0f))
                .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops 20% of the time
                .with(ItemEntry.builder(ModItems.BLANK_MOULD))
                .with(ItemEntry.builder(ModItems.CORE_OF_CHANGING))
                .with(ItemEntry.builder(ModItems.TROWEL))
                .with(ItemEntry.builder(ModItems.MORTAR_AND_PESTLE))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

        LootPool.Builder poolBuilder_40 = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.4f)) // Drops 40% of the time
                .with(ItemEntry.builder(ModItems.BLANK_MOULD))
                .with(ItemEntry.builder(ModItems.CORE_OF_CHANGING))
                .with(ItemEntry.builder(ModItems.RAW_SILVER))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 10.0f)).build());


        tableBuilder.pool(poolBuilder_gem.build());
        tableBuilder.pool(poolBuilder_helmet.build());
        tableBuilder.pool(poolBuilder_chestplate.build());
        tableBuilder.pool(poolBuilder_leggings.build());
        tableBuilder.pool(poolBuilder_boots.build());

        tableBuilder.pool(poolBuilder_bucket.build());
        tableBuilder.pool(poolBuilder_pickaxe.build());
        tableBuilder.pool(poolBuilder_axe.build());
        tableBuilder.pool(poolBuilder_shovel.build());
        tableBuilder.pool(poolBuilder_hoe.build());
        tableBuilder.pool(poolBuilder_sword.build());
        tableBuilder.pool(poolBuilder_shears.build());
        tableBuilder.pool(poolBuilder_shield.build());

        tableBuilder.pool(poolBuilder_20.build());
        tableBuilder.pool(poolBuilder_40.build());
    }


}