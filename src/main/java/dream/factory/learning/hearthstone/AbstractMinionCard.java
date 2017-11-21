package dream.factory.learning.hearthstone;

import java.util.Collections;
import java.util.List;

public class AbstractMinionCard implements HearthstoneCard {
    String title;
    int manaCost;
    int attack;
    int health;
    int numberOfAttacks;
    List abilities;

    @Override
    public int play() {
        numberOfAttacks = 0;

        return manaCost;
    }

    public void attack(AbstractMinionCard target) {
        if (target == null) {
            System.out.println("Wrong target!");
            return;
        }

        target.health = target.health - this.attack;
        this.health = this.health - target.attack;
        numberOfAttacks--;

        if (this.health <= 0) {
            this.goToGraveyard();
        }

        if (target.health <= 0) {
            target.goToGraveyard();
        }
    }

    public void attack(Player target) {
        if (target.armor < this.attack) {
            this.attack -= target.armor;
            target.armor = 0;
        } else if (target.armor >= this.attack){
            target.armor -= this.attack;
            return;
        }

        target.health -= this.attack;

        if (target.health < 0) {
            target.isDead();
        }
    }
}
