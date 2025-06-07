package net.spacegateir.steamcraft.creative_tab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.item.ModRewardItems;

public class ModItemRewardsGroups {
    public static final ItemGroup STEAMCRAFT_REWARDS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Steamcraft.MOD_ID,"scr"),
            FabricItemGroup.builder().displayName(Text.translatable("SteamCraft Rewards"))
                    .icon(() -> new ItemStack(ModRewardItems.WOLF_FURY_HELMET)).entries((displayContext, entries) -> {

                        entries.add(ModRewardItems.LOOT_CHEST);

                        entries.add(ModRewardItems.DRAGON_BANE_LOOT_CHEST);
                        entries.add(ModRewardItems.DRAGON_BANE_HELMET);
                        entries.add(ModRewardItems.DRAGON_BANE_CHESTPLATE);
                        entries.add(ModRewardItems.DRAGON_BANE_LEGGINGS);
                        entries.add(ModRewardItems.DRAGON_BANE_BOOTS);

                        entries.add(ModRewardItems.ORIKALKUM_LOOT_CHEST);
                        entries.add(ModRewardItems.ORIKALKUM_HELMET);
                        entries.add(ModRewardItems.ORIKALKUM_CHESTPLATE);
                        entries.add(ModRewardItems.ORIKALKUM_LEGGINGS);
                        entries.add(ModRewardItems.ORIKALKUM_BOOTS);

                        entries.add(ModRewardItems.ADAMANTITE_LOOT_CHEST);
                        entries.add(ModRewardItems.ADAMANTITE_HELMET);
                        entries.add(ModRewardItems.ADAMANTITE_CHESTPLATE);
                        entries.add(ModRewardItems.ADAMANTITE_LEGGINGS);
                        entries.add(ModRewardItems.ADAMANTITE_BOOTS);

                        entries.add(ModRewardItems.MAGIRITE_LOOT_CHEST);
                        entries.add(ModRewardItems.MAGIRITE_HELMET);
                        entries.add(ModRewardItems.MAGIRITE_CHESTPLATE);
                        entries.add(ModRewardItems.MAGIRITE_LEGGINGS);
                        entries.add(ModRewardItems.MAGIRITE_BOOTS);

                        entries.add(ModRewardItems.MYTHRIL_LOOT_CHEST);
                        entries.add(ModRewardItems.MYTHRIL_HELMET);
                        entries.add(ModRewardItems.MYTHRIL_CHESTPLATE);
                        entries.add(ModRewardItems.MYTHRIL_LEGGINGS);
                        entries.add(ModRewardItems.MYTHRIL_BOOTS);

                        entries.add(ModRewardItems.DWARF_STEEL_LOOT_CHEST);
                        entries.add(ModRewardItems.DWARF_STEEL_HELMET);
                        entries.add(ModRewardItems.DWARF_STEEL_CHESTPLATE);
                        entries.add(ModRewardItems.DWARF_STEEL_LEGGINGS);
                        entries.add(ModRewardItems.DWARF_STEEL_BOOTS);

                        entries.add(ModRewardItems.AER_LOOT_CHEST);
                        entries.add(ModRewardItems.AER_HELMET);
                        entries.add(ModRewardItems.AER_CHESTPLATE);
                        entries.add(ModRewardItems.AER_LEGGINGS);
                        entries.add(ModRewardItems.AER_BOOTS);

                        entries.add(ModRewardItems.AQUA_LOOT_CHEST);
                        entries.add(ModRewardItems.AQUA_HELMET);
                        entries.add(ModRewardItems.AQUA_CHESTPLATE);
                        entries.add(ModRewardItems.AQUA_LEGGINGS);
                        entries.add(ModRewardItems.AQUA_BOOTS);

                        entries.add(ModRewardItems.TERA_LOOT_CHEST);
                        entries.add(ModRewardItems.TERA_HELMET);
                        entries.add(ModRewardItems.TERA_CHESTPLATE);
                        entries.add(ModRewardItems.TERA_LEGGINGS);
                        entries.add(ModRewardItems.TERA_BOOTS);

                        entries.add(ModRewardItems.IGNIS_LOOT_CHEST);
                        entries.add(ModRewardItems.IGNIS_HELMET);
                        entries.add(ModRewardItems.IGNIS_CHESTPLATE);
                        entries.add(ModRewardItems.IGNIS_LEGGINGS);
                        entries.add(ModRewardItems.IGNIS_BOOTS);

                        entries.add(ModRewardItems.WOLF_FURY_LOOT_CHEST);
                        entries.add(ModRewardItems.WOLF_FURY_HELMET);
                        entries.add(ModRewardItems.WOLF_FURY_CHESTPLATE);
                        entries.add(ModRewardItems.WOLF_FURY_LEGGINGS);
                        entries.add(ModRewardItems.WOLF_FURY_BOOTS);





                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("registering Item Rewards Groups for "+ Steamcraft.MOD_ID);
    }
}