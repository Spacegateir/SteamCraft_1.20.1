package net.spacegateir.steamcraft.util;

public enum ShearsMode {
    X1("1x1"),
    X3("3x3"),
    X5("5x5"),
    X7("7x7");

    private final String displayName;

    ShearsMode(String displayName) {
        this.displayName = displayName;
    }

    public static ShearsMode next(ShearsMode current, boolean hasBuff) {
        return switch (current) {
            case X1 -> X3;
            case X3 -> X5;
            case X5 -> hasBuff ? X7 : X1;
            case X7 -> X1;
            default -> X1;
        };
    }

    public String getDisplayName() {
        return displayName;
    }
}
