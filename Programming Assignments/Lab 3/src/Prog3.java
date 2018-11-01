import java.util.Random;
import java.util.Scanner;

public class Prog3 {

    public static void insertionSort(int[] a){

        int unsorted = 1;
        while(unsorted < a.length){
            int hold = a[unsorted];
            int i = unsorted - 1;
            while ((i >= 0) && (hold < a[i])){
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = hold;
            unsorted += 1;
        }

    }

    public static int randInt(){
        int min = -5000, max = 5000;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array (n): ");
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            // generates a random number between -1000 and 1000 and puts in array
            a[i] = randInt();
        }
        long startTime = System.nanoTime();
        insertionSort(a);
        long endTime = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n" + (endTime - startTime) + " nanoseconds");

    }
}
