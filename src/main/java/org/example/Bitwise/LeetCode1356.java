package org.example.Bitwise;

import java.util.Arrays;

public class LeetCode1356 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    static int[] sortByBits(int[] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<(arr.length - i - 1); j++){
                int countOne = Integer.bitCount(arr[j]);
                int countTwo = Integer.bitCount(arr[j+1]);
                if(countOne >= countTwo){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
