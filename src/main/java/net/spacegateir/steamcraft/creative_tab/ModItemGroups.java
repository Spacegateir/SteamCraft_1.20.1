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

                        //Blocks
                        entries.add(ModBlocks.TEST_BLOCK);
                        entries.add(ModBlocks.AETHER_COIL);

                        //BlockItems
                        entries.add(ModItems.TEST_ITEM_BLOCK);




                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Groups for "+ Steamcraft.MOD_ID);
    }
}