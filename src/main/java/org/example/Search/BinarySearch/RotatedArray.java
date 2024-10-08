package org.example.Search.BinarySearch;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(search(arr,1));
    }

    static int search(int[] nums, int target){
        int start = 0, last = nums.length - 1;
        while(start <= last){
            int mid = start + (last - start) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && nums[mid] > target)
                    last = mid - 1;
                else
                    start = mid + 1;
            } else if(target > nums[mid] && target <= nums[last])
                start = mid + 1;
            else
                last = mid - 1;
        }
        return -1;
    }
}
