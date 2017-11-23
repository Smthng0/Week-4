package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.MinionCard;

public class Board {
    private static Player activePlayer;
    private static Player passivePlayer;

    public static void endTurn() {
        Player tempPlayer = activePlayer;
        activePlayer = passivePlayer;
        passivePlayer = tempPlayer;
        if (tempPlayer.getHand().getNumberOfCards() > tempPlayer.getHand().getLimit()) {
            tempPlayer.getHand().discardCard(0);
        }
    }

    public static void startTurn() {
        activePlayer.setManaPool(activePlayer.getManaPool()+1);
        activePlayer.setRemainingMana(activePlayer.getManaPool());
        activePlayer.setRemainingAttacks(activePlayer.getMaxAttacks());
    }

    public static Attackable getTarget() {
        //placeholder for getTarget
        return new MinionCard("Minion", 2, 3, 4);
    }

    //board temporarely has everything static (need engine to do something)

    public static Player getActivePlayer() {
        return activePlayer;
    }

    public static Player getPassivePlayer() {
        return passivePlayer;
    }

}
