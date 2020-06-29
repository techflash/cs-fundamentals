package guava;

import com.google.common.base.Predicates;
import java.util.function.Predicate;

public class PredicatesTest {

  public static void main(String[] args) {
    Predicate<Integer> p = Predicates.and(
        x -> x == 10 || x != 20,
        x -> x != 20
    );

    System.out.println(p.test(10));
  }


}
