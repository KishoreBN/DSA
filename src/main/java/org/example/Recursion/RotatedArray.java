package org.example.Recursion;

public class RotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        System.out.println(search(nums,5));
    }

    static int search(int[] nums, int target){
        int start = 0, last = nums.length - 1;
        return helperSearch(nums, target, start, last);
    }

    static int helperSearch(int[] nums, int target, int start, int last){
        if(start > last)
            return -1;
        int mid = start + (last - start) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[start] <= nums[mid])
            if(nums[start] >= target && nums[mid] > target)
                return helperSearch(nums, target, start, mid - 1);
            else
                return helperSearch(nums, target, mid + 1, last);
        else if(nums[mid]< target && nums[last] >= target)
            return helperSearch(nums,target,mid+1, last);
        else
            return helperSearch(nums, target, start, mid - 1);

    }
}
