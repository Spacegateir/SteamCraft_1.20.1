package net.spacegateir.steamcraft.item.trinkets.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.spacegateir.steamcraft.util.ModEntityAttributes;

import java.util.UUID;

public class AthleteShoesItem extends TrinketItem {

    private static final UUID SPEED_BOOST_UUID = UUID.fromString("e1a7e4d4-9c02-4af0-9c9f-122edc71ef90");
    private static final UUID JUMP_BOOST_UUID  = UUID.fromString("b2a1c4d7-1a4b-432d-9a87-0f1e6c7d9f00");
    private static final UUID STEP_BOOST_UUID = UUID.fromString("d3a8c9f2-7b5f-4e2a-8d8c-1f9b6e7c2a11");


    public AthleteShoesItem(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(
            ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {

        Multimap<EntityAttribute, EntityAttributeModifier> modifiers =
                super.getModifiers(stack, slot, entity, uuid);

        if (slot.inventory().getSlotType().getName().equals("feet") ||
                slot.inventory().getSlotType().getName().equals("shoes")) {

            // +50% movement speed
            modifiers.put(
                    EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    new EntityAttributeModifier(
                            SPEED_BOOST_UUID,
                            "Running Shoes speed boost",
                            0.5,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                    )
            );

            // +3 jump Height
            modifiers.put(
                    ModEntityAttributes.GENERIC_MOVEMENT_JUMP,
                    new EntityAttributeModifier(
                            JUMP_BOOST_UUID,
                            "Running Shoes jump boost",
                            3.0,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            // +1 Step Height
            modifiers.put(
                    ModEntityAttributes.GENERIC_MOVEMENT_STEP,
                    new EntityAttributeModifier(
                            STEP_BOOST_UUID,
                            "Running Shoes step boost",
                            1.0,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

        }

        return modifiers;
    }
}
