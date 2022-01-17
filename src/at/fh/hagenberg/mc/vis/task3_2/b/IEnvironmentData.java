package at.fh.hagenberg.mc.vis.task3_2.b;

import org.json.JSONArray;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IEnvironmentData {
    enum Locations { Wien, Graz, Linz };

    @WebMethod
    public Locations requestEnvironmentDataTypes();

    @WebMethod
    public EnvData requestWeatherData();
}
