package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> integers = IntStream
                .range(0, 10)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));

        System.out.println(integers);
    }
}
