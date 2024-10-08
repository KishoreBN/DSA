package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode1004 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(helper(nums, 3));
    }

    /**
     * Time complexity: O(2N) ~= O(N)
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        int right = 0, left = 0, maxLength = 0, count = 0;
        while (right < nums.length){
            if(nums[right] == 0){
                count++;
            }
            if(count > k){
                while (count > k){
                    count = nums[left] == 0 ? count - 1 : count;
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static int helper(int[] nums, int k){
        int right = 0, left = 0, maxLength = 0, count = 0;
        while (right < nums.length){
            if(nums[right] == 0)
                count++;
            if(count <= k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            if(count > k){
                count = nums[left] == 0 ? count - 1 : count;
                left++;
            }
            right++;
        }
        return maxLength;
    }
}
