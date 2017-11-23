package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.cards.MinionCard;

public class MirrorImage implements Ability {

    @Override
    public void effect() {

        Engine.getActivePlayer().getBoard().summonMinion
                (new MinionCard("Mirror Image", 0, 0, 2));
        Engine.getActivePlayer().getBoard().summonMinion
                (new MinionCard("Mirror Image", 0, 0, 2));

    }

    @Override
    public String getAbilityType() {
        return "MirrorImage";
    }
}
