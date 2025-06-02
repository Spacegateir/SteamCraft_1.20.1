package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
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


        FabricTagProvider<Item>.FabricTagBuilder aetherCoilsTagBuilder = getOrCreateTagBuilder(net.spacegateir.steamcraft.util.ModTags.Items.AETHER_COIL);
        ModBlocks.COLOR_TO_AETHER_COIL.values().forEach(coilBlock -> aetherCoilsTagBuilder.add(coilBlock.asItem()));
        aetherCoilsTagBuilder.add(
                ModBlocks.AETHER_COIL.asItem()
        );

        getOrCreateTagBuilder(net.spacegateir.steamcraft.util.ModTags.Items.ANCIENT_GEMS).add(
                ModItems.FERRITE_HEARTSTONE,
                ModItems.AETHERIUM_PRISM,
                ModItems.AQUARION_SHARD,
                ModItems.PYROCITE_CORE,
                ModItems.LUMINITE_SPARK,
                ModItems.OBSCURIUM_CRYSTAL
        );
    }
}
