package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;
import dream.factory.learning.hearthstone.cards.SpellCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int numberOfCards = 0;
    private int limit = 10;
    private List<HearthstoneCard> backingHand = new ArrayList<>(limit);
    private Deck deck = null;
    private Board board = null;

    public Hand (Deck deck, boolean playsFirst, Board board){
        backingHand = null;
        this.deck = deck;
        this.board = board;

        for (int i = 0; i < 3; i++) {
            this.drawCard();
        }

        if (!playsFirst){
            this.addCard(new SpellCard("The Coin", 0, null));
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
            board.addToGraveyard(card);
        } else {
            System.out.println("Doesn't have that card!");
        }
    }

    public void discardCard(int index) {
        if (hasCards()){
            numberOfCards--;
            board.addToGraveyard(backingHand.remove(index));
        } else {
            System.out.println("No more cards!");
        }
    }

    public void playCard(HearthstoneCard card) {
        if (card instanceof MinionCard){
            board.summonMinion((MinionCard)card);
        }

        card.play();
        backingHand.remove(card);
        numberOfCards--;
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

    public int getLimit() {
        return limit;
    }
}
