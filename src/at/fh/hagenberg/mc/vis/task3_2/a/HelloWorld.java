package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Hello World Web Service
 */
@WebService(endpointInterface = "at.fh.hagenberg.mc.vis.task3_2.a.IHelloWorld")
public class HelloWorld implements IHelloWorld {

    /**
     * Returns Hello World
     * @return String
     */
    @WebMethod
    public String saySomething() {
        return "Hello World";
    }

    /**
     * Returns a new dummy with the given name
     * @param _name String
     * @return DummyData
     */
    @WebMethod
    public DummyData getData(String _name) {
        return new DummyData(_name,
                System.currentTimeMillis());
    }
}
