package algo.sorting;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] array = {32, 11, 232, 23, 23432, 234, 99934};

    for (int i = 1; i < array.length; i++) {
      int hole = i;
      int value = array[hole];

      while (hole > 0 && array[hole - 1] > value) {
        array[hole] = array[hole - 1];
        hole--;
      }
      array[hole] = value;
    }

    System.out.println(Arrays.toString(array));
  }

}
