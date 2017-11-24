package dream.factory.learning.hearthstone.cards.spells;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.cards.MinionCard;
import dream.factory.learning.hearthstone.cards.SpellCard;

import java.util.ArrayList;
import java.util.List;

public class MirrorImageSpellCard extends SpellCard {

    public MirrorImageSpellCard() {
        super("Mirror Image", 1, new ArrayList<>());

        this.addAbility(new Ability() {
            @Override
            public void effect() {
                //need to add taunt
                Engine.getActivePlayer().getBoard().summonMinion
                        (new MinionCard("Mirror Image", 0, 0, 2));
                Engine.getActivePlayer().getBoard().summonMinion
                        (new MinionCard("Mirror Image", 0, 0, 2));
            }

            @Override
            public String getAbilityType() {
                return "MirrorImageSpellCard";
            }
        });
    }

}
