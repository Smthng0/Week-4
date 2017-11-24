package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.MinionCard;

public class Engine {
    private static Player activePlayer;
    private static Player passivePlayer;

    public static void startTurn() {
        activePlayer.setManaPool(activePlayer.getManaPool()+1);
        activePlayer.setRemainingMana(activePlayer.getManaPool());
        activePlayer.setRemainingAttacks(activePlayer.getMaxAttacks());

        for (MinionCard minion : activePlayer.getBoard().getAllMinions()) {
            minion.setRemainingAttacks(minion.getMaxAttacks());
        }
    }

    public static void endTurn() {
        if (activePlayer.fullHand()) {
            while (activePlayer.getNumberOfCards()
                    > activePlayer.getCardLimit()) {
                activePlayer.discardCard(0);
            }
        }

        Player tempPlayer = activePlayer;
        activePlayer = passivePlayer;
        passivePlayer = tempPlayer;
    }

    public static Attackable getEnemyMinion() {
        for (MinionCard minion : passivePlayer.getBoard().getAllMinions()) {
            if (minion.getAbility("Taunt") != null) {
                return minion;
            }
        }

        return passivePlayer.getBoard().getAnyMinion();
    }

    public static Attackable getFriendlyMinion() {
        for (MinionCard minion : activePlayer.getBoard().getAllMinions()) {
            if (minion.getAbility("Taunt") != null) {
                return minion;
            }
        }

        return activePlayer.getBoard().getAnyMinion();
    }

    //board temporarely has everything static (need engine to do something)

    public static Player getFriendlyPlayer() {
        return activePlayer;
    }

    public static Player getEnemyPlayer() {
        return passivePlayer;
    }

}
