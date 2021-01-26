package fr.interview.business;

import org.junit.Assert;
import org.junit.Test;

public class movingForwardAndOrientationTest {

    @Test
    public void takingTourAndStayAndSameDirection() {
        Lawn lawn = new Lawn(5, 5);
        Mower m = new Mower(lawn, new Position(2, 2), Orientation.NORTH);
        m.apply("GGGG");
        Mower expected = new Mower(lawn, new Position(2, 2), Orientation.NORTH);
        Assert.assertEquals(expected, m);
    }

    @Test
    public void movingRightAndForwardChangeOrientationPositionX() {
        Lawn lawn = new Lawn(5, 5);
        Mower m = new Mower(lawn, new Position(2, 2), Orientation.NORTH);
        m.apply("DA");
        Mower expected = new Mower(lawn, new Position(3, 2), Orientation.EAST);
        Assert.assertEquals(expected, m);
    }

    @Test
    public void movingLeftAndForwardChangeOrientationPositionY() {
        Lawn lawn = new Lawn(5, 5);
        Mower m = new Mower(lawn, new Position(2, 2), Orientation.NORTH);
        m.apply("GA");
        Mower expected = new Mower(lawn, new Position(1, 2), Orientation.WEST);
        Assert.assertEquals(expected, m);
    }


    @Test
    public void givenArbitraryInstruction() {
        Lawn lawn = new Lawn(5, 5);
        Mower m = new Mower(lawn, new Position(1, 2), Orientation.NORTH);
        m.apply("GAGAGAGAA");
        Mower expected = new Mower(lawn, new Position(1, 3), Orientation.NORTH);
        Assert.assertEquals(expected, m);
    }

    @Test
    public void minimizeLawAndVerifyStoppedMower() {
        Lawn lawn = new Lawn(3, 3);
        Mower m = new Mower(lawn, new Position(1, 2), Orientation.NORTH);
        m.apply("AADAADADDA");
        Mower expected = new Mower(lawn, new Position(3, 3), Orientation.NORTH);
        Assert.assertEquals(expected, m);
    }
}
