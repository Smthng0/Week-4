package dream.factory.learning.hearthstone;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbilitiesListTest {

    @Test
    public void generate_abilities_List_OK() {
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



        AbilitiesList abilitiesList = new AbilitiesList(testingSet);
        AbilitiesList abilitiesListNull = new AbilitiesList();
        System.out.println(abilitiesList.allAbilities.toString());
        System.out.println(testingSet.toString());
        System.out.println(abilitiesList.hasAbilities.toString());
        System.out.println(abilitiesListNull.hasAbilities.toString());
    }

}