package dream.factory.learning.web;

import com.google.gson.Gson;
/*import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;*/

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class Java9ToCSVWritter {
  /*  public void getFromWebJavaApi() {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://ai-eu.nextuser.com/undiz_fr/PRODUCT/recommendations?variation=VISII"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

            handleResponse(response);

        } catch (URISyntaxException | IOException  | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void processJavaApiToJson(HttpResponse<String> response) {
        Gson gson = new Gson();
        ProductList productList = gson.fromJson(response.body(), ProductList.class);
        productList.printList();
    }

    public void writeToFileAsync() { public void getFromWebJavaApi() {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://ai-eu.nextuser.com/undiz_fr/PRODUCT/recommendations?variation=VISII"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

            handleResponse(response);

        } catch (URISyntaxException | IOException  | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://ai-eu.nextuser.com/undiz_fr/PRODUCT/recommendations?variation=VISII"))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> httpResponse = client.sendAsync(request, HttpResponse.BodyHandler.asString());

            while (!httpResponse.isDone()) {
                System.out.println("Status code: " + httpResponse.get().statusCode());
                System.out.println("Body: " + httpResponse.get().body());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleResponse(HttpResponse<String> response){
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }
*/
}
