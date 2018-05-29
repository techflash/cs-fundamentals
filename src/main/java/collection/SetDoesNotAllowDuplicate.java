package collection;

import java.util.HashSet;
import java.util.Set;

public class SetDoesNotAllowDuplicate {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("sunil");
        stringSet.add("sunil");

        System.out.println(stringSet);
    }
}
