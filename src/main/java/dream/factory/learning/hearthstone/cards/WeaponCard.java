package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.Board;
import dream.factory.learning.hearthstone.Player;
import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.abilities.Battlecry;
import dream.factory.learning.hearthstone.abilities.Deathrattle;
import dream.factory.learning.hearthstone.abilities.Windfury;

import java.util.ArrayList;
import java.util.List;

public class WeaponCard implements HearthstoneCard {
    private String title;
    private int manaCost;
    private int attack;
    private int durability;
    private List<Ability> abilities;

    public WeaponCard(String title, int manaCost, int attack, int durability){
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.durability = durability;
        this.abilities = new ArrayList<>();
    }

    public WeaponCard(String title, int manaCost, int attack, int durability, List<Ability> abilities){
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.durability = durability;
        this.abilities = abilities;
    }

    @Override
    public void play() {
        Player player = Board.getActivePlayer();
        player.setWeapon(this);
        player.setAttack(this.attack);
        player.setMaxAttacks(1);

        for (Ability ability : abilities) {
            if (ability instanceof Battlecry){
                ability.effect();
            } else if (ability instanceof Windfury){
                ability.effect();
                player.setMaxAttacks(2);
            }
        }

        player.setRemainingAttacks(player.getMaxAttacks());
    }

    @Override
    public void removeFromPlay(){
        this.goToGraveyard();

        for (Ability ability : abilities) {
            if (ability instanceof Deathrattle){
                ability.effect();
            }
        }

    }

    @Override
    public boolean hasAbility() {
        return abilities.size() > 0;
    }

    @Override
    public void addAbility(Ability ability){
        this.abilities.add(ability);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }


}
