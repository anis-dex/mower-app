package fr.interview.tools.parser;


import fr.interview.business.Lawn;

public class LawnParser {
    private static final String SEPARATOR = " ";
    private static final String PATTERN = "^\\d+ \\d+$";

private LawnParser(){

}
    public static Lawn parse(final String source) {
        if (source.matches(PATTERN)) {
            String[] fildes = source.split(SEPARATOR);
            return new Lawn(Integer.parseInt(fildes[0]), Integer.parseInt(fildes[1]));
        }
        return null;
    }

}
