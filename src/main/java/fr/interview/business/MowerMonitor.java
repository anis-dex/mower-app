package fr.interview.business;

import exception.MowerException;
import fr.interview.tools.parser.LawnParser;
import fr.interview.tools.parser.MowerParser;
import tools.Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MowerMonitor {
    String[] mowerInfos;


    public void load(String filePath) throws MowerException,IOException  {
        mowerInfos = Utils.loadProvidedFile(filePath).split("\n");
    }


    public Lawn getLawn() {
        return LawnParser.parse(mowerInfos[0]);
    }

    public List<Mower> getMowers() {
        Lawn lawn = getLawn();
        return
                Arrays.asList(
                        MowerParser.parse(lawn, mowerInfos[1]),
                        MowerParser.parse(lawn, mowerInfos[3])
                );
    }

    public List<String> getInstructions() {
        return Arrays.asList(mowerInfos[2], mowerInfos[4]);
    }
}
