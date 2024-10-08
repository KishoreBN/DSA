package org.example.Search.BinarySearch;

public class LeetCode1095 {
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        int target = 2;
        int peakIndex = peakIndexInMountainArray(arr);
        int leftResult = binarySearch(arr, target, 0, peakIndex);
        if(leftResult != -1)
            System.out.println(leftResult);
        else
            System.out.println(binarySearch(arr, target, peakIndex, arr.length - 1));
    }

    static int peakIndexInMountainArray(int[] arr){
        int startIndex = 0, lastIndex = arr.length - 1, mid = -1;
        while(startIndex < lastIndex){
            mid = startIndex + (lastIndex - startIndex) / 2;
            if(arr[mid] > arr[mid + 1])
                lastIndex = mid;
            else
                startIndex = mid + 1;
        }
        return startIndex;
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
