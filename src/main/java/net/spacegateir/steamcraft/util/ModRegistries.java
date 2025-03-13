package net.spacegateir.steamcraft.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;

public class ModRegistries {
    public static void registerModStuff() {

        createPortal();
    }

    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.TEST_BLOCK_ITEM)
                .lightWithItem(ModItems.TEST_ITEM)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim"))
                .tintColor(0xc76efa)
                .registerPortal();
    }

}
