package net.spacegateir.steamcraft.item.client.amethyst_armor;

import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.AmethystArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class AmethystArmorModel extends GeoModel<AmethystArmorItem> {
    @Override
    public Identifier getModelResource(AmethystArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "geo/amethyst_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmethystArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "textures/armor/amethyst_armor.png");
    }

    @Override
    public Identifier getAnimationResource(AmethystArmorItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "animations/amethyst_armor.animation.json");
    }
}
