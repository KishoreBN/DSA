package org.example.GreedyAlgo;

public class LeetCode45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int right = 0, left = 0, minStep = 0;
        while (right < nums.length - 1){
            int farthest = 0;
            for(int i=left; i <= right; i++){
                farthest = Math.max(nums[i] + i, farthest);
            }
            left = right + 1;
            right = farthest;
            minStep++;
        }
        return minStep;
    }
}
