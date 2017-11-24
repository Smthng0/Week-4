package dream.factory.learning.hearthstone.cards.spells;

import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.abilities.effects.Silence;
import dream.factory.learning.hearthstone.cards.SpellCard;

import java.util.ArrayList;
import java.util.List;


public class SilenceSpellCard extends SpellCard {

    public SilenceSpellCard() {
        super("Silence", 0, new ArrayList<>());
        this.addAbility(new Silence());
    }

}
