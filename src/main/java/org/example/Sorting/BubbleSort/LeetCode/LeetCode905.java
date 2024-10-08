package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode905 {
    public static void main(String[] args) {
        int[] nums = {0,2};
        sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }

    static int[] sortArrayByParity(int[] nums) {
        int start = 0, last = nums.length - 1;
        while(start < last){
            while(start < nums.length && (nums[start] & 1) != 1)
                start++;
            while(last > 0 && (nums[last] & 1) == 1)
                last--;
            if(start <= last){
                int temp = nums[start];
                nums[start] = nums[last];
                nums[last] = temp;
                start++;
                last--;
            }
        }
        return nums;
    }
}
