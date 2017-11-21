package dream.factory.learning.hearthstone;

public class AbstractMinionCard implements HearthstoneCard {
    String title;
    int manaCost;
    int attack;
    int health;
    String ability;

    //napraviti set sa key-evima "true" i "false"... i kad se napravi karta, u "true" idu oni koje posjeduje
    //mozda mogu klasu abilities napravit... :D popis svih ability-a i metodu "active/true/has ability"...
    //a mogu i napravit builder za minion koji dodaje ability-e i stavlja ih u tu mapu true... :D to je mozda bolje
}
