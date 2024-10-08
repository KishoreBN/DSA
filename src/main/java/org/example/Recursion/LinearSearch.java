package org.example.Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(search(nums, -1));
    }

    static int search(int[] nums, int target){
        return helper(nums, target,0);
    }

    static int helper(int[] nums, int target, int i){
        if(i >= nums.length)
            return -1;
        if(nums[i] == target)
            return i;
        return helper(nums, target, i + 1);
    }
}
