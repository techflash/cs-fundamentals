package general;

import java.util.Objects;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class ClassesAndObjects {

  public interface Abc {

  }

  class Xyz implements Abc {

  }

  class People {

  }

  public boolean test(Class<?> providers) {
    return Xyz.class.isAssignableFrom(providers);
  }

  @Test
  public void testAssigning() {
    System.out.println(Objects.equals(
        "2",
        "2"));
  }

  class A {

    private int x;

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }
  }

  class B extends A {

    private int y;

    public int getY() {
      return y;
    }

    public void setY(int y) {
      this.y = y;
    }

    @Override
    public String toString() {
      return "B{" +
          "x=" + getX() +
          ", y=" + y +
          '}';
    }
  }

  @Test
  public void testSomethingPleasse() {

    ModelMapper modelMapper = new ModelMapper();

    B b = new B();

    b.setY(10);
    b.setX(20);

    A a = b;

    B b2 = new B();
    modelMapper.map(a, b2);

    System.out.println(b2.toString());

  }

  @Test
  public void testSomethingPlease2() {
    System.out.println("");
  }

}
