package dream.factory.learning.hearthstone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Abilities {
    HashSet<String> allAbilities = new HashSet<>();
    HashSet<String> hasAbilities = new HashSet<>();

    List<String> listOfAbilities = new ArrayList<>();

    {
    try (Stream<String> abilities = Files.lines(Paths.get("abilities.txt"))) {
        listOfAbilities = abilities.collect(Collectors.toList());
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        allAbilities.addAll(listOfAbilities);
    }
    }

    public Abilities () {
        this(null);
    }

    public Abilities (Collection list) {
        if (list == null) {
            hasAbilities.clear();
        } else {
            hasAbilities.addAll(allAbilities);
            hasAbilities.retainAll(list);
        }
    }

}
