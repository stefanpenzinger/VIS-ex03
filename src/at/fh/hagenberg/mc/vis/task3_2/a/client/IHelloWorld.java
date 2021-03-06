
package at.fh.hagenberg.mc.vis.task3_2.a.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IHelloWorld", targetNamespace = "http://a.task3_2.vis.mc.hagenberg.fh.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHelloWorld {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saySomething", targetNamespace = "http://a.task3_2.vis.mc.hagenberg.fh.at/", className = "at.fh.hagenberg.mc.vis.task3_2.a.client.SaySomething")
    @ResponseWrapper(localName = "saySomethingResponse", targetNamespace = "http://a.task3_2.vis.mc.hagenberg.fh.at/", className = "at.fh.hagenberg.mc.vis.task3_2.a.client.SaySomethingResponse")
    @Action(input = "http://a.task3_2.vis.mc.hagenberg.fh.at/IHelloWorld/saySomethingRequest", output = "http://a.task3_2.vis.mc.hagenberg.fh.at/IHelloWorld/saySomethingResponse")
    public String saySomething();

    /**
     * 
     * @param arg0
     * @return
     *     returns at.fh.hagenberg.mc.vis.task3_2.a.client.DummyData
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getData", targetNamespace = "http://a.task3_2.vis.mc.hagenberg.fh.at/", className = "at.fh.hagenberg.mc.vis.task3_2.a.client.GetData")
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://a.task3_2.vis.mc.hagenberg.fh.at/", className = "at.fh.hagenberg.mc.vis.task3_2.a.client.GetDataResponse")
    @Action(input = "http://a.task3_2.vis.mc.hagenberg.fh.at/IHelloWorld/getDataRequest", output = "http://a.task3_2.vis.mc.hagenberg.fh.at/IHelloWorld/getDataResponse")
    public DummyData getData(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
