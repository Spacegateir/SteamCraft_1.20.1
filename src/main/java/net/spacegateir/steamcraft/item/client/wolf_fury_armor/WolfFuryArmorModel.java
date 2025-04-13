package net.spacegateir.steamcraft.item.client.wolf_fury_armor;

import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.WolfArmorItem;
import net.spacegateir.steamcraft.item.armor.WolfFuryArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class WolfFuryArmorModel extends GeoModel<WolfFuryArmorItem> {
    @Override
    public Identifier getModelResource(WolfFuryArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "geo/wolf_fury_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfFuryArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "textures/armor/wolf_fury_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WolfFuryArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "animations/wolf_fury_armor.animation.json");
    }
}
