package in.athenaeum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Mumbai", "mumbai", "Mysuru");

        //  distinct is a non-terminal operator
        //  that applies filtration (remembers the processed items)
        cities.stream()
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
