package in.athenaeum;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Ratnagiri", "Dharwad", "Haveri", "Bidar");
        //  https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Stream.html#findFirst()
        //  findAny is a terminal operator that produces Optional<T>
        //  Optional<T> because result could not exist
        Optional<String> findAnyResult
                = cities.stream()
                .filter(s -> s.length() > 7)
                .findAny();

        Optional<String> findFirstResult
                = cities.stream()
                .filter(s -> s.length() > 7)
                .findFirst();

        System.out.println("findAnyResult: " + findAnyResult);
        System.out.println("findFirstResult: " + findFirstResult);

        //  findAny is non-deterministic, it can potentially return any element
        //  Please read the documentation
    }
}
