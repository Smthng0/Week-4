package dream.factory.learning.hearthstone;

import java.util.ArrayList;

public class Board {
    static Player activePlayer;
    static Player passivePlayer;

    public static Player getActivePlayer() {
        return activePlayer;
    }

    public static void endTurn() {
        Player tempPlayer = activePlayer;
        activePlayer = passivePlayer;
        passivePlayer = tempPlayer;
        if (tempPlayer.hand.numberOfCards > tempPlayer.hand.limit) {
            tempPlayer.hand.discardCard(0);
        }
    }

    public static void startTurn() {
        activePlayer.manaPool += 1;
        activePlayer.remainingAttacks = activePlayer.maxAttacks;
    }

    public static Attackable getTarget() {
        //placeholder for getTarget
        return new Player("Vice", new Deck(new ArrayList<HearthstoneCard>()), false);
    }

    //board temporarely has everything static (need engine to do something)
}
