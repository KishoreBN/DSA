package org.example.SlidingWindow_TwoPointer;

public class LeetCode1248 {
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        System.out.println(numberOfSubarrays(nums, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubArrLessThanEqual(nums, k) - numberOfSubArrLessThanEqual(nums, k - 1);
    }

    public static int numberOfSubArrLessThanEqual(int[] nums, int k){
        if(k < 0)
            return 0;
        int right = 0, left = 0, count = 0, oddCount = 0;
        while (right < nums.length){
            oddCount += ((nums[right] & 1) == 1) ? 1 : 0;
            while (oddCount > k){
                oddCount -= ((nums[left] & 1) == 1) ? 1 : 0;
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
