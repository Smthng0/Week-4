package dream.factory.learning.hearthstone.cards;

import dream.factory.learning.hearthstone.Attackable;
import dream.factory.learning.hearthstone.Engine;
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
    private List<Ability> temporaryAbilities;
    private List<Ability> originalAbilities;

    public MinionCard(String title, int manaCost, int attack, int health){
        this.title = title;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.originalAbilities = new ArrayList<>();
        this.temporaryAbilities = new ArrayList<>();
    }

    public MinionCard(String title, int manaCost, int attack, int health, List<Ability> abilities){
        this (title, manaCost, attack, health);
        this.originalAbilities = abilities;
        temporaryAbilities.addAll(originalAbilities);
    }

    @Override
    public void play() {
        temporaryAbilities.clear();
        temporaryAbilities.addAll(originalAbilities);
        maxAttacks = 1;
        remainingAttacks = 0;
    }

    @Override
    public void attack(Attackable target) {
        if (target == null) {
            System.out.println("No target!");
        } else {
            sortAbilitiesReverse();

            if (getAbility("Windfury") != null){
                maxAttacks = 2;
            }

            if (getAbility("Charge") != null){
                remainingAttacks = maxAttacks;
            }

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

        if ((getAbility("DivineShield") != null)
            && !((DivineShield)(getAbility("DivineShield")))
                .isUsedUp()) {
            getAbility("DivineShield").effect();
            this.health = tempHealth;
        }

        if (this.isDead()){
            this.removeFromPlay();
        }
    }

    public Ability getAbility(Ability ability) {
        for (Ability abilityIterator : temporaryAbilities) {
            if (abilityIterator.getAbilityType()
                    .equals(ability.getAbilityType())) {
                return abilityIterator;
            }
        }

        return null;
    }

    public Ability getAbility(String ability) {
        for (Ability abilityIterator : temporaryAbilities) {
            if (abilityIterator.getAbilityType()
                    .equals(ability)) {
                return abilityIterator;
            }
        }

        return null;
    }

    @Override
    public void addAbility(Ability ability) {
        this.temporaryAbilities.add(ability);
    }

    public void sortAbilitiesReverse() {
        temporaryAbilities.sort(Comparator.comparing(Ability::getAbilityType));
        Collections.reverse(temporaryAbilities);
    }

    public void suppressAbility(){
        this.temporaryAbilities.clear();
    }

    @Override
    public boolean hasAbility() {
        return temporaryAbilities.size() > 0;
    }

    @Override
    public boolean isDead(){
        return this.health <= 0;
    }

    @Override
    public void goToGraveyard() {
        if (this.getAbility("Deathrattle") != null) {
            this.getAbility("Deathrattle").effect();
        }

        System.out.println("Go to this players graveyard");
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
        return temporaryAbilities;
    }
}
