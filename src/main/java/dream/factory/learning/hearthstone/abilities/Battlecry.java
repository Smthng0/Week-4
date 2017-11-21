package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Ability;

public abstract class Battlecry implements Ability {
    String trigger = "On play";

    @Override
    public void effect() {
    }
}
