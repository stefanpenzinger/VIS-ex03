package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.xml.ws.Endpoint;

/**
 * Task 3.2a - Server Implementation
 */
public class Main {
    public static void main(String[] _args) {
        HelloWorld test = new HelloWorld();
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/HelloWorld", test);
        System.out.println("server up and running ...");
    }
}
