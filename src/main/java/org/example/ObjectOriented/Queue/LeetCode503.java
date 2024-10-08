package org.example.ObjectOriented.Queue;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {
    public static void main(String[] args) {
        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElements(nums2)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=(nums.length * 2) - 1; i >= 0; i--){
            while(!stack.empty() && stack.peek() <= nums[i % nums.length]){
                stack.pop();
            }
            if(i < nums.length) {
                result[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(nums[i % nums.length]);
        }
        return result;
    }
}
