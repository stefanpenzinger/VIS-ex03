package at.fh.hagenberg.mc.vis.task3_2.b;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Task 3.2b Client Implementation
 */
public class Client {
    public static void main(String[] _args) {

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

            int choice = 1;
            at.fh.hagenberg.mc.vis.task3_2.b.client.Locations location;
            String requestedLocation = "";

            do {
                try {
                    System.out.println("1. Request Locations\n2. Request Weather Data\n0. Exit");
                    Scanner io = new Scanner(System.in);
                    System.out.print("\nChoice: ");

                    choice = io.nextInt();
                    System.out.println();

                    if (choice == 1) {
                        System.out.println(mSoap.requestEnvironmentDataTypes());
                    } else if (choice == 2) {
                        try {
                            System.out.print("Location: ");

                            requestedLocation = io.next().toUpperCase(Locale.ROOT);

                            location = at.fh.hagenberg.mc.vis.task3_2.b.client.Locations.valueOf(requestedLocation);
                            at.fh.hagenberg.mc.vis.task3_2.b.client.EnvData weatherData = mSoap.requestWeatherData(location);

                            System.out.println(weatherData);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error - " + requestedLocation + " is not a supported location!");
                        }
                    } else if (choice != 0) {
                        System.err.println("Invalid option!\n");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid option!\n");
                    choice = 1;
                }
            } while (choice != 0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
