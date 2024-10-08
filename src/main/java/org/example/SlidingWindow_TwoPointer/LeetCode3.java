package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(helper("pwwkew"));
    }

    /**
     * Use hashmap to keep a track of the character frequency.
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxlength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            if(map.get(s.charAt(right)) == null){
                map.put(s.charAt(right), 1);
            } else {
                while (map.get(s.charAt(right)) != 0){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                map.put(s.charAt(right), 1);
            }
            maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }
        return maxlength;
    }

    /**
     * Using hashmap to hold the index of characters, Lesser time complexity
     * @param s
     * @return
     */
    public static int helper(String s){
        int right = 0, left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            if(map.get(s.charAt(right)) != null && map.get(s.charAt(right)) >= left){
                left = map.get(s.charAt(right)) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return maxLength;
    }
}
