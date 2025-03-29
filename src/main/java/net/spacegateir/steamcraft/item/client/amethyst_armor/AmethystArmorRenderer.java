package net.spacegateir.steamcraft.item.client.amethyst_armor;

import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AmethystArmorRenderer extends GeoArmorRenderer<AmethystArmorItem> {
    public AmethystArmorRenderer() {
        super(new AmethystArmorModel());
    }

}
