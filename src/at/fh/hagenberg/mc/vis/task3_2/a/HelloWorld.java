package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "at.fh.hagenberg.mc.vis.task3_2.a.IHelloWorld")
public class HelloWorld implements IHelloWorld {
    @WebMethod
    public String saySomething() {
        return "Hello World";
    }
    @WebMethod
    public DummyData getData(String _name) {
        return new DummyData(_name,
                System.currentTimeMillis());
    }
}
