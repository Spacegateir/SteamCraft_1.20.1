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
            public static final TagKey<Block> ARCANE_BLOCKS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "arcane_blocks")
            );
            public static final TagKey<Block> TRAPS = TagKey.of(
                    RegistryKeys.BLOCK,
                    new Identifier("steamcraft", "traps")
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

        getOrCreateTagBuilder(ModTags.Blocks.ARCANE_BLOCKS)
                .add(
                        ModBlocks.ARCANE_ABSORPTION_BLOCK,
                        ModBlocks.ARCANE_BAD_OMEN_BLOCK,
                        ModBlocks.ARCANE_BLINDNESS_BLOCK,
                        ModBlocks.ARCANE_CONDUIT_BLOCK,
                        ModBlocks.ARCANE_DARKNESS_BLOCK,
                        ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK,
                        ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK,
                        ModBlocks.ARCANE_GLOWING_BLOCK,
                        ModBlocks.ARCANE_HASTE_BLOCK,
                        ModBlocks.ARCANE_HEALTH_BOOST_BLOCK,
                        ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK,
                        ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK,
                        ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK,
                        ModBlocks.ARCANE_INVISIBILITY_BLOCK,
                        ModBlocks.ARCANE_JUMP_BOOST_BLOCK,
                        ModBlocks.ARCANE_LEVITATION_BLOCK,
                        ModBlocks.ARCANE_LUCK_BLOCK,
                        ModBlocks.ARCANE_MINING_FATIGUE_BLOCK,
                        ModBlocks.ARCANE_NEAUSEA_BLOCK,
                        ModBlocks.ARCANE_NIGHT_VISION_BLOCK,
                        ModBlocks.ARCANE_POISION_BLOCK,
                        ModBlocks.ARCANE_REGENERATION_BLOCK,
                        ModBlocks.ARCANE_RESISTANCE_BLOCK,
                        ModBlocks.ARCANE_SATUATION_BLOCK,
                        ModBlocks.ARCANE_SLOW_FALL_BLOCK,
                        ModBlocks.ARCANE_SLOWNESS_BLOCK,
                        ModBlocks.ARCANE_SPEED_BLOCK,
                        ModBlocks.ARCANE_STARVING_BLOCK,
                        ModBlocks.ARCANE_STRENGTH_BLOCK,
                        ModBlocks.ARCANE_UNLUCK_BLOCK,
                        ModBlocks.ARCANE_WATER_BREATHING_BLOCK,
                        ModBlocks.ARCANE_WEAKNESS_BLOCK,
                        ModBlocks.ARCANE_WITHER_BLOCK,
                        ModBlocks.ARCANE_VOID_BLOCK,
                        ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK,
                        ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK,
                        ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK,
                        ModBlocks.ARCANE_DISORIENT_BLOCK,
                        ModBlocks.ARCANE_STICKY_FEAT_BLOCK,
                        ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK
                        );

        getOrCreateTagBuilder(ModBlockTagProvider.ModTags.Blocks.TRAPS)
                .add(
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

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.Blocks.SKELETON)
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS)

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
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,

                        ModBlocks.POWER_PRECISION_BLOCK,
                        ModBlocks.SMOKE_BLOCK


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
                        ModBlocks.SAND_PATH,
                        ModBlocks.SNOW_PATH,

                        ModBlocks.SAND_QUICKSAND,
                        ModBlocks.RED_SAND_QUICKSAND,
                        ModBlocks.GRAVEL_SINKSTONE,
                        ModBlocks.MUD_SINKING_SLUDGE,
                        ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND

                );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(

                        ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK

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
                        ModBlocks.FOOLS_GOLD_RAW_BLOCK,

                        ModBlocks.POWER_PRECISION_BLOCK

                );

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .addTag(ModTags.Blocks.ARCANE_BLOCKS)
                .addTag(ModTags.Blocks.TRAPS);



    }
}