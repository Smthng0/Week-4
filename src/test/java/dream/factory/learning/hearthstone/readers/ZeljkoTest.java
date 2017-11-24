package dream.factory.learning.hearthstone.readers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZeljkoTest {

    @Test
    public void csvToJson() throws Exception {
        Zeljko zeljko = new Zeljko();
        zeljko.csvToJson();
    }

}