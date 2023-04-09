import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryIteratorExample {
    public static void main(String... args) throws Exception {
        Path dir = Paths.get("JavaBankDir");
        Files.walk(dir).forEach(path -> showFile(path.toFile()));
    }

    public static void showFile(File file) {
        if (!file.isDirectory()) {
            System.out.println("File: " + file.getAbsolutePath());
            try {
                System.out.println(Files.readAllLines(Paths.get(String.valueOf(file))).get(0));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
