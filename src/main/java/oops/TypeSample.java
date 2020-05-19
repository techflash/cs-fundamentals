package oops;

public class TypeSample {

  static interface I {

    void hello();
  }

  static class ABC implements I {

    @Override
    public void hello() {
      System.out.println("x");
    }
  }

  public static void main(String[] args) {
    new ABC() {
      @Override
      public void hello() {
        System.out.println("y");
      }
    }.hello();
  }
}
