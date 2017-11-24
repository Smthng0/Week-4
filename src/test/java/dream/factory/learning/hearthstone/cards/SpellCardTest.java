package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.abilities.keywords.Battlecry;
import dream.factory.learning.hearthstone.abilities.keywords.Windfury;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpellCardTest {

    @Test
    public void create_spell_OK() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Windfury());
        SpellCard spellCard1 = new SpellCard("The Coin", 0, null);
        SpellCard spellCard2 = new SpellCard("The Coin", 1, abilities);

        assertTrue((spellCard1.getTitle().equals("The Coin"))
                &&(spellCard1.getManaCost() == 0)
                &&(spellCard1.getAbilities().size() == 0)
                &&(!spellCard1.hasAbility()));
        assertTrue((spellCard2.getManaCost() == 1)
                &&(spellCard2.hasAbility()));
    }

    @Test
    public void play() {
        //gona test when engine is done
    }

    @Test
    public void addAbility() {
        SpellCard spellCard = new SpellCard("The Coin", 0, null);

        assertFalse(spellCard.hasAbility());

        spellCard.addAbility(new Battlecry());

        assertTrue(spellCard.hasAbility());

    }

}