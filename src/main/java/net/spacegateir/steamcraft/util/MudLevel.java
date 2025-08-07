package net.spacegateir.steamcraft.util;

public enum MudLevel {
    WET(-2),
    SLIGHTLY_WET(-1),
    NORMAL(0),
    SLIGHTLY_DRY(1),
    DRY(2);

    public final int value;

    MudLevel(int value) {
        this.value = value;
    }

    public static MudLevel fromValue(int value) {
        for (MudLevel level : values()) {
            if (level.value == value) return level;
        }

        // Clamp to closest valid value
        if (value < -2) return WET;
        if (value > 2) return DRY;
        return NORMAL;
    }
}
