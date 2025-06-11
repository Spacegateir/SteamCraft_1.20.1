package net.spacegateir.steamcraft.creative_tab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup STEAMCRAFT = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Steamcraft.MOD_ID,"sc"),
            FabricItemGroup.builder().displayName(Text.translatable("SteamCraft"))
                    .icon(() -> new ItemStack(ModItems.PATTERN_RECOMPILER)).entries((displayContext, entries) -> {

                        //Items
//                        entries.add(ModItems.TEST_ITEM);



                        entries.add(ModItems.TROWEL);
                        entries.add(ModItems.PATTERN_RECOMPILER);
                        entries.add(ModItems.TRAP_CONCEALER);
                        entries.add(ModItems.CORE_OF_CHANGING);

                        entries.add(ModItems.FERRITE_HEARTSTONE);
                        entries.add(ModItems.AETHERIUM_PRISM);
                        entries.add(ModItems.AQUARION_SHARD);
                        entries.add(ModItems.PYROCITE_CORE);
                        entries.add(ModItems.LUMINITE_SPARK);
                        entries.add(ModItems.OBSCURIUM_CRYSTAL);

                        entries.add(ModItems.BLANK_MOULD);
                        entries.add(ModItems.HELMET_MOULD);
                        entries.add(ModItems.CHESTPLATE_MOULD);
                        entries.add(ModItems.LEGGINGS_MOULD);
                        entries.add(ModItems.BOOTS_MOULD);
                        entries.add(ModItems.BUCKET_MOULD);
                        entries.add(ModItems.WINGED_SANDALS);

                        entries.add(ModItems.FOOLS_GOLD_SCRAP);
                        entries.add(ModItems.FOOLS_GOLD_RAW);
                        entries.add(ModItems.FOOLS_GOLD_INGOT);
                        entries.add(ModItems.DIVINITITE_ALLOY_INGOT);

                        entries.add(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
                        entries.add(ModBlocks.FOOLS_GOLD_BLOCK);
                        entries.add(ModItems.DIVINITITE_ALLOY_ITEM);

                        entries.add(ModItems.FOOLS_GOLD_HELMET);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS);

                        entries.add(ModItems.CELESTIAL_GEARFORGED_HELMET);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_LEGGINGS);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_BOOTS);


                        entries.add(ModItems.FOOLS_GOLD_HELMET_1);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_2);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_3);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_4);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_1);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_2);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_3);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_4);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_1);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_2);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_3);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_4);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_1);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_2);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_3);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_4);

                        //Blocks
