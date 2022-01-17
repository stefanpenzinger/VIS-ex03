package at.fh.hagenberg.mc.vis.task3_2.b;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "mTemp", "mTempMin", "mHumidity", "mPressure", "mTempMax" })
public class EnvData {
    @XmlElement(name = "temp")
    private float mTemp;
    @XmlElement(name = "pressure")
    private float mPressure;
    @XmlElement(name = "humidity")
    private float mHumidity;
    @XmlElement(name = "temp_min")
    private float mTempMin;
    @XmlElement(name = "temp_max")
    private float mTempMax;

    public EnvData() {
    }

    public EnvData(float _temp, float _pressure, float _humidity, float _minTemp, float _maxTemp) {
        this.mTemp = _temp;
        this.mPressure = _pressure;
        this.mHumidity = _humidity;
        this.mTempMin = _minTemp;
        this.mTempMax = _maxTemp;
    }

    public float getmTemp() {
        return mTemp;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public float getmTempMin() {
        return mTempMin;
    }

    public float getmTempMax() {
        return mTempMax;
    }

    @Override
    public String toString() {
        return "EnvData{" +
                "mTemp=" + mTemp +
                ", mPressure=" + mPressure +
                ", mHumidity=" + mHumidity +
                ", mTempMin=" + mTempMin +
                ", mTempMax=" + mTempMax +
                '}';
    }
}
