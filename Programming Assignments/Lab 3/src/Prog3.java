import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    /**
     * T(n) = O(n^2)
     * @param a
     */
    public static void insertionSort(int[] a) {
        int unsorted = 1;
        while (unsorted < a.length) {
            // the second index in the array
            int hold = a[unsorted];
            int i = unsorted - 1;

            // if the elements after a[i] are less than it
            while ((i >= 0) && (hold < a[i])) {
                // swaps elements
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = hold;

            // goes to the next element
            unsorted = unsorted + 1;
        }
    }

    /**
     * method used to calculate the average running time of insertion sort
     * @param a - array to be sorted
     * @param n - size of array
     */
    public static void insertionRunner(int[] a, int n){
        populateArray(a, n);
        long start = System.nanoTime();
        for (int j = 0; j < 100; j++) {
            insertionSort(a);
            //printArray(a);
        }
        long end = System.nanoTime();
        int test = 100;


        long timeElapsed = end - start;
        long avg = (timeElapsed / test);
        System.out.println("The average of using insertion sort 100 times with size " + n + " is " + avg + " nanoseconds");
        double sec = avg * 0.0000000001;
        sec = 1 / sec;
        double result = Math.sqrt(sec);
        System.out.println("The number of instructions that my laptop can run in a second is " + result);
    }

    /**
     *
     * @return random integer between -5000 and 5000
     */
    public static int randInt() {
        int min = -5000, max = 5000;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * prints an array
     * @param a
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void populateArray(int a[], int n){
        for (int i = 0; i < n; i++) {
            a[i] = randInt();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int n = in.nextInt();
        int a[] = new int[n];
        insertionRunner(a, n);

    }
}
