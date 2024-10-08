package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode1695 {
    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0, maxSum = 0, sum = 0;
        while (right < nums.length){
            sum += nums[right];
            if(map.get(nums[right]) == null)
                map.put(nums[right], 1);
            else
                map.put(nums[right], map.get(nums[right]) + 1);
            while (map.get(nums[right]) > 1){
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            maxSum = Math.max(maxSum, sum);
            right++;
        }
        return maxSum;
    }
}
