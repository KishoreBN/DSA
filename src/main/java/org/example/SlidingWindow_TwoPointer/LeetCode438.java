package org.example.SlidingWindow_TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("aaaaaa", "aaa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(char c : p.toCharArray()){
            if(pMap.get(c) == null)
                pMap.put(c, 1);
            else
                pMap.put(c, pMap.get(c) + 1);
        }
        int right = 0, left = 0;
        while (right < s.length()){
            if(map.get(s.charAt(right)) == null)
                map.put(s.charAt(right), 1);
            else
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            if((right - left + 1) > p.length()){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            if(compareMap(pMap, map))
                result.add(left);
            right++;
        }
        return result;
    }

    public static boolean compareMap(HashMap<Character, Integer> a, HashMap<Character, Integer> b){
        for(Map.Entry<Character, Integer> set : a.entrySet()){
            if(b.get(set.getKey()) == null || b.get(set.getKey()) != set.getValue())
                return false;
        }
        return true;
    }
}
