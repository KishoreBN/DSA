package org.example.Sorting.BubbleSort.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int max = maxIndex(arr, 0, arr.length - i);
            swap(arr, max, arr.length - 1 -i);
        }
    }

    static int maxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i=start; i<end; i++){
            if(arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
