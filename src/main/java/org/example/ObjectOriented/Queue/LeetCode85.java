package org.example.ObjectOriented.Queue;

import com.sun.jdi.connect.AttachingConnector;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','1'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        int totalMaxArea = 0;
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        prefixSum(matrix, prefixSum);
        for(int i=0; i<prefixSum.length; i++){
            totalMaxArea = Math.max(maximumHistogram(prefixSum[i]), totalMaxArea);
        }
        return totalMaxArea;
    }

    public static int maximumHistogram(int[] heights){
        int maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i<heights.length){
            while (!stack.empty() && heights[stack.peek()] > heights[i]){
                maxArea = getMaxArea(stack,heights, i, maxArea);
            }
            stack.push(i);
            i++;
        }
        while (!stack.empty()){
            maxArea = getMaxArea(stack, heights, i, maxArea);
        }
        return maxArea;
    }

    public static int getMaxArea(Stack<Integer> stack, int[] heights, int index, int maxArea){
        int area = 0;
        int ele = stack.pop();
        if(stack.empty()){
            area = heights[ele] * index;
        } else {
            area = heights[ele] * (index - stack.peek() - 1);
        }
        return Math.max(area, maxArea);
    }
    public static void prefixSum(char[][] matrix, int[][] prefixSum){
        for(int i=0; i<prefixSum.length; i++){
            for(int j=0; j<prefixSum[i].length; j++){
                if(matrix[i][j] == '1'  && i - 1 >= 0)
                    prefixSum[i][j] = prefixSum[i - 1][j] + 1;
                else
                    prefixSum[i][j] = Integer.parseInt(matrix[i][j]+"");
            }
        }
    }
}
