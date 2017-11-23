package dream.factory.learning.hearthstone.readers;

import dream.factory.learning.hearthstone.readers.AbilitiesReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbilitiesReaderTest {

    @Test
    public void generate_abilities_List_OK() {
        List<String> testingList = new ArrayList<>();

        //this gets all abilities, shuffles them and collects only 5
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



        AbilitiesReader abilitiesList = new AbilitiesReader(testingSet);
        AbilitiesReader abilitiesListNull = new AbilitiesReader();
        System.out.println(abilitiesList.allAbilities.toString());
        System.out.println(testingSet.toString());
        System.out.println(abilitiesList.hasAbilities.toString());
        System.out.println(abilitiesListNull.hasAbilities.toString());
    }

}