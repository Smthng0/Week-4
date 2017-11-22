package dream.factory.learning.hearthstone;

import java.util.List;

public class MinionCard extends AbstractMinionCard {

    public MinionCard (String title, int manaCost, int attack, int health, List<Ability> abilities){
        super();
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.abilities = abilities;
    }

}
