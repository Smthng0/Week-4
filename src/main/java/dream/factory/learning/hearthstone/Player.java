package dream.factory.learning.hearthstone;

public class Player implements Attackable {
    String playerName;
    int attack = 0;
    int armor = 0;
    int maxAttacks = 0;
    int remainingAttacks = 0;
    int health = 30;
    int manaPool = 0;
    boolean hasWeapon = false;
    Ability classAbility = null;
    WeaponCard weapon = null;
    Deck deck;
    Hand hand;

    public Player(String name, Deck deck, boolean playsFirst) {
        this.playerName = name;
        this.deck = deck;
        this.hand = new Hand(deck, playsFirst);
    }

    @Override
    public void attack(Attackable target) {
        if (hasWeapon){

            if (target == null) {
                System.out.println("No target!");
            } else {
                while (remainingAttacks > 0) {

                    //the defend part will go to board/engine once it's implemented
                    target.defend(this);

                    if (target instanceof AbstractMinionCard) {
                        this.takeDamage(target.getAttack());
                    }

                    remainingAttacks--;
                    weapon.durability--;

                    if (weapon.durability == 0){
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

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public void suppressAbility(){
        this.weapon.abilities = null;
    }

    public void supressClassAbility(){
        this.classAbility = null;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

}
