package org.example.SlidingWindow_TwoPointer;

public class LeetCode862 {
    public static void main(String[] args) {
        int[] nums = {84,-37,32,40,95};
        System.out.println(shortestSubarray(nums, 167));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int right = 0, left = 0, sum = 0, result = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= k && left <= right){
                if(sum >= k && (right - left + 1) < result)
                    result = (right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
