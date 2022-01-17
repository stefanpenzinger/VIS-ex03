package at.fh.hagenberg.mc.vis.task3_2.b;

import at.fh.hagenberg.mc.vis.task3_2.b.client.JsonArray;
import org.json.JSONArray;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) {

        try {
            /*

            +++ VARIANT A +++

            URL url = new URL("http://localhost:8081/HelloWorld?wsdl");

            HelloWorldService helloWorldService = new HelloWorldService(url);
            at.fh.hagenberg.mc.vis.task3_2.a.client.HelloWorld helloWorldServiceProxy = helloWorldService.getHelloWorldPort();

            System.out.println(helloWorldServiceProxy.saySomething());
            System.out.println(helloWorldServiceProxy.getData("LOL"));
            */

            /*

            +++ VARIANT B +++

             */

            Service service =
                    Service.create(
                            new URL("http://localhost:8081/Environment?wsdl"),
                            new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/",
                                    "EnvironmentDataService"));

            at.fh.hagenberg.mc.vis.task3_2.b.client.IEnvironmentData mSoap = service.getPort(at.fh.hagenberg.mc.vis.task3_2.b.client.IEnvironmentData.class);

            System.out.println(mSoap.requestEnvironmentDataTypes());
            System.out.println(mSoap.requestWeatherData());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
