package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.abilities.Ability;

public interface HearthstoneCard {

    void play();

    HearthstoneCard goToGraveyard();

    boolean hasAbility();

    void addAbility(Ability ability);

    default void removeFromPlay() {
        this.goToGraveyard();
    };

    String getTitle();

}
