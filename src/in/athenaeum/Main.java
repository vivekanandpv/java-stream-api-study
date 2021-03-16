package in.athenaeum;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("vivek", Set.of("admin", "manager")),
                new User("arjun", Set.of("backup", "user")),
                new User("asad", Set.of("developer")),
                new User("bharat", Set.of("qa", "user"))
        );

        Map<String, Set<String>> userMap =
                userList.stream()
                        .collect(
                                Collectors.toMap(
                                        User::getUsername,
                                        User::getRoles
                                )
                        );
    }
}

class User {
    private final String username;
    private final Set<String> roles;

    public User(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
