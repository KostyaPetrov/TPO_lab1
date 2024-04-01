package ru.konstantinpetrov;


public class HeapSort {
    public int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            maxToRoot(arr,n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxToRoot(arr, i, 0);
        }

        return arr;
    }

    public int[] swap(int[] arr, int index1, int index2){
        int a = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = a;
        return arr;
    }

    public void maxToRoot(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[max])
            max = left;

        if (right < n && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swap(arr, i, max);

            maxToRoot(arr, n, max);
        }
    }
}
