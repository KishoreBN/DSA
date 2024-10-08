package org.example.Search.BinarySearch;

import java.util.Arrays;

public class LeetCode167 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7};
        int target = 9;
        int nearestNum2;
        int nearestNum1 = nearestNumber(nums, target, 0, nums.length - 1);
        target = target - nums[nearestNum1];
        if(target <= 0){
            nearestNum2 = nearestNumber(nums, target, 0, nearestNum1 - 1);
        } else{
            nearestNum2 = nearestNumber(nums, target, 0, nearestNum1 - 1);
        }
        System.out.println((nearestNum2 + 1) + " " +(nearestNum1 + 1));
    }

    static int nearestNumber(int[] nums, int target, int startIndex, int lastIndex){
        int mid = 0;
        while(startIndex <= lastIndex){
            mid = startIndex + (lastIndex - startIndex) /2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                lastIndex = mid -1;
            else
                startIndex = mid + 1;
        }
        return lastIndex;
    }
}
