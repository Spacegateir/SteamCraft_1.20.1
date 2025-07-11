package net.spacegateir.steamcraft.TestTools.Tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.spacegateir.steamcraft.particle.ModParticles;

public class TestParticlesItem extends Item {

    public TestParticlesItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            HitResult hitResult = player.raycast(5.0D, 0.0F, false);
            if (hitResult instanceof BlockHitResult blockHit) {
                Vec3d pos = blockHit.getPos();

                System.out.println("Spawning particles");
                ((ServerWorld) world).spawnParticles(
                        ModParticles.EARTH_SPIKE_PARTICLE,
                        pos.x, pos.y, pos.z,
                        50,
                        0.2, 0.2, 0.2,
                        0.01
                );

//                ((ServerWorld) world).spawnParticles(
//                        ParticleTypes.CLOUD, pos.x, pos.y, pos.z, 50, 0.2, 0.2, 0.2, 0.01
//                );
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }
}
