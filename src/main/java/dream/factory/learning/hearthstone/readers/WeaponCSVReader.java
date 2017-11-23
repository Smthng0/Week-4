package dream.factory.learning.hearthstone.readers;

import dream.factory.learning.hearthstone.cards.HearthstoneCard;
import dream.factory.learning.hearthstone.cards.MinionCard;
import dream.factory.learning.hearthstone.cards.WeaponCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeaponCSVReader {

    public static void main(String[] args) {

        List<WeaponCard> weaponList = new ArrayList<>();
        String weaponFile = "Weapons.csv";
        String line;
        String csvSplit = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(weaponFile))) {
            while ((line = br.readLine()) != null) {
                String[] weapon = line.split(csvSplit);

                weaponList.add(new WeaponCard(weapon[0],
                        Integer.parseInt(weapon[1]),
                        Integer.parseInt(weapon[2]),
                        Integer.parseInt(weapon[3])
                        )
                );
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (HearthstoneCard card : weaponList) {
            System.out.println(card.getTitle());
        }
    }

}
