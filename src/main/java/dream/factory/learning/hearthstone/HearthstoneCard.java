package dream.factory.learning.hearthstone;

public interface HearthstoneCard {

    default HearthstoneCard play() {
        System.out.println("NYI");
        return this;
    };

    //this is probably not needed (it will be in enging)
    default HearthstoneCard discard(){
        //go to graveyard
        System.out.println("NYI");
        return this;
    };

    //this is probably not needed too
    default HearthstoneCard draw(){
        System.out.println("NYI");
        return this;
    };

}
