package org.example.ObjectOriented.Queue;

import java.util.Stack;

class MyStack {

    Stack<Integer> stack;
    Stack<Integer> helper;
    public MyStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while(!stack.empty()){
            helper.push(stack.pop());
        }
        Integer element = helper.pop();
        while(!helper.empty()){
            stack.push(helper.pop());
        }
        return element;
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}
public class LeetCode225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
