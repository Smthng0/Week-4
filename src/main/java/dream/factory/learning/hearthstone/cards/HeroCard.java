package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.abilities.Ability;

import java.util.List;

public class HeroCard implements HearthstoneCard {
    private String title;
    private int manaCost;
    private int armor;
    private List<Ability> abilities;

    @Override
    public void play() {
        //do ability
    }

    @Override
    public HearthstoneCard goToGraveyard() {
        return null;
    }

    @Override
    public boolean hasAbility() {
        return abilities.size() > 0;
    }

    @Override
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public List<Ability> getAbilities() {
        return abilities;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
