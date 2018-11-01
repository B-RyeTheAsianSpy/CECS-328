package pkg_1;

import java.util.Random;
import java.util.Scanner;

public class PartA {

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

        // Using linear search 100 times and finding the average of the runtime
        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {

            //generates a random number and uses it as a key. If the random number is negative, * -1
            int key = randInt();
            if (key < 0){
                key *= -1;
            }
            linearSearch(a, key);
        }
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        System.out.println("The average time for running linear search 100 times is " + elapsedTime / 100 + " nanoseconds.");

        // Using binary search 100 times and finding the average of the runtime
        long startTime2 = System.nanoTime();
        for (int j = 0; j < 100; j++){
            //generates a random number and uses it as a key. If the random number is negative, * -1
            int key = randInt();
            if (key < 0){
                key *= -1;
            }
            binarySearch(a, key);
        }
        long endTime2 = System.nanoTime();
        long elapsedTime2 = (endTime2 - startTime2);

        System.out.println("The average time for running binary search 100 times is " + elapsedTime2 / 100 + " nanoseconds.");

    }
}
