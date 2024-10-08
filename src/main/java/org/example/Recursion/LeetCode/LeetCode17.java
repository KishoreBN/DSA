package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> letterCombinations(String digits) {
        String[] keySet = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        helper(digits,"", keySet, result);
        return result;
    }

    static void helper(String unprocessed, String processed, String[] keySet, List<String> result){
        if(unprocessed.isEmpty()){
            if(!processed.isEmpty())
                result.add(processed);
            return;
        }
        Integer num = unprocessed.charAt(0) - '0';
        String alphabets = keySet[num];
        for(char c : alphabets.toCharArray()){
            helper(unprocessed.substring(1), processed + c, keySet, result);
        }
    }

    static void helper2(String unprocessed, String processed, List<String> result){
        if(unprocessed.isEmpty()){
            if(!processed.isEmpty()){
                result.add(processed);
            }
            return;
        }
        int num = unprocessed.charAt(0) - '0';
        int start = (num - 2) * 3;
        int end = start + 3;
        for(int i = start; i < end; i++){
            char ch = (char)('a' + i);
            helper2(unprocessed.substring(1), processed + ch, result);
        }
    }
}
