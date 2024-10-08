package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' || c == ']' || c == '}'){
                if(stack.empty() || (c == ')' && stack.peek() != '(')
                        || (c == ']' && stack.peek() != '[')
                        || (c == '}' && stack.peek() != '{'))
                    return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
