package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(Arrays.toString(previousSmallerElement(nums)));
    }

    public static int[] previousSmallerElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!stack.empty() && stack.peek() >= nums[i]){
                stack.pop();
            }
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
