package dream.factory.learning.hearthstone.readers;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinionCSVReaderTest {
    @Test
    public void createMinionListFromTxt_OK() throws Exception {
        List<MinionCard> minionList = MinionCSVReader.createMinionListFromTxt();

        for (HearthstoneCard card : minionList) {
            System.out.println(card.getTitle());
        }
    }

}