package dream.factory.learning.hearthstone;

public interface Attackable {

    void takeDamage(int damage);

    int getAttack();

    boolean isDead();

    void attack(Attackable target);

    void defend(Attackable target);
}
