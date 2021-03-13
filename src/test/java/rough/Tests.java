package rough;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class Tests {

  @Test
  public void testLambdas() {
    int x = 1;
    BooleanSupplier shouldPush = () -> x == 1;
    System.out.println(shouldPush.getAsBoolean());

    Function<Integer, String> concept = (input) -> input + "1";

    String result = concept.apply(10);
    System.out.println(result);

  }

  enum Switch {
    ON,
    OFF
  }

  @Test
  public void someTest() {

    List<Integer> items = Arrays.asList(10, 20, 30)
        .stream()
        .filter(i -> i > 10)
        .collect(Collectors.toList());
    System.out.println(items);
    System.out.println(items.size());
  }

  @Test
  public void immutableTest() {
    System.out.println("".equals(""));
    System.out.println(new ArrayList<>().size());
    Arrays.stream("".split(",")).forEach(System.out::print);
    List<String> lists = Arrays.asList("".split(","));
    System.out.println(lists.get(0));
    System.out.println(lists.size());
    System.out.println(lists == null || lists.isEmpty());
  }


  @Test
  public void enumTest() {
    Switch lightSwitch = Switch.OFF;
    System.out.println(lightSwitch == null);
  }

  @Test
  public void dateTest() throws ParseException {
    Date projectStartDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-24");
    Date projectStartDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-25");

    Date projectEndDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-27");
    Date projectEndDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-28");

    System.out.println(projectStartDate2);
  }

  @Test
  public void testConsumer() {
    List<Integer> evenNumbers = new ArrayList<>();
    collectAllEvens(Arrays.asList(10, 20, 30, 11, 31, 37, 95, 100),
        n -> {
          if (n % 2 == 0) {
            evenNumbers.add(n);
          }
        });
    System.out.println(evenNumbers);
  }

  private static void collectAllEvens(List<Integer> numbers, Consumer<Integer> consumer) {
    numbers.forEach(consumer);
  }

  @Test
  public void flatMap(){
    class Add {
      public String streetName;
      public String city;

      public Add(String streetName, String city) {
        this.streetName = streetName;
        this.city = city;
      }

      @Override
      public String toString() {
        return "Add{" +
            "streetName='" + streetName + '\'' +
            ", city='" + city + '\'' +
            '}';
      }
    }
    class Emp {
      String name;
      List<Add> addresses;

      public Emp(String name, List<Add> addresses) {
        this.name = name;
        this.addresses = addresses;
      }
    }

    class Dept {
      List<Emp> emp;
      public Dept(List<Emp> emp) {
        this.emp = emp;
      }
    }

    Dept dept = new Dept(Arrays.asList(
        new Emp("sunil",
            Arrays.asList(
                new Add("Leibniz", "Berlin"),
                new Add("Bismark", "Berlin"))
            ),
        new Emp("xyz",
            Arrays.asList(
                new Add("abc", "Berlin"),
                new Add("exy", "Berlin"))
            )

    ));

    dept.emp
        .stream()
        .flatMap(emp -> emp.addresses.stream())
        .forEach(
            add -> System.out.println(add)
        );
  }

  @Test
  public void removeAll() {
    char [] x = {'l'};
    List<String> list = new ArrayList<>();
    list.add("1");
    list.removeAll(Arrays.asList("1", "2"));
    System.out.println(list);
  }
}
