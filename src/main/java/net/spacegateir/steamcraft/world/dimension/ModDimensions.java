package net.spacegateir.steamcraft.world.dimension;

import net.spacegateir.steamcraft.Steamcraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> STEAMDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim"));
    public static final RegistryKey<World> STEAMDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim"));
    public static final RegistryKey<DimensionType> STEAM_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(STEAM_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)));
    }
}