package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode1541 {
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push('(');
            else {
                if(i+1 < s.length() && s.charAt(i+1) == ')')
                    i++;
                else
                    counter++;
                if(!stack.empty())
                    stack.pop();
                else
                    counter++;
            }
        }
        counter += 2 * stack.size();
        return counter;
    }
}
