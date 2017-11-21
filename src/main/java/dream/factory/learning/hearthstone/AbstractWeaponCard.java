package dream.factory.learning.hearthstone;

import java.util.List;

public class AbstractWeaponCard implements HearthstoneCard {
    String title;
    int manaCost;
    int attack;
    int durability;
    List abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

}
