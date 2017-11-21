package dream.factory.learning.cupic.chapter16;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        Path p = Paths.get ("Not Real Path", "Dev", "Week-2", "Test");


        System.out.println("Root stuff");
        System.out.println(p.getRoot());
      //System.out.println(p.getRoot().getNameCount());
        System.out.println();

        System.out.println("Element stuff");
        int numberOfElements = p.getNameCount();
        for (int i = 0; i < numberOfElements; i++) {
            Path starting = p.getName(i);
            System.out.println(starting);
        }
        System.out.println();

        System.out.println("Other stuff");
        System.out.println(p.toAbsolutePath());
        System.out.println(p.subpath(0, 2));
        System.out.println(p.getParent());
        System.out.println();

    }
}
