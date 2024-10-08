package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("()()"));
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            str.append(s.charAt(i));
            if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            if(stack.empty()){
                result.append(str.substring(1, str.length() - 1));
                str.setLength(0);
            }
        }
        return result.toString();
    }

    public static String removeOuterParentheses2(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(stack.empty())
                stack.push(s.charAt(i));
            else if(s.charAt(i) == '('){
                result.append('(');
                stack.push(s.charAt(i));
            } else {
                if(!stack.empty()) {
                    result.append(')');
                    stack.pop();
                }
            }
        }
        return result.toString();
    }
}
