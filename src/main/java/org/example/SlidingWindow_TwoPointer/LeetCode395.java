package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode395 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
    }

    public static int longestSubstring(String s, int k) {
        if(k == 0 || s.length() == 0)
            return 0;
        if(k <= 1)
            return s.length();
        HashMap<Character, Integer> fMap = new HashMap<>();
        int maxLen = 0, index = 0;
        for(char c : s.toCharArray()){
            if(fMap.get(c) == null)
                fMap.put(c, 1);
            else
                fMap.put(c, fMap.get(c));
        }
        while (index < s.length() && fMap.get(s.charAt(index)) >= k)
            index++;
        if(index >= s.length() - 1)
            return index;
        maxLen = Math.max(longestSubstring(s.substring(0, index), k), longestSubstring(s.substring(index + 1, s.length()), k));
        return maxLen;
    }
}
