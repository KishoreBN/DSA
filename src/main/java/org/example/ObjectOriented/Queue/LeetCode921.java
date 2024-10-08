package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("(()))"));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' && !stack.empty() && (stack.peek() == '('))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.size();
    }
}
