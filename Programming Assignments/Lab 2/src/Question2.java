import java.util.Scanner;

public class Question2 {

    /**
     * Given an array of sorted 0's and 1's, we are finding the index of where the split
     * between the two numbers occur
     *
     * @param a - the array that we are searching for the split
     * @return the index where the split occurs
     */
    public static int binarySearch(int a[]){
        // p is the first element of the array, r is the last element
        int p = 0, r = a.length - 1;
        while(p <= r){
           
        }
        return -1;
    }

    /**
     * @author Brian Nguyen
     * @since 10/11/18
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of your array: ");
        int n = in.nextInt();
        int[] a = new int[n];

        System.out.println("Enter a positive amount of starting zeroes: ");
        int k = in.nextInt();
        while (k > n){
            System.out.print("Please enter a number less than your array size: ");
            k = in.nextInt();
        }

        // populate the array with leading 0's
        for (int i = 0; i <= k; i++) {
            a[i] = 0;
        }
        // populate the rest of the array with 1's
        for (int i = k; i < n; i++) {
            a[i] = 1;
        }

        // printing the array
        System.out.println("Your array:");
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
        System.out.println("\nThe zeroes and ones split at k = " + binarySearch(a));
    }
}
