package org.example.SlidingWindow_TwoPointer;

public class LeetCode1493 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int right = 0, left = 0, count = 1, maxLen = 0;
        while (right < nums.length){
            if(nums[right] == 0)
                count--;
            while (count < 0 && left <= right){
                if(nums[left] == 0)
                    count++;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen - 1;
    }
}
