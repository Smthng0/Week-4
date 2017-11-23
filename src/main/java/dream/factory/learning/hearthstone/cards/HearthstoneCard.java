package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.abilities.Ability;

public interface HearthstoneCard {

    void play();

    //this will maybe be in the engine/board
    default HearthstoneCard goToGraveyard(){
        System.out.println("NYI goToGraveyard");
        return this;
    }

    boolean hasAbility();

    void addAbility(Ability ability);

    void removeFromPlay();

    String getTitle();

}
