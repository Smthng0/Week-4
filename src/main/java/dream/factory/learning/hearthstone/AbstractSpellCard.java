package dream.factory.learning.hearthstone;

import java.util.List;

public class AbstractSpellCard implements HearthstoneCard {
    String title;
    int manaCost;
    List abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

    public int play(Object target) {
        //do stuff to target (ability)
        return manaCost;
    }

}
