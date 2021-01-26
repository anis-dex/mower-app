package fr.interview.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Lawn {
    private int width;
    private int length;

    public boolean accept(Position p) {
        return p.getX() <= this.width && p.getX() >= 0
                && p.getY() <= this.length && p.getY() >= 0;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

}
