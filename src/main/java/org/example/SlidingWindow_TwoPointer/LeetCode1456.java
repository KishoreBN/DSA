package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1456 {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiodef", 5));
    }

    public static int maxVowels(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0, maxLen = 0, count = 0;
        while (right < s.length()){
            if(map.get(s.charAt(right)) == null)
                map.put(s.charAt(right), 1);
            else
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            if((right - left + 1) > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            count = countVowels(map);
            if(count > (k/2))
                maxLen = Math.max(maxLen, count);
            right++;
        }
        return maxLen;
    }

    public static int countVowels(HashMap<Character, Integer> map){
        int sum = 0;
        for(Map.Entry<Character, Integer> set : map.entrySet()){
            sum += (set.getKey() == 'a' || set.getKey() == 'e'
            || set.getKey() == 'i' || set.getKey() == 'o' || set.getKey() == 'u') ? set.getValue() : 0;
        }
        return sum;
    }
}
