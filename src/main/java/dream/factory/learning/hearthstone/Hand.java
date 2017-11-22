package dream.factory.learning.hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    int numberOfCards = 0;
    int limit = 7;
    HearthstoneCard noCard = null;
    List<HearthstoneCard> hand = new ArrayList<>(limit);
    Deck deck = null;

    public Hand (Deck deck, boolean playsFirst){
        hand = null;
        this.deck = deck;

        for (int i = 0; i < 3; i++) {
            this.drawCard();
        }

        if (!playsFirst){
            this.addCard(new SpellCard("Mana Crystal", 0, null));
        }

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
        if (noMoreCards()){
            System.out.println("No more cards!");
        } else if (hand.remove(card)){
            numberOfCards--;
            card.goToGraveyard();
        }
    }

    public void discardCard(int index) {
        if (noMoreCards()){
            System.out.println("No more cards!");
        } else {
            numberOfCards--;
            (hand.remove(index)).goToGraveyard();
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

    public boolean noMoreCards(){
        return this.numberOfCards == 0;
    }
}
