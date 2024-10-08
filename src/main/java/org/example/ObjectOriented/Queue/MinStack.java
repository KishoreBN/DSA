package org.example.ObjectOriented.Queue;

import java.util.Stack;

/**
 * Will work for positive values.
 * Uses O(1) space and time complexity.
 */
public class MinStack {
    Stack<Long> stack;
    Long min = Long.MAX_VALUE;

    MinStack(){
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.empty()){
            min = Long.valueOf(val);
            stack.push(Long.valueOf(val));
        } else {
            if (val < min) {
                long newVal = 2 * val - min;
                min = Long.valueOf(val);
                stack.push(newVal);
            } else {
                stack.push(Long.valueOf(val));
            }
        }
    }

    public void pop() {
        long val = stack.pop();
        if(val < min){
            min = 2*min - val;
        }
    }

    public int top() {
        return (stack.peek() < min) ? min.intValue() : stack.peek().intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}