//                        entries.add(ModBlocks.TEST_BLOCK);

                        entries.add(ModBlocks.AETHER_COIL);
                        entries.add(ModBlocks.AETHER_COIL_WHITE);
                        entries.add(ModBlocks.AETHER_COIL_LIGHT_GRAY);
                        entries.add(ModBlocks.AETHER_COIL_GRAY);
                        entries.add(ModBlocks.AETHER_COIL_BLACK);
                        entries.add(ModBlocks.AETHER_COIL_BROWN);
                        entries.add(ModBlocks.AETHER_COIL_RED);
                        entries.add(ModBlocks.AETHER_COIL_ORANGE);
                        entries.add(ModBlocks.AETHER_COIL_YELLOW);
                        entries.add(ModBlocks.AETHER_COIL_LIME);
                        entries.add(ModBlocks.AETHER_COIL_GREEN);
                        entries.add(ModBlocks.AETHER_COIL_CYAN);
                        entries.add(ModBlocks.AETHER_COIL_LIGHT_BLUE);
                        entries.add(ModBlocks.AETHER_COIL_BLUE);
                        entries.add(ModBlocks.AETHER_COIL_PURPLE);
                        entries.add(ModBlocks.AETHER_COIL_MAGENTA);
                        entries.add(ModBlocks.AETHER_COIL_PINK);

                        entries.add(ModBlocks.CLAY_PATH);
                        entries.add(ModBlocks.COARSE_DIRT_PATH);
                        entries.add(ModBlocks.DIRT_PATH);
                        entries.add(ModBlocks.GRAVEL_PATH);
                        entries.add(ModBlocks.MUD_PATH);
                        entries.add(ModBlocks.RED_SAND_PATH);
                        entries.add(ModBlocks.ROOTED_DIRT_PATH);
                        entries.add(ModBlocks.SAND_PATH);
                        entries.add(ModBlocks.SNOW_PATH);
                        entries.add(ModBlocks.ANDESITE_PATH);
                        entries.add(ModBlocks.ANDESITE_DIRTY_PATH);
                        entries.add(ModBlocks.ANDESITE_MOSSY_PATH);
                        entries.add(ModBlocks.COBBLESTONE_PATH);
                        entries.add(ModBlocks.COBBLED_DIRTY_PATH);
                        entries.add(ModBlocks.MOSSY_COBBLESTONE_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH);
                        entries.add(ModBlocks.DIORITE_PATH);
                        entries.add(ModBlocks.DIORITE_DIRTY_PATH);
                        entries.add(ModBlocks.DIORITE_MOSSY_PATH);
                        entries.add(ModBlocks.GRANITE_PATH);
                        entries.add(ModBlocks.GRANITE_DIRTY_PATH);
                        entries.add(ModBlocks.GRANITE_MOSSY_PATH);
                        entries.add(ModBlocks.STONE_PATH);
                        entries.add(ModBlocks.STONE_DIRTY_PATH);
                        entries.add(ModBlocks.STONE_MOSSY_PATH);
                        entries.add(ModBlocks.END_STONE_PATH);

                        entries.add(ModBlocks.SKELETON_SITTING);
                        entries.add(ModBlocks.SKELETON_LAYING);
                        entries.add(ModBlocks.SKELETON_HEAD);
                        entries.add(ModBlocks.SKELETON_TORSO);
                        entries.add(ModBlocks.SKELETON_ARM);
                        entries.add(ModBlocks.SKELETON_ARMS_CROSS);
                        entries.add(ModBlocks.SKELETON_LEG);
                        entries.add(ModBlocks.SKELETON_LEGS_CROSS);
                        entries.add(ModBlocks.SKELETON_HEAD_STACK);
                        entries.add(ModBlocks.SKELETON_HALF_BODY);
                        entries.add(ModBlocks.SKELETON_CHEST);
                        entries.add(ModBlocks.SKELETON_PELVIS);
                        entries.add(ModBlocks.SKELETON_SPINE);

                        entries.add(ModBlocks.ARCANE_ABSORPTION_BLOCK);
                        entries.add(ModBlocks.ARCANE_BAD_OMEN_BLOCK);
                        entries.add(ModBlocks.ARCANE_BLINDNESS_BLOCK);
                        entries.add(ModBlocks.ARCANE_CONDUIT_BLOCK);
                        entries.add(ModBlocks.ARCANE_DARKNESS_BLOCK);
                        entries.add(ModBlocks.ARCANE_DOLPHINS_GRACE_BLOCK);
                        entries.add(ModBlocks.ARCANE_FIRE_RESISTANCE_BLOCK);
                        entries.add(ModBlocks.ARCANE_GLOWING_BLOCK);
                        entries.add(ModBlocks.ARCANE_HASTE_BLOCK);
                        entries.add(ModBlocks.ARCANE_HEALTH_BOOST_BLOCK);
                        entries.add(ModBlocks.ARCANE_HERO_OF_THE_VILLAGE_BLOCK);
                        entries.add(ModBlocks.ARCANE_INSTANT_DAMAGE_BLOCK);
                        entries.add(ModBlocks.ARCANE_INSTANT_HEALTH_BLOCK);
                        entries.add(ModBlocks.ARCANE_INVISIBILITY_BLOCK);
                        entries.add(ModBlocks.ARCANE_JUMP_BOOST_BLOCK);
                        entries.add(ModBlocks.ARCANE_LEVITATION_BLOCK);
                        entries.add(ModBlocks.ARCANE_LUCK_BLOCK);
                        entries.add(ModBlocks.ARCANE_MINING_FATIGUE_BLOCK);
                        entries.add(ModBlocks.ARCANE_NEAUSEA_BLOCK);
                        entries.add(ModBlocks.ARCANE_NIGHT_VISION_BLOCK);
                        entries.add(ModBlocks.ARCANE_POISION_BLOCK);
                        entries.add(ModBlocks.ARCANE_REGENERATION_BLOCK);
                        entries.add(ModBlocks.ARCANE_RESISTANCE_BLOCK);
                        entries.add(ModBlocks.ARCANE_SATUATION_BLOCK);
                        entries.add(ModBlocks.ARCANE_SLOW_FALL_BLOCK);
                        entries.add(ModBlocks.ARCANE_SLOWNESS_BLOCK);
                        entries.add(ModBlocks.ARCANE_SPEED_BLOCK);
                        entries.add(ModBlocks.ARCANE_STARVING_BLOCK);
                        entries.add(ModBlocks.ARCANE_STRENGTH_BLOCK);
                        entries.add(ModBlocks.ARCANE_UNLUCK_BLOCK);
                        entries.add(ModBlocks.ARCANE_WATER_BREATHING_BLOCK);
                        entries.add(ModBlocks.ARCANE_WEAKNESS_BLOCK);
                        entries.add(ModBlocks.ARCANE_WITHER_BLOCK);
                        entries.add(ModBlocks.ARCANE_VOID_BLOCK);
                        entries.add(ModBlocks.ARCANE_CLEAR_NEGATIVE_BLOCK);
                        entries.add(ModBlocks.ARCANE_CLEAR_POSITIVE_BLOCK);
                        entries.add(ModBlocks.ARCANE_CLEAR_NEUTRAL_BLOCK);
                        entries.add(ModBlocks.ARCANE_DISORIENT_BLOCK);
                        entries.add(ModBlocks.ARCANE_STICKY_FEAT_BLOCK);
                        entries.add(ModBlocks.ARCANE_FREAKY_BUNNY_BLOCK);

                        entries.add(ModBlocks.POWER_PRECISION_BLOCK);

                        entries.add(ModBlocks.CURSED_BLOCK);
                        entries.add(ModBlocks.COURSE_DIRT_TRAP_BLOCK);
                        entries.add(ModBlocks.STONE_TRAP_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_TRAP_BLOCK);
                        entries.add(ModBlocks.SAND_QUICKSAND);
                        entries.add(ModBlocks.RED_SAND_QUICKSAND);
                        entries.add(ModBlocks.GRAVEL_SINKSTONE);
                        entries.add(ModBlocks.MUD_SINKING_SLUDGE);
                        entries.add(ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND);
                        entries.add(ModBlocks.FLAREFORGE_BLOCK);
                        entries.add(ModBlocks.NETHER_STEAM_VENT);
                        entries.add(ModBlocks.SPIRIT_JUMP_TRAP);
                        entries.add(ModBlocks.FROST_BITE_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_BRASIER_TRAP_BLOCK);
                        entries.add(ModBlocks.EMPTY_BRASIER);
                        entries.add(ModBlocks.CURSED_TOTEM_BLOCK);
                        entries.add(ModItems.TELEPORT_TRAP_ITEM);

                        entries.add(ModItems.SMOKE_BLOCK_ITEM);

                        entries.add(ModItems.GLIMMERSTONE_ITEM);
                        entries.add(ModItems.GLIMMERSTONE_COBBLESTONE_ITEM);

                        entries.add(ModBlocks.COBBLED_WHITE_CONCRETE);
                        entries.add(ModBlocks.COBBLED_WHITE_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE);
                        entries.add(ModBlocks.COBBLED_LIGHT_GRAY_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_GRAY_CONCRETE);
                        entries.add(ModBlocks.COBBLED_GRAY_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_BLACK_CONCRETE);
                        entries.add(ModBlocks.COBBLED_BLACK_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_BROWN_CONCRETE);
                        entries.add(ModBlocks.COBBLED_BROWN_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_RED_CONCRETE);
                        entries.add(ModBlocks.COBBLED_RED_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_ORANGE_CONCRETE);
                        entries.add(ModBlocks.COBBLED_ORANGE_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_YELLOW_CONCRETE);
                        entries.add(ModBlocks.COBBLED_YELLOW_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_LIME_CONCRETE);
                        entries.add(ModBlocks.COBBLED_LIME_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_GREEN_CONCRETE);
                        entries.add(ModBlocks.COBBLED_GREEN_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_CYAN_CONCRETE);
                        entries.add(ModBlocks.COBBLED_CYAN_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE);
                        entries.add(ModBlocks.COBBLED_LIGHT_BLUE_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_BLUE_CONCRETE);
                        entries.add(ModBlocks.COBBLED_BLUE_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_PURPLE_CONCRETE);
                        entries.add(ModBlocks.COBBLED_PURPLE_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_MAGENTA_CONCRETE);
                        entries.add(ModBlocks.COBBLED_MAGENTA_CONCRETE_POWDER);
                        entries.add(ModBlocks.COBBLED_PINK_CONCRETE);
                        entries.add(ModBlocks.COBBLED_PINK_CONCRETE_POWDER);

                        entries.add(ModBlocks.PACKED_ICE_BRICKS);
                        entries.add(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
                        entries.add(ModBlocks.PACKED_ICE_TILES);
                        entries.add(ModBlocks.PACKED_ICE_TILES_CRACKED);

                        entries.add(ModBlocks.SNOW_BRICKS);
                        entries.add(ModBlocks.SNOW_BRICKS_CRACKED);
                        entries.add(ModBlocks.SNOW_TILES);
                        entries.add(ModBlocks.SNOW_TILES_CRACKED);







                        //BlockItems
//                        entries.add(ModItems.TEST_ITEM_BLOCK);


                        entries.add(ModItems.AGAPANTHUS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_AGAPANTHUS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_AGAPANTHUS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_AGAPANTHUS_FLOWER_ITEM);

                        entries.add(ModItems.BLUE_COSMOS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_BLUE_COSMOS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_BLUE_COSMOS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_BLUE_COSMOS_FLOWER_ITEM);

                        entries.add(ModItems.BONSAI_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_BONSAI_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_BONSAI_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_BONSAI_FLOWER_ITEM);

                        entries.add(ModItems.CARNATION_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_CARNATION_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_CARNATION_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_CARNATION_FLOWER_ITEM);

                        entries.add(ModItems.DAFFODIL_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DAFFODIL_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DAFFODIL_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_DAFFODIL_FLOWER_ITEM);

                        entries.add(ModItems.DAHLIA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DAHLIA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DAHLIA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_DAHLIA_FLOWER_ITEM);

                        entries.add(ModItems.DELPHINIUM_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DELPHINIUM_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DELPHINIUM_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_DELPHINIUM_FLOWER_ITEM);

                        entries.add(ModItems.HAWTHORN_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_HAWTHORN_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_HAWTHORN_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_HAWTHORN_FLOWER_ITEM);

                        entries.add(ModItems.HYDRANGEA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_HYDRANGEA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_HYDRANGEA_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_HYDRANGEA_FLOWER_ITEM);

                        entries.add(ModItems.IRIS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_IRIS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_IRIS_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_IRIS_FLOWER_ITEM);

                        entries.add(ModItems.LARKSPUR_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_LARKSPUR_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_LARKSPUR_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_LARKSPUR_FLOWER_ITEM);

                        entries.add(ModItems.MIDNIGHT_MYSTIC_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM);

                        entries.add(ModItems.PRIMROSE_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_PRIMROSE_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_PRIMROSE_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_PRIMROSE_FLOWER_ITEM);

                        entries.add(ModItems.SNOW_DROP_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_SNOW_DROP_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_SNOW_DROP_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_SNOW_DROP_FLOWER_ITEM);

                        entries.add(ModItems.SPIDERLILY_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_SPIDERLILY_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_SPIDERLILY_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_SPIDERLILY_FLOWER_ITEM);

                        entries.add(ModItems.VIOLET_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_VIOLET_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_THORNED_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_VIOLET_FLOWER_ITEM);
//                        entries.add(ModItems.GLOW_LUSH_VIOLET_FLOWER_ITEM);

                        entries.add(ModItems.WHITE_WATER_BUCKET);
                        entries.add(ModItems.LIGHT_GRAY_WATER_BUCKET);
                        entries.add(ModItems.GRAY_WATER_BUCKET);
                        entries.add(ModItems.BLACK_WATER_BUCKET);
                        entries.add(ModItems.BROWN_WATER_BUCKET);
                        entries.add(ModItems.RED_WATER_BUCKET);
                        entries.add(ModItems.ORANGE_WATER_BUCKET);
                        entries.add(ModItems.YELLOW_WATER_BUCKET);
                        entries.add(ModItems.LIME_WATER_BUCKET);
                        entries.add(ModItems.GREEN_WATER_BUCKET);
                        entries.add(ModItems.CYAN_WATER_BUCKET);
                        entries.add(ModItems.LIGHT_BLUE_WATER_BUCKET);
                        entries.add(ModItems.BLUE_WATER_BUCKET);
                        entries.add(ModItems.PURPLE_WATER_BUCKET);
                        entries.add(ModItems.MAGENTA_WATER_BUCKET);
                        entries.add(ModItems.PINK_WATER_BUCKET);

                        entries.add(ModItems.WHITE_LAVA_BUCKET);
                        entries.add(ModItems.LIGHT_GRAY_LAVA_BUCKET);
                        entries.add(ModItems.GRAY_LAVA_BUCKET);
                        entries.add(ModItems.BLACK_LAVA_BUCKET);
                        entries.add(ModItems.BROWN_LAVA_BUCKET);
                        entries.add(ModItems.RED_LAVA_BUCKET);
                        entries.add(ModItems.ORANGE_LAVA_BUCKET);
                        entries.add(ModItems.YELLOW_LAVA_BUCKET);
                        entries.add(ModItems.LIME_LAVA_BUCKET);
                        entries.add(ModItems.GREEN_LAVA_BUCKET);
                        entries.add(ModItems.CYAN_LAVA_BUCKET);
                        entries.add(ModItems.LIGHT_BLUE_LAVA_BUCKET);
                        entries.add(ModItems.BLUE_LAVA_BUCKET);
                        entries.add(ModItems.PURPLE_LAVA_BUCKET);
                        entries.add(ModItems.MAGENTA_LAVA_BUCKET);
                        entries.add(ModItems.PINK_LAVA_BUCKET);

                        entries.add(ModItems.FOOLS_GOLD_LAVA_BUCKET);
                        entries.add(ModItems.DIVINITITE_ALLOY_LAVA_BUCKET);






                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Groups for "+ Steamcraft.MOD_ID);
    }
}