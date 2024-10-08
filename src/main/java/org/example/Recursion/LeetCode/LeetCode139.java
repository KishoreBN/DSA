package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode139 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(wordBreak("aaaaaaaaaaaaa", wordDict));
    }

    static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,"",wordDict);
    }

    static boolean helper(String unprocessed, String processed, List<String> wordDict){
        if(unprocessed.isEmpty()){
            return true;
        }
        for(int i=0; i<wordDict.size(); i++){
            if(unprocessed.startsWith(wordDict.get(i))){
                if(helper(unprocessed.substring(wordDict.get(i).length(),
                        unprocessed.length()),
                        processed + wordDict.get(i), wordDict)){
                    return true;
                }
            }
        }
        return false;
    }
}
