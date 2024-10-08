package org.example.GreedyAlgo;

import java.util.Arrays;

public class LeetCode455 {
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s){
        int right = 0, left = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (right < g.length && left < s.length){
            if(s[left] >= g[right]){
                right++;
                left++;
            } else {
                left++;
            }
        }
        return right;
    }
}
