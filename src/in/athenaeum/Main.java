package in.athenaeum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<ComplexNumber> complexNumbers =
                List.of(
                        new ComplexNumber(1, 1),
                        new ComplexNumber(2, 1),
                        new ComplexNumber(3, 2),
                        new ComplexNumber(2, 2)
                );

        //  Collector is a state machine that builds a collection
        //  such as List, Set, Map, etc from a stream

        List<Double> realParts =
                complexNumbers.stream()
                        .map(ComplexNumber::getReal)
                        .collect(Collectors.toList());

        Set<Double> imaginaryParts =
                complexNumbers.stream()
                        .map(ComplexNumber::getImaginary)
                        .collect(Collectors.toSet());

        //  Collecting to a comma-separated string
        //  Works only with Stream<String>
        String realPartsAsString =
                complexNumbers.stream()
                        .map(ComplexNumber::getReal)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));

        //  Collecting to primitive array
        double[] realPartsAsArrayFromDoubleStream =
                complexNumbers.stream()
                        .mapToDouble(ComplexNumber::getReal)    //  creates a double stream (primitive, efficient)
                        .toArray();

        //  Collecting to T[]
        Double[] realPartsAsArrayFromNormalStream = complexNumbers.stream()
                .map(ComplexNumber::getReal)    //  normal stream (autoboxing type)
                .toArray(Double[]::new);
    }
}

class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return this.getReal() + " "
                + (this.getImaginary() > 0 ? " + " + this.getImaginary() + "i" :
                this.getImaginary() < 0 ? " - " + this.getImaginary() + "i" :
                        "");
    }
}
