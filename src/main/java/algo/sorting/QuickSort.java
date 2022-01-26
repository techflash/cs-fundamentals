package algo.sorting;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr2 = {99, 9, 96, 66, 88, 23};
    quickSort(arr2, 0, arr2.length-1);
    System.out.println(Arrays.toString(arr2));
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partitionIndex = partition(arr, start, end);
      quickSort(arr, start, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, end);
    }

  }

  public static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int pIndex = start;

    for (int i = start; i < end; i++) {
      if (arr[i] < pivot) {
        swap(arr, pIndex, i);
        pIndex++;
      }
    }
    swap(arr, pIndex, end);
    return pIndex;
  }

  private static void swap(int[] arr, int pIndex, int i) {
    int temp = arr[i];
    arr[i] = arr[pIndex];
    arr[pIndex] = temp;
  }
}
