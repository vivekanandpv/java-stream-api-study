package in.athenaeum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> cities = List.of("Mumbai", "Chennai", "Mysuru");

        //  https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
        //  If there is a static method that has the same signature as the lambda,
        //  or a method available on the parameter's type,
        //  we can provide the method reference as Type::method
        //  Using method references makes the code concise and clean
        cities.stream()
                .map(String::toUpperCase)   //toUpperCase is available on String
                .forEach(Main::printName);  //printName is a static method
        //  .forEach(Provider::printName);  //also possible
        //  .forEach(System.out::println);  //also possible
    }

    public static void printName(String s) {
        System.out.println(s);
    }
}

interface Provider {
    static void printName(String name) {
        System.out.println(name);
    }
}
