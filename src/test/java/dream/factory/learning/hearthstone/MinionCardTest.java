package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.Charge;
import dream.factory.learning.hearthstone.abilities.DivineShield;
import dream.factory.learning.hearthstone.abilities.Windfury;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinionCardTest {

    @Test
    public void attack_OK() {
        List<Ability> abilities1 = new ArrayList<>();
        List<Ability> abilities2 = new ArrayList<>();
        abilities1.add(new Windfury());
        abilities1.add(new Charge());
        abilities2.add(new DivineShield());

        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6, abilities1);
        MinionCard minion2 = new MinionCard("Minion1", 3, 4, 3, abilities2);
        minion1.play();
        minion2.play();

        minion1.attack(minion2);
        System.out.println(minion1.health + " " + minion2.health);

    }

}