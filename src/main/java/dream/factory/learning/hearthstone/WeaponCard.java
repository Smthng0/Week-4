package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.Battlecry;
import dream.factory.learning.hearthstone.abilities.Windfury;

import java.util.List;

public class WeaponCard extends AbstractWeaponCard {

    public WeaponCard (String title, int manaCost, int attack, int durability, List<Ability> abilities){
        super();
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.durability = durability;
        this.abilities = abilities;
    }

    @Override
    public void play() {
        Player player = Board.getActivePlayer();
        player.weapon = this;
        player.attack = this.attack;
        player.maxAttacks = 1;
        player.hasWeapon = true;

        for (Ability ability : abilities) {
            if (ability instanceof Battlecry){
                ability.effect();
            } else if (ability instanceof Windfury){
                ability.effect();
                player.maxAttacks = 2;
            }
        }

        player.remainingAttacks = player.maxAttacks;

    }

}
