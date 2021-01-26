package fr.interview.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Action {
    private char name;
    public static final char LEFT = 'G';
    private static final char RIGHT = 'D';

    public boolean isMovement() {
        return !isOrientation();
    }

    public boolean isOrientation() {
        return LEFT == name || RIGHT == name;
    }
}
