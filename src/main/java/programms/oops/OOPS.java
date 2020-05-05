package programms.oops;


class A{
    void method(){
        System.out.println("shit in a");
    }
}

class B extends A{
    void method(){
        System.out.println("in b");
    }

    void awara(){
        System.out.println("shitting in awara");
    }
}

public class OOPS {

    public static void main(String[] args) {
      A a = new B();
      a.method();

    }
}
