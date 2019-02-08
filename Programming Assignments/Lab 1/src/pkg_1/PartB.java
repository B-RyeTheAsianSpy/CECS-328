package pkg_1;

import java.util.Random;
import java.util.Scanner;

public class PartB {

    /**
     * Lab 1, Part B - Calculating the worst case time for linear search and binary search
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a positive integer: ");
        int n = sc.nextInt();
        int a[] = new int[n];

        populateArray(a, n);
        selectionSort(a);
        linearRunner(a, n);
        System.out.println();
        binaryRunner(a, n);

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
        // returns the value of the key, else -1 if not found
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

    /**
     *
     * @param arr - array used
     * @param a - element a
     * @param b - element b
     */
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
     * calculates the average time of linear search for 100 iterations
     * @param a
     */
    public static void linearRunner(int[] a, int n){

        // Using linear search 100 times and finding the average of the runtime
        long startTime = System.nanoTime();
        int key = 500000;
        linearSearch(a, key);

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        System.out.println("The time to run linear search once is is " + elapsedTime);
        double average = 1 / (double)n;
        System.out.println("The time it takes to run one single step using linear search is " + average + " seconds");
        double large = 10000000; // 10^7
        double worstCase = (average / (double)n ) * large * 1000000000; // convert to seconds
        System.out.println("The worst case runtime for linear search is " + worstCase + " seconds");


    }

    /**
     * calculates the average time of binary search for 100 iterations
     * @param a - array used in binary search
     */
    public static void binaryRunner(int a[], int n){

        int key = 5000000;
        long startTime = System.nanoTime();

        binarySearch(a, key);

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        System.out.println("The time to run binary search once is " + elapsedTime);
        double average = 1 / Math.log(n);
        System.out.println("The time it takes to run one single step using binary search is " + average + " seconds");

        double large = 10000000; // 10^7
        // based off of # 3
        double worstCase = ((average / Math.log((double)n )) * Math.log(large)) * 1000000000; // convert to seconds
        System.out.println("The worst case runtime for binary search is " + worstCase + " seconds");


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
