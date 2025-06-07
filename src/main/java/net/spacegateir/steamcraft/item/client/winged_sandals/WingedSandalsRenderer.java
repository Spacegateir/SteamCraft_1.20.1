package net.spacegateir.steamcraft.item.client.winged_sandals;

import net.spacegateir.steamcraft.item.armor.WingedSandalsCosmeticItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WingedSandalsRenderer extends GeoArmorRenderer<WingedSandalsCosmeticItem> {
    public WingedSandalsRenderer() {
        super(new WingedSandalsModel());
    }

}
