package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.xml.ws.Endpoint;
public class Main {
    public static void main(String[] args) {
        HelloWorld test = new HelloWorld();
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/HelloWorld", test);
        System.out.println("server up and running ...");
    }
}
