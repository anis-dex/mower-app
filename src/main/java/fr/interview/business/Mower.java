package fr.interview.business;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tools.parser.ActionParser;

import java.util.List;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mower {

    public static final char LEFT = 'G';
    private static final char RIGHT = 'D';
    private Lawn lawn;
    private Position position;
    private Orientation orientation;

    public Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public void apply(String task)  {
        List<Action> actions = ActionParser.parse(task);
        actions.forEach(action -> {
            if (action.isOrientation()) {
                changeOrientation(action.getName());
            }
            if (action.isMovement() && isMoveForwardPossible()) {
                moveForward();
            }
        });

    }

    private boolean isMoveForwardPossible() {
        Position nextPosition = getNextPositionOf(position.copy());
        return lawn.accept(nextPosition);

    }


    public void changeOrientation(char orientation) {
        if (LEFT == orientation) {
            this.orientation = this.orientation.left();
        }
        if (RIGHT == orientation) {
            this.orientation = this.orientation.right();
        }
    }

    private Position getNextPositionOf(Position p) {

        if (Orientation.NORTH.equals(this.orientation)) {
            p.goUp();

        }
        if (Orientation.EAST.equals(this.orientation)) {
            p.goRight();

        }
        if (Orientation.WEST.equals(this.orientation)) {
            p.goLeft();

        }
        if (Orientation.SOUTH.equals(this.orientation)) {
            p.goDown();
        }
        return p;

    }

    public void moveForward() {
        position = getNextPositionOf(position);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return position.equals(mower.position) &&
                orientation == mower.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }

    @Override
    public String toString() {
        return "Mower{" +

                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }

}
