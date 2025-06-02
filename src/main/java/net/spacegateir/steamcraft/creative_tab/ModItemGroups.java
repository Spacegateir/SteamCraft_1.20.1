package net.spacegateir.steamcraft.creative_tab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.spacegateir.steamcraft.Steamcraft;
import net.spacegateir.steamcraft.block.ModBlocks;
import net.spacegateir.steamcraft.block.arcane.ArcaneBlock;
import net.spacegateir.steamcraft.item.ModItems;
import net.spacegateir.steamcraft.item.ModRewardItems;

public class ModItemGroups {
    public static final ItemGroup STEAMCRAFT = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Steamcraft.MOD_ID, "sc"),
            FabricItemGroup.builder().displayName(Text.literal("SteamCraft"))
                    .icon(() -> new ItemStack(ModItems.PATTERN_RECOMPILER))
                    .entries((displayContext, entries) -> {
                        //Items
//                        entries.add(ModItems.TEST_ITEM);


                        entries.add(ModItems.TROWEL);
                        entries.add(ModItems.PATTERN_RECOMPILER);
                        entries.add(ModItems.TRAP_CONCEALER);
                        entries.add(ModItems.CORE_OF_CHANGING);

                        entries.add(ModItems.FERRITE_HEARTSTONE);
                        entries.add(ModItems.AETHERIUM_PRISM);
                        entries.add(ModItems.AQUARION_SHARD);
                        entries.add(ModItems.PYROCITE_CORE);
                        entries.add(ModItems.LUMINITE_SPARK);
                        entries.add(ModItems.OBSCURIUM_CRYSTAL);

                        entries.add(ModItems.BLANK_MOULD);
                        entries.add(ModItems.HELMET_MOULD);
                        entries.add(ModItems.CHESTPLATE_MOULD);
                        entries.add(ModItems.LEGGINGS_MOULD);
                        entries.add(ModItems.BOOTS_MOULD);
                        entries.add(ModItems.WINGED_SANDALS);

                        entries.add(ModItems.FOOLS_GOLD_SCRAP);
                        entries.add(ModItems.FOOLS_GOLD_RAW);
                        entries.add(ModBlocks.FOOLS_GOLD_RAW_BLOCK);
                        entries.add(ModItems.FOOLS_GOLD_INGOT);
                        entries.add(ModBlocks.FOOLS_GOLD_BLOCK);
                        entries.add(ModItems.DIVINITITE_ALLOY_INGOT);

                        entries.add(ModItems.FOOLS_GOLD_HELMET);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS);

                        entries.add(ModItems.CELESTIAL_GEARFORGED_HELMET);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_CHESTPLATE);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_LEGGINGS);
                        entries.add(ModItems.CELESTIAL_GEARFORGED_BOOTS);


                        entries.add(ModItems.FOOLS_GOLD_HELMET_1);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_2);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_3);
                        entries.add(ModItems.FOOLS_GOLD_HELMET_4);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_1);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_2);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_3);
                        entries.add(ModItems.FOOLS_GOLD_CHESTPLATE_4);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_1);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_2);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_3);
                        entries.add(ModItems.FOOLS_GOLD_LEGGINGS_4);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_1);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_2);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_3);
                        entries.add(ModItems.FOOLS_GOLD_BOOTS_4);

                        //Blocks
