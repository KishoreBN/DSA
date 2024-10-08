package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode84 {
    public static void main(String[] args) {
        int[] heights = {1,5,3,4,2};
        System.out.println(helper(heights));
    }

    public static int helper(int[] heights){
        int maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < heights.length){
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                maxArea = getMax(heights, stack, i, maxArea);
            }
            stack.push(i);
            i++;
        }
        while(!stack.empty()){
            maxArea = getMax(heights, stack, i, maxArea);
        }
        return maxArea;
    }

    public static int getMax(int[] heights, Stack<Integer> stack, int index, int maxArea){
        int area = 0;
        int ele = stack.pop();
        if(stack.empty()){
            area = heights[ele] * index;
        } else {
            area = heights[ele] * (index - 1 - stack.peek());
        }
        return Math.max(area, maxArea);
    }

}
