package org.example.SlidingWindow_TwoPointer;

public class LeetCode930 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayLessThanEqual(nums, goal) - numSubarrayLessThanEqual(nums, goal - 1);
    }

    public static int numSubarrayLessThanEqual(int[] nums, int goal){
        if(goal < 0)
            return 0;
        int right = 0, left = 0, sum = 0, count = 0;
        while (right < nums.length){
            sum += nums[right];
            while (sum > goal){
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
