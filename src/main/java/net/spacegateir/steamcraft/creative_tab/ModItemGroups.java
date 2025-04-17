package net.spacegateir.steamcraft.creative_tab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
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

                        entries.add(ModItems.PATTERN_RECOMPILER);
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
                        entries.add(ModItems.WINGED_SANDALS);

                        entries.add(ModItems.FOOLS_GOLD_SCRAP);
                        entries.add(ModItems.FOOLS_GOLD_RAW);
                        entries.add(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
                        entries.add(ModItems.FOOLS_GOLD_INGOT);
                        entries.add(ModBlocks.FOOLS_GOLD_BLOCK);
                        entries.add(ModItems.DIVINITITE_ALLOY_INGOT);

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

                        //BlockItems
//                        entries.add(ModItems.TEST_ITEM_BLOCK);

                        entries.add(ModItems.AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_AGAPANTHUS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_AGAPANTHUS_FLOWER_ITEM);

                        entries.add(ModItems.BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_BLUE_COSMOS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_BLUE_COSMOS_FLOWER_ITEM);

                        entries.add(ModItems.BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_BONSAI_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_BONSAI_FLOWER_ITEM);

                        entries.add(ModItems.CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_CARNATION_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_CARNATION_FLOWER_ITEM);

                        entries.add(ModItems.DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DAFFODIL_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_DAFFODIL_FLOWER_ITEM);

                        entries.add(ModItems.DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DAHLIA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_DAHLIA_FLOWER_ITEM);

                        entries.add(ModItems.DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_DELPHINIUM_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_DELPHINIUM_FLOWER_ITEM);

                        entries.add(ModItems.HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_HAWTHORN_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_HAWTHORN_FLOWER_ITEM);

                        entries.add(ModItems.HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_HYDRANGEA_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_HYDRANGEA_FLOWER_ITEM);

                        entries.add(ModItems.IRIS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_IRIS_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_IRIS_FLOWER_ITEM);

                        entries.add(ModItems.LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_LARKSPUR_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_LARKSPUR_FLOWER_ITEM);

                        entries.add(ModItems.MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_MIDNIGHT_MYSTIC_FLOWER_ITEM);

                        entries.add(ModItems.PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_PRIMROSE_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_PRIMROSE_FLOWER_ITEM);

                        entries.add(ModItems.SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_SNOW_DROP_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_SNOW_DROP_FLOWER_ITEM);

                        entries.add(ModItems.SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_SPIDERLILY_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_SPIDERLILY_FLOWER_ITEM);

                        entries.add(ModItems.VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.THORNED_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_THORNED_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.LUSH_VIOLET_FLOWER_ITEM);
                        entries.add(ModItems.GLOW_LUSH_VIOLET_FLOWER_ITEM);




                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Groups for "+ Steamcraft.MOD_ID);
    }
}