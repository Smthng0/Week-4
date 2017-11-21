package dream.factory.learning.hearthstone;

import java.util.List;

public class AbstractHeroCard {
    String title;
    int manaCost;
    int armor;
    List abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

}
