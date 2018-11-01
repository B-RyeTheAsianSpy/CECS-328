package pkg_1;

import java.util.Random;
import java.util.Scanner;

public class PartB {
    /**
     * T(n) = O(n)
     *
     * @param a - the array that we are finding a key in
     * @param key - the value we are searching for in the array
     * @return the index of the key, else -1
     */
    public static int linearSearch(int[] a, int key){
        int answer = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key){
                answer = i;
            }
        }
        return answer;
    }

    /**
     * T(n) = O(log(n))
     *
     * @param a - the array that we are finding a key in
     * @param key - the value we are searching for in the array
     * @return the index of the key, else -1
     */
    public static int binarySearch(int[] a, int key){
        int p = 0, r = a.length-1;
        while (p <= r){
            int q = (p + r) / 2;
            if (a[q] == key) return q;
            if (a[q] > key) r = q - 1;
            else p = q + 1;
        }
        return -1;
    }

    /**
     *
     * @param a - the array that we are sorting
     */
    public static void selectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]) min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     *
     * @return a random number between -1000 and 1000
     */
    public static int randInt(){
        int min = -1000, max = 1000;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args) {
        // user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a positive integer: ");
        int n = sc.nextInt();

        // create an array with size of n, the value that the user put
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            // generates a random number between -1000 and 1000 and puts in array
            a[i] = randInt();
        }

        // sorts array using selection sort
        selectionSort(a);

        // Using linear search
        long startTime = System.nanoTime();
        linearSearch(a, 500000000);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println("\nThe worst case scenario for linear search is " + elapsedTime + " nanoseconds");
        System.out.println("The estimated runtime for one single step is " + (elapsedTime / n) + " nanoseconds");

        // time it takes to run one step
        long temp = elapsedTime / n;

        // convert nanoseconds to seconds
        double seconds =  (temp * 0.000000001);

        // time it takes to run one step when input size is 10^7
        seconds = (seconds / n) * 10000000;
        System.out.println("Time it takes to run an array with size 10^7: " + seconds + " seconds\n");

        // Using binary search
        long startTime2 = System.nanoTime();
        binarySearch(a, 50000000);
        long endTime2 = System.nanoTime();
        elapsedTime = endTime2 - startTime2;

        System.out.println("The worst case scenario for binary search is " + elapsedTime + " nanoseconds");
        System.out.println("The estimated runtime for one single step is " + (elapsedTime / (Math.log(n) / Math.log(2))) + " nanoseconds");

        double t = elapsedTime / (Math.log(n) / Math.log(2));
        seconds =  (t * 0.000000001);
        seconds = (seconds / n) * 10000000;
        System.out.println("Time it takes to run an array with size 10^7: " + seconds + " seconds");


    }


}
