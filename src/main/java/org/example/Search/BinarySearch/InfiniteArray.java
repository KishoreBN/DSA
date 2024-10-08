package org.example.Search.BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(findRange(arr, 4));
    }

    static int findRange(int[] arr, int target){
        /*
        We will start the looking for the target in chunks, since we dont know
        the endpoint of an infinte array.
        We will check the size of the last element on chunk, if it is less, then
        do the binary search else double the size of the chunk.
        */
        int start =0, end =1;
        while(arr[end] < target){
            int temp = end + 1;
            end = end + (end - start + 1) * 2; //Double the chunk size;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int startIndex, int endIndex){
        int mid;
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
