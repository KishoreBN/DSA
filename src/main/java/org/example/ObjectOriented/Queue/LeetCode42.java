package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapOptimized(height));
    }

    /**
     * First identify the left and right greater number for an element
     * Amount of water an element can hold on top of it = Min(right greatest, left greatest) - height of the element.
     * amount = Math.min(leftGreatest, rightGreatest) - height[i];
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];
        int result = 0;
        for(int i=height.length - 1; i >= 0; i--){
            if(!rightStack.empty() && rightStack.peek() < height[i]) {
                while (!rightStack.empty() && rightStack.peek() <= height[i]) {
                    rightStack.pop();
                }
                rightStack.push(height[i]);
            }
            rightArr[i] = rightStack.empty() ? -1 : rightStack.peek();
            if(rightStack.empty()){
                rightStack.push(height[i]);
            }
        }
        for(int i=0; i < height.length ; i++){
            if(!leftStack.empty() && leftStack.peek() < height[i]) {
                while (!leftStack.empty() && leftStack.peek() <= height[i]) {
                    leftStack.pop();
                }
            }
            leftArr[i] = leftStack.empty() ? -1 : leftStack.peek();
            if(leftArr[i] != -1 && rightArr[i] != -1){
                result = result + (Math.min(rightArr[i], leftArr[i]) - height[i]);
            }
            if(leftStack.empty()){
                leftStack.push(height[i]);
            }
        }
        return result;
    }

    public static int trapOptimized(int[] height){
        int result = 0, leftMax = 0, rightMax = 0, leftPointer = 0, rightPointer = height.length - 1;
        while (leftPointer < rightPointer){
            if(height[leftPointer] < height[rightPointer]){
                if(height[leftPointer] < leftMax)
                    result += leftMax - height[leftPointer];
                if(height[leftPointer] > leftMax)
                    leftMax = height[leftPointer];
                leftPointer++;
            } else {
                if(height[rightPointer] < rightMax)
                    result += rightMax - height[rightPointer];
                if(height[rightPointer] > rightMax)
                    rightMax = height[rightPointer];
                rightPointer--;
            }
        }
        return result;
    }
}
