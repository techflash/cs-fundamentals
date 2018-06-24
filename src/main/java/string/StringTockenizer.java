package string;

import java.util.StringTokenizer;

public class StringTockenizer {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("my       :name  :is: sunil", ":");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
}