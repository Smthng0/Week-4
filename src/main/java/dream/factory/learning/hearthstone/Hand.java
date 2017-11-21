package dream.factory.learning.hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    int numberOfCards = 0;
    int limit = 7;
    HearthstoneCard noCard = null;
    List<HearthstoneCard> hand = new ArrayList<>(limit);

    public Hand (List<HearthstoneCard> list) throws IllegalArgumentException {
        if ( (list.size() != 3) ^ (list.size() != 4) ){
            throw new IllegalArgumentException("Not a valid hand!");
        }

        hand.addAll(list);
    }

    public HearthstoneCard drawCard(HearthstoneCard card) {
        if (numberOfCards < limit){
            numberOfCards++;
            hand.add(card);
            return card;
        } else {
            card.discard();
            return noCard;
        }
    }

    public HearthstoneCard discard(HearthstoneCard card) {
        if (numberOfCards == 0){
            return noCard;
        } else {
            return card.discard();
        }
    }

    public HearthstoneCard play(HearthstoneCard card) {
        card.play();
        return card.discard();
    }

    public HearthstoneCard returnToHand(HearthstoneCard card) {
        return this.drawCard(card);
    }
}
