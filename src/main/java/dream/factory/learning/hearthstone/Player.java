package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;
import dream.factory.learning.hearthstone.cards.WeaponCard;

public class Player implements Attackable {
    private String playerName;
    private int attack = 0;
    private int armor = 0;
    private int maxAttacks = 0;
    private int remainingAttacks = 0;
    private int health = 30;
    private int manaPool = 0;
    private int remainingMana = 0;
    private Ability classAbility = null;
    private WeaponCard weapon = null;
    private Deck deck;
    private Hand hand;
    private Board board;

    public Player(String name, Deck deck, boolean playsFirst) {
        this.playerName = name;
        this.deck = deck;
        this.board = new Board();
        this.hand = new Hand(deck, playsFirst, this.board);
    }

    @Override
    public void attack(Attackable target) {
        if (this.hasWeapon()){
            if (target == null) {
                System.out.println("No target!");
            } else {
                while (remainingAttacks > 0) {
                    target.defend(this);

                    if (target instanceof MinionCard) {
                        this.takeDamage(target.getAttack());
                    }

                    remainingAttacks--;
                    weapon.setDurability(weapon.getDurability()-1);

                    if (weapon.getDurability() == 0){
                        weapon.removeFromPlay();
                        weapon = null;
                        remainingAttacks = 0;
                        System.out.println("Weapon used up!");
                    }
                }
            }
        } else {
            System.out.println("No weapon!");
        }
    }

    @Override
    public void defend(Attackable target) {
        this.takeDamage(target.getAttack());

        if (this.isDead()){
            System.out.println("I won!!!");
            //need to make some victory stuff here
        }
    }

    @Override
    public void takeDamage(int damage){
        if (this.armor < damage) {
            damage -= this.armor;
            this.armor = 0;
            this.health -= damage;
        } else if (this.armor >= damage){
            this.armor -= damage;
        }
    }

    public void goToGraveyard(HearthstoneCard card){
        board.addToGraveyard(card);
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    public boolean hasWeapon() {
        return weapon != null;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getManaPool() {
        return manaPool;
    }

    public void setManaPool(int manaPool) {
        this.manaPool = manaPool;
    }

    public int getRemainingMana() {
        return remainingMana;
    }

    public void setRemainingMana(int remainingMana) {
        this.remainingMana = remainingMana;
    }

    public Ability getClassAbility() {
        return classAbility;
    }

    public void setClassAbility(Ability classAbility) {
        this.classAbility = classAbility;
    }

    public WeaponCard getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponCard weapon) {
        this.weapon = weapon;
    }

    public Hand getHand() {
        return hand;
    }

    public Board getBoard() {
        return this.board;
    }

}
