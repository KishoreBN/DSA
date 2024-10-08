package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode140 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(List.of("apple","pen","applepen","pine","pineapple"));
        System.out.println(wordBreak("pineapplepenapple", wordDict));
    }

    static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        helper(s, "", wordDict,result);
        return result;
    }

    static void helper(String unprocessed, String processed, List<String> wordDict, List<String> result){
        if(unprocessed.isEmpty()){
            result.add(processed);
            return;
        }
        for(String str : wordDict){
            if(unprocessed.startsWith(str)){
                helper(unprocessed.substring(str.length()), processed + str + " ", wordDict, result);
            }
        }
    }
}
