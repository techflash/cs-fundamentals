package interview.jalando;

class Solution {

  public static void main(String[] args) {
    solution(new String[]{"A...", "...X", "^..."});
  }

  public static boolean solution(String[] B) {

    // convert into matrix
    String arr[][] = new String[B.length][B.length];
    for (int i = 0; i < B.length; i++) {
      arr[i] = B[i].split("");
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    return false;
  }

}
