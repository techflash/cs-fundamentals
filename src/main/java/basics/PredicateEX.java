package basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Employee {

  String name;
  Roles role;

  public Employee(String name, Roles role) {
    this.name = name;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }
}

enum Roles {
  MANAGER,
  ENGINEER
}

public class PredicateEX {
 static Map<Predicate<Roles>, Consumer<Employee>> map = Collections.unmodifiableMap(
      new HashMap<Predicate<Roles>, Consumer<Employee>>() {
        {
          put(isIn(Roles.MANAGER), PredicateEX::greetEmp);
          put(isIn(Roles.ENGINEER), PredicateEX::abuseEmp);
        }
      }
  );

  public static void main(String[] args) {
    getGreeting(new Employee("werewr", Roles.ENGINEER));
    getGreeting(new Employee("4r345", Roles.MANAGER));
  }

  private static void getGreeting(Employee employee) {
    map.entrySet()
        .stream()
        .filter(e -> e.getKey().test(employee.role))
        .findAny()
        .ifPresent(e -> e.getValue().accept(employee));
  }

  public static Consumer<Employee> greetManager(Employee employee) {
    return PredicateEX::greetEmp;
  }

  private static void greetEmp(Employee e) {
    System.out.println("Hello " + e.getName());
  }

 private static void abuseEmp(Employee e) {
    System.out.println("Asshole " + e.getName());
  }

  public static Predicate<Roles> isIn(Roles... values) {
    return (Arrays.asList(values)::contains);
  }

}
