package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode1839 {
    public static void main(String[] args) {
        System.out.println(helper("aeeeiiiioooauuuaeiou"));
    }

    public static int longestBeautifulSubstring(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0, maxLen = 0;
        while (right < word.length()){
            char c = word.charAt(right);
            if(map.get(c) == null)
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
            if(map.size() == 5)
                maxLen = Math.max(maxLen, right - left + 1);
            if(right + 1 < word.length() && word.charAt(right + 1) < c){
                map.clear();
                left = right + 1;
            }
            right++;
        }
        return maxLen;
    }

    public static int helper(String word){
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == 'a'){
                for(int j=i; j<word.length(); j++){
                    char c = word.charAt(j);
                    map.put(c, 1);
                    if(map.size() == 5)
                        maxLen = Math.max(maxLen, j-i+1);
                    if(j+1<word.length() && word.charAt(j+1) < c) {
                        i = j;
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}
