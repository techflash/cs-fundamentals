package algo.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {32, 232, 23, 23432, 234, 99934};

    for (int i = array.length; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }

    System.out.println(Arrays.toString(array));
  }

}
