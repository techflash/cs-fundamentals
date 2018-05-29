package overriding;

import java.util.ArrayList;
import java.util.List;

class P{

    public void m1(List<String> stringList) throws ArithmeticException, InterruptedException {
        System.out.println("in P's m1");
    }

    public static void m2() throws ArithmeticException{
        System.out.println("static P");
    }
    static public int a = 1;
}

public class A extends P {
   static public int a = 2;

    public static void m2() throws RuntimeException{
        System.out.println("static A");
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        P p = new A();
        p.m1(new ArrayList<String>());

        p.m2();

        System.out.println(p.a);
    }

    public void m1(ArrayList<String> stringList) throws Exception {
        System.out.println("in A's m1");
    }
}

