package net.spacegateir.steamcraft;

import net.fabricmc.api.ModInitializer;

import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.creative_tab.ModItemGroups;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.util.ModLootTableModifiers;
import net.spacegateir.steamcraft.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Steamcraft implements ModInitializer {
	public static final String MOD_ID = "steamcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();


		ModRegistries.registerModStuff();
		ModLootTableModifiers.modifyLootTables();



		LOGGER.info("Hello Fabric world!");
	}
}