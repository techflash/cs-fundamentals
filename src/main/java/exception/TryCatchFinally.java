package exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(exc());
    }

    private static String exc() {
        // 1.
        //        try{
//            f();
//            System.out.println("a");
//            return 1;
//        }catch (RuntimeException e){
//            System.out.println("Exception e");
//            return 2;
//        }finally {
//            return 3;
//        }


        // 2.
//        try {
//            return 10;    //control will not be passed to main() method here
//        } catch (Exception e) {
//            return 20;    //Control will not be passed to main() method here
//        } finally {
//            System.out.println("finally block is always executed");
//
//            //Control will be passed to main() method after executing this block
//        }

// 3.
        String s = null;
        try
        {
            f();
            s = "return value from try block";
            return s;
        }
        catch (Error e)
        {
            s = s + "return value from catch block";
            return s;
        }
        finally
        {
            s = s + "return value from finally block";
        }
    }

    private static void f() {
//        throw new NullPointerException();
        throw new Error();

    }
}
