package org.example.Sorting.BubbleSort.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,0,-1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] nums){
        if(nums.length <= 1)
            return nums;
        int mid = nums.length / 2;
        int[] leftArr = mergeSort(Arrays.copyOfRange(nums, 0 , mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(leftArr, rightArr);
    }

    static int[] merge(int[] first, int[] second){
        int i=0, j=0, k=0;
        int[] result = new int[first.length + second.length];
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < first.length){
            result[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            result[k] = second[j];
            j++;
            k++;
        }
        return result;
    }
}
