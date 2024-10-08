package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static void main(String[] args) {
        System.out.println(minWindow("a","a"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c : t.toCharArray()){
            if(tMap.get(c) == null)
                tMap.put(c, 1);
            else
                tMap.put(c, tMap.get(c) + 1);
        }
        int right = 0, left = 0, minSubarray = Integer.MAX_VALUE, minLeft = 0, minRight = -1;
        while (right < s.length()){
            if(sMap.get(s.charAt(right)) == null)
                sMap.put(s.charAt(right), 1);
            else
                sMap.put(s.charAt(right), sMap.get(s.charAt(right)) + 1);
            while (compareHashMap(tMap, sMap)){
                if((right - left + 1) < minSubarray) {
                    minSubarray = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return s.substring(minLeft, minRight + 1);
    }

    public static boolean compareHashMap(HashMap<Character, Integer> a, HashMap<Character, Integer> b){
        for(Map.Entry<Character, Integer> set : a.entrySet()){
            if(b.get(set.getKey()) == null || b.get(set.getKey()) < set.getValue())
                return false;
        }
        return true;
    }
}
