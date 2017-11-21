package dream.factory.learning.hearthstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    int remainingCards = 30;
    int dmgCounter = 0;
    HearthstoneCard noCards = null;
    List<HearthstoneCard> deck = new ArrayList<>();


    public Deck (List<HearthstoneCard> list) throws IllegalArgumentException {
        if (list.size() != 30){
            throw new IllegalArgumentException("Deck must have 30 cards");
        }

        deck.addAll(list);
        Collections.shuffle(deck);
    }

    public HearthstoneCard drawCard() {
        if (remainingCards == 0){
            dmgCounter += 1;
            return noCards;
        }

        remainingCards--;
        return deck.remove(0);
    }

    public HearthstoneCard removeTargetCard(HearthstoneCard card) {
        if ((remainingCards == 0)
                || (!deck.contains(card))) {
            return noCards;
        }

        remainingCards--;
        return deck.remove(deck.indexOf(card));
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }


    public boolean searchCard(HearthstoneCard card) {
        return deck.contains(card);
    }


}
