package org.example.Search.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 9;
        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target){
        int startIndex = 0, endIndex = arr.length - 1, mid;
        while(startIndex <= endIndex){
            mid = startIndex + (endIndex -startIndex)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }
}
