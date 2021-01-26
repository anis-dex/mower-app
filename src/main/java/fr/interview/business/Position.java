package fr.interview.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@AllArgsConstructor
@Getter
@Setter

public class Position {
    private int x;
    private int y;

    public void goUp() {
        this.y = y + 1;
    }

    public void goRight() {
        this.x = x + 1;
    }

    public void goLeft() {
        this.x = x - 1;
    }

    public void goDown() {
        this.y = y - 1;
    }

    public Position copy() {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
