import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Test {

  private static StringBuilder resu = new StringBuilder();

  public static void main(String[] args) {
    List<String> rowIds = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    List<String> toBeDeleted = new ArrayList<>(Arrays.asList("2", "4"));

    List<String> sublist = rowIds.subList(1, rowIds.size());
    sublist.add(rowIds.size() - 1, rowIds.get(0));
    System.out.println(sublist);
  }

  private static void getDocumentPage(int n) {
    System.out.println(n);
  }

  private static String conv(int no) {
      if (no <= 0) {
          return "0";
      }
    int s = no % 2;
    conv(no / 2);
    return resu.append(s).toString();

  }

  private static boolean canAssign(Class clazz) {
    return Test.class.isAssignableFrom(clazz);
  }


}

enum Time {
  GOODTIME,
  BADTIME;

  public static boolean isValidKey(String key) {
    try {
      return Time.valueOf(key) instanceof Time;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}