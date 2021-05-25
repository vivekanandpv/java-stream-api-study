package in.athenaeum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Pranav", List.of("Admin", "Manager", "User")));
        users.add(new User("Asha", List.of("Finance", "Controller", "User")));
        users.add(new User("Ramakant", List.of("Developer", "Lead", "User")));

        //  flatMap applies map to inner collection
        //  it's a map that returns another stream explicitly
        users.stream()
                .flatMap(u -> u.getRoles().stream())
                .forEach(System.out::println);
    }
}


class User {
    private String username;
    private List<String> roles;

    public User(String username, List<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }
}
