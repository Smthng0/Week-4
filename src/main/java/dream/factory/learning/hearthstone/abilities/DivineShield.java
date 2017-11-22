package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Ability;

public class DivineShield implements Ability {
    String trigger = "On attack";
    public boolean usedUp = false;

    @Override
    public void effect(){
        usedUp = true;
    }
}
