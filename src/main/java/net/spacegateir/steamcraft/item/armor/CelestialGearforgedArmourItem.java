package net.spacegateir.steamcraft.item.armor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.spacegateir.steamcraft.item.ModArmorMaterials;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.client.celestial_gearforged.CelestialGearforgedArmourRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.minecraft.entity.EquipmentSlot.*;

public class CelestialGearforgedArmourItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.CELESTIAL_GEARFORGED, new StatusEffectInstance(ModEffects.CELESTIAL_GEARFORGES_EFFECT, 1000, 0))
                    .build();

    private static final UUID SPEED_BOOST_UUID = UUID.fromString("e94b5c2e-6a6f-4f1e-9048-6d5f84a16b36");
    private static final UUID ATTACK_BOOST_UUID = UUID.fromString("c47d1a2e-6b2a-4d5b-9dbe-2e7f92f8364f");
    private static final UUID ATTACK_SPEED_BOOST_UUID = UUID.fromString("5939e83f-2803-4aba-955d-e6ff4b0cc703");
    private static final UUID HEALTH_BOOST_UUID = UUID.fromString("89041fef-396a-48cc-8a13-86d58c1610c8");
    private static final UUID LUCK_BOOST_UUID = UUID.fromString("f429eb46-071c-42cf-bc51-687c85c1c113");

    private static final UUID ARMOR_UUID = UUID.fromString("e91e84b1-bd46-4cd2-8b35-df9a5942a1e1");
    private static final UUID TOUGHNESS_UUID = UUID.fromString("05f55ae2-9f6d-44f4-bb50-6a0a41835438");
    private static final UUID KNOCKBACK_RESISTANCE_UUID = UUID.fromString("9e29de15-7a4b-4f24-b55c-7b5a9c8f0e4e");

    private static final UUID HELMENT_UUID = UUID.fromString("a1f4bb3c-75cb-4c7b-8ee6-9e6caa1d1550");
    private static final UUID CHESTPLATE_UUID = UUID.fromString("e2037a43-21a3-4f32-8cb1-c12e60b22370");
    private static final UUID LEGGINGS_UUID = UUID.fromString("4de3db2f-9f6b-4e71-baf2-614d34fa9c6b");
    private static final UUID BOOTS_UUID = UUID.fromString("5f293a94-49f0-4bb7-a0cf-b3a32aebef9d");


    public CelestialGearforgedArmourItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private CelestialGearforgedArmourRenderer renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new CelestialGearforgedArmourRenderer();

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
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffect(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;

            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffectAlready = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (!hasPlayerEffectAlready) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial mapArmorMaterial, PlayerEntity player) {
        for (ItemStack armorStack : player.getArmorItems()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial &&
                chestplate.getMaterial() == mapArmorMaterial && boots.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() &&!leggings.isEmpty() &&!chestplate.isEmpty() &&!helmet.isEmpty();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        UUID armorUUID = switch (slot) {
            case HEAD -> HELMENT_UUID;
            case CHEST -> CHESTPLATE_UUID;
            case LEGS -> LEGGINGS_UUID;
            case FEET -> BOOTS_UUID;
            default -> UUID.randomUUID();
        };



        if (slot == HEAD && stack.getItem() == ModItems.CELESTIAL_GEARFORGED_HELMET) {
            builder.put(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(HELMENT_UUID, "Armor", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(HELMENT_UUID, "Toughness", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(HELMENT_UUID, "Knockback Resistance", 1.0, EntityAttributeModifier.Operation.MULTIPLY_BASE));

            builder.put(
                    EntityAttributes.GENERIC_LUCK,
                    new EntityAttributeModifier(LUCK_BOOST_UUID, "Luck boost", 50.0, EntityAttributeModifier.Operation.ADDITION));
        }

        if (slot == EquipmentSlot.CHEST && stack.getItem() == ModItems.CELESTIAL_GEARFORGED_CHESTPLATE) {
            builder.put(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(CHESTPLATE_UUID, "Armor", 18.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(CHESTPLATE_UUID, "Toughness", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(CHESTPLATE_UUID, "Knockback Resistance", 1.0, EntityAttributeModifier.Operation.MULTIPLY_BASE));


            builder.put(
                    EntityAttributes.GENERIC_ATTACK_DAMAGE,
                    new EntityAttributeModifier(ATTACK_BOOST_UUID, "Attack boost", 6.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_ATTACK_SPEED,
                    new EntityAttributeModifier(ATTACK_SPEED_BOOST_UUID, "Attack Speed boost", 1.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (slot == LEGS && stack.getItem() == ModItems.CELESTIAL_GEARFORGED_LEGGINGS) {
            builder.put(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(LEGGINGS_UUID, "Armor", 14.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(LEGGINGS_UUID, "Toughness", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(LEGGINGS_UUID, "Knockback Resistance", 1.0, EntityAttributeModifier.Operation.MULTIPLY_BASE));


            builder.put(
                    EntityAttributes.GENERIC_MAX_HEALTH,
                    new EntityAttributeModifier(HEALTH_BOOST_UUID, "Health boost", 20.0, EntityAttributeModifier.Operation.ADDITION));
        }

        if (slot == FEET && stack.getItem() == ModItems.CELESTIAL_GEARFORGED_BOOTS) {
            builder.put(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(BOOTS_UUID, "Armor", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(BOOTS_UUID, "Toughness", 8.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(
                    EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(BOOTS_UUID, "Knockback Resistance", 1.0, EntityAttributeModifier.Operation.MULTIPLY_BASE));


            builder.put(
                    EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    new EntityAttributeModifier(SPEED_BOOST_UUID, "Speed boost", 1.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return builder.build();
    }
}