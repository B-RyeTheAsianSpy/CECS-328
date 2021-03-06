import java.util.Random;
import java.util.Scanner;

public class QuickSelectRunner {

    /**
     * takes an array and partitions it. A value for the pivot is chosen and is placed in the middle, where values less
     * than it are on the left side, and values greater than it are on the right side
     *
     * @param a - the array to be partitioned
     * @param left - the leftmost element in the array
     * @param right - the rightmost element in the array
     * @return the pivot
     */
    public static int partition(int a[], int left, int right){
        // choosing the right most element as our pivot
        int pivot = a[right], i = left;

        // j starts from the first element, then traverses through the end
        for (int j = left; j <= right -1; j++){
            // if the pivot is greater than or equal to the a[j], then swap the two values
            if (a[j] <= pivot){
                swap(i, j, a);
                i++;

            }
        }
        // eventually, the pivot will be swapped to the position after i
        swap(i, right, a);

        return i;
    }

    /**
     * algorithm used to find the kth smallest element in an unsorted array
     *
     * @param a - array
     * @param left - leftmost index
     * @param right - rightmost index
     * @param k - kth smallest integer
     * @return - the array which contains the kth smallest integer
     */
    public static int quick_select(int a[], int left, int right, int k){

        // if the array has one element
        if (left == right) return a[left];

        int pivot = partition(a, left, right);

        // if the pivot is at the kth element, then return its value
        if (k == pivot) return a[k];

        // if k is on the "left" array, then call quick_select on the "left" array
        else if(k < pivot) return quick_select(a, left, pivot - 1, k);

        // if k is on the "right" array, then call quick_select on the "right" array
        else return quick_select(a, pivot + 1, right, k);

    }

    /**
     *
     * @return - random integer between -100 and 100
     */
    public static int randInt(){
        int min = -100, max = 100;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * method used to swap elements in the array
     * @param i - index i
     * @param j - index j
     * @param a - the array
     */
    public static void swap(int i, int j, int a[]){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * @author - Brian Nguyen
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = randInt();
            System.out.print(a[i] + " ");
        }
        System.out.print("\nEnter k: ");
        int k = in.nextInt();
        System.out.println(quick_select(a, 0, a.length -1, k));
    }

}
