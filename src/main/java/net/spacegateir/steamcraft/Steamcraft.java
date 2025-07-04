package net.spacegateir.steamcraft;

import net.fabricmc.api.ModInitializer;

import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.creative_tab.ModItemGroups;
import net.spacegateir.steamcraft.creative_tab.ModItemRewardsGroups;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;
import net.spacegateir.steamcraft.potion.ModPotions;
import net.spacegateir.steamcraft.util.*;
import net.spacegateir.steamcraft.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;



public class Steamcraft implements ModInitializer {
	public static final String MOD_ID = "steamcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModBlocks.registerCropData();
		ModItems.registerModItems();
		ModFluids.registerFluids();
		ModRewardItems.registerModRewardItems();

		ModBlockEntities.registerAll();

		ModItemGroups.registerItemGroups();
		ModItemRewardsGroups.registerItemGroups();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModRegistries.registerModStuff();
		ModCustomTrades.registerCustomTrades();
		ModLootTableModifiers.modifyLootTables();

		ModCauldronInteractions.bootstrap();

		GeckoLib.initialize();

		ModWorldGeneration.generateModWorldGeneration();












		LOGGER.info("Hello Fabric world!");
	}
}