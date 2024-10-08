package org.example.Search.BinarySearch;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        System.out.println(findPivot(nums));
    }

    /*
    Modified the pivot method to return the smallest element by finding the pivot and returning the
    smalled element.
     */
    static int findPivot(int[] nums){
        int startIndex = 0, lastIndex = nums.length-1;
        while(startIndex < lastIndex){
            int mid = startIndex + (lastIndex - startIndex) / 2;
            if(mid < lastIndex && nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(mid > startIndex && nums[mid] < nums[mid - 1])
                return nums[mid];
            else if(nums[startIndex] < nums[mid])
                startIndex = mid + 1;
            else
                lastIndex = mid - 1;
        }
        return nums[0];
    }
}
