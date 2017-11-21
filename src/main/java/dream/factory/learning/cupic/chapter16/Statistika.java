package dream.factory.learning.cupic.chapter16;

import java.io.File;
import java.util.*;

public class Statistika {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Krivi poziv!");
            System.exit(0);
        }

        File dir = new File(args[0]);
        Informacije info = obradi(dir);

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

        List<InfoOEkstenziji> lista = new ArrayList<>(
                info.mapa.values()
        );

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

    private static Informacije obradi (File dir) {
        Informacije info = new Informacije();
        rekurzivnoListaj(dir, info);
        return info;
    }

    private static void rekurzivnoListaj(File dir,
        Informacije info) {
        info.obradiDirektorij(dir);
        File[] djeca = dir.listFiles();
        if (djeca == null) return;
        for (File f : djeca) {
            if (f.isFile()) {
                info.obradiDatoteku(f);
            } else if (f.isDirectory()) {
                rekurzivnoListaj(f, info);
            }
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

        public void obradiDirektorij (File dir) {
            brojPojavaDirektorija++;
        }

        public void obradiDatoteku (File f) {
            brojPojavaDatoteka++;
            ukupnaVelicinaDatoteka += f.length();

            String ekst = izracunajEkstenziju (f.getName());
            if (ekst == null){
                return;
            }

            InfoOEkstenziji info = mapa.get(ekst);
            if (info == null)  {
                info = new InfoOEkstenziji(ekst);
                mapa.put(ekst, info);
            }
            info.brojPojava++;
            info.ukupnaVelicina += f.length();
        }

        private String izracunajEkstenziju (String name) {
            int pozicijeTocke = name.lastIndexOf('.');
            if (pozicijeTocke < 0) return null;
            String ekst = name.substring(pozicijeTocke + 1);
            if (ekst.isEmpty()) return null;
            return ekst.toUpperCase();
        }

    }

}
