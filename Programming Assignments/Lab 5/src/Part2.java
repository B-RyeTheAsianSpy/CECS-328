import java.util.Random;
import java.util.Scanner;

public class Part2 {

    /**
     * @author - Brian Nguyen
     * @since - 11/1/18
     * @param args
     */
    public static void main(String[] args) {
        int[] a  = input();
        populateArray(a);
        printArray(a);
        System.out.println("\nThe maximum sum is " + mss(a, 0, a.length - 1));
    }
    /**
     * Maximum subsequence sum - finds the largest sum in the array using divide-and-conquer method
     * Runtime: O(nlogn)
     * @param a - the array to find the maximum subsequence sum
     * @return the max sum
     */
    public static int mss(int [] a, int low, int high){

        // if there is only one element in the array
        if (high == low) return a[low];

        else{
            printArray(a);
            int mid = (low + high) / 2; // dividing the arrays
            int left_sum = mss(a, low, mid);
            int right_sum = mss(a, mid + 1, high);
            int cross_sum = mssCrossSum(a, low, mid, high);

   

        }
    }

    /**
     * method used to find the summ in a subarray
     * @param a - array
     * @param low - first element in the subarray
     * @param mid - middle element in the subarray
     * @param high - last element in the subarray
     * @return the sum of the right side and the left side
     */
    public static int mssCrossSum(int a[], int low, int mid, int high){
        int left_sum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= low; i--){
            
        }
        int right_sum = Integer.MIN_VALUE; sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            
        }
        return left_sum + right_sum;
    }
    /**
     * @return a random integer between -100 and 100
     */
    public static int randInt(){
        int min = -100, max = 100;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    /**
     * method to print an array
     *
     * @param a - array to be printed
     */
    public static void printArray(int a[]){
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }
    /**
     * uses the randInt() function and populates an array with random integers
     * @param a
     */
    public static void populateArray(int [] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = randInt();
        }
    }
    /**
     * the user inputs array size n, which will create a new array with that size
     * @return - array with size n
     */
    public static int[] input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer n: "); int n = in.nextInt();
        int[] a = new int[n];
        return a;
    }
}
