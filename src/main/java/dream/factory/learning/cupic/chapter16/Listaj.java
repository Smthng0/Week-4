package dream.factory.learning.cupic.chapter16;

import java.io.File;

public class Listaj {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Krivi poziv!");
            System.exit(0);
        }

        System.out.println(" \"baba\"  ");
        System.out.println("\\\"baba\"\\");


        File dir = new File(args[0]);
        rekurzivnoListaj(dir);
    }

    private static void rekurzivnoListaj(File dir) {
        System.out.println(dir);
        File[] djeca = dir.listFiles();
        if (djeca == null) return;
        for (File f : djeca){
            if (f.isFile()) {
                System.out.println(f);
            } else if (f.isDirectory()) {
                rekurzivnoListaj(f);
            }
        }
    }

}
