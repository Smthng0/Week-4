package dream.factory.learning.hearthstone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void create_deck_OK() {
        List<HearthstoneCard> arrayDeck = new ArrayList<>();
        Random random = new Random ();

        for (int i = 0; i < 30; i++) {
            arrayDeck.add(
                    new MinionCard(("Minion"+(i+1)),
                            random.nextInt(9),
                            random.nextInt(10),
                            random.nextInt(10)
                    )
            );
        }

        Deck deck = new Deck (arrayDeck);

        assertTrue(arrayDeck.size() == 30);
        assertTrue(deck.remainingCards == 30);
    }

    @Test
    public void drawCard_OK() {
        List<HearthstoneCard> arrayDeck = new ArrayList<>();
        Random random = new Random ();

        for (int i = 0; i < 30; i++) {
            arrayDeck.add(
                    new MinionCard(("Minion"+(i+1)),
                            random.nextInt(9),
                            random.nextInt(10),
                            random.nextInt(10)
                    )
            );
        }

        Deck deck = new Deck (arrayDeck);

        deck.drawCard();
        assertTrue(deck.remainingCards == 29);
        deck.drawCard();
        assertTrue(deck.remainingCards == 28);
        assertTrue(deck.remainingCards == deck.deck.size());

        for (int i = 0; i < 30; i++) {
            deck.drawCard();
        }

        assertTrue(deck.remainingCards == 0);
        assertTrue(deck.dmgCounter == 2);

    }

    @Test
    public void searchDeck_OK() {
        List<HearthstoneCard> arrayDeck = new ArrayList<>();
        Random random = new Random ();

        for (int i = 0; i < 30; i++) {
            arrayDeck.add(
                    new MinionCard(("Minion"+(i+1)),
                            random.nextInt(9),
                            random.nextInt(10),
                            random.nextInt(10)
                    )
            );
        }

        Deck deck = new Deck (arrayDeck);

        assertTrue(deck.searchCard("Minion29"));
        assertTrue(deck.searchCard("Minion1"));
        assertTrue(deck.searchCard("Minion14"));

    }

}