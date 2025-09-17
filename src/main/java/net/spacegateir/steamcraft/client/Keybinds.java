package net.spacegateir.steamcraft.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    public static KeyBinding MAGIC_BAG_KEY;

    public static void registerKeybinds() {

        MAGIC_BAG_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.steamcraft.magic_bag",     // Translation key
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,                // Default key
                "category.steamcraft"  // Key category in controls menu
        ));
    }
}
