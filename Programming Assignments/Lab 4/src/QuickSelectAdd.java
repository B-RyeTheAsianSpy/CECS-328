import java.util.Random;
import java.util.Scanner;

public class QuickSelectAdd {

    public static int partition(int a[], int left, int right){
        int x = a[right], i = left;
        for (int j = left; j <= right - 1; j++){
            if (a[j] <= x){
                swap(i, j, a);
                i++;
            }
        }
        swap(i, right, a);

        return i;
    }
    public static int quick_select(int a[], int left, int right, int k){


        if (left == right) return a[left];

        int pivot = partition(a, left, right);

        if (k == pivot) return a[k];

        else if(k < pivot){
            return quick_select(a, left, pivot - 1, k);
        }
        else return  quick_select(a, pivot + 1, right, k);

    }
    public static int randInt(){
        int min = -100, max = 100;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public static void swap(int i, int j, int a[]){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

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
