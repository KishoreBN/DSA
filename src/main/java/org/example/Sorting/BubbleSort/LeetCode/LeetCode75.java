package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode75 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortColors(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i > max)
                max = i;
        }
        int[] frequencyArr = new int[max+1];
        for(int i : nums){
            frequencyArr[i]++;
        }
        int i = 0, j = 0;
        while(i < nums.length){
            while(frequencyArr[j] > 0){
                nums[i] = j;
                i++;
                frequencyArr[j]--;
            }
            j++;
        }
    }
}
