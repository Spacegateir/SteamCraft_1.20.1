package net.spacegateir.steamcraft.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class EarthSpikeParticles extends SpriteBillboardParticle {

    protected EarthSpikeParticles(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                  SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord + 0.1, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.1f; // slow velocity multiplier
        this.velocityX = (xd * 0.02) + (this.random.nextGaussian() * 0.001);
        this.velocityY = 0.01 + (this.random.nextFloat() * 0.005); // slight upward drift
        this.velocityZ = (zd * 0.02) + (this.random.nextGaussian() * 0.001);

        this.scale *= 0.5f; // smaller dust particle size
        this.maxAge = 400 + this.random.nextInt(20); // longer lifespan for lingering effect
        this.setSpriteForAge(spriteSet);

        // Light grayish white color with some transparency
        this.red = 0.85f + this.random.nextFloat() * 0.15f;
        this.green = 0.85f + this.random.nextFloat() * 0.15f;
        this.blue = 0.85f + this.random.nextFloat() * 0.15f;
        this.alpha = 0.5f; // semi-transparent
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        // Fade out slowly
        this.alpha *= 0.96f;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {
            return new EarthSpikeParticles(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}