package collectors;


import stream.Person;
import stream.SEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by shraddha on 2/10/16.
 */
public class CollectorsOperations {
    public static void main(String[] args) {
        List<Person> peeps = new ArrayList<>();

        /* replacing the forloop with range */
        IntStream.range(1, 10).forEach(
                i ->  peeps.add(new Person("Person_" + i, 5 * i, i % 2 == 0 ? SEX.FEMALE : SEX.MALE))
        );


        // Collect names into a Set
        Set<String> names = peeps.stream()
                .map(Person::getfName)
                .collect(Collectors.toSet());
        names.forEach(System.out::println);

        // create a map of person to age
        Map<String, Integer> personToage =
                peeps.stream()
                .collect(Collectors.toMap(Person::getfName, Person::getAge));

        personToage.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        //Group people by gender
        Map<SEX, List<Person>> genderToPeep =
                peeps.stream()
                .collect(Collectors.groupingBy(Person::getSex));

        genderToPeep.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        // Find average age by gender
        Map<SEX, Double> avergaeAge =
                peeps.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.averagingInt(Person::getAge)));
        avergaeAge.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        peeps.stream()
                .forEach(p -> p.setAge(p.getAge() * 100));
        peeps.forEach(System.out::println);
    }

}
