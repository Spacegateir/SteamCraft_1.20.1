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
            new Identifier(Steamcraft.MOD_ID,"test"),
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

                        entries.add(ModItems.FOOLS_GOLD_HELMET);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS);


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

                        //BlockItems
//                        entries.add(ModItems.TEST_ITEM_BLOCK);




                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Groups for "+ Steamcraft.MOD_ID);
    }
}