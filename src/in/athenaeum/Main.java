package in.athenaeum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    //  Exercise: company produces cars
    //  every car has some colors (red, silver, white, blue)
    //  the company how many total colors are there for all the cars?

    public static void main(String[] args) {

        List<Car> cars = List.of(
                new Car("Camry", new String[]{"Blue", "White", "Black"}),
                new Car("Etios", new String[]{"Silver", "Brown", "White"}),
                new Car("Corolla", new String[]{"Golden", "Black", "White"})
        );

        //  flatMap applies map to inner collection
        //  it's a map that returns another stream explicitly
        //  Arrays.stream() is a convenience method

        long totalColours =
                cars.stream()
                        .flatMap(c -> Arrays.stream(c.getColours()))
                        .distinct()
                        .peek(System.out::println)
                        .count();

        System.out.println(totalColours);
    }
}

class Car {
    private final String model;
    private final String[] colours;

    public Car(String model, String[] colours) {
        this.model = model;
        this.colours = colours;
    }

    public String getModel() {
        return model;
    }

    public String[] getColours() {
        return colours;
    }
}
