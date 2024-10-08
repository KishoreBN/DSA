package org.example.Sorting.BubbleSort.LeetCode;

import java.util.Arrays;

public class LeetCode1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for(int i : arr1){
            if(i > max)
                max = i;
        }
        int[] frequencyArr = new int[max+1];
        boolean[] visitedArr = new boolean[max+1];
        for(int i : arr1){
            frequencyArr[i]++;
        }
        int j = 0;
        for(int i : arr2){
            visitedArr[i] = true;
            while(frequencyArr[i] > 0){
                arr1[j] = i;
                j++;
                frequencyArr[i]--;
            }
        }
        for(int i=0; i<visitedArr.length; i++){
            if(visitedArr[i] != true){
                while(frequencyArr[i] > 0){
                    arr1[j] = i;
                    j++;
                    frequencyArr[i]--;
                }
            }
        }
        return arr1;
    }
}
