package org.example.Search.BinarySearch;

public class Ceiling {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18, 19};
        int target = 1;
        System.out.println(ceiling(arr, target));
    }

    static int ceiling(int[] arr, int target){
        if(target > arr[arr.length - 1])
            return -1;
        int startIndex = 0, endIndex = arr.length - 1, mid;
        while(startIndex<=endIndex){
            mid = startIndex + (endIndex - startIndex) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return startIndex;
    }
}
