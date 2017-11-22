package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Ability;
import dream.factory.learning.hearthstone.Board;

public class Silence implements Ability {

    @Override
    public void effect() {
        (Board.getTarget()).suppressAbility();
    }

}
