package net.spacegateir.steamcraft.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.spacegateir.steamcraft.item.tools.IToolWithBuffAndMode;

import java.util.List;


public class ModPackets {

    public static final Identifier ACTIVATE_BUFF_PACKET_ID = new Identifier("steamcraft", "activate_buff");
    public static final Identifier WINGED_SANDALS_DASH_PACKET_ID = new Identifier("steamcraft", "winged_sandals_dash");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(ACTIVATE_BUFF_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                ItemStack mainHand = player.getMainHandStack();
                if (!mainHand.isEmpty()) {
                    var item = mainHand.getItem();
                    String className = item.getClass().getSimpleName();

                    if (className.contains("CelestialGearforged") && item instanceof IToolWithBuffAndMode tool) {
                        tool.applyBuffAbility(player);
                    }
                }
            });
        });
    }

    public static void registerServerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(WINGED_SANDALS_DASH_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            server.execute(() -> {
                if (!player.isOnGround() && player.isSneaking()) {
                    if (player.getHungerManager().getFoodLevel() >= 10) {

                        // Get direction vector
                        Vec3d start = player.getCameraPosVec(1.0F);
                        Vec3d direction = player.getRotationVec(1.0F).normalize();
                        Vec3d end = start.add(direction.multiply(100.0));

                        // Raycast to prevent going through blocks or void
                        HitResult hitResult = player.getWorld().raycast(new RaycastContext(
                                start,
                                end,
                                RaycastContext.ShapeType.COLLIDER,
                                RaycastContext.FluidHandling.NONE,
                                player
                        ));

                        Vec3d dashTo = hitResult.getPos();

                        // Prevent going below world bottom
                        if (dashTo.y < player.getWorld().getBottomY()) {
                            dashTo = new Vec3d(dashTo.x, player.getWorld().getBottomY(), dashTo.z);
                        }

                        player.requestTeleport(dashTo.x, dashTo.y, dashTo.z);

                        // Play sound to nearby players
                        List<ServerPlayerEntity> players = ((ServerWorld) player.getWorld()).getPlayers(p ->
                                p.squaredDistanceTo(player) <= 32 * 32
                        );
                        for (ServerPlayerEntity p : players) {
                            p.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, net.minecraft.sound.SoundCategory.PLAYERS, 3.0F, 1.2F);
                        }

                        // Spawn particles
                        for (int i = 0; i < 10; i++) {
                            double offsetX = (player.getRandom().nextDouble() - 0.5);
                            double offsetY = player.getRandom().nextDouble();
                            double offsetZ = (player.getRandom().nextDouble() - 0.5);

                            ((ServerWorld) player.getWorld()).spawnParticles(
                                    ParticleTypes.CLOUD,
                                    dashTo.x + offsetX, dashTo.y + offsetY, dashTo.z + offsetZ,
                                    1, 0, 0, 0, 0
                            );
                        }

                        // Reduce hunger
                        HungerManager hunger = player.getHungerManager();
                        hunger.setFoodLevel(Math.max(0, hunger.getFoodLevel() - 10));
                        hunger.setSaturationLevel(Math.min(hunger.getSaturationLevel(), hunger.getFoodLevel()));
                    }
                }
            });
        });
    }


}