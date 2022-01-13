package at.fh.hagenberg.mc.vis.task3_1.b;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Default Handler class to parse string.xml to WindData object
 */
public class WindDataHandler extends DefaultHandler {

    private static final String SPEED = "speed";
    private static final String DEG = "deg";

    /** Object to be builed */
    private WindData mWindData;

    /** StringBuilder is needed to read values */
    private StringBuilder mElementValue;

    @Override
    public void characters(char[] _ch, int _start, int _length) throws SAXException {
        if (mElementValue == null) {
            mElementValue = new StringBuilder();
        } else {
            mElementValue.append(_ch, _start, _length);
        }
    }

    /**
     * called when document starts (in our example: <wind> tag)
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        mWindData = new WindData();
    }

    /**
     * called on start of xml tag (starting to read values)
     * @param _uri uri
     * @param _lName lName
     * @param _qName qName
     * @param _attr attr
     * @throws SAXException
     */
    @Override
    public void startElement(String _uri, String _lName, String _qName, Attributes _attr) throws SAXException {
        switch (_qName) {
            case SPEED:
            case DEG:
                mElementValue = new StringBuilder();
                break;
        }
    }

    /**
     * called at end of xml tag (read out StringBuilder)
     *
     * @param _uri uri
     * @param _localName localName
     * @param _qName qName
     * @throws SAXException
     */
    @Override
    public void endElement(String _uri, String _localName, String _qName) throws SAXException {
        switch (_qName) {
            case SPEED:
                mWindData.setmSpeed(mElementValue.toString());
                break;
            case DEG:
                mWindData.setmDeg(mElementValue.toString());
                break;
        }
    }

    /** Getter of windData */
    public WindData getmWindData() {
        return mWindData;
    }
}
