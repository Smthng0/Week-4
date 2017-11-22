package dream.factory.learning.hearthstone;

import java.util.List;

public class MinionCard extends AbstractMinionCard {

    public MinionCard (String title, int manaCost, int attack, int health){
        super();
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.hasAbilities = false;
        this.abilities = null;
    }

    public MinionCard (String title, int manaCost, int attack, int health, List<Ability> abilities){
        this (title, manaCost, attack, health);
        this.abilities = abilities;
        this.hasAbilities = true;
    }

}
