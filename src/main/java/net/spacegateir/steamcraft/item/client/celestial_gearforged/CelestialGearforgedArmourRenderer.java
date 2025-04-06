package net.spacegateir.steamcraft.item.client.celestial_gearforged;

import net.spacegateir.steamcraft.item.armor.CelestialGearforgedArmourItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CelestialGearforgedArmourRenderer extends GeoArmorRenderer<CelestialGearforgedArmourItem> {
    public CelestialGearforgedArmourRenderer() {
        super(new CelestialGearforgedArmourModel());
    }

}
