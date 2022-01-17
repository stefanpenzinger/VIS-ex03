package at.fh.hagenberg.mc.vis.task3_2.b;

import at.fh.hagenberg.mc.vis.task3_1.c.Pet;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@WebService(endpointInterface = "at.fh.hagenberg.mc.vis.task3_2.b.IEnvironmentData")
public class EnvironmentData implements IEnvironmentData {
    @Override
    @WebMethod
    public Locations requestEnvironmentDataTypes() {
        return Locations.Wien;
    }

    @Override
    @WebMethod
    public EnvData requestWeatherData() {
        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

            //String content = getContent();
            String content = " {" +
                    "   \"message\":\"accurate\"," +
                    "   \"cod\":\"200\"," +
                    "   \"count\":1," +
                    "   \"list\":[" +
                    "      {" +
                    "         \"id\":2643743," +
                    "         \"name\":\"London\"," +
                    "         \"coord\":{" +
                    "            \"lat\":51.5085," +
                    "            \"lon\":-0.1258" +
                    "         }," +
                    "         \"main\":{" +
                    "            \"temp\":7," +
                    "            \"pressure\":1012," +
                    "            \"humidity\":81," +
                    "            \"temp_min\":5," +
                    "            \"temp_max\":8" +
                    "         }," +
                    "         \"dt\":1485791400," +
                    "         \"wind\":{" +
                    "            \"speed\":4.6," +
                    "            \"deg\":90" +
                    "         }," +
                    "         \"sys\":{" +
                    "            \"country\":\"GB\"" +
                    "         }," +
                    "         \"rain\":null," +
                    "         \"snow\":null," +
                    "         \"clouds\":{" +
                    "            \"all\":90" +
                    "         }," +
                    "         \"weather\":[" +
                    "            {" +
                    "               \"id\":701," +
                    "               \"main\":\"Mist\"," +
                    "               \"description\":\"mist\"," +
                    "               \"icon\":\"50d\"" +
                    "            }," +
                    "            {" +
                    "               \"id\":300," +
                    "               \"main\":\"Drizzle\"," +
                    "               \"description\":\"light intensity drizzle\"," +
                    "               \"icon\":\"09d\"" +
                    "            }" +
                    "         ]" +
                    "      }" +
                    "   ]" +
                    "  }";


            JSONObject jsonObject = new JSONObject(content);
            jsonObject = jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main");

            //EnvData envDataTest = new EnvData(jsonObject.getFloat("temp"), jsonObject.getFloat("pressure"),jsonObject.getFloat("humidity"),jsonObject.getFloat("temp_min"),jsonObject.getFloat("temp_max"));

            JAXBContext jc = JAXBContext.newInstance(new Class[] { EnvData.class });

            Unmarshaller um = jc.createUnmarshaller();

            um.setProperty(UnmarshallerProperties.MEDIA_TYPE,
                    MediaType.APPLICATION_JSON);
            um.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,
                    Boolean.FALSE);

            StreamSource stream = new StreamSource(new StringReader(jsonObject.toString()));
            JAXBElement<EnvData> envDataContainer = um.unmarshal(stream, EnvData.class);
            EnvData envData = envDataContainer.getValue();

            return envData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getContent() throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Wien,at&units=metric&APPID=15700b057d281f860821612c91035931");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();

        int length = http.getContentLength();
        int resCode = http.getResponseCode();
        String mime = http.getContentType();

        Scanner s = new Scanner(http.getInputStream(), "UTF-8");
        s.useDelimiter("\\z"); // \z --> till end of input

        String content = s.next();
        s.close();

        return content;
    }
}
