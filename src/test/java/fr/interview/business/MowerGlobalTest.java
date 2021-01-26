package fr.interview.business;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MowerGlobalTest {
    final static String FILE_PATH = "./src/test/resources/data.txt";
    @Test
    public void mowerFollowInstructionFile() throws Exception {
        //Given
        MowerMonitor mowerManager = new MowerMonitor();
        mowerManager.load(FILE_PATH);
        Lawn lawn = mowerManager.getLawn();
        List<Mower> mowers = mowerManager.getMowers();
        List<String> instructions = mowerManager.getInstructions();

        Lawn expectedLawn = new Lawn(5, 5);
        Assert.assertEquals(expectedLawn, lawn);


        Mower firstMower = mowers.get(0);
        //when
        firstMower.apply(instructions.get(0));
        Mower expected = new Mower(new Position(1, 3), Orientation.NORTH);
        //then
        Assert.assertEquals(expected, firstMower);



        Mower secondMower = mowers.get(1);
        //when
        secondMower.apply(instructions.get(1));
        //then
        expected = new Mower(new Position(5, 1), Orientation.EAST);

        Assert.assertEquals(expected, secondMower);


    }
}
