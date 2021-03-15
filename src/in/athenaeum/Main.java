package in.athenaeum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<String> cities = List.of("Mumbai", "Chennai", "Mysuru");

	    cities.stream()
                .map(s -> {
                    System.out.println("Map1: " + s);
                   return s.toUpperCase();
                })
                .map(s -> {
                    System.out.println("Map2: " + s);
                    return s.length();
                })
                .filter(i -> {
                    System.out.println("Filter: " + i);
                    return i > 6;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
