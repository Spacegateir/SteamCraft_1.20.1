package net.spacegateir.steamcraft.util;

public enum LumberMode {
    NORMAL("Normal"),
    PILLAR("Pillar"),
    LUMBER_JACK("Lumber Jack");

    private final String displayName;

    LumberMode(String displayName) {
        this.displayName = displayName;
    }

    public static LumberMode next(LumberMode current, boolean hasBuff) {
        return switch (current) {
            case NORMAL -> PILLAR;
            case PILLAR -> LUMBER_JACK;
            case LUMBER_JACK -> NORMAL;
        };
    }

    public String getDisplayName() {
        return displayName;
    }
}
