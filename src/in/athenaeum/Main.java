package in.athenaeum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<ComplexNumber> complexNumbers =
                List.of(
                        new ComplexNumber(1, 1),
                        new ComplexNumber(2, 1),
                        new ComplexNumber(3, 2),
                        new ComplexNumber(2, 2)
                );

        //  A reducer is a pure function
        //  In this first variant, reducer is applied iteratively
        //  For example:
        //  0   1   2   3   4    5   // original stream
        //  0 + 1   // reducer returns 1
        //      1 + 2   // reducer returns 3
        //          3 + 3   // reducer returns 6
        //              6 + 4   // reducer returns 10
        //                  10 + 5  // reducer returns 15
        //                      15  // no c2 from this point. result = 15

        //  why Optional<T>?
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
                + (this.getImaginary() > 0 ? " +" + this.getImaginary() + "i" :
                this.getImaginary() < 0 ? this.getImaginary() + "i" :
                        "");
    }
}
