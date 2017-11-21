package dream.factory.learning.cupic.chapter16;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IspisDirektorija {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Wrong call!");
            return;
        }

        Path dir = Paths.get(args[0]);

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir, "*.*")) {
            for (Path p : stream) {
                System.out.println(p.getFileName());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
