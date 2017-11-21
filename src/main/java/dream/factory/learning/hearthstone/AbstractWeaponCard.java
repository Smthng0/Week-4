package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.Deathrattle;

import java.util.List;

public abstract class AbstractWeaponCard implements HearthstoneCard, Targetable {
    String title;
    int manaCost;
    int attack;
    int durability;
    List<Ability> abilities;

    @Override
    public int play() {
        //do ability
        return manaCost;
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();

        for (Ability ability : abilities) {
            if (ability instanceof Deathrattle){
                ability.effect();
                return;
            }
        }

    }

}
