package org.example.Search.BinarySearch;

public class LeetCode852 {
    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int startIndex = 0, endIndex = arr.length - 1, mid = -1;
        while(startIndex < endIndex){
            mid = startIndex + (endIndex - startIndex) / 2;
            if(arr[mid + 1] > arr[mid])
                startIndex = mid + 1;
            else
                endIndex = mid - 1;
        }
        return mid;
    }
}
