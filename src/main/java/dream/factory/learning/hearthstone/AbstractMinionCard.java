package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.Battlecry;
import dream.factory.learning.hearthstone.abilities.Charge;
import dream.factory.learning.hearthstone.abilities.Deathrattle;
import dream.factory.learning.hearthstone.abilities.DivineShield;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMinionCard implements HearthstoneCard, Targetable {
    String title;
    int manaCost;
    int attack;
    int health;
    int numberOfAttacks;
    List<Ability> abilities = new ArrayList<>();

    @Override
    public int play() {
        numberOfAttacks = 0;

        for (Ability ability : abilities) {
            if (ability instanceof Charge){
                ability.effect();
                numberOfAttacks = 1;
            } else if (ability instanceof Battlecry){
                ability.effect();
            }
        }

        return manaCost;
    }

    public void attack(AbstractMinionCard target) {
        int tempHealth = this.health;

        if (target == null) {
            System.out.println("Wrong target!");
            return;
        }

        target.health = target.health - this.attack;
        this.health = this.health - target.attack;

        //Divine shield ability (takes no damage and removes divine shield)
        for (Ability ability : abilities) {
            if (ability instanceof DivineShield){
                ability.effect();
                abilities.remove(ability);
                this.health = tempHealth;
                break;
            }
        }

        numberOfAttacks--;

        if (this.isDead()) {
            this.removeFromPlay();
        }

        if (target.isDead()) {
            target.removeFromPlay();
        }
    }

    public void attack(Player target) {
        int modifiedAttack = this.attack;

        if (target.armor < this.attack) {
            modifiedAttack -= target.armor;
            target.armor = 0;
        } else if (target.armor >= this.attack){
            target.armor -= this.attack;
            modifiedAttack = 0;
        }

        target.health -= modifiedAttack;

        if (target.isDead()) {
            System.out.println("I won!!!");
            //need to make some victory stuff here
        }

        if (target.hasWeapon){
            this.health -= target.attack;

            if (this.isDead()) {
                this.removeFromPlay();
            }
        }

    }

    public boolean isDead(){
        return (this.health <= 0);
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();

        for (Ability ability : abilities) {
            if (ability instanceof Deathrattle){
                ability.effect();
                break;
            }
        }

    }

}
