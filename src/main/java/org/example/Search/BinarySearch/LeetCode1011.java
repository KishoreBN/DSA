package org.example.Search.BinarySearch;

public class LeetCode1011 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        int days = 4;
        int start = Integer.MAX_VALUE, end = 0, minValue = Integer.MIN_VALUE;
        /*
          To find the lower and upper bound.
        */
        for(int i=0; i<arr.length; i++){
            if(arr[i] < start)
                start = arr[i];
            if(arr[i] > minValue)
                minValue = arr[i];
            end += arr[i];
        }
        while(start < end) {
            int pieces = 1;
            int temp = 0;
            int mid = start + (end - start) / 2;
            for(int i=0; i<arr.length; i++){
                if(temp + arr[i] > mid){
                    pieces++;
//                    if(arr[i] > mid)
//                        pieces++;
                    temp = arr[i];
                } else{
                    temp += arr[i];
                }
            }
            if(pieces <= days && mid >= minValue)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(start);
    }
}
