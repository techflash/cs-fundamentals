package programms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayProb {
    public static void main(String[] args) {
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("a", "c"),
                Arrays.asList("a")
        );
       List<String> list = Arrays.asList("a", "b", "c");

        List<String> a = Optional.ofNullable(listOfList)
                .orElse(Collections.emptyList())
                .stream().flatMap(s -> s.stream().filter( x -> x == "a"))
                .collect(Collectors.toList());

        System.out.println(a);
    }

    private static int[] generate(){
        return new int[] {1};
    }
}
