package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.arcane.ArcaneBlock;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AETHER_COIL);
        ModBlocks.COLOR_TO_AETHER_COIL.values().forEach(aetherCoil -> addDrop(aetherCoil, dropsWithSilkTouch(aetherCoil, ItemEntry.builder(ModBlocks.AETHER_COIL))));

        addDrop(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
        addDrop(ModBlocks.FOOLS_GOLD_BLOCK);

        addDrop(ModBlocks.CLAY_PATH, dropsWithSilkTouch(ModBlocks.CLAY_PATH, ItemEntry.builder(Blocks.CLAY)));
        addDrop(ModBlocks.COARSE_DIRT_PATH, dropsWithSilkTouch(ModBlocks.COARSE_DIRT_PATH, ItemEntry.builder(Blocks.COARSE_DIRT)));
        addDrop(ModBlocks.DIRT_PATH, dropsWithSilkTouch(ModBlocks.DIRT_PATH, ItemEntry.builder(Blocks.DIRT)));
        addDrop(ModBlocks.GRAVEL_PATH, dropsWithSilkTouch(ModBlocks.GRAVEL_PATH, ItemEntry.builder(Blocks.GRAVEL)));
        addDrop(ModBlocks.MUD_PATH, dropsWithSilkTouch(ModBlocks.MUD_PATH, ItemEntry.builder(Blocks.MUD)));
        addDrop(ModBlocks.RED_SAND_PATH, dropsWithSilkTouch(ModBlocks.RED_SAND_PATH, ItemEntry.builder(Blocks.RED_SAND)));
        addDrop(ModBlocks.ROOTED_DIRT_PATH, dropsWithSilkTouch(ModBlocks.ROOTED_DIRT_PATH, ItemEntry.builder(Blocks.ROOTED_DIRT)));
        addDrop(ModBlocks.SAND_PATH, dropsWithSilkTouch(ModBlocks.SAND_PATH, ItemEntry.builder(Blocks.SAND)));
        addDrop(ModBlocks.SNOW_PATH, dropsWithSilkTouch(ModBlocks.SNOW_PATH, ItemEntry.builder(Blocks.SNOW_BLOCK)));
        addDrop(ModBlocks.ANDESITE_PATH, dropsWithSilkTouch(ModBlocks.ANDESITE_PATH, ItemEntry.builder(Blocks.ANDESITE)));
        addDrop(ModBlocks.ANDESITE_MOSSY_PATH, dropsWithSilkTouch(ModBlocks.ANDESITE_MOSSY_PATH, ItemEntry.builder(Blocks.ANDESITE)));
        addDrop(ModBlocks.ANDESITE_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.ANDESITE_DIRTY_PATH, ItemEntry.builder(Blocks.ANDESITE)));
        addDrop(ModBlocks.COBBLESTONE_PATH, dropsWithSilkTouch(ModBlocks.COBBLESTONE_PATH, ItemEntry.builder(Blocks.COBBLESTONE)));
        addDrop(ModBlocks.MOSSY_COBBLESTONE_PATH, dropsWithSilkTouch(ModBlocks.MOSSY_COBBLESTONE_PATH, ItemEntry.builder(Blocks.MOSSY_COBBLESTONE)));
        addDrop(ModBlocks.COBBLED_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.COBBLED_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLESTONE)));
        addDrop(ModBlocks.COBBLED_DEEPSLATE_PATH, dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE)));
        addDrop(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH, dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE)));
        addDrop(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH, ItemEntry.builder(Blocks.COBBLED_DEEPSLATE)));
        addDrop(ModBlocks.DIORITE_PATH, dropsWithSilkTouch(ModBlocks.DIORITE_PATH, ItemEntry.builder(Blocks.DIORITE)));
        addDrop(ModBlocks.DIORITE_MOSSY_PATH, dropsWithSilkTouch(ModBlocks.DIORITE_MOSSY_PATH, ItemEntry.builder(Blocks.DIORITE)));
        addDrop(ModBlocks.DIORITE_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.DIORITE_DIRTY_PATH, ItemEntry.builder(Blocks.DIORITE)));
        addDrop(ModBlocks.GRANITE_PATH, dropsWithSilkTouch(ModBlocks.GRANITE_PATH, ItemEntry.builder(Blocks.GRANITE)));
        addDrop(ModBlocks.GRANITE_MOSSY_PATH, dropsWithSilkTouch(ModBlocks.GRANITE_MOSSY_PATH, ItemEntry.builder(Blocks.GRANITE)));
        addDrop(ModBlocks.GRANITE_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.GRANITE_DIRTY_PATH, ItemEntry.builder(Blocks.GRANITE)));
        addDrop(ModBlocks.STONE_PATH, dropsWithSilkTouch(ModBlocks.STONE_PATH, ItemEntry.builder(Blocks.STONE)));
        addDrop(ModBlocks.STONE_MOSSY_PATH, dropsWithSilkTouch(ModBlocks.STONE_MOSSY_PATH, ItemEntry.builder(Blocks.STONE)));
        addDrop(ModBlocks.STONE_DIRTY_PATH, dropsWithSilkTouch(ModBlocks.STONE_DIRTY_PATH, ItemEntry.builder(Blocks.STONE)));
        addDrop(ModBlocks.END_STONE_PATH, dropsWithSilkTouch(ModBlocks.END_STONE_PATH, ItemEntry.builder(Blocks.END_STONE)));

// Minecraft blocks
        addDrop(Blocks.BUDDING_AMETHYST, dropsWithSilkTouch(Blocks.BUDDING_AMETHYST, ItemEntry.builder(Blocks.AMETHYST_BLOCK)));
        addDrop(Blocks.SPAWNER, dropsWithSilkTouch(Blocks.SPAWNER, ItemEntry.builder(Blocks.SPAWNER)));
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

        ModBlocks.COLOR_TO_FLOWER.values().forEach(this::addDrop);
        ModBlocks.FLOWER_TO_GLOW_FLOWER.values().forEach(this::addDrop);

        ModBlocks.FLOWER_TO_THORNED_FLOWER.values().forEach(this::addDrop);
        ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.values().forEach(this::addDrop);

        ModBlocks.FLOWER_TO_LUSH_FLOWER.values().forEach(this::addDrop);
        ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.values().forEach(this::addDrop);

        addDrop(ModBlocks.POWER_PRECISION_BLOCK);

        Registries.BLOCK.stream()
                .filter(block -> block instanceof ArcaneBlock)
                .forEach(this::addDrop);

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

        ModBlocks.COLOR_TO_COBBLED_CONCRETE.values().forEach(this::addDrop);
        ModBlocks.COLOR_TO_COBBLED_CONCRETE_POWDER.values().forEach(this::addDrop);

        addDrop(ModBlocks.PACKED_ICE_BRICKS);
        addDrop(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
        addDrop(ModBlocks.PACKED_ICE_TILES);
        addDrop(ModBlocks.PACKED_ICE_TILES_CRACKED);
        addDrop(ModBlocks.SNOW_BRICKS);
        addDrop(ModBlocks.SNOW_BRICKS_CRACKED);
        addDrop(ModBlocks.SNOW_TILES);
        addDrop(ModBlocks.SNOW_TILES_CRACKED);
    }
}