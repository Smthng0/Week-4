package dream.factory.learning.hearthstone.abilities;

import dream.factory.learning.hearthstone.Ability;

public abstract class Deathrattle implements Ability {
    String trigger = "On death";

    @Override
    public void effect() {
    }
}
