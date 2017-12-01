package dream.factory.learning.web;

import org.junit.Test;

public class FeignToCSVWritterTest {
    @Test
    public void combo_OK() throws Exception {
        new FeignToCSVWritter().writeToFile(new FeignToCSVWritter().readWeb());
    }

}