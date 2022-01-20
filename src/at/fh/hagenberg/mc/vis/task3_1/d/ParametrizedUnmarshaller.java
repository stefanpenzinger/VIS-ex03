package at.fh.hagenberg.mc.vis.task3_1.d;

import at.fh.hagenberg.mc.vis.task3_1.c.Pet;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Task 3.1d
 * Parametrized Unmarshaller in order to parse JSON to Data Container
 */
public class ParametrizedUnmarshaller {
    public static void main(String[] _args) {
        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

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
            m.setProperty(UnmarshallerProperties.MEDIA_TYPE,
                    MediaType.APPLICATION_JSON);
            m.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,
                    Boolean.FALSE);

            StringWriter sw = new StringWriter();
            m.marshal(pet, sw);

            String data = sw.getBuffer().toString();
            System.out.println(data);

            Unmarshaller um = jc.createUnmarshaller();

            um.setProperty(UnmarshallerProperties.MEDIA_TYPE,
                    MediaType.APPLICATION_JSON);
            um.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,
                    Boolean.FALSE);
            StreamSource stream = new StreamSource(new StringReader(data));
            JAXBElement<Pet> petContainer = um.unmarshal(stream, Pet.class);

            Pet newPet = petContainer.getValue();
            System.out.println(newPet);
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
    }
}
