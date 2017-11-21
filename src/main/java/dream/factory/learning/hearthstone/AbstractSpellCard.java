package dream.factory.learning.hearthstone;

import java.util.List;

public abstract class AbstractSpellCard implements HearthstoneCard {
    String title;
    int manaCost;
    List<Ability> abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();
    }
}
