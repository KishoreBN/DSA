package org.example.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LeetCode2260 {
    public static void main(String[] args) {
        int[] cards = {3,2,1,3,4,7};
        System.out.println(helper(cards));
    }

    public static int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0, minLen = Integer.MAX_VALUE;
        while (right < cards.length){
            int num = cards[right];
            if(map.get(num) == null)
                map.put(num, 1);
            else{
                map.put(num, map.get(num) + 1);
                while (map.get(num) > 1){
                    map.put(cards[left], map.get(cards[left]) - 1);
                    left++;
                }
                minLen = Math.min(minLen, right - left + 2);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static int helper(int[] cards){
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0, minLen = Integer.MAX_VALUE;
        while (right < cards.length){
            int num = cards[right];
            if(map.get(num) == null)
                map.put(num, right);
            else {
                minLen = Math.min(minLen, right - map.get(num) + 1);
                map.put(num, right);
            }
            right++;
        }
        return minLen;
    }
}
