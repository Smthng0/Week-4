package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMinionCard implements HearthstoneCard, Attackable {
    String title;
    int manaCost;
    int attack;
    int health;
    int maxAttacks;
    int remainingAttacks;
    List<Ability> abilities = new ArrayList<>();

    @Override
    public void play() {
        maxAttacks = 1;
        remainingAttacks = 0;

        for (Ability ability : abilities) {
            if (ability instanceof Windfury){
                ability.effect();
                maxAttacks = 2;
            } else if (ability instanceof Charge){
                ability.effect();
                remainingAttacks = maxAttacks;
            } else if (ability instanceof Battlecry){
                ability.effect();
            }
        }

    }

    @Override
    public void attack(Attackable target) {
        if (target == null) {
            System.out.println("No target!");
        } else {
            while (remainingAttacks > 0) {
                //the defend part will go to board/engine once it's implemented
                target.defend(this);

                if (target instanceof AbstractMinionCard) {
                    this.takeDamage(target.getAttack());
                }

                remainingAttacks--;
            }
        }
    }

    public void defend(Attackable target){
        this.takeDamage(target.getAttack());

        //this will go to engine/board probably
        if (this.isDead()){
            this.removeFromPlay();
        }
    }


    @Override
    public void takeDamage(int damage){
        int tempHealth = this.health;

        this.health -= damage;

        //Divine shield ability (takes no damage and removes divine shield)
        for (Ability ability : abilities) {
            if (ability instanceof DivineShield){
                ability.effect();
                abilities.remove(ability);
                this.health = tempHealth;
            }
        }
    }

    @Override
    public void suppressAbility(){
        this.abilities = null;
    }

    @Override
    public boolean isDead(){
        return this.health <= 0;
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();

        //this will probably be for board/engine
        for (Ability ability : abilities) {
            if (ability instanceof Deathrattle){
                ability.effect();
            }
        }

    }

    @Override
    public int getAttack() {
        return this.attack;
    }

}
