package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    /**
     * Returns Hello World
     * @return String
     */
    @WebMethod
    String saySomething();

    /**
     * Returns a new dummy with the given name
     * @param _name String
     * @return DummyData
     */
    @WebMethod
    DummyData getData(String _name);
}
