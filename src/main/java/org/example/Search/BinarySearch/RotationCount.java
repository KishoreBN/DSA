package org.example.Search.BinarySearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {19, 20, 21, 22, 2, 3, 6, 12, 15, 18};
        int pivotIndex = findPivot(arr);
        System.out.println("Number of times array rotated is : " + (pivotIndex + 1));
    }

    static int findPivot(int[] arr){
        int startIndex =0, lastIndex = arr.length - 1;
        while(startIndex <= lastIndex){
            int mid = startIndex + (lastIndex - startIndex)/2;
            if(mid < lastIndex && arr[mid] > arr[mid + 1])
                return mid;
            else if(mid > startIndex && arr[mid - 1] > arr[mid])
                return mid - 1;
            else if(arr[startIndex] < arr[mid])
                startIndex = mid + 1;
            else
                lastIndex = mid - 1;
        }
        return -1;
    }
}