//                        entries.add(ModBlocks.TEST_BLOCK);

                        entries.add(ModBlocks.AETHER_COIL);
                        ModBlocks.COLOR_TO_AETHER_COIL.values().forEach(entries::add);

                        entries.add(ModBlocks.CLAY_PATH);
                        entries.add(ModBlocks.COARSE_DIRT_PATH);
                        entries.add(ModBlocks.DIRT_PATH);
                        entries.add(ModBlocks.GRAVEL_PATH);
                        entries.add(ModBlocks.MUD_PATH);
                        entries.add(ModBlocks.RED_SAND_PATH);
                        entries.add(ModBlocks.ROOTED_DIRT_PATH);
                        entries.add(ModBlocks.SAND_PATH);
                        entries.add(ModBlocks.SNOW_PATH);
                        entries.add(ModBlocks.ANDESITE_PATH);
                        entries.add(ModBlocks.ANDESITE_DIRTY_PATH);
                        entries.add(ModBlocks.ANDESITE_MOSSY_PATH);
                        entries.add(ModBlocks.COBBLESTONE_PATH);
                        entries.add(ModBlocks.COBBLED_DIRTY_PATH);
                        entries.add(ModBlocks.MOSSY_COBBLESTONE_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_DIRTY_PATH);
                        entries.add(ModBlocks.COBBLED_DEEPSLATE_MOSSY_PATH);
                        entries.add(ModBlocks.DIORITE_PATH);
                        entries.add(ModBlocks.DIORITE_DIRTY_PATH);
                        entries.add(ModBlocks.DIORITE_MOSSY_PATH);
                        entries.add(ModBlocks.GRANITE_PATH);
                        entries.add(ModBlocks.GRANITE_DIRTY_PATH);
                        entries.add(ModBlocks.GRANITE_MOSSY_PATH);
                        entries.add(ModBlocks.STONE_PATH);
                        entries.add(ModBlocks.STONE_DIRTY_PATH);
                        entries.add(ModBlocks.STONE_MOSSY_PATH);
                        entries.add(ModBlocks.END_STONE_PATH);

                        entries.add(ModBlocks.SKELETON_SITTING);
                        entries.add(ModBlocks.SKELETON_LAYING);
                        entries.add(ModBlocks.SKELETON_HEAD);
                        entries.add(ModBlocks.SKELETON_TORSO);
                        entries.add(ModBlocks.SKELETON_ARM);
                        entries.add(ModBlocks.SKELETON_ARMS_CROSS);
                        entries.add(ModBlocks.SKELETON_LEG);
                        entries.add(ModBlocks.SKELETON_LEGS_CROSS);
                        entries.add(ModBlocks.SKELETON_HEAD_STACK);
                        entries.add(ModBlocks.SKELETON_HALF_BODY);
                        entries.add(ModBlocks.SKELETON_CHEST);
                        entries.add(ModBlocks.SKELETON_PELVIS);
                        entries.add(ModBlocks.SKELETON_SPINE);

                        Registries.BLOCK.stream()
                                .filter(block -> block instanceof ArcaneBlock)
                                .forEach(entries::add);

                        entries.add(ModBlocks.POWER_PRECISION_BLOCK);

                        entries.add(ModBlocks.CURSED_BLOCK);
                        entries.add(ModBlocks.COURSE_DIRT_TRAP_BLOCK);
                        entries.add(ModBlocks.STONE_TRAP_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_TRAP_BLOCK);
                        entries.add(ModBlocks.SAND_QUICKSAND);
                        entries.add(ModBlocks.RED_SAND_QUICKSAND);
                        entries.add(ModBlocks.GRAVEL_SINKSTONE);
                        entries.add(ModBlocks.MUD_SINKING_SLUDGE);
                        entries.add(ModBlocks.SOUL_SAND_PHANTOM_QUICKSAND);
                        entries.add(ModBlocks.FLAREFORGE_BLOCK);
                        entries.add(ModBlocks.NETHER_STEAM_VENT);
                        entries.add(ModBlocks.SPIRIT_JUMP_TRAP);
                        entries.add(ModBlocks.FROST_BITE_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_NAUSEA_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_POISON_SPORE_TRAP_BLOCK);
                        entries.add(ModBlocks.CURSED_BRASIER_TRAP_BLOCK);
                        entries.add(ModBlocks.EMPTY_BRASIER);
                        entries.add(ModBlocks.CURSED_TOTEM_BLOCK);
                        entries.add(ModItems.TELEPORT_TRAP_ITEM);

                        entries.add(ModItems.SMOKE_BLOCK_ITEM);

                        for (DyeColor color : DyeColor.values()) {
                            entries.add(ModBlocks.COLOR_TO_CONCRETE.get(color));
                            entries.add(ModBlocks.COLOR_TO_CONCRETE_POWDER.get(color));
                        }

                        entries.add(ModBlocks.PACKED_ICE_BRICKS);
                        entries.add(ModBlocks.PACKED_ICE_BRICKS_CRACKED);
                        entries.add(ModBlocks.PACKED_ICE_TILES);
                        entries.add(ModBlocks.PACKED_ICE_TILES_CRACKED);

                        entries.add(ModBlocks.SNOW_BRICKS);
                        entries.add(ModBlocks.SNOW_BRICKS_CRACKED);
                        entries.add(ModBlocks.SNOW_TILES);
                        entries.add(ModBlocks.SNOW_TILES_CRACKED);

                        //BlockItems
//                        entries.add(ModItems.TEST_ITEM_BLOCK);


                        for (Block flower : ModBlocks.COLOR_TO_FLOWER.values()) {
                            entries.add(flower);
                            entries.add(ModBlocks.FLOWER_TO_GLOW_FLOWER.get(flower));
                            entries.add(ModBlocks.FLOWER_TO_THORNED_FLOWER.get(flower));
                            entries.add(ModBlocks.FLOWER_TO_GLOW_THORNED_FLOWER.get(flower));
                            entries.add(ModBlocks.FLOWER_TO_LUSH_FLOWER.get(flower));
                            entries.add(ModBlocks.FLOWER_TO_GLOW_LUSH_FLOWER.get(flower));
                        }

                        ModItems.COLOR_TO_WATER_BUCKET.values().forEach(entries::add);
                        ModItems.COLOR_TO_LAVA_BUCKET.values().forEach(entries::add);
                    }).build());

    public static final ItemGroup STEAMCRAFT_REWARDS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Steamcraft.MOD_ID, "scr"),
            FabricItemGroup.builder().displayName(Text.literal("SteamCraft Rewards"))
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

//                        entries.add(ModRewardItems.AMETHYST_LOOT_CHEST);
//                        entries.add(ModRewardItems.AMETHYST_HELMET);
//                        entries.add(ModRewardItems.AMETHYST_CHESTPLATE);
//                        entries.add(ModRewardItems.AMETHYST_LEGGINGS);
//                        entries.add(ModRewardItems.AMETHYST_BOOTS);


                    }).build());

    public static void registerItemGroups() {
        Steamcraft.LOGGER.info("Registering Item Groups");
    }
}