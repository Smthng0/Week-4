package dream.factory.learning.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbilitiesReader {

    HashSet<String> allAbilities = new HashSet<>();
    HashSet<String> hasAbilities = new HashSet<>();
    private List<String> listOfAbilities = new ArrayList<>();

    {
        try (Stream<String> abilities = Files.lines(Paths.get("abilities.txt"))) {
            listOfAbilities = abilities.collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            allAbilities.addAll(listOfAbilities);
            hasAbilities.addAll(allAbilities);
        }
    }

    public AbilitiesReader() {
        this(null);
    }

    public AbilitiesReader(Collection list) {
        if (list == null) {
            hasAbilities.clear();
        } else {
            hasAbilities.retainAll(list);
        }
    }

    //Tu cu napraviti liste ability-a po triggerima (comesIntoPlayAbility, triggerAbility, deathAbility...)
    //mozda ovo bude korisno jednom.... -> vjerovatno nece bit


}
