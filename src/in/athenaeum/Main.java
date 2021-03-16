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

        //  In this reducer variant, we provide an identity element
        //  When there are no elements, operation short-circuits to
        //  identity element provided.
        //  For only one element in the stream, c1 will be identity
        //  c2 will be the first element of the stream. Reducer runs only
        //  once.
        //  For 2 or more elements in stream, accumulator starts from identity
        //  and progresses.

        //  Providing the correct identity element for the context of computation
        //  is developer's responsibility. A wrong identity element leads to wrong
        //  result.

        //  As the identity is provided, the result is assured to be
        //  of type T (ComplexNumber in this case).

        ComplexNumber result = complexNumbers.stream()
                .reduce(
                        new ComplexNumber(0, 0),
                        (c1, c2) -> {
                            System.out.println("Reducer runs with " + c1 + " and " + c2);
                            return new ComplexNumber(
                                    c1.getReal() + c2.getReal(),
                                    c1.getImaginary() + c2.getImaginary()
                            );
                        }
                );

        System.out.println(result);
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
