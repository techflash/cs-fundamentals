package arrays;

public class FindMaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{12, 10, 15, 7, 8, 5}));
    }

    public static int maxProfit(int[] arr) {
        int maxI = 0;
        int minI = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[maxI] < arr[i]) {
                maxI = i;
            }
        }

        for (int i = 1; i < maxI; i++) {
            if (arr[minI] > arr[i]) {
                minI = i;
            }
        }

        return arr[maxI] - arr[minI];
    }
}
