package org.example.SlidingWindow_TwoPointer;

public class LeetCode1208 {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd","acde",0));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int[] nums = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            nums[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int right = 0, left = 0, maxLen = 0, sum = 0;
        while (right < nums.length){
            sum += nums[right];
            while (sum > maxCost && left <= right){
                sum -= nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
