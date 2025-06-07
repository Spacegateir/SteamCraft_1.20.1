package net.spacegateir.steamcraft.item.client.winged_sandals;

import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.armor.WingedSandalsCosmeticItem;
import software.bernie.geckolib.model.GeoModel;

public class WingedSandalsModel extends GeoModel<WingedSandalsCosmeticItem> {
    @Override
    public Identifier getModelResource(WingedSandalsCosmeticItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "geo/winged_sandals.geo.json");
    }

    @Override
    public Identifier getTextureResource(WingedSandalsCosmeticItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "textures/armor/winged_sandals.png");
    }

    @Override
    public Identifier getAnimationResource(WingedSandalsCosmeticItem animatable) {
        return new Identifier(Steamcraft.MOD_ID, "animations/winged_sandals.animation.json");
    }
}
