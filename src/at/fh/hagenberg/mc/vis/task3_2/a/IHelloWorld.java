package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    @WebMethod
    public String saySomething();

    @WebMethod
    public DummyData getData(String _name);
}
