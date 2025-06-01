package net.spacegateir.steamcraft.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.entity.SmokeBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<SmokeBlockEntity> SMOKE_BLOCK_ENTITY =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE, // this is valid in 1.19.x and earlier
                    new Identifier(Steamcraft.MOD_ID, "smoke_block_entity"),
                    BlockEntityType.Builder.create(SmokeBlockEntity::new, ModBlocks.SMOKE_BLOCK).build(null)
            );



    public static void registerBlockEntities() {

    }
}
