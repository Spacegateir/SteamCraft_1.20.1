package net.spacegateir.steamcraft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.spacegateir.steamcraft.datagen.ModWorldGenerator;
import net.spacegateir.steamcraft.world.dimension.ModDimensions;

public class SteamcraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModWorldGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
