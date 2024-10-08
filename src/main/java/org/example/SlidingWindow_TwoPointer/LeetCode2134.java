package org.example.SlidingWindow_TwoPointer;

public class LeetCode2134 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,0};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int totalOnes = 0, right = 0, left = 0, minSwap = Integer.MAX_VALUE, count = 0;
        for(int i=0; i<nums.length; i++)
            totalOnes += nums[i];
        while (right < nums.length * 2){
            count += nums[right % nums.length];
            if(right - left + 1 > totalOnes){
                count -= nums[left % nums.length];
                left++;
            }
            if(right - left + 1 == totalOnes)
                minSwap = Math.min(minSwap, totalOnes - count);
            right++;
        }
        return minSwap;
    }
}
