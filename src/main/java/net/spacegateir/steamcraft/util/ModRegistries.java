package net.spacegateir.steamcraft.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
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
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_overworld"))
                .tintColor(0x009300)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.TEST_BLOCK)
                .lightWithItem(ModItems.TEST_ITEM)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_void"))
                .tintColor(0x000000)
                .registerPortal();
    }

}
