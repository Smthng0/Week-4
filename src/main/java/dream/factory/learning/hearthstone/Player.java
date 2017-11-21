package dream.factory.learning.hearthstone;

public class Player {
    int armor = 0;
    int health = 30;
    public int manaPool = 0;

    public void isDead() {
        System.out.println("Game is over! Somebody won!");
    }
}
