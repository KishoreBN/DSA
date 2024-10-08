package org.example.Search.BinarySearch;

public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 3;
        int pivotIndex = findPivot(nums);
        if(pivotIndex == -1)
            System.out.println(binarySearch(nums, target, 0, nums.length - 1));
        int leftRes = binarySearch(nums, target, 0, pivotIndex);
        if(leftRes != -1)
            System.out.println(leftRes);
        else
            System.out.println(binarySearch(nums, target, pivotIndex + 1, nums.length - 1));
    }

    static int findPivot(int[] arr){
        int startIndex = 0, lastIndex = arr.length - 1, mid;
        while(startIndex <= lastIndex){
            mid = startIndex + (lastIndex - startIndex) /2;
            if(mid < lastIndex && arr[mid] > arr[mid + 1])
                return mid;
            else if(mid > startIndex && arr[mid] < arr[mid - 1])
                return mid - 1;
            else if(arr[mid] > arr[startIndex])
                startIndex = mid + 1;
            else
                lastIndex = mid - 1;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int startIndex, int lastIndex){
        boolean isAsc = arr[startIndex] < arr[lastIndex];
        while(startIndex <= lastIndex){
            int mid = startIndex + (lastIndex - startIndex)/2;
            if(arr[mid] == target)
                return mid;
            else {
                if(isAsc) {
                    if(arr[mid] > target)
                        lastIndex = mid - 1;
                    else
                        startIndex = mid + 1;
                } else {
                    if(arr[mid] > target)
                        startIndex = mid + 1;
                    else
                        lastIndex = mid - 1;
                }
            }
        }
        return -1;
    }
}
