
package at.fh.hagenberg.mc.vis.task3_2.a.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dummyData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dummyData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dummyData", propOrder = {
    "mText",
    "mTime"
})
public class DummyData {

    protected String mText;
    protected long mTime;

    /**
     * Gets the value of the mText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMText() {
        return mText;
    }

    /**
     * Sets the value of the mText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMText(String value) {
        this.mText = value;
    }

    /**
     * Gets the value of the mTime property.
     * 
     */
    public long getMTime() {
        return mTime;
    }

    /**
     * Sets the value of the mTime property.
     * 
     */
    public void setMTime(long value) {
        this.mTime = value;
    }

}
