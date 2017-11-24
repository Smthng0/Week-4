package dream.factory.learning.hearthstone.cards.spells;

import dream.factory.learning.hearthstone.abilities.effects.Silence;
import dream.factory.learning.hearthstone.cards.SpellCard;

import java.util.ArrayList;


public class SilenceSpellCard extends SpellCard {

    public SilenceSpellCard() {
        super("Silence", 0, new ArrayList<>());
        this.addAbility(new Silence() {});
    }

}
