package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private int remainingCards = 30;
    private int dmgCounter = 0;
    private List<HearthstoneCard> backingDeck = new ArrayList<>();


    public Deck (List<HearthstoneCard> list) throws IllegalArgumentException {
        if (list.size() != 30){
            throw new IllegalArgumentException("Deck must have 30 cards");
        }

        backingDeck.addAll(list);
        Collections.shuffle(backingDeck);
    }

    public HearthstoneCard drawCard() {
        if (remainingCards == 0){
            dmgCounter += 1;
            return null;
        }

        remainingCards--;

        return backingDeck.remove(0);
    }

    public boolean removeTargetCard(HearthstoneCard card) {
        if ((remainingCards == 0)
                || (!backingDeck.contains(card))) {
            return false;
        }

        backingDeck.remove(backingDeck.indexOf(card));
        remainingCards--;
        return true;
    }

    public boolean searchCard(String title) {
        for (HearthstoneCard card : backingDeck) {
            if (card.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }

    public boolean searchCard(HearthstoneCard targetCard) {
        for (HearthstoneCard card : backingDeck) {
            if (card.getTitle().equals(targetCard.getTitle())) {
                return true;
            }
        }

        return false;
    }

    public void shuffleDeck() {
        Collections.shuffle(backingDeck);
    }

    public int getRemainingCards() {
        return remainingCards;
    }

    public int getDmgCounter() {
        return dmgCounter;
    }

    public List<HearthstoneCard> getBackingDeck() {
        return backingDeck;
    }
}
