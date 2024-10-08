package org.example.ObjectOriented.Stack;

public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
