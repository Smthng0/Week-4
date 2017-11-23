package dream.factory.learning.hearthstone.abilities;

public class DivineShield implements Ability {
    public boolean usedUp = false;

    @Override
    public void effect(){
        usedUp = true;
    }

    @Override
    public String getAbilityType() {
        return "DivineShield";
    }
}
