package at.fh.hagenberg.mc.vis.task3_1.c;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Pet data container
 */
@XmlRootElement
@XmlType(propOrder = { "mName", "mType", "mID", "mBirthday", "mVaccinations" })
public class Pet {
    /**
     * Supported type of pets
     */
    @XmlType
    public enum Type { cat, dog, mouse, bird }

    /**
     * Name of the pet
     * @val String mName
     */
    @XmlElement(name = "name")
    private String mName;
    /**
     * Nickname of the pet
     * @val String mNickname
     */
    @XmlAttribute(name = "nickname")
    private String mNickName;
    /**
     * Birthday of the pet
     * @val Date mBirthday
     */
    @XmlElement(name = "birthday")
    private Date mBirthday;
    /**
     * Type of the pet
     * @val Type mType
     */
    @XmlElement(name = "type", namespace = "pet type")
    private Type mType;
    /**
     * Vaccinations the pet has
     * @val String[] mVaccinations
     */
    @XmlElementWrapper(name = "vaccinations")
    @XmlElement(name = "vaccination")
    private String[] mVaccinations;
    /**
     * ID of the pet
     * @val String mID
     */
    @XmlElement(name = "id")
    private String mID;

    /**
     * Needed Default Constructor
     */
    public Pet() {
    }

    /**
     * Get the name of the pet
     * @return String
     */
    public String getmName() {
        return mName;
    }

    /**
     * Get Birthday of the pet
     * @return Date
     */
    public Date getmBirthday() {
        return mBirthday;
    }

    /**
     * Get the type of the pet
     * @return Type
     */
    public Type getmType() {
        return mType;
    }

    /**
     * Get Vaccinations
     * @return String[]
     */
    public String[] getmVaccinations() {
        return mVaccinations;
    }

    /**
     * Get ID of the pet
     * @return String
     */
    public String getmID() {
        return mID;
    }

    /**
     * Constructor of the Pet
     * @param _name name
     * @param _nickName nickname
     * @param _birthday birthday
     * @param _type type
     * @param _vaccinations vaccinations
     * @param _id id
     */
    public Pet(String _name, String _nickName, Date _birthday, Type _type, String[] _vaccinations, String _id) {
        this.mName = _name;
        this.mNickName = _nickName;
        this.mBirthday = _birthday;
        this.mType = _type;
        this.mVaccinations = _vaccinations;
        this.mID = _id;
    }

    /**
     * String representation of Pet
     * @return String
     */
    @Override
    public String toString() {
        return "Pet{" +
                "mName='" + mName + '\'' +
                ", mNickName='" + mNickName + '\'' +
                ", mBirthday=" + mBirthday +
                ", mType=" + mType +
                ", mVaccinations=" + Arrays.toString(mVaccinations) +
                ", mID='" + mID + '\'' +
                '}';
    }
}
