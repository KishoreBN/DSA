package org.example.Search.BinarySearch;

public class LeetCode81 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,3,1};
        int target = 0;
        int pivotIndex = findPivot(nums);
        boolean leftRes = binarySearch(nums, target, 0, pivotIndex);
        if(leftRes){
            System.out.println(leftRes);
        } else {
            System.out.println(binarySearch(nums, target, pivotIndex + 1, nums.length - 1));
        }
    }

    static int findPivot(int[] nums){
        int startIndex =0, lastIndex = nums.length -1;
        while(startIndex < lastIndex){
            int mid = startIndex + (lastIndex - startIndex)/2;
            if(mid < lastIndex && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid > startIndex && nums[mid - 1] > nums[mid])
                return mid - 1;
            else if(nums[startIndex] == nums[mid] && nums[mid] == nums[lastIndex]){
                if(nums[startIndex] > nums[startIndex + 1])
                    return startIndex;
                startIndex++;
                if(nums[lastIndex] < nums[lastIndex - 1])
                    return lastIndex - 1;
                lastIndex--;
            }
            else if(nums[startIndex] < nums[mid] || (nums[startIndex] == nums[mid] && nums[startIndex] > nums[lastIndex]))
                startIndex = mid + 1;
            else
                lastIndex = mid - 1;
        }
        return -1;
    }

    static boolean binarySearch(int[] nums, int target, int startIndex, int lastIndex){
        while(startIndex <= lastIndex){
            int mid = startIndex + (lastIndex - startIndex)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                lastIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return false;
    }
}
