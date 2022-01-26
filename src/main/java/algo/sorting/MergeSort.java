package algo.sorting;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr2 = {99, 9, 96, 66, 88, 23};
    mergeSort(arr2);
    System.out.println(Arrays.toString(arr2));
  }

  public static void mergeSort(int[] arr) {
    if (arr.length < 2) {
      return;
    }

    int mid = arr.length / 2;
    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];

    System.arraycopy(arr, 0, left, 0, mid);
    System.arraycopy(arr, mid, right, 0, arr.length - mid);

    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);
  }

  public static void merge(int[] left, int[] right, int[] arr) {
    int i, j, k;
    i = j = k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        arr[k] = left[i];
        i++;
      } else if (left[i] > right[j]) {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < left.length) {
      arr[k] = left[i];
      i++;
      k++;
    }

    while (j < right.length) {
      arr[k] = right[j];
      j++;
      k++;
    }

  }
}
