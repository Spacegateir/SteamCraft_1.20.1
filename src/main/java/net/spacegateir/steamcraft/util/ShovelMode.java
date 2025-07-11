package net.spacegateir.steamcraft.util;

public enum ShovelMode {
    X1("1x1"),
    X1X2("1x2"),
    X1X3("1x3"),
    X3("3x3"),
    X5("5x5"),
    X7("7x7");

    private final String displayName;

    ShovelMode(String displayName) {
        this.displayName = displayName;
    }

    public static ShovelMode next(ShovelMode current, boolean hasBuff) {
        return switch (current) {
            case X1 -> X1X2;
            case X1X2 -> X1X3;
            case X1X3 -> X3;
            case X3 -> hasBuff ? X5 : X1;
            case X5 -> hasBuff ? X7 : X1;
            case X7 -> X1;
        };
    }

    public String getDisplayName() {
        return displayName;
    }
}
