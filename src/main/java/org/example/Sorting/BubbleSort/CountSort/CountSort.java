package org.example.Sorting.BubbleSort.CountSort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {4,5,6,1,2,5,6,1};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void countSort(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i > max)
                max = i;
        }
        int[] frequnecyArr = new int[max+1]; //Since the numbers would be from 0...max
        for(int i : nums){
            frequnecyArr[i]++;
        }
        int i = 0, j = 0;
        while(i<nums.length){
            while(frequnecyArr[j]>0){
                nums[i] = j;
                frequnecyArr[j]--;
                i++;
            }
            j++;
        }
    }
}
