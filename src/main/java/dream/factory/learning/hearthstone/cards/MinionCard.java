package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.Attackable;
import dream.factory.learning.hearthstone.abilities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinionCard implements HearthstoneCard, Attackable {
    private String title;
    private int manaCost;
    private int attack;
    private int health;
    private int maxAttacks;
    private int remainingAttacks;
    private List<Ability> abilities;

    public MinionCard(String title, int manaCost, int attack, int health){
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.abilities = new ArrayList<>();
    }

    public MinionCard(String title, int manaCost, int attack, int health, List<Ability> abilities){
        this (title, manaCost, attack, health);
        this.abilities = abilities;
    }

    @Override
    public void play() {
        maxAttacks = 1;
        remainingAttacks = 0;
        sortAbilitiesReverse();

        for (Ability ability : this.abilities) {
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
                target.defend(this);

                if (target instanceof MinionCard) {
                    this.takeDamage(target.getAttack());
                }

                this.remainingAttacks--;
            }
        }
    }

    public void defend(Attackable target){
        this.takeDamage(target.getAttack());
    }


    @Override
    public void takeDamage(int damage){
        int tempHealth = this.health;
        this.health -= damage;

        for (Ability ability : abilities) {
            if (ability instanceof DivineShield){
                DivineShield dummy = (DivineShield)ability;
                if (!dummy.usedUp){
                    this.health = tempHealth;
                }
                ability.effect();
            }
        }

        //this will go to engine/board probably
        if (this.isDead()){
            this.removeFromPlay();
        }
    }

    public void suppressAbility(){
        this.abilities.clear();
    }

    @Override
    public boolean isDead(){
        return this.health <= 0;
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

    public void sortAbilitiesReverse() {
        abilities.sort(Comparator.comparing(Ability::getAbilityType));
        Collections.reverse(abilities);
    }

    @Override
    public boolean hasAbility() {
        return abilities.size() > 0;
    }

    @Override
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxAttacks() {
        return maxAttacks;
    }

    public void setMaxAttacks(int maxAttacks) {
        this.maxAttacks = maxAttacks;
    }

    public int getRemainingAttacks() {
        return remainingAttacks;
    }

    public void setRemainingAttacks(int remainingAttacks) {
        this.remainingAttacks = remainingAttacks;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
}
