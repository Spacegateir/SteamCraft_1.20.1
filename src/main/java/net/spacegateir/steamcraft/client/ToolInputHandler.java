package net.spacegateir.steamcraft.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.item.tools.IToolWithBuffAndMode;

public class ToolInputHandler {
    private static boolean wasBuffKeyPressed = false;
    private static boolean wasModeKeyPressed = false;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            ItemStack stack = client.player.getMainHandStack();
            if (!(stack.getItem() instanceof IToolWithBuffAndMode)) return;

            // Detect CTRL+SHIFT+UseKey for buff activation
            boolean buffKeyPressed = Screen.hasControlDown() && Screen.hasShiftDown() && client.options.useKey.isPressed();
            if (buffKeyPressed && !wasBuffKeyPressed) {
                ClientPlayNetworking.send(ModPackets.ACTIVATE_BUFF_PACKET_ID, PacketByteBufs.empty());
            }
            wasBuffKeyPressed = buffKeyPressed;

//             Detect CTRL+SHIFT+RightClick (or custom key) for mode switching
//             This example assumes right-click is detected in use() method for mode switch,
//             but you could add a keybinding here for mode switching if you want.
//
//             For example, handle another key combo similarly
//             boolean modeKeyPressed = ...;
//             if (modeKeyPressed && !wasModeKeyPressed) {
//                 ClientPlayNetworking.send(ModPackets.SWITCH_MODE_PACKET_ID, PacketByteBufs.empty());
//             }
//             wasModeKeyPressed = modeKeyPressed;
        });
    }
}
