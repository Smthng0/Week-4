package dream.factory.learning.web.feign;

import dream.factory.learning.web.ProductList;
import feign.RequestLine;

public interface RecommendationService {
    @RequestLine("GET")
    ProductList franeHCAPI();
}
