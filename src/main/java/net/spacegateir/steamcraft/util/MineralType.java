package net.spacegateir.steamcraft.util;

import net.minecraft.block.Block;
import net.spacegateir.steamcraft.block.ModBlocks;

public enum MineralType {
    DEFAULT(20),
    CLAY(40),
    COAL(50),
    IRON(60),
    COPPER(60),
    SILVER(80),
    REDSTONE(100),
    LAPIS(100),
    GOLD(120),
    NETHERITE(1200),
    GEM(60);


    private final int respawnDelayTicks;

    MineralType(int ticks) {
        this.respawnDelayTicks = ticks;
    }

    public int getRespawnDelayTicks() {
        return respawnDelayTicks;
    }

    public Block getActiveBlock() {
        switch (this) {
            case CLAY:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_CLAY;
            case COAL:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_COAL;
            case IRON:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_IRON;
            case COPPER:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_COPPER;
            case SILVER:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_SILVER;
            case REDSTONE:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_REDSTONE;
            case LAPIS:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_LAPIS;
            case GOLD:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_GOLD;
            case NETHERITE:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_NETHERITE;
            case GEM:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_GEM;
            default:
                return ModBlocks.MINERAL_DEPOSIT_ACTIVE_BLOCK;
        }
    }

    public Block getInactiveBlock() {
        switch (this) {
            case CLAY:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_CLAY;
            case COAL:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_COAL;
            case IRON:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_IRON;
            case COPPER:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_COPPER;
            case SILVER:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_SILVER;
            case REDSTONE:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_REDSTONE;
            case LAPIS:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_LAPIS;
            case GOLD:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_GOLD;
            case NETHERITE:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_NETHERITE;
            case GEM:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_GEM;
            default:
                return ModBlocks.MINERAL_DEPOSIT_INACTIVE_BLOCK;
        }
    }

}


