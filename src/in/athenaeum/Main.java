package in.athenaeum;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 2, 4, 5, 3, 2, 1, 7, 8);

        //  peek is a non-terminal operator used for side-effects
        //  It doesn't alter the stream

        long count = numbers.stream()
                .peek(i -> System.out.println(i + "^3 = " + i * i * i))
                .distinct()
                .count();
        System.out.println("-----------------------");
        System.out.println(count);
    }
}
