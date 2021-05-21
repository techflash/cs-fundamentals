package collection;

import java.util.Arrays;
import java.util.List;

public class ListSort {

  public static void main(String[] args) {

    List<Integer> unsortedList1 = Arrays.asList(10, 3, 4, 11, 222, 33);
    List<Integer> unsortedList2 = Arrays.asList(3, 33, 10, 222, 4, 11);

    unsortedList1.sort((a, b) -> {
      Integer pos1 = unsortedList2.indexOf(a);
      Integer pos2 = unsortedList2.indexOf(b);
      return pos1.compareTo(pos2);
    });

    System.out.println(unsortedList1);
  }


  public void sortListAsPerOther(List<Integer> listToBeSorted, List<Integer> listAsPerSort) {
    if (listAsPerSort.isEmpty() && listToBeSorted.isEmpty()
        && listToBeSorted.size() != listAsPerSort.size()) {
      return;
    }

    for (int i = 0; i < listToBeSorted.size(); i++) {
      int targetIndex = listAsPerSort.indexOf(listAsPerSort.get(i));

    }
  }
}
