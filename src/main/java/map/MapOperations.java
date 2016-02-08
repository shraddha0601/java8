package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shraddha on 2/7/16.
 */
public class MapOperations {
    public static void main(String[] args) {
        Map<String, List<User>> map = new HashMap<>();

        /* Put if absent */
        map.putIfAbsent("Comedians", new ArrayList<>(Arrays.asList(new User("Larry", "larry@hbo.com"),
                new User("Jerry", "jerry@gmail.com"), new User("Tina", "lizlemon@tgs.com"))));

        map.putIfAbsent("Musicians", new ArrayList<>(Arrays.asList(new User("Coldplay", "coldplay@sm.com"),
                new User("Adele", "adele@singlesclub.com"))));

        printMap(map);

        /* getOrDefault */
        System.out.println(map.getOrDefault("Athletes", new ArrayList<>(Arrays.asList(new User("Michael", "mphelps@usa.com")))));

        /* computeIfAbsent */
        map.computeIfAbsent("Politicians",
                users -> new ArrayList<>()).add((new User("Hillary", "hillary@whitehouse.com")));

        printMap(map);

        /* Merge 2 maps */
        Map<String, List<User>> map2 = new HashMap<>();
        map2.putIfAbsent("Comedians", new ArrayList<>(Arrays.asList(new User("Trevor", "trevor@dailyshow.com"),
                new User("Amy", "amy@comedycellar.com"))));

        map2.forEach((category, users) -> {
                    map.merge(category, users,
                            (existingUsers, newUsers) -> {
                                existingUsers.addAll(newUsers);
                                return existingUsers;
                            });
                }
        );
        System.out.println("\n After merging: ");
        printMap(map);
    }

    private static void printMap(Map<String, List<User>> map) {
        /* forEach */
        map.forEach((department, users) -> System.out.println(String.format("Department: %s - Users: %s", department, users)));
    }
}
