package enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum which represents the different types of pentominoes
 */
public enum PentominoTypeEnum {
    /**
     * Represents the names of pentominoes
     */
    F, _7, I, L, J, N, S, P, Q, T, U, V, W, X, Y, _L, Z, _S;

    /**
     * Static lookup table relating enum ordinal number to {@link PentominoTypeEnum}
     */
    public static final Map<Integer, PentominoTypeEnum> lookup = new HashMap<>();

    // Creation of the lookup table
    static {
        int ordinal = 0;
        for (PentominoTypeEnum p: EnumSet.allOf(PentominoTypeEnum.class)) {
            lookup.put(ordinal++, p);
        }
    }

    /**
     * @return this enum value's ordinal number
     */
    public int getType() {
        return this.ordinal();
    }

    /**
     * @param ordinal the requested ordinal number
     * @return the {@link PentominoTypeEnum} enum value for the given ordinal number
     */
    public static PentominoTypeEnum fromOrdinal(int ordinal) {
        return lookup.get(ordinal);
    }

    /**
     * @return a random {@link PentominoTypeEnum}
     */
    public static PentominoTypeEnum getRandomPentoType() {
        int rand = (int)(Math.random() * 18);
        return fromOrdinal(rand);
    }
}
