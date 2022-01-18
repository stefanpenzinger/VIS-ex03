package at.fh.hagenberg.mc.vis.task3_2.b;

import javax.xml.ws.Endpoint;

/**
 * Task 3.2b Server Implementation
 */
public class Main {
    public static void main(String[] args) {
        EnvironmentData test = new EnvironmentData();
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/Environment", test);
        System.out.println("server up and running ...");
    }
}