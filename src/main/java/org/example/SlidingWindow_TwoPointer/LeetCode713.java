package org.example.SlidingWindow_TwoPointer;

public class LeetCode713 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(numSubarrayProductLessThanK(nums, 1));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int right = 0, left = 0, count = 0, product = 1;
        while (right < nums.length){
            product *= nums[right];
            while (product >= k && left <= right){
                product /= nums[left];
                left++;
            }
            if(right >= left) {
                count += right - left + 1;
            }
            right++;
        }
        return count;
    }
}
