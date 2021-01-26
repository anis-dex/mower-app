package fr.interview.business;

import java.util.Arrays;

public enum Orientation {

    NORTH("N"), WEST("W"), EAST("E"), SOUTH("S");
    String value;

    Orientation(String value) {
        this.value = value;
    }

    public static Orientation findByValue(String value) {
        return Arrays.stream(values())
                .filter(x -> x.value .equals(value))
                .findFirst()
                .orElse(null);

    }

    Orientation left() {
        if (this == NORTH) {
            return WEST;
        }
        if (this == WEST) {
            return SOUTH;
        }
        if (this == SOUTH) {
            return EAST;
        }
        return NORTH;
    }

    public Orientation right() {
        if (this == NORTH) {
            return EAST;
        }
        if (this == EAST) {
            return SOUTH;
        }
        if (this == SOUTH) {
            return WEST;
        }
        return NORTH;
    }


}
