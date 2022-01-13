package task_3_1_c;

import java.time.LocalDate;

public class ElegentApproach {
    public static void main(String[] args) {
        Pet pet = new Pet(
                "Thomas",
                "Tom",
                LocalDate.of(1940, 2, 10),
                Pet.Type.cat,
                new String[] { "cat flu", "feline distemper", "rabies", "leucosis" },
                "123456789"
        );


    }
}
