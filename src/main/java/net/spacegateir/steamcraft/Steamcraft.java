package net.spacegateir.steamcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.creative_tab.ModItemGroups;
import net.spacegateir.steamcraft.creative_tab.ModItemRewardsGroups;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;
import net.spacegateir.steamcraft.util.ModCustomTrades;
import net.spacegateir.steamcraft.util.ModLootTableModifiers;
import net.spacegateir.steamcraft.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Steamcraft implements ModInitializer {
	public static final String MOD_ID = "steamcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModRewardItems.registerModRewardItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();
		ModItemRewardsGroups.registerItemGroups();



		ModEffects.registerEffects();

		ModRegistries.registerModStuff();
		ModCustomTrades.registerCustomTrades();
		ModLootTableModifiers.modifyLootTables();

		GeckoLib.initialize();





		LOGGER.info("Hello Fabric world!");
	}
}