package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode922 {
    public static void main(String[] args) {
        int[] nums = {2,3};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));;
    }
    static int[] sortArrayByParityII(int[] nums) {
        int oddNum = 1, evenNum = 0;
        while(oddNum<nums.length && evenNum<nums.length){
            while(oddNum < nums.length && (nums[oddNum] & 1)==1)
                oddNum = oddNum + 2;
            while(evenNum < nums.length && (nums[evenNum] & 1)==0)
                evenNum = evenNum + 2;
            if(oddNum<nums.length && evenNum<nums.length) {
                swap(nums, oddNum, evenNum);
            }
            oddNum = oddNum + 2;
            evenNum = evenNum + 2;
        }
        return nums;
    }

    static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
