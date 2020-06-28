package collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaMapExamples {

  static class Person {

    public String name;
    public String address;

    public Person(String name, String address) {
      this.name = name;
      this.address = address;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }
  }

  public static void main(String[] args) {
    List<Person> personList = Arrays.asList(new Person("sunil", "Bismark 103"),
        new Person("florien", "Bismark 104"),
        new Person("florien", "New place xyz"),
        new Person("florien", "another place xyz"));

    Map<String, String> phoneBook =
        personList.stream()
            .collect(Collectors.toMap(Person::getName, Person::getAddress, (p1, p2) -> p1 + "," + p2));

    phoneBook.forEach((e1, e2) -> System.out.println(e1 + " " + e2));
  }
}
