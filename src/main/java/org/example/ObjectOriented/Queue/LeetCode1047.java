package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(Long.parseLong(""));
    }

    public static String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.empty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
