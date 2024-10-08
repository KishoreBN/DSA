package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode32 {
    public static void main(String[] args) {
        System.out.println(helper("(()"));
    }

    public static int max = Integer.MIN_VALUE;
    public static int longestValidParentheses(String s) {
        Stack<Character> brackets = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')' && !brackets.empty() && brackets.peek() == '('){
                brackets.pop();
                indexes.pop();
            } else {
                brackets.push(c);
                indexes.push(i);
            }
        }
        if(indexes.empty())
            return s.length();
        int prevIndex = s.length(), result = 0;
        while (!indexes.empty()){
            result = Math.max(result, prevIndex - indexes.peek() - 1);
            prevIndex = indexes.pop();
        }
        if(prevIndex > 0){
            result = Math.max(result, prevIndex - 0 - 1);
        }
        return result;
    }

    public static int helper(String s){
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            if(right > left){
                left = 0;
                right = 0;
            }
            if(s.charAt(i) == '(')
                left++;
            if(s.charAt(i) == ')')
                right++;
            if(left == right)
                max = Math.max(right * 2, max);
        }
        left = 0; right = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(left > right){
                left = 0;
                right = 0;
            }
            if(s.charAt(i) == '(')
                left++;
            if(s.charAt(i) == ')')
                right++;
            if(left == right)
                max = Math.max(right * 2, max);
        }
        return max;
    }

    public static int calculateMax(String s){
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            if(right > left){
                left = 0;
                right = 0;
            }
            if(s.charAt(i) == '(')
                left++;
            if(s.charAt(i) == ')')
                right++;
            if(left == right)
                max = Math.max(right * 2, max);
        }
        return max;
    }
}
