package net.spacegateir.steamcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.spacegateir.steamcraft.block.ModBlockEntities;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.creative_tab.ModItemGroups;
import net.spacegateir.steamcraft.creative_tab.ModItemRewardsGroups;
import net.spacegateir.steamcraft.effect.ModEffects;
import net.spacegateir.steamcraft.event.AxeBlockBreakHandler;
import net.spacegateir.steamcraft.event.AxeBlockStripHandler;
import net.spacegateir.steamcraft.fluid.ModFluids;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;
import net.spacegateir.steamcraft.item.trinkets.item.MagicBagItem;
import net.spacegateir.steamcraft.item.trinkets.item.NecklaceTrinketItem;
import net.spacegateir.steamcraft.item.trinkets.item.RingTrinketItem;
import net.spacegateir.steamcraft.util.ModEvents;
import net.spacegateir.steamcraft.network.ModPackets;
import net.spacegateir.steamcraft.network.ModServerPackets;
import net.spacegateir.steamcraft.particle.ModParticles;
import net.spacegateir.steamcraft.potion.ModPotions;
import net.spacegateir.steamcraft.sound.ModSounds;
import net.spacegateir.steamcraft.util.*;
import net.spacegateir.steamcraft.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;






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
		ModSounds.registerSounds();

		ModBlockEntities.registerAll();

		ModEvents.register();

		ModItemGroups.registerItemGroups();
		ModItemRewardsGroups.registerItemGroups();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModParticles.registerParticles();

		ModEntityAttributes.registerAttributes();

		ModRegistries.registerModStuff();
		ModCustomTrades.registerCustomTrades();
		ModLootTableModifiers.modifyLootTables();

		ModCauldronInteractions.bootstrap();

		GeckoLib.initialize();

		ModWorldGeneration.generateModWorldGeneration();

		ModServerPackets.register();
		ModPackets.registerC2SPackets();
		ModPackets.registerServerReceivers();

		AxeBlockBreakHandler.register();
		AxeBlockStripHandler.register();

		ServerPlayNetworking.registerGlobalReceiver(MagicBagItem.OPEN_PACKET_ID, (server, player, handler, buf, responseSender) -> {
			server.execute(() -> MagicBagItem.openBag(player));
		});

		// Player tick
		ServerTickEvents.END_WORLD_TICK.register((world) -> {
			for (var player : world.getPlayers()) {
				RingTrinketItem.onPlayerTick(player, world);
				NecklaceTrinketItem.onPlayerTick(player, world);
			}
		});

		// Attack callback
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof LivingEntity target) {
				RingTrinketItem.onAttack(player, target);
			}
			return ActionResult.PASS;
		});







		LOGGER.info("Hello Fabric world!");
	}
}