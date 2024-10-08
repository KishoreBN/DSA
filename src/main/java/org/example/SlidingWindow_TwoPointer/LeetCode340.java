package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

/**
 * Longest Substring with at most K distinct characters.
 */
public class LeetCode340 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabbcccc", 2));
    }

    public static int longestSubstring(String s, int k){
        int right = 0, left = 0, maxLength = 0, length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            Integer previousVal = map.get(s.charAt(right));
            if(previousVal != null){
                map.put(s.charAt(right), previousVal + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            while (map.size() > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(map.size() <= k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
