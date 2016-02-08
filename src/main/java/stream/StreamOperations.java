package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by shraddha on 2/7/16.
 */
public class StreamOperations {

    public static void main(String[] args) {
        List<Person> peeps = new ArrayList<>();

        /* replacing the forloop with range */
        IntStream.range(1, 10).forEach(
              i ->  peeps.add(new Person("Person_" + i, 5 * i, i % 2 == 0 ? SEX.FEMALE : SEX.MALE))
        );

        /* print with stream */
        peeps.stream()
                .forEach(System.out::println);

        /* Find average age of the women */
        System.out.println("\n Calculating averages...");
        System.out.println("Average age of women: " +
                peeps.stream()
                        .filter(person -> person.getSex().equals(SEX.FEMALE))
                        .peek(System.out::println)
                        .mapToInt(Person::getAge)
                        .average()
        );


        /* Find first man over 25 */
        System.out.println("Finding a man over 25");
        Optional<Person> personOptional = peeps.stream()
                                                .filter(person -> person.getAge() > 25 && person.getSex().equals(SEX.MALE))
                                                .findFirst();

        if(personOptional.isPresent()) {
            System.out.println(personOptional.get());
        }

    }

}
