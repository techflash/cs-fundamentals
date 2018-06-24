package overriding;


interface I {
    void doWork();

    String toString();

}

class X implements I {

    @Override
    public void doWork() {
        System.out.println("Doing something...");
    }
}

public class InterfaceCheck {

    public static void main(String[] args) {
        I i = new X();
        i.doWork();

        System.out.println(i.toString());
    }
}
