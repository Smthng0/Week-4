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
    public void create_minion_OK() {
        List<Ability> ability = new ArrayList<>();
        MinionCard minion = new MinionCard("Minion1", 8, 17, 4);
        MinionCard minionWithAbility = new MinionCard("Minion1", 8, 5, 8, ability);

        assertTrue((minion.title.equals("Minion1"))
                &&(minion.manaCost == 8)
                &&(minion.attack == 17)
                &&(minion.health == 4)
                &&(!minion.hasAbilities)
                &&(minion.abilities == null));
        assertTrue((minionWithAbility.health == 8)
                &&(minionWithAbility.hasAbilities)
                &&(minionWithAbility.abilities != null));
    }

    @Test
    public void attack_sequence_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 4, 3);
        minion1.play();
        minion2.play();

        minion1.remainingAttacks = minion1.maxAttacks;
        minion1.attack(minion2);

        assertTrue(minion1.health == 2);
        assertTrue(minion2.health == 1);
    }

    @Test
    public void Windfury_attack_sequence_OK () {
        List<Ability> ability = new ArrayList<>();
        ability.add(new Windfury());

        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6, ability);
        MinionCard minion2 = new MinionCard("Minion2", 3, 2, 3);
        minion1.play();
        minion2.play();

        minion1.remainingAttacks = minion1.maxAttacks;
        minion1.attack(minion2);

        assertTrue(minion1.health == 2);
        assertTrue(minion2.health == -1);

    }

    @Test
    public void DivineShield_attack_sequence_OK () {
        List<Ability> ability = new ArrayList<>();
        ability.add(new DivineShield());

        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3, ability);
        minion1.play();
        minion2.play();

        minion1.remainingAttacks = minion1.maxAttacks;
        minion1.attack(minion2);

        assertTrue(minion1.health == 3);
        assertTrue(minion2.health == 3);
    }

    @Test
    public void Charge_attack_sequence_OK () {
        List<Ability> ability = new ArrayList<>();
        ability.add(new Charge());

        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6, ability);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3);
        minion1.play();
        minion2.play();

        minion1.attack(minion2);

        assertTrue(minion1.health == 3);
        assertTrue(minion2.health == -1);
    }

}