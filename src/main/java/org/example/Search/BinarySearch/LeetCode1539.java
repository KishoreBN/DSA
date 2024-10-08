package org.example.Search.BinarySearch;

public class LeetCode1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 1));
    }

    static int findKthPositive(int[] arr, int k) {
        int start = 0, last = arr.length - 1;
        while(start <= last){
            int mid = start + (last - start) / 2;
            int missingCount = arr[mid] - (mid + 1);
            if(missingCount < k)
                start = mid + 1;
            else
                last = mid - 1;
        }
        return (k + last + 1);
    }
}
