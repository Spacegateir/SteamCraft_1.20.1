package net.spacegateir.steamcraft.util;

// Add these new MiningModes in your MiningMode enum:
public enum MiningMode {
    ONE_BY_ONE,
    ONE_BY_TWO,
    ONE_BY_THREE,
    THREE_BY_THREE,
    FIVE_BY_FIVE,
    SEVEN_BY_SEVEN;

    public static MiningMode next(MiningMode current, boolean hasBuff) {
        // Cycle through modes normally, but only allow 5x5 and 7x7 if buff is active
        switch (current) {
            case ONE_BY_ONE: return ONE_BY_TWO;
            case ONE_BY_TWO: return ONE_BY_THREE;
            case ONE_BY_THREE: return THREE_BY_THREE;
            case THREE_BY_THREE:
                return hasBuff ? FIVE_BY_FIVE : ONE_BY_ONE;
            case FIVE_BY_FIVE:
                return hasBuff ? SEVEN_BY_SEVEN : ONE_BY_ONE;
            case SEVEN_BY_SEVEN:
                return ONE_BY_ONE;
            default: return ONE_BY_ONE;
        }
    }
}
