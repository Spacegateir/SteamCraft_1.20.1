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
                .frameBlock(ModBlocks.AETHER_COIL_GREEN)
                .lightWithItem(ModItems.FERRITE_HEARTSTONE)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_green"))
                .setPortalSearchYRange(50, 150)
                .tintColor(0x009300)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_BLUE)
                .lightWithItem(ModItems.AQUARION_SHARD)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_blue"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0x0000ff)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_RED)
                .lightWithItem(ModItems.PYROCITE_CORE)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_red"))
                .setPortalSearchYRange(50, 150)
                .tintColor(0xff0000)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_YELLOW)
                .lightWithItem(ModItems.AETHERIUM_PRISM)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_yellow"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0xffa500)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_WHITE)
                .lightWithItem(ModItems.LUMINITE_SPARK)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_white"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0xffffff)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.AETHER_COIL_BLACK)
                .lightWithItem(ModItems.OBSCURIUM_CRYSTAL)
                .destDimID(new Identifier(Steamcraft.MOD_ID, "steamdim_black"))
                .setPortalSearchYRange(64, 64)
                .tintColor(0x000000)
                .registerPortal();
    }

}
