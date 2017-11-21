package dream.factory.learning.hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    int numberOfCards = 0;
    int limit = 7;
    HearthstoneCard noCard = null;
    List<HearthstoneCard> hand = new ArrayList<>(limit);
    Deck deck = null;

    public Hand (Deck deck) {
        hand = null;
        for (int i = 0; i < 3; i++) {
            hand.add(deck.drawCard());
            numberOfCards++;
        }
        this.deck = deck;
    }

    public Hand (Deck deck, boolean playsSecond){
        this(deck);
        hand.add(new SpellCard("Mana Crystal", 0, null));
    }

    public void drawCard() {
        numberOfCards++;
        hand.add(deck.drawCard());
    }

    public void addCard(HearthstoneCard card) {
        hand.add(card);
        numberOfCards++;
    }

    public void discardCard(HearthstoneCard card) {
        if (numberOfCards == 0){
            System.out.println("No more cards!");
        } else {
            numberOfCards--;
            hand.remove(card);
            card.goToGraveyard();
        }
    }

    public void playCard(HearthstoneCard card) {
        card.play();
        hand.remove(card);
        numberOfCards--;
    }

    public void returnToHand(HearthstoneCard card) {
        hand.add(card);
        numberOfCards++;
        card.removeFromPlay();
    }
}
