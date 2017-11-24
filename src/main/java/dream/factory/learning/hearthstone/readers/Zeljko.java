package dream.factory.learning.hearthstone.readers;


import com.google.gson.*;
import dream.factory.learning.hearthstone.cards.MinionCard;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Zeljko {

    public void csvToJson() {
        List<MinionCard> minionList = MinionCSVReader.createMinionListFromTxt();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        try (Writer writer = new FileWriter("Minions.json")) {
            gson.toJson(minionList, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
