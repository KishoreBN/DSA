package org.example.Recursion.LeetCode;

public class LeetCode494 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findTargetSumWays(arr,1));
    }

    static int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    static int helper(int[] nums, int target, int sum, int index){
        if(sum == target && index == nums.length){
            return 1;
        }
        if(index >= nums.length){
            return 0;
        }
        return helper(nums, target, sum - nums[index], index + 1) +
        helper(nums, target, sum + nums[index],  index + 1);
    }
}
