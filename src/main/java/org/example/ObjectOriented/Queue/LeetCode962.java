package org.example.ObjectOriented.Queue;

import java.util.Stack;

public class LeetCode962 {
    public static void main(String[] args) {
        int[] nums = {6,0,8,2,1,5};
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(stack.empty() || nums[i] < nums[stack.peek()]){
                stack.push(i);
            }
        }
        int ans = 0;
        for(int i=nums.length-1; i>=0; i--){
            while (!stack.empty() && nums[i] > nums[stack.peek()]){
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}
