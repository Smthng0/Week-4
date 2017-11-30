package dream.factory.learning.web;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeignToCSVTest {
    @Test
    public void combo_OK() throws Exception {
        new FeignToCSV().writeToFile(new FeignToCSV().readWeb());
    }

}