package at.fh.hagenberg.mc.vis.task3_3.a;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * Hello World Service class
 */
@Path("/hello")
public class HelloWorld extends Application {
    /**
     * Returns hello world html text
     * @return String HTML
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getDataHTML() {
        return "<html><head></head><body>Hello World (HTML text)!!!</body> </html>";
    }

    /**
     * Returns hello world plain text
     * @return String plain text
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDataPlain() {
        return "Hello World (plain text)";
    }

    /**
     * Returns hello world xml
     * @return String XML
     */
    @GET
    @Path("/xml")
    @Produces(MediaType.TEXT_XML)
    public String getDataXML() {
        return "<HelloWorld>Hello World (XML text)!!!</HelloWorld>";
    }

    /**
     * Returns hello world json
     * @return String JSON
     */
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDataJSON() {
        return "{\"val\":\"HelloWorld\"}";
    }
}
