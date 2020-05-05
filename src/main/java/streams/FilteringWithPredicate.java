package streams;

import java.util.function.Consumer;
import java.util.function.Function;

public class FilteringWithPredicate {

  public static void main(String[] args) {
    Function<String, Consumer<User>> userFiler = letter -> user -> System.out.println(user);
  }

}
