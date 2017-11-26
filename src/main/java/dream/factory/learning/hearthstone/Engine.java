package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.MinionCard;

import java.util.Scanner;

public class Engine {
    private static Player activePlayer;
    private static Player passivePlayer;

    public static void main(String[] args) {
        Engine.availableActions();
    }

    public static void availableActions(){
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Available actions: ");
        System.out.print("Play card");
        System.out.print("  |  ");
        System.out.print("Attack");
        System.out.print("  |  ");
        System.out.println("End turn");

        do {
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("Play card")) {
                System.out.println("Choose card");

            }

            if (command.equalsIgnoreCase("Attack")) {
                System.out.println("Choose Attackable");
            }

        } while (!command.equalsIgnoreCase("End turn"));

    }

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

    public static Player getFriendlyPlayer() {
        return activePlayer;
    }

    public static Player getEnemyPlayer() {
        return passivePlayer;
    }

}
