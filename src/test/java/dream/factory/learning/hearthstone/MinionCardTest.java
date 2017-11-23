package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.*;
import dream.factory.learning.hearthstone.cards.MinionCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinionCardTest {

    @Test
    public void create_minion_OK() {
        List<Ability> ability = new ArrayList<>();
        ability.add(new Deathrattle());
        MinionCard minion = new MinionCard("Minion1", 8, 17, 4);
        MinionCard minionWithAbility = new MinionCard("Minion1", 8, 5, 8, ability);

        assertTrue((minion.getTitle().equals("Minion1"))
                &&(minion.getManaCost() == 8)
                &&(minion.getAttack() == 17)
                &&(minion.getHealth() == 4)
                &&(minion.getAbilities().size() == 0));
        assertTrue((minionWithAbility.getHealth() == 8)
                &&(minionWithAbility.getAbilities().size() > 0));
    }

    @Test
    public void attack_sequence_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 4, 3);
        minion1.play();
        minion2.play();

        minion1.setRemainingAttacks(minion1.getMaxAttacks());
        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 2);
        assertTrue(minion2.getHealth() == 1);
    }

    @Test
    public void Windfury_attack_sequence_OK () {
        List<Ability> ability = new ArrayList<>();
        ability.add(new Windfury());

        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6, ability);
        MinionCard minion2 = new MinionCard("Minion2", 3, 2, 3);
        minion1.play();
        minion2.play();

        minion1.setRemainingAttacks(minion1.getMaxAttacks());
        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 2);
        assertTrue(minion2.getHealth() == -1);

    }

    @Test
    public void DivineShield_attack_sequence_OK () {
        List<Ability> ability = new ArrayList<>();
        ability.add(new DivineShield());

        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3, ability);
        minion1.play();
        minion2.play();

        minion1.setRemainingAttacks(minion1.getMaxAttacks());
        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 3);
        assertTrue(minion2.getHealth() == 3);
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

        assertTrue(minion1.getHealth() == 3);
        assertTrue(minion2.getHealth() == -1);
    }


}