package net.spacegateir.steamcraft.item.client.wolf_armor;

import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import net.spacegateir.steamcraft.item.armor.WolfArmorItem;
import net.spacegateir.steamcraft.item.client.amethyst_armor.AmethystArmorModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WolfArmorRenderer extends GeoArmorRenderer<WolfArmorItem> {
    public WolfArmorRenderer() {
        super(new WolfArmorModel());
    }

}
