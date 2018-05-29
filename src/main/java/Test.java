public class Test {

    public static void main(String[] args) throws InterruptedException {

        int arr[] = {12, 5, 787, 1, 23};
        int top = 2;
        int max = 0;

        for (int i = 0; i < top; i++) {
            int x = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[x] < arr[j]) {
                    x = j;
                }
            }
            System.out.println(arr[x]);
            arr[x] = Integer.MIN_VALUE;
        }
    }

    private static void m() {
        System.out.println("wtf");
    }


}
