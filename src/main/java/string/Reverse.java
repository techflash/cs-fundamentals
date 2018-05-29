package string;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("sunil"));
    }

    private static String reverse(String s){
        if(s.length()< 1){
            return s;
        }
        String x = reverse(s.substring(1)) + s.charAt(0);
        System.out.println(" Returned " + x);
        return x;
    }
}
