package generics;

class A{
    static <A extends Number> Number add(A a, A b){
        return a.doubleValue() + b.doubleValue();
    }
}
public class Generic1 {

    public static void main(String[] args) {
        System.out.println(A.add(10.3, 30.3));
        System.out.println(A.add(10, 30));

    }

}
