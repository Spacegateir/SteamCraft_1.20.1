package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static class ModTags {
        public static class Items {
            public static final TagKey<Item> DYES = TagKey.of(
                    RegistryKeys.ITEM,
                    new Identifier("steamcraft", "dyes")
            );

            public static final TagKey<Item> AETHER_COIL = TagKey.of(
                    net.minecraft.registry.Registries.ITEM.getKey(),
                    new Identifier("steamcraft", "aether_coil")
            );

            public static final TagKey<Item> ANCIENT_GEMS = TagKey.of(
                    net.minecraft.registry.Registries.ITEM.getKey(),
                    new Identifier("steamcraft", "ancient_gems")
            );
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FOOLS_GOLD_HELMET,ModItems.FOOLS_GOLD_CHESTPLATE,ModItems.FOOLS_GOLD_LEGGINGS,ModItems.FOOLS_GOLD_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.AETHER_COIL)
                .add(ModBlocks.AETHER_COIL.asItem())
                .add(ModBlocks.AETHER_COIL_WHITE.asItem())
                .add(ModBlocks.AETHER_COIL_LIGHT_GRAY.asItem())
                .add(ModBlocks.AETHER_COIL_GRAY.asItem())
                .add(ModBlocks.AETHER_COIL_BLACK.asItem())
                .add(ModBlocks.AETHER_COIL_BROWN.asItem())
                .add(ModBlocks.AETHER_COIL_RED.asItem())
                .add(ModBlocks.AETHER_COIL_ORANGE.asItem())
                .add(ModBlocks.AETHER_COIL_YELLOW.asItem())
                .add(ModBlocks.AETHER_COIL_LIME.asItem())
                .add(ModBlocks.AETHER_COIL_GREEN.asItem())
                .add(ModBlocks.AETHER_COIL_CYAN.asItem())
                .add(ModBlocks.AETHER_COIL_LIGHT_BLUE.asItem())
                .add(ModBlocks.AETHER_COIL_BLUE.asItem())
                .add(ModBlocks.AETHER_COIL_PURPLE.asItem())
                .add(ModBlocks.AETHER_COIL_MAGENTA.asItem())
                .add(ModBlocks.AETHER_COIL_PINK.asItem());

        getOrCreateTagBuilder(ModTags.Items.ANCIENT_GEMS)
                .add(ModItems.FERRITE_HEARTSTONE.asItem())
                .add(ModItems.AETHERIUM_PRISM.asItem())
                .add(ModItems.AQUARION_SHARD.asItem())
                .add(ModItems.PYROCITE_CORE.asItem())
                .add(ModItems.LUMINITE_SPARK.asItem())
                .add(ModItems.OBSCURIUM_CRYSTAL.asItem());

    }
}
