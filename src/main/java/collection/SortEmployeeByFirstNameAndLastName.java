package collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class Emp {

    private Dept dept;
    private String firstName;
    private String lastName;

    public Emp(Dept dept, String firstName, String lastName) {
        this.dept = dept;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp emp = (Emp) o;

        if (dept != emp.dept) return false;
        if (firstName != null ? !firstName.equals(emp.firstName) : emp.firstName != null) return false;
        return lastName != null ? lastName.equals(emp.lastName) : emp.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = dept != null ? dept.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public enum Dept {
        SALES,
        MARKETING,
        IT
    }
}

public class SortEmployeeByFirstNameAndLastName {
    public static void main(String[] args) {

        SortedSet<Emp> emp = new TreeSet<>(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                Emp that = o2;

                if (o1.getDept().name().compareTo(that.getDept().name()) == 0) {
                    return o1.getFirstName().compareTo(that.getFirstName()) == 0 ?
                            (o1.getLastName().compareTo(that.getLastName()) == 0
                                    ? 0 : o1.getLastName().compareTo(that.getLastName())) : o1.getFirstName().compareTo(that.getFirstName());
                }
                return o1.getDept().name().compareTo(((Emp) that).getDept().name());
            }
        });

        emp.add(new Emp(Emp.Dept.IT, "sunil", "vishwakarma"));
        emp.add(new Emp(Emp.Dept.MARKETING, "sunil", "sharma"));
        emp.add(new Emp(Emp.Dept.SALES, "amol", "palkar"));
        emp.add(new Emp(Emp.Dept.SALES, "amol", "katkar"));

        System.out.println(emp);
    }
}
