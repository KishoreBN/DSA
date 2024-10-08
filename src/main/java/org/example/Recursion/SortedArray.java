package org.example.Recursion;

public class SortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,0,4,5};
        System.out.println(isSorted(nums));
    }

    static boolean isSorted(int[] nums){
        return helper(nums, 0);
    }

    static boolean helper(int[] nums, int i){
        if(i == nums.length - 1)
            return true;
        return nums[i] <= nums[i+1] && helper(nums, i+1);
    }
}
