public class hw4prob11 {

    public static int mss(int[] a){
        int max_sum = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > max_sum){
                max_sum = sum;
            }
            else if (sum < 0){
                sum = 0;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int a[] = {7, 2, -14, 38, 52, -37, 4, 12, -4, 6, 3, 2};
        int b[] = {1, -5, 6, -3, 10, -4, 2, 0, 3};
        int c[] = {7, 2, -14, 3, 5, -3, 4};
        int d[] = {3, 6, -20, 11, -15, 26, -43, 10, -14, 27, 0, 39};
        System.out.println(mss(d));
    }
}
