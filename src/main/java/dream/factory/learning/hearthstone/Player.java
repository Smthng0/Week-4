package dream.factory.learning.hearthstone;

public class Player implements Targetable {
    int armor = 0;
    int health = 30;
    public int manaPool = 0;
    boolean hasWeapon = false;
    int attack = 0;

    Deck deck = null;
    Hand hand = null;

    public Player(Deck deck) {
        this.deck = deck;
        this.hand = new Hand(deck);
    }

    public Player(Deck deck, boolean playsSecond) {
        this.deck = deck;
        this.hand = new Hand(deck, playsSecond);
    }

    public boolean isDead() {
        return (this.health <= 0);
    }
}
