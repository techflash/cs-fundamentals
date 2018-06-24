public abstract class Test {
    private static StringBuilder resu = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(canAssign(Object.class));

//        System.out.println(conv(10));
    }


    private static String conv(int no) {
        if (no <= 0) return "0";
        int s = no % 2;
        conv(no / 2);
        return resu.append(s).toString();

    }

    private static boolean canAssign(Class clazz) {
        return Test.class.isAssignableFrom(clazz);
    }
}
