package net.spacegateir.steamcraft;

import net.fabricmc.api.ClientModInitializer;
import net.spacegateir.steamcraft.util.ModModelPredicateProvider;

public class SteamcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicateProvider.registerModelPredicates();

    }
}
