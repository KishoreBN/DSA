package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,new ArrayList<>(), result);
        return result;
    }

    static void helper(String unprocessed, List<String> processed, List<List<String>> result){
        if(unprocessed.isEmpty()){
            result.add(new ArrayList<>(processed));
            return;
        }
        for(int i=1; i<=unprocessed.length(); i++){
            if(isPalindrome(unprocessed.substring(0,i))){
                processed.add(unprocessed.substring(0,i));
                helper(unprocessed.substring(i, unprocessed.length()), processed, result);
                processed.remove(processed.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s){
        int low = 0, high = s.length()-1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
