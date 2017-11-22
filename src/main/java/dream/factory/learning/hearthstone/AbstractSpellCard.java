package dream.factory.learning.hearthstone;

import java.util.List;

public abstract class AbstractSpellCard implements HearthstoneCard {
    String title;
    int manaCost;
    List<Ability> abilities;

    @Override
    public void play() {
        //do ability
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
