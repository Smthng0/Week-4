package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Ability;

public class DivineShield implements Ability {
    public boolean usedUp = false;

    @Override
    public void effect(){
        usedUp = true;
    }
}
