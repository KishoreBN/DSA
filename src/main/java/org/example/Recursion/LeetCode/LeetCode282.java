package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode282 {
    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }

    static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, "", 0, 0, 0, result, target);
        return result;
    }

    static void helper(String unprocessed, String processed, int index, long currResult, long previousNum, List<String> result, int target) {
        if(index == unprocessed.length()){
            if(target == currResult){
                result.add(processed);
            }
            return;
        }
        for(int i=index; i<unprocessed.length(); i++) {
            if(i>index && unprocessed.charAt(index) == '0') break;
            long num = Long.parseLong(unprocessed.substring(index, i + 1));
            if (index == 0) {
                helper(unprocessed, unprocessed.substring(index, i + 1), i + 1, num, num, result, target);
            } else {
                helper(unprocessed, processed + "+" + num, i + 1, currResult + num, num, result, target);
                helper(unprocessed, processed + "-" + num, i + 1, currResult - num, -num, result, target);
                helper(unprocessed, processed + "*" + num, i + 1, (currResult - previousNum + previousNum * num), previousNum * num, result, target);
            }
        }
    }
}
