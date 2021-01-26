package tools.parser;

import fr.interview.business.Action;

import java.util.List;
import java.util.stream.Collectors;

public class ActionParser {
    private ActionParser(){

    }
    public static List<Action> parse(String tasks) {
        return tasks.chars()
                .mapToObj(task -> new Action((char) task))
                .collect(Collectors.toList());

    }
}


