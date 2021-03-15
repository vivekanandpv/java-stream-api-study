package in.athenaeum;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 2, 4, 5, 3, 2, 1, 7, 8);

        //  takeWhile is like filter, but stops the pipeline as soon as
        //  the non-match is found (while filter continues to look for
        //  other elements)

        numbers.stream()
                .takeWhile(n -> n % 2 == 0) //stops the stream at first non-match
                .forEach(System.out::println);  //8,2,4

        System.out.println("---------------------------");

        numbers.stream()
                .filter(n -> n % 2 == 0) //skips non matching elements
                .forEach(System.out::println);  //8,2,4,2,8
    }
}
