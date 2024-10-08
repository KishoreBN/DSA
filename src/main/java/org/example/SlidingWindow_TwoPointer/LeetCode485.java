package org.example.SlidingWindow_TwoPointer;

public class LeetCode485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, maxLength = 0;
        while (right < nums.length){
            if(nums[right] == 1)
                right++;
            else {
                maxLength = Math.max(maxLength, right - left);
                right++;
                left = right;
            }
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}
