package org.example.Search.BinarySearch;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18, 19};
        int target = 15;
        System.out.println(floor(arr, target));
    }

    static int floor(int[] arr,int target){
        int startIndex = 0, endIndex = arr.length - 1, mid;
        while(startIndex<= endIndex){
            mid = startIndex + (endIndex - startIndex)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return endIndex;
    }
}
