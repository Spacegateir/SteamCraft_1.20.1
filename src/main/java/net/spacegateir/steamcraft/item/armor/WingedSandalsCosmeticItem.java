package net.spacegateir.steamcraft.item.armor;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.client.winged_sandals.WingedSandalsRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WingedSandalsCosmeticItem extends ArmorItem implements GeoItem {
    private static long lastDashAge = 0;

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public WingedSandalsCosmeticItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_1"));
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_2"));
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_3"));
        } else {
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip"));
        }

    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private WingedSandalsRenderer renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new WingedSandalsRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<?> animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("animation.model.Idel", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public void handleMovement(ClientPlayerEntity player) {

        boolean isJumpingNow = player.input.sneaking && player.input.jumping;

        if (isJumpingNow && !player.isOnGround() && (player.age - lastDashAge > DASH_COOLDOWN_MS)) {
            if (player.getHungerManager().getFoodLevel() >= 10) {

                Vec3d forward = player.getRotationVec(1.0F).normalize().multiply(100.0); // Balanced dash distance
                Vec3d dashTo = new Vec3d(player.getX() + forward.x, player.getY(), player.getZ() + forward.z);
                player.updatePosition(dashTo.x, dashTo.y, dashTo.z);

                player.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 3.0F, 1.2F);

                Random random = player.getRandom();
                for (int i = 0; i < 10; i++) {
                    double offsetX = random.nextDouble() - 0.5;
                    double offsetY = random.nextDouble();
                    double offsetZ = random.nextDouble() - 0.5;

                    player.getWorld().addParticle(ParticleTypes.CLOUD,
                            dashTo.x + offsetX,
                            dashTo.y + offsetY,
                            dashTo.z + offsetZ,
                            0, 0, 0
                    );
                }

                if (!player.isCreative()) {
                    HungerManager hunger = player.getHungerManager();
                    hunger.setFoodLevel(Math.max(0, hunger.getFoodLevel() - 10));
                    hunger.setSaturationLevel(Math.min(hunger.getSaturationLevel(), hunger.getFoodLevel()));
                }

                lastDashAge = player.age;
            }
        }
    }

}




