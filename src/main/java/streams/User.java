package streams;

import java.util.List;

public class User {
    private String name;
    private Integer age;
    private List<String> cellNumbers;

    public User() {
    }

    public User(String name, Integer age, List<String> cellNumbers) {
        this.name = name;
        this.age = age;
        this.cellNumbers = cellNumbers;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getCellNumbers() {
        return cellNumbers;
    }

    public void setCellNumbers(List<String> cellNumbers) {
        this.cellNumbers = cellNumbers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cellNumbers=" + cellNumbers +
                '}';
    }
}
