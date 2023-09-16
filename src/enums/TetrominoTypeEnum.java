package enums;

import java.util.*;

/**
 * Enum which represents the different types of tetrominoes
 */
public enum TetrominoTypeEnum {
    /**
     * Represents the names of tetrominoes
     */
    I, J, L, O, S, T, Z;

    /**
     * Static lookup table relating enum ordinal number to {@link TetrominoTypeEnum}
     */
    private static final Map<Integer, TetrominoTypeEnum> lookup = new HashMap<>();

    // Creation of the lookup table
    static {
        int ordinal = 0;
        for (TetrominoTypeEnum t: EnumSet.allOf(TetrominoTypeEnum.class)) {
            lookup.put(ordinal++, t);
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
     * @return the {@link TetrominoTypeEnum} enum value for the given ordinal number
     */
    public static TetrominoTypeEnum fromOrdinal(int ordinal) {
        return lookup.get(ordinal);
    }

    /**
     * @return a random {@link TetrominoTypeEnum}
     */
    public static TetrominoTypeEnum getRandomTetroType() {
        int rand = (int)(Math.random() * 7);
        return fromOrdinal(rand);
    }
}
