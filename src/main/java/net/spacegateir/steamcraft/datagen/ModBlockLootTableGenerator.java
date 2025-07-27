package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.custom.ModCropBlock;
import net.spacegateir.steamcraft.item.ModItems;
import net.minecraft.loot.*;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.*;
import net.minecraft.loot.function.*;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.item.Items;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;


public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        Block block = ModBlocks.ANCIENT_GRAVEL_BLOCK;
        LootPoolEntry.Builder<?> silkTouchEntry = ItemEntry.builder(block)
                .conditionally(MatchToolLootCondition.builder(
                        ItemPredicate.Builder.create()
                                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))
                ));
        LootPoolEntry.Builder<?> flintEntry = ItemEntry.builder(Items.FLINT)
                .conditionally(TableBonusLootCondition.builder(
                        Enchantments.FORTUNE,
                        new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}
                ))
                .conditionally(SurvivesExplosionLootCondition.builder());
        LootPoolEntry.Builder<?> gravelEntry = ItemEntry.builder(ModItems.ANCIENT_GRAVEL_ITEM)
                .conditionally(SurvivesExplosionLootCondition.builder());
        this.addDrop(block, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(silkTouchEntry)
                        .with(flintEntry)
                        .with(gravelEntry)
                )
        );
        addDrop(ModBlocks.ANCIENT_SAND_BLOCK);
        addDrop(ModBlocks.ANCIENT_SILT_BLOCK);

        addDrop(ModBlocks.ANCIENT_LOAM_BLOCK,
                dropsWithSilkTouch(ModBlocks.ANCIENT_LOAM_BLOCK, ItemEntry.builder(Blocks.DIRT))
        );
        addDrop(ModBlocks.ANCIENT_MUD_BLOCK);
        addDrop(ModBlocks.ANCIENT_CLAY_BLOCK,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.ANCIENT_CLAY_BLOCK)
                                        .conditionally(MatchToolLootCondition.builder(
                                                ItemPredicate.Builder.create()
                                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))))
                                .with(ItemEntry.builder(ModItems.ANCIENT_CLAY)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
                                        .conditionally(SurvivesExplosionLootCondition.builder())))
        );
        addDrop(ModBlocks.ANCIENT_MOIST_CLAY_BLOCK,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.ANCIENT_MOIST_CLAY_BLOCK)
                                        .conditionally(MatchToolLootCondition.builder(
                                                ItemPredicate.Builder.create()
                                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))))
                                .with(ItemEntry.builder(ModItems.ANCIENT_MOIST_CLAY)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
                                        .conditionally(SurvivesExplosionLootCondition.builder())))
        );

        addDrop(ModBlocks.AETHER_COIL);
        addDrop(ModBlocks.AETHER_COIL_WHITE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_WHITE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIGHT_GRAY,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIGHT_GRAY, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_GRAY,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_GRAY, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BLACK,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BLACK, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BROWN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BROWN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_RED,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_RED, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_ORANGE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_ORANGE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_YELLOW,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_YELLOW, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIME,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIME, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_GREEN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_GREEN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_CYAN,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_CYAN, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_LIGHT_BLUE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_LIGHT_BLUE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_BLUE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_BLUE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_PURPLE,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_PURPLE, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_MAGENTA,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_MAGENTA, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );
        addDrop(ModBlocks.AETHER_COIL_PINK,
                dropsWithSilkTouch(ModBlocks.AETHER_COIL_PINK, ItemEntry.builder(ModBlocks.AETHER_COIL))
        );

        addDrop(ModBlocks.RAW_SILVER_BLOCK);
        addDrop(ModBlocks.SILVER_BLOCK);
        addDrop(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
        addDrop(ModBlocks.FOOLS_GOLD_BLOCK);
        addDrop(ModBlocks.DIVINITITE_ALLOY_BLOCK);

        addDrop(ModBlocks.CLAY_PATH,
                dropsWithSilkTouch(ModBlocks.CLAY_PATH, ItemEntry.builder(Blocks.CLAY))
        );
        addDrop(ModBlocks.COARSE_DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.COARSE_DIRT_PATH, ItemEntry.builder(Blocks.COARSE_DIRT))
        );
        addDrop(ModBlocks.DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.DIRT_PATH, ItemEntry.builder(Blocks.DIRT))
        );
        addDrop(ModBlocks.GRAVEL_PATH,
                dropsWithSilkTouch(ModBlocks.GRAVEL_PATH, ItemEntry.builder(Blocks.GRAVEL))
        );
        addDrop(ModBlocks.MUD_PATH,
                dropsWithSilkTouch(ModBlocks.MUD_PATH, ItemEntry.builder(Blocks.MUD))
        );
        addDrop(ModBlocks.RED_SAND_PATH,
                dropsWithSilkTouch(ModBlocks.RED_SAND_PATH, ItemEntry.builder(Blocks.RED_SAND))
        );
        addDrop(ModBlocks.ROOTED_DIRT_PATH,
                dropsWithSilkTouch(ModBlocks.ROOTED_DIRT_PATH, ItemEntry.builder(Blocks.ROOTED_DIRT))
        );
        addDrop(ModBlocks.SAND_PATH,
                dropsWithSilkTouch(ModBlocks.SAND_PATH, ItemEntry.builder(Blocks.SAND))
        );
        addDrop(ModBlocks.SNOW_PATH,
                dropsWithSilkTouch(ModBlocks.SNOW_PATH, ItemEntry.builder(Blocks.SNOW_BLOCK))
        );
        addDrop(ModBlocks.ANDESITE_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.ANDESITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_MOSSY_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.ANDESITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.ANDESITE_DIRTY_PATH, ItemEntry.builder(Blocks.ANDESITE))
        );
        addDrop(ModBlocks.COBBLESTONE_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLESTONE_PATH, ItemEntry.builder(Blocks.COBBLESTONE))
        );
        addDrop(ModBlocks.MOSSY_COBBLESTONE_PATH,
                dropsWithSilkTouch(ModBlocks.MOSSY_COBBLESTONE_PATH, ItemEntry.builder(Blocks.MOSSY_COBBLESTONE))
        );
        addDrop(ModBlocks.COBBLED_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLESTONE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE))
        );
        addDrop(ModBlocks.DIORITE_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.DIORITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_MOSSY_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.DIORITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.DIORITE_DIRTY_PATH, ItemEntry.builder(Blocks.DIORITE))
        );
        addDrop(ModBlocks.GRANITE_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.GRANITE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_MOSSY_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.GRANITE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.GRANITE_DIRTY_PATH, ItemEntry.builder(Blocks.GRANITE))
        );
        addDrop(ModBlocks.STONE_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.STONE_MOSSY_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_MOSSY_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.STONE_DIRTY_PATH,
                dropsWithSilkTouch(ModBlocks.STONE_DIRTY_PATH, ItemEntry.builder(Blocks.STONE))
        );
        addDrop(ModBlocks.END_STONE_PATH,
                dropsWithSilkTouch(ModBlocks.END_STONE_PATH, ItemEntry.builder(Blocks.END_STONE))
        );

