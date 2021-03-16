package in.athenaeum;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<ComplexNumber> complexNumbers =
                List.of(
                        new ComplexNumber(1, 1),
                        new ComplexNumber(2, 1),
                        new ComplexNumber(3, 2),
                        new ComplexNumber(2, 2)
                );

        //  toMap requires a key extractor and a value extractor
        Map<Integer, ComplexNumber> mapDump =
                IntStream.range(0, complexNumbers.size())
                .mapToObj(i -> new IndexedComplexNumber(i, complexNumbers.get(i)))  // map returns IntStream, hence mapToObj
                .collect(
                        Collectors.toMap(
                                IndexedComplexNumber::getIndex,
                                IndexedComplexNumber::getComplexNumber
                        )
                );
    }
}

class IndexedComplexNumber {
    private final int index;
    private final ComplexNumber complexNumber;

    public IndexedComplexNumber(int index, ComplexNumber complexNumber) {
        this.index = index;
        this.complexNumber = complexNumber;
    }

    public int getIndex() {
        return index;
    }

    public ComplexNumber getComplexNumber() {
        return complexNumber;
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
