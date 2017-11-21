package dream.factory.learning.cupic.chapter16;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class StatistikaWithInterface {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Krivi poziv!");
            System.exit(0);
        }

        Path dir = Paths.get(args[0]);

        Analiza analiza = new Analiza();

        try {
            Files.walkFileTree(dir, analiza);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        Informacije info = analiza.info;

        System.out.println(
                "Broj datoteka je: " + info.brojPojavaDatoteka);
        System.out.println(
                "Ukupna velicina datoteka je: " +
                        info.ukupnaVelicinaDatoteka);
        System.out.println(
                "Prosjecna velicina datoteka je: " +
                        info.prosjekDatoteka());
        System.out.println(
                "Broj direktorija je: " + info.brojPojavaDatoteka);

        List<InfoOEkstenziji> lista =
                new ArrayList<>(info.mapa.values());

        Comparator<InfoOEkstenziji> komparator =
                new Comparator<InfoOEkstenziji>() {
                    @Override
                    public int compare(InfoOEkstenziji o1, InfoOEkstenziji o2) {
                        return o1.ekstenzija.compareTo(o2.ekstenzija);
                    }
                };

        Collections.sort(
                lista, Collections.reverseOrder(komparator)
        );

        for (InfoOEkstenziji i : lista) {
            System.out.println(
                    i.ekstenzija + " " + i.brojPojava + " " +
                            i.ukupnaVelicina + " " + i.prosjek()
            );
        }

    }

    private static class Analiza implements FileVisitor<Path> {

        private Informacije info = new Informacije();

        @Override
        public FileVisitResult postVisitDirectory (Path dir,
                                                   IOException exc)
            throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory (Path dir,
            BasicFileAttributes attrs) throws IOException {
            info.obradiDirektorij (dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile (Path file,
            BasicFileAttributes attrs) throws IOException {
            info.obradiDatoteku (file);
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult visitFileFailed (Path file,
        IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
        }

    }

    static class InfoOEkstenziji {
        String ekstenzija;
        int brojPojava;
        long ukupnaVelicina;

        public InfoOEkstenziji (String ekstenzija) {
            super();
            this.ekstenzija = ekstenzija;
        }

        double prosjek() {
            if (brojPojava == 0){
                return 0;
            }
            return ukupnaVelicina / brojPojava;
        }
    }

    static class Informacije {
        int brojPojavaDirektorija;
        int brojPojavaDatoteka;
        long ukupnaVelicinaDatoteka;

        Map<String, InfoOEkstenziji> mapa =
                new HashMap<String, InfoOEkstenziji>();

        double prosjekDatoteka() {
            if (brojPojavaDatoteka == 0){
                return 0;
            }
            return ukupnaVelicinaDatoteka / brojPojavaDatoteka;
        }

        public void obradiDirektorij (Path dir) {
            brojPojavaDirektorija++;
        }

        public void obradiDatoteku (Path f) {
            brojPojavaDatoteka++;

            long velicina = 0;
            try {
                velicina = Files.size(f);
            } catch (IOException ignorable) {
            }

            ukupnaVelicinaDatoteka += velicina;

            String ekst = izracunajEkstenziju (
                    f.getFileName().toString()
            );

            if (ekst == null) return;

            InfoOEkstenziji info = mapa.get(ekst);
            if (info == null) {
                info = new InfoOEkstenziji(ekst);
                mapa.put(ekst, info);
            }

            info.brojPojava++;
            info.ukupnaVelicina += velicina;
        }

        private String izracunajEkstenziju (String name) {
            int pozicijaTocke = name.lastIndexOf('.');
            if (pozicijaTocke < 0) return null;
            String ekst = name.substring(pozicijaTocke+1);
            if (ekst.isEmpty()) return null;
            return ekst.toUpperCase();
        }
    }
}
