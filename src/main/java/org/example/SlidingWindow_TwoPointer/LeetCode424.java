package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LeetCode424 {
    public static void main(String[] args) {
        System.out.println(helper("AABABBA", 2));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, runningMaxFreq = 0, right = 0;
        while (right < s.length()){
            if(map.get(s.charAt(right)) != null){
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            if(((right - left + 1) - getMaxFrequency(map)) > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            if((right - left + 1) > maxLength){
                maxLength = right - left + 1;
            }
            right++;
        }
        return maxLength;
    }

    public static int getMaxFrequency(Map<Character, Integer> map){
        int maxFrequency = 0;
        for(Map.Entry<Character, Integer> set : map.entrySet()){
            if(set.getValue() > maxFrequency){
                maxFrequency = set.getValue();
            }
        }
        return maxFrequency;
    }

    public static int helper(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0, maxFrequency = 0, maxLength = 0;
        while (right < s.length()){
            if(map.get(s.charAt(right)) != null) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            maxFrequency = map.get(s.charAt(right)) > maxFrequency ? map.get(s.charAt(right)) : maxFrequency;
            if((right - left + 1) - maxFrequency > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            if((right - left + 1) - maxFrequency <= k){
                maxLength = right - left + 1;
            }
            right++;
        }
        return maxLength;
    }
}
