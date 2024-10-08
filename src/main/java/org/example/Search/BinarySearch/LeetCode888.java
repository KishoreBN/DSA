package org.example.Search.BinarySearch;

import java.util.Arrays;

public class LeetCode888 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,17,14,1,16}, new int[]{26, 11})));
    }

    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        for(int i=0; i<aliceSizes.length; i++){
            aliceSum += aliceSizes[i];
        }
        for(int i=0; i<bobSizes.length; i++){
            bobSum += bobSizes[i];
        }
        int diff = Math.abs(aliceSum - bobSum) / 2;
        int[] iterator = aliceSum < bobSum ? aliceSizes : bobSizes;
        int[] searchIterator = aliceSum < bobSum ? bobSizes : aliceSizes;
        Arrays.sort(searchIterator);
        int index = 0;
        for(int i=0; i<iterator.length; i++){
            if(isValuePresentInArray(searchIterator, iterator[i] + diff))
                index = i;
        }
        int[] result = new int[2];
        result[0] = aliceSum < bobSum ? aliceSizes[index] : bobSizes[index] + diff;
        result[1] = aliceSum < bobSum ? aliceSizes[index] + diff : bobSizes[index];
        return result;
    }

    static boolean isValuePresentInArray(int[] arr, int target){
        int start = 0, last = arr.length - 1;
        while (start <= last){
            int mid = start + (last - start) / 2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                last = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
