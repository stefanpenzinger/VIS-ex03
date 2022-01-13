package task_3_1_c;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Task 3.1c
 */
public class ElegantApproach {
    public static void main(String[] _args) {
        try {
            Pet pet = new Pet(
                    "Thomas",
                    "Tom",
                    Date.from(
                            LocalDate.of(1940, 2, 10)
                                    .atStartOfDay()
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()),
                    Pet.Type.cat,
                    new String[] { "cat flu", "feline distemper", "rabies", "leucosis" },
                    "123456789"
            );

            JAXBContext jc = JAXBContext.newInstance(new Class[] { Pet.class });
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(pet, sw);

            String data = sw.getBuffer().toString();
            System.out.println(data);

            Unmarshaller um = jc.createUnmarshaller();
            Pet newPet = (Pet) um.unmarshal(new StringReader(data));

            System.out.println(newPet);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
