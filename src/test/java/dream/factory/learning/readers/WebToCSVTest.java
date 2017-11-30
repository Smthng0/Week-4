package dream.factory.learning.readers;

import org.junit.Test;

import static org.junit.Assert.*;

public class WebToCSVTest {
    @Test
    public void writeToFile_OK() {
        new WebToCSV().writeToFile();
    }

}