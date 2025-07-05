package net.spacegateir.steamcraft.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;

public class ModParticles {

    public static final DefaultParticleType EARTH_SPIKE_PARTICLE =
            registerParticle("earth_spike_particle", FabricParticleTypes.simple(true));


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Steamcraft.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        Steamcraft.LOGGER.info("Registering Particles for " + Steamcraft.MOD_ID);
    }
}