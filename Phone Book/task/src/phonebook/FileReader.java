package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static String[] readFromFile(String pathToFile) throws IOException {
        return Files.readAllLines(Path.of(pathToFile)).toArray(new String[0]);
    }
}
