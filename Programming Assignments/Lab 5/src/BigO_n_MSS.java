import java.util.Random;
import java.util.Scanner;

public class BigO_n_MSS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int a[] = new int [n];
        for (int i = 0; i < a.length; i++) {
            a[i] = randInt();
            System.out.print(a[i] + " ");
        }

        System.out.println("\nMSS: "+ MSS(a));
    }
    public static int randInt(){
        int min = -100, max = 100;

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static int MSS(int a[]){
        int max_sum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if(sum > max_sum) max_sum = sum;

            else if (sum < 0) sum = 0;
        }
        return max_sum;
    }

}
