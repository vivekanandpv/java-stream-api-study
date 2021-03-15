package in.athenaeum;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Ratnagiri", "Dharwad", "Haveri", "Bidar");

        //  limit is a non-terminal operator that applies
        //  filtration with remembrance

        cities.stream()
                .limit(2)   //only Ratnagiri and Dharwad
                .forEach(System.out::println);
    }
}
