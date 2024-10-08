package org.example.SlidingWindow_TwoPointer;

public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int right = 0, left = 0, minLen = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= target){
                if(minLen > (right - left + 1))
                    minLen = right - left + 1;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
