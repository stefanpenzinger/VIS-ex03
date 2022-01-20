package at.fh.hagenberg.mc.vis.task3_3.b;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Wrapper class of Sensor
 */
@XmlRootElement(name = "sensors")
@XmlAccessorType(XmlAccessType.FIELD)
public class SensorList {
    /**
     * List of sensors
     * @val List<Sensor>
     */
    @XmlElement(name = "sensor")
    List<Sensor> mSensorList;

    /**
     * Needed default constructor
     */
    public SensorList() {
    }

    /**
     * Constructor of SensorList
     * @param mSensorList List<Sensor>
     */
    public SensorList(List<Sensor> mSensorList) {
        this.mSensorList = mSensorList;
    }

    /**
     * Get List of Sensors
     * @return List<Sensor>
     */
    public List<Sensor> getSensorList() {
        return mSensorList;
    }
}
