package Selection;

import java.util.Random;
import java.util.Scanner;

public class SelectionRunner {
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();

        int a[] = input();
        int rep = 100;
        //i.printArray(a);
        long start = nanosec();
        for (int j = 0; j < rep; j++) {
            populateArray(a);
            s.sort(a);
            printArray(a);
        }
        long end = nanosec();
        long avg = (end - start) / 2;
        System.out.println("The average time for selection sort through " + rep +" repetitions is " + avg + " nanoseconds");
        //i.printArray(a);
    }
    /**
     * populates an array with random integers from -10000 to 10000
     * @param a
     */
    public static void populateArray(int [] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = randInt();
        }
    }
    /**
     *
     * @return random int between -10000 and 10000
     */
    public static int randInt(){
        int min = -10001, max = 10001;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    /**
     *
     * @return - array with size n
     */
    public static int[] input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer n: "); int n = in.nextInt();
        int[] a = new int[n];
        return a;
    }
    /**
     * prints array
     * @param a - array
     */
    public static void printArray(int a[]){
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }
    public static long nanosec(){
        return System.nanoTime();
    }


}
