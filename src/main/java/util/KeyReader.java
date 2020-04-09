package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class KeyReader {
    public static String getKey() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src", "main", "resources", "key.txt")));
    }
}
