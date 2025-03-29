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
    public static final RegistryKey<DimensionOptions> STEAMDIM_GREEN_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_green"));
    public static final RegistryKey<World> STEAMDIM_GREEN_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_green"));
    public static final RegistryKey<DimensionType> STEAM_DIM_GREEN_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_green_type"));

    public static final RegistryKey<DimensionOptions> STEAMDIM_BLUE_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_blue"));
    public static final RegistryKey<World> STEAMDIM_BLUE_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_blue"));
    public static final RegistryKey<DimensionType> STEAM_DIM_BLUE_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_blue_type"));

    public static final RegistryKey<DimensionOptions> STEAMDIM_RED_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_red"));
    public static final RegistryKey<World> STEAMDIM_RED_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_red"));
    public static final RegistryKey<DimensionType> STEAM_DIM_RED_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_red_type"));

    public static final RegistryKey<DimensionOptions> STEAMDIM_YELLOW_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_yellow"));
    public static final RegistryKey<World> STEAMDIM_YELLOW_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_yellow"));
    public static final RegistryKey<DimensionType> STEAM_DIM_YELLOW_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_yellow_type"));

    public static final RegistryKey<DimensionOptions> STEAMDIM_WHITE_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_white"));
    public static final RegistryKey<World> STEAMDIM_WHITE_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_white"));
    public static final RegistryKey<DimensionType> STEAM_DIM_WHITE_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_white_type"));

    public static final RegistryKey<DimensionOptions> STEAMDIM_BLACK_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(Steamcraft.MOD_ID, "steamdim_black"));
    public static final RegistryKey<World> STEAMDIM_BLACK_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Steamcraft.MOD_ID, "steamdim_black"));
    public static final RegistryKey<DimensionType> STEAM_DIM_BLACK_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(Steamcraft.MOD_ID, "steamdim_black_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(STEAM_DIM_GREEN_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
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
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));

        context.register(STEAM_DIM_BLUE_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
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
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));

        context.register(STEAM_DIM_RED_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                false, // bedWorks
                true, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));

        context.register(STEAM_DIM_YELLOW_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
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
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));

        context.register(STEAM_DIM_WHITE_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
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
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));

        context.register(STEAM_DIM_BLACK_TYPE, new DimensionType(
                OptionalLong.of(6000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                true, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 7), 0)));
    }
}