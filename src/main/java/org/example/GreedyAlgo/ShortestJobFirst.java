package org.example.GreedyAlgo;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int[] nums = {4,3,7,1,2};
        System.out.println(shortestJobFirst(nums));
    }

    public static int shortestJobFirst(int[] nums){
        int waitingTime = 0, sum = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            waitingTime += nums[i-1];
            sum += waitingTime;
        }
        return sum/nums.length;
    }
}
