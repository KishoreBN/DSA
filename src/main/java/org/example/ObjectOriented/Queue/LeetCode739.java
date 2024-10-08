package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode739 {
    public static void main(String[] args) {
        int[] temperatures = {30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=temperatures.length - 1; i>=0; i--){
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            result[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public static int[] helper(int[] temperatures){
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for(int i=temperatures.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]){
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peekLast() - i;
            stack.offerLast(i);
        }
        return result;
    }
}
