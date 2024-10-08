package org.example.Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] nums, int index){
        if(index >= nums.length)
            return;
        int max = 0, j=0;
        while(j < nums.length - index){
            if(nums[j] > nums[max])
                max = j;
            j++;
        }
        int temp = nums[nums.length - 1 - index];
        nums[nums.length - 1 - index] = nums[max];
        nums[max] = temp;
        sort(nums, ++index);
    }
}
