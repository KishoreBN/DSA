package org.example.Search.BinarySearch;

import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,7,8,8,10};
        int target = 7;
//        System.out.println(Arrays.toString(searchRange(arr, target)));
        System.out.println(Arrays.toString(new int[]{firstOccurance(arr, target, true), firstOccurance(arr, target, false)}));
    }

    /*
        Solution one
    */
    static int[] searchRange(int[] nums, int target){
        if(nums.length == 0 || nums[0] > target || target > nums[nums.length - 1])
            return new int[]{-1, -1};
        int startIndex = 0, endIndex = nums.length - 1, mid;
        while(startIndex <= endIndex){
            mid = startIndex + (endIndex - startIndex)/2;
            if(nums[mid] == target){
                while(nums[startIndex] != target || nums[endIndex] != target){
                    if(nums[startIndex] != target)
                        startIndex++;
                    if(nums[endIndex] != target)
                        endIndex--;
                }
                return new int[]{startIndex, endIndex};
            } else if(nums[mid] > target)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return new int[]{-1, -1};
    }

    /*
        Solution two - Run Binary Search to find the first and last Occurance
    */
    static int firstOccurance(int[] arr, int target, boolean isFirstOccurance) {
        if (arr.length == 0 || target < arr[0] || target > arr[arr.length - 1])
            return -1;
        int startIndex = 0, endIndex = arr.length - 1, mid, ans = -1;
        while(startIndex <= endIndex){
            mid = startIndex + (endIndex - startIndex)/2;
            if(arr[mid] > target)
                endIndex = mid - 1;
            else if(arr[mid] < target)
                startIndex = mid + 1;
            else{
                ans = mid;
                if(isFirstOccurance){
                    endIndex = mid -1;
                } else{
                    startIndex = mid + 1;
                }
            }
        }
        return ans;
    }
}
