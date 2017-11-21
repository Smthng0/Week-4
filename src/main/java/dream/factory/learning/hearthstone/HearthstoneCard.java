package dream.factory.learning.hearthstone;

public interface HearthstoneCard {

    default HearthstoneCard play() {
        System.out.println("NYI");
        return this;
    };

    //this will maybe be in the engine/board
    default HearthstoneCard goToGraveyard(){
        System.out.println("NYI");
        return this;
    };

    //this is probably not needed
    default HearthstoneCard draw(){
        System.out.println("NYI");
        return this;
    };

}
