package tools;

import exception.MowerException;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@NoArgsConstructor
public class Utils {

    public static String loadProvidedFile(String filePath) throws MowerException, IOException {
        File file = new File(filePath);
        if (!file.isFile()) {
            throw new MowerException("Erreur Fichier inexistant");
        }
        StringBuilder linesFile = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> linesFile.append(line).append("\n"));

        }
        return linesFile.toString();

    }
}
