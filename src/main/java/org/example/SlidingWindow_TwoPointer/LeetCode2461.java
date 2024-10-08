package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode2461 {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(nums, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        long maxSum = 0, sum = 0;
        while (right < nums.length){
            sum += nums[right];
            if(right - left + 1 > k){
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            if(map.get(nums[right]) == null){
                map.put(nums[right], 1);
            } else {
                map.put(nums[right], map.get(nums[right]) + 1);
            }
            while (map.get(nums[right]) > 1){
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            if(right - left + 1 == k)
                maxSum = Math.max(maxSum, sum);
            right++;
        }
        return maxSum;
    }
}
