package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapEx {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Humpty", "Dumpty");

        List<User> users = names
                .stream()
                .map(name -> new User(name, 18, Arrays.asList("133" + name, "5454" + name)))
//                .filter(user -> user.getName() == "Humpty")
                .collect(Collectors.toList());

        users.stream().forEach(System.out::println);

        System.out.println("Check phone number");


        Optional<String> nos = users.stream()
                .map(user -> user.getCellNumbers().stream())
                .flatMap(numbers -> numbers.filter(no -> no.equals("133Humpty")))
                .findAny();

        nos.ifPresent(System.out::println);
    }
}
