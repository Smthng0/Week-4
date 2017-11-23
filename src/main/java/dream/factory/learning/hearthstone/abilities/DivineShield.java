package dream.factory.learning.hearthstone.abilities;

public class DivineShield implements Ability {
    public boolean usedUp = false;

    @Override
    public void effect(){
        usedUp = true;
    }

    public boolean isUsedUp() {
        return usedUp;
    }

    @Override
    public String getAbilityType() {
        return "DivineShield";
    }
}
