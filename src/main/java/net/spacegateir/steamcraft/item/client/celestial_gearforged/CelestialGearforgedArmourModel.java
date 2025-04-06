package net.spacegateir.steamcraft.item.client.celestial_gearforged;

import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.CelestialGearforgedArmourItem;
import software.bernie.geckolib.model.GeoModel;

public class CelestialGearforgedArmourModel extends GeoModel<CelestialGearforgedArmourItem> {
    @Override
    public Identifier getModelResource(CelestialGearforgedArmourItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "geo/celestial_gearforged_armour.geo.json");
    }

    @Override
    public Identifier getTextureResource(CelestialGearforgedArmourItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "textures/armor/celestial_gearforged_armour.png");
    }

    @Override
    public Identifier getAnimationResource(CelestialGearforgedArmourItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "animations/celestial_gearforged_armour.animation.json");
    }
}
