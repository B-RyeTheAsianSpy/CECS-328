package Selection;

public class SelectionSort {
    /**
     * selection sort algorithm
     * @param a
     */
    public void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }

    /**
     * swaps one element in an array with another
     * @param arr
     * @param a
     * @param b
     */
    public void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
