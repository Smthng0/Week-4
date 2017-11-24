package dream.factory.learning.hearthstone.abilities.effects;

import dream.factory.learning.hearthstone.Engine;
import dream.factory.learning.hearthstone.abilities.Ability;
import dream.factory.learning.hearthstone.cards.MinionCard;

public class Silence  implements Ability {

    @Override
    public void effect() {
        if (Engine.getEnemyMinion() instanceof MinionCard){
            ((MinionCard)(Engine.getEnemyMinion())).suppressAbility();
        } else {
            System.out.println("Invalid target!");
        }
    }

    @Override
    public String getAbilityType() {
        return "Silence";
    }

}
