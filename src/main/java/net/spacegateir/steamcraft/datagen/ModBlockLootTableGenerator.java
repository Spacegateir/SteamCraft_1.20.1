package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.entry.ItemEntry;
import net.spacegateir.steamcraft.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
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



    }
}