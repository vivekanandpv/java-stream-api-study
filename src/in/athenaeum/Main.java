package in.athenaeum;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Ratnagiri", "Dharwad", "Haveri", "Bidar");

        //  skip is a non-terminal operator that applies
        //  filtration with remembrance

        cities.stream()
                .skip(2)   //only Haveri and Bidar
                .forEach(System.out::println);
    }
}
