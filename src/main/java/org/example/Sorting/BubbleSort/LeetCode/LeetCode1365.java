package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode1365 {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(i > max)
                max = i;
        }
        int[] frequencyArr = new int[max+1];
        for(int i : nums){
            frequencyArr[i]++;
        }
        int runningSum = 0;
        for(int i=0; i<frequencyArr.length; i++){
            int temp = frequencyArr[i];
            frequencyArr[i] = runningSum;
            runningSum = runningSum + temp;
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = frequencyArr[nums[i]];
        }
        return nums;
    }
}
