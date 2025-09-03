package net.spacegateir.steamcraft.util;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityAttributes {

    public static final EntityAttribute GENERIC_MOVEMENT_JUMP = register(
            "generic.movement_jump", new ClampedEntityAttribute("attribute.name.generic.movement_jump",
                    0.0D, 0.0D,1024.0D).setTracked(true)
    );
    public static final EntityAttribute GENERIC_MOVEMENT_STEP = register(
            "generic.movement_step", new ClampedEntityAttribute("attribute.name.generic.movement_step",
                    0.0D, 0.0D,1024.0D).setTracked(true)
    );





    public static void addPlayerAttributes(DefaultAttributeContainer.Builder builder) {
        builder.add(GENERIC_MOVEMENT_JUMP, 0.0D);
        builder.add(GENERIC_MOVEMENT_STEP, 0.0D);
    }

    private static EntityAttribute register(String id, EntityAttribute attribute) {
        return Registry.register(Registries.ATTRIBUTE, new Identifier("steamcraft", id), attribute);
    }

    public static void registerAttributes() {
    }
}