package org.example.Recursion.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1079 {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }

    static int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        helper(tiles, "", result);
        return result.size();
    }

    static void helper(String unprocessed, String processed, Set<String> result){
        if(unprocessed.isEmpty()){
            if(!processed.isEmpty()){
                permutation(result, processed, "");
                result.add(processed);
            }
            return;
        }
        char ch = unprocessed.charAt(0);
        helper(unprocessed.substring(1), processed, result);
        helper(unprocessed.substring(1), processed + ch, result);
    }

    static void permutation(Set<String> result, String unprocessed, String processed){
        if(unprocessed.isEmpty()){
            if(!processed.isEmpty()){
                result.add(processed);
                return;
            }
        }
        char ch = unprocessed.charAt(0);
        for(int i=0; i<=processed.length(); i++){
            String internal = processed.substring(0,i) + ch + processed.substring(i, processed.length());
            permutation(result, unprocessed.substring(1), internal);
        }
    }
}
