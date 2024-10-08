package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static  int numberOfSubstrings(String s) {
        int right = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', -1);
        map.put('b', -1);
        map.put('c', -1);
        while (right < s.length()){
            map.put(s.charAt(right), right);
            if(map.get('a') >=0 && map.get('b') >= 0 && map.get('c') >= 0){
                int min = Math.min(Math.min(map.get('a'), map.get('b')), map.get('c'));
                count += (min + 1);
            }
            right++;
        }
        return count;
    }
}
