package at.fh.hagenberg.mc.vis.task3_3.b;

import at.fh.hagenberg.mc.vis.task3_1.c.Pet;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Environment Service class
 */
@Path("/EnvironmentService")
public class Environment extends Application {
    /**
     * Returns an overview
     * @return String HTML
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getOverview() {
        return "<table>" +
                "   <tr>" +
                "       <th>Content</th><th>Path</th><th>Media Type</th>" +
                "   </tr>" +
                "   <tr>" +
                "       <td>Overview</td><td>/</td><td>HTML</td>" +
                "   </tr>" +
                "   <tr>" +
                "       <td>Supported Sensors</td><td>/sensors</td><td>XML</td>" +
                "   </tr>" +
                "   <tr>" +
                "       <td>Get Sensor Data</td><td>/{Sensor}</td><td>XML</td>" +
                "   </tr>" +
                "   <tr>" +
                "       <td>Get All Sensor Data</td><td>/ALL</td><td>XML</td>";
    }

    /**
     * Returns available sensors
     * @return String XML
     */
    @GET
    @Path("/sensors")
    @Produces(MediaType.TEXT_XML)
    public String getSensors() {
        return "<sensors>" +
                    "<sensor>temperature</sensor>" +
                    "<sensor>humidity</sensor>" +
                "</sensors>";
    }

    /**
     * Returns sensor value of the given string
     * @param _sensor String
     * @return String XML
     */
    @GET
    @Path("/{sensor}")
    @Produces(MediaType.TEXT_XML)
    public String getSensors(@PathParam("sensor") String _sensor) {
        return getXml(_sensor);
    }

    /**
     * Returns all Sensor values
     * @return String XML
     */
    @GET
    @Path("/ALL")
    @Produces(MediaType.TEXT_XML)
    public String getAllSensors() {
        return getXml(null);
    }

    /**
     * Returns XML Representation of Sensors
     * @param _sensorName Sensor[]
     * @return String
     */
    private String getXml(String _sensorName) {
        try {
            JAXBContext jc = JAXBContext.newInstance(new Class[] { SensorList.class, Sensor.class });
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();

            if (_sensorName != null) {
                Sensor sensor = new Sensor(Sensor.Type.valueOf(_sensorName));
                m.marshal(sensor, sw);
            }
            else {
                ArrayList<Sensor> sensors = new ArrayList<>();
                for (Sensor.Type type : Sensor.Type.values()) {
                    sensors.add(new Sensor(type));
                }
                m.marshal(new SensorList(sensors), sw);
            }

            return sw.getBuffer().toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "<error><message>" + e.getMessage() + "</message></error>";
        }
    }
}
