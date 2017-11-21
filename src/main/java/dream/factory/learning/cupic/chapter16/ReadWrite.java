package dream.factory.learning.cupic.chapter16;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadWrite {
    public static void main(String[] args) throws IOException {
        primjerBinarni();
        primjerTekstovni();
    }

    private static void primjerBinarni() throws IOException {
        byte[] sadrzaj = {1, 2, 5, 7, 11};
        Path binarna = Paths.get("binarna.bin");
        Files.write(binarna, sadrzaj);
        byte[] novi = Files.readAllBytes(binarna);
        System.out.println("Jednaki: " + Arrays.equals(sadrzaj, novi));
    }

    private static void primjerTekstovni() throws IOException {
        List<String> lista = Arrays.asList(
                "Zagreb", "Bjelovar", "Sibenik", "Split"
        );

        Path tekstovna = Paths.get("gradovi.txt");
        Files.write(tekstovna, lista, StandardCharsets.UTF_8);
        List<String> ucitana = Files.readAllLines(
                tekstovna, StandardCharsets.UTF_8
        );

        System.out.println("Jednako: " + lista.equals(ucitana));
        System.out.println(ucitana);
    }

}
