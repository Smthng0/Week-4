package dream.factory.learning.hearthstone.abilities.effects;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.cards.MinionCard;
import dream.factory.learning.hearthstone.cards.SpellCard;

public interface Silence  extends Ability {

    @Override
    default void effect() {
        if (Engine.getAttackTarget() instanceof MinionCard){
            ((MinionCard)(Engine.getAttackTarget())).suppressAbility();
        } else {
            System.out.println("Invalid target!");
        }
    }

    @Override
    default String getAbilityType() {
        return "Silence";
    }

}
