package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Dummy Data - Data Container
 */
@XmlRootElement
public class DummyData {
    /**
     * Text which represents the dummy
     * @val String mText
     */
    @XmlElement
    String mText;
    /**
     * Timestamp when the dummy was created
     * @val long mTime
     */
    @XmlElement
    long mTime;

    /**
     * The needed default constructor
     */
    public DummyData() {}

    /**
     * Constructor of dummy data container
     * @param _txt String
     * @param _time long
     */
    public DummyData(String _txt, long _time) {
        mText = _txt;
        mTime = _time;
    }

    /**
     * String representation of the dummy
     * @return String
     */
    @Override
    public String toString() {
        return "DummyData from (" + mTime + ") --> " + mText;
    }
}