// Minecraft blocks
        addDrop(Blocks.BUDDING_AMETHYST,
                dropsWithSilkTouch(Blocks.BUDDING_AMETHYST, ItemEntry.builder(Blocks.AMETHYST_BLOCK))
        );
        addDrop(Blocks.SPAWNER,
                dropsWithSilkTouch(Blocks.SPAWNER, ItemEntry.builder(Blocks.SPAWNER))
        );
        addDrop(Blocks.REINFORCED_DEEPSLATE);

// Mob Parts
        addDrop(ModBlocks.SKELETON_ARM);
        addDrop(ModBlocks.SKELETON_CHEST);
        addDrop(ModBlocks.SKELETON_HEAD);
        addDrop(ModBlocks.SKELETON_LEG);
        addDrop(ModBlocks.SKELETON_PELVIS);
        addDrop(ModBlocks.SKELETON_ARMS_CROSS);
        addDrop(ModBlocks.SKELETON_HALF_BODY);
        addDrop(ModBlocks.SKELETON_HEAD_STACK);
        addDrop(ModBlocks.SKELETON_LAYING);
        addDrop(ModBlocks.SKELETON_LEGS_CROSS);
        addDrop(ModBlocks.SKELETON_TORSO);
        addDrop(ModBlocks.SKELETON_SITTING);
        addDrop(ModBlocks.SKELETON_SPINE);


        // Normal Flowers
        addDrop(ModBlocks.BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_VIOLET_FLOWER_BLOCK);

        // Thorned Flowers
        addDrop(ModBlocks.THORNED_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.THORNED_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_THORNED_AGAPANTHUS_FLOWER_BLOCK);

        // Lush Flowers
        addDrop(ModBlocks.LUSH_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_BONSAI_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_CARNATION_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DAFFODIL_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DAHLIA_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_DELPHINIUM_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_HAWTHORN_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_HYDRANGEA_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_IRIS_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_LARKSPUR_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_PRIMROSE_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_SNOW_DROP_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_SPIDERLILY_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_VIOLET_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_BLUE_COSMOS_FLOWER_BLOCK);
        addDrop(ModBlocks.LUSH_AGAPANTHUS_FLOWER_BLOCK);
        addDrop(ModBlocks.GLOW_LUSH_AGAPANTHUS_FLOWER_BLOCK);

        addDrop(ModBlocks.POWER_PRECISION_BLOCK);

        addDrop(ModBlocks.ARCANE_ABSORPTION_BLOCK);
        addDrop(ModBlocks.ARCANE_BAD_OMEN_BLOCK);
        addDrop(ModBlocks.ARCANE_BLINDNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_CONDUIT_BLOCK);
        addDrop(ModBlocks.ARCANE_DARKNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK);
        addDrop(ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK);
        addDrop(ModBlocks.ARCANE_GLOWING_BLOCK);
        addDrop(ModBlocks.ARCANE_HASTE_BLOCK);
        addDrop(ModBlocks.ARCANE_HEALTH_BOOST_BLOCK);
        addDrop(ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK);
        addDrop(ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK);
        addDrop(ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK);
        addDrop(ModBlocks.ARCANE_INVISIBILITY_BLOCK);
        addDrop(ModBlocks.ARCANE_JUMP_BOOST_BLOCK);
        addDrop(ModBlocks.ARCANE_LEVITATION_BLOCK);
        addDrop(ModBlocks.ARCANE_LUCK_BLOCK);
        addDrop(ModBlocks.ARCANE_MINING_FATIGUE_BLOCK);
        addDrop(ModBlocks.ARCANE_NEAUSEA_BLOCK);
        addDrop(ModBlocks.ARCANE_NIGHT_VISION_BLOCK);
        addDrop(ModBlocks.ARCANE_POISION_BLOCK);
        addDrop(ModBlocks.ARCANE_REGENERATION_BLOCK);
        addDrop(ModBlocks.ARCANE_RESISTANCE_BLOCK);
        addDrop(ModBlocks.ARCANE_SATUATION_BLOCK);
        addDrop(ModBlocks.ARCANE_SLOW_FALL_BLOCK);
        addDrop(ModBlocks.ARCANE_SLOWNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_SPEED_BLOCK);
        addDrop(ModBlocks.ARCANE_STARVING_BLOCK);
        addDrop(ModBlocks.ARCANE_STRENGTH_BLOCK);
        addDrop(ModBlocks.ARCANE_UNLUCK_BLOCK);
        addDrop(ModBlocks.ARCANE_WATER_BREATHING_BLOCK);
        addDrop(ModBlocks.ARCANE_WEAKNESS_BLOCK);
        addDrop(ModBlocks.ARCANE_WITHER_BLOCK);
        addDrop(ModBlocks.ARCANE_VOID_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK);
        addDrop(ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK);
        addDrop(ModBlocks.ARCANE_DISORIENT_BLOCK);
        addDrop(ModBlocks.ARCANE_STICKY_FEAT_BLOCK);
        addDrop(ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK);

        addDrop(ModBlocks.CURSED_BLOCK);
        addDrop(ModBlocks.COURSE_DIRT_TRAP_BLOCK);
        addDrop(ModBlocks.STONE_TRAP_BLOCK);
        addDrop(ModBlocks.DEEPSLATE_TRAP_BLOCK);
        addDrop(ModBlocks.FLAREFORGE_BLOCK);
        addDrop(ModBlocks.NETHER_STEAM_VENT);
        addDrop(ModBlocks.SPIRIT_JUMP_TRAP);
        addDrop(ModBlocks.FROST_BITE_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK);
        addDrop(ModBlocks.CURSED_BRASIER_TRAP_BLOCK);
        addDrop(ModBlocks.EMPTY_BRASIER);
        addDrop(ModBlocks.CURSED_TOTEM_BLOCK);
        addDrop(ModBlocks.TELEPORT_TRAP_BLOCK);
        addDrop(ModBlocks.SAND_QUICKSAND);
        addDrop(ModBlocks.RED_SAND_QUICKSAND);
        addDrop(ModBlocks.GRAVEL_SINKSTONE);
        addDrop(ModBlocks.MUD_SINKING_SLUDGE);
        addDrop(ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND);

        addDrop(ModBlocks.SMOKE_BLOCK);

        addDrop(ModBlocks.COBBLED_WHITE_CONCRETE);
        addDrop(ModBlocks.COBBLED_WHITE_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE);
        addDrop(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_GRAY_CONCRETE);
        addDrop(ModBlocks.COBBLED_GRAY_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_BLACK_CONCRETE);
        addDrop(ModBlocks.COBBLED_BLACK_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_BROWN_CONCRETE);
        addDrop(ModBlocks.COBBLED_BROWN_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_RED_CONCRETE);
        addDrop(ModBlocks.COBBLED_RED_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_ORANGE_CONCRETE);
        addDrop(ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_YELLOW_CONCRETE);
        addDrop(ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_LIME_CONCRETE);
        addDrop(ModBlocks.COBBLED_LIME_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_GREEN_CONCRETE);
        addDrop(ModBlocks.COBBLED_GREEN_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_CYAN_CONCRETE);
        addDrop(ModBlocks.COBBLED_CYAN_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE);
        addDrop(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_BLUE_CONCRETE);
        addDrop(ModBlocks.COBBLED_BLUE_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_PURPLE_CONCRETE);
        addDrop(ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_MAGENTA_CONCRETE);
        addDrop(ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER);
        addDrop(ModBlocks.COBBLED_PINK_CONCRETE);
        addDrop(ModBlocks.COBBLED_PINK_CONCRETE_POWDER);

        addDrop(ModBlocks.PACKED_ICE_BRICKS);
        addDrop(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
        addDrop(ModBlocks.PACKED_ICE_TILES);
        addDrop(ModBlocks.PACKED_ICE_TILES_CRACKED);
        addDrop(ModBlocks.SNOW_BRICKS);
        addDrop(ModBlocks.SNOW_BRICKS_CRACKED);
        addDrop(ModBlocks.SNOW_TILES);
        addDrop(ModBlocks.SNOW_TILES_CRACKED);

//        Cauldrons

        addDrop(ModBlocks.WHITE_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.WHITE_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.BLACK_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.BLACK_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.BLUE_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.BLUE_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.LIGHT_BLUE_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.LIGHT_BLUE_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.BROWN_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.BROWN_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.CYAN_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.CYAN_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.GRAY_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.GRAY_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.LIGHT_GRAY_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.LIGHT_GRAY_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.GREEN_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.GREEN_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.LIME_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.LIME_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.MAGENTA_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.MAGENTA_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.ORANGE_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.ORANGE_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.PINK_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.PINK_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.PURPLE_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.PURPLE_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.RED_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.RED_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));

        addDrop(ModBlocks.YELLOW_LAVA_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));
        addDrop(ModBlocks.YELLOW_WATER_CAULDRON_BLOCK,
                dropsWithSilkTouch(Blocks.CAULDRON, ItemEntry.builder(Blocks.CAULDRON)));


