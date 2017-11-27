package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static Player activePlayer;
    private static Player passivePlayer;
    private static Player player1;
    private static Player player2;
    private static Scanner scanner = new Scanner(System.in);
    private static String command;
    private static int turnCounter;

    public static void main(String[] args) {
        createPlayers();
        do {
            startOfTurn();
            checkStatus();
            chooseAction();
        } while ((!command.equalsIgnoreCase("Exit game"))
                && (!command.equalsIgnoreCase("Exit")));
    }

    public static void createPlayers() {
        System.out.println("Enter first players minion names: ");
        Deck deck1 = createDeck();
        System.out.println("Enter first player name: ");
        player1 = new Player(scanner.nextLine(), deck1, true);

        System.out.println("Enter second players minion names: ");
        Deck deck2 = createDeck();
        System.out.println("Enter second player name: ");
        player2 = new Player(scanner.nextLine(), deck2, false);
        activePlayer = player1;
        passivePlayer = player2;
        System.out.println();

        System.out.println("****************************************");
        System.out.println("\\\\**..  " + player1.getPlayerName() + "  vs  " + player2.getPlayerName() + "  ..**//");
        separator();
        turnCounter = 2;
    }

    public static void startOfTurn() {
        System.out.println("It's " + activePlayer.getPlayerName() + "'s turn!");
        System.out.println("Turn number: " + (int)Math.ceil(turnCounter/2));
        startTurn();
        separator();
    }

    public static void availableActions(){
        System.out.println("Available actions: ");
        separator();
        System.out.print("Play card");
        System.out.print("  |  ");
        System.out.print("Attack");
        System.out.print("  |  ");
        System.out.print("Check status");
        System.out.print("  |  ");
        System.out.print("End turn");
        System.out.print("  |  ");
        System.out.println("Exit game");
        separator();
    }

    public static void chooseAction() {
        do {
            availableActions();

            command = scanner.nextLine();
            System.out.println();
            if ((command.equalsIgnoreCase("Play card"))
                    || (command.equalsIgnoreCase("Play"))
                    || (command.equalsIgnoreCase("card"))) {
                playCard();
            }

            if (command.equalsIgnoreCase("Attack")) {
                attack();
            }

            if ((command.equalsIgnoreCase("Check status"))
                    || (command.equalsIgnoreCase("status"))
                    || (command.equalsIgnoreCase("check"))) {
                checkStatus();
            }

        } while ((!command.equalsIgnoreCase("End turn"))
                && (!command.equalsIgnoreCase("End"))
                && (!command.equalsIgnoreCase("Exit"))
                && (!command.equalsIgnoreCase("Exit game")));

        endTurn();
    }

    public static void playCard() {
        System.out.println();
        System.out.println("Available cards:  ");
        activePlayer.viewHand();
        System.out.println("Available mana:  " + activePlayer.getRemainingMana());
        separator();
        command = scanner.nextLine();
        int index;
        try {
            index = Integer.parseInt(command);
        } catch (Exception ex) {
            return;
        }
        if (index < activePlayer.getNumberOfCards()
                && (index >= 0)) {
            command = activePlayer.getCard(index).getTitle();
            int mana = activePlayer.playCard(index);

            if (mana == -1){
                System.out.println("Card not played! (no such card or not enough mana) ");
            } else {
                if (command.equalsIgnoreCase("The Coin")) {
                    activePlayer.setRemainingMana(activePlayer.getRemainingMana() + 1);
                }

                activePlayer.setRemainingMana(activePlayer.getRemainingMana() - mana);
                System.out.println("Card " + command + " played successfully!");
                System.out.println(command + " costs " + mana + " mana.");
                System.out.println("Remaining mana: " + activePlayer.getRemainingMana());
            }

        } else {
            System.out.println("Card not played! (no such card or not enough mana) ");
        }

        System.out.println();
        separator();
    }

    public static void attack() {
        if (activePlayer.getBoard().getAllMinions() == null) {
            System.out.println();
            System.out.println("No minions! ");
            separator();
        } else {
            System.out.println("Choose Minion");
            separator();
            activePlayer.viewBoard();
            int index;
            command = scanner.nextLine();
            System.out.println();
            try {
                index = Integer.parseInt(command);
            } catch (Exception ex) {
                return;
            }
            if ((activePlayer.getBoard().getNumberOfMinions() > index)
                    && (index >= 0)) {
                if (activePlayer.getMinion(index).getRemainingAttacks() > 0) {
                    MinionCard attackingMinion = activePlayer.getMinion(index);
                    System.out.println("Available targets: ");
                    separator();
                    if (passivePlayer.getBoard().getNumberOfMinions() > 0){
                        System.out.println("Minions: ");
                        passivePlayer.viewBoard();
                    }
                    System.out.println("Player: ");
                    System.out.println((passivePlayer.getBoard().getNumberOfMinions())
                            + ".  " + passivePlayer.getPlayerName());

                    command = scanner.nextLine();
                    System.out.println();
                    try {
                        index = Integer.parseInt(command);
                    } catch (Exception ex) {
                        return;
                    }

                    if (passivePlayer.getMinion(index) != null) {
                        MinionCard defendingMinion = passivePlayer.getMinion(index);

                        System.out.println(attackingMinion.getTitle() + " did "
                                + attackingMinion.getAttack() + " damage to "
                                + defendingMinion.getTitle()
                                + "!  |  " + attackingMinion.getTitle()
                                + "'s remaining health: " + attackingMinion.getHealth());
                        System.out.println(defendingMinion.getTitle() + " did "
                                + defendingMinion.getAttack() + " damage to "
                                + attackingMinion.getTitle() + "!  |  "
                                + defendingMinion.getTitle()
                                + "'s remaining health: "
                                + defendingMinion.getHealth());

                        attackingMinion.attack(passivePlayer.getMinion(index));

                        if (defendingMinion.isDead()){
                            passivePlayer.goToGraveyard(defendingMinion);
                        }
                        if (attackingMinion.isDead()){
                            activePlayer.goToGraveyard(attackingMinion);
                        }
                    }

                    if (index == (passivePlayer.getBoard().getNumberOfMinions())) {
                        System.out.println(attackingMinion.getTitle() + " did "
                                + attackingMinion.getAttack()
                                + " damage to " + passivePlayer.getPlayerName() + "!");

                        attackingMinion.attack(passivePlayer);

                        if (passivePlayer.isDead()) {
                            System.out.println("");
                            System.out.println("Press Enter to exit");
                            scanner.nextLine();
                            command = "exit";
                        } else {
                            System.out.println(passivePlayer.getPlayerName()
                                    + "'s remaining health: " + passivePlayer.getHealth());
                        }
                    }

                } else {
                    System.out.println("Minion did not attack (no remaining attacks)...");
                }
                System.out.println();
            } else {
                System.out.println();
                System.out.println("No such minion!");
                separator();
            }

            System.out.println();
            separator();
        }
    }

    public static void checkStatus() {
        System.out.println("Player " + activePlayer.getPlayerName() + " status: ");
        separator();
        System.out.print("Your health: ");
        System.out.print(activePlayer.getHealth());
        System.out.print("  |  Your mana pool: ");
        System.out.print(activePlayer.getManaPool());
        System.out.print("  |  Your remaining mana: ");
        System.out.print(activePlayer.getRemainingMana());
        System.out.print("  |  Your hand size: ");
        System.out.print(activePlayer.getNumberOfCards());
        System.out.print("  |  Number of active minions: ");
        System.out.println(activePlayer.getBoard().getNumberOfMinions());
        System.out.print("Enemy health: ");
        System.out.print(passivePlayer.getHealth());
        System.out.print("  |  Enemy mana pool: ");
        System.out.print(passivePlayer.getManaPool());
        System.out.print("  |  Enemy hand size: ");
        System.out.print(passivePlayer.getNumberOfCards());
        System.out.print("  |  Number of active enemy minions: ");
        System.out.println(passivePlayer.getBoard().getNumberOfMinions());
        separator();
    }



    public static void startTurn() {
        activePlayer.setManaPool(activePlayer.getManaPool()+1);
        activePlayer.setRemainingMana(activePlayer.getManaPool());
        activePlayer.setRemainingAttacks(activePlayer.getMaxAttacks());
        HearthstoneCard card = activePlayer.drawCard();
        System.out.println(activePlayer.getPlayerName() + " drew "
                + card.getTitle() + " Mana cost: " + card.getManaCost());

        if (activePlayer.getBoard().getAllMinions() != null) {
            for (MinionCard minion : activePlayer.getBoard().getAllMinions()) {
                minion.setRemainingAttacks(minion.getMaxAttacks());
            }
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
        turnCounter++;
    }

    public static Attackable getEnemyMinion(String title) {
        for (MinionCard minion : passivePlayer.getBoard().getAllMinions()) {
            if (minion.getAbility("Taunt") != null) {
                return minion;
            }
        }

        return passivePlayer.getBoard().getMinion(title);
    }

    public static Attackable getFriendlyMinion(String title) {

        return activePlayer.getBoard().getMinion(title);
    }

    public static Player getFriendlyPlayer() {
        return activePlayer;
    }

    public static Player getEnemyPlayer() {
        return passivePlayer;
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    public static void separator() {
        System.out.println("----------------------------------------");
        System.out.println();
    }

    public static Deck createDeck(){
        List<HearthstoneCard> arrayDeck = new ArrayList<>();
        Random random = new Random ();
        String minionName = scanner.nextLine();

        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(5);
            int y = random.nextInt(4);
            arrayDeck.add(
                    new MinionCard((minionName+(i+1)),
                            x+y,
                            x+x+y,
                            x+y+y+1
                    )
            );
        }

        Deck deck = new Deck (arrayDeck);
        return deck;
    }



}
