package dream.factory.learning.hearthstone;

import java.util.List;

public abstract class AbstractWeaponCard implements HearthstoneCard {
    String title;
    int manaCost;
    int attack;
    int durability;
    List<Ability> abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

}
