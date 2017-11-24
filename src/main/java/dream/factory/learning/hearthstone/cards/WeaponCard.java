package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.Player;
import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.abilities.keywords.Battlecry;
import dream.factory.learning.hearthstone.abilities.keywords.Windfury;

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
        Player player = Engine.getFriendlyPlayer();
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

    public Ability getAbility(String ability) {
        for (Ability abilityIterator : abilities) {
            if (abilityIterator.getAbilityType()
                    .equals(ability)) {
                return abilityIterator;
            }
        }

        return null;
    }

    @Override
    public void goToGraveyard() {
        if (this.getAbility("Deathrattle") != null) {
            this.getAbility("Deathrattle").effect();
        }

        Engine.getFriendlyPlayer().goToGraveyard(this);
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

    @Override
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
