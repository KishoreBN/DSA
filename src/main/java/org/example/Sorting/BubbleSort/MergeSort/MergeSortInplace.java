package org.example.Sorting.BubbleSort.MergeSort;

import java.util.Arrays;

public class MergeSortInplace {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,11,2};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] nums, int start, int last){
        if((last - start) <= 1)
            return;
        int mid = start + (last - start) /2 ;
        mergeSort(nums, 0, mid);
        mergeSort(nums, mid, last);
        mergeInplace(nums, start, mid, last);
    }

    static void mergeInplace(int[] nums, int start, int mid, int last){
        int i=start, j=mid, k=0;
        int[] result = new int[last - start];
        while(i<mid && j<last){
            if(nums[i] < nums[j]){
                result[k] = nums[i];
                i++;
            } else{
                result[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            result[k] = nums[i];
            i++;
            k++;
        }
        while(j<last){
            result[k] = nums[j];
            j++;
            k++;
        }
        for(int l=0; l<result.length; l++){
            nums[start + l] = result[l];
        }
    }
}
