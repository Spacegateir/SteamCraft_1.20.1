package net.spacegateir.steamcraft.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
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
                .lightWithItem(Items.DIAMOND)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_overworld"))
                .setPortalSearchYRange(60, 100)
                .tintColor(0x009300)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.TEST_BLOCK)
                .lightWithItem(Items.DIAMOND)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_void"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0x000000)
                .registerPortal();
    }

}