//        Glimmerstones
        addDrop(ModBlocks.GLIMMERSTONE_BLOCK,
                dropsWithSilkTouch(ModBlocks.GLIMMERSTONE_BLOCK, ItemEntry.builder(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK)));
        addDrop(ModBlocks.GLIMMERSTONE_STAIR_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_SLAB_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_WALL_BLOCK);

        addDrop(ModBlocks.GLIMMERSTONE_COBBLESTONE_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_COBBLESTONE_STAIR_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_COBBLESTONE_SLAB_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_COBBLESTONE_WALL_BLOCK);

        addDrop(ModBlocks.GLIMMERSTONE_BRICKS_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_BRICKS_STAIR_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_BRICKS_SLAB_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_BRICKS_WALL_BLOCK);

        addDrop(ModBlocks.GLIMMERSTONE_PILLAR_BLOCK);
        addDrop(ModBlocks.GLIMMERSTONE_ENGRAVED_BLOCK);



        addDrop(ModBlocks.FARMLAND_ENRICHED_BLOCK,
                dropsWithSilkTouch(Blocks.DIRT, ItemEntry.builder(Blocks.DIRT)));


        addDrop(ModBlocks.MORTAR_AND_PESTLE_BLOCK);

        addDrop(ModBlocks.GAMEBOARD_BLOCK);
        addDrop(ModBlocks.MEDKIT);
        addDrop(ModBlocks.POT);
        addDrop(ModBlocks.PAN);

        addDrop(ModBlocks.PARTICIPATION_TROPHY_BLOCK);
        addDrop(ModBlocks.COPPER_TROPHY_BLOCK);
        addDrop(ModBlocks.SILVER_TROPHY_BLOCK);
        addDrop(ModBlocks.GOLD_TROPHY_BLOCK);

    }

        // Auto-generated crop drops
        private void registerAllCropDrops() {
            registerCropDrop(ModBlocks.CARNATION_CROP, ModItems.CARNATION_FLOWER_ITEM, ModItems.CARNATION_SEED);
            registerCropDrop(ModBlocks.LUSH_CARNATION_CROP, ModItems.LUSH_CARNATION_FLOWER_ITEM, ModItems.LUSH_CARNATION_SEED);
            registerCropDrop(ModBlocks.THORNED_CARNATION_CROP, ModItems.THORNED_CARNATION_FLOWER_ITEM, ModItems.THORNED_CARNATION_SEED);

            registerCropDrop(ModBlocks.VIOLET_CROP, ModItems.VIOLET_FLOWER_ITEM, ModItems.VIOLET_SEED);
            registerCropDrop(ModBlocks.LUSH_VIOLET_CROP, ModItems.LUSH_VIOLET_FLOWER_ITEM, ModItems.LUSH_VIOLET_SEED);
            registerCropDrop(ModBlocks.THORNED_VIOLET_CROP, ModItems.THORNED_VIOLET_FLOWER_ITEM, ModItems.THORNED_VIOLET_SEED);

            registerCropDrop(ModBlocks.IRIS_CROP, ModItems.IRIS_FLOWER_ITEM, ModItems.IRIS_SEED);
            registerCropDrop(ModBlocks.LUSH_IRIS_CROP, ModItems.LUSH_IRIS_FLOWER_ITEM, ModItems.LUSH_IRIS_SEED);
            registerCropDrop(ModBlocks.THORNED_IRIS_CROP, ModItems.THORNED_IRIS_FLOWER_ITEM, ModItems.THORNED_IRIS_SEED);

            registerCropDrop(ModBlocks.PRIMROSE_CROP, ModItems.PRIMROSE_FLOWER_ITEM, ModItems.PRIMROSE_SEED);
            registerCropDrop(ModBlocks.LUSH_PRIMROSE_CROP, ModItems.LUSH_PRIMROSE_FLOWER_ITEM, ModItems.LUSH_PRIMROSE_SEED);
            registerCropDrop(ModBlocks.THORNED_PRIMROSE_CROP, ModItems.THORNED_PRIMROSE_FLOWER_ITEM, ModItems.THORNED_PRIMROSE_SEED);

            registerCropDrop(ModBlocks.DAFFODIL_CROP, ModItems.DAFFODIL_FLOWER_ITEM, ModItems.DAFFODIL_SEED);
            registerCropDrop(ModBlocks.LUSH_DAFFODIL_CROP, ModItems.LUSH_DAFFODIL_FLOWER_ITEM, ModItems.LUSH_DAFFODIL_SEED);
            registerCropDrop(ModBlocks.THORNED_DAFFODIL_CROP, ModItems.THORNED_DAFFODIL_FLOWER_ITEM, ModItems.THORNED_DAFFODIL_SEED);

            registerCropDrop(ModBlocks.DELPHINIUM_CROP, ModItems.DELPHINIUM_FLOWER_ITEM, ModItems.DELPHINIUM_SEED);
            registerCropDrop(ModBlocks.LUSH_DELPHINIUM_CROP, ModItems.LUSH_DELPHINIUM_FLOWER_ITEM, ModItems.LUSH_DELPHINIUM_SEED);
            registerCropDrop(ModBlocks.THORNED_DELPHINIUM_CROP, ModItems.THORNED_DELPHINIUM_FLOWER_ITEM, ModItems.THORNED_DELPHINIUM_SEED);

            registerCropDrop(ModBlocks.DAHLIA_CROP, ModItems.DAHLIA_FLOWER_ITEM, ModItems.DAHLIA_SEED);
            registerCropDrop(ModBlocks.LUSH_DAHLIA_CROP, ModItems.LUSH_DAHLIA_FLOWER_ITEM, ModItems.LUSH_DAHLIA_SEED);
            registerCropDrop(ModBlocks.THORNED_DAHLIA_CROP, ModItems.THORNED_DAHLIA_FLOWER_ITEM, ModItems.THORNED_DAHLIA_SEED);

            registerCropDrop(ModBlocks.HYDRANGEA_CROP, ModItems.HYDRANGEA_FLOWER_ITEM, ModItems.HYDRANGEA_SEED);
            registerCropDrop(ModBlocks.LUSH_HYDRANGEA_CROP, ModItems.LUSH_HYDRANGEA_FLOWER_ITEM, ModItems.LUSH_HYDRANGEA_SEED);
            registerCropDrop(ModBlocks.THORNED_HYDRANGEA_CROP, ModItems.THORNED_HYDRANGEA_FLOWER_ITEM, ModItems.THORNED_HYDRANGEA_SEED);

            registerCropDrop(ModBlocks.MIDNIGHT_MYSTIC_CROP, ModItems.MIDNIGHT_MYSTIC_FLOWER_ITEM, ModItems.MIDNIGHT_MYSTIC_SEED);
            registerCropDrop(ModBlocks.LUSH_MIDNIGHT_MYSTIC_CROP, ModItems.LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM, ModItems.LUSH_MIDNIGHT_MYSTIC_SEED);
            registerCropDrop(ModBlocks.THORNED_MIDNIGHT_MYSTIC_CROP, ModItems.THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM, ModItems.THORNED_MIDNIGHT_MYSTIC_SEED);

            registerCropDrop(ModBlocks.HAWTHORN_CROP, ModItems.HAWTHORN_FLOWER_ITEM, ModItems.HAWTHORN_SEED);
            registerCropDrop(ModBlocks.LUSH_HAWTHORN_CROP, ModItems.LUSH_HAWTHORN_FLOWER_ITEM, ModItems.LUSH_HAWTHORN_SEED);
            registerCropDrop(ModBlocks.THORNED_HAWTHORN_CROP, ModItems.THORNED_HAWTHORN_FLOWER_ITEM, ModItems.THORNED_HAWTHORN_SEED);

            registerCropDrop(ModBlocks.BONSAI_CROP, ModItems.BONSAI_FLOWER_ITEM, ModItems.BONSAI_SEED);
            registerCropDrop(ModBlocks.LUSH_BONSAI_CROP, ModItems.LUSH_BONSAI_FLOWER_ITEM, ModItems.LUSH_BONSAI_SEED);
            registerCropDrop(ModBlocks.THORNED_BONSAI_CROP, ModItems.THORNED_BONSAI_FLOWER_ITEM, ModItems.THORNED_BONSAI_SEED);

            registerCropDrop(ModBlocks.SPIDERLILY_CROP, ModItems.SPIDERLILY_FLOWER_ITEM, ModItems.SPIDERLILY_SEED);
            registerCropDrop(ModBlocks.LUSH_SPIDERLILY_CROP, ModItems.LUSH_SPIDERLILY_FLOWER_ITEM, ModItems.LUSH_SPIDERLILY_SEED);
            registerCropDrop(ModBlocks.THORNED_SPIDERLILY_CROP, ModItems.THORNED_SPIDERLILY_FLOWER_ITEM, ModItems.THORNED_SPIDERLILY_SEED);

            registerCropDrop(ModBlocks.LARKSPUR_CROP, ModItems.LARKSPUR_FLOWER_ITEM, ModItems.LARKSPUR_SEED);
            registerCropDrop(ModBlocks.LUSH_LARKSPUR_CROP, ModItems.LUSH_LARKSPUR_FLOWER_ITEM, ModItems.LUSH_LARKSPUR_SEED);
            registerCropDrop(ModBlocks.THORNED_LARKSPUR_CROP, ModItems.THORNED_LARKSPUR_FLOWER_ITEM, ModItems.THORNED_LARKSPUR_SEED);

            registerCropDrop(ModBlocks.AGAPANTHUS_CROP, ModItems.AGAPANTHUS_FLOWER_ITEM, ModItems.AGAPANTHUS_SEED);
            registerCropDrop(ModBlocks.LUSH_AGAPANTHUS_CROP, ModItems.LUSH_AGAPANTHUS_FLOWER_ITEM, ModItems.LUSH_AGAPANTHUS_SEED);
            registerCropDrop(ModBlocks.THORNED_AGAPANTHUS_CROP, ModItems.THORNED_AGAPANTHUS_FLOWER_ITEM, ModItems.THORNED_AGAPANTHUS_SEED);

            registerCropDrop(ModBlocks.BLUE_COSMOS_CROP, ModItems.BLUE_COSMOS_FLOWER_ITEM, ModItems.BLUE_COSMOS_SEED);
            registerCropDrop(ModBlocks.LUSH_BLUE_COSMOS_CROP, ModItems.LUSH_BLUE_COSMOS_FLOWER_ITEM, ModItems.LUSH_BLUE_COSMOS_SEED);
            registerCropDrop(ModBlocks.THORNED_BLUE_COSMOS_CROP, ModItems.THORNED_BLUE_COSMOS_FLOWER_ITEM, ModItems.THORNED_BLUE_COSMOS_SEED);

            registerCropDrop(ModBlocks.SNOW_DROP_CROP, ModItems.SNOW_DROP_FLOWER_ITEM, ModItems.SNOW_DROP_SEED);
            registerCropDrop(ModBlocks.LUSH_SNOW_DROP_CROP, ModItems.LUSH_SNOW_DROP_FLOWER_ITEM, ModItems.LUSH_SNOW_DROP_SEED);
            registerCropDrop(ModBlocks.THORNED_SNOW_DROP_CROP, ModItems.THORNED_SNOW_DROP_FLOWER_ITEM, ModItems.THORNED_SNOW_DROP_SEED);
        }

// Reusable helper
        private void registerCropDrop(Block cropBlock, ItemConvertible flowerItem, ItemConvertible seedItem) {
            LootCondition.Builder condition = BlockStatePropertyLootCondition.builder(cropBlock)
                    .properties(StatePredicate.Builder.create().exactMatch(ModCropBlock.AGE, ModCropBlock.MAX_AGE));
            this.addDrop(cropBlock, this.cropDrops(cropBlock, (Item) flowerItem, (Item) seedItem, condition));
        }
    }
