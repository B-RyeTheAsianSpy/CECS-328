package pkg_1;

import java.util.Random;
import java.util.Scanner;


public class PartA {
    static int rep = 100;
    /**
     * Lab 1, Part A - Calculating the average time of linear search and binary search
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a positive integer: ");
        int n = sc.nextInt();
        int a[] = new int[n];

        populateArray(a, n);
        selectionSort(a);
        linearRunner(a);
        binaryRunner(a);

    }

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
                break;
            }
        }
        // returns the value of the key, else -1 if not founnd
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
     * T(n) = O(n^2)
     *
     * @param a - the array that we are sorting
     */
    public static void selectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }
    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

    /**
     *
     * @return random integer between 0 and the (length of an array - 1)
     */
    public static int randIntArray(int [] a){
        int min = 0, max = a.length - 1;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * calculates the average time of linear search for 100 iterations
     * @param a
     */
    public static void linearRunner(int[] a){

        // Using linear search 100 times and finding the average of the runtime
        long startTime = System.nanoTime();
        for (int i = 0; i < rep; i++) {

            //generates a random number and uses it as a key
            int key = a[randIntArray(a)];
            linearSearch(a, key);
        }
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        System.out.println("The average time for running linear search 100 times is " + elapsedTime / rep + " nanoseconds.");

    }

    /**
     * calculates the average time of binary search for 100 iterations
     * @param a - array used in binary search
     */
    public static void binaryRunner(int a[]){


        long startTime = System.nanoTime();
        for (int j = 0; j < rep; j++){

            //generates a random number and uses it as a key
            int key = randIntArray(a);
            binarySearch(a, key);
        }
        long endTime = System.nanoTime();
        long elapsedTime2 = (endTime - startTime);

        System.out.println("The average time for running binary search 100 times is " + elapsedTime2 / rep + " nanoseconds.");
    }

    /**
     * populates an array with random integers from -1000 to 1000
     * @param a - the array to be populated
     * @param n - the size of the array
     * @return the array populated with random integers
     */
    public static int[] populateArray(int[] a, int n){
        for (int i = 0; i < n; i++) {
            a[i] = randInt();
        }
        return a;
    }

}
