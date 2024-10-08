package org.example.Search.BinarySearch;

public class LeetCode410 {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr, 2));
    }

    static int splitArray(int[] nums, int k) {
        int start =Integer.MIN_VALUE, end =0;
        //This will return the lower and upper bound values.
        for(int i: nums){
            end += i;
            start = Math.max(start, i);
        }
        while(start < end){
            int mid = start + (end - start) / 2;
            int sum = 0, pieces = 1;
            for(int i: nums){
                if(sum + i > mid){
                    sum = i;
                    pieces++;
                } else{
                    sum += i;
                }
            }
            if(pieces <= k){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; //both start and end will have same value.
    }
}
