package task_3_1_c;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@XmlRootElement
public class Pet {
    @XmlType
    public enum Type { cat, dog, mouse, bird };

    @XmlElement(name = "name")
    private String mName;
    @XmlAttribute
    @XmlElement(name = "nickname")
    private String mNickName;
    @XmlElement(name = "birthday")
    private LocalDate mBirthday;
    @XmlElementWrapper(namespace = "pet")
    @XmlElement(name = "type")
    private Type mType;
    @XmlElementWrapper(name = "vaccinations")
    @XmlElement(name = "vaccination")
    private String[] mVaccinations;
    @XmlElement(name = "id")
    private String mID;

    public Pet(String _name, String _nickName, LocalDate _birthday, Type _type, String[] _vaccinations, String _id) {
        this.mName = _name;
        this.mNickName = _nickName;
        this.mBirthday = _birthday;
        this.mType = _type;
        this.mVaccinations = _vaccinations;
        this.mID = _id;
    }
}
