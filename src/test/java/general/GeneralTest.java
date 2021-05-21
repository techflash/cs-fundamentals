package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

enum Time {
  GOODTIME,
  BADTIME;

  public static boolean isValidKey(String key) {
    try {
      return Time.valueOf(key) instanceof Time;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}

  public class GeneralTest {


    @Test
    public void test() {
      List<String> x = new ArrayList<>();
      x.add("a");
      x.add("b");
      x.add("c");
      x.removeAll(Arrays.asList("2", "1"));
      System.out.println(x);
    }
  }
