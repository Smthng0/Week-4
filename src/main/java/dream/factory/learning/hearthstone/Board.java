package dream.factory.learning.hearthstone;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int minionLimit = 7;
    private List<MinionCard> backingBoard = new ArrayList<>();
    private int numberOfMinions = 0;
    private List<HearthstoneCard> graveyard = new ArrayList<>();

    public void summonMinion(MinionCard card) {
        if (isFull()){
            System.out.println("Board is full");
        } else {
            backingBoard.add(card);
            numberOfMinions++;
        }
    }

    public HearthstoneCard addToGraveyard(HearthstoneCard card){
        graveyard.add(card);
        return card = null;
    }

    public MinionCard getAnyMinion(){
        if (isEmpty()) {
            return null;
        } else {
            return backingBoard.get(0);
        }
    }

    private boolean isFull() {
        return numberOfMinions == minionLimit;
    }

    private boolean isEmpty() {
        return numberOfMinions == 0;
    }

    public List<MinionCard> getBoard() {
        return backingBoard;
    }

    public int getNumberOfMinions() {
        return numberOfMinions;
    }

    public List<HearthstoneCard> getGraveyard() {
        return graveyard;
    }
}
