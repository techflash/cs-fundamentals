package algo.sorting;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] array = {32, 232, 23, 23432, 234};

    System.out.println("length: " + array.length);

    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[i]) {
          min = j;
        }
      }
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }

    System.out.println(Arrays.toString(array));
  }

}
