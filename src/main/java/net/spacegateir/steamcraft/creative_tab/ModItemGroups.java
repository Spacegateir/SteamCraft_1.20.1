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
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM)).entries((displayContext, entries) -> {

                        //Items
                        entries.add(ModItems.TEST_ITEM);

                        entries.add(ModItems.PATTERN_RECOMPILER);
                        entries.add(ModItems.FERRITE_HEARTSTONE);
                        entries.add(ModItems.AETHERIUM_PRISM);
                        entries.add(ModItems.AQUARION_SHARD);
                        entries.add(ModItems.PYROCITE_CORE);
                        entries.add(ModItems.LUMINITE_SPARK);
                        entries.add(ModItems.OBSCURIUM_CRYSTAL);

                        //Blocks
                        entries.add(ModBlocks.TEST_BLOCK);

                        entries.add(ModBlocks.AETHER_COIL);
                        entries.add(ModBlocks.AETHER_COIL_GREEN);
                        entries.add(ModBlocks.AETHER_COIL_BLUE);
                        entries.add(ModBlocks.AETHER_COIL_RED);
                        entries.add(ModBlocks.AETHER_COIL_YELLOW);
                        entries.add(ModBlocks.AETHER_COIL_WHITE);
                        entries.add(ModBlocks.AETHER_COIL_BLACK);

                        //BlockItems
                        entries.add(ModItems.TEST_ITEM_BLOCK);




                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Groups for "+ Steamcraft.MOD_ID);
    }
}