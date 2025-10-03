package net.spacegateir.steamcraft.item.armor;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.item.client.winged_sandals.WingedSandalsRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.spacegateir.steamcraft.network.ModPackets;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WingedSandalsCosmeticItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    private long lastDashTime = 0; // Add this as a class field
    private static final long DASH_COOLDOWN_MS = 10000; // 10 seconds cooldown


    public WingedSandalsCosmeticItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_1"));
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_2"));
            tooltip.add(Text.translatable("tooltip.steamcraft.winged_sandals.tooltip.shift_3"));

            long timeLeft = Math.max(0, (DASH_COOLDOWN_MS - (System.currentTimeMillis() - lastDashTime)) / 1000);
            if (timeLeft > 0) {
                tooltip.add(Text.literal("§cDash Cooldown: " + timeLeft + "s"));
            } else {
                tooltip.add(Text.literal("§aDash Ready!"));
            }
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
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("animation.model.Idel", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public void handleMovement(ClientPlayerEntity player) {
        boolean isJumpingNow = player.input.sneaking && player.input.jumping;
        long currentTime = System.currentTimeMillis();

        if (isJumpingNow && !player.isOnGround() && (currentTime - lastDashTime > DASH_COOLDOWN_MS)) {
            // Send dash activation to server
            PacketByteBuf buf = PacketByteBufs.create();
            ClientPlayNetworking.send(ModPackets.WINGED_SANDALS_DASH_PACKET_ID, buf);

            lastDashTime = currentTime;
        }
    }

}




