package at.fh.hagenberg.mc.vis.task3_3.b;

import javax.xml.bind.annotation.*;
import java.util.Random;

/**
 * Sensor data class
 */
@XmlRootElement
public class Sensor {
    /**
     * Available types of sensors
     */
    public enum Type { temperature, humidity }

    /**
     * Type of sensor
     * @val Type mType
     */
    @XmlElement(name = "sensor-type")
    private Type mType;

    /**
     * Value of sensor
     * @val float mValue
     */
    @XmlElement(name = "value")
    private float mValue;

    /**
     * The needed constructor
     */
    public Sensor() {
    }

    /**
     * Constructor of Sensor
     * @param mType Type
     */
    public Sensor(Type mType) {
        this.mType = mType;

        if (mType == Type.temperature) {
            this.mValue = 25.2f;
        }
        else if (mType == Type.humidity) {
            this.mValue = new Random().nextFloat() * 100;
        }
    }

    /**
     * Sets the value of the sensor
     * @param _value float
     */
    public void setValue(float _value) {
        this.mValue = _value;
    }
}
