package fr.interview;

import fr.interview.business.facade.FacadeMower;
import exception.MowerException;

public class MainApplication {
    final static String FILE_PATH = "./src/main/resources/data.txt";

    public static void main(String... args)  {
        try {
            new FacadeMower().treatment(FILE_PATH);
        } catch (MowerException mowerExp) {
            System.err.println(
                    "Business Exception occured : " + mowerExp.getMessage());
        } catch (Exception exp) {
            System.err.println(
                    " General Exception occured : " + exp.getMessage());
        }


    }


}
