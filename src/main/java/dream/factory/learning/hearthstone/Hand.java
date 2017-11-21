package dream.factory.learning.hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    int numberOfCards = 0;
    int limit = 7;
    HearthstoneCard noCard = null;
    List<HearthstoneCard> hand = new ArrayList<>(limit);

    public Hand (Deck deck, int ) {
        hand = null;
        for (int i = 0; i < 3; i++) {
            hand.add(deck.drawCard());
            numberOfCards++;
        }
    }

    public HearthstoneCard drawCard(HearthstoneCard card) {
        if (numberOfCards < limit){
            numberOfCards++;
            hand.add(card);
            return card;
        } else {
            card.goToGraveyard();
            return noCard;
        }
    }

    public HearthstoneCard discardCard(HearthstoneCard card) {
        if (numberOfCards == 0){
            return noCards;
        } else {
            return card.goToGraveyard();
        }
    }

    public HearthstoneCard playCard(HearthstoneCard card) {
        card.play();
        return card.goToGraveyard();
    }

    public HearthstoneCard returnToHand(HearthstoneCard card) {
        return this.drawCard(card);
    }
}
