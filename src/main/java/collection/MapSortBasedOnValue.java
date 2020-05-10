package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapSortBasedOnValue {
    public static void main(String[] args) {
        Map<Employee, Integer> map = new HashMap<>();

        map.put(new Employee("sunil", 101), 1);
        map.put(new Employee("ramesh", 102), 3);
        map.put(new Employee("pravin", 103), 4);
        map.put(new Employee("umesh", 103), 2);


        System.out.println("Unsorted :");
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey().getName() + " : " + entry.getValue()));

        // sort the map
        SortedSet<Map.Entry<Employee, Integer>> sortedSet = sortMap(map);
        System.out.println("Sorted :");
        sortedSet.stream().forEach(entry -> System.out.println(entry.getKey().getName() + " : " + entry.getValue()));

    }

    private static SortedSet<Map.Entry<Employee, Integer>> sortMap(Map<Employee, Integer> map) {
        SortedSet<Map.Entry<Employee, Integer>> sortedSet = new TreeSet<>(
                (o1, o2) ->
                        o1.getValue().equals(o2.getValue()) ? 0
                                : (o1.getValue() > o2.getValue() ? 1 : -1));

        sortedSet.addAll(map.entrySet());
        return sortedSet;
    }

    static class Employee {
        private String name;
        private Integer id;

        public Employee(String name, Integer id) {
            this.name = name;
            this.id = id;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

}
