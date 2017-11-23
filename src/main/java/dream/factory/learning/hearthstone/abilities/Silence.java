package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Board;
import dream.factory.learning.hearthstone.cards.MinionCard;

public class Silence implements Ability {

    @Override
    public void effect() {
        if (Board.getTarget() instanceof MinionCard){
            ((MinionCard)(Board.getTarget())).suppressAbility();
        } else {
            System.out.println("Invalid target!");
        }
    }

    @Override
    public String getAbilityType() {
        return "Silence";
    }

}
