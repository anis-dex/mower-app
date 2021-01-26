package fr.interview.business.facade;

import fr.interview.business.Lawn;
import fr.interview.business.Mower;
import fr.interview.business.MowerMonitor;
import exception.MowerException;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@NoArgsConstructor
public class FacadeMower {

    public static void treatment(String arg) throws MowerException, IOException {
        MowerMonitor mowerManager = new MowerMonitor();
        mowerManager.load(arg);
        Lawn lawn = mowerManager.getLawn();
        List<Mower> mowers = mowerManager.getMowers();
        List<String> instructions = mowerManager.getInstructions();

        Mower firstMower = mowers.get(0);
        firstMower.apply(instructions.get(0));
        Mower secondMower = mowers.get(1);
        secondMower.apply(instructions.get(1));

        System.out.println(firstMower.getPosition().getX() + " " + firstMower.getPosition().getY() + " " + firstMower.getOrientation());
        System.out.println(secondMower.getPosition().getX() + " " + secondMower.getPosition().getY() + " " + secondMower.getOrientation());
    }
}
