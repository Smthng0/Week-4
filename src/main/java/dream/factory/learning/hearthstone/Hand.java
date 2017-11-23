package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.SpellCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int numberOfCards = 0;
    private int limit = 7;
    private List<HearthstoneCard> backingHand = new ArrayList<>(limit);
    private Deck deck = null;

    public Hand (Deck deck, boolean playsFirst){
        backingHand = null;
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
        backingHand.add(deck.drawCard());
    }

    public void addCard(HearthstoneCard card) {
        backingHand.add(card);
        numberOfCards++;
    }

    public void discardCard(HearthstoneCard card) {
        if (hasCards()
                &&backingHand.remove(card)){
            numberOfCards--;
            card.goToGraveyard();
        } else {
            System.out.println("Doesn't have that card!");
        }
    }

    public void discardCard(int index) {
        if (hasCards()){
            numberOfCards--;
            (backingHand.remove(index)).goToGraveyard();
        } else {
            System.out.println("No more cards!");
        }
    }

    public void playCard(HearthstoneCard card) {
        card.play();
        backingHand.remove(card);
        numberOfCards--;
    }

    public void returnToHand(HearthstoneCard card) {
        backingHand.add(card);
        numberOfCards++;
        card.removeFromPlay();
    }

    public boolean hasCards(){
        return this.numberOfCards > 0;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public List<HearthstoneCard> getBackingHand() {
        return backingHand;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
