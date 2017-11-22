package dream.factory.learning.hearthstone;

import java.util.List;

public abstract class AbstractHeroCard implements HearthstoneCard {
    String title;
    int manaCost;
    int armor;
    List<Ability> abilities;

    @Override
    public void play() {
        //do ability
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();
    }

}
