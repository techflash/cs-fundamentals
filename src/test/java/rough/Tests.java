package rough;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class Tests {

  private boolean myConditions;
  List<Employee> employees = null;

  private class Employee {

    private Integer id;
    private List<Integer> reportsTo;

    public Employee(Integer id, List<Integer> reportsTo) {
      this.id = id;
      this.reportsTo = reportsTo;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public List<Integer> getReportsTo() {
      return reportsTo;
    }

    public void setReportsTo(List<Integer> reportsTo) {
      this.reportsTo = reportsTo;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "id=" + id +
          ", reportsTo=" + reportsTo +
          '}';
    }
  }

  @Test
  public void testLambdas() {
    int x = 1;
    BooleanSupplier shouldPush = () -> x == 1;
//    System.out.println(shouldPush.getAsBoolean());

    Function<Integer, String> concept = (input) -> input + "1";

    String result = concept.apply(10);
//    System.out.println(result);

    BiPredicate<Integer, Boolean> shouldFuck = (age, isHot) -> age > 18 && isHot;
    shouldFuck = shouldFuck.and((hour, inMood) -> hour > 20 && inMood)
        .and((hoursWorked, workCompleted) -> workCompleted);

    System.out.println("Should I fuck: " + (shouldFuck.test(20, true) ? "Yeah" : "Nope"));
  }

  enum Switch {
    ON,
    OFF
  }

  @Test
  public void someTest() {
    if (null == Switch.ON) {
      System.out.println("on");
    } else {
      System.out.println("off");
    }
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
  public void flatMap() {
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
    List<String> list = new ArrayList<>();
    list.add("1");
    list.retainAll(Arrays.asList("1", "2"));
    System.out.println(list);
  }

  @Test
  public void streamTest() {
    List<String> a = new ArrayList<>();
    a.add("1");
    a.add("2");
    a.add("4");
    List<String> b = new ArrayList<>();
    b.add("3");
    b.add("2");

    List<String> joinedList = Arrays.asList(a, b, null)
        .stream()
        .flatMap(x -> Optional.ofNullable(x).orElse(Collections.emptyList()).stream())
        .collect(Collectors.toUnmodifiableList());

    System.out.println(joinedList);

  }


  @Test
  public void test() {
    System.out.println("2367479f-68e3-4975-b2c0-20fd65a185b0.80d8c41a-a538-4138-bced-cce2f24e57a4"
        .split("\\.")[1]);
  }


  @Test
  public void testDate() throws ParseException {
    DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss Z");
    OffsetDateTime projectStartDate1 = OffsetDateTime
        .parse("24-02-2021:05:16:03 -0100", DATE_FORMAT);
//    System.out.println(Date.from(LocalTime.MAX.atDate(projectStartDate1.toLocalDate()).atZone(
//        ZoneId.systemDefault()).toInstant()).toString());

    System.out.println(LocalTime.MAX.atDate(projectStartDate1.toLocalDate()));
    System.out.println(projectStartDate1.toLocalDate().atStartOfDay());
  }

//  public OffsetDateTime date(String shortDateAsString){
//    DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss Z");
//    return shortDateAsString==null? null :
//  }

  @Test
  public void testStuff() {

    Employee manager1 = new Employee(1, Collections.emptyList());
    Employee manager2 = new Employee(2, Collections.emptyList());
    Employee lead1 = new Employee(3, new ArrayList<>());
    Employee lead2 = new Employee(6, new ArrayList<>());
    lead2.getReportsTo().add(lead1.getId());
    lead1.getReportsTo().add(lead2.getId());
    Employee employee1 = new Employee(4, Arrays.asList(lead1.getId()));
    Employee employee2 = new Employee(5, Arrays.asList(lead2.getId(), lead1.getId()));

//    employees = Arrays.asList(manager1, manager2, lead1, lead2, employee1, employee2);
//
//    Set<Employee> subordinates = new HashSet<>();
//    findAllSubordinates(subordinates, lead1);
//
//    System.out.println("Subordinates:" + subordinates);

    System.out.println(
        new ArrayList<Employee>().stream().allMatch(
            employee -> employee.getReportsTo() != null && employee.getReportsTo().size() > 0));
  }

  private void findAllSubordinates(Set<Employee> subs, Employee superior) {
    employees.forEach(employee -> {
      if (employee.getReportsTo().contains(superior.getId())) {
        subs.add(employee);
        findAllSubordinates(subs, employee);
      }
    });
  }
}
