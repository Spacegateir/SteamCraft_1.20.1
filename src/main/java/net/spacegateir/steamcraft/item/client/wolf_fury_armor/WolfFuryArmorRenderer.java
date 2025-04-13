package net.spacegateir.steamcraft.item.client.wolf_fury_armor;

import net.spacegateir.steamcraft.item.armor.WolfFuryArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WolfFuryArmorRenderer extends GeoArmorRenderer<WolfFuryArmorItem> {
    public WolfFuryArmorRenderer() {
        super(new WolfFuryArmorModel());
    }

}
