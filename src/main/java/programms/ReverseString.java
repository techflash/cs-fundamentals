package programms;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("sunil"));
    }

    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));

    }
}