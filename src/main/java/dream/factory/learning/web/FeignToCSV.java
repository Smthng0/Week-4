package dream.factory.learning.web;


import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import dream.factory.learning.web.feign.RecommendationService;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.io.File;

public class FeignToCSV {

    public ProductList readWeb() {
        String franeAPI = "https://ai-eu.nextuser.com/undiz_fr/PRODUCT/recommendations?variation=VISII";

        return (Feign.builder()
                .decoder(new GsonDecoder())
                .target(RecommendationService.class, franeAPI)).franeHCAPI();
    }

    public void writeToFile(ProductList productList) {
        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(new BeanWriterProcessor<>(Product.class));
        CsvWriter parseMe = new CsvWriter(new File("kita.csv"),settings);

        parseMe.writeHeaders();
        parseMe.processRecords(productList.getResults());
        parseMe.flush();
        parseMe.close();
    }
}
