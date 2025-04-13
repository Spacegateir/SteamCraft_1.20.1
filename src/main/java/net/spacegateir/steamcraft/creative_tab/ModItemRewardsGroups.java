package net.spacegateir.steamcraft.creative_tab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;

public class ModItemRewardsGroups {
    public static final ItemGroup STEAMCRAFT_REWARDS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Steamcraft.MOD_ID,"scr"),
            FabricItemGroup.builder().displayName(Text.translatable("SteamCraft Rewards"))
                    .icon(() -> new ItemStack(ModRewardItems.WOLF_FURY_HELMET)).entries((displayContext, entries) -> {

                        entries.add(ModRewardItems.AMETHYST_HELMET);
                        entries.add(ModRewardItems.AMETHYST_CHESTPLATE);
                        entries.add(ModRewardItems.AMETHYST_LEGGINGS);
                        entries.add(ModRewardItems.AMETHYST_BOOTS);

                        entries.add(ModRewardItems.WOLF_FURY_HELMET);
                        entries.add(ModRewardItems.WOLF_FURY_CHESTPLATE);
                        entries.add(ModRewardItems.WOLF_FURY_LEGGINGS);
                        entries.add(ModRewardItems.WOLF_FURY_BOOTS);





                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Rewards Groups for "+ Steamcraft.MOD_ID);
    }
}