package dream.factory.learning.cupic.chapter15;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Kolektori {
    public static void main(String[] args) {
        List<String> imena = Arrays.asList(
                "Zec", "Vice", "Marin", "Muci", "Mario", "Dejan"
        );

        String spojenaImena = imena.stream()
                .collect(
                        new Supplier<StringBuilder>() {
                            @Override
                            public StringBuilder get() {
                                return new StringBuilder();
                            }
                        },
                        new BiConsumer<StringBuilder, String>() {
                            @Override
                            public void accept(StringBuilder aku, String ime) {
                                aku.append(ime);
                            }
                        },
                        new BiConsumer<StringBuilder, StringBuilder>() {
                            @Override
                            public void accept(StringBuilder aku1, StringBuilder aku2) {
                                aku1.append(aku2);
                            }

                            ;
                        }
                )
                .toString();

        System.out.println(spojenaImena);

        String spojenaImenaBuilder = imena.stream()
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                )
                .toString();

        System.out.println(spojenaImenaBuilder);

        String spojenaImenaJoiner = imena.stream()
                .collect(
                        () -> new StringJoiner(", "),
                        StringJoiner::add,
                        StringJoiner::merge
                )
                .toString();

        System.out.println(spojenaImenaJoiner);

        String spojenaImenaKolektor = imena.stream()
                .collect(Collectors.joining(", "));

        System.out.println(spojenaImenaKolektor);


    }

}
