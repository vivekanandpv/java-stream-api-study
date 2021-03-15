package in.athenaeum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<String> names = List.of("Raman", "Einstein", "Rutherford", "Heisenberg", "Bohr");

        //  flatMap applies map to inner collection
        //  it's a map that returns another stream explicitly
        //  Arrays.stream() is a convenience method
        names.stream()
                .flatMap(name -> Arrays.stream(name.split("[aeiou]")))
                .forEach(System.out::println);
    }
}
