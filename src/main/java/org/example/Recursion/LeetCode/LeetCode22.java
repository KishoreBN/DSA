package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    static List<String> generateParenthesis(int n) {
        StringBuilder openingBrackets = new StringBuilder();
        StringBuilder closingBrackets = new StringBuilder();
        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            openingBrackets.append("(");
            closingBrackets.append(")");
        }
        helper(openingBrackets.toString(), closingBrackets.toString(), "", result);
        return result;
    }

    static void helper(String openingBrackets, String closingBrackets, String processed, List<String> result){
        if(openingBrackets.isEmpty()){
            processed += closingBrackets;
            result.add(processed);
            return;
        }
        helper(openingBrackets.substring(1), closingBrackets, processed + openingBrackets.charAt(0), result);
        if(openingBrackets.length() < closingBrackets.length())
            helper(openingBrackets, closingBrackets.substring(1), processed + closingBrackets.charAt(0), result);
    }
}
