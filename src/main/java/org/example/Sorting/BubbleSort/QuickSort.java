package org.example.Sorting.BubbleSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,-1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] nums, int low, int high){
        if(low >= high)
            return;
        int start = low, last = high;
        int mid = start + (last - start)/2;
        int pivot = nums[mid];
        while(start <= last){
            while(nums[start] < pivot)
                start++;
            while(nums[last] > pivot)
                last--;
            if(start <= last){
                int temp = nums[start];
                nums[start] = nums[last];
                nums[last] = temp;
                start++;
                last--;
            }
        }
        quickSort(nums, low, last);
        quickSort(nums, start, high);
    }
}
