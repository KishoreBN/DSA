package org.example.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] nums, int index){
        if(index > nums.length)
            return;
        int j = 1;
        while(j < nums.length - index) {
            if(nums[j - 1] > nums[j]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
            j++;
        }
        sort(nums, ++index);
    }
}
