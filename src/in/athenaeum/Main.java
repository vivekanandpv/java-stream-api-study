package in.athenaeum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<ComplexNumber> complexNumbers =
                List.of(
                        new ComplexNumber(1, 1)
                );

        //  When there is only one element in the stream
        //  that element is the result of the reduction
        //  Processing is short-circuited. Reducer doesn't run
        //  but the result is produced.

        Optional<ComplexNumber> resultOptional = complexNumbers.stream()
                .reduce(
                        (c1, c2) -> {
                            System.out.println("Reducer runs with " + c1 + " and " + c2);
                            return new ComplexNumber(
                                    c1.getReal() + c2.getReal(),
                                    c1.getImaginary() + c2.getImaginary()
                            );
                        }
                );

        System.out.println(resultOptional);
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
