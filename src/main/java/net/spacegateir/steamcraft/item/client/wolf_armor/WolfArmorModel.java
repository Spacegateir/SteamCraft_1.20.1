package net.spacegateir.steamcraft.item.client.wolf_armor;

import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import net.spacegateir.steamcraft.item.armor.WolfArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class WolfArmorModel extends GeoModel<WolfArmorItem> {
    @Override
    public Identifier getModelResource(WolfArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "geo/wolf_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "textures/armor/wolf_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WolfArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "animations/wolf_armor.animation.json");
    }
}
