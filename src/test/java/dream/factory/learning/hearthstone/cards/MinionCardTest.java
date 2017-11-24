package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.abilities.*;
import dream.factory.learning.hearthstone.abilities.keywords.Charge;
import dream.factory.learning.hearthstone.abilities.keywords.Deathrattle;
import dream.factory.learning.hearthstone.abilities.keywords.DivineShield;
import dream.factory.learning.hearthstone.abilities.keywords.Windfury;
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
                &&(minionWithAbility.hasAbility()));
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
    public void Charge_addAbility_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3);
        minion1.play();
        minion2.play();
        minion1.addAbility(new Charge());

        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 3);
        assertTrue(minion2.getHealth() == -1);
    }

    @Test
    public void getAbility_Card_Title_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3);
        minion1.play();
        minion2.play();
        minion1.addAbility(new Charge());
        minion2.addAbility(new Deathrattle());

        assertTrue(minion1.getAbility(new Charge()) != null);
        assertTrue(minion2.getAbility("Deathrattle") != null);
        assertFalse(minion2.getAbility("DivineShield") != null);
    }

    @Test
    public void Windfury_Charge_sortAbility_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 2, 3);
        minion1.play();
        minion2.play();
        minion1.addAbility(new Windfury());
        minion1.addAbility(new Charge());

        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 2);
        assertTrue(minion2.getHealth() == -1);

    }

    @Test
    public void Charge_DivineShield_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 4, 6);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3);
        minion1.play();
        minion2.play();
        minion1.addAbility(new Charge());
        minion2.addAbility(new DivineShield());

        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == 3);
        assertTrue(minion2.getHealth() == 3);
    }

    @Test
    public void Charge_Windfury_DivineShield_OK() {
        MinionCard minion1 = new MinionCard("Minion1", 2, 2, 4);
        MinionCard minion2 = new MinionCard("Minion2", 3, 3, 3);
        minion1.play();
        minion2.play();
        minion1.addAbility(new Charge());
        minion1.addAbility(new Windfury());
        minion2.addAbility(new DivineShield());

        minion1.attack(minion2);

        assertTrue(minion1.getHealth() == -2);
        assertTrue(minion2.getHealth() == 1);
    }


}