package net.spacegateir.steamcraft.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.spacegateir.steamcraft.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {

        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.DIAMOND,48),
                            new ItemStack(ModItems.WINGED_SANDALS,1),
                            1, 25, 0.05f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK,8),
                            new ItemStack(ModItems.FOOLS_GOLD_LEGGINGS_3,1),
                            1, 25, 0.05f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.CHARCOAL,16),
                            new ItemStack(Items.EMERALD,2),
                            32, 2, 0.5f));
                });

    }
}
