package dream.factory.learning.hearthstone;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbilitiesTest {

    @Test
    public void generate_abilities_OK() {
        List<String> testingList = new ArrayList<>();

        try (Stream<String> abilities = Files.lines(Paths.get("abilities.txt"))) {
            testingList = abilities.collect(
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            collected -> {
                                Collections.shuffle(collected);
                                return collected.stream();
                            }))
                    .limit(5)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Set<String> testingSet = new HashSet<>(testingList);



        Abilities abilities = new Abilities(testingSet);
        System.out.println(abilities.allAbilities.toString());
        System.out.println(testingSet.toString());
        System.out.println(abilities.hasAbilities.toString());
    }

}