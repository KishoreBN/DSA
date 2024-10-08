package org.example;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{5,3,1,2,0})));
    }

    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1){
            return arr;
        }
        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] leftArr, int[] rightArr){
        int[] result = new int[leftArr.length + rightArr.length];
        int resultPointer = 0;
        int leftPointer = 0, rightPointer = 0;
        while(leftPointer < leftArr.length && rightPointer < rightArr.length){
            if(leftArr[leftPointer] < rightArr[rightPointer]){
                result[resultPointer] = leftArr[leftPointer];
                leftPointer++;
            } else {
                result[resultPointer] = rightArr[rightPointer];
                rightPointer++;
            }
            resultPointer++;
        }
        if(leftPointer < leftArr.length){
            while(leftPointer < leftArr.length) {
                result[resultPointer] = leftArr[leftPointer];
                leftPointer++;
                resultPointer++;
            }
        }
        if(rightPointer < rightArr.length){
            while(rightPointer < rightArr.length) {
                result[resultPointer] = rightArr[rightPointer];
                rightPointer++;
                resultPointer++;
            }
        }
        return result;
    }
}
