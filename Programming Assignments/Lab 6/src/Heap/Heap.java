package Heap;

public class Heap {

    /**
     *
     * @param i - index of node
     * @return the parent node
     */
    public int parent(int i){
        return i;
    }

    /**
     *
     * @param i - index of node
     * @return the left child
     */
    public int leftChild(int i){
        return (2 * i) + 1;
    }

    /**
     *
     * @param i - index of node
     * @return the right child
     */
    public  int rightChild(int i){
        return (2 * i) + 2;
    }

    /**
     * algorithm to build a max heap
     * @param a - array used in making the max heap
     */
    public void build_max_heap(int[] a){
        int n = a.length;
        for (int i = n /2 - 1; i >= 0; i--) {
            max_heapify(a, n, i);
        }
    }

    /**
     * algorithm used to sort the array
     * @param a - array
     */
    public void heapSort(int a[]){

        int n = a.length;
        build_max_heap(a);
        for (int i = n - 1; i >= 0; i--){
            swap(a, 0, i);
            max_heapify(a, i, 0);
        }
    }

    /**
     * algorithm used to make a heap into a max heap
     * @param a - array
     * @param n - size of array
     * @param i - index position
     */
    public  void max_heapify(int a[], int n, int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int parent = parent(i);

        // if the left child node's value is greater that its parent's
        if (left < n && a[left] > a[i]){
            parent = left;
        }
        // if the right child node's value is greater than its parent's
        if (right < n && a[right] > a[parent]){
            parent = right;
        }
        if (parent != i){
            int temp = a[i];
            a[i] = a[parent];
            a[parent] = temp;
            max_heapify(a, n, parent);
        }
    }
    public void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
