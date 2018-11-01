import java.util.Scanner;

public class Question1 {
    /**
     * @author Brian Nguyen
     * @since 10/11/18
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = in.nextInt();
        System.out.println(squareRoot(n));
    }

    /**
     * Using the fundamentals of the binary search algorithm, we are solving the square root of an integer n.
     * The function creates an "imaginary array" and constantly returns the midpoint from the range of 0 to n,
     *
     * until the midpoint contains the answer
     * @param n - integer value that the algorithm is finding the square root of
     * @return the square root of our value n
     */
    public static int squareRoot(int n){


        if (n < 1) return 0;

        // p is the first index of the "array", q is the midpoint, r is the last
        int p = 0, r = n, q = (p + r) / 2;;

        while (p <= r){
            q = (p + r) / 2;
            // COMMENT / UNCOMMENT STATEMENT TO SEE HOW ALGORITHM DIVIDES AND CONQUERS
            System.out.println(q);
            // if the midpoint of the "array" is the answer, return the midpoint
            if ((q*q) == n) return q;
            if ((q*q) > n) r = q - 1;
            else p = q + 1;
        }
        // returns the ceiling value of our final element q if q*q != n
        return q+1;
    }


}