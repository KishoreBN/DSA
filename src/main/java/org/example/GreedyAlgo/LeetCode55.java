package org.example.GreedyAlgo;

public class LeetCode55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maxJump)
                return false;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }
}
