package net.spacegateir.steamcraft.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;

public class ModSounds {

    public static final SoundEvent ZIPPER = registerSoundEvent("zipper");
    public static final SoundEvent ZIPPER_FAST = registerSoundEvent("zipper_fast");
    public static final SoundEvent ZIPPER_SLOW = registerSoundEvent("zipper_slow");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Steamcraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Steamcraft.LOGGER.info("Registering Mod Sounds for" + Steamcraft.MOD_ID);
    }
}
