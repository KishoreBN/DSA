package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode301 {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(")("));
    }

    static int max = 0;
    static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(s,"", result);
        return result;
    }

    static void helper(String unprocessed, String processed, List<String> result){
        if(unprocessed.isEmpty()){
            if(processed.length() >= max && !result.contains(processed) && isValidParenthesis(processed)){
                if(processed.length() > max){
                    result.clear();
                    result.add(processed);
                } else {
                    result.add(processed);
                }
                max = processed.length();
            }
            return;
        }
        if(unprocessed.charAt(0) != '(' && unprocessed.charAt(0) != ')'){
            helper(unprocessed.substring(1), processed + unprocessed.charAt(0), result);
        } else {
            helper(unprocessed.substring(1), processed + unprocessed.charAt(0), result);
            helper(unprocessed.substring(1), processed, result);
        }
    }

    static boolean isValidParenthesis(String str){
        int openingBracketsCount = 0;
        int closingBracketsCount = 0;
        for(int i=0; i<str.length(); i++){
            if(closingBracketsCount > openingBracketsCount){
                return false;
            }
            if(str.charAt(i) == '('){
                openingBracketsCount++;
            }
            if(str.charAt(i) == ')'){
                closingBracketsCount++;
            }
        }
        if(openingBracketsCount != closingBracketsCount){
            return false;
        }
        return true;
    }

    static void helper(String unprocessed, String processed, int last_i, int last_j){
        if(unprocessed.isEmpty()){

        }
    }
}
