package in.athenaeum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Mumbai", "Chennai", "Mysuru");

        //  count is a terminal operator that produces a long result
        long result =
                cities.stream()
                        .filter(s -> s.length() > 6)
                        .count();   //=1

        System.out.println(result);
    }
}
