package at.fh.hagenberg.mc.vis.task3_2.a;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DummyData {
    @XmlElement
    String mText;
    @XmlElement
    long mTime;
    public DummyData() {}
    public DummyData(String _txt, long _time) {
        mText = _txt;
        mTime = _time;
    }

    @Override
    public String toString() {
        return "DummyData from (" + mTime + ") --> " + mText;
    }
}
