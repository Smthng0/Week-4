package dream.factory.learning.hearthstone;

public interface HearthstoneCard {

    void play();

    //this will maybe be in the engine/board
    default HearthstoneCard goToGraveyard(){
        System.out.println("NYI goToGraveyard");
        return this;
    }

    void removeFromPlay();

}
