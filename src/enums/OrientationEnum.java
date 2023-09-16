package enums;

import java.util.*;

/**
 * Enum that represents the possible Block orientations
 */
public enum OrientationEnum {
    /**
     * Represents the block orientations
     */
    UP, DOWN, LEFT, RIGHT;

    /**
     * Static lookup table relating enum ordinal number to {@link OrientationEnum}
     */
    private static final Map<Integer, OrientationEnum> lookup = new HashMap<>();

    // Creation of the lookup table
    static {
        int ordinal = 0;
        for (OrientationEnum o : EnumSet.allOf(OrientationEnum.class)) {
            lookup.put(ordinal++, o);
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
     * @return the {@link OrientationEnum} enum value for the given ordinal number
     */
    public static OrientationEnum fromOrdinal(int ordinal) {
        return lookup.get(ordinal);
    }

    /**
     * @return a random {@link OrientationEnum}
     */
    public static OrientationEnum getRandomOrientation() {
        int rand = (int)(Math.random() * 4);
        return fromOrdinal(rand);
    }
}
