package dream.factory.learning.hearthstone;

import java.util.List;

public class SpellCard extends AbstractSpellCard {

    public SpellCard (String title, int manaCost, List<Ability> abilities){
        super();
        this.title = title;
        this.manaCost = manaCost;
        this.abilities = abilities;
    }


}
