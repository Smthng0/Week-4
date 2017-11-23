package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.cards.MinionCard;

public class Silence implements Ability {

    @Override
    public void effect() {
        if (Engine.getAttackTarget() instanceof MinionCard){
            ((MinionCard)(Engine.getAttackTarget())).suppressAbility();
        } else {
            System.out.println("Invalid target!");
        }
    }

    @Override
    public String getAbilityType() {
        return "Silence";
    }

}
