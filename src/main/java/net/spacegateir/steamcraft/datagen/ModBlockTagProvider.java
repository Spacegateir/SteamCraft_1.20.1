package net.spacegateir.steamcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static class ModTags {
        public static class Blocks {
            public static final TagKey<Block> SKELETON = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "skeleton")
            );
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ModBlockTagProvider.ModTags.Blocks.SKELETON)
                .add(
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

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.Blocks.SKELETON)

                .add(
                        ModBlocks.AETHER_COIL,
                        ModBlocks.AETHER_COIL_WHITE,
                        ModBlocks.AETHER_COIL_LIGHT_GRAY,
                        ModBlocks.AETHER_COIL_GRAY,
                        ModBlocks.AETHER_COIL_BLACK,
                        ModBlocks.AETHER_COIL_BROWN,
                        ModBlocks.AETHER_COIL_RED,
                        ModBlocks.AETHER_COIL_ORANGE,
                        ModBlocks.AETHER_COIL_YELLOW,
                        ModBlocks.AETHER_COIL_LIME,
                        ModBlocks.AETHER_COIL_GREEN,
                        ModBlocks.AETHER_COIL_CYAN,
                        ModBlocks.AETHER_COIL_LIGHT_BLUE,
                        ModBlocks.AETHER_COIL_BLUE,
                        ModBlocks.AETHER_COIL_PURPLE,
                        ModBlocks.AETHER_COIL_MAGENTA,
                        ModBlocks.AETHER_COIL_PINK,
                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK
                );

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(

                        ModBlocks.CLAY_PATH,
                        ModBlocks.COARSE_DIRT_PATH,
                        ModBlocks.DIRT_PATH,
                        ModBlocks.GRAVEL_PATH,
                        ModBlocks.MUD_PATH,
                        ModBlocks.RED_SAND_PATH,
                        ModBlocks.ROOTED_DIRT_PATH,
                        ModBlocks.SAND_PATH

                );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.AETHER_COIL,
                        ModBlocks.AETHER_COIL_WHITE,
                        ModBlocks.AETHER_COIL_LIGHT_GRAY,
                        ModBlocks.AETHER_COIL_GRAY,
                        ModBlocks.AETHER_COIL_BLACK,
                        ModBlocks.AETHER_COIL_BROWN,
                        ModBlocks.AETHER_COIL_RED,
                        ModBlocks.AETHER_COIL_ORANGE,
                        ModBlocks.AETHER_COIL_YELLOW,
                        ModBlocks.AETHER_COIL_LIME,
                        ModBlocks.AETHER_COIL_GREEN,
                        ModBlocks.AETHER_COIL_CYAN,
                        ModBlocks.AETHER_COIL_LIGHT_BLUE,
                        ModBlocks.AETHER_COIL_BLUE,
                        ModBlocks.AETHER_COIL_PURPLE,
                        ModBlocks.AETHER_COIL_MAGENTA,
                        ModBlocks.AETHER_COIL_PINK,

                        ModBlocks.FOOLS_GOLD_BLOCK,
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK

                );


    }
}