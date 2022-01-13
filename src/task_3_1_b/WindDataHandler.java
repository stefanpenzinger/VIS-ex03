package task_3_1_b;

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
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (mElementValue == null) {
            mElementValue = new StringBuilder();
        } else {
            mElementValue.append(ch, start, length);
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
     * @param uri
     * @param lName
     * @param qName
     * @param attr
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case SPEED:
            case DEG:
                mElementValue = new StringBuilder();
                break;
        }
    }

    /**
     * called at end of xml tag (read out StringBuilder)
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
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
