package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.arcane.ArcaneBlock;
import net.spacegateir.steamcraft.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModTags.Blocks.SKELETON).add(
                ModBlocks.SKELETON_ARM,
                ModBlocks.SKELETON_CHEST,
                ModBlocks.SKELETON_HEAD,
                ModBlocks.SKELETON_LEG,
                ModBlocks.SKELETON_PELVIS,
                ModBlocks.SKELETON_ARMS_CROSS,
                ModBlocks.SKELETON_HALF_BODY,
                ModBlocks.SKELETON_HEAD_STACK,
                ModBlocks.SKELETON_LAYING,
                ModBlocks.SKELETON_LEGS_CROSS,
                ModBlocks.SKELETON_TORSO,
                ModBlocks.SKELETON_SITTING,
                ModBlocks.SKELETON_SPINE
        );

        FabricTagProvider<Block>.FabricTagBuilder arcaneBlocksTagBuilder = getOrCreateTagBuilder(ModTags.Blocks.ARCANE_BLOCKS);
        Registries.BLOCK.stream()
                .filter(block -> block instanceof ArcaneBlock)
                .forEach(arcaneBlocksTagBuilder::add);

        FabricTagProvider<Block>.FabricTagBuilder aetherCoilsTagBuilder = getOrCreateTagBuilder(ModTags.Blocks.AETHER_BLOCKS);
        aetherCoilsTagBuilder.add(ModBlocks.AETHER_COIL);
        ModBlocks.COLOR_TO_AETHER_COIL.values().forEach(aetherCoilsTagBuilder::add);

        getOrCreateTagBuilder(ModTags.Blocks.TRAPS).add(
                ModBlocks.CURSED_BLOCK,
                ModBlocks.COURSE_DIRT_TRAP_BLOCK,
                ModBlocks.STONE_TRAP_BLOCK,
                ModBlocks.DEEPSLATE_TRAP_BLOCK,
                ModBlocks.FLAREFORGE_BLOCK,
                ModBlocks.NETHER_STEAM_VENT,
                ModBlocks.SPIRIT_JUMP_TRAP,
                ModBlocks.FROST_BITE_TRAP_BLOCK,
                ModBlocks.CURSED_NAUSEA_TRAP_BLOCK,
                ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK,
                ModBlocks.CURSED_BRASIER_TRAP_BLOCK,
                ModBlocks.EMPTY_BRASIER,
                ModBlocks.CURSED_TOTEM_BLOCK,
                ModBlocks.TELEPORT_TRAP_BLOCK
        );

        FabricTagProvider<Block>.FabricTagBuilder buildingBlocksTagBuilder = getOrCreateTagBuilder(ModTags.Blocks.BUILDING_BLOCKS);
        ModBlocks.COLOR_TO_COBBLED_CONCRETE.values().forEach(buildingBlocksTagBuilder::add);
        ModBlocks.COLOR_TO_COBBLED_CONCRETE_POWDER.values().forEach(buildingBlocksTagBuilder::add);

        getOrCreateTagBuilder(ModTags.Blocks.STONE_PATH_BLOCKS).add(
                ModBlocks.ANDESITE_PATH,
                ModBlocks.ANDESITE_MOSSY_PATH,
                ModBlocks.ANDESITE_DIRTY_PATH,
                ModBlocks.COBBLESTONE_PATH,
                ModBlocks.MOSSY_COBBLESTONE_PATH,
                ModBlocks.COBBLED_DIRTY_PATH,
                ModBlocks.COBBLED_DEEPSLATE_PATH,
                ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH,
                ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH,
                ModBlocks.DIORITE_PATH,
                ModBlocks.DIORITE_MOSSY_PATH,
                ModBlocks.DIORITE_DIRTY_PATH,
                ModBlocks.GRANITE_PATH,
                ModBlocks.GRANITE_MOSSY_PATH,
                ModBlocks.GRANITE_DIRTY_PATH,
                ModBlocks.STONE_PATH,
                ModBlocks.STONE_MOSSY_PATH,
                ModBlocks.STONE_DIRTY_PATH,
                ModBlocks.END_STONE_PATH
        );

        getOrCreateTagBuilder(ModTags.Blocks.SOIL_PATH_BLOCKS).add(
                ModBlocks.CLAY_PATH,
                ModBlocks.COARSE_DIRT_PATH,
                ModBlocks.DIRT_PATH,
                ModBlocks.GRAVEL_PATH,
                ModBlocks.MUD_PATH,
                ModBlocks.RED_SAND_PATH,
                ModBlocks.ROOTED_DIRT_PATH,
                ModBlocks.SAND_PATH,
                ModBlocks.SNOW_PATH
        );

        FabricTagProvider<Block>.FabricTagBuilder cauldronsTagBuilder = getOrCreateTagBuilder(BlockTags.CAULDRONS);
        ModBlocks.COLOR_TO_WATER_CAULDRON.values().forEach(cauldronsTagBuilder::add);
        ModBlocks.COLOR_TO_LAVA_CAULDRON.values().forEach(cauldronsTagBuilder::add);


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.Blocks.SKELETON)
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.AETHER_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)
                .addTag(ModTags.Blocks.BUILDING_BLOCKS)
                .addTag(ModTags.Blocks.STONE_PATH_BLOCKS)
                .add(
                        Blocks.BUDDING_AMETHYST,
                        Blocks.SPAWNER,
                        Blocks.REINFORCED_DEEPSLATE,

                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,

                        ModBlocks.POWER_PRECISION_BLOCK,
                        ModBlocks.SMOKE_BLOCK,

                        ModBlocks.PACKED_ICE_BRICKS,
                        ModBlocks.PACKED_ICE_BRICKS_CRACKED,
                        ModBlocks.PACKED_ICE_TILES,
                        ModBlocks.PACKED_ICE_TILES_CRACKED
                );

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .addTag(ModTags.Blocks.SOIL_PATH_BLOCKS)
                .add(
                        ModBlocks.SAND_QUICKSAND,
                        ModBlocks.RED_SAND_QUICKSAND,
                        ModBlocks.GRAVEL_SINKSTONE,
                        ModBlocks.MUD_SINKING_SLUDGE,
                        ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND,

                        ModBlocks.SMOKE_BLOCK,

                        ModBlocks.SNOW_BRICKS,
                        ModBlocks.SNOW_BRICKS_CRACKED,
                        ModBlocks.SNOW_TILES,
                        ModBlocks.SNOW_TILES_CRACKED

                );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(
                ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK,
                ModBlocks.SMOKE_BLOCK
        );

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(
                ModBlocks.SMOKE_BLOCK
        );

        FabricTagProvider<Block>.FabricTagBuilder needsIronToolTagBuilder = getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        needsIronToolTagBuilder.add(
                ModBlocks.AETHER_COIL,

                ModBlocks.FOOLS_GOLD_BLOCK,
                ModBlocks.FOOLS_GOLD_RAW_BLOCK,

                ModBlocks.POWER_PRECISION_BLOCK
        );
        ModBlocks.COLOR_TO_AETHER_COIL.values().forEach(needsIronToolTagBuilder::add);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)
                .add(
                        Blocks.BUDDING_AMETHYST,
                        Blocks.REINFORCED_DEEPSLATE,
                        Blocks.SPAWNER
                );
    }
}