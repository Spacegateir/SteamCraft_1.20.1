package net.spacegateir.steamcraft.world.biome;

import net.minecraft.sound.SoundEvents;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.spacegateir.steamcraft.Steamcraft;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> TEST_BIOME = register("test_biome");
    public static final RegistryKey<Biome> VOID_BIOME = register("void_biome");

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(Steamcraft.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(TEST_BIOME, testBiome(context));
        context.register(VOID_BIOME, VoidBiome(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome VoidBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();


        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, MiscPlacedFeatures.VOID_START_PLATFORM);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.0f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8103167)
//                        .grassColor(0x7f03fc)
//                        .foliageColor(0xd203fc)
                        .fogColor(12638463)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }

    public static Biome testBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
//        spawnBuilder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 1, 2));

//        spawnBuilder.spawn(SpawnGroup.AXOLOTLS, new SpawnSettings.SpawnEntry(EntityType.AXOLOTL, 5, 1, 4));

        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.COD, 10, 3, 6));
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 10, 3, 6));
//        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 10, 3, 6));

//        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.TURTLE, 5, 2, 5));

        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 10, 1, 2));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 10, 1, 4));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 10, 1, 4));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 10, 1, 2));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WARDEN, 1, 1, 1));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 3, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITHER_SKELETON, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BLAZE, 5, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HOGLIN, 5, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN_BRUTE, 3, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PILLAGER, 5, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.RAVAGER, 2, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.VEX, 5, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.VINDICATOR, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.EVOKER, 3, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PHANTOM, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 5, 2, 5));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SHULKER, 3, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOGLIN, 3, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 8, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HUSK, 8, 1, 3));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 8, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 8, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GUARDIAN, 5, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ELDER_GUARDIAN, 1, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 8, 1, 3));
//        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 8, 1, 3));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 10, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.HORSE, 5, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DONKEY, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MULE, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MOOSHROOM, 5, 1, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 8, 2, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PANDA, 5, 1, 2));
//        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.POLAR_BEAR, 3, 1, 2));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));
//        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SNIFFER, 5, 1, 2));

//        spawnBuilder.spawn(SpawnGroup.MISC, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 3, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MISC, new SpawnSettings.SpawnEntry(EntityType.TRADER_LLAMA, 2, 1, 1));
        spawnBuilder.spawn(SpawnGroup.MISC, new SpawnSettings.SpawnEntry(EntityType.LLAMA, 3, 2, 4));
//        spawnBuilder.spawn(SpawnGroup.MISC, new SpawnSettings.SpawnEntry(EntityType.IRON_GOLEM, 1, 1, 1));
//        spawnBuilder.spawn(SpawnGroup.MISC, new SpawnSettings.SpawnEntry(EntityType.WANDERING_TRADER, 1, 1, 1));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_GAME))
                        .build())
                .build();
    }
}