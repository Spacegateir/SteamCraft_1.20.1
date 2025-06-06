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
import net.spacegateir.steamcraft.item.ModRewardItems;

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
                .add(ModItems.FOOLS_GOLD_HELMET, ModItems.FOOLS_GOLD_CHESTPLATE, ModItems.FOOLS_GOLD_LEGGINGS, ModItems.FOOLS_GOLD_BOOTS)
                .add(ModRewardItems.ADAMANTITE_HELMET, ModRewardItems.ADAMANTITE_CHESTPLATE, ModRewardItems.ADAMANTITE_LEGGINGS, ModRewardItems.ADAMANTITE_BOOTS)
                .add(ModRewardItems.DRAGON_BANE_HELMET, ModRewardItems.DRAGON_BANE_CHESTPLATE, ModRewardItems.DRAGON_BANE_LEGGINGS, ModRewardItems.DRAGON_BANE_BOOTS)
                .add(ModRewardItems.ORIKALKUM_HELMET, ModRewardItems.ORIKALKUM_CHESTPLATE, ModRewardItems.ORIKALKUM_LEGGINGS, ModRewardItems.ORIKALKUM_BOOTS)
                .add(ModRewardItems.DWARF_STEEL_HELMET, ModRewardItems.DWARF_STEEL_CHESTPLATE, ModRewardItems.DWARF_STEEL_LEGGINGS, ModRewardItems.DWARF_STEEL_BOOTS)
                .add(ModRewardItems.AQUA_HELMET, ModRewardItems.AQUA_CHESTPLATE, ModRewardItems.AQUA_LEGGINGS, ModRewardItems.AQUA_BOOTS)
                .add(ModRewardItems.AER_HELMET, ModRewardItems.AER_CHESTPLATE, ModRewardItems.AER_LEGGINGS, ModRewardItems.AER_BOOTS)
                .add(ModRewardItems.TERA_HELMET, ModRewardItems.TERA_CHESTPLATE, ModRewardItems.TERA_LEGGINGS, ModRewardItems.TERA_BOOTS)
                .add(ModRewardItems.IGNIS_HELMET, ModRewardItems.IGNIS_CHESTPLATE, ModRewardItems.IGNIS_LEGGINGS, ModRewardItems.IGNIS_BOOTS)
                .add(ModRewardItems.MYTHRIL_HELMET, ModRewardItems.MYTHRIL_CHESTPLATE, ModRewardItems.MYTHRIL_LEGGINGS, ModRewardItems.MYTHRIL_BOOTS)
                .add(ModRewardItems.MAGIRITE_HELMET, ModRewardItems.MAGIRITE_CHESTPLATE, ModRewardItems.MAGIRITE_LEGGINGS, ModRewardItems.MAGIRITE_BOOTS);



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
