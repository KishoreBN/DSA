package org.example.ObjectOriented.Queue;

import java.util.Stack;

/**
 * UNABLE TO SOLVE
 */
public class LeetCode456 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1,4,0,-1,-2,-3,-1,-2}));
    }

    public static boolean find132pattern(int[] nums) {
        if(nums.length < 3)
            return false;
        int min = nums[0];
        for(int i=1; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] > min && nums[j] < nums[i])
                    return true;
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
