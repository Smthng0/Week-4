package dream.factory.learning.hearthstone.readers;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinionCSVReader {

    public static void main(String[] args) {

        List<MinionCard> minionList = new ArrayList<>();
        String minionFile = "Minions.csv";
        String line;
        String csvSplit = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(minionFile))) {
            while ((line = br.readLine()) != null) {
                String[] minion = line.split(csvSplit);

                minionList.add(new MinionCard(minion[0],
                        Integer.parseInt(minion[1]),
                        Integer.parseInt(minion[2]),
                        Integer.parseInt(minion[3])
                        )
                );
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (HearthstoneCard card : minionList) {
            System.out.println(card.getTitle());
        }
    }

}
