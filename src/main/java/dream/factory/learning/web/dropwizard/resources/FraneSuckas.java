package dream.factory.learning.web.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import dream.factory.learning.web.dropwizard.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/index")
@Produces(MediaType.TEXT_HTML)
public class FraneSuckas {

    @GET
    @Timed
    public String sayHello() {
        final String value = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is a Heading</h1>\n" +
                "<p>This is a paragraph.</p>\n" +
                "\n" +
                "<img src=\"https://vignette.wikia.nocookie.net/unturned-bunker/images/0/0a/" +
                "Meaning-of-vault-boy-thumbs-up-jpg.jpg/revision/latest?cb=20160316025719}\"" +
                "</body>\n" +
                "</html>";
        return value;
    }

}
