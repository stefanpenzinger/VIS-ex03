package at.fh.hagenberg.mc.vis.task3_2.a;

import at.fh.hagenberg.mc.vis.task3_2.a.client.HelloWorldService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Task 3.2a
 * Client Implementation
 */
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
                            new URL("http://localhost:8081/HelloWorld?wsdl"),
                            new QName("http://a.task3_2.vis.mc.hagenberg.fh.at/",
                                    "HelloWorldService"));

            at.fh.hagenberg.mc.vis.task3_2.a.client.HelloWorld mSoap = service.getPort(at.fh.hagenberg.mc.vis.task3_2.a.client.HelloWorld.class);

            System.out.println(mSoap.saySomething());
            System.out.println(mSoap.getData("LOL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
