package dream.factory.learning.readers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductList {
    private List<Product> results = new ArrayList<>();

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public void printList() {
        for (Product product : results) {
            System.out.println("Product title: " + product.getTitle()
                    + ", Category: " + product.getCategory()
                    + ", ID: " + product.getId()
                    + ", Price: " + product.getPrice());
        }
    }
}
