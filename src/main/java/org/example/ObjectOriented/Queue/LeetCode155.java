package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode155 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(-2147483648);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());
    }
}
