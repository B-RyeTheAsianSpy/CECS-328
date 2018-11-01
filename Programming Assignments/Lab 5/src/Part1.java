import java.util.Random;
import java.util.Scanner;

public class Part1 {

    /**
     * @author - Brian Nguyen
     * @since - 11/1/18
     * @param args
     */
    public static void main(String[] args) {
        int a[] = input();
        populateArray(a);
        printArray(a);
        System.out.println("\nThe maximum sum is " + mss(a));
    }

    /**
     * Maximum subsequence sum - finds the largest sum in the array using one for loop
     * Runtime: O(n)
     * @param a - the array to find the maximum subsequence sum
     * @return the max sum
     */
    public static int mss(int[] a){

        int max_sum = 0;
        int sum = 0;
      
        return max_sum;
    }

    /**
     *
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
       
    }

    /**
     * the user inputs array size n, which will create a new array with that size
     * @return - array with size n
     */
    public static int[] input(){
        
    }
}

